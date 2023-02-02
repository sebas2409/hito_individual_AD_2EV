package com.example.hito_individual_ad_2ev.infrastructure.database.entitites;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "task")
public class Task {
    @ToString.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ToString.Include
    @Column(name = "description", nullable = false, length = 500)
    private String description;

    @ToString.Include
    @Column(name = "created_at", nullable = false)
    private LocalDate createdAt;

    @ToString.Include
    @Column(name = "end_at", nullable = false)
    private LocalDate endAt;

    @Column(name = "status", length = 500)
    private String status;

}