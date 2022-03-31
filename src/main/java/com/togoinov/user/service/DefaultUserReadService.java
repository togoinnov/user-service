package com.togoinov.user.service;

import com.togoinov.user.api.service.UserQueryService;
import com.togoinov.user.domain.entities.User;
import com.togoinov.user.domain.repository.UserRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
@Service
public class DefaultUserReadService implements UserQueryService {

    @NonNull
    private final UserRepository userRepository;

    @Override
    public @NonNull List<User> findAllUsers() {
        return (List<User>) this.userRepository.findAll();
    }

    @Override
    public Page<User> findAllUsersPageable(Pageable pageable) {
        return this.userRepository.findAll(pageable);
    }

    @Override
    public Optional<User> getUserById(@NonNull UUID id) {
        return this.userRepository.findById(id);
    }
}
