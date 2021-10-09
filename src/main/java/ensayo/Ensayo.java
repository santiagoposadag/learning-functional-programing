package ensayo;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ensayo {
    public static void main(String[] args) {
        System.out.println(IntStream.range(2, 3).reduce((a,b)-> a = a+b).getAsInt());
    }
}
