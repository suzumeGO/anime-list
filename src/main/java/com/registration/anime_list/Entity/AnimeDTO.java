package com.registration.anime_list.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record AnimeDTO(
        @JsonProperty("pagination") Pagination pagination,
        @JsonProperty("data") List<Anime> data
) {

    public record Pagination(
            @JsonProperty("last_page") int lastPage,
            @JsonProperty("has_next_page") boolean hasNextPage,
            @JsonProperty("current_page") int currentPage,
            @JsonProperty("items") Items items
    ) {

        public record Items(
                @JsonProperty("count") int count,
                @JsonProperty("total") int total,
                @JsonProperty("per_page") int perPage
        ) {}
    }

    public record Anime(
            @JsonProperty("id") Long id,
            @JsonProperty("image_url") String imageUrl,
            @JsonProperty("small_image_url") String smallImageUrl,
            @JsonProperty("large_image_url") String largeImageUrl,
            @JsonProperty("genres") List<Genre> genres,
            @JsonProperty("studios") List<Studio> studios,
            @JsonProperty("trailer") Trailer trailer,
            @JsonProperty("title") String title,
            @JsonProperty("title_english") String titleEnglish,
            @JsonProperty("title_japanese") String titleJapanese,
            @JsonProperty("type") String type,
            @JsonProperty("source") String source,
            @JsonProperty("episodes") int episodes,
            @JsonProperty("status") String status,
            @JsonProperty("airing") boolean airing,
            @JsonProperty("aired_from") String airedFrom,
            @JsonProperty("aired_to") String airedTo,
            @JsonProperty("aired_str") String airedStr,
            @JsonProperty("duration") String duration,
            @JsonProperty("rating") String rating,
            @JsonProperty("score") double score,
            @JsonProperty("synopsis") String synopsis,
            @JsonProperty("season") String season,
            @JsonProperty("year") String year
    ) {

        public record Genre(
                @JsonProperty("id") Long id,
                @JsonProperty("name") String name,
                @JsonProperty("name_rus") String nameRus
        ) {}

        public record Trailer(
                @JsonProperty("youtube_id") String youtubeId,
                @JsonProperty("url") String url,
                @JsonProperty("embed_url") String embedUrl,
                @JsonProperty("image_url") String imageUrl,
                @JsonProperty("small_image_url") String smallImageUrl,
                @JsonProperty("medium_image_url") String mediumImageUrl,
                @JsonProperty("large_image_url") String largeImageUrl,
                @JsonProperty("max_image_url") String maximumImageUrl
        ) {}

        public record Studio(
                @JsonProperty("id") Long id,
                @JsonProperty("name") String name
        ) {}
    }
}
