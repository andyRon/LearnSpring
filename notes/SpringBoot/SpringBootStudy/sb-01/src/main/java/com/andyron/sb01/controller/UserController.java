package com.andyron.sb01.controller;

import com.andyron.sb01.common.ResponseResult;
import com.andyron.sb01.entity.User;
import com.andyron.sb01.entity.param.UserParam;
import com.andyron.sb01.service.UserService;
import com.andyron.sb01.validation.AddValidationGroup;
import com.andyron.sb01.validation.EditValidationGroup;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author andyron
 **/
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("add")
    public ResponseResult<User> add(User user) {
        // ...

        return ResponseResult.success(user);
    }

    @GetMapping("get/{id}")
    public ResponseResult<User> get(Long userId) {
        return ResponseResult.success(new User());
    }


    /*
    {
        "userId": 1,
        "email": "",
        "cardNo": "",
        "nickName": "",
        "age": 123,
        "sex": 2,
        "address": {
                "city": "",
                "zipcode": ""
            }
        }

     */
    @PostMapping("add2")
    public ResponseEntity<String> add2(@Valid @RequestBody UserParam userParam, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<ObjectError> errors = bindingResult.getAllErrors();
            errors.forEach(p -> {
                FieldError fieldError = (FieldError) p;
                log.error("Invalid Parameter: object - {},field - {},errorMessage - {}",
                        fieldError.getObjectName(), fieldError.getField(), fieldError.getDefaultMessage());
            });
            return ResponseEntity.badRequest().body("invalid parameter");
        }
        return ResponseEntity.ok("success");
    }

    @PostMapping("add3")
    public ResponseEntity<UserParam> add3(@Validated(AddValidationGroup.class) @RequestBody UserParam userParam) {
        return ResponseEntity.ok(userParam);
    }


    @PostMapping("edit")
    public ResponseEntity<UserParam> edit(@Validated(EditValidationGroup.class) @RequestBody UserParam userParam) {
        return ResponseEntity.ok(userParam);
    }

}
