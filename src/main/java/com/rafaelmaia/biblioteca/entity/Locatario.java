package com.rafaelmaia.biblioteca.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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
@Table(name = "locatario")
public class Locatario implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome é obrigatório")
    @Column(nullable = false, length = 80)
    private String nome;

    @Column(name = "sexo", length = 9)
    private String sexo; // opcional

    @NotBlank(message = "O telefone é obrigatório")
    @Pattern(regexp = "\\(\\d{2}\\) \\d{5}-\\d{4}", message = "O telefone deve estar no formato (XX) XXXXX-XXXX")
    @Column(nullable = false, length = 14)
    private String telefone;

    @NotBlank(message = "O email é obrigatório")
    @Email(message = "O e-mail deve ser válido")
    @Column(unique = true, nullable = false, length = 100)
    private String email;

    @NotNull
    @Past(message = "A data de nascimento deve ser uma data no passado")
    @Column(name = "data_de_nascimento", nullable = false)
    private LocalDate dataNascimento;

    @NotBlank(message = "O CPF é obrigatório")
    @Column(unique = true, nullable = false, length = 11)
    @Pattern(regexp = "\\d{11}", message = "O CPF deve ter 11 dígitos e conter apenas números")
    private String cpf;
}
