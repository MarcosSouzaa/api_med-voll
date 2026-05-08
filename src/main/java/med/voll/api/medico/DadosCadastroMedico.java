package med.voll.api.medico;

import med.voll.api.endereco.DadosEndereco;

/**
 * Record criado para receber os campos que estão chegando da requisição como:
 * nome, email, crm que são finais(constantes)
 * Especialidade eu vou criar um ENUM
 */
public record DadosCadastroMedico(String nome, String email, String telefone, String crm, Especialidades especialidade, DadosEndereco endereco) {
}
