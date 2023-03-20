package com.epam.example.mapper;

import com.epam.example.dto.User;
import com.epam.example.dto.UserResponseDto;
import java.util.List;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
    injectionStrategy = InjectionStrategy.CONSTRUCTOR,
    unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface UserToUserDtoResponseMapper {

  List<UserResponseDto> map(List<User> source);

  UserResponseDto map(User source);

}
