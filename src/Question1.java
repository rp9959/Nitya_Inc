public class Question1 {
	
    public static class Class1{
    	Class2 b;

		public Class1(Class2 b) {
			super();
			this.b = b;
		}
    }
    
    public static class Class2{
    	int c;

		public Class2(int c) {
			super();
			this.c = c;
		}
 
    }
    
    public static class Class3{
        Class4 c;

		public Class3(Class4 c) {
			super();
			this.c = c;
		}
        
    }

    public static class Class4{
   int a;
   public Class4(int a) {
	super();
	this.a = a;
}

    }
    
    public static void main(String [] args){
    Class1 a = new Class1(new Class2(23));
      Class3 b = new Class3(new Class4(43));
        a.b.c = b.c.a;
        System.out.println("The statement is succesfully used");
        
    }
}
