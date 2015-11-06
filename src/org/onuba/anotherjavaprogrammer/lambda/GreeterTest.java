package org.onuba.anotherjavaprogrammer.lambda;

public class GreeterTest {

    public static void main (String [] args) {
        
        final Runnable task = () -> {
            greeterClassic();
            greeterLambda();
        };
        
        task.run();
        
    }
    
    private static void greeterClassic() {
        
        final Greeter greeterClassic = new Greeter() {

            @Override
            public String saluda(String name) {
                return "Hello " + name;
            }
            
        };
        
        System.out.println(greeterClassic.saluda("Fran"));
    }
    
    private static void greeterLambda() {
        
        final Greeter greeterLambda = (name) -> {return "Hello " + name;};
        
        System.out.println(greeterLambda.saluda("FranLambda"));
    }
}
