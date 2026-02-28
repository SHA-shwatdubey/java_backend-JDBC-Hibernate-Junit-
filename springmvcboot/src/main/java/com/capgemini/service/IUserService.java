package com.capgemini.service;

import com.capgemini.dto.UserDTO;

import java.util.List;

public interface IUserService {

    List<UserDTO> getAllUsers();

    UserDTO getUserById(Long id);

    UserDTO createUser(UserDTO userDTO);

    UserDTO updateUser(Long id, UserDTO userDTO);

    void deleteUser(Long id);

    UserDTO getUserByUsername(String username);

    boolean userExists(Long id);
}

