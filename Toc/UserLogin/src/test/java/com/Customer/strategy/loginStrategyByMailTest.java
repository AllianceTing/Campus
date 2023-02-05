package com.Customer.strategy;

import com.Customer.PO.User;
import com.Customer.PiplineValidate.PipelineExecutor;
import com.Customer.PiplineValidate.UserLoginReuestContent;
import com.Customer.Service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.mockito.Mockito.*;

class loginStrategyByMailTest {
    @Mock
    PipelineExecutor pipelineExecutor;
    @Mock
    UserService userService;
    @InjectMocks
    com.Customer.strategy.loginStrategyByMail loginStrategyByMail;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testLoginStrategy() {
        when(pipelineExecutor.acceptSync(any())).thenReturn(true);
        when(userService.selectUserByEmail(anyString())).thenReturn(new User("username", Long.valueOf(1), "userAccount", "avatarUrl", Integer.valueOf(0), "userPassword", "phone", "email", Integer.valueOf(0), new GregorianCalendar(2023, Calendar.FEBRUARY, 4, 21, 6).getTime(), new GregorianCalendar(2023, Calendar.FEBRUARY, 4, 21, 6).getTime(), Integer.valueOf(0), Integer.valueOf(0)));

        boolean result = loginStrategyByMail.loginStrategy(new UserLoginReuestContent());
        Assertions.assertEquals(true, result);
    }

    @Test
    void testGetloginType() {
        LoginTypeEnum result = loginStrategyByMail.getloginType();
        Assertions.assertEquals(LoginTypeEnum.WeChatLogin, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme
