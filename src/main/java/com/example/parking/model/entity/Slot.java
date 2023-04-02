package com.example.parking.model.entity;

import com.example.parking.constant.SlotStatus;
import com.example.parking.constant.VehicleType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "slot")
@Getter
@Setter
public class Slot extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "floor_id")
    private Floor floor;

    /* List of Vehicle that are parked or booked a slot */
    @OneToMany(mappedBy = "bookedSlot")
    private List<Vehicle> vehicles;

    @Column(name = "for_vehicle_type")
    @Type(type = "")
    private VehicleType forVehicleType;

    @Column(name = "status")
    @Type(type = "")
    private SlotStatus status;

}
