package ru.neoflex.userwebflux.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.neoflex.userwebflux.dtos.ClientDto;
import ru.neoflex.userwebflux.dtos.ErrorResponse;
import ru.neoflex.userwebflux.dtos.SearchFilter;
import ru.neoflex.userwebflux.models.client.Client;

public interface ClientAccountAPI {
    @PostMapping
    @Operation(
            summary = "Create",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Created successfully"
                    )
            }
    )
    Mono<Client> create(@RequestBody @Valid ClientDto clientDto, @RequestHeader("x-Source") String source);

    @Operation(
            summary = "Find by id",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Found successfully",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ClientDto.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Not found",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ErrorResponse.class)
                            )
                    )
            }
    )
    @GetMapping("/{id}")
    Mono<ClientDto> findById(@PathVariable("id") String id);

    @Operation(
            summary = "Search",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Found successfully",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ClientDto.class)
                            )
                    )
            }
    )
    @GetMapping("/search/")
    Flux<ClientDto> search(SearchFilter filters);
}
