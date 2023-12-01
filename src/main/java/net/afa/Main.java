package net.afa;


import net.afa.enumm.AccountStatus;
import net.afa.enumm.AccountType;
import net.afa.model.BankAccount;
import net.afa.model.Customer;
import net.afa.repo.AccountRepoImpl;
import net.afa.util.JsonSerializer;

import javax.swing.*;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) throws IOException, CloneNotSupportedException {
        JsonSerializer<BankAccount> bankAccountJsonSerializer=new JsonSerializer<>();
        AccountRepoImpl accountRepo= AccountRepoImpl.getInstance();
       // accountRepo.populateDate();

        BankAccount account=new BankAccount();
        account.setAccountID(UUID.randomUUID().toString());
        account.setBalance(1233);
        account.setCurrency("MAD");
        account.setType(AccountType.SAVING_ACCOUNT);
        account.setStatus(AccountStatus.SUSPENDED);
        Customer customer=new Customer(1L,"fatima");
        account.setCustomer(customer);
        BankAccount account1=account.clone();
        account.setCustomer(new Customer(2L,"afa"));
        System.out.println("acc1 = "+account);
        System.out.println("acc2 = "+account1);
        /*
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                accountRepo.populateDate();
            }).start();
        }
        System.out.println("tap a character");
        System.in.read();

        List<BankAccount> bankAccounts=accountRepo.findAll();
        List<BankAccount> bankAccounts1 = accountRepo.searchAccount(bankAccount -> bankAccount.getType()
                .equals(AccountType.CURRENT_ACCOUNT));
        bankAccounts1.stream().map(bankAccountJsonSerializer::toJson)
                .forEach(System.out::println);
        //BankAccount bankAccount = accountRepo.findById("aaa").orElse(null);*/





    }

}