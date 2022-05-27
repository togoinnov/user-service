package com.togoinov.user.service.mapper;

import com.togoinov.user.DefaultTestDataUtils;
import com.togoinov.user.domain.api.UserDto;
import com.togoinov.user.domain.entities.Address;
import com.togoinov.user.domain.entities.User;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class UserDtoMapperTest {

    @Test
    public void testUserDto() {
        final var userAddress = DefaultTestDataUtils.createAddress();
        final var user1 = DefaultTestDataUtils.createUser();
        final var user2 = DefaultTestDataUtils.createAnotherUser();
        user1.setAddresses(List.of(userAddress));
        user2.setAddresses(List.of(userAddress));

        UserDto userDto1 = UserDtoMapper.mapUserEntity(user1);
        UserDto userDto2 = UserDtoMapper.mapUserEntity(user2);
        assertEquals("firstName", userDto1.getFirstname());
        assertEquals("Jean", userDto2.getFirstname());
        assertNotEquals(userDto1.getFirstname(), userDto2.getFirstname());
        assertEquals("KOLIKO", userDto2.getLastname());
        // assertEquals(userDto1.getAddressDtos(), userDto2.getAddressDtos());

        // Ajout d'un nouveau test
    }

    @Test
    public void testUser() {
        final var userAddressDto = DefaultTestDataUtils.createAddressDto();
        final var userDto = DefaultTestDataUtils.createUserDto();
        userDto.toBuilder().addressDtos(List.of(userAddressDto)).build();

        User user = UserDtoMapper.mapUserDto(userDto);
        assertEquals("lastname@mail.com", user.getEmail());
    }

}
