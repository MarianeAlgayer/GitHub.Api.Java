package com.exercise.github.api.controllers;

import com.exercise.github.api.dto.GitHubUserPageDto;
import com.exercise.github.api.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UsersController {

  private final UsersService usersService;

  @Autowired
  public UsersController(UsersService usersService) {
    this.usersService = usersService;
  }

  @GetMapping
  public GitHubUserPageDto getUsers(@RequestParam(value = "since", defaultValue = "0") int since) {
    return usersService.getUsers(since);
  }
}
