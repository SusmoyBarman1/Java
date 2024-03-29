package com.example.asus.voicecontrolledapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.speech.tts.TextToSpeech;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.format.DateUtils;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private TextToSpeech myTTL;
    // To recognize the speech, we will create a variable.
    private SpeechRecognizer mySpeechRecognizer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                intent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 1);
                mySpeechRecognizer.startListening(intent);
            }
        });
        initializeTextToSpeach();
        initializeSpeechRecognizer();
    }

    private void initializeSpeechRecognizer() {
        if(SpeechRecognizer.isRecognitionAvailable(this)){
            mySpeechRecognizer = SpeechRecognizer.createSpeechRecognizer(this);
            mySpeechRecognizer.setRecognitionListener(new RecognitionListener() {
                @Override
                public void onReadyForSpeech(Bundle params) {

                }

                @Override
                public void onBeginningOfSpeech() {

                }

                @Override
                public void onRmsChanged(float rmsdB) {

                }

                @Override
                public void onBufferReceived(byte[] buffer) {

                }

                @Override
                public void onEndOfSpeech() {

                }

                @Override
                public void onError(int error) {

                }

                @Override
                public void onResults(Bundle bundle) {
                    List<String> results = bundle.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
                    processResult(results.get(0));
                }

                @Override
                public void onPartialResults(Bundle partialResults) {

                }

                @Override
                public void onEvent(int eventType, Bundle params) {

                }
            });
        }
    }

    private void processResult(String command) {
        command = command.toLowerCase();

        //1st command: What is your name?
        //2nd command: What is the time?
        //3rd command: Open a browser
        if(command.indexOf("what") != -1){
            if(command.indexOf("your name") != -1){
                speak("My name is Monday");
            }
            if(command.indexOf("time") != -1){
                Date now = new Date();
                String time = DateUtils.formatDateTime(this,now.getTime(),DateUtils.FORMAT_SHOW_TIME);
                speak("The time is: "+ time);
            }
        }
        else if(command.indexOf("open") != -1){
            if(command.indexOf("browser") != -1){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/"));
                startActivity(intent);
            }
        }
    }

    private void initializeTextToSpeach() {
        //Initializing the constructor
        myTTL = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(myTTL.getEngines().size() == 0)
                {
                    //Checking whether your device has the TTS engine or not.
                    Toast.makeText(MainActivity.this,"There is no TTS engine on your device!"
                            ,Toast.LENGTH_SHORT).show();
                    finish();
                }
                else{
                    //Setting the language to US English.
                    myTTL.setLanguage(Locale.US);
                    //Say something
                    speak("Hello! I am ready.");
                }
            }
        });
    }

    private void speak(String message) {
        //Checking the API level
        if(Build.VERSION.SDK_INT >= 21){
            //If it is same or higher than 21, than it will expect 4 arguments.
            // last two argument is not necessary for this application.
            myTTL.speak(message, TextToSpeech.QUEUE_FLUSH,null,null );
        }
        else{
            //If the API level is lower than 21, it will take 3 arguments.
            myTTL.speak(message,TextToSpeech.QUEUE_FLUSH,null);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPause() {
        //After use, this will shut the app down.
        super.onPause();
        myTTL.shutdown();
    }
}
