package net.afa.model;

import net.afa.enumm.AccountStatus;
import net.afa.enumm.AccountType;

import java.util.Random;
import java.util.UUID;

public class BankAccount {
    private String accountID;
    private double balance;
    private String currency;
    private AccountType type;
    private AccountStatus status;

    public BankAccount( double balance, String currency, AccountType type, AccountStatus status) {
        this.accountID = UUID.randomUUID().toString();
        this.balance = balance;
        this.currency = currency;
        this.type = type;
        this.status = status;
    }

    public BankAccount() {
        this.accountID = UUID.randomUUID().toString();
    }


    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountID='" + accountID + '\'' +
                ", balance=" + balance +
                ", currency='" + currency + '\'' +
                ", type=" + type +
                ", status=" + status +
                '}';
    }


    public static class AccountBuilder{
        private BankAccount bankAccount=new BankAccount();
        public AccountBuilder accountID(String id){
            bankAccount.accountID=id;
            return this;
        }
        public AccountBuilder balance(double balance){
            bankAccount.balance=balance;
            return this;
        }
        public AccountBuilder balance(String currency){
            bankAccount.currency=currency;
            return this;
        }
        public AccountBuilder type(AccountType type){
            bankAccount.type=type;
            return this;
        }
        public AccountBuilder currency(String currency){
            bankAccount.currency=currency;
            return this;
        }
        public AccountBuilder status(AccountStatus status){
            bankAccount.status=status;
            return this;
        }
        public BankAccount build(){
            return this.bankAccount;
        }
    }

}
