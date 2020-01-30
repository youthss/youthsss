package board.spring.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BoardDAO {
	@Autowired
	SqlSession session;
	
	//전체 게시물
	public List<BoardVO> boardList(){
		return session.selectList("board.allboard");
		
	}
	//페이징 리스트
	public List<BoardVO> boardPaging(int[]param){
		return session.selectList("board.pagingboard", param);
	//상세 게시물 조회
	public BoardVO getBoardDetail(int seq){
		return session.selectOne("board.boarddetail",seq);
		}
	//조회수 증가
	public void updateViewcount(int seq) {
		session.update("board.plusvc", seq);
	}
	public int writeBoard() {}
	//게시물 등록
	}
	public int writeBoard(BoardVO vo) {
		return session.insert("board.insertboard", vo);
	//작성자확인 게시글 수정
	}
	public namecheck(BoardVO vo) {
		
	}
	
	
	
	}
}
