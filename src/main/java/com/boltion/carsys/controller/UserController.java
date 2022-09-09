package com.boltion.carsys.controller;

import com.boltion.carsys.dto.UserLoginDTO;
import com.boltion.carsys.services.FilesStorageService;
import com.boltion.carsys.services.UserService;
import com.boltion.carsys.util.StrandedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;

/**
 * @auther sachin
 * @date 2022-09-05
 */
@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService service;
    @Autowired
    private FilesStorageService storageService;

    @PostMapping
    public ResponseEntity registration(@RequestBody UserLoginDTO dto) {
        boolean registration = service.registration(dto);
        if (registration) {
            return new ResponseEntity(new StrandedResponse(true, "Registration Success.!",""), HttpStatus.OK);
        }
        return new ResponseEntity(new StrandedResponse(false, "Registration Fail.!",""), HttpStatus.OK);
    }

    @PostMapping(path = "/upload")
    public ResponseEntity uploadFiles(@RequestParam(value = "file[]") MultipartFile[] files, @RequestParam("nic") String id, HttpServletRequest request) {
        String rootPath = request.getSession().getServletContext().getRealPath("/");
        for (MultipartFile file : files) {
            storageService.save(file, id, rootPath);
        }
        return new ResponseEntity(new StrandedResponse(true, "Success.!",""), HttpStatus.OK);
    }

    @GetMapping(path = "/load")
    public ResponseEntity loadFiles(HttpServletRequest request) {
        String rootPath = request.getSession().getServletContext().getRealPath("/");
        String s = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
        System.out.println(s);
        storageService.load("153698572V", rootPath);

        return new ResponseEntity(new StrandedResponse(true, "Success.!",""), HttpStatus.OK);
    }

    @GetMapping(params = {"email", "password"})
    public ResponseEntity login(@RequestParam("email") String email, @RequestParam("password") String password) {
        UserLoginDTO userLoginDTO = service.userLogin(email, password);
        userLoginDTO.setPassword(null);
        return new ResponseEntity(new StrandedResponse(true, "Login Success.!", userLoginDTO), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity updateUser(@RequestBody UserLoginDTO dto) {
        boolean b = service.updateUserDetails(dto);
        if (b) {
            return new ResponseEntity(new StrandedResponse(true, "Update Success.!",""), HttpStatus.OK);
        }
        return new ResponseEntity(new StrandedResponse(false, "Update Fail.!",""), HttpStatus.OK);
    }

}
