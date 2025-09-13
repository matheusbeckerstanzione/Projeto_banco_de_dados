package br.com.senai.entregas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id

    //@GeneratedValue - define que a chave primaria e gerenciada pelo BD
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "usuario_id", nullable = false)
    private String UsuarioId;

    @Column(name = "nomeCompleto", nullable = false, columnDefinition = "TEXT")
    private String nomeCompleto;

    @Column(name = "email", nullable = false, columnDefinition = "TEXT", unique = true)
    private String email;

    @Column(name = "senha", nullable = false, columnDefinition = "TEXT")
    private String senha;


}
