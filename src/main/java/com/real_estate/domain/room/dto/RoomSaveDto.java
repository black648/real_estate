package com.real_estate.domain.room.dto;

import com.real_estate.domain.room.domain.Room;
import com.real_estate.global.utils.CommonUtil;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RoomSaveDto {
    private String name;
    private Long memberId;
    private String address;
    private String addressInfo;
    private Double longitude;
    private Double latitude;
    private String roomCd;
    private String status;

    @Builder
    public RoomSaveDto(String name, Long memberId, String address, String addressInfo, Double longitude, Double latitude, String roomCd, String status) {
        this.name = name;
        this.memberId = memberId;
        this.address = address;
        this.addressInfo = addressInfo;
        this.longitude = longitude;
        this.latitude = latitude;
        this.roomCd = roomCd;
        this.status = status;
    }

    public Room toEntity() {
        return Room.builder()
                .name(name)
                .memberId(memberId)
                .address(address)
                .addressInfo(addressInfo)
                .location(CommonUtil.getLocation(longitude, latitude))
                .roomCd(roomCd)
                .status(status)
                .build();
    }
}