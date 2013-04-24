/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gaa.vargas.autodealer.web.admin.autos;

import gaa.vargas.autodealer.domain.Auto;
import gaa.vargas.autodealer.repository.AutoDao;
import gaa.vargas.autodealer.services.find.AutoPictureGrapsImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author gabriel
 */
public class ManagerAutosController extends AbstractController {

    private AutoDao autoDao;
    private HttpSession session;
	private static final int NUMBERS_AUTO_SHOW = 4; 
	private static final int START_VALUE = 0; 
	private static final int ENABLED = 1;

    

    public void setAutoDao(AutoDao autoDao) {
        this.autoDao = autoDao;
    }


    public ManagerAutosController() {
    }
    
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception
    {

            String path = request.getSession().getServletContext().getRealPath("/")+"images/autos/";
            AutoPictureGrapsImpl autoPictureGraps;
            List<Auto> autos = new ArrayList<Auto>();

            session = request.getSession();
            Map<String,Object> model = new HashMap<String,Object>();

            String value = request.getParameter("value");
  

            if ((value==null)||(value.isEmpty()))
            {
                // get all enables autos front the database
                autos = autoDao.findAll(ENABLED);
                autoPictureGraps = new AutoPictureGrapsImpl(path,autos);
                autoPictureGraps.setNumbershowfrontend(NUMBERS_AUTO_SHOW);
                autoPictureGraps.setStartValue(START_VALUE);
                
                model.put("autos", autoPictureGraps.getNext());

                session.setAttribute("autopicturegraps",autoPictureGraps);

            }else
            {
                if (value.equals("pre"))
                {
                    autoPictureGraps =  (AutoPictureGrapsImpl) session.getAttribute("autopicturegraps");
                    model.put("autos", autoPictureGraps.getPrevious());
                    session.setAttribute("autopicturegraps",autoPictureGraps);


                }else if (value.equals("next"))
                {
                    autoPictureGraps =  (AutoPictureGrapsImpl) session.getAttribute("autopicturegraps");
                    model.put("autos", autoPictureGraps.getNext());
                    session.setAttribute("autopicturegraps",autoPictureGraps);
           
                }else
                {
                    autoPictureGraps =  (AutoPictureGrapsImpl) session.getAttribute("autopicturegraps");
                    autos = autoDao.findAllOrderByWithEnabled(value,autoPictureGraps.getEnabled());
                    autoPictureGraps.setAutos(autos);
                    autoPictureGraps.setStartValue(START_VALUE);
                    model.put("autos", autoPictureGraps.getNext());
                    session.setAttribute("autopicturegraps",autoPictureGraps);

                }
            }
            return new ModelAndView("web/admin/autos/managerAutos",model);

    }

}