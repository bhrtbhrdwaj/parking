package com.example.parking.service;

import com.example.parking.constant.SlotStatus;
import com.example.parking.model.entity.Floor;
import com.example.parking.model.entity.Slot;

import java.util.List;

public interface ISlotService {
    Slot create();
    SlotStatus fetchSlotStatus(Long slotId);
    boolean book();
    boolean parkVehicle();
    boolean unParkVehicle();
}
