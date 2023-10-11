package org.parkinglot.dtos;

import org.parkinglot.models.VehicleType;

public class IssueTicketRequestDto {
    private VehicleType vehicleType;
    private String vehicleNumber;
    private String vehicleOwnerNumber;
    private long gateId;
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleOwnerNumber() {
        return vehicleOwnerNumber;
    }

    public void setVehicleOwnerNumber(String vehicleOwnerNumber) {
        this.vehicleOwnerNumber = vehicleOwnerNumber;
    }

    public long getGateId() {
        return gateId;
    }

    public void setGateId(long gateId) {
        this.gateId = gateId;
    }
}
