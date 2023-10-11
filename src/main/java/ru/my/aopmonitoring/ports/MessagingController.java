package ru.my.aopmonitoring.ports;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.my.aopmonitoring.messaging.model.MessageDTO;

@RestController
@RequestMapping("/v1/messaging")
public class MessagingController {
    @GetMapping("/{uuid}")
    public MessageDTO get(@PathVariable String uuid){
        return MessageDTO
                .builder()
                .uuidRecipient(uuid)
                .uuidSender("mmm")
                .message("my")
                .build();
    }
}
