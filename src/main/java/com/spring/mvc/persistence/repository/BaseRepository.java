package com.spring.mvc.persistence.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * Our base repository implementation -
 * provides methods from CrudRepository, PagingAndSortingRepository and JpaRepository.
 * Does not provide standard delete methods as we want to deactivate instead.
 * Uses Java8 Optional for findOne
 *
 * Examples for defining custom methods in base repositories here:
 * http://docs.spring.io/spring-data/jpa/docs/1.9.4.RELEASE/reference/html/#repositories
 */
@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable> extends Repository<T, ID> {
  /**
   * @see org.springframework.data.jpa.repository.JpaRepository#findAll()
   * @return
   */
  List<T> findAll();

  /**
   * @see org.springframework.data.jpa.repository.JpaRepository#findAll(Sort)
   * @return
   */
  List<T> findAll(Sort sort);

  /**
   * @see org.springframework.data.jpa.repository.JpaRepository#findAll(Iterable)
   * @return
   */
  Iterable<T> findAll(Iterable<ID> ids);

  /**
   * @see org.springframework.data.repository.PagingAndSortingRepository#findAll(Pageable)
   * @param var1
   * @return
   */
  Page<T> findAll(Pageable var1);

  /**
   * @see org.springframework.data.jpa.repository.JpaRepository#save(Iterable)
   * @return
   */
  <S extends T> List<S> save(Iterable<S> var1);

  /**
   * Saves an entity and flushes changes instantly.
   *
   * @param entity
   * @return the saved entity
   */
  <S extends T> S saveAndFlush(S entity);

  /**
   * @see org.springframework.data.repository.CrudRepository#save(Object)
   *
   * @param var1
   * @param <S>
   * @return
   */
  <S extends T> S save(S var1);

  /**
   * Flushes all pending changes to the database
   */
  void flush();

  /**
   * Returns a reference to the entity with the given identifier.
   * @see org.springframework.data.jpa.repository.JpaRepository#getOne(Serializable)
   *
   * @param id must not be {@literal null}.
   * @return a reference to the entity with the given identifier.
   */
  T getOne(ID id);

  /**
   * Returns Optional.empty() instead of null in case no unique element
   * satisfying the query can be found
   *
   * @param var1
   * @return
   */
  Optional<T> findOne(ID var1);

  /**
   * @see org.springframework.data.repository.CrudRepository#exists(Serializable)
   *
   * @param var1
   * @return
   */
  boolean exists(ID var1);
}
