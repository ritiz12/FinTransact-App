package com.example.App1.userDetails.persistence;

import com.example.App1.userDetails.domain.UserInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InformationRepository  extends JpaRepository<UserInformation , Long> {
    UserInformation getUserInformationByAccountNumber(Long accountNumber);
}
