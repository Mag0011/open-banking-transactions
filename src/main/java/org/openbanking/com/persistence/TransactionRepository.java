package org.openbanking.com.persistence;

import org.openbanking.com.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Override
    default List<Transaction> findAll() {
        return List.of();
    }

    @Override
    default List<Transaction> findAllById(Iterable<Long> transactions) {
        return List.of();
    }

    @Override
    default <S extends Transaction> S save(S entity) {
        return null;
    }

    @Override
    default void delete(Transaction entity) {

    }

    @Override
    default <S extends Transaction> S saveAndFlush(S entity) {
        return null;
    }

    List<Transaction> findTransactionByAccountNumber(long accountNumber);

}
