package ee.bcs.myApp.bank.account;

import ee.bcs.myApp.bank.customer.CustomerDto;
import lombok.Data;

import java.io.Serializable;

@Data
public class AccountDto1 implements Serializable {
    private final Integer id;
    private final CustomerDto customer;
    private final String accountNumber;
    private final Integer balance;
    private final Boolean locked;
}