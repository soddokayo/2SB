// 96~97p. save, findAll 기능 테스트
package com.soddokayo.springboot.domain.posts;

// 이제 JUnit4 to JUnit5 migration은 식은죽먹기지!
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @AfterEach // JUnit4에서 After은 단위테스트 끝날때마다 수행하는 메소드지정임. AfterEach랑 동일!
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {
        //given
        String title = "나는 천재개발자다";
        String content = "아무도 그 사실을 모른다";

        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("soddokayo@gmail.com")
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }

}
