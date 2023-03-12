package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import org.springframework.data.repository.query.Param;

import com.example.demo.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query("SELECT u FROM User u where u.email = :email")
	public User findUserByEmail(String email);
	
	@Query("SELECT u FROM User u WHERE u.username = :username")
	public User findUserByUsername(String username);
	
	@Query("SELECT u FROM User u WHERE u.verificationCode = ?1")
    public User findByVerificationCode(String code);
	
	@Query("SELECT u FROM User u WHERE u.resetPasswordToken = ?1")
	public User findUserByResetPasswordToken(String token);

    @Query(value = "SELECT s FROM User s WHERE s.username LIKE '%' || :keyword || '%'"
			+ " OR s.email LIKE '%' || :keyword || '%'"
			+ " OR s.username LIKE '%' || :keyword || '%'"
			)
	public List<User> search(@Param("keyword") String keyword);
}
