package board.spring.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class controllerex {
	@Autowired	
	BoardMybatisService service;
	//게시물페이지별 리스트
	@RequestMapping("/boardpaginglist")
	public ModelAndView pagingList(@RequestParam(required = false)String pagenum,
									@RequestParam(required = false )String result) {
		ModelAndView mav = new ModelAndView();
		if(pagenum == null) {
			pagenum = "1";
		}
		int pagenumI = Integer.parseInt(pagenum);
		int[] param = new int[2];
		param[0] = (pagenumI - 1) * 5 +1;
		param[1] = pagenumI *5;
		List<BoardVO> list = service.boardPaging(param);
		mav.addObject("paginglist",list);
		mav.setViewName("boardpaginglist");
		if(result != null) {
			mav.addObject("result","게시물 삭제 완료하였습니다.");
		}
		return mav;
	}
	//상세 게시물 조회
	@RequestMapping("/boarddeatil")
	public ModelAndView getBoardDetail(@RequestParam int seq,
										@RequestParam(required = false) String result) {
		ModelAndView mav = new ModelAndView();
		service.updateViewcount(seq);
		BoardVO vo = service.getBoardDetail(seq);
		if(result != null) {
			mav.addObject("result","게시물 삭제 실패하였습니다");
			}
		mav.addObject("detail",vo);
		mav.setViewName("boarddetail");
		return mav;
	}
	@RequestMapping(value = "/boardwrite", method = RequestMethod.GET)
	public ModelAndView writeBoard() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("boardwrite");
		return mav;
	}
	@RequestMapping(value = "/boardwrite", method = RequestMethod.POST)
	public ModelAndView writeBoard(BoardVO vo) {
		ModelAndView mav = new ModelAndView();
		int result = service.namecheck(vo);
		if(result !=0) {
			int a = service.writeBoard(vo);
			if (a==1) {
				mav.addObject("result","게시물 작성이 완료되었습니다.");
				mav.setViewName("boardwritesuccess");
			}
		}else
			mav.setViewName("memberinsert");
		return mav;
		}
	
	@RequestMapping(value = "/boardupdate", method = RequestMethod.GET)
	public ModelAndView boardUpdate(@RequestParam int seq,
									@RequestParam(required = false)String result) {
		ModelAndView mav = new ModelAndView();
		BoardVO vo = service.getBoardDetail(seq);
		if(result!=null) {
			mav.addObject("result","게시물 수정 실패했습니다.");
		}
		mav.addObject("result","게시물 수정 실패했습니다.");
		mav.setViewName("boardupdate");
		return mav;
		}
	@RequestMapping(value = "/boardupdate", method = RequestMethod.POST)
	public String boardUpdate(BoardVO vo) {
		String url = "";
		int result = service.boardupdate(vo);
		if (result == 1) {
			url = "redirect:/boarddetail?seq="+vo.getSeq();
		}else {
			url = "redirect:/boardupdate?seq="+vo.getSeq()+"&result=fail";
		}
		return url;
	}
	@RequestMapping(value = "/boarddelete")
	public String boardDelete(@RequestParam int seq) {
		int result = service.boarddelete(seq);
		String url = "";
		if(result == 1) {
			url = "redirect:/boardpaginglist?result=success";
		}else {
			url = "redirect:/boarddetail?seq="+ seq + "result=fail";
		}
		return url;
	}
}
		
