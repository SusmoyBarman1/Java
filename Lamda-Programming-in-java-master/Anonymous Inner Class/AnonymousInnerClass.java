package Annonymous_Inner_Class;

public class AnonymousInnerClass {

	public static void main(String[] args) {
		
		//An anonymous inner class is that, which class is implemented inline and has no name of it.
		Greeting anonymousInnerClass = new Greeting() {
			public void perform() {
				System.out.println("Hello world");
			}
		};

		anonymousInnerClass.perform();
	}

}
