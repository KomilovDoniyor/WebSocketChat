package config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import response.UserResponse;

@EnableScheduling
@Configuration
@RequiredArgsConstructor
public class SchedulerConfig {

    SimpMessagingTemplate template;

    @Scheduled(fixedDelay = 3000)
    public void sendMessage(){
        template.convertAndSend("/topic/user", new UserResponse("Fixed Delay Scheduler"));
    }
}
