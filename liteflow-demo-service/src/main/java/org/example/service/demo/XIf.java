package org.example.service.demo;

import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeIfComponent;
@LiteflowComponent("xIf")
public class XIf extends NodeIfComponent {
    @Override
    public boolean processIf() throws Exception {
        System.out.println("--------xIf---------");
        return true;
    }
}
