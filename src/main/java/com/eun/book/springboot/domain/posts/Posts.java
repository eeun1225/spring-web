package com.eun.book.springboot.domain.posts;

import com.eun.book.springboot.domain.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter //모든 필드의 Getter 메소드 자동생성
@NoArgsConstructor //기본 생성자 자동 추가
@Entity //테이블과 링크될 클래스임을 나타내는 어노테이션
public class Posts extends BaseTimeEntity {

    @Id //해당 테이블의 PK를 나타낸다.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK 생성 규칙
    private Long id;

    //@Column 선언하지 않아도 해당 클래스의 필드는 모두 column이 된다.
    @Column(length = 500, nullable = false) //기본값 외에 추가로 변경이 필요한 옵션이 있을 때 사용
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder //해당 클래스의 빌더 패턴 클래스 생성
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
