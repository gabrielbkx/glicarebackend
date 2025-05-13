package com.glicarebackend.glicare.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Table(name = "glucose_measurement")
public class GlucoseMeasurement {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private Double glicemia;
    private LocalDateTime dateHourRegister;
    private LocalDate creationDate;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
