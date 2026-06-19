// 자바스크립트와 연동할 API 주소창
// 사용자의 입력을 받아 😶View(UI)와 😶Model(Service와 Repository) 사이를 연결합니다
package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
// [🟢2️⃣2단계: 접수]
@RestController // 이 클래스는 HTML을 그리지 않고, 오직 JSON 데이터만 주고받는 문지기(서버) - 🟥fetch랑 대화
@RequiredArgsConstructor // 자바의 new 생성자 노가다 없이 아래 서비스를 스프링이 알아서 연결(DI)해줘 //의존성 주입(DI)을 자동으로 해줍니다.
@CrossOrigin(origins = "*") // 다른 포트(예: 5500포트 HTML)에서 요청을 보내도 보안 에러(CORS) 내지 말고 받아줘
@RequestMapping("/api/boards") // 브라우저 주소창에 /api/boards 라고 치면 이리로 찾아오게 해줘

public class BoardController {
  private final BoardRepository boardRepository; // 비즈니스 로직을 처리해 줄 서비스 대리인을 고용함

    // 1. 게시글 저장 API (Postman이나 프론트엔드에서 데이터가 넘어오면 DB에 저장)
    @PostMapping // 브라우저에서 'POST' 방식으로 요청이 들어오면 이 메서드를 실행해!
    public Board createBoard(@RequestBody Board board) { // @RequestBody: 자바스크립트가 보낸 JSON 글자를 자바의 'Board' 객체로 스프링이 중간에서 자동으로 통역해서 채워줌!
        // 원래 서블릿이었으면 req.getParameter()로 하나씩 다 꺼냈어야 했는데 스프링이 대신 해준 거야.
        return boardRepository.save(board); // 접수한 데이터를 서비스 대리인에게 넘겨서 처리하라고 시킴 (3단계 이동)
    }

    // 2. 전체 게시글 조회 API (DB에 있는 데이터를 자바 객체 통째로 리턴 -> 스프링이 알아서 JSON 배열로 변환함)
    @GetMapping
    public List<Board> getAllBoards() {
        return boardRepository.findAll();
    }
}
