class Parent
{
	{
		System.out.println("Parent instance block 1");
	}
	static{
		System.out.println("Parent Static block 1");
	}
	Parent(){
		System.out.println("Parent Constructor");
	}
}
class Initializer extends Parent
{
	static int i=10;
	int a;
	{
		a=10;
		System.out.println("Instance initializer block 1");
		System.out.println("a = "+a);
	}
	static{
		System.out.println("Static block 1");
	}
	Initializer(){
		a=40;
		System.out.println("Default constructor");
		System.out.println("a = "+a);
	}
	static{
		System.out.println("Static block 2");
	}
	{
		a=20;
		System.out.println("Instance initializer block 2");
		System.out.println("a = "+a);
	}
	public static void main(String args[])
	{
		Initializer obj1=new Initializer();
		System.out.println("From Main method");
		//Initializer obj2=new Initializer();
	}
}