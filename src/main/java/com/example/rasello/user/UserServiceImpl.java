package com.example.rasello.user;

import com.example.rasello.response.BaseResponse;
import com.example.rasello.response.Response;
import com.example.rasello.user.request.UserWorkspace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
import java.util.regex.Pattern;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public BaseResponse<UserProfile> addUser(UserProfile user) {


        UserProfile user1 = userRepository.findByEmail(user.getEmail());
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +  //part before @
                "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);

        if (user.getFirstName() == null || user.getLastName() == null || user.getEmail() == null) {
            return new BaseResponse(400, false, "Required Field cannot be null!", null);
        }
        if (user.getPhone().equals(toString())) {
            return new BaseResponse(400, false, "Number cannot be string");
        }
        if (user.getEmail().equals(user1.getEmail())) {
            return new BaseResponse(400, false, "Email Already exits!", null);
        }
        if (!user.isPersonal()) {
            return new BaseResponse(400, false, "Required Organizational");
        }
        return new BaseResponse(200, true, "success", userRepository.save(user));

    }

    @Override
    public BaseResponse<UserProfile> update(UUID userId, UserProfile userProfile) {
        Optional<UserProfile> data = userRepository.findById(userId);
        if (data.isEmpty()) {
            return new BaseResponse<>(400, false, "Doesnot exist!", null);
        }

        UserProfile user = data.get();
        user.setFirstName(user.getFirstName());
        user.setLastName(user.getLastName());
        user.setEmail(user.getEmail());
        user.setPhone(user.getPhone());
        user.setPersonal(user.isPersonal());


        return new BaseResponse(200, true, "Added Success", userRepository.save(user));
    }

    @Override
    public Response deleteById(UUID userId) {
        userRepository.deleteById(userId);
        return new Response(200, true, "Success");
    }

    @Override
    public BaseResponse<UserProfile> addUserWorkspace(UUID workspaceId, UserWorkspace request) {
        return null;
    }
}
