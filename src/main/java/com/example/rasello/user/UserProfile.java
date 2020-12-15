package com.example.rasello.user;

import com.example.rasello.workspace.Workspace;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
public class UserProfile {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
        
    )
    @Column(name = "id",updatable = false, nullable = false)
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private Long phone;
    private boolean personal;
    private List<Workspace> workspaces;

}
