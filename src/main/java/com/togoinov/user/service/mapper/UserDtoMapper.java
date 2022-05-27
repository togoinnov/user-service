package com.togoinov.user.service.mapper;


import com.togoinov.user.domain.api.UserDto;
import com.togoinov.user.domain.entities.User;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserDtoMapper {

    private UserDtoMapper() {
        throw new IllegalStateException("Classe utilitaire");
    }

    public static @NonNull UserDto mapUserEntity(@NonNull final User user) {
        return UserDto.builder()
                .id(user.getId())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .dob(user.getDob())
                .sex(user.getSex())
                .email(user.getEmail())
                .avatar(user.getAvatar())
                .addressDtos(AddressDtoMapper.mapEntities(user.getAddresses()))
                .build();
    }

    public static @NonNull List<User> mapEntities(@NonNull List<UserDto> userDtos) {
        return userDtos.stream()
                .map(UserDtoMapper::mapUserDto)
                .collect(Collectors.toList());
    }

    public static @NonNull List<UserDto> mapDtos(@NonNull List<User> users) {
        return users.stream()
                .map(UserDtoMapper::mapUserEntity)
                .collect(Collectors.toList());
    }

    public static @NonNull User mapUserDto(@NonNull final UserDto userDto) {
        return User.builder()
                .id(userDto.getId())
                .firstname(userDto.getFirstname())
                .lastname(userDto.getLastname())
                .dob(userDto.getDob())
                .sex(userDto.getSex())
                .email(userDto.getEmail())
                .avatar(userDto.getAvatar())
                .addresses(
                        (userDto.getAddressDtos() == null) ? new ArrayList<>() :
                                AddressDtoMapper.mapDtos(userDto.getAddressDtos()))
                .build();
    }

    public static @NonNull User updateUser(@NonNull final User user, @NonNull final UserDto userDto) {
        user.setFirstname(userDto.getFirstname());
        user.setLastname(userDto.getLastname());
        user.setSex(userDto.getSex());
        user.setEmail(userDto.getEmail());
        user.setDob(userDto.getDob());
        user.setAddresses(userDto.getAddressDtos() == null ? new ArrayList<>() : AddressDtoMapper.mapDtos(userDto.getAddressDtos()));

        return user;
    }
}
