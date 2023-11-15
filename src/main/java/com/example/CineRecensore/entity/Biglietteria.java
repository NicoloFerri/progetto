package com.example.CineRecensore.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "biglietteria")
public class Biglietteria {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer bigliettiVenduti;
    private Double totaleIncasso;

























}
