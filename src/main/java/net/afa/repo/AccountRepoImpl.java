package net.afa.repo;

import net.afa.enumm.AccountStatus;
import net.afa.enumm.AccountType;
import net.afa.model.BankAccount;
import net.afa.model.BankDirector;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AccountRepoImpl implements AccountRepo {
    private static final AccountRepoImpl accountRepo;
    static {
        System.out.println("Singleton instantiation ");
        accountRepo=new AccountRepoImpl();
    }
    private AccountRepoImpl(){}
    private Map<String, BankAccount> bankAccountMap=new HashMap<>();
    private long accountCount=0;
    @Override
    public BankAccount save(BankAccount bankAccount) {
        accountCount++;
        bankAccount.setAccountID(UUID.randomUUID().toString());
        bankAccountMap.put(bankAccount.getAccountID(),bankAccount);
        return bankAccount;
    }

    @Override
    public List<BankAccount> findAll() {
        return bankAccountMap.values().stream().toList();
    }

    @Override
    public Optional<BankAccount> findById(String id) {
        BankAccount bankAccount=bankAccountMap.get(id);

        return (bankAccount==null) ?Optional.empty() : Optional.of(bankAccount);


    }

    @Override
    public List<BankAccount> searchAccount(Predicate<BankAccount> predicate) {

        return bankAccountMap.values().stream().filter(predicate).collect(Collectors.toList());
    }

    @Override
    public BankAccount update(BankAccount account) {
        bankAccountMap.put(account.getAccountID(),account);
        return account;
    }

    @Override
    public void deleteById(String id) {
        bankAccountMap.remove(id);
    }

    public void populateDate(){
        for (int i = 0; i < 10; i++) {
            BankAccount bankAccount= BankDirector.accountBuilder()
                    .balance(100*Math.random()*900)
                    .type(Math.random()>0.5? AccountType.CURRENT_ACCOUNT:AccountType.SAVING_ACCOUNT)
                    .status(Math.random()>0.5? AccountStatus.ACTIVAED: AccountStatus.CREATED)
                    .currency(Math.random()>0.5?"MAD" : "EUR")
                    .build();
            save(bankAccount);
            System.out.println(Thread.currentThread().getName());
            System.out.println("Account count "+accountCount);
            System.out.println("size : "+bankAccountMap.values().size());
            System.out.println("**************************************");

        }
    }
    public static AccountRepoImpl getInstance(){
            return accountRepo;

    }
}
