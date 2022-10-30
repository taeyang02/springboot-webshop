package com.example.ShowMakerCode.Service.ServiceIplm;

import com.example.ShowMakerCode.Entity.Role;
import com.example.ShowMakerCode.Repository.RoleRepository;
import com.example.ShowMakerCode.Service.EntiryService.RoleService;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
@Service
public class RoleServiceIplm implements RoleService {
    RoleRepository roleRepository;

    public RoleServiceIplm(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public List<Role> findAll(Sort sort) {
        return roleRepository.findAll(sort);
    }

    @Override
    public List<Role> findAllById(Iterable<Long> longs) {
        return roleRepository.findAllById(longs);
    }

    @Override
    public <S extends Role> List<S> saveAll(Iterable<S> entities) {
        return roleRepository.saveAll(entities);
    }

    @Override
    public void flush() {
        roleRepository.flush();
    }

    @Override
    public <S extends Role> S saveAndFlush(S entity) {
        return roleRepository.saveAndFlush(entity);
    }

    @Override
    public <S extends Role> List<S> saveAllAndFlush(Iterable<S> entities) {
        return roleRepository.saveAllAndFlush(entities);
    }

    @Override
    @Deprecated
    public void deleteInBatch(Iterable<Role> entities) {
        roleRepository.deleteInBatch(entities);
    }

    @Override
    public void deleteAllInBatch(Iterable<Role> entities) {
        roleRepository.deleteAllInBatch(entities);
    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {
        roleRepository.deleteAllByIdInBatch(longs);
    }

    @Override
    public void deleteAllInBatch() {
        roleRepository.deleteAllInBatch();
    }

    @Override
    @Deprecated
    public Role getOne(Long aLong) {
        return roleRepository.getOne(aLong);
    }

    @Override
    @Deprecated
    public Role getById(Long aLong) {
        return roleRepository.getById(aLong);
    }

    @Override
    public Role getReferenceById(Long aLong) {
        return roleRepository.getReferenceById(aLong);
    }

    @Override
    public <S extends Role> List<S> findAll(Example<S> example) {
        return roleRepository.findAll(example);
    }

    @Override
    public <S extends Role> List<S> findAll(Example<S> example, Sort sort) {
        return roleRepository.findAll(example, sort);
    }

    @Override
    public Page<Role> findAll(Pageable pageable) {
        return roleRepository.findAll(pageable);
    }

    @Override
    public <S extends Role> S save(S entity) {
        return roleRepository.save(entity);
    }

    @Override
    public Optional<Role> findById(Long aLong) {
        return roleRepository.findById(aLong);
    }

    @Override
    public boolean existsById(Long aLong) {
        return roleRepository.existsById(aLong);
    }

    @Override
    public long count() {
        return roleRepository.count();
    }

    @Override
    public void deleteById(Long aLong) {
        roleRepository.deleteById(aLong);
    }

    @Override
    public void delete(Role entity) {
        roleRepository.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {
        roleRepository.deleteAllById(longs);
    }

    @Override
    public void deleteAll(Iterable<? extends Role> entities) {
        roleRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        roleRepository.deleteAll();
    }

    @Override
    public <S extends Role> Optional<S> findOne(Example<S> example) {
        return roleRepository.findOne(example);
    }

    @Override
    public <S extends Role> Page<S> findAll(Example<S> example, Pageable pageable) {
        return roleRepository.findAll(example, pageable);
    }

    @Override
    public <S extends Role> long count(Example<S> example) {
        return roleRepository.count(example);
    }

    @Override
    public <S extends Role> boolean exists(Example<S> example) {
        return roleRepository.exists(example);
    }

    @Override
    public <S extends Role, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return roleRepository.findBy(example, queryFunction);
    }

    @Override
    @Query(value = "select o from Role o where o.name = ?1", nativeQuery = false)
    public Role findByNameRole(String UOA) {
        return roleRepository.findByNameRole(UOA);
    }
}
