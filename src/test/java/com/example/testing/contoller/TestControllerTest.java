package com.example.testing.contoller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class TestControllerTest {

    @InjectMocks
    private TestController testController;

    /*@BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }*/


    @Test
    void hello() {
        String str = testController.hello();
        assertEquals( "Application is running",str);
    }
}