package com.example.App1.accounts.persistence;

import com.example.App1.accounts.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Account getUserInformationByAccountNumber(Long accountNumber);

    Account findByAccountNumber(Long accountNumber);
}
