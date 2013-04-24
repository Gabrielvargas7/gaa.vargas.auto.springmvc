/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gaa.vargas.autodealer.web.admin.autos;

import gaa.vargas.autodealer.repository.AutoDao;
import gaa.vargas.autodealer.repository.SpecDao;

import java.io.File;
import java.io.FilenameFilter;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
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
public class ProcessAutoDeletePicturesController extends AbstractController {

     private AutoDao autoDao;
     private SpecDao specDao;
     private String modelAndView;
     private String[] picturesArray;
  


    public void setAutoDao(AutoDao autoDao) {
        this.autoDao = autoDao;
    }

    public void setSpecDao(SpecDao specDao) {
        this.specDao = specDao;
    }


    public ProcessAutoDeletePicturesController() {
    }
    
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception
    {
        modelAndView ="web/admin/autos/successAuto";
        Map<String,Object> model = new HashMap<String,Object>();
        List<String>  pictures = new ArrayList<String>();
        picturesArray =   request.getParameterValues("picture");
     
        if (picturesArray!= null)
        {
            pictures = Arrays.asList(picturesArray);

        }
        String path = request.getSession().getServletContext().getRealPath("/")+"images/autos/";

        // delete select Pictures
        for(String picture: pictures)
        {

                File f = new File(path+picture);
                f.delete();
        }
            String successMessage  = "auto successfully added";
            model.put("successMessage",successMessage);
            return new ModelAndView(modelAndView,model);

    }




}