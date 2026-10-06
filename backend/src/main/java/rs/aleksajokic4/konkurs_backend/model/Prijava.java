/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.aleksajokic4.konkurs_backend.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import rs.aleksajokic4.konkurs_backend.model.enums.StatusPrijave;

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
public class Prijava {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusPrijave status;
    
    @Column(name = "datum_podnosenja", nullable = false)
    private LocalDateTime datumPodnosenja;
    
    @Column(name = "datum_azuriranja")
    private LocalDateTime datumAzuriranja;
    
    @Column(name = "broj_prijave", length = 30, nullable = false, unique = true)
    private String brojPrijave;
    
    @Column(name = "napomena_admina", length = 500)
    private String napomenaAdmina;
    
    @JoinColumn(name = "kandidat_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Kandidat kandidat;
    
    @JoinColumn(name = "kadministrator_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Administrator administrator;
    
    @Builder.Default
    @OneToMany(mappedBy = "prijava", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Dokument> dokumenti = new ArrayList<>();
    
    @Builder.Default
    @OneToMany(mappedBy = "prijava", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<PrijavljenProgram> prijavljeniProgrami = new ArrayList<>();
}
