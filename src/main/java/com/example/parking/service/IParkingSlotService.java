package com.example.parking.service;

import com.example.parking.constant.VehicleType;
import com.example.parking.model.entity.Floor;
import com.example.parking.model.entity.ParkingLot;
import com.example.parking.model.entity.Slot;

public interface IParkingSlotService {
    ParkingLot create();
    Floor add();
    Slot findASlotFor(VehicleType vehicleType);
}
