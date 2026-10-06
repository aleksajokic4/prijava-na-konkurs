/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.aleksajokic4.konkurs_backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 *
 * @author Jokic13
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Kandidat extends Korisnik{
    
    @Column(name = "broj_telefona", length = 15, nullable = false)
    private String brojTelefona;
    
    @Column(name = "datum_rodjenja", nullable = false)
    private LocalDate datumRodjenja;
    
    @Column(length = 13, nullable = false, unique = true)
    private String jmbg;
    
    @JoinColumn(name = "srednja_skola_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private SrednjaSkola srednjaSkola;
    
}
