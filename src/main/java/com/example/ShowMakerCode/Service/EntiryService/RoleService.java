package com.example.ShowMakerCode.Service.EntiryService;

import com.example.ShowMakerCode.Entity.Role;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public interface RoleService {
    List<Role> findAll();

    List<Role> findAll(Sort sort);

    List<Role> findAllById(Iterable<Long> longs);

    <S extends Role> List<S> saveAll(Iterable<S> entities);

    void flush();

    <S extends Role> S saveAndFlush(S entity);

    <S extends Role> List<S> saveAllAndFlush(Iterable<S> entities);

    @Deprecated
    void deleteInBatch(Iterable<Role> entities);

    void deleteAllInBatch(Iterable<Role> entities);

    void deleteAllByIdInBatch(Iterable<Long> longs);

    void deleteAllInBatch();

    @Deprecated
    Role getOne(Long aLong);

    @Deprecated
    Role getById(Long aLong);

    Role getReferenceById(Long aLong);

    <S extends Role> List<S> findAll(Example<S> example);

    <S extends Role> List<S> findAll(Example<S> example, Sort sort);

    Page<Role> findAll(Pageable pageable);

    <S extends Role> S save(S entity);

    Optional<Role> findById(Long aLong);

    boolean existsById(Long aLong);

    long count();

    void deleteById(Long aLong);

    void delete(Role entity);

    void deleteAllById(Iterable<? extends Long> longs);

    void deleteAll(Iterable<? extends Role> entities);

    void deleteAll();

    <S extends Role> Optional<S> findOne(Example<S> example);

    <S extends Role> Page<S> findAll(Example<S> example, Pageable pageable);

    <S extends Role> long count(Example<S> example);

    <S extends Role> boolean exists(Example<S> example);

    <S extends Role, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);

    @Query(value = "select o from Role o where o.name = ?1", nativeQuery = false)
    Role findByNameRole(String UOA);
}
