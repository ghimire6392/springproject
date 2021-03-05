package com.biswas.springjanweb.webservice.user.controller;

import com.biswas.springjanweb.user.entity.User;
import com.biswas.springjanweb.user.service.UserService;
import com.biswas.springjanweb.webservice.core.dto.ResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(UserRestController.URI)
@AllArgsConstructor
public class UserRestController {

    final static String URI = "/v1/api/user";

    private final UserService userService;

    @GetMapping("/all")
    public ResponseEntity<?> getUsers() {
        ResponseDto responseDto = new ResponseDto();
        try {
            responseDto.setStatus(true);
            responseDto.setMessage("successfully retrieve User data");
            responseDto.setData(userService.finaAll());
        } catch (Exception e) {
            responseDto.setStatus(false);
            responseDto.setMessage("failed to retrieve User data");
        }

        return ResponseEntity.ok(responseDto);

    }
}
