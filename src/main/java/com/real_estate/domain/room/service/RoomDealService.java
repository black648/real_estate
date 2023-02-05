package com.real_estate.domain.room.service;

import com.real_estate.domain.room.domain.Repository.RoomDealRepository;
import com.real_estate.domain.room.domain.RoomDeal;
import com.real_estate.domain.room.dto.RoomDealSaveDto;
import com.real_estate.domain.room.dto.RoomDealUpdateDto;
import com.real_estate.domain.room.dto.RoomUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class RoomDealService {
    private final RoomDealRepository roomDealRepository;

    @Transactional
    public Long save(RoomDealSaveDto saveDto) {
        return roomDealRepository.save(saveDto.toEntity()).getId();
    }

    @Transactional
    public void update(RoomDealUpdateDto updateDto) {
       RoomDeal roomDeal =  roomDealRepository.findById(updateDto.getId()).orElseThrow(() ->
                new IllegalArgumentException("조회된 방이 없습니다."));
        roomDeal.update(updateDto);
    }

    @Transactional
    public void deleteAllToRoomId(Long roomId) {
        if(roomDealRepository.findRoomDealByRoomId(roomId).size() > 0) {
            roomDealRepository.deleteAllByRoomId(roomId);
        }
    }
}
