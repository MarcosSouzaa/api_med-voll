package med.voll.api.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Embeddable O que ela faz: Ela diz ao JPA que essa classe não possui uma tabela própria.
 * Ela é uma "classe incorporável". Os campos abaixo serão colunas dentro da tabela de outra entidade
 */
@Embeddable
@Getter //lombok escreve os getters
@NoArgsConstructor //lombok escreve construtor sem argumentos que a JPA exige
@AllArgsConstructor //lombok escreve construtor que recebe todos os campos
public class Endereço {

    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;

    /**
     * Aqui fiz o construtor que trabalha com DTO
     */
    public Endereço(DadosEndereco dados) {
        this.logradouro = dados.logradouro();
        this.bairro = dados.bairro();
        this.cep = dados.cep();
        this.numero = dados.numero();
        this.complemento = dados.complemento();
        this.cidade = dados.cidade();
        this.uf = dados.uf();

    }
}
