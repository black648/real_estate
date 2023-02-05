package com.real_estate.domain.room.service;

import com.real_estate.domain.room.domain.Repository.RoomRepository;
import com.real_estate.domain.room.domain.Room;
import com.real_estate.domain.room.dto.RoomSaveDto;
import com.real_estate.domain.room.dto.RoomUpdateDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Slf4j
@Service
public class RoomService {
    private final RoomRepository roomRepository;

    @Transactional
    public Long save(RoomSaveDto saveDto) {
        return roomRepository.save(saveDto.toEntity()).getId();
    }

    @Transactional
    public void update(RoomUpdateDto updateDto) {
        Room room = roomRepository.findById(updateDto.getId()).orElseThrow(() ->
                new IllegalArgumentException("조회된 방이 없습니다."));
        room.update(updateDto);
    }
}
