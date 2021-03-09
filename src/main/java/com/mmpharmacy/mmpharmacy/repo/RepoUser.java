package com.mmpharmacy.mmpharmacy.repo;

import com.mmpharmacy.mmpharmacy.entity.User;
import com.mmpharmacy.mmpharmacy.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoUser extends JpaRepository<User, Integer> {

    User findByEmail(String email);
}
