package com.example.farmingholiday.repository;

import com.example.farmingholiday.domain.Guest;
import com.example.farmingholiday.domain.Host;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import static org.assertj.core.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@DisplayName("Jpa연결 테스트")
@ActiveProfiles("test")
@SpringBootTest
public class JpaRepositoryTest {
    private final FarmingHolidayRepository farmingHolidayRepository;
    private final FarmingHolidayGuestHouseRepository farmingHolidayGuestHouseRepository;
    private final GuestRepository guestRepository;
    private final HashtagRepository hashtagRepository;
    private final HostRepository hostRepository;
    private final HouseRepository houseRepository;
    private final LikeFarmingHolidayRepository likeFarmingHolidayRepository;
    private final LikeHostRepository likeHostRepository;
    private final LikeHouseRepository likeHouseRepository;
    private final NewsRepository newsRepository;

    public JpaRepositoryTest(
            @Autowired FarmingHolidayRepository farmingHolidayRepository,
            @Autowired FarmingHolidayGuestHouseRepository farmingHolidayGuestHouseRepository,
            @Autowired GuestRepository guestRepository,
            @Autowired HashtagRepository hashtagRepository,
            @Autowired HostRepository hostRepository,
            @Autowired HouseRepository houseRepository,
            @Autowired LikeFarmingHolidayRepository likeFarmingHolidayRepository,
            @Autowired LikeHostRepository likeHostRepository,
            @Autowired LikeHouseRepository likeHouseRepository,
            @Autowired NewsRepository newsRepository) {
        this.farmingHolidayRepository = farmingHolidayRepository;
        this.farmingHolidayGuestHouseRepository = farmingHolidayGuestHouseRepository;
        this.guestRepository = guestRepository;
        this.hashtagRepository = hashtagRepository;
        this.hostRepository = hostRepository;
        this.houseRepository = houseRepository;
        this.likeFarmingHolidayRepository = likeFarmingHolidayRepository;
        this.likeHostRepository = likeHostRepository;
        this.likeHouseRepository = likeHouseRepository;
        this.newsRepository = newsRepository;
    }


    @DisplayName("1. select 테스트")
    @Test
    void givenTestData_whenSelecting_thenWorksFine(){
        //Given
        //When
        hostRepository.findAll().stream().map(Host::getExplanation).forEach(System.out::println);
        //Then
    }

    @DisplayName("2. insert 테스트")
    @Test
    void givenTest_whenInserting_thenWorksFine(){
        //Given
        long previousCount = guestRepository.count();
        //When
        Guest guest = guestRepository.save(Guest.of("inderby@naver.com", "123", "김용빈",
                        "5월8일","123-123","인하대 후문", "image"));
        //Then
        assertThat(guestRepository.count()).isEqualTo(previousCount+1);
    }
    @DisplayName("3. update테스트")
    @Test
    void givenTestData_whenUpdating_whenWorkFine(){
        //Given
        Guest guest = guestRepository.findById(1L).orElseThrow();
        guest.setName("김호떡");
        //When
        Guest savedGuest = guestRepository.saveAndFlush(guest);
        //Then
        assertThat(savedGuest.getName()).isEqualTo("김호떡");
    }
}
