package org.example.web;

import lombok.Data;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ElTest {
    ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal();

    @Test
    public void testEl() {
        Map<String, Object> map = new HashMap<>();
        User user = new User();
        user.setName("zhangsan");
        user.setAge(16);
        map.put("user", user);
        threadLocal.set(map);
        Map<String, Object> threadVal = threadLocal.get();

        EvaluationContext context = new StandardEvaluationContext();
        for (String key : threadVal.keySet()) {
            context.setVariable(key, threadVal.get(key));
        }

        ExpressionParser parser = new SpelExpressionParser();
        Expression expression= parser.parseExpression("#user.name");
        Object value = expression.getValue(context);
        System.out.println(value);
    }


}

@Data
class User {
    private String name;
    private int age;
}