/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gaa.vargas.autodealer.web.admin.autos;


import gaa.vargas.autodealer.domain.Auto;
import gaa.vargas.autodealer.domain.Message;
import gaa.vargas.autodealer.domain.Spec;
import gaa.vargas.autodealer.domain.SpecChecked;
import gaa.vargas.autodealer.repository.AutoDao;
import gaa.vargas.autodealer.repository.SpecDao;
import gaa.vargas.autodealer.services.checked.AutoSpecChecked;
import gaa.vargas.autodealer.services.checked.AutoSpecCheckedImpl;
import gaa.vargas.autodealer.services.file.PictureNamingUpload;
import gaa.vargas.autodealer.services.filter.AutoFilter;
import gaa.vargas.autodealer.services.filter.AutoFilterImpl;

import gaa.vargas.autodealer.services.validate.ValidateAuto;

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
public class ProcessAutoAddController extends AbstractController {

     private AutoDao autoDao;
     private SpecDao specDao;


     private String modelAndView;
     private Auto auto = new Auto();

     private String[] specidArray;
     private HttpSession session;

     private String miles;
     private String price;
     private String year;
     private String filepath;
    
     
     private String soldchecked;



    public void setAutoDao(AutoDao autoDao) {
        this.autoDao = autoDao;
    }

    public void setSpecDao(SpecDao specDao) {
        this.specDao = specDao;
    }


    public ProcessAutoAddController() {
    }
    
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception
    {

        
        session = request.getSession();
     	String path = request.getSession().getServletContext().getRealPath("/")+"images/autos/";

        modelAndView ="/web/admin/autos/processAutoAddPictures";
        Map<String,Object> model = new HashMap<String,Object>();
        List<String>  specids = new ArrayList<String>();
        List<Spec> autoSpec = new ArrayList<Spec>();


        auto.setBrand(  request.getParameter("brand"));
        auto.setModel(  request.getParameter("model"));
        
        year = request.getParameter("year");
        miles = request.getParameter("miles");
        price = request.getParameter("price");
     
        specidArray =   request.getParameterValues("spec");

        // get file 
        

        
        
        java.util.Date date = new java.util.Date();
        DateFormat dateFormat = new SimpleDateFormat ("yyyy-MM-dd");
        String dateStr = dateFormat.format (date);
        auto.setBegindate(Date.valueOf(dateStr));
        auto.setEnddate(Date.valueOf(dateStr));
        auto.setSold(request.getParameter("sold"));

        soldchecked = "";
        if (auto.getSold() == null)
        {
            auto.setSold("");
            soldchecked = "";
        }else
        {
            soldchecked = "checked";
        }
        model.put("soldchecked",soldchecked);
    
        auto.setEnabled(1);
        if (specidArray!= null)
        {
            specids = Arrays.asList(specidArray);
        }
        for(String specid: specids)
        {
            Spec singleSpec = new Spec();
            singleSpec = specDao.findSpecBySpecId(Integer.parseInt(specid));
            if (!singleSpec.getName().isEmpty())
            autoSpec.add(singleSpec);
        }

        
        ValidateAuto  autoValidator = new ValidateAuto();

        
        autoValidator.validateAutoDigits(year,"year");
        List<Message> frontEndMessages = autoValidator.getMessages();
           
     
        if (frontEndMessages.size()==0)
            auto.setYear(Integer.parseInt(year));
        else  auto.setYear(0);
        
   
        
        autoValidator.clearMessages();
        autoValidator.validateAutoDigits(miles,"miles");        
        frontEndMessages = autoValidator.getMessages();
        
        if (frontEndMessages.size()==0)
            auto.setMiles(Integer.parseInt(miles));
        else 
            auto.setMiles(0);
        
        autoValidator.clearMessages();
        autoValidator.validateAutoDecimal(price,"price");
        frontEndMessages = autoValidator.getMessages();
        
        if (frontEndMessages.size()==0)
            auto.setPrice(Double.parseDouble(price));
        else
            auto.setPrice(0.0);
        
        autoValidator.clearMessages();
        autoValidator.validateAutoAdd(auto);
        frontEndMessages = autoValidator.getMessages();
        
        
        if ((frontEndMessages.size()==0))
        {
            // Add to database
        	
        	
            AutoFilter autoFilter = new AutoFilterImpl();
            autoFilter.toLowerCaseAutoString(auto);

            autoDao.insert(auto, autoSpec);
            model.put("auto",auto);
            session.setAttribute("auto",auto);
            String successMessage  = "auto successfully added";
            model.put("successMessage",successMessage);
        }else
        {
            modelAndView = "admin/autos/processAutoAdd";

            // set the Selected specs
            List<Spec> specs = new ArrayList<Spec>();
            specs = specDao.findAll();
            List<SpecChecked> specCheckedList = new ArrayList<SpecChecked>();
            AutoSpecChecked autoSpecChecked = new AutoSpecCheckedImpl();
            specCheckedList = autoSpecChecked.findSpecChecked(specs, autoSpec);
            model.put("specs",specCheckedList);
            model.put("auto", auto);

            for(Message frontEndMessage: frontEndMessages)
            {
                model.put("m"+frontEndMessage.getName(),frontEndMessage.getDescription());
            }

        }
            return new ModelAndView(modelAndView,model);

    }




}