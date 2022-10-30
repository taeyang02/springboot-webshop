package com.example.ShowMakerCode.Service.EntiryService;

import com.example.ShowMakerCode.Entity.Account;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public interface AccountService {
    List<Account> findAll();

    List<Account> findAllById(Iterable<Long> longs);

    <S extends Account> S save(S entity);

    void delete(Account entity);

    void deleteAllById(Iterable<? extends Long> longs);

    <S extends Account> Optional<S> findOne(Example<S> example);

    <S extends Account, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);

    @Query(value = "select o from Account o where o.username = ?1 and o.password = ?2", nativeQuery = false)
    Account findByUsernameandPass(String username, String password);

    @Query(value = "select  o from Account o where o.email = ?1 and o.status = 1", nativeQuery = false)
    Account findByEmail(String email);

    @Query("select  o from  Account o where o.status =1")
    List<Account> getAllByActive();

    @Query("select o from Account o where o.id =?1 and o.status = 1")
    Account getAccountById(Long id);

    <S extends Account> S saveAndFlush(S entity);
}
