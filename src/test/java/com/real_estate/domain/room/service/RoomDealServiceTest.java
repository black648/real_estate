package com.real_estate.domain.room.service;

import com.real_estate.domain.room.domain.Repository.RoomDealRepository;
import com.real_estate.domain.room.domain.RoomDeal;
import com.real_estate.domain.room.dto.RoomDealSaveDto;
import com.real_estate.domain.room.dto.RoomDealUpdateDto;
import com.real_estate.domain.room.dto.RoomSaveDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class RoomDealServiceTest {
    @Autowired
    RoomService roomService;

    @Autowired
    RoomDealService roomDealService;

    @Autowired
    RoomDealRepository roomDealRepository;

    @DisplayName("[단위테스트] 방 거래 등록")
    @Test
    public void save() {
        Long roomId = roomService.save(RoomSaveDto.builder()
                .name("삼성역 도보 1분거리 깨끗한 원룸")
                .memberId(1L)
                .address("서울특별시 강남구 영동대로 513 (삼성동)")
                .addressInfo("111-1")
                .longitude(37.51148310935)
                .latitude(127.06033711446)
                .roomCd("R00101")
                .status("N")
                .build());

        Long roomDealId = roomDealService.save(RoomDealSaveDto.builder()
                .roomId(roomId)
                .dealCd("R001001")
                .deposit(1000L)
                .rentalFee(50L)
                .build());

        List<RoomDeal> list = roomDealRepository.findAll();
        assertThat(list.get(0).getId()).isEqualTo(roomDealId);
    }

    @DisplayName("[단위테스트] 방 수정")
    @Test
    public void update() {
        Long roomId = roomService.save(RoomSaveDto.builder()
                .name("삼성역 도보 5분거리 깨끗한 원룸")
                .memberId(1L)
                .address("서울특별시 강남구 영동대로 513 (삼성동)")
                .addressInfo("111-1")
                .longitude(37.51148310935)
                .latitude(127.06033711446)
                .roomCd("R00101")
                .status("N")
                .build());

        Long roomDealId = roomDealService.save(RoomDealSaveDto.builder()
                .roomId(roomId)
                .dealCd("R001001")
                .deposit(1000L)
                .rentalFee(50L)
                .build());

        roomDealService.update(RoomDealUpdateDto.builder()
                .id(roomDealId)
                .dealCd("R001002")
                .deposit(1200L)
                .rentalFee(70L)
                .build());

        RoomDeal roomDeal = roomDealRepository.findById(roomDealId).get();
        assertThat(1200L).isEqualTo(roomDeal.getDeposit());
    }


}