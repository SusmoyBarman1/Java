package com.example.hello;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.HashMap;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileActivity extends AppCompatActivity
{
    private String receiverUserId, senderUserId, current_state;

    private CircleImageView UserProfileImage;
    private TextView UserProfileName, UserProfileStatus;
    private Button SendMessageRequestButton, DeclineMessageRequestButton;

    private DatabaseReference UserRef, ChatRequestRef, ContactsRef, NotificationRef;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        mAuth = FirebaseAuth.getInstance();

        UserRef = FirebaseDatabase.getInstance().getReference().child("Users");
        ChatRequestRef = FirebaseDatabase.getInstance().getReference().child("Chat Requests");
        ContactsRef = FirebaseDatabase.getInstance().getReference().child("Contacts");
        NotificationRef = FirebaseDatabase.getInstance().getReference().child("Notifications");


        receiverUserId = getIntent().getExtras().get("visit_user_id").toString();
        senderUserId = mAuth.getCurrentUser().getUid();

       // Toast.makeText(this, "User ID: "+receiverUserId, Toast.LENGTH_SHORT).show();

        UserProfileImage = (CircleImageView) findViewById(R.id.visit_profile_image);
        UserProfileName = ( TextView) findViewById(R.id.visit_user_name);
        UserProfileStatus = (TextView) findViewById(R.id.visit_profile_status);
        SendMessageRequestButton = (Button) findViewById(R.id.send_message_request_button);
        DeclineMessageRequestButton = (Button) findViewById(R.id.decline_message_request_button);
        current_state = "new";

        RetrieveUserInfo();
    }

    private void RetrieveUserInfo()
    {
        UserRef.child(receiverUserId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                if((dataSnapshot.exists()) && (dataSnapshot.hasChild("image")))
                {
                    String userImage = dataSnapshot.child("image").getValue().toString();
                    String userName = dataSnapshot.child("name").getValue().toString();
                    String userStatus = dataSnapshot.child("status").getValue().toString();

                    Picasso.get().load(userImage).placeholder(R.drawable.profile_image).into(UserProfileImage);

                    UserProfileName.setText(userName);
                    UserProfileStatus.setText(userStatus);

                    ManageChatRequest();
                }
                else
                {
                    String userName = dataSnapshot.child("name").getValue().toString();
                    String userStatus = dataSnapshot.child("status").getValue().toString();

                    UserProfileName.setText(userName);
                    UserProfileStatus.setText(userStatus);

                    ManageChatRequest();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {

            }
        });
    }

    private void ManageChatRequest()
    {
        ChatRequestRef.child(senderUserId)
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot)
                    {
                        if(dataSnapshot.hasChild(receiverUserId))
                        {
                            String request_type = dataSnapshot.child(receiverUserId)
                                    .child("request_type").getValue().toString();

                            if(request_type.equals("sent") )
                            {
                                current_state = "request_sent";
                                SendMessageRequestButton.setText("Cancel Chat Request");
                            }
                            else if(request_type.equals("received"))
                            {
                                current_state = "request_received";
                                SendMessageRequestButton.setText("Accept chat request");

                                DeclineMessageRequestButton.setVisibility(View.VISIBLE);
                                DeclineMessageRequestButton.setEnabled(true);

                                DeclineMessageRequestButton.setOnClickListener(new View.OnClickListener()
                                {
                                    @Override
                                    public void onClick(View v)
                                    {
                                        CancelChatRequest();
                                    }
                                });
                            }
                        }
                        else
                        {
                            ContactsRef.child(senderUserId)
                                    .addListenerForSingleValueEvent(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot)
                                        {
                                            if(dataSnapshot.hasChild(receiverUserId))
                                            {
                                                current_state = "friends";
                                                SendMessageRequestButton.setText("Remove This Contact");

                                            }
                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                        }
                                    });
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

        if(!senderUserId.equals(receiverUserId))
        {
            SendMessageRequestButton.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    SendMessageRequestButton.setEnabled(false);

                    if(current_state.equals("new"))
                    {
                        SendChatRequest();
                    }
                    if(current_state.equals("request_sent"))
                    {
                        CancelChatRequest();
                    }
                    if(current_state.equals("request_received"))
                    {
                        AcceptChatRequest();
                    }
                    if(current_state.equals("friends"))
                    {
                        RemoveSpecificContact();
                    }
                }
            });
        }
        else
        {
            SendMessageRequestButton.setVisibility(View.INVISIBLE);
        }
    }

    private void RemoveSpecificContact()
    {
        ContactsRef.child(senderUserId).child(receiverUserId)
                .removeValue()
                .addOnCompleteListener(new OnCompleteListener<Void>()
                {
                    @Override
                    public void onComplete(@NonNull Task<Void> task)
                    {
                        if(task.isSuccessful())
                        {
                            ContactsRef.child(receiverUserId).child(senderUserId)
                                    .removeValue()
                                    .addOnCompleteListener(new OnCompleteListener<Void>()
                                    {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task)
                                        {
                                            if(task.isSuccessful())
                                            {
                                                SendMessageRequestButton.setEnabled(true);
                                                current_state = "new";
                                                SendMessageRequestButton.setText("Send Message");

                                                DeclineMessageRequestButton.setVisibility(View.INVISIBLE);
                                                DeclineMessageRequestButton.setEnabled(false);
                                            }
                                        }
                                    });
                        }
                    }
                });
    }

    private void AcceptChatRequest()
    {
        ContactsRef.child(senderUserId).child(receiverUserId)
                .child("Contacts").setValue("Saved")
                .addOnCompleteListener(new OnCompleteListener<Void>()
                {
                    @Override
                    public void onComplete(@NonNull Task<Void> task)
                    {
                        if(task.isSuccessful())
                        {
                            ContactsRef.child(receiverUserId).child(senderUserId)
                                    .child("Contacts").setValue("Saved")
                                    .addOnCompleteListener(new OnCompleteListener<Void>()
                                    {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task)
                                        {
                                            if(task.isSuccessful())
                                            {
                                                ChatRequestRef.child(senderUserId).child(receiverUserId)
                                                        .removeValue()
                                                        .addOnCompleteListener(new OnCompleteListener<Void>()
                                                        {
                                                            @Override
                                                            public void onComplete(@NonNull Task<Void> task)
                                                            {
                                                                if(task.isSuccessful())
                                                                {
                                                                    ChatRequestRef.child(receiverUserId).child(senderUserId)
                                                                            .removeValue()
                                                                            .addOnCompleteListener(new OnCompleteListener<Void>()
                                                                            {
                                                                                @Override
                                                                                public void onComplete(@NonNull Task<Void> task)
                                                                                {
                                                                                    SendMessageRequestButton.setEnabled(true);
                                                                                    current_state = "friends";

                                                                                    SendMessageRequestButton.setText("Remove This Contact");

                                                                                    DeclineMessageRequestButton.setVisibility(View.INVISIBLE);
                                                                                    DeclineMessageRequestButton.setEnabled(false);
                                                                                }
                                                                            });
                                                                }
                                                            }
                                                        });
                                            }
                                        }
                                    });
                        }
                    }
                });
    }

    private void CancelChatRequest()
    {
        ChatRequestRef.child(senderUserId).child(receiverUserId)
                .removeValue()
                .addOnCompleteListener(new OnCompleteListener<Void>()
                {
                    @Override
                    public void onComplete(@NonNull Task<Void> task)
                    {
                        if(task.isSuccessful())
                        {
                            ChatRequestRef.child(receiverUserId).child(senderUserId)
                                    .removeValue()
                                    .addOnCompleteListener(new OnCompleteListener<Void>()
                                    {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task)
                                        {
                                            if(task.isSuccessful())
                                            {
                                                SendMessageRequestButton.setEnabled(true);
                                                current_state = "new";
                                                SendMessageRequestButton.setText("Send Message");

                                                DeclineMessageRequestButton.setVisibility(View.INVISIBLE);
                                                DeclineMessageRequestButton.setEnabled(false);
                                            }
                                        }
                                    });
                        }
                    }
                });
    }

    private void SendChatRequest()
    {
        //For sender
        ChatRequestRef.child(senderUserId).child(receiverUserId)
                .child("request_type").setValue("sent")
                .addOnCompleteListener(new OnCompleteListener<Void>()
                {
                    @Override
                    public void onComplete(@NonNull Task<Void> task)
                    {
                        if(task.isSuccessful())
                        {
                            //For Receiver

                            ChatRequestRef.child(receiverUserId).child(senderUserId)
                                    .child("request_type").setValue("received")
                                    .addOnCompleteListener(new OnCompleteListener<Void>()
                                    {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task)
                                        {
                                            if(task.isSuccessful())
                                            {
                                                HashMap<String,String> chatnotificationMap = new HashMap<>();
                                                chatnotificationMap.put("from", senderUserId);
                                                chatnotificationMap.put("type", "request");

                                                NotificationRef.child(receiverUserId).push()
                                                        .setValue(chatnotificationMap)
                                                        .addOnCompleteListener(new OnCompleteListener<Void>()
                                                        {
                                                            @Override
                                                            public void onComplete(@NonNull Task<Void> task)
                                                            {
                                                                if(task.isSuccessful())
                                                                {
                                                                    SendMessageRequestButton.setEnabled(true);
                                                                    current_state = "request_sent";
                                                                    SendMessageRequestButton.setText("Cancel Chat Request");
                                                                }
                                                            }
                                                        });
                                            }
                                        }
                                    });
                        }
                    }
                });
    }
}
