package combiantorpattern;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

public interface CustomerRegistrationValidator extends Function<Costumer, CustomerRegistrationValidator.ValidationResult> {

    static CustomerRegistrationValidator isEmailValid(){
        return customer -> customer.getEmail().contains("@")
                ?ValidationResult.SUCCES
                :ValidationResult.EMAIL_NOT_VALID;
    }
    static CustomerRegistrationValidator isPhoneValid(){
        return customer -> customer.getPhoneNumber().startsWith("+0")
                ?ValidationResult.SUCCES
                :ValidationResult.PHONE_NUMBER_NOT_VALID;
    }
    static CustomerRegistrationValidator isAnAduly(){
        return customer -> Period.between(customer.getDob(), LocalDate.now()).getYears() > 16
                ?ValidationResult.SUCCES
                :ValidationResult.IS_NOT_AN_ADULT;
    }

    default CustomerRegistrationValidator and (CustomerRegistrationValidator other){
        return customer -> {
            ValidationResult result = this.apply(customer);
            return result.equals(ValidationResult.SUCCES)
                    ?other.apply(customer)
                    :result;
        };
    }
    enum ValidationResult{
        SUCCES,
        PHONE_NUMBER_NOT_VALID,
        EMAIL_NOT_VALID,
        IS_NOT_AN_ADULT
    }
}
