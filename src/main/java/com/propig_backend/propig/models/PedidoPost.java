package com.propig_backend.propig.models;

import javax.persistence.*;
import java.io.Serializable;
import lombok.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class PedidoPost implements Serializable {
    private static final long serialVersionUID = 1L;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String nome;
    private Double preco;
    @ManyToOne
    @JoinColumn(name = "user_cnpj", referencedColumnName = "cnpj")
    private User user;


    @Override
    public String toString() {
        return "Olá, \n\nSegue abaixo os detalhes do seu pedido:\n\n" +
                "Número do pedido: " + id + "\n" +
                "Produto: " + nome + "\n" +
                "Preço: R$" + preco + "\n" +
                "CNPJ: " + user.getCnpj() + "\n\n" +
                "Agradecemos pela sua preferência!\n\n" +
                "Atenciosamente,\n" +
                "Propig";
    }
}
