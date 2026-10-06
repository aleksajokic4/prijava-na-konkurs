/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.aleksajokic4.konkurs_backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumeratedValue;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rs.aleksajokic4.konkurs_backend.model.enums.TipDokumenta;

/**
 *
 * @author Jokic13
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Dokument {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "datum_otpremanja", nullable = false)
    private LocalDateTime datumOtpremanja;
    
    @Column(name = "originalni_naziv_fajla", nullable = false, length = 150)
    private String originalniNaziv;
    
    @Column(nullable = false, length = 255)
    private String putanja;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipDokumenta tip;
    
    @Column(name = "tip_sadrzaja", length = 50)
    private String tipSadrzaja;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "prijava_id", nullable = false)
    private Prijava prijava;
    
}
