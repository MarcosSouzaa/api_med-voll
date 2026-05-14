package med.voll.api.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.endereco.DadosEndereco;

/**
 * Record criado para receber os campos que estão chegando da requisição como:
 * nome, email, telefone, crm que são finais(constantes)
 * Especialidade eu vou criar um ENUM
 * endereço, vou criar um Record que poderá ser usado por outras classes
 */
public record DadosCadastroMedico(
        @NotBlank //ele não pode ser nulo e vir em branco
        String nome,

        @NotBlank
        @Email
        String email,

        @NotBlank
        String telefone,

        @NotBlank
        @Pattern(regexp = "\\d{4,6}") //expressão Regular de 4 a 6 dígitos
        String crm,

        @NotNull //aqui é um ENUM já validado pelo Spring, não usa NotBlank porque não é String
        Especialidades especialidade,

        @NotNull
        @Valid //porque ele é um DTO e preciso que ele seja validado
        DadosEndereco endereco) {
}
