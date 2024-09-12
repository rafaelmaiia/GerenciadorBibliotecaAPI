package com.rafaelmaia.biblioteca.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "autor")
public class Autor implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome é obrigatório")
    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = true, length = 9)
    private String sexo; // opcional

    @NotBlank(message = "O ano de nascimento é obrigatório")
    @Column(name = "ano_de_nascimento", nullable = false)
    private Integer anoNascimento;

    @NotBlank(message = "O CPF é obrigatório")
    @Column(unique = true, nullable = false, length = 11)
    @Pattern(regexp = "\\d{11}", message = "O CPF deve ter 11 dígitos e conter apenas números")
    private String cpf;
}
