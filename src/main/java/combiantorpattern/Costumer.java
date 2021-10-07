package combiantorpattern;

import java.time.LocalDate;

public class Costumer {
    private final String name;
    private final String email;
    private final String phoneNumber;
    private final LocalDate dob;

    public Costumer(String name, String email, String phoneNumber, LocalDate dob) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public LocalDate getDob() {
        return dob;
    }
}
