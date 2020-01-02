package com.lazyboy.secondary;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SecondaryUserRepository extends JpaRepository<User, Long> {

}
