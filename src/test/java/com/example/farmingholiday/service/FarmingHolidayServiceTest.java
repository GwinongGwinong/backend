package com.example.farmingholiday.service;

import com.example.farmingholiday.domain.FarmingHoliday;
import com.example.farmingholiday.dto.BlockFarmingHolidayDto;
import com.example.farmingholiday.dto.FarmingHolidayDto;
import com.example.farmingholiday.repository.FarmingHolidayRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Optional;

import static org.mockito.BDDMockito.*;

@DisplayName("비즈니스로직 - 파밍홀리데이 패키지")
@ExtendWith(MockitoExtension.class)
public class FarmingHolidayServiceTest {
    @InjectMocks
    private FarmingHolidayService sut;
    @Mock
    private FarmingHolidayRepository farmingHolidayRepository;

    @DisplayName("홈화면 구성용 블럭패키지 데이터들을 가져온다")
    @Test
    void givenNoParameter_whenHomepageConnect_thenReturnBlockFarmingHolidayDtos(){
        //Given
        given(farmingHolidayRepository.findAll()).willReturn(List.of(new FarmingHoliday()));
        //When
        List<BlockFarmingHolidayDto> dto = sut.getBlockFarmingHolidays();
        //Then
        assertThat(dto).isNotNull();
        then(farmingHolidayRepository).should().findAll();
    }

    @DisplayName("상세보기 페이지에 자세한 패키지 데이터를 가져온다")
    @Test
    void givenID_whenDetailPageConnect_thenReturnFarmingHolidayDto(){
        //Given
        long package_id = 1L;
        FarmingHoliday farmingHoliday = createFarmingHoliday();
        given(farmingHolidayRepository.findById(package_id)).willReturn(Optional.of(farmingHoliday));
        //When
        FarmingHolidayDto dto = sut.getFarmingHoliday(package_id);
        //Then
        assertThat(dto)
                .hasFieldOrPropertyWithValue("name", farmingHoliday.getName())
                .hasFieldOrPropertyWithValue("location", farmingHoliday.getLocation())
                .hasFieldOrPropertyWithValue("address", farmingHoliday.getAddress())
                .hasFieldOrPropertyWithValue("pay", farmingHoliday.getPay())
                .hasFieldOrPropertyWithValue("payMonths", farmingHoliday.getPayMonths());
    }

    private FarmingHoliday createFarmingHoliday(){
        return new FarmingHoliday(
               "김찐빵",
               "인천 미추홀구",
               "126-23",
               14,
               280
        );
    }

}
