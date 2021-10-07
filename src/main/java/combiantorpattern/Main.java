package combiantorpattern;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Costumer customer = new Costumer(
                "Alice",
                "Alice@gmail.com",
                "+09856965462",
                LocalDate.of(2015, 1, 1)
        );



        //System.out.println(new CustomerValidatorService().isValid(customer));

        //After validating the customer we can now store it in a DB

        //Using combinator pattern
        CustomerRegistrationValidator.ValidationResult result = CustomerRegistrationValidator
                .isEmailValid()
                .and(CustomerRegistrationValidator.isPhoneValid())
                .and(CustomerRegistrationValidator.isAnAduly())
                .apply(customer);

        System.out.println(result);

        if (result != CustomerRegistrationValidator.ValidationResult.SUCCES){
            throw new IllegalArgumentException(result.name());
        }

    }
}
