package br.com.americanas.correlation.mapper;

import br.com.americanas.correlation.controller.request.UserRequest;
import br.com.americanas.correlation.controller.response.UserResponse;
import br.com.americanas.correlation.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.slf4j.MDC;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User toUser(UserRequest userRequest);

    UserResponse toUserResponse(User user, String correlationId);
}
