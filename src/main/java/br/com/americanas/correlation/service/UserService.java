package br.com.americanas.correlation.service;

import br.com.americanas.correlation.controller.request.UserRequest;
import br.com.americanas.correlation.entity.User;
import br.com.americanas.correlation.mapper.UserMapper;
import br.com.americanas.correlation.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository repository;

    public User save(UserRequest userRequest) {
        log.info("Chamada ao repositório para salvar usuário");
        return repository.save(UserMapper.INSTANCE.toUser(userRequest));
    }
}
