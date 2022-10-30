package com.example.ShowMakerCode.Service.ServiceIplm;

import com.example.ShowMakerCode.Entity.Account;
import com.example.ShowMakerCode.Repository.AccountRepository;
import com.example.ShowMakerCode.Service.EntiryService.AccountService;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
@Service
public class AccountServiceIplm implements AccountService {
    AccountRepository accountRepository;

    public AccountServiceIplm(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public List<Account> findAllById(Iterable<Long> longs) {
        return accountRepository.findAllById(longs);
    }

    @Override
    public <S extends Account> S save(S entity) {
        return accountRepository.save(entity);
    }

    @Override
    public void delete(Account entity) {
        accountRepository.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {
        accountRepository.deleteAllById(longs);
    }

    @Override
    public <S extends Account> Optional<S> findOne(Example<S> example) {
        return accountRepository.findOne(example);
    }

    @Override
    public <S extends Account, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return accountRepository.findBy(example, queryFunction);
    }

    @Override
    @Query(value = "select o from Account o where o.username = ?1 and o.password = ?2", nativeQuery = false)
    public Account findByUsernameandPass(String username, String password) {
        return accountRepository.findByUsernameandPass(username, password);
    }

    @Override
    @Query(value = "select  o from Account o where o.email = ?1 and o.status = 1", nativeQuery = false)
    public Account findByEmail(String email) {
        return accountRepository.findByEmail(email);
    }

    @Override
    @Query("select  o from  Account o where o.status =1")
    public List<Account> getAllByActive() {
        return accountRepository.getAllByActive();
    }

    @Override
    @Query("select o from Account o where o.id =?1 and o.status = 1")
    public Account getAccountById(Long id) {
        return accountRepository.getAccountById(id);
    }

    @Override
    public <S extends Account> S saveAndFlush(S entity) {
        return accountRepository.saveAndFlush(entity);
    }
}
