package ru.test.project.pushcount;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import ru.test.project.pushcount.entities.CounterEntity;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
public class JsonTests {
    @Autowired
    private JacksonTester<CounterEntity> jackson;

    @Test
    public void jsonSerializationTest() throws Exception {
        CounterEntity  counterEntity = new CounterEntity();
        counterEntity.setId(1L);
        counterEntity.setQuantity(1);
        // {
        //   "id": 1,
        //   "quantity": 1
        // }
        assertThat(this.jackson.write(counterEntity)).hasJsonPathNumberValue("$.id");
        assertThat(this.jackson.write(counterEntity)).extractingJsonPathNumberValue("$.quantity").isEqualTo(1);
    }

    @Test
    public void jsonDeserializationTest() throws Exception {
        String content = "{\"id\": 1,\"quantity\": 1}";
        CounterEntity counterEntity = new CounterEntity();
        counterEntity.setId(1L);
        counterEntity.setQuantity(1);

        assertThat(this.jackson.parse(content)).isEqualTo(counterEntity);
        assertThat(this.jackson.parseObject(content).getQuantity()).isEqualTo(1);
    }
}
