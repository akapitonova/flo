package com.kap.flowershop.back.mapping;

import com.kap.flowershop.back.entity.Users;
import com.kap.flowershop.front.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    @Mapping(target = "firstName", source = "user.userProperties.firstName")
    @Mapping(target = "lastName", source = "user.userProperties.lastName")
    @Mapping(target = "customerPhone", source = "user.userProperties.customerPhone")
    @Mapping(target = "shippingAddress", source = "user.userProperties.shippingAddress")
    @Mapping(target = "balance", source = "user.userProperties.balance")
    @Mapping(target = "discount", source = "user.userProperties.discount")
    UserDto entityToDto(Users user);

    @Mapping(source = "firstName", target = "userProperties.firstName")
    @Mapping(source = "lastName", target = "userProperties.lastName")
    @Mapping(source = "customerPhone", target = "userProperties.customerPhone")
    @Mapping(source = "shippingAddress", target = "userProperties.shippingAddress")
    @Mapping(source = "balance", target = "userProperties.balance")
    @Mapping(source = "discount", target = "userProperties.discount")
    Users dtoToEntity(UserDto user);

    List<UserDto> toListDto(List<Users> list);
}
