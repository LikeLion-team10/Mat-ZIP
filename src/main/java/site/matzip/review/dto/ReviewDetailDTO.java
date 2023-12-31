package site.matzip.review.dto;

import lombok.*;
import site.matzip.matzip.domain.MatzipType;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Setter
@Getter
@Builder
public class ReviewDetailDTO {

    private String profileImageUrl;
    private String matzipUrl;
    private Long reviewId;
    private Long authorId;
    private Long loginId;
    private int views;
    private String authorNickname;
    private LocalDateTime createDate;
    private String content;
    private String matzipName;
    private double rating;
    private MatzipType matzipType;
    private String address;
    private String phoneNumber;
    private int heartCount;
    private boolean isHeart;
    private Map<String, String> badgeImage;
    private List<String> imageUrls;

    public String getFormattedCreateDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return createDate.format(formatter);
    }
}