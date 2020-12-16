package com.example.rasello.user;

import com.example.rasello.response.BaseResponse;
import com.example.rasello.response.Response;
import com.example.rasello.user.request.UserWorkspace;
import com.example.rasello.workspace.Workspace;
import com.example.rasello.workspace.request.WorkspaceRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface UserService {

    BaseResponse<UserProfile> addUser(UserProfile user);

    BaseResponse<UserProfile> update(UUID userId, UserProfile userProfile );

    Response deleteById(UUID userId);

    BaseResponse<UserProfile> addUserWorkspace(UUID userId, UserWorkspace request);





}
