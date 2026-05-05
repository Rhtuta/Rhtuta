package com.cfs.BookMyShow.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "screens")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Screen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer totalSeats;

    @OneToMany(mappedBy = "screen",cascade = CascadeType.ALL)
    private List<Show> shows;

    @ManyToOne
    @JoinColumn(name = "theater_id",nullable = false)
    private Theater theater;

    @OneToMany(mappedBy = "screen",cascade = CascadeType.ALL)
    private List<Seat> seats;
}
