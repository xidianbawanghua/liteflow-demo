package org.example.web;

import com.yomahub.liteflow.core.FlowExecutor;
import com.yomahub.liteflow.flow.LiteflowResponse;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class LiteFlowTest {
    @Autowired
    private FlowExecutor flowExecutor;

    @Test
    public void testLiteFlowConfig() {
        LiteflowResponse response = flowExecutor.execute2Resp("complexChain", "arg");
        Assert.assertTrue(response.isSuccess());
    }

}
