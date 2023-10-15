package ru.my.messenger.ports;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.my.messenger.app.query.QueryMessages;
import ru.my.messenger.messaging.model.dto.MessageDTO;

import static org.springframework.http.MediaType.APPLICATION_NDJSON_VALUE;

@RestController
@RequestMapping(value = "/v1/message", produces = APPLICATION_NDJSON_VALUE)
@RequiredArgsConstructor
public class MessagingController {
    private final QueryMessages query;
    @GetMapping("/channel/{channelId}")
    public Flux<MessageDTO> getMessageInChannel(@PathVariable String channelId){
        return query.findAllByChannelId(channelId);
    }

    @GetMapping("/{id}")
    public Mono<MessageDTO> getMessageByMessageId(@PathVariable String id){
        return query.findMessageByMessageId(id);
    }

    @PostMapping("/push")
    public void pushMessage(@RequestBody Mono<MessageDTO> body){

    }
}
