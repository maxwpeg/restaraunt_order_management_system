//package com.komarov.restaraunt_order_management_system.mappers;
//
//import com.komarov.restaraunt_order_management_system.api.dto.User;
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//import org.mapstruct.MappingConstants;
//
//import java.util.Set;
//import java.util.stream.Collectors;
//
//@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
//public interface UserDbModelToMealDtoMapper {
//
//    default Set<com.komarov.restaraunt_order_management_system.data.enums.Role> map(Set<com.komarov.restaraunt_order_management_system.data.enums.Role> roles) {
//        return roles.stream()
//                .map(role -> com.komarov.restaraunt_order_management_system.data.enums.Role.valueOf(role.name()))
//                .collect(Collectors.toSet());
//    }
//    User map (com.komarov.restaraunt_order_management_system.data.User user);
//
//}
