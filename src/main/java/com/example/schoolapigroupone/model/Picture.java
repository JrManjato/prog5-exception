package com.example.schoolapigroupone.model;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Picture {
    private UUID id;
    private String label;
    private String directory;
    private String base64;
}
