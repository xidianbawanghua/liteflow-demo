package org.example.rpc;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("${a.b.demo}")
public interface DemoFeignClient {
}
