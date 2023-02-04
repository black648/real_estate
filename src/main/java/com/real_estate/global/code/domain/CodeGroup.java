package com.real_estate.global.code.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
@Table(name="codeGroup")
public class CodeGroup {
    @Id
    @Column(columnDefinition = "varchar(20)")
    private String cd;

    @OneToMany(mappedBy = "codeGroup", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<Code> codeList = new ArrayList<>();

    //그룹코드명
    @Column(columnDefinition = "varchar(100) not null")
    private String name;

    //그룹코드설명
    @Column(columnDefinition = "varchar(500)")
    private String description;

    //코드맥스레벨
    @Column(columnDefinition = "smallint not null")
    private String maxLevel;

    //사용여부
    @Column(columnDefinition = "varchar(1) default 'Y' not null")
    private String useAble;

    //정렬순서
    @Column(columnDefinition = "smallint")
    private int orderNo;
}
