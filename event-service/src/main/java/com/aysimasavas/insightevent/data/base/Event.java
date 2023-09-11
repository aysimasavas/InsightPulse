package com.aysimasavas.insightevent.data.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Map;

@Document(value = "Event")
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Event {
    @Id
    private String id;
    // provider
    private String providerId;
    // client
    private String clientId;
    // event data
    private String type;
    private String name;
    private String status;
    private Map<String, Object> params;


    @CreatedDate
    private LocalDateTime createdAt;
}
