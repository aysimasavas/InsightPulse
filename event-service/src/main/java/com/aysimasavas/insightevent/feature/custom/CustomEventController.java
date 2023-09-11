package com.aysimasavas.insightevent.feature.custom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event/custom")
public class CustomEventController {
    private final CustomEventService customEventService;

    @Autowired
    public CustomEventController(CustomEventService customEventService) {
        this.customEventService = customEventService;
    }

    @PostMapping
    public ResponseEntity<CustomEvent> createCustomEvent(@RequestBody CustomEvent customEvent) {
        CustomEvent createdCustomEvent = customEventService.createCustomEvent(customEvent);
        return new ResponseEntity<>(createdCustomEvent, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomEvent> getCustomEventById(@PathVariable String id) {
        CustomEvent customEvent = customEventService.getCustomEventById(id);
        if (customEvent != null) {
            return new ResponseEntity<>(customEvent, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<CustomEvent>> getAllCustomEvents() {
        List<CustomEvent> customEvents = customEventService.getAllCustomEvents();
        return new ResponseEntity<>(customEvents, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<CustomEvent> updateCustomEvent(@RequestBody CustomEvent customEvent) {
        CustomEvent updatedCustomEvent = customEventService.updateCustomEvent(customEvent);
        return new ResponseEntity<>(updatedCustomEvent, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomEvent(@PathVariable String id) {
        customEventService.deleteCustomEvent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
