package med.voll.api.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosEndereco(

        @NotBlank
        String logradouro,

        @NotBlank
        String bairro,

        @NotBlank
        @Pattern(regexp = "\\d{8}")//são 8 dígitos que compõe o CEP
        String cep,

        @NotBlank
        String cidade,

        @NotBlank
        String uf,

        //Opcional
        String complemento,

        //opcional
        String numero) {
}
