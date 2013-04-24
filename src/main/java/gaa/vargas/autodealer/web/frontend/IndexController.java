package gaa.vargas.autodealer.web.frontend;

import gaa.vargas.autodealer.domain.Auto;
import gaa.vargas.autodealer.domain.AutoWithPictures;
import gaa.vargas.autodealer.repository.AutoDao;
import gaa.vargas.autodealer.services.find.AutoPictureGraps;
import gaa.vargas.autodealer.services.find.AutoPictureGrapsImpl;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class IndexController extends AbstractController {

	private static final int NUMBERS_AUTO_SHOW = 12; 
	private static final int START_VALUE = 0; 
	private static final int ENABLED = 1;
	private static final String ASCENDING = "ASC";
	private static final String DESCENDING = "DESC";
	private static final String ALL_AUTOS = "all_autos";
	
	private String modelAndView;
	private HttpSession session;
	private AutoDao autoDao;
	private Map<String,Object> model;
	private String order_ascending_descending;
	private String path;
	private String value;
	private Set brands;
	private String filter_value;
	List<Auto> autos;
	
	public void setAutoDao(AutoDao autoDao) {
		this.autoDao = autoDao;
	}

	public IndexController() {
			// TODO Auto-generated constructor stub
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		modelAndView ="index";
		
		
        path = request.getSession().getServletContext().getRealPath("/")+"images/autos/";
        AutoPictureGrapsImpl autoPictureGrapsFrontEnd;
        autos = new ArrayList<Auto>();

        session = request.getSession();
        model = new HashMap<String,Object>();
        
        // get all brand ordered and unique  
        brands = new TreeSet();
        brands = autoDao.findAllBrands();
        model.put("brands", brands);
        
        value = request.getParameter("frontend_value");
        filter_value = request.getParameter("filter_value");
        if ((filter_value==null)||(filter_value.isEmpty()))
        {
        	filter_value = ALL_AUTOS; 
        }
        
        order_ascending_descending = (String) session.getAttribute("order_ascending_descending");
        
        
        if ((value==null)||(value.isEmpty()))
        {
            // get all enables autos front the database
        	order_ascending_descending = ASCENDING;
        	
        	if (filter_value.equals(ALL_AUTOS))
            {
        		autos = autoDao.findAll(ENABLED);
            }else 
            {
            	autos = autoDao.findByFilter(ENABLED,filter_value);
            }
            
          
        	
            autoPictureGrapsFrontEnd = new AutoPictureGrapsImpl(path,autos);
            autoPictureGrapsFrontEnd.setNumbershowfrontend(NUMBERS_AUTO_SHOW);
            autoPictureGrapsFrontEnd.setStartValue(START_VALUE);
            this.setFrontEndModel(autoPictureGrapsFrontEnd.getNext());
       
            session.setAttribute("autopicturegrapsFrontEnd",autoPictureGrapsFrontEnd);
            session.setAttribute("order_ascending_descending",order_ascending_descending);
            
        }else
        {
            if (value.equals("pre"))
            {
                autoPictureGrapsFrontEnd =  (AutoPictureGrapsImpl) session.getAttribute("autopicturegrapsFrontEnd");
                this.setFrontEndModel(autoPictureGrapsFrontEnd.getPrevious());  
                //model.put("autos", autoPictureGraps.getPrevious());
                session.setAttribute("autopicturegrapsFrontEnd",autoPictureGrapsFrontEnd);


            }else if (value.equals("next"))
            {
                autoPictureGrapsFrontEnd =  (AutoPictureGrapsImpl) session.getAttribute("autopicturegrapsFrontEnd");
                this.setFrontEndModel(autoPictureGrapsFrontEnd.getNext());
                
                //model.put("autos", autoPictureGraps.getNext());
                session.setAttribute("autopicturegrapsFrontEnd",autoPictureGrapsFrontEnd);
       
            }else
            {
            	order_ascending_descending = (String) session.getAttribute("order_ascending_descending");
                
            	if(order_ascending_descending.equals(ASCENDING))
            	{	
            		order_ascending_descending = DESCENDING;
            	}else 
            	{
            		order_ascending_descending = ASCENDING;
            	}
            	
            	
                autoPictureGrapsFrontEnd =  (AutoPictureGrapsImpl) session.getAttribute("autopicturegrapsFrontEnd");
                
            	if (filter_value.equals(ALL_AUTOS))
                {
            		autos = autoDao.findAllOrderByWithEnabledAscDesc(value,autoPictureGrapsFrontEnd.getEnabled(),order_ascending_descending);
                }else
            	{
                	autos = autoDao.findByFilterOrderByWithEnabledAscDesc(value,autoPictureGrapsFrontEnd.getEnabled(),order_ascending_descending,filter_value);
            	}
                
                
                autoPictureGrapsFrontEnd.setAutos(autos);
                autoPictureGrapsFrontEnd.setLastvalue(0);
                autoPictureGrapsFrontEnd.setStartValue(START_VALUE);
                this.setFrontEndModel(autoPictureGrapsFrontEnd.getNext());
                session.setAttribute("autopicturegrapsFrontEnd",autoPictureGrapsFrontEnd);
                session.setAttribute("order_ascending_descending",order_ascending_descending);

            }
        }
       
        
		return new ModelAndView(modelAndView,model);

	}
	
	private void setFrontEndModel(List<AutoWithPictures> autoWithPicturesList)
	{
         int x = 0;
         for (AutoWithPictures autoWithPictures :autoWithPicturesList)
         {	
         	x++;
         	model.put("autoid_"+x,autoWithPictures.getAutoid());
         	model.put("brand_"+x,autoWithPictures.getBrand());
         	model.put("miles_"+x,autoWithPictures.getMilesFormat());
         	model.put("model_"+x,autoWithPictures.getModel());
         	model.put("price_"+x,autoWithPictures.getPriceCurrency());
         	model.put("sold_"+x,autoWithPictures.getSold());
         	model.put("year_"+x,autoWithPictures.getYear());
         	
         	for (String picture:autoWithPictures.getPictures()) 
         	{
         		model.put("mainpicture_"+x,picture);
         	}
         }
    
	}

}
