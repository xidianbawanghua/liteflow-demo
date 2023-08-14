package org.example.service.demo;

import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeSwitchComponent;

@LiteflowComponent("aSwitch")
public class ASwitch extends NodeSwitchComponent {
    @Override
    public String processSwitch() throws Exception {
        System.out.println("------aSwitch------");
        return "c"; //todo:这个switch还是需要在代码里判断返回，没办法在表达式支持？
    }
}
