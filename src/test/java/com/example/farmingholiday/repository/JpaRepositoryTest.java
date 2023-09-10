package com.example.farmingholiday.repository;

import com.example.farmingholiday.domain.Host;
import com.example.farmingholiday.domain.Users;
import com.example.farmingholiday.dto.UserType;
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
    private final FarmingHolidayGuestRepository farmingHolidayGuestRepository;
    private final GuestRepository guestRepository;
    private final HashtagRepository hashtagRepository;
    private final HostRepository hostRepository;
    private final HouseRepository houseRepository;
    private final LikesRepository likesRepository;
    private final NewsRepository newsRepository;
    private final UserRepository userRepository;


    public JpaRepositoryTest(
            @Autowired FarmingHolidayRepository farmingHolidayRepository,
            @Autowired FarmingHolidayGuestRepository farmingHolidayGuestRepository,
            @Autowired GuestRepository guestRepository,
            @Autowired HashtagRepository hashtagRepository,
            @Autowired HostRepository hostRepository,
            @Autowired HouseRepository houseRepository,
            @Autowired LikesRepository likesRepository,
            @Autowired NewsRepository newsRepository,
            @Autowired UserRepository userRepository) {
        this.farmingHolidayRepository = farmingHolidayRepository;
        this.farmingHolidayGuestRepository = farmingHolidayGuestRepository;
        this.guestRepository = guestRepository;
        this.hashtagRepository = hashtagRepository;
        this.hostRepository = hostRepository;
        this.houseRepository = houseRepository;
        this.likesRepository = likesRepository;
        this.newsRepository = newsRepository;
        this.userRepository = userRepository;
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
        long previousCount = userRepository.count();
        //When
        Users users = userRepository
                .save(Users.of(UserType.GUEST, "inderby@naver.com", "123", "김용빈", "5월8일","123-123","인하대", "인하대 후문", "local"));
        //Then
        assertThat(userRepository.count()).isEqualTo(previousCount+1);
    }
    @DisplayName("3. update테스트")
    @Test
    void givenTestData_whenUpdating_whenWorkFine(){
        //Given
        Users users = userRepository.findById(1L).orElseThrow();
        users.setName("김호떡");
        //When
        Users savedUsers = userRepository.saveAndFlush(users);
        //Then
        assertThat(savedUsers.getName()).isEqualTo("김호떡");
    }
}
