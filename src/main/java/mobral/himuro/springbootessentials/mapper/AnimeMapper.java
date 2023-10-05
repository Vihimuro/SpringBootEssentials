package mobral.himuro.springbootessentials.mapper;

import mobral.himuro.springbootessentials.domain.Anime;
import mobral.himuro.springbootessentials.requests.AnimePostRequestBody;
import mobral.himuro.springbootessentials.requests.AnimePutRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class AnimeMapper {
    public static final AnimeMapper INSTANCE = Mappers.getMapper(AnimeMapper.class);
    public abstract Anime toAnime(AnimePostRequestBody animePostRequestBody);
    public abstract Anime toAnime(AnimePutRequestBody animePutRequestBody);
}
