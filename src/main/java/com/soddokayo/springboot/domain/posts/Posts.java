// 88~89p.
package com.soddokayo.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter // 6, 클래스 내 모든 필드에 대해 Getter method 자동생성
// ** Setter가 없음! **
// -> Entity Class는 기본적으로 Setter없이 생성자를 통해 값 채운 후 변경 필요할 땐 적절한 public 메소드 호출로!
@NoArgsConstructor // 5, 기본 생성자 자동추가 (public Posts() {})
@Entity // 1
public class Posts {    // Entity Class (실제 DB 테이블과 매칭되어, 이 객체를 수정하면 DB에 반영이된다구!)

    @Id // 2
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 3, auto-increment하려면 IDENTITY 타입 명시
    private Long id;    // Entity의 PK는 왠만하면 Long 타입의 auto-increment 추천함(mysql의 bigint)

    @Column(length = 500, nullable = false) // 4, 암것도 안써도 Column이긴한데 이렇게 속성변경할때 씀
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder // 7, 해당 클래스의 빌더 패턴 클래스 생성
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
