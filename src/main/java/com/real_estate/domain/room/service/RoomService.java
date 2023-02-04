package com.real_estate.domain.room.service;

import com.real_estate.domain.room.domain.Repository.RoomRepository;
import com.real_estate.domain.room.dto.RoomSaveDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class RoomService {
    private final RoomRepository roomRepository;

    @Transactional
    public Long save(RoomSaveDto saveDto) {
        return roomRepository.save(saveDto.toEntity()).getId();
    }
}
