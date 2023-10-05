package mobral.himuro.springbootessentials.repository;

import mobral.himuro.springbootessentials.domain.Anime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimeRepository extends JpaRepository<Anime, Long> {

}
