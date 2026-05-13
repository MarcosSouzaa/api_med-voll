package med.voll.api.controller;

import med.voll.api.medico.DadosCadastroMedico;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    //INJEÇÃO DE DEPENDÊNCIAS

    /**
     * Aqui dentro da classe controller, vou declarar como atributo privado  da classe MedicoController
     * vou chamar esse atributo de repository do tipo MedicoRepository
     * tenho que informar ao sprig que ele que conhece a interface, então ele que vai estanciar
     * esse atributo criando um objeto e passando para o controller
     * para fazer isso, coloco Autowired encima do atributo
     */
    @Autowired
    private MedicoRepository repository;


    /* vou criar um method Post sem retorno
     * o @ avisa ao Spring que se chegar uma requisição tipo Post
     * para url /medico é para chamar o method cadastrar
     * aviso ao spring pegar o json do corpo da requisição
     * Após construir o Médico Repository, vou persistir os dados no DB
     */
    @PostMapping
    @Transactional //do springFramework (preciso ter uma transação ativa com DB)
    public void cadastrar(@RequestBody DadosCadastroMedico dados) {
        /* Aqui ele pede para eu passar a entidade médico, mas eu recebo um DTO DadosCadastroMedico
         * então eu tenho que convertê-lo para um objeto do tipo médico, então vou usar um construtor
         * vou estanciar o construtor usando new, e vou receber os dados que vem do DTO
         * O id será gerado pelo banco de dados, por isso ele será nulo.
         * vou usar o parâmetro dados + '.' para coletar os dados
         * OBS: SÓ QUE É MAIS FÁCIL SE EU CRIAR O CONSTRUTOR DENTRO DA CLASSE MÉDICO
         */
        repository.save(new Medico(dados ));
    }
}
