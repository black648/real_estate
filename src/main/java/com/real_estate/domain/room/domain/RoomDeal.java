package com.real_estate.domain.room.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.real_estate.domain.BaseEntity;
import com.real_estate.domain.room.dto.RoomDealUpdateDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "roomDeal")
public class RoomDeal extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Room ID
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "roomId", insertable = false, updatable = false)
    private Room room;

    @Column(nullable = false)
    private Long roomId;

    //보증금
    @Column(nullable = false)
    private Long deposit;

    //월세
    @Column(nullable = false)
    private Long rentalFee;

    //거래유형(월세 전세 매매)
    @Column(nullable = false)
    private String dealCd;

    //삭제일
    @Column
    private LocalDate deletedDate;

    @Builder
    public RoomDeal(Long roomId, Long deposit, Long rentalFee, String dealCd, LocalDate deletedDate) {
        this.roomId = roomId;
        this.deposit = deposit;
        this.rentalFee = rentalFee;
        this.dealCd = dealCd;
        this.deletedDate = deletedDate;
    }

    public void update(RoomDealUpdateDto updateDto) {
        this.deposit = updateDto.getDeposit();
        this.rentalFee = updateDto.getRentalFee();
        this.dealCd = updateDto.getDealCd();
    }
}
