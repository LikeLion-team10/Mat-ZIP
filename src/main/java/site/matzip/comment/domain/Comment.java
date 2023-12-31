package site.matzip.comment.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import site.matzip.base.domain.BaseEntity;
import site.matzip.member.domain.Member;
import site.matzip.review.domain.Review;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "review_id")
    private Review review;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member author;

    private String content;

    private boolean pointsRewarded;

    @Builder
    public Comment(String content) {
        this.content = content;
    }

    public void addAssociation(Review review, Member author) {
        addReview(review);
        addAuthor(author);
    }

    private void addReview(Review review) {
        if (this.review != null) {
            this.review.getComments().remove(this);
        }
        this.review = review;
        this.review.getComments().add(this);
    }

    private void addAuthor(Member author) {
        if (this.author != null) {
            this.author.getComments().remove(this);
        }
        this.author = author;
        this.author.getComments().add(this);
    }

    public void updatePointsRewarded() {
        this.pointsRewarded = true;
    }
}