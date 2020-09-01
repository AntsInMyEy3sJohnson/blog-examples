package io.github.antsinmyey3sjohnson.multistagebuilds;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleRestController {

    @GetMapping("/")
    public ResponseEntity<GenericResponse> sayHello(@RequestParam(required = false, defaultValue = "") String name) {
        var message = new GenericResponse(name.isEmpty() ?
                "Hi there, stranger!" : String.format("Hello, %s!", name));
        return ResponseEntity.ok(message);

    }

    @AllArgsConstructor
    @Getter
    private static class GenericResponse {

        private final String message;

    }
}
