package com.example.ShowMakerCode.Service.EntiryService;

import com.example.ShowMakerCode.Entity.Account;
import com.example.ShowMakerCode.Entity.AccountRole;
import com.example.ShowMakerCode.Entity.AccountRoleId;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AccountRoleService {
    List<AccountRole> findAll();

    List<AccountRole> findAll(Sort sort);

    List<AccountRole> findAllById(Iterable<AccountRoleId> accountRoleIds);

    <S extends AccountRole> List<S> saveAll(Iterable<S> entities);

    <S extends AccountRole> List<S> findAll(Example<S> example, Sort sort);

    <S extends AccountRole> S save(S entity);

    Optional<AccountRole> findById(AccountRoleId accountRoleId);

    void deleteById(AccountRoleId accountRoleId);

    void deleteAllById(Iterable<? extends AccountRoleId> accountRoleIds);

    <S extends AccountRole> Optional<S> findOne(Example<S> example);

    <S extends AccountRole> Page<S> findAll(Example<S> example, Pageable pageable);


    @Query(value = "select o from AccountRole  o where o.account = ?1", nativeQuery = false)
    AccountRole findByAccount(Account account);
}
