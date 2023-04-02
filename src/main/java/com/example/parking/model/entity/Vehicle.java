package com.example.parking.model.entity;

import com.example.parking.constant.BookingStatus;
import com.example.parking.constant.VehicleType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "vehicle")
@Getter
@Setter
public class Vehicle extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "booked_slot_id")
    private Slot bookedSlot;
    @Column(name = "type")
    @Type(type = "")
    private VehicleType type;

    @Column(name = "booking_status")
    @Type(type = "")
    private BookingStatus bookingStatus;

}
