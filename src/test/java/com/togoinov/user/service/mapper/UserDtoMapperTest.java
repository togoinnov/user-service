package com.togoinov.user.service.mapper;

import com.togoinov.user.DefaultTestDataUtils;
import com.togoinov.user.domain.api.UserDto;
import com.togoinov.user.domain.entities.User;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class UserDtoMapperTest {

    @Test
    void testUserDto() {
        final var userAddress = DefaultTestDataUtils.createAddress();
        final var user = DefaultTestDataUtils.createUser();
        user.setAddresses(List.of(userAddress));

        UserDto userDto = UserDtoMapper.mapUserEntity(user);
        assertEquals("firstName", userDto.getFirstname());
    }

    @Test
    void testUser() {
        final var userAddressDto = DefaultTestDataUtils.createAddressDto();
        final var userDto = DefaultTestDataUtils.createUserDto();
        userDto.toBuilder().addressDtos(List.of(userAddressDto)).build();

        User user = UserDtoMapper.mapUserDto(userDto);
        assertEquals("lastname@mail.com", user.getEmail());
    }

}
