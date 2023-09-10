package com.example.farmingholiday;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.test.context.web.WebAppConfiguration;

@EnableJdbcRepositories
@ComponentScan(basePackages = "src/main/java/com/example/farmingholiday/repository")
@EntityScan(basePackages = "src/main/java/com/example/farmingholiday/domain")
@SpringBootTest
class FarmingHolidayApplicationTests {

    @Test
    void contextLoads() {
    }

}
