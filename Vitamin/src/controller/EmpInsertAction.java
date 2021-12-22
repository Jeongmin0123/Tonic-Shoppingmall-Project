package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.emp.EmpDAO;
import model.emp.EmpVO;

public class EmpInsertAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 받아올 때 mem인지 emp인지 확인후에 진행해야 하지만 아직 이 부분이 어떻게 될 지 몰라서 두 개의 메서드로 제작 후 합칠 예정
		EmpDAO dao = new EmpDAO();
		EmpVO vo = new EmpVO();
		vo.setEno(request.getParameter("eno"));
		vo.setEname(request.getParameter("ename"));
		vo.setEgender(request.getParameter("egender"));
		vo.setEbirth(Integer.parseInt(request.getParameter("ebirth")));
		vo.setEaddr(request.getParameter("eaddr"));
		vo.setEtel(request.getParameter("etel"));
		vo.setEemail(request.getParameter("eemail"));
		vo.setId(request.getParameter("id"));
		dao.insert(vo);
		
		
		// 이 부분에 메인 페이지에서 보여줄 데이터를 설정해줘야 하는데 아직 메인페이지의 데이터 부분이 완성되지 않아 비워놨습니다.
		
		
		ActionForward forward = new ActionForward();
		forward.setPath("main.jsp");
		forward.setRedirect(false);
		return forward;
	}

}
