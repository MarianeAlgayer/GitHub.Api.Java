package com.exercise.github.api.services;

import com.exercise.github.api.dto.GitHubUserDto;
import com.exercise.github.api.dto.GitHubUserPageDto;
import com.exercise.github.api.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

  @Value("${github.client.url}")
  private String gitHubUrl;
  private final UsersRepository usersRepository;

  @Autowired
  public UsersService(UsersRepository usersRepository) {
    this.usersRepository = usersRepository;
  }

  public GitHubUserPageDto getUsers(int since) {

    var response = new GitHubUserPageDto();

    List<GitHubUserDto> users = usersRepository.getUsers(since);

    if (users.isEmpty()) return response;

    int lastId = users.get(users.size() - 1).id;

    response.users = users;
    response.next = gitHubUrl + "/api/users?since=" + lastId;

    return response;
  }
}
