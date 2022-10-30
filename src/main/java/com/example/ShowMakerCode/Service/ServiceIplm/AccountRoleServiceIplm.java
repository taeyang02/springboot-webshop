package com.example.ShowMakerCode.Service.ServiceIplm;

import com.example.ShowMakerCode.Entity.Account;
import com.example.ShowMakerCode.Entity.AccountRole;
import com.example.ShowMakerCode.Entity.AccountRoleId;
import com.example.ShowMakerCode.Repository.AccountRoleRepository;
import com.example.ShowMakerCode.Service.EntiryService.AccountRoleService;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AccountRoleServiceIplm implements AccountRoleService {
    AccountRoleRepository accountRoleRepository;

    public AccountRoleServiceIplm(AccountRoleRepository accountRoleRepository) {
        this.accountRoleRepository = accountRoleRepository;
    }

    @Override
    public List<AccountRole> findAll() {
        return accountRoleRepository.findAll();
    }

    @Override
    public List<AccountRole> findAll(Sort sort) {
        return accountRoleRepository.findAll(sort);
    }

    @Override
    public List<AccountRole> findAllById(Iterable<AccountRoleId> accountRoleIds) {
        return accountRoleRepository.findAllById(accountRoleIds);
    }

    @Override
    public <S extends AccountRole> List<S> saveAll(Iterable<S> entities) {
        return accountRoleRepository.saveAll(entities);
    }

    @Override
    public <S extends AccountRole> List<S> findAll(Example<S> example, Sort sort) {
        return accountRoleRepository.findAll(example, sort);
    }

    @Override
    public <S extends AccountRole> S save(S entity) {
        return accountRoleRepository.save(entity);
    }

    @Override
    public Optional<AccountRole> findById(AccountRoleId accountRoleId) {
        return accountRoleRepository.findById(accountRoleId);
    }

    @Override
    public void deleteById(AccountRoleId accountRoleId) {
        accountRoleRepository.deleteById(accountRoleId);
    }

    @Override
    public void deleteAllById(Iterable<? extends AccountRoleId> accountRoleIds) {
        accountRoleRepository.deleteAllById(accountRoleIds);
    }

    @Override
    public <S extends AccountRole> Optional<S> findOne(Example<S> example) {
        return accountRoleRepository.findOne(example);
    }

    @Override
    public <S extends AccountRole> Page<S> findAll(Example<S> example, Pageable pageable) {
        return accountRoleRepository.findAll(example, pageable);
    }

    @Override
    @Query(value = "select o from AccountRole  o where o.account = ?1", nativeQuery = false)
    public AccountRole findByAccount(Account account) {
        return accountRoleRepository.findByAccount(account);
    }
}
