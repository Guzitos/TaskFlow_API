package org.loop.todo_list_api.dto;

// Use record (com parênteses) em vez de class
public record LoginDTO(String perfilName, String password) {}