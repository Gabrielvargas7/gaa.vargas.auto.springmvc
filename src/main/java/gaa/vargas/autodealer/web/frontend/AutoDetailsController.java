package gaa.vargas.autodealer.web.frontend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import gaa.vargas.autodealer.domain.Auto;
import gaa.vargas.autodealer.domain.Spec;
import gaa.vargas.autodealer.repository.AutoDao;
import gaa.vargas.autodealer.repository.SpecDao;
import gaa.vargas.autodealer.services.find.AutoPicture;
import gaa.vargas.autodealer.services.find.AutoPictureImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class AutoDetailsController extends AbstractController{

	private int autoid;
	private AutoDao autoDao;
	private SpecDao specDao;
	private Auto auto;
	private List<Spec> spec;
	private String modelAndView;
	private Map<String,Object> model;
	
	public void setAutoDao(AutoDao autoDao) {
		this.autoDao = autoDao;
	}

	public void setSpecDao(SpecDao specDao) {
		this.specDao = specDao;
	}




	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		autoid = Integer.parseInt(request.getParameter("autoid"));
		auto = autoDao.findByAutoid(autoid);
	    spec = specDao.findAllByAutoid(autoid);
	    model = new HashMap<String,Object>();
     
	    String path = request.getSession().getServletContext().getRealPath("/")+"images/autos/";
        AutoPicture autoPicture = new AutoPictureImpl();
        List<String> pictures = new ArrayList<String>();
        pictures = autoPicture.findAllPicture(auto.getAutoid(), path);

        model.put("pictures",pictures);
        
		model.put("auto",auto);
		model.put("spec", spec);
	    modelAndView = "/web/frontend/autoDetails"; 
		return new ModelAndView(modelAndView,model);
	}
	
	

}
