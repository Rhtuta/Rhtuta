package com.cfs.BookMyShow.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDto {

    private Long id;
    private String title;
    private String language;
    private String description;
    private String releaseDate;
    private String genre;
    private Integer durationMins;
    private String posterUrl;
}