package ee.bcs.myApp.validation;

import ee.bcs.myApp.bank.domain.account.Account;
import ee.bcs.myApp.bank.domain.customer.Customer;
import ee.bcs.myApp.infrastructure.exception.BusinessException;
import ee.bcs.myApp.infrastructure.exception.DataNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ValidationService {


    public static final String ACCOUNT_NOT_EXISTS = "Sellist kontot ei eksisteeri";
    public static final String CUSTOMER_NOT_EXISTS = "Sellist klienti ei eksisteeri";
    public static final String DEPOSIT_OVER_LIMIT = "Deposiidi limiit on ületatud";
    public static final String WITHDRAW_OVER_LIMIT = "Raha väljavõtmise limiit on ületatud";
    public static final String INSUFFICIENT_FUNDS = "Kontol pole piisavalt vahendeid tehingu sooritamiseks";
    public static final String ISIKUKOOD_ALREADY_TAKEN = "Isikukood on juba kasutusel";

    public void accountExists(Integer accountId, Optional<Account> account) {
        if (account.isEmpty()) {
            throw new DataNotFoundException(ACCOUNT_NOT_EXISTS, "Kontot ID'ga " + accountId + " ei leitud");
        }
    }

    public void accountExists(String accountNumber, Optional<Account> account) {
        if (account.isEmpty()) {
            throw new DataNotFoundException(ACCOUNT_NOT_EXISTS, "Kontot kontonumbriga " + accountNumber + " ei leitud");
        }
    }

    public void isValidDepositAmount(Integer amount) {
        // productionsis tuleks see väärtus andmebaasist
        Integer limit = 5000;
        if (amount > limit) {
            throw new BusinessException(DEPOSIT_OVER_LIMIT, "Summa €" + amount + " ületab limiidi €" + limit);
        }
    }

    public void isValidWithdrawAmount(Integer amount) {
        // productionsis tuleks see väärtus andmebaasist
        Integer limit = 15000;
        if (amount > limit) {
            throw new BusinessException(WITHDRAW_OVER_LIMIT, "Summa €" + amount + " ületab limiidi €" + limit);
        }
    }

    public void isWithinBalance(Integer balance, Integer amount) {
        if (amount > balance) {
            throw new BusinessException(INSUFFICIENT_FUNDS, "Summa €" + amount + " ületab kontojääki €" + balance);
        }
    }

    public void customerExists(Integer customerId, Optional<Customer> customer) {
        if (customer.isEmpty()) {
            throw new DataNotFoundException(CUSTOMER_NOT_EXISTS, "Klienti ID'ga " + customerId + " ei leitud");
        }
    }

    public void isikukoodExists(boolean customerExists, String isikukood) {
        if (customerExists) {
            throw new BusinessException(ISIKUKOOD_ALREADY_TAKEN, "Isikukood " + isikukood + " on juba kasutusel");
        }
    }
}
