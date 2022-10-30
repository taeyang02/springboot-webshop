package com.example.ShowMakerCode.Repository;

import com.example.ShowMakerCode.Entity.Account;
import com.example.ShowMakerCode.Entity.AccountRole;
import com.example.ShowMakerCode.Entity.AccountRoleId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRoleRepository extends JpaRepository<AccountRole, AccountRoleId> {
 @Query(value ="select o from AccountRole  o where o.account = ?1" ,nativeQuery = false)
    AccountRole findByAccount(Account account);
}