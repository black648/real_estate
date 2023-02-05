package com.real_estate.domain.room.controller;

import com.real_estate.domain.room.dto.RoomSaveDto;
import com.real_estate.domain.room.dto.RoomUpdateDto;
import com.real_estate.domain.room.service.RoomService;
import com.real_estate.global.result.ResultAPI;
import com.real_estate.global.result.ResultSet;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class RoomController {
    private final RoomService roomService;

    @PostMapping("/room/save")
    public ResultAPI save(@RequestBody RoomSaveDto saveDto) {
        return ResultSet.resultData(roomService.save(saveDto));
    }

    @PutMapping("/room/update")
    public void update(@RequestBody RoomUpdateDto updateDto) {
        roomService.update(updateDto);
    }

    @DeleteMapping("/room/delete/{id}")
    public void delete(@PathVariable Long id) {
        roomService.delete(id);
    }

    @PostMapping("/room/get/{id}")
    public ResultAPI get(@PathVariable Long id) {
        return ResultSet.resultData(roomService.get(id));
    }
}
