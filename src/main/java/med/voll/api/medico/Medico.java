package med.voll.api.medico;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.endereco.Endereço;

/*
 * Classe Medico para ser usada JPA: Java Persistence API
 */
@Table(name = "medicos") //Define o nome da tabela no banco de dados
@Entity(name = "Medico") //Indica que esta classe é uma entidade persistente. O JPA a reconhece como algo que deve ser salvo e consultado no banco.
@Getter //lombok escreve os getters
@NoArgsConstructor //lombok escreve construtor sem argumentos que a JPA exige
@AllArgsConstructor //lombok escreve construtor que recebe todos os campos
@EqualsAndHashCode(of = "id") //gera os Equals e HashCode encima do Id e não sobre todos os atributos
public class Medico {

    /**
     * Arroba Id - Definem que o campo id é a Chave Primária
     * GenerationType.IDENTITY avisa ao banco de dados para ele mesmo gerar esse número (o famoso "auto-increment").
     */
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String crm;

    /*Enumerated(EnumType.STRING): Usada para o campo especialidade. Por padrão, o Java salva Enums como números (0, 1, 2).
     * Essa anotação com STRING força o banco a salvar o nome do texto (ex: "ORTOPEDIA"),
     */
    @Enumerated(EnumType.STRING)
    private Especialidades especialidade;

    /**
     * Embedded: Esta é a "metade" da relação com a classe Endereço. Ela diz: "Pegue os campos que estão dentro da
     * classe Endereco e coloque-os aqui dentro desta tabela".
     */
    @Embedded //incorporado
    private Endereço endereco;

    public Medico(DadosCadastroMedico dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.crm = dados.crm();
        this.especialidade = dados.especialidade();
        this.endereco = new Endereço(dados.endereco());
    }
}