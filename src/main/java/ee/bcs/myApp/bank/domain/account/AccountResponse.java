package ee.bcs.myApp.bank.domain.account;

import lombok.Data;

@Data
public class AccountResponse {

    private Integer customerId;
    private Integer accountId;
    private String firstName;
    private String lastName;
    private String isikukood;
    private String accountNumber;
    private Integer balance;
    private Boolean locked;
}
