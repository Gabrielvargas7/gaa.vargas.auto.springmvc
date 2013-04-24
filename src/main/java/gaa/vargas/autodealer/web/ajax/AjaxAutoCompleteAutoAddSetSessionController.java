package gaa.vargas.autodealer.web.ajax;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class AjaxAutoCompleteAutoAddSetSessionController extends AbstractController {

	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		//session
		String brand = request.getParameter("brand");
		
		PrintWriter out = response.getWriter();

		if (brand.isEmpty()||(brand=="null"))
		{
			session.setAttribute("brand","");
			
		}else 
		{
			session.setAttribute("brand",brand);
		}
		out.println("ok");

	
		
		
		
		// TODO Auto-generated method stub
		return null;
	}

}
