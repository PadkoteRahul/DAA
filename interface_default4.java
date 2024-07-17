interface IOne
{
  default int m1()
  {
    return 1;
  }
}

interface ITwo 
{
  default int m1()
  {
    return 2;
  }
}

class test implements IOne, ITwo
{   
  public int m2()
  {
    return 3;
  }
  public static void main(String[] args)
  {
    IOne obj = new test();
    System.out.println(obj.m1());
  }
}