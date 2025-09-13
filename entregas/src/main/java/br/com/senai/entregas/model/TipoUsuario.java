package br.com.senai.entregas.model;
import jakarta.persistence.*;
import lombok.*;

// lombok
@Getter
@Setter
//obigatorio para o jpa funcionar  @NoArgsConstructor
@NoArgsConstructor
@AllArgsConstructor

//JPA
//@Entity - infiorma que essa classe e uma tabela
@Entity
//@Table - permite que vc configure a tabela
@Table(name = "tipo_usuario")
public class TipoUsuario {

    //id - define que e chave primaria
   @Id

   //@GeneratedValue - define que a chave primaria e gerenciada pelo BD
   @GeneratedValue(strategy = GenerationType.IDENTITY)

   //Column eu posso configurar minha coluna
   //name = nome da coluna
   //nullable = false - se poder se nulo ou nao
   @Column(name = "tipo_usuario_id", nullable = false)
    private String tipoUsuarioId;

   @Column(name = "descricao", nullable = false, columnDefinition = "TEXT")
    private String descricao;

}
