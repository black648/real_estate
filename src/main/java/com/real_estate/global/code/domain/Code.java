package com.real_estate.global.code.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
@Table(name="code")
public class Code {
    @Id
    @Column(columnDefinition = "varchar(20)")
    private String cd;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "groupCd", insertable = false, updatable = false)
    private CodeGroup codeGroup;

    @Column(columnDefinition = "varchar(5)")
    private String groupCd;

    @Column(columnDefinition = "varchar(20)")
    private String parentCd;

    //레벨
    @Column(columnDefinition = "smallint")
    private int level;

    //코드명
    @Column(columnDefinition = "varchar(20)")
    private String name;

    //코드설명
    @Column(columnDefinition = "varchar(300)")
    private String description;

    //사용여부
    @Column(columnDefinition = "varchar(1) default 'Y' not null")
    private String useAble;

    //정렬순서
    @Column(columnDefinition = "smallint")
    private int orderNo;
}
