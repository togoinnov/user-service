package com.togoinov.user.domain.repository;

import com.togoinov.user.DefaultTestDataUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AddressRepository addressRepository;

    @BeforeEach
    void cleanup() {
        addressRepository.deleteAll();
        userRepository.deleteAll();
    }

    @Test
    void when_find_by_id_then_return() {
        final var address = DefaultTestDataUtils.createAddress();

        final var userAddress = this.addressRepository.save(address);

        final var user = DefaultTestDataUtils.createUser();
        user.setAddresses(List.of(userAddress));

        this.userRepository.save(user);
    }
}
