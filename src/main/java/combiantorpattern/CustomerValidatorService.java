package combiantorpattern;

import java.time.LocalDate;
import java.time.Period;

public class CustomerValidatorService {
    private boolean isEmailValid(String email){
        return email.contains("@");
    }
    private boolean isPhoneNumberValid(String number){
        return number.startsWith("+0");
    }
    private boolean isAdult(LocalDate dob){
        return Period.between(dob, LocalDate.now()).getYears() > 16;
    }

    public boolean isValid(Costumer costumen){
        return isEmailValid(costumen.getEmail())
                && isPhoneNumberValid(costumen.getPhoneNumber())
                && isAdult(costumen.getDob());
    }
}
