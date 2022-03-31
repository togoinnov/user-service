package com.togoinov.user.api.service;

import com.togoinov.user.domain.entities.User;
import lombok.NonNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserQueryService {

    @NonNull List<User> findAllUsers();

    @NonNull Page<User> findAllUsersPageable(Pageable pageable);

    @NonNull Optional<User> getUserById(@NonNull UUID id);
}
