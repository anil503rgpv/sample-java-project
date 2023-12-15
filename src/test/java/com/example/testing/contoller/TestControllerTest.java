package com.example.testing.contoller;

import com.example.testing.model.Emp;
import com.example.testing.service.TestService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TestController.class)
class TestControllerTest {

    @InjectMocks
    private TestController testController;

    @MockBean
    private TestService testService;

    @Autowired
    private MockMvc mvc;

    @Test
    void hello() {
        String str = testController.hello();
        assertEquals("Application is running", str);
    }

    @Test
    void testResponse() throws Exception {
        when(testService.serviceResponse()).thenReturn("mock value");
        mvc.perform(MockMvcRequestBuilders.get("/hello")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void testCreateEmpWhenNewEmployeeThenCreated() throws Exception {
        Emp emp = new Emp("John", 1, "Hello");
        mvc.perform(MockMvcRequestBuilders.post("/createemp")
                        .content("{\"name\":\"John\",\"id\":1,\"msg\":\"Hello\"}")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    void testCreateEmpWhenExistingEmployeeThenCreated() throws Exception {
        Emp emp = new Emp("John", 1, "Hello");
        testController.createEmp(emp);
        mvc.perform(MockMvcRequestBuilders.post("/createemp")
                        .content("{\"name\":\"John\",\"id\":1,\"msg\":\"Hello\"}")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    /*@Test
    void testCreateEmpWhenExceptionThenInternalServerError() throws Exception {
        when(testService.serviceResponse()).thenThrow(new RuntimeException());
        mvc.perform(MockMvcRequestBuilders.post("/createemp")
                        .content("{\"name\":\"John\",\"id\":1,\"msg\":\"Hello\"}")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isInternalServerError());
    }*/

    @Test
    void testGetEmpWhenListNotEmptyThenOk() throws Exception {
        Emp emp = new Emp("John", 1, "Hello");
        testController.createEmp(emp);
        mvc.perform(MockMvcRequestBuilders.get("/getemp")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void testGetEmpWhenListEmptyThenOk() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/getemp")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }
}