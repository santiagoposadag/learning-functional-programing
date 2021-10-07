package optionals;

import java.util.Optional;

public class _Optional {
    public static void main(String[] args) {
        Optional.ofNullable(null)
                .ifPresentOrElse(value -> System.out.printf("Sending email to %s", value),
                        ()-> System.out.println("Cant send email"));
    }
}
