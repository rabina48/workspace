package com.example.rasello.workspace;

import com.example.rasello.response.BaseResponse;
import com.example.rasello.response.Response;
import com.example.rasello.user.UserProfile;
import com.example.rasello.workspace.request.WorkspaceRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class WorkspaceServiceImpl implements WorkspaceService {

    @Autowired
    private  WorkspaceRepository workspaceRepository;


    public BaseResponse<Workspace> getAll() {
        return  new BaseResponse(200,true,"Success",workspaceRepository.findAll());
    }

    @Override
    public BaseResponse<Workspace> addNewWorkspace(Workspace workspace) {

        return new BaseResponse(200,true,"success",workspaceRepository.save(workspace));
    }

    @Override
    public BaseResponse<Workspace> getWorkspaceById(UUID id) {
        return new BaseResponse(200,true,"Success",workspaceRepository.findById(id));
    }

    @Override
    public BaseResponse<Workspace> update(UUID workSpaceId) {
        Optional<Workspace> data = workspaceRepository.findById(workSpaceId);
        if (data.isEmpty()) {
            return new BaseResponse<>(400, false, "Doesnot exist!", null);
        }
        Workspace workspace = new Workspace();
        workspace.setId(workspace.getId());
        workspace.setCode(workspace.getCode());
        workspace.setCreatedAt(workspace.getCreatedAt());
        workspace.setUpdate_at(workspace.getUpdate_at());

        return null;
    }

    @Override
    public Response deleteById(UUID id) {
        workspaceRepository.deleteById(id);
        return new Response(200,true,"Success");
    }
}
