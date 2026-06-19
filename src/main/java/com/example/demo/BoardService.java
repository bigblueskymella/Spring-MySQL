// 아직 안 한 곳..

// @Service // [3단계: 연산] 스프링아, 이 클래스는 우리 웹사이트의 핵심 기능(로직)을 처리하는 브레인이야!
// @RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository; // DB 관리원(Repository)을 불러옴

    public Board savePost(Board board) {
        // 회원 권한 체크, 욕설 필터링, 글자 수 제한 등 '비즈니스 검증'을 보통 여기서 처리함
        if (board.getTitle().contains("바보")) {
            throw new IllegalArgumentException("제목에 금지어가 포함되어 있습니다.");
        }
        
        return boardRepository.save(board); // 검증이 끝난 데이터를 진짜 DB 관리원에게 넘김 (4단계 이동)
    }
}
