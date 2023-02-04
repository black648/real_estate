package com.real_estate.domain.room.domain;

import com.real_estate.domain.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.geo.Point;

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
    private String Address;

    //상세주소
    @Column(nullable = false)
    private String AddressInfo;

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
}
