package com.lazyboy;

import com.alibaba.fastjson.JSONObject;
import com.lazyboy.primary.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ApplicationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void userControllerTest() throws Exception {

        //测试"/users/"GET请求
        mockMvc.perform(MockMvcRequestBuilders.get("/users/")).andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")));

        //插入数据"/users/"POST请求
        MockHttpServletRequestBuilder update = MockMvcRequestBuilders.post("/users/")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content("{\"id\":1,\"name\":\"lazyBoy\",\"age\":18}");
        mockMvc.perform(update)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("success")))
                .andDo(print())
                .andReturn()
                .getResponse();

        //查询数据"/users/{id}"GET请求
        mockMvc.perform(MockMvcRequestBuilders.get("/users/1"))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("{\"id\":1,\"name\":\"lazyBoy\",\"age\":18}")))
                .andDo(print())
                .andReturn()
                .getResponse()
                .getContentAsString();

        //修改数据"/users/{id}"PUT请求
        String userJsonReq = JSONObject.toJSONString(new User(1L, "lazyboyRobo", 20));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/users/1")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(userJsonReq);
        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("success")))
                .andDo(print())
                .andReturn()
                .getResponse();

        //删除数据"/users/{id}"DELETE请求
        mockMvc.perform(MockMvcRequestBuilders.delete("/users/1"))
                .andExpect(status().isOk()).andExpect(content().string(equalTo("success")));

        //查询user列表,结果应该为空
        mockMvc.perform(MockMvcRequestBuilders.get("/users/")).andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")))
                .andDo(print())
                .andReturn()
                .getResponse();
    }

}
