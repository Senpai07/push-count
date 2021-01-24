package ru.test.project.pushcount;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.test.project.pushcount.entities.CounterEntity;
import ru.test.project.pushcount.services.CounterService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.hasValue;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CounterControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private CounterService counterService;

    @Test
    public void getCounterTest() throws Exception {
        CounterEntity counterEntity = new CounterEntity();
        counterEntity.setId(1L);
        counterEntity.setQuantity(1);

        given(counterService.findById(1L)).willReturn(java.util.Optional.of(counterEntity));

        mvc.perform(get("/api/v1/counter")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").isNumber())
                .andExpect(jsonPath("quantity").isNumber())
                .andExpect(jsonPath("quantity", is(counterEntity.getQuantity())));
    }
}
