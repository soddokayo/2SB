// 61~62p.
package com.soddokayo.springboot.web;

import org.junit.jupiter.api.Test;                  // 거지같은 JUnit4에서 JUnit5로의 migrating 1
import org.junit.jupiter.api.extension.ExtendWith;  // 거지같은 JUnit4에서 JUnit5로의 migrating 2
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
// import org.springframework.test.context.junit4.SpringRunner; // 얘는 어째야하지?
import org.springframework.test.context.junit.jupiter.SpringExtension; // 이렇게 바꾸나? 맞네
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class) // 1, JUnit4 to 5
@WebMvcTest(controllers = HelloController.class) // 2, JUnit4 to 5
public class HelloControllerTest {

    @Autowired // 3
    private MockMvc mvc; // 4

    @Test
    public void hello가_리턴된다() throws Exception{
        String hello = "징용hi";

        mvc.perform(get("/hello"))  // 5
                .andExpect(status().isOk())  // 6
                .andExpect(content().string(hello)); // 7
    }
}
