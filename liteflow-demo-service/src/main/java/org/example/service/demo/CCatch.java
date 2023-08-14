package org.example.service.demo;

import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeComponent;
@LiteflowComponent("cCatch")
public class CCatch extends NodeComponent {

    @Override
    public void process() throws Exception {
        System.out.println("---------cCatch---------");
//        throw new RuntimeException("cCatch throw");
    }
}
