package functionalinterface;

import java.util.function.Function;

public class _Function {

    public static void main(String[] args) {
        int increment = incrementByOne(1);
        System.out.println("increment = " + increment);

        Integer increment2 = incrementByOneFunction.apply(1);
        System.out.println("increment2 = " + increment2);

        Integer added1AndThenMultipliedBy10 = incrementByOneFunction.andThen(multiplyBy10Function).apply(2);
        System.out.println("Function composition");
        System.out.println("added1AndThenMultipliedBy10 = " + added1AndThenMultipliedBy10);


    }
    static Function<Integer, Integer> multiplyBy10Function = number -> number*10;
    
    static Function<Integer, Integer> incrementByOneFunction = number -> number + 1;
    
    static int incrementByOne(int number){
        return number + 1 ;
    }
}
