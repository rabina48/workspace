package com.example.rasello.workspace;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;


@Entity
@Data
@NoArgsConstructor
@Table(name = "workspace",schema = "public")
public class Workspace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @JoinTable(name = "user_workspace",
            joinColumns =@JoinColumn(name = "workspace_id"),
            inverseJoinColumns= @JoinColumn(name ="user_id"))
    private UUID id;
    private String name;
    private Integer code;

    @Column (name= "created_by", nullable = false)
    @CreatedBy
    private String createdBy;

//    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at",nullable = false,updatable = false)
    @CreatedDate
    private Timestamp createdAt;

//    @Temporal(TemporalType.TIMESTAMP)
    @Column(name ="update_at",nullable = false)
    @LastModifiedDate
    private Timestamp update_at;


}
