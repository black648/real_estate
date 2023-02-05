package com.real_estate.domain.room.service;

import com.real_estate.domain.room.domain.Repository.RoomQueryDsl;
import com.real_estate.domain.room.domain.Repository.RoomRepository;
import com.real_estate.domain.room.domain.Room;
import com.real_estate.domain.room.dto.RoomRequestDto;
import com.real_estate.domain.room.dto.RoomResponseDto;
import com.real_estate.domain.room.dto.RoomSaveDto;
import com.real_estate.domain.room.dto.RoomUpdateDto;
import com.real_estate.global.code.service.CodeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class RoomService {
    private final RoomDealService roomDealService;
    private final RoomRepository roomRepository;
    private final RoomQueryDsl roomQueryDsl;
    private final CodeService codeService;

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

    @Transactional
    public void delete(Long id) {
            Room room = roomRepository.findById(id).orElseThrow(() ->
                    new IllegalArgumentException("조회된 방이 없습니다."));
            roomRepository.delete(room);

//      방 거래유형 일괄삭제
        roomDealService.deleteAllToRoomId(id);
    }

    public RoomResponseDto get(Long id) {
        RoomResponseDto responseDto = new RoomResponseDto(roomRepository.findById(id).get());
        responseDto.setRoomCdName(codeService.get(responseDto.getRoomCd()).getName());
        return responseDto;
    }

    public List<RoomResponseDto> getList(RoomRequestDto requestDto) {
        return roomQueryDsl.getList(requestDto);
    }
}
