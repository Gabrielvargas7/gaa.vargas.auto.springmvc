package gaa.vargas.autodealer.web.admin.autospec;

import gaa.vargas.autodealer.domain.Spec;
import gaa.vargas.autodealer.repository.SpecDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class ProcessAutoSpecController extends AbstractController {

	private String modelAndView;

	private String operation;
	private String specid;
	private SpecDao specDao;

	
	
	public void setSpecDao(SpecDao specDao) {
		this.specDao = specDao;
	}


	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		modelAndView ="web/admin/autospec/managerAutoSpec"; 
		
		operation = request.getParameter("operation");
		specid = request.getParameter("spec");
		
		if (operation.equals("add new specification"))
		{
			modelAndView ="web/admin/autospec/processAutoSpecAdd"; 
		
		}else if (operation.equals("delete a specification"))
 		{
			
				if(specid!=null)
				if(!specid.isEmpty())	
				specDao.delete(Integer.parseInt(specid));
		}
		
		List<Spec> specs = specDao.findAll();
		Map model = new HashMap();
		model.put("specs",specs);	
		
		return new ModelAndView(modelAndView,model);

		
		
	}

}
