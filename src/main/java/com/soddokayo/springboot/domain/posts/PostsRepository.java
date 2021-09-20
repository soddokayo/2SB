// 94p.
package com.soddokayo.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long>{
    // DB Layer 접근자임. JpaRepository 상속하면 기본적인 CRUD 메소드가 자동 생성됨. @Repository도 필요없음
}
