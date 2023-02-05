package com.real_estate.domain.room.domain;

import com.real_estate.domain.BaseEntity;
import com.real_estate.domain.room.dto.RoomUpdateDto;
import com.real_estate.global.utils.CommonUtil;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.locationtech.jts.geom.Point;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "room")
public class Room extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<RoomDeal> codeList = new ArrayList<>();

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Long memberId;

    //기본주소
    @Column(nullable = false)
    private String address;

    //상세주소
    @Column(nullable = false)
    private String addressInfo;

    //위치정보
    @Column(nullable = false, columnDefinition = "GEOMETRY")
    private Point location;

    //방 구조
    @Column(nullable = false)
    private String roomCd;

    //계약상태
    @Column(nullable = false)
    private String status;

    //삭제일
    @Column
    private LocalDate deletedDate;

    @Builder
    public Room(String name, Long memberId, String address, String addressInfo, Point location, String roomCd, String status, LocalDate deletedDate) {
        this.name = name;
        this.memberId = memberId;
        this.address = address;
        this.addressInfo = addressInfo;
        this.location = location;
        this.roomCd = roomCd;
        this.status = status;
        this.deletedDate = deletedDate;
    }

    public void update(RoomUpdateDto updateDto) {
        this.name = updateDto.getName();
        this.address = updateDto.getAddress();
        this.addressInfo = updateDto.getAddressInfo();
        this.location = CommonUtil.getLocation(updateDto.getLongitude(), updateDto.getLatitude());
        this.roomCd = updateDto.getRoomCd();
        this.status = updateDto.getStatus();
    }
}
