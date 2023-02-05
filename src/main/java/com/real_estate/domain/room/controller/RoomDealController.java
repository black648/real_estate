package com.real_estate.domain.room.controller;

import com.real_estate.domain.room.dto.RoomDealSaveDto;
import com.real_estate.domain.room.dto.RoomDealUpdateDto;
import com.real_estate.domain.room.service.RoomDealService;
import com.real_estate.global.result.ResultAPI;
import com.real_estate.global.result.ResultSet;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class RoomDealController {
    private final RoomDealService roomDealService;

    @PostMapping("/roomDeal/save")
    public ResultAPI save(@RequestBody RoomDealSaveDto saveDto) {
        return ResultSet.resultData(roomDealService.save(saveDto));
    }

    @PutMapping("/roomDeal/update")
    public void update(@RequestBody RoomDealUpdateDto updateDto) {
        roomDealService.update(updateDto);
    }

}
