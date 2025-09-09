package adopet.api.repository;

import adopet.api.model.Adocao;
import adopet.api.model.StatusAdocao;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdocaoRepository extends JpaRepository<Adocao,Long> {

    List<Adocao> status(StatusAdocao status);

    Boolean existisByPetIdAndStatus(@NotNull Long aLong, StatusAdocao statusAdocao);

    Integer countByTutorIdAndStatus(@NotNull Long aLong, StatusAdocao statusAdocao);
}
