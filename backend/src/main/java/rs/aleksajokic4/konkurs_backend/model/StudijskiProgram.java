/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.aleksajokic4.konkurs_backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Jokic13
 */
@Entity
@Table(name = "studijski_program")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudijskiProgram {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, length = 150, unique = true)
    private String naziv;
    
    @Builder.Default
    @OneToMany(mappedBy = "studijskiProgram")
    private List<PrijavljenProgram> prijavgljeniProgrami = new ArrayList<>();
}
