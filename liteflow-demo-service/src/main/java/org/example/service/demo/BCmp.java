package org.example.service.demo;

import com.yomahub.liteflow.core.NodeComponent;
import org.springframework.stereotype.Component;

@Component("b")
public class BCmp extends NodeComponent {
    @Override
    public void process() throws Exception {
        System.out.println("-----b----");
    }
}
