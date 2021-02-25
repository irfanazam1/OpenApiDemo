package com.example;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.links.Link;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@RestController(value = "User Resource")
@RequestMapping("/api/v1/user")
public class UserController {

    @GetMapping(value = "/{userId}")
    @ApiResponse(description = "User not found for the given id.", responseCode = "404")
    @ApiResponse(description = "User found for the given id.", responseCode = "200",  links = @Link(name="RoleDto"))
    @ApiResponse(description = "Failed to reach the user store.", responseCode = "502")
    @ApiResponse(description = "Unknown Error.", responseCode = "500")
    @Operation(method = "findById", description = "Method to find a user by id", tags = {"User"})
    public ResponseEntity<User> findById(
            @Valid
            @Parameter(name = "userId", in = ParameterIn.PATH, required = true, description = "User id to search for")
            @PathVariable(value = "userId")  long userId) {
        User dto = new User();
        dto.setId(UUID.randomUUID().toString());
        dto.setName(UUID.randomUUID().toString());
        dto.setRole(new Role("admin"));
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/")
    @ApiResponse(description = "No users present in the system.", responseCode = "204")
    @ApiResponse(description = "Users found.", responseCode = "200",  links = @Link(name="RoleDto"))
    @ApiResponse(description = "Failed to reach the user store.", responseCode = "502")
    @ApiResponse(description = "Unknown Error.", responseCode = "500")
    @Operation(method = "getAllUsers", description = "Returns all users in the system", tags = {"User"})
    public ResponseEntity<List<User>> getAllUsers() {
        User dto = new User();
        dto.setId(UUID.randomUUID().toString());
        dto.setName(UUID.randomUUID().toString());
        dto.setRole(new Role("admin"));
        return ResponseEntity.ok(new ArrayList<User>(Arrays.asList(dto)));
    }

    @PostMapping(value="/", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
    @ApiResponse(description = "User Added", responseCode = "200",  links = @Link(name="RoleDto"))
    @ApiResponse(description = "Failed to reach the user store.", responseCode = "502")
    @ApiResponse(description = "Unknown Error.", responseCode = "500")
    @Operation(method = "addUser", description = "Adds a new in the system", tags = {"User"})
    @ApiResponse(description = "Invalid payload. Check if provided values are the in right format.", responseCode = "400")
    public ResponseEntity<List<User>> addUser() {
        User dto = new User();
        dto.setId(UUID.randomUUID().toString());
        dto.setName(UUID.randomUUID().toString());
        dto.setRole(new Role("admin"));
        return ResponseEntity.ok(new ArrayList<User>(Arrays.asList(dto)));
    }

    @PutMapping(value = "/{userId}", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
    @ApiResponse(description = "No user found with the given id.", responseCode = "404")
    @ApiResponse(description = "User found and successfully updated.", responseCode = "200",  links = @Link(name="RoleDto"), content = @Content(mediaType = "application/json"))
    @ApiResponse(description = "Failed to reach the user store.", responseCode = "502")
    @ApiResponse(description = "Unknown Error.", responseCode = "500")
    @ApiResponse(description = "Invalid payload. Check if provided values are in right format.", responseCode = "400")
    @Operation(method = "updateUser", description = "Updates a given user", tags = {"User"})
    public User updateUser(
            @Parameter(name = "userId", in = ParameterIn.PATH, required = true, description = "User id to update for")
            @PathVariable(value = "userId") final String userId, @RequestBody(required = true) final User user) {
        return user;
    }
}
