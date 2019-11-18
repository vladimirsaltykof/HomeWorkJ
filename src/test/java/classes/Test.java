package classes;


import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class Test {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private RestController controller;

    @org.junit.Test
    public void test() throws Exception {
        assertThat(controller).isNotNull();
    }

    @org.junit.Test
    public void test2() throws Exception {
        this.mockMvc.perform(get("/order/history"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("[")));
    }

    @org.junit.Test
    public void test3() throws Exception {
        this.mockMvc.perform(get("/order/transfer/1=2=50000.0"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("На счету недостаточно средств")));
    }

    @org.junit.Test
    public void test4() throws Exception {
        this.mockMvc.perform(get("/order/transfer/1=2=50.0"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Перевод успешно совершён")));
    }

}
