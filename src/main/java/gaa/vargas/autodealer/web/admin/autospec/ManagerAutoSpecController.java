package gaa.vargas.autodealer.web.admin.autospec;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import gaa.vargas.autodealer.domain.Spec;
import gaa.vargas.autodealer.repository.SpecDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class ManagerAutoSpecController extends AbstractController {

	private String modelAndView;
	private List<Spec> specs;
	private Map model;
	
	private SpecDao specDao;
	
	public void setSpecDao(SpecDao specDao) {
		this.specDao = specDao;
	}



	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		modelAndView ="web/admin/autospec/managerAutoSpec"; 
		model = new HashMap();
		specs = specDao.findAll();
		model.put("specs",specs);
		
		return new ModelAndView(modelAndView,model);
	}

}
