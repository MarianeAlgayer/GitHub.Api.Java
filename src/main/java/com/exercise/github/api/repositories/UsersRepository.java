package com.exercise.github.api.repositories;

import com.exercise.github.api.dto.GitHubUserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "github", url = "${github.client.url}")
public interface UsersRepository {

  @GetMapping("/users")
  List<GitHubUserDto> getUsers(@RequestParam("since") int since);
}
