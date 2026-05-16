package com.cfs.BookMyShow.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "shows")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime startTime;

    @Column(nullable = false)
    private LocalDateTime endTime;

    @ManyToOne
    @JoinColumn(name = "screen_id", nullable = false)
    private Screen screen;

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

    @JsonIgnore
    @OneToMany(
            mappedBy = "show",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<ShowSeat> showSeats;

    @JsonIgnore
    @OneToMany(
            mappedBy = "show",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Booking> bookings;
}