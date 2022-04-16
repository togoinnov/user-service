package com.togoinov.user;

import com.togoinov.user.api.Sex;
import com.togoinov.user.domain.api.AddressDto;
import com.togoinov.user.domain.api.UserDto;
import com.togoinov.user.domain.entities.Address;
import com.togoinov.user.domain.entities.User;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.UUID;

public class DefaultTestDataUtils {

    public static User createUser(){
        return User.builder()
                .id(UUID.randomUUID())
                .firstname("firstName")
                .lastname("lastName")
                .dob(ZonedDateTime.of(1980, 5, 22, 16, 54, 0, 0, ZoneOffset.UTC).toLocalDateTime())
                .email("lastname@mail.com")
                .sex(Sex.LGBT)
                .avatar("avatar")
                .build();
    }

    public static UserDto createUserDto(){
        return UserDto.builder()
                .id(UUID.randomUUID())
                .firstname("firstName")
                .lastname("lastName")
                .dob(ZonedDateTime.of(1980, 5, 22, 16, 54, 0, 0, ZoneOffset.UTC).toLocalDateTime())
                .email("lastname@mail.com")
                .sex(Sex.LGBT)
                .avatar("avatar")
                .build();
    }

    public static Address createAddress() {
        return Address.builder()
                .id(UUID.randomUUID())
                .street("my street")
                .houseNumber("15")
                .zipCode("5432")
                .city("Lome")
                .land("Togo")
                .build();
    }

    public static AddressDto createAddressDto() {
        return AddressDto.builder()
                .id(UUID.randomUUID())
                .street("my street")
                .houseNumber("15")
                .zipCode("5432")
                .city("Lome")
                .land("Togo")
                .build();
    }

}
