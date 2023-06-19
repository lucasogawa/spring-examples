package com.ogawalucas.springexamples.app.ports.in.rest.controller;

import com.ogawalucas.springexamples.DatabaseContainer;
import com.ogawalucas.springexamples.app.dto.AnyRequest;
import com.ogawalucas.springexamples.app.ports.out.streaming.KafkaProducer;
import com.ogawalucas.springexamples.core.utils.JsonUtils;
import com.ogawalucas.springexamples.helper.AnyTestHelper;
import jakarta.transaction.Transactional;
import org.junit.ClassRule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.containers.PostgreSQLContainer;

import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Transactional
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AnyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @ClassRule
    public static PostgreSQLContainer postgreSQLContainer = DatabaseContainer.getInstance();

    @Autowired
    private JsonUtils jsonUtils;

    @MockBean
    private KafkaProducer kafkaProducer;

    @Test
    public void pubish_shouldPublish_ifMethodCalled() throws Exception {
        var request = post("/api/any/publish")
            .contentType(MediaType.APPLICATION_JSON)
            .content(jsonUtils.toJson(AnyTestHelper.getAnyRequest()));
        var response = mockMvc.perform(request)
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andReturn().getResponse().getContentAsString(StandardCharsets.UTF_8);
        var actual = jsonUtils.toObject(response, AnyRequest.class);
        var expected = AnyTestHelper.getAnyResponse();

        assertThat(actual)
            .usingRecursiveComparison()
            .ignoringFields("id")
            .isEqualTo(expected);
        assertThat(actual.getId())
            .isNotNull();

        verify(kafkaProducer, times(1))
            .sendToAnyTopic(argThat(argument -> expected.getAnyField().equals(argument.getAnyField())));
    }
}
