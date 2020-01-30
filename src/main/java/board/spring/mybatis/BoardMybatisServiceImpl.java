package board.spring.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class BoardMybatisServiceImpl implements BoardMybatisService{
	@Autowired
	BoardMybatisDAO dao;

	@Override
	public List<BoardVO> boardPaging(int[] param) {
		return dao.boardPaging(param);
	}

	@Override
	public BoardVO getBoardDetail(int seq) {
		return dao.getBoardDetail(seq);
	}

	@Override
	public void writeBoard() {
	}

	@Override
	public int writeBoard(BoardVO vo) {
		return dao.writeBoard(vo);
	}

	@Override
	public List<BoardVO> boardList() {
		return dao.boardList();
	}

	@Override
	public void updateViewcount(int seq) {
		dao.updateViewcount(seq);
	}

	@Override
	public int namecheck(BoardVO vo) {
		return dao.namecheck(vo);
	}

	@Override
	public void boardupdate() {
	}

	@Override
	public int boardupdate(BoardVO vo) {
		int result = 0;
		int seq = vo.getSeq();
		BoardVO check = dao.getBoardDetail(seq);
		
		int password = check.getPassword();
		if(password == vo.getPassword()) {
			result = dao.boardupdate(vo);
		}
		return result;
	}

	@Override
	public int boarddelete(int seq) {
		return dao.boarddelete(seq);
	}
	
	
	
}
