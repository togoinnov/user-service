package com.togoinov.user.service.mapper;

import com.togoinov.user.api.AddressDto;
import com.togoinov.user.domain.entities.Address;
import lombok.NonNull;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class AddressDtoMapper {

    private AddressDtoMapper() {
        throw new IllegalStateException("Classe utilitaire");
    }

    public static @NonNull AddressDto mapEntity(@NonNull final Address address) {
        return AddressDto.builder()
                .id(address.getId())
                .street(address.getStreet())
                .houseNumber(address.getHouseNumber())
                .zipCode(address.getZipCode())
                .city(address.getCity())
                .land(address.getLand())
                .build();
    }

    public static List<AddressDto> mapEntities(@NonNull List<Address> addresses) {
        return addresses.stream()
                .map(AddressDtoMapper::mapEntity)
                .collect(Collectors.toList());
    }

    public static List<Address> mapDtos(@NonNull List<AddressDto> addressDtos) {
        return addressDtos.stream()
                .map(AddressDtoMapper::mapDto)
                .collect(Collectors.toList());
    }

    public static @NonNull Address mapDto(@NonNull final AddressDto addressDto) {
        return Address.builder()
                .id(addressDto.getId() == null ? UUID.randomUUID(): addressDto.getId())
                .street(addressDto.getStreet())
                .houseNumber(addressDto.getHouseNumber())
                .zipCode(addressDto.getZipCode())
                .city(addressDto.getCity())
                .land(addressDto.getLand())
                .build();
    }
}
