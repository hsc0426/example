package com.hsc0426.example1.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;
//ctrl + alt + o = 필요없는 import 없애주는 단축키
//ctrl + E = 최근에 작업한 파일보기

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Board {
    @Id
    @GeneratedValue
    private Long id;

    private String author;
    private String subject;
    private String content;
    private LocalDateTime createdTime;
}
