package com.example.progresspal.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table (name = "goals")
public class Goals {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column (name = "user_id")
    private Integer userId;
    @Column ( name = "title")
    private String title;
    @Column ( name = "target_date")
    private LocalDate targetDate;
    @Column (name = "created_at")
    private LocalDateTime createdAt;

    public void setUserId(Object id) {
    }

    public void setTitle(String title) {
    }
}
