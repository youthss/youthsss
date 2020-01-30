package board.spring.mybatis;

import java.util.List;

public interface BoardMybatisService {

	//모든 게시물 조회
	public List<BoardVO> boardList();
	
	//게시판 페이징
	public List<BoardVO> boardPaging(int[] param);
	
	//상세게시물 조회
	public BoardVO getBoardDetail(int seq);
	
	//조회수 증가
	public void updateViewcount(int seq);
	
	//게시물 등록 화면
	public void writeBoard();
	
	//게시물 등록
	public int writeBoard(BoardVO vo);
	
	//작성자 조회
	public int namecheck(BoardVO vo);
	
	//게시물 수정
	public void boardupdate();
	public int boardupdate(BoardVO vo);
	
	//게시물 삭제
	public int boarddelete(int seq);
}
