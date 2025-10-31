package org.upcy.simbia.api.health;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/health")
public interface HealthApi {

    @GetMapping("/check")
    String checkHealth();
}
