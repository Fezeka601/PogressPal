package com.example.progresspal.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "goals")
public class Goals {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String title;

    private String description;

    @Column(name = "target_date")
    private LocalDate targetDate;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    private Integer targetValue;

    private Integer currentValue;

    @Enumerated(EnumType.STRING)
    private GoalStatus status;

    @Enumerated(EnumType.STRING)
    private GoalCategory category;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnoreProperties({"goals"})
    private Users user;

    public Goals() {
    }

    @PrePersist
    public void prePersist() {

        if (createdAt == null) {
            createdAt = LocalDateTime.now();
        }

        if (currentValue == null) {
            currentValue = 0;
        }

        if (status == null) {
            status = GoalStatus.NOT_STARTED;
        }
    }
    @Transient
    public double getProgressPercentage() {

        if (targetValue == null || targetValue == 0) {
            return 0;
        }

        return ((double) currentValue / targetValue) * 100;
    }
    @Transient
    public boolean isOverdue() {

        return targetDate != null
                && LocalDate.now().isAfter(targetDate)
                && status != GoalStatus.COMPLETED;
    }
    // ==========================
    // GETTERS
    // ==========================

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Integer getTargetValue() {
        return targetValue;
    }

    public Integer getCurrentValue() {
        return currentValue;
    }

    public GoalStatus getStatus() {
        return status;
    }

    public GoalCategory getCategory() {
        return category;
    }

    public Users getUser() {
        return user;
    }

    // ==========================
    // SETTERS
    // ==========================

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setTargetValue(Integer targetValue) {
        this.targetValue = targetValue;
    }

    public void setCurrentValue(Integer currentValue) {
        this.currentValue = currentValue;
    }

    public void setStatus(GoalStatus status) {
        this.status = status;
    }

    public void setCategory(GoalCategory category) {
        this.category = category;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
