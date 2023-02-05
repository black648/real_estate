package com.real_estate.domain.room.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RoomDealUpdateDto {
    private Long id;
    private Long deposit;
    private Long rentalFee;
    private String dealCd;

    @Builder
    public RoomDealUpdateDto(Long id, Long deposit, Long rentalFee, String dealCd) {
        this.id = id;
        this.deposit = deposit;
        this.rentalFee = rentalFee;
        this.dealCd = dealCd;
    }
}
