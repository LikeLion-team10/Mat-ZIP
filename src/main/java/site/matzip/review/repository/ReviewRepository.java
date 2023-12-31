package site.matzip.review.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import site.matzip.member.domain.Member;
import site.matzip.review.domain.Review;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    Page<Review> findByMatzipId(Long matzipId, Pageable pageble);

    List<Review> findByAuthor(Member author);

    @EntityGraph(attributePaths = {"author"})
    @Query("SELECT r from Review r WHERE r.createDate < :olderThanTime")
    List<Review> findReviewsOlderThan(@Param("olderThanTime") LocalDateTime olderThanTime);

    Page<Review> findByMatzipIdAndAuthorId(Long matzipId, Long authorId, Pageable pageable);
}
