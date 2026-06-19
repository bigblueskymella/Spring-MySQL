// 🟢4️⃣[4단계: DB 배달] 스프링 데이터 JPA의 핵심 마법! 
// 인터페이스만 만들고 JpaRepository를 상속(extends)받으면 끝남.
// 원래 서블릿이었으면 Class.forName() 쓰고 SQL문 INSERT INTO... 적고 Connection 닫고 난리 쳤어야 함.
// 스프링이 이 인터페이스를 보고 "아, 글 저장 기능(save)이랑 조회 기능(findAll) 코드를 내가 알아서 짜줄게" 하고 자동 구현함.


// 인터페이스, DB에 값 넣고 빼는 역할: 아래 기존 틀
// public class BoardRepository {
  
// }
package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

// SQL 한 줄 안 짜도 이 인터페이스가 save(), findAll() 같은 기본 메서드를 다 제공🤩
public interface BoardRepository extends JpaRepository<Board, Long> {
}
