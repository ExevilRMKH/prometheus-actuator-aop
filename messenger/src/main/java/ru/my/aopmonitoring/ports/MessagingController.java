package ru.my.aopmonitoring.ports;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.my.aopmonitoring.app.query.QueryMessages;
import ru.my.aopmonitoring.messaging.model.MessageDTO;

import java.util.List;

@RestController
@RequestMapping("/v1/messaging")
@RequiredArgsConstructor
public class MessagingController {
    private final QueryMessages query;
    @GetMapping("/users/{uuid}")
    public List<MessageDTO> get(@PathVariable String uuid){
        return query.getAllMessageByUUID(uuid);
    }
}
