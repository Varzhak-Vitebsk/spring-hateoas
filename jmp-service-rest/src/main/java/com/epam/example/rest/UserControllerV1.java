package com.epam.example.rest;

import com.epam.example.dto.ErrorResponse;
import com.epam.example.dto.UserRequestDto;
import com.epam.example.dto.UserResponseDto;
import com.epam.example.dto.UsersResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(path = "/api/public/v1/user", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public interface UserControllerV1 {

    @Operation(summary = "Create user.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", content = {
            @Content(mediaType = "application/json",
                schema = @Schema(implementation = UserResponseDto.class))
        }),
        @ApiResponse(responseCode = "400", content = {
            @Content(mediaType = "application/json",
                schema = @Schema(implementation = ErrorResponse.class))
        }),
        @ApiResponse(responseCode = "500", content = {
            @Content(mediaType = "application/json",
                schema = @Schema(implementation = ErrorResponse.class))
        })
    })
    @PostMapping
    ResponseEntity<UserResponseDto> createUser(
        @RequestBody @Valid UserRequestDto request);

    @Operation(summary = "Update user.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", content = {
            @Content(mediaType = "application/json",
                schema = @Schema(implementation = UserResponseDto.class))
        }),
        @ApiResponse(responseCode = "400", content = {
            @Content(mediaType = "application/json",
                schema = @Schema(implementation = ErrorResponse.class))
        }),
        @ApiResponse(responseCode = "404", content = {
            @Content(mediaType = "application/json",
                schema = @Schema(implementation = ErrorResponse.class))
        }),
        @ApiResponse(responseCode = "500", content = {
            @Content(mediaType = "application/json",
                schema = @Schema(implementation = ErrorResponse.class))
        })
    })
    @PatchMapping
    ResponseEntity<UserResponseDto> updateUser(
        @RequestBody @Valid UserRequestDto request);

    @Operation(summary = "Delete user.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200"),
        @ApiResponse(responseCode = "400", content = {
            @Content(mediaType = "application/json",
                schema = @Schema(implementation = ErrorResponse.class))
        }),
        @ApiResponse(responseCode = "404", content = {
            @Content(mediaType = "application/json",
                schema = @Schema(implementation = ErrorResponse.class))
        }),
        @ApiResponse(responseCode = "500", content = {
            @Content(mediaType = "application/json",
                schema = @Schema(implementation = ErrorResponse.class))
        })
    })
    @DeleteMapping(value = "{id}")
    ResponseEntity<Void> deleteUser(
        @PathVariable(name = "id") @NotNull Long id);

    @Operation(summary = "Retrieve user.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", content = {
            @Content(mediaType = "application/json",
                schema = @Schema(implementation = UserResponseDto.class))
        }),
        @ApiResponse(responseCode = "400", content = {
            @Content(mediaType = "application/json",
                schema = @Schema(implementation = ErrorResponse.class))
        }),
        @ApiResponse(responseCode = "404", content = {
            @Content(mediaType = "application/json",
                schema = @Schema(implementation = ErrorResponse.class))
        }),
        @ApiResponse(responseCode = "500", content = {
            @Content(mediaType = "application/json",
                schema = @Schema(implementation = ErrorResponse.class))
        })
    })
    @GetMapping(value = "{id}")
    ResponseEntity<UserResponseDto> getUser(
        @PathVariable(name = "id") @NotNull Long id);

    @Operation(summary = "Retrieve users.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", content = {
            @Content(mediaType = "application/json",
                schema = @Schema(implementation = UsersResponse.class))
        }),
        @ApiResponse(responseCode = "500", content = {
            @Content(mediaType = "application/json",
                schema = @Schema(implementation = ErrorResponse.class))
        })
    })
    @GetMapping
    ResponseEntity<UsersResponse> getAllUsers(); //TODO use paging on prod

}
