package io.github.antsinmyey3sjohnson.jibdemo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class JibController {

    @GetMapping
    public ResponseEntity<GenericResponse> sayHello() {

        return ResponseEntity.ok(new GenericResponse("Hi, my Docker image was built using Google Jib!"));

    }

    @AllArgsConstructor
    @Getter
    private static class GenericResponse {

        private final String message;

    }

}
