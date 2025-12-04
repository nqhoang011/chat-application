package com.nqhoang011.chatapp.mapper;

import com.nqhoang011.chatapp.dto.request.UserCreateRequest;
import com.nqhoang011.chatapp.dto.request.UserUpdateRequest;
import com.nqhoang011.chatapp.dto.response.UserResponse;
import com.nqhoang011.chatapp.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    User toUser(UserCreateRequest request);

    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    void updateUser(@MappingTarget User user, UserUpdateRequest request);

    UserResponse toUserResponse(User user);
}
