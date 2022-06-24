package com.example.jpademo.control;

import com.example.jpademo.dto.PublisherDto;
import com.example.jpademo.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/publisher")
public class PublisherController {

    private final PublisherService publisherService;

    @PostMapping("save")
    public PublisherDto save(@RequestBody @Valid PublisherDto publisherDto) {
        return publisherService.save(publisherDto);
    }

    @PutMapping("/{publisherId}")
    public PublisherDto update(@PathVariable Long publisherId,
                               @RequestBody @Valid PublisherDto publisherDto) {
        publisherDto.setPublisherId(publisherId);
        return publisherService.update(publisherDto);
    }

    @GetMapping("/{publisherId}")
    public PublisherDto getOne(@PathVariable Long publisherId) {
        return publisherService.getOne(publisherId);
    }

    @GetMapping
    public List<PublisherDto> getList() {
        return publisherService.getList();
    }

    @DeleteMapping("/{publisherId}")
    public void delete(@PathVariable Long publisherId) {
        publisherService.delete(publisherId);
    }

}
