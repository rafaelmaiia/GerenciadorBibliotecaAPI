package com.rafaelmaia.biblioteca.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "livro")
public class Livro implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do livro é obrigatório")
    @Column(nullable = false)
    private String nome;

    @NotBlank(message = "O ISBN é obrigatório")
    @Column(nullable = false, unique = true)
    private String isbn;

    @NotNull
    @Past(message = "A data de publicação deve ser uma data no passado")
    @Column(name = "data_de_publicacao", nullable = false)
    private LocalDate dataPublicacao;
}
