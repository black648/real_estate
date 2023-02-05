package com.real_estate.domain.room.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RoomRequestDto {
    private Long id;
    private String name;
    private Long memberId;
    private String roomCd;

    @Builder
    public RoomRequestDto(Long id, String name, Long memberId, String roomCd) {
        this.id = id;
        this.name = name;
        this.memberId = memberId;
        this.roomCd = roomCd;
    }
}
