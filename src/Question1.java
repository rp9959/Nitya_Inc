public class Question1 {
	
    public static class Variable{
        Variable a;
        Variable b;
        Variable c;
    }
    public static void main(String... args){
       Variable a = new Variable();
       Variable b = new Variable();
       b.c = new Variable();
       a.b = new Variable();
       a.b.c = b.c.a;
       System.out.println("Statement is succesfully executed");
    }
}
