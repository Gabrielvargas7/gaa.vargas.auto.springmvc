package gaa.vargas.autodealer.web.ajax;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import gaa.vargas.autodealer.repository.AutoDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class AjaxAutoCompleteAutoAddController extends AbstractController{
	
	private AutoDao autoDao;
	private String groupValue;
	private String query;
	private List<String> autoValue;
	private String brand;
	private HttpSession session;
	public void setAutoDao(AutoDao autoDao) {
		this.autoDao = autoDao;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		session = request.getSession();
		brand = (String)session.getAttribute("brand");
		
		query = request.getParameter("q");
		query = query.toLowerCase();
		
		String value = request.getParameter("value");		
		
		if (value.equals("model")&&!(brand.isEmpty())&&(brand!="null"))
		{
			autoValue = autoDao.getGroupByFieldnameWhereValue(value,"brand",brand);
		}else 
		{
			autoValue = autoDao.getGroupByFieldname(value);
		}		
		List<String> matched = new ArrayList<String>();
		PrintWriter out = response.getWriter();
		     
		for(String auto: autoValue) {			
			String a = auto.toLowerCase();			
			if(a.startsWith(query)) {
				out.println(a);
			}
		}
		return null;
	}
	


}
