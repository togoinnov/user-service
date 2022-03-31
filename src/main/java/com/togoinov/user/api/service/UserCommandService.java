package com.togoinov.user.api.service;

import com.togoinov.user.api.UserDto;
import lombok.NonNull;

import java.util.UUID;

public interface UserCommandService {

    @NonNull UserDto create(@NonNull UserDto userDto);

   void delete(@NonNull UUID id);

    @NonNull UserDto update(@NonNull UserDto userDto);
}
