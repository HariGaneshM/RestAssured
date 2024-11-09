package inheritance;

public class ClassC extends ClassB {
	
	public static void ingerit() {
		
		Method1();
		Method2();
		Method3();
		Method4();
	}
	
	public static void main(String[] args) {
		
		String s = "Hello";
		
		char[] charArr = s.toCharArray();
		char[] newcharArr = new char[charArr.length];
		
		for (int i=0; i<charArr.length; i++) {
			
			newcharArr[i] = charArr[(charArr.length-i-1)];
		}
		System.out.println(newcharArr);
	}
}
