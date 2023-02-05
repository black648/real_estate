package com.real_estate.domain.room.dto;

import com.real_estate.domain.room.domain.RoomDeal;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RoomDealSaveDto {
    private Long roomId;
    private Long deposit;
    private Long rentalFee;
    private String dealCd;

    @Builder
    public RoomDealSaveDto(Long roomId, Long deposit, Long rentalFee, String dealCd) {
        this.roomId = roomId;
        this.deposit = deposit;
        this.rentalFee = rentalFee;
        this.dealCd = dealCd;
    }

    public RoomDeal toEntity() {
        return RoomDeal.builder()
                .roomId(roomId)
                .deposit(deposit)
                .rentalFee(rentalFee)
                .dealCd(dealCd)
                .build();
    }
}
