package com.cybersoft.baitapkhoa4.repository;

import com.cybersoft.baitapkhoa4.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
