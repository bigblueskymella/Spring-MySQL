// 데이터베이스 테이블 역할

package com.example.demo; // 본인의 패키지 경로에 맞게 수정

import jakarta.persistence.*;
import lombok.Data;

@Entity // 🟢5️⃣[5단계: 저장소] 이 클래스 모양대로 H2 DB에 테이블이 자동으로 생깁니다!
@Data   // Lombok이 Getter, Setter를 자동으로 만들어줍니다.

public class Board {
  @Id // 이 필드가 데이터베이스의 주민등록번호(Primary Key) 역할을 할 거야
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto Increment (고유번호 자동으로 1씩 증가: 글 쓸때마다)
    private Long id;
    private String title; // DB의 TITLE 컬럼이 됨
    private String content; // DB의 CONTENT 컬럼이 됨
}

// 😶Entity/Repository 정리
// Entity = DB 테이블 모양
// Repository = DB 저장/조회 도구
// H2 Console = DB 확인 화면