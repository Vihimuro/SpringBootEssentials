package mobral.himuro.springbootessentials.service;

import lombok.RequiredArgsConstructor;
import mobral.himuro.springbootessentials.domain.Anime;
import mobral.himuro.springbootessentials.repository.AnimeRepository;
import mobral.himuro.springbootessentials.requests.AnimePostRequestBody;
import mobral.himuro.springbootessentials.requests.AnimePutRequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimeService {

    private final AnimeRepository animeRepository;
    public List<Anime> listAll(){
        return animeRepository.findAll();
    }

    public Anime findByIdOrThrowBadRequestException(long id){
        return  animeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime not Found"));
    }

    public Anime save(AnimePostRequestBody animePostRequestBody) {
        Anime anime = Anime.builder().name(animePostRequestBody.getName()).build();
        return animeRepository.save(anime);
    }

    public void delete(long id) {
        animeRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void replace(AnimePutRequestBody animePutRequestBody) {
        Anime savedAnime = findByIdOrThrowBadRequestException(animePutRequestBody.getId());
        Anime anime = Anime.builder()
                        .id(savedAnime.getId())
                        .name(animePutRequestBody.getName())
                        .build();
        animeRepository.save(anime);
    }
}
