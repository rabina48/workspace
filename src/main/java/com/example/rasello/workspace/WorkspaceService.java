package com.example.rasello.workspace;

import com.example.rasello.response.BaseResponse;
import com.example.rasello.response.Response;
import com.example.rasello.workspace.request.WorkspaceRequest;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface WorkspaceService {

    BaseResponse<Workspace> getAll();

    BaseResponse<Workspace> addNewWorkspace(Workspace workspace);

    BaseResponse<Workspace> getWorkspaceById(UUID id);

    BaseResponse<Workspace> update(UUID workSpaceId);

    Response deleteById(UUID id);


}
