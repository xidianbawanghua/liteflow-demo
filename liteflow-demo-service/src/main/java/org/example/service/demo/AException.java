package org.example.service.demo;

import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeComponent;
@LiteflowComponent("aException")
public class AException extends NodeComponent {
    @Override
    public void process() throws Exception {
        System.out.println("--------aException------");
        throw new RuntimeException("aException throw");
    }
}
