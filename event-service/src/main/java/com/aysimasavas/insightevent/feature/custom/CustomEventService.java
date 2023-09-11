package com.aysimasavas.insightevent.feature.custom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomEventService {
    private final CustomEventRepository customEventRepository;

    @Autowired
    public CustomEventService(CustomEventRepository customEventRepository) {
        this.customEventRepository = customEventRepository;
    }

    public CustomEvent createCustomEvent(CustomEvent customEvent) {
        return customEventRepository.save(customEvent);
    }

    public CustomEvent getCustomEventById(String id) {
        Optional<CustomEvent> customEvent = customEventRepository.findById(id);
        return customEvent.orElse(null);
    }

    public List<CustomEvent> getAllCustomEvents() {
        return customEventRepository.findAll();
    }

    public CustomEvent updateCustomEvent(CustomEvent customEvent) {
        return customEventRepository.save(customEvent);
    }

    public void deleteCustomEvent(String id) {
        customEventRepository.deleteById(id);
    }
}

