package com.example.rasello.user.request;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class UserWorkspace {
    private List<UUID> workspaceId;

}
