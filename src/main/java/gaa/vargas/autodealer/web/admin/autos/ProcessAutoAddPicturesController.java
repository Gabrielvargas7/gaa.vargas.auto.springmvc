/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gaa.vargas.autodealer.web.admin.autos;

 import gaa.vargas.autodealer.domain.Auto;
import gaa.vargas.autodealer.services.file.PictureNamingUpload;
import gaa.vargas.autodealer.services.filter.FileListFilter;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author gabriel
 */
public class ProcessAutoAddPicturesController extends AbstractController {

    private HttpSession session;
    private String modelAndView; 
    private Auto auto;
    private Map<String,Object> model = new HashMap<String,Object>();
    private  boolean isMultipart;

    public ProcessAutoAddPicturesController() {
    }
    
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception
    {
        session = request.getSession();
        auto = (Auto) session.getAttribute("auto");
        //String autoid = String.valueOf(auto.getAutoid());
        modelAndView ="web/admin/autos/successAuto";
    
        isMultipart = ServletFileUpload.isMultipartContent(request);

        if (isMultipart)
        {
          FileItemFactory factory = new DiskFileItemFactory();
          ServletFileUpload upload = new ServletFileUpload(factory);
          List pictureList = null;
          String path = request.getSession().getServletContext().getRealPath("/")+"images/autos/";

          try {
                 pictureList = upload.parseRequest(request);
          } catch (FileUploadException e) {
            e.printStackTrace();
          }
          
          PictureNamingUpload.savePictures(pictureList,auto.getAutoid(), path);
        }
        
        
        String successMessage  = " auto successfully added";
        model.put("successMessage",successMessage);
        return new ModelAndView(modelAndView,model);

    	
    }
}