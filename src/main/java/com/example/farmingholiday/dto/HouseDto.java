package com.example.farmingholiday.dto;

import com.example.farmingholiday.domain.House;
import lombok.*;

import java.time.LocalDateTime;

// 상세페이지 - 숙소
// 데이터 : 수용인원, 이름, 지역, 주소, 숙박 기간, 면적, 객실 시설, 부대 시설, 평점, 위경도
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HouseDto {
    private long capacity;
    private String name;
    private String location;
    private String address;
    private LocalDateTime rentStartDate;
    private LocalDateTime rentEndDate;
    private String houseType;
    private long area;
    private String roomFacilities;
    private String outFacilities;
    private double rate;
    private String lat;
    private String lon;



    public static HouseDto from(House entity){
        return new HouseDto(
                entity.getCapacity(),
                entity.getName(),
                entity.getLocation(),
                entity.getAddress(),
                entity.getRentStartDate(),
                entity.getRentEndDate(),
                entity.getHouseType(),
                entity.getArea(),
                entity.getRoomFacilities(),
                entity.getOutFacilities(),
                entity.getRate(),
                entity.getLat(),
                entity.getLon()
        );
    }
}