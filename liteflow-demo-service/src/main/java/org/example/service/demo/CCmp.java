package org.example.service.demo;

import com.yomahub.liteflow.core.NodeComponent;
import org.springframework.stereotype.Component;

@Component("c")
public class CCmp extends NodeComponent {
    @Override
    public void process() throws Exception {
        System.out.println("----c----");
    }
}
