package com.freddans.popcorn.services;

import com.freddans.popcorn.entities.User;
import com.freddans.popcorn.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private PasswordEncoder passwordEncoder;
    private UserRepository userRepository;


    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User findUserById(long id) {
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isPresent()) {

            return optionalUser.get();
        } else {
            return null;
        }
    }

    public User findUserByUsername(String username) {
        Optional<User> optionalUser = userRepository.findByUsername(username);

        if (optionalUser.isPresent()) {

            return optionalUser.get();
        } else {

            return null;
        }
    }

    public User createUser(User newUserInfo) {
        System.out.println("check if user exist");
        User existingUser = findUserByUsername(newUserInfo.getUsername());

        if (existingUser == null) {

            if (newUserInfo.getUsername() != null && !newUserInfo.getUsername().isEmpty() && newUserInfo.getPassword() != null && !newUserInfo.getPassword().isEmpty()) {

                if (newUserInfo.getRoles() != null && !newUserInfo.getRoles().isEmpty()) {
                    newUserInfo.setRoles(newUserInfo.getRoles().toUpperCase());

                    if (newUserInfo.getRoles().equals("USER") || newUserInfo.getRoles().equals("ADMIN")) {

                        newUserInfo.setPassword(passwordEncoder.encode(newUserInfo.getPassword()));

                        User newUser = new User(newUserInfo.getUsername(), newUserInfo.getPassword(), newUserInfo.getRoles());

                        userRepository.save(newUser);

                        return newUser;
                    } else {
                        System.out.println("getroles does not equal to neither user nor admin");
                        return null;
                    }

                } else {

                    newUserInfo.setPassword(passwordEncoder.encode(newUserInfo.getPassword()));

                    User newUser = new User(newUserInfo.getUsername(), newUserInfo.getPassword());
                    newUser.setRoles("USER");

                    userRepository.save(newUser);

                    return newUser;
                }


            } else {
                System.out.println("username is null or empty, or with password");
                return null;
            }
        } else {

            // Username already exist
            System.out.println("username exist");
            return null;
        }
    }

    public User updateUser(long id, User updatedUserInfo) {
        User existingUser = findUserById(id);

        if (existingUser == null) {
            return null;
        }

        // Update username if provided and not empty
        if (updatedUserInfo.getUsername() != null && !updatedUserInfo.getUsername().isEmpty() &&
                !updatedUserInfo.getUsername().equals(existingUser.getUsername())) {
            existingUser.setUsername(updatedUserInfo.getUsername());
        }

        // Update roles if provided, not empty, and valid
        if (updatedUserInfo.getRoles() != null && !updatedUserInfo.getRoles().isEmpty() &&
                !updatedUserInfo.getRoles().equals(existingUser.getRoles())) {
            updatedUserInfo.setRoles(updatedUserInfo.getRoles().toUpperCase());
            if (updatedUserInfo.getRoles().equals("USER") || updatedUserInfo.getRoles().equals("ADMIN")) {
                existingUser.setRoles(updatedUserInfo.getRoles());
            } else {
                return null; // Optionally, return error here if role is invalid
            }
        }

        // Update password if provided and not empty
        if (updatedUserInfo.getPassword() != null && !updatedUserInfo.getPassword().isEmpty()) {
            existingUser.setPassword(passwordEncoder.encode(updatedUserInfo.getPassword()));
        }

        userRepository.save(existingUser);

        return existingUser;
    }

    public String deleteUser(long id) {
        User existingUser = findUserById(id);

        if (existingUser != null) {

            userRepository.delete(existingUser);
            return "Deleted User with ID: " + id;
        } else {

            return "ERROR: User does not exist";
        }
    }

    public void saveOrUpdate(User user) {
        if (user != null) {
            userRepository.save(user);
        }
    }

    public String createUserWeb(User user) {

        if (user.getUsername() == null || user.getUsername().isEmpty() || user.getUsername() == null ||user.getPassword().isEmpty()) {

            return "redirect:/register?error";
        } else {
            Optional<User> existingUser = userRepository.findByUsername(user.getUsername());

            if (existingUser.isPresent()) {

                return "redirect:/register?error";

            } else {

                user.setPassword(passwordEncoder.encode(user.getPassword()));

                if (user.getRoles() == null) {
                    user.setRoles("USER");

                    User result = userRepository.save(user);

                    if (result.getId() > 0) {
                        System.out.println("user saved as user automatically");

                        return "User was saved";
                    } else {

                        return "ERROR: User could not be saved";
                    }
                } else if (user.getRoles() != null) {

                    if (user.getRoles().equals("ADMIN") || user.getRoles().equals("USER")) {

                        User result = userRepository.save(user);

                        if (result.getId() > 0) {

                            System.out.println("user saved with role given");

                            return "User was saved";
                        } else {

                            return "ERROR: User could not be saved";
                        }
                    } else {

                        return "ERROR: Roles has to be set as either ADMIN or USER";
                    }
                } else {
                    return "ERROR: Unknown error when creating a user";
                }
            }

        }

    }

    public User findUserInfo() {
        Optional<User> optionalUser = userRepository.findByUsername(findLoggedInUserDetails().getUsername());

        if (optionalUser.isPresent()) {

            return optionalUser.get();
        } else {

            return null;
        }
    }

    public UserDetails findLoggedInUserDetails() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {

            return (UserDetails) authentication.getPrincipal();
        } else {

            return null;
        }
    }
}
