package net.afa.model;

public class BankDirector {
    public static BankAccount.AccountBuilder accountBuilder() {
        return new BankAccount.AccountBuilder();
    }

}
