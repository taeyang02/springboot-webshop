package com.example.ShowMakerCode.Repository;

import com.example.ShowMakerCode.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    @Query(value = "select o from Account o where o.username = ?1 and o.password = ?2 and o.status=1",nativeQuery = false)
    Account findByUsernameandPass(String username , String password);

    @Query(value = "select  o from Account o where o.email = ?1 and o.status = 1",nativeQuery = false)
    Account findByEmail(String email);

    @Query(value = "select  o from  Account o where o.status =1")
    List<Account> getAllByActive();
    @Query(value = "select o from Account o where o.id =?1 and o.status = 1")
    Account getAccountById(Long id);

}