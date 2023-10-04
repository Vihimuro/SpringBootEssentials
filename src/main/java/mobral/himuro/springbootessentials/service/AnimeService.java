package mobral.himuro.springbootessentials.service;

import mobral.himuro.springbootessentials.domain.Anime;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimeService {
    public List<Anime> listAll(){
        return List.of(new Anime(1L,"HxH"), new Anime(2L,"One Piece"));
    }
}
