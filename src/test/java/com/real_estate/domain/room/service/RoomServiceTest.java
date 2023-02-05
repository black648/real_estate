package com.real_estate.domain.room.service;

import com.real_estate.domain.room.domain.Repository.RoomRepository;
import com.real_estate.domain.room.domain.Room;
import com.real_estate.domain.room.dto.RoomResponseDto;
import com.real_estate.domain.room.dto.RoomSaveDto;
import com.real_estate.domain.room.dto.RoomUpdateDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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
    public void save() {
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

        List<Room> list = roomRepository.findAll();
        assertThat(list.get(0).getId()).isEqualTo(roomId);
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

        roomService.update(RoomUpdateDto.builder()
                .id(roomId)
                .name("삼성역 도보 2분거리 깨끗한 원룸")
                .address("서울특별시 강남구 영동대로 510 (삼성동)")
                .addressInfo("131-1")
                .longitude(39.51148310935)
                .latitude(126.06033711446)
                .roomCd("R00101")
                .status("Y")
                .build());

        Room room = roomRepository.findById(roomId).get();
        assertThat("삼성역 도보 2분거리 깨끗한 원룸").isEqualTo(room.getName());
    }

    @DisplayName("[단위테스트] 방 조회")
    @Test
    public void get() {
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

        RoomResponseDto responseDto = roomService.get(roomId);
        assertThat(roomId).isEqualTo(responseDto.getId());
    }


}