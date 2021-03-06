package ee.bcs.myApp.bank.service.transfer;

import ee.bcs.myApp.bank.domain.account.Account;
import ee.bcs.myApp.bank.domain.account.AccountService;
import ee.bcs.myApp.bank.domain.transaction.Transaction;
import ee.bcs.myApp.bank.domain.transaction.TransactionService;
import ee.bcs.myApp.bank.service.DepositRequest;
import ee.bcs.myApp.bank.service.WithdrawRequest;
import ee.bcs.myApp.validation.ValidationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TransferService {

    @Resource
    private AccountService accountService;

    @Resource
    private TransactionService transactionService;

    @Resource
    private ValidationService validationService;

    public void deposit(DepositRequest request) {
        validationService.isValidDepositAmount(request.getAmount());
        Transaction transaction = transactionService.addDepositTransaction(request);
        accountService.updateCreditPaymentBalance(transaction.getAccount(), request.getAmount());
    }

    public void withdraw(WithdrawRequest request) {
        validationService.isValidWithdrawAmount(request.getAmount());
        Transaction transaction = transactionService.addWithdrawTransaction(request);
        accountService.updateDebitPaymentBalance(transaction.getAccount(), request.getAmount());
    }

    public TransferResponse receiveMoney(TransferRequest request) {
        Transaction transaction = transactionService.addReceiveMoneyTransaction(request);
        accountService.updateCreditPaymentBalance(transaction.getAccount(), request.getAmount());        
        return new TransferResponse(transaction.getId());
    }

    public TransferResponse sendMoney(SendRequest request) {
        Integer senderAccountId = request.getSenderAccountId();
        Account account = accountService.getValidAccountById(senderAccountId);
        TransferRequest transferRequest = new TransferRequest();
        transferRequest.setSenderAccountNumber(account.getAccountNumber());
        transferRequest.setReceiverAccountNumber(request.getReceiverAccountNumber());
        transferRequest.setAmount(request.getAmount());
        Transaction transaction = transactionService.addSendMoneyTransaction(transferRequest);
        return new TransferResponse(transaction.getId());
    }
}
