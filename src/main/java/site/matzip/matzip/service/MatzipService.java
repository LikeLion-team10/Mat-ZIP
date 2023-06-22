package site.matzip.matzip.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import site.matzip.matzip.domain.Matzip;
import site.matzip.matzip.domain.MatzipRecommendation;
import site.matzip.matzip.dto.MatzipCreationDTO;
import site.matzip.matzip.repository.MatzipRecommendationRepository;
import site.matzip.matzip.repository.MatzipRepository;
import site.matzip.base.rsData.RsData;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MatzipService {
    private final MatzipRepository matzipRepository;
    private final MatzipRecommendationRepository matzipRecommendationRepository;

    public RsData<Matzip> create(MatzipCreationDTO creationDTO) {
        //맛집 등록
        Matzip matzip = Matzip.builder()
                .matzipName(creationDTO.getMatzipName())
                .address(creationDTO.getAddress())
                .matzipType(creationDTO.getMatzipTypeEnum())
                .phoneNumber(creationDTO.getPhoneNumber())
                .matzipRecommendations(new ArrayList<>())
                .build();
        //맛집 추천 생성
        MatzipRecommendation matzipRecommendation = MatzipRecommendation.builder()
                .rating(creationDTO.getRating())
                .description(creationDTO.getDescription())
                .matzip(matzip)
                .build();
        matzip.getMatzipRecommendations().add(matzipRecommendation);

        Matzip savedMatzip = matzipRepository.save(matzip);
        return RsData.of("S-1", "맛집이 등록 되었습니다.", savedMatzip);
    }

    public List<Matzip> findAll() {
        List<Matzip> list = matzipRepository.findAll();
        return list;
    }
}
