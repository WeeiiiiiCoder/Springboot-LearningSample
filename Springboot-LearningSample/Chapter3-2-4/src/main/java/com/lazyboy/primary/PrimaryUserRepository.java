package com.lazyboy.primary;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PrimaryUserRepository extends JpaRepository<User, Long> {

}
