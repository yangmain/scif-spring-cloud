package com.greenever.archetype;

import com.greenever.archetype.Bootstrap;
import com.greenever.base.common.dto.BaseRequest;
import com.greenever.base.common.dto.HeaderUserInfo;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Jimmy.Huang
 * @since 2020-03-17
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Bootstrap.class)
public class BaseTest {

    protected void fillUserInfo(BaseRequest baseRequest, long userId) {
        HeaderUserInfo headerInfo = new HeaderUserInfo();
        headerInfo.setUserId(userId);
        headerInfo.setUserName("testName");
        baseRequest.setUserInfo(headerInfo);
    }
}
