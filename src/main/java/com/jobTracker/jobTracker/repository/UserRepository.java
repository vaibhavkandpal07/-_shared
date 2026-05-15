package com.jobTracker.jobTracker.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.jobTracker.jobTracker.model.User;



@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
