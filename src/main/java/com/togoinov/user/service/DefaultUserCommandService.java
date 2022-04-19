package com.togoinov.user.service;

import com.togoinov.user.api.UserDto;
import com.togoinov.user.api.service.UserCommandService;
import com.togoinov.user.common.StructuredArgs;
import com.togoinov.user.domain.repository.AddressRepository;
import com.togoinov.user.domain.repository.UserRepository;
import com.togoinov.user.service.exception.ResourceNotFoundException;
import com.togoinov.user.service.mapper.AddressDtoMapper;
import com.togoinov.user.service.mapper.UserDtoMapper;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static com.togoinov.user.common.LogConstants.LOG_FORMAT_2;

@RequiredArgsConstructor
@Slf4j
@Service
public class DefaultUserCommandService implements UserCommandService {

    @NonNull
    private final UserRepository userRepository;

    @NonNull
    private final AddressRepository addressRepository;

    @Override
    public @NonNull UserDto create(@NonNull UserDto userDto) {
        if (userDto.getId() != null) {
            log.info(
                    LOG_FORMAT_2,
                    "User already exists",
                    StructuredArgs.userDto(userDto)
            );
            return userDto;
        }
        userDto.toBuilder().id(UUID.randomUUID());
        log.info(
                LOG_FORMAT_2,
                "Creating a new User",
                StructuredArgs.userDto(userDto)
        );
        final var addresses = userDto.getAddressDtos() != null ? AddressDtoMapper.mapDtos(userDto.getAddressDtos()) : null;
        if (addresses != null) {
            this.addressRepository.saveAll(addresses);
        }
         final var newUser = UserDtoMapper.mapUserDto(userDto);
//
         final var savedUser = this.userRepository.save(newUser);

        return UserDtoMapper.mapUserEntity(savedUser);
    }

    @Override
    public void delete(@NonNull UUID id) {
        final var optionalUser = this.userRepository.findById(id);
        if (optionalUser.isPresent()) {
            final var existingUser = optionalUser.get();
            log.info(
                    LOG_FORMAT_2,
                    "Deleting User",
                    StructuredArgs.user(existingUser)
            );
            this.userRepository.delete(existingUser);
        }
    }

    @Override
    public @NonNull UserDto update(@NonNull UserDto userDto) {
        final var id = userDto.getId();
        assert id != null;
        log.info(
                LOG_FORMAT_2,
                "Updating User",
                StructuredArgs.userDto(userDto)
        );

        final var userToUpdate = this.userRepository.findById(id)
                .map(user -> UserDtoMapper.updateUser(user, userDto))
                .orElseThrow(() -> new ResourceNotFoundException(id));

        final var updatedUser = this.userRepository.save(userToUpdate);
        return UserDtoMapper.mapUserEntity(updatedUser);
    }
}
