package com.real_estate.domain.room.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.locationtech.jts.geom.Point;

@Getter
@NoArgsConstructor
public class RoomUpdateDto {
    private Long id;
    private String name;
    private String address;
    private String addressInfo;
    private Double longitude;
    private Double latitude;
    private Point location;
    private String roomCd;
    private String status;

    @Builder
    public RoomUpdateDto(Long id, String name, String address, String addressInfo, Double longitude, Double latitude, String roomCd, String status) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.addressInfo = addressInfo;
        this.longitude = longitude;
        this.latitude = latitude;
        this.roomCd = roomCd;
        this.status = status;
    }
}