package com.real_estate.domain.room.service;

import com.real_estate.domain.room.domain.Repository.RoomRepository;
import com.real_estate.domain.room.domain.Room;
import com.real_estate.domain.room.dto.RoomSaveDto;
import com.real_estate.global.utils.CommonUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.locationtech.jts.io.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class RoomServiceTest {
    @Autowired
    RoomService roomService;

    @Autowired
    RoomRepository roomRepository;

    @DisplayName("[단위테스트] 방 등록")
    @Test
    public void save() throws ParseException {
        Long roomId = roomService.save(RoomSaveDto.builder()
                .name("삼성역 도보 5분거리 깨끗한 원룸")
                .memberId(1L)
                .address("서울특별시 강남구 영동대로 513 (삼성동)")
                .addressInfo("111-1")
                .location(CommonUtil.getLocation(37.51148310935, 127.06033711446))
                .roomCd("R00101")
                .status("N")
                .build());

        List<Room> list = roomRepository.findAll();
        assertThat(list.get(0).getId()).isEqualTo(roomId);
    }

}