package site.matzip.review.domain;

import jakarta.persistence.*;
import lombok.*;
import net.minidev.json.annotate.JsonIgnore;
import site.matzip.base.domain.BaseEntity;
import site.matzip.matzip.domain.Matzip;
import site.matzip.member.domain.Member;
import site.matzip.image.domain.ReviewImage;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Review extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double rating;
    private String content;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "matzip_id")
    @JsonIgnore
    private Matzip matzip;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    @JsonIgnore
    private Member author;
    @OneToMany(mappedBy = "review", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ReviewImage> reviewImages = new ArrayList<>();

    @Builder
    public Review(Matzip matzip, Member author, Long rating, String content) {
        this.matzip = matzip;
        this.author = author;
        this.rating = rating;
        this.content = content;
    }
}