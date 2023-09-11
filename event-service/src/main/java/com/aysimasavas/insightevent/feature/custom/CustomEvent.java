package com.aysimasavas.insightevent.feature.custom;


import com.aysimasavas.insightevent.data.base.Event;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "CustomEvent")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomEvent extends Event {
    // ....
    private String session;
}
