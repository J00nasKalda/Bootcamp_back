package ee.bcs.myApp.bank.domain.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.Nullable;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Integer> {
    @Query("select a from Account a where upper(a.customer.lastName) = upper(?1) order by a.accountNumber")
    List<Account> findByLastName(String lastName);

    @Query("select a from Account a where upper(a.accountNumber) = upper(?1)")
    Optional<Account> findByAccountNumber(String accountNumber);

    @Query("select (count(a) > 0) from Account a where upper(a.accountNumber) = upper(?1)")
    boolean existsByAccountNumber(String accountNumber);

    @Query("select a from Account a where a.customer.id = ?1 order by a.accountNumber")
    List<Account> findByCustomerId(Integer id);



    
    


    
    
  

    
    
}