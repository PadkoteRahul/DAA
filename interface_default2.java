// Identify the errors in the interface definition
interface IOne
{
  default int add();
  default int add(int x)
  {
    return x;
  }
  default abstract int add(int x, int y)
  {
    return x + y;
  }
  public int add(int x, int y, int z)
  {
    return x + y + y;
  }
}

class test implements IOne
{   	  
  public int add() { return 10; }

  public static void main(String[] args)
  {
    test obj = new test();
    System.out.println(obj.add());
  }
}