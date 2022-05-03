package br.com.americanas.correlation.controller;

import br.com.americanas.correlation.controller.request.UserRequest;
import br.com.americanas.correlation.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity<String> save(@RequestBody UserRequest userRequest, UriComponentsBuilder uriBuilder) {
        log.info("Requisitado para salvar um usuário no banco");
        var user = service.save(userRequest);
        log.info("Usuário salvo com sucesso");


        URI uri = uriBuilder.path("/api/users/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(MDC.get("correlationId"));
    }
}
