package com.real_estate.domain.room.domain;

import com.real_estate.domain.BaseEntity;
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
}
