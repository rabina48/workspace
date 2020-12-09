package com.example.rasello.workspace.request;

import com.example.rasello.workspace.Workspace;
import lombok.Data;

import java.util.List;
import java.util.UUID;
@Data
public class WorkspaceRequest {
    private UUID userId;
    private List<Workspace> workSpaceId;
}
