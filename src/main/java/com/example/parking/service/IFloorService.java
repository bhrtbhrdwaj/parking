package com.example.parking.service;

import com.example.parking.model.entity.Floor;
import com.example.parking.model.entity.ParkingLot;
import com.example.parking.model.entity.Slot;

import java.util.List;

public interface IFloorService {
    Floor create();
    Floor addSlot();
    List<Slot> fetchOccupiedSlots(Integer floorId);
    List<Slot> fetchVacantSlots(Integer floorId);
}
