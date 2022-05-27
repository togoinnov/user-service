package com.togoinov.user.domain.repository;

import com.togoinov.user.domain.entities.User;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface UserRepository extends PagingAndSortingRepository<User, UUID> {
}