package com.real_estate.domain.room.domain.Repository;

import com.real_estate.domain.room.domain.RoomDeal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomDealRepository extends JpaRepository<RoomDeal, Long> {
    List<RoomDeal> findRoomDealByRoomId(Long roomId);
    void deleteAllByRoomId(Long roomId);
}
