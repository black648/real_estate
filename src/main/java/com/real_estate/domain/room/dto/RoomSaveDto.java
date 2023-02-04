package com.real_estate.domain.room.dto;

import com.real_estate.domain.room.domain.Room;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.locationtech.jts.geom.Point;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class RoomSaveDto {
    private String name;
    private Long memberId;
    private String address;
    private String addressInfo;
    private Point location;
    private String roomCd;
    private String status;
    private LocalDate deletedDate;

    @Builder
    public RoomSaveDto(String name, Long memberId, String address, String addressInfo, Point location, String roomCd, String status, LocalDate deletedDate) {
        this.name = name;
        this.memberId = memberId;
        this.address = address;
        this.addressInfo = addressInfo;
        this.location = location;
        this.roomCd = roomCd;
        this.status = status;
        this.deletedDate = deletedDate;
    }

    public Room toEntity() {
        return Room.builder()
                .name(name)
                .memberId(memberId)
                .address(address)
                .addressInfo(addressInfo)
                .location(location)
                .roomCd(roomCd)
                .status(status)
                .deletedDate(deletedDate)
                .build();
    }
}