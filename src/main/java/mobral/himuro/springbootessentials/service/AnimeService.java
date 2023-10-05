package mobral.himuro.springbootessentials.service;

import lombok.RequiredArgsConstructor;
import mobral.himuro.springbootessentials.domain.Anime;
import mobral.himuro.springbootessentials.exception.BadRequestException;
import mobral.himuro.springbootessentials.mapper.AnimeMapper;
import mobral.himuro.springbootessentials.repository.AnimeRepository;
import mobral.himuro.springbootessentials.requests.AnimePostRequestBody;
import mobral.himuro.springbootessentials.requests.AnimePutRequestBody;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimeService {

    private final AnimeRepository animeRepository;
    public Page<Anime> listAll(Pageable pageable){
        return animeRepository.findAll(pageable);
    }
    public List<Anime> findByName(String name){
        return animeRepository.findByName(name);
    }

    public Anime findByIdOrThrowBadRequestException(long id){
        return  animeRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Anime not Found"));
    }


    @Transactional
    public Anime save(AnimePostRequestBody animePostRequestBody) {
        return animeRepository.save(AnimeMapper.INSTANCE.toAnime(animePostRequestBody));
    }

    public void delete(long id) {
        animeRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void replace(AnimePutRequestBody animePutRequestBody) {
        Anime savedAnime = findByIdOrThrowBadRequestException(animePutRequestBody.getId());
        Anime anime = AnimeMapper.INSTANCE.toAnime(animePutRequestBody);
        anime.setId(savedAnime.getId());
        animeRepository.save(anime);
    }
}
