package com.mmpharmacy.mmpharmacy.repo;

import com.mmpharmacy.mmpharmacy.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepoUser extends JpaRepository<User, Integer> {

    List<User> findAllByIsActive(String isActive);

//    User findUserByUser_id(int id);

}
