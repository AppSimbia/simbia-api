package org.upcy.simbia.api.health;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController implements HealthApi{

    @Override
    public String checkHealth() {
        return "I'm Still Standing!";
    }
}
