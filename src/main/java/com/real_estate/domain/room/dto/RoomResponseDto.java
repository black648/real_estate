package com.real_estate.domain.room.dto;

import com.real_estate.domain.room.domain.Room;
import com.real_estate.domain.room.domain.RoomDeal;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.locationtech.jts.geom.Point;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class RoomResponseDto {
    private Long id;
    private String name;
    private Long memberId;
    private String address;
    private String addressInfo;
    private Double longitude;
    private Double latitude;
    private String roomCd;
    private String status;
    private List<RoomDeal> roomDealList = new ArrayList<>();

    @Builder
    public RoomResponseDto(Room room) {
        this.id = room.getId();
        this.name = room.getName();
        this.memberId = room.getMemberId();
        this.address = room.getAddress();
        this.addressInfo = room.getAddressInfo();
        this.longitude = room.getLocation().getX();
        this.latitude = room.getLocation().getY();
        this.roomCd = room.getRoomCd();
        this.status = room.getStatus();
        this.roomDealList = room.getRoomDealList();
    }
}