package med.voll.api.controller;

import med.voll.api.medico.DadosCadastroMedico;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    /*vou criar um method Post sem retorno
   o @ avisa ao Spring que se chegar uma requisição tipo Post
    para url /medico é para chamar o method cadastrar */
    @PostMapping // aviso ao spring pegar o json do corpo da requisição
    public void cadastrar(@RequestBody DadosCadastroMedico dados) {
        System.out.println(dados);
    }
}
