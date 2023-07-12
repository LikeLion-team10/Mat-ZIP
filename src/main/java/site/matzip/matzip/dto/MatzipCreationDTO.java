package site.matzip.matzip.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.matzip.matzip.domain.MatzipType;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MatzipCreationDTO {
    @NotBlank(message = "맛집 이름을 입력해주세요.")
    private String matzipName;
    @NotBlank(message = "맛집 주소를 입력해주세요.")
    private String address;
    @Pattern(regexp = "^\\(?(\\d{2,3})\\)?[- ]?(\\d{3,4})[- ]?(\\d{4})$",
            message = "전화번호 형식이 잘못되었습니다. (올바른 형식: 010-1234-5678 or 02-123-4567)")
    private String phoneNumber;
    @NotBlank(message = "맛집의 URL을 입력해주세요")
    private String matzipUrl;
    private Long kakaoId;
    @NotBlank(message = "맛집의 유형을 입력해주세요")
    private String matzipType;
    private String description;
    private double rating;
    private double x;
    private double y;

    public MatzipType getMatzipTypeEnum() {
        return MatzipType.valueOf(matzipType);
    }

}
