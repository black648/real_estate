package com.real_estate.domain.room.controller;

import com.real_estate.domain.room.dto.RoomSaveDto;
import com.real_estate.domain.room.service.RoomService;
import com.real_estate.global.result.ResultAPI;
import com.real_estate.global.result.ResultSet;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class RoomController {
    private final RoomService roomService;

    @PostMapping("/save")
    public ResultAPI save(RoomSaveDto saveDto) {
        return ResultSet.resultData(roomService.save(saveDto));
    }
}
