package ryu.assign.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ryu.assign.database.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
}
