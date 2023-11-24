package net.afa;


import net.afa.enumm.AccountType;
import net.afa.model.BankAccount;
import net.afa.repo.AccountRepoImpl;
import net.afa.util.JsonSerializer;

import javax.swing.*;
import java.io.IOException;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) throws IOException {
        JsonSerializer<BankAccount> bankAccountJsonSerializer=new JsonSerializer<>();
        AccountRepoImpl accountRepo= AccountRepoImpl.getInstance();
        accountRepo.populateDate();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
            }).start();
        }
        System.out.println("tap a character");
        System.in.read();//wssalt f vedio 1h53min

        List<BankAccount> bankAccounts=accountRepo.findAll();
        List<BankAccount> bankAccounts1 = accountRepo.searchAccount(bankAccount -> bankAccount.getType()
                .equals(AccountType.CURRENT_ACCOUNT));
        bankAccounts1.stream().map(bankAccountJsonSerializer::toJson)
                .forEach(System.out::println);
        //BankAccount bankAccount = accountRepo.findById("aaa").orElse(null);*/





    }

}