package gaa.vargas.autodealer.web.admin.autospec;

import gaa.vargas.autodealer.domain.Spec;
import gaa.vargas.autodealer.repository.SpecDao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class ProcessAutoSpecAddController extends AbstractController{
	
	private String modelAndView;
		
	private SpecDao specDao;
	

	public void setSpecDao(SpecDao specDao) {
		this.specDao = specDao;
	}


	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		
		
		for(int e=1;e<=3;e++)
		{
			Spec spec = new Spec();
			spec.setName(request.getParameter("namespec"+e).trim());
			spec.setSpec(request.getParameter("spec"+e).trim());
			
			if(((spec.getName().isEmpty())||(spec.getName()==null))&&
					(spec.getSpec().isEmpty()||(spec.getSpec()==null)))
			{
				// do nothing
			}else 
			{
				specDao.insert(spec);
			}
			
		}
		HashMap model = new HashMap();
		List<Spec> specs = specDao.findAll();
		model.put("specs",specs);	

		
		modelAndView ="web/admin/autospec/managerAutoSpec"; 

		return new ModelAndView(modelAndView,model);
	}

}
