package com.real_estate.global.code.dto;

import com.real_estate.global.code.domain.Code;
import com.real_estate.global.code.domain.CodeGroup;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CodeResponseDto {
    private String cd;
    private CodeGroup codeGroup;
    private String groupCd;
    private String parentCd;
    private int level;
    private String name;
    private String description;
    private String useAble;
    private int orderNo;

    @Builder
    public CodeResponseDto(Code code) {
        this.cd = code.getCd();
        this.codeGroup = code.getCodeGroup();
        this.groupCd = code.getGroupCd();
        this.parentCd = code.getParentCd();
        this.level = code.getLevel();
        this.name = code.getName();
        this.description = code.getDescription();
        this.useAble = code.getUseAble();
        this.orderNo = code.getOrderNo();
    }
}
