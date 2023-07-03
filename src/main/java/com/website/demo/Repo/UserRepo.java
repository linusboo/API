package com.website.demo.Repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.website.demo.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
}
