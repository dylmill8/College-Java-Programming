class Sum
{
    static int add(int a)
    {
        return a+a;
    }
    static int add(int a, int b)
    {
        return a+b;
    }
    static double add(double a, double b)
    {
        return a+b;
    }
}
//Note: In this example, we are creating static methods
// so that we don’t need to create an instance for calling methods.
class TestOverloading2
{
    public static void main(String[] args)
    {
        System.out.println(Sum.add(10));
        System.out.println(Sum.add(17,13));
        System.out.println(Sum.add(10.4,10.6));
    }
}
