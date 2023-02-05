package com.real_estate.domain.room.domain.Repository;

import com.querydsl.core.types.Expression;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.real_estate.domain.room.domain.Room;
import com.real_estate.domain.room.dto.RoomRequestDto;
import com.real_estate.domain.room.dto.RoomResponseDto;
import com.real_estate.global.utils.QueryDslUtil;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

import java.util.List;

import static com.real_estate.domain.room.domain.QRoom.room;
import static com.real_estate.domain.room.domain.QRoomDeal.roomDeal;
import static com.real_estate.global.code.domain.QCode.code;

@Repository
public class RoomQueryDsl {
    private final JPAQueryFactory queryFactory;

    public RoomQueryDsl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    public Room get(Long id) {
        return queryFactory.selectFrom(room)
                .where(QueryDslUtil.equalsLong(id, room.id))
                .leftJoin(room.roomDealList, roomDeal).fetchJoin()
                .fetchOne();
    }

    public List<RoomResponseDto> getList(RoomRequestDto requestDto) {
        return queryFactory.select(Projections.fields(RoomResponseDto.class, setColumn()))
                .from(room)
                .where(QueryDslUtil.equalsLong(requestDto.getId(), room.id))
                .where(QueryDslUtil.equalsLong(requestDto.getMemberId(), room.memberId))
                .where(QueryDslUtil.equals(requestDto.getRoomCd(), room.roomCd))
                .where(QueryDslUtil.equals(requestDto.getName(), room.name))
                .fetch();
    }

    private Expression<?>[] setColumn() {
        return new Expression[]{
                room.id,
                room.name,
                room.address,
                room.addressInfo,
                room.location,
                room.status,
                room.roomCd,
                ExpressionUtils.as(JPAExpressions.select(code.name).from(code).where(code.cd.eq(room.roomCd)), "roomCdName")
        };
    }
}
