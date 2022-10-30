package com.example.ShowMakerCode.Service.EntiryService;

import com.example.ShowMakerCode.Entity.Category;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public interface CategoryService {
    List<Category> findAll();

    List<Category> findAll(Sort sort);

    <S extends Category> S save(S entity);

    Optional<Category> findById(Long aLong);

    void deleteById(Long aLong);

    <S extends Category> Page<S> findAll(Example<S> example, Pageable pageable);

    <S extends Category, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);


    @Query(value = "select o from Category o where o.id = ?1", nativeQuery = false)
    Category cFindById(Long Id);

    <S extends Category> S saveAndFlush(S entity);
}
