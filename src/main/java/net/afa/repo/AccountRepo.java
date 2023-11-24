package net.afa.repo;

import net.afa.model.BankAccount;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public interface AccountRepo {
        BankAccount save(BankAccount bankAccount);
        List<BankAccount> findAll();
      Optional<BankAccount>  findById(String id);
      List<BankAccount> searchAccount(Predicate<BankAccount> predicate);
      BankAccount update(BankAccount account);
      void deleteById(String id);

}
