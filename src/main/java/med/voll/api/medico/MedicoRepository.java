package med.voll.api.medico;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Qual é o tipo da entidade que esse atributo vai trabalhar: Medico
 * Qual é o tipo do atributo da chave primária dessa entidade: Long
 * Depois de mapeado, já posso usar no controller
 */
public interface MedicoRepository extends JpaRepository<Medico, Long> {
}
