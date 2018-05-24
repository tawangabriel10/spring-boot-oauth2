package br.com.diego.springplayground.apresentacao;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "usuario", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserRestController {

    @PreAuthorize("#oauth2.hasScope('read')")
    @GetMapping(value = "{id}")
    public ResponseEntity<Map<String, Long>> getUsuario(@PathVariable("id") Long id) {
        Map<String, Long> resposta = new HashMap<>();
        resposta.put("usuario", id);
        return new ResponseEntity<>(resposta, HttpStatus.OK);
    }

}
