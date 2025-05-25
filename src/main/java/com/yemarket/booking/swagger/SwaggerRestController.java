package com.yemarket.booking.swagger;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/test")
@Tag(name = "테스트 API", description = "Swagger 연결 테스트용 API")
public class SwaggerRestController{

    @Operation(summary = "Hello API", description = "간단한 Hello 반환 API입니다.")
    @GetMapping("/hello")
    public String hello() {
        return "Hello Swagger!";
    }
}
