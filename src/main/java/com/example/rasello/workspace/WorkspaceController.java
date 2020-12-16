package com.example.rasello.workspace;

import com.example.rasello.response.BaseResponse;
import com.example.rasello.response.Response;
import com.example.rasello.workspace.request.WorkspaceRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class WorkspaceController {

    @Autowired
    private WorkspaceService workspaceService;

    @GetMapping("/workspace")
    public BaseResponse<List<Workspace>> getAll() {
        return workspaceService.getAllWorkspaces();
    }

    @GetMapping("/workspace/{id}")
    public BaseResponse<Workspace> getWorkspaceById(UUID id) {
        return workspaceService.getWorkspaceById(id);
    }

    @DeleteMapping("/{workspaceId}")
    public Response delete(@PathVariable UUID workspaceId) {
        return workspaceService.deleteById(workspaceId);

    }

    @PutMapping("/{workspaceId}")
    public BaseResponse<Workspace> update(@PathVariable UUID workspaceId, @RequestBody WorkspaceRequest request) {
        return workspaceService.update(workspaceId);

    }
    @PostMapping("/workspace")
    public BaseResponse<Workspace> addNewWorkspace(@RequestBody Workspace workspace){
        return workspaceService.addNewWorkspace(workspace);
    }


    }
