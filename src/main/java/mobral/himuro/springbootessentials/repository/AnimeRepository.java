package mobral.himuro.springbootessentials.repository;

import mobral.himuro.springbootessentials.domain.Anime;

import java.util.List;

public interface AnimeRepository {
    List<Anime> listAll();
}
