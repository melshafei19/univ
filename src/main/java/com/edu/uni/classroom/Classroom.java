package com.edu.uni.classroom;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Timestamp;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor


public class Classroom {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "building_name", length = 100)
    private String buildingName;

    @Column(name = "room_number", nullable = false)
    private Integer roomNumber;

    @Lob
    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

}
