package com.example.rasello.user;

import com.example.rasello.workspace.Workspace;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
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

    @JoinTable(name = "user_workspace",
            joinColumns = @JoinColumn(name = "workspace_id"))

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL )
    private List<Workspace> workspaces;

}
