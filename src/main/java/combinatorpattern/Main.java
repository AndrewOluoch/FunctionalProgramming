package combinatorpattern;

import java.time.LocalDate;

import static combinatorpattern.CustomerRegistrationValidator.*;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        Customer customer = new Customer(
                "Alice",
                 "alice@gmail.com",
                "0898787879878",
                LocalDate.of(2015,1,1)
        );

       // System.out.println(new CustomerValidatorService().isValid(customer));
        ValidationResult result = isEmailValid()
                .and(isPhoneNumberValid())
                .and(isAnAdult())
                .apply(customer);
        System.out.println(result);

        if (result != ValidationResult.SUCCESS){
            throw new IllegalAccessException(result.name());
        }
    }
}
