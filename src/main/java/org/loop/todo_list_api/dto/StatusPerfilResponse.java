package org.loop.todo_list_api.dto;

import org.loop.todo_list_api.enums.Ranks;

public record StatusPerfilResponse(
        int xpTotal,
        Ranks rank
) {}