package com.example.farmingholiday.dto.host;

import com.example.farmingholiday.domain.Host;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MyPageHostDto {
    private String name;
    private Long reviewCounts;
    private double rate;

    public static MyPageHostDto from(Host entity){
        return MyPageHostDto.builder()
            .name(entity.getName())
            .reviewCounts(1L)  //TODO : 일관성을 위해서 review 테이블에서 직접 가져와야함
            .rate(entity.getRate())  //TODO : 일관성을 위해서 review 테이블에서 직접 가져와야함
            .build(); // TODO : 그런데 드는 고민 - 이걸 매번 테이블에서 가져오긴 뭐하니까 그냥 저장해두는게 좋을 것 같은데;;
    }
}