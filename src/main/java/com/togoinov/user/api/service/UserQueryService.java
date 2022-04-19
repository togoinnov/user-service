package com.togoinov.user.api.service;

import com.togoinov.user.api.UserDto;
import com.togoinov.user.domain.entities.User;
import lombok.NonNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface UserQueryService {

    @NonNull List<User> findAllUsers();

    @NonNull Page<User> findAllUsersPaginated(Pageable pageable);

    UserDto getUserById(@NonNull UUID id);

    long countUsers();
}
