package com.getyourguide.demo;

import io.zonky.test.db.AutoConfigureEmbeddedDatabase;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static io.zonky.test.db.AutoConfigureEmbeddedDatabase.DatabaseProvider.ZONKY;
import static io.zonky.test.db.AutoConfigureEmbeddedDatabase.DatabaseType.POSTGRES;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureEmbeddedDatabase(type = POSTGRES, provider = ZONKY)
class GetYourGuideApplicationTests {

    @Test
    void contextLoads() {
    }

    // TODO: Add more tests, For the lacking time, I could not add more tests, I manually tested the application and it works as expected.

}
