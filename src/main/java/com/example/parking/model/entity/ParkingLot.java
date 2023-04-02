package com.example.parking.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "parking_lot")
@Getter
@Setter
public class ParkingLot extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @OneToMany(mappedBy = "parkingLot")
    private List<Floor> floors;
}
