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
import gaa.vargas.autodealer.services.find.AutoPictureImpl;
import gaa.vargas.autodealer.services.find.AutoPicture;

import gaa.vargas.autodealer.services.find.AutoPictureGrapsImpl;
import gaa.vargas.autodealer.services.validate.ValidateAuto;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author gabriel
 */
public class ProcessAutoController extends AbstractController {

    private AutoDao autoDao;
    private SpecDao specDao;
    private HttpSession session;
    private final int ENABLED = 1;
    private final int DISABLE = 0;
    private final int LASTVALUE = 0;


    public void setSpecDao(SpecDao specDao) {
        this.specDao = specDao;
    }


    public void setAutoDao(AutoDao autoDao) {
        this.autoDao = autoDao;
    }
   
   

    public ProcessAutoController() {
    }
    
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception {

            session = request.getSession();
            
            String path = request.getSession().getServletContext().getRealPath("/")+"images/autos/";
            AutoPictureGrapsImpl autoPictureGraps;
            autoPictureGraps =  (AutoPictureGrapsImpl) session.getAttribute("autopicturegraps");
            List<Auto> autos = new ArrayList<Auto>();

            Auto auto = new Auto();

            String operation = ServletRequestUtils.getStringParameter(request,"operation");
            String autoid = ServletRequestUtils.getStringParameter(request,"autoid");

            
            
           
            
            ValidateAuto autoValidator = new ValidateAuto();
            autoValidator.validateAutoDigits(autoid,"autoid");
            
            List<Message> frontEndMessage = autoValidator.getMessages();
            
            Map<String,Object> model = new HashMap<String,Object>();
            String modelAndView="index";

            if (frontEndMessage.size()==0)
            {
                auto.setAutoid(Integer.parseInt(autoid));
                session.setAttribute("auto",auto);
            }

            if (operation.equals("add a car"))
            {


                List<Spec> specs = new ArrayList<Spec>();
                // Empty spec
                List<Spec> autoSpec = new ArrayList<Spec>();

                specs = specDao.findAll();

                List<SpecChecked> specCheckedList = new ArrayList<SpecChecked>();

                AutoSpecChecked autoSpecChecked = new AutoSpecCheckedImpl();

                specCheckedList = autoSpecChecked.findSpecChecked(specs, autoSpec);
                model.put("specs",specCheckedList);

                modelAndView = "web/admin/autos/processAutoAdd";
               // modelAndView = "admin/autos/processAutoTest";


            }else if(operation.equals("disable")&&(frontEndMessage.size()==0))
            {
                modelAndView = "web/admin/autos/managerAutos";
                autoDao.disable(auto.getAutoid());

                autos =autoDao.findAll(autoPictureGraps.getEnabled());
                autoPictureGraps.setAutos(autos);

                model.put("autos",autoPictureGraps.getNext());
                session.setAttribute("autopicturegraps",autoPictureGraps);

            }else if(operation.equals("enabled")&&(frontEndMessage.size()==0))
            {
                autoDao.enabled(auto.getAutoid());
                modelAndView = "web/admin/autos/managerAutos";
                autos =autoDao.findAll(autoPictureGraps.getEnabled());
                autoPictureGraps.setAutos(autos);
                model.put("autos",autoPictureGraps.getNext());
                session.setAttribute("autopicturegraps",autoPictureGraps);

        
            }else if(operation.equals("change information")&&(frontEndMessage.size()==0))
            {
                modelAndView = "web/admin/autos/processAutoChange";

                auto = autoDao.findByAutoid(auto.getAutoid());
                model.put("auto", auto);
                String soldchecked;
                if (auto.getSold().equals("sold"))
                {
                    soldchecked = "checked";
                }else
                {
                    soldchecked = "";
                }
                model.put("soldchecked", soldchecked);

                List<Spec> specs = new ArrayList<Spec>();
                specs = specDao.findAll();
                List<Spec> autoSpec = new ArrayList<Spec>();
                autoSpec = specDao.findAllByAutoid(auto.getAutoid());
                List<SpecChecked> specCheckedList = new ArrayList<SpecChecked>();
                AutoSpecChecked autoSpecChecked = new AutoSpecCheckedImpl();
                specCheckedList = autoSpecChecked.findSpecChecked(specs, autoSpec);
                model.put("specs",specCheckedList);

            }else if(operation.equals("delete picture")&&(frontEndMessage.size()==0))
            {

                modelAndView = "web/admin/autos/processAutoDeletePictures";
                
                AutoPicture autoPicture = new AutoPictureImpl();
                //autoPicture.findAllPicture(auto.getAutoid(), path);
                
                List<String> pictures = new ArrayList<String>();
                pictures = autoPicture.findAllPicture(auto.getAutoid(), path);

                model.put("pictures",pictures);
                model.put("auto",auto);

            }

            else if(operation.equals("add picture")&&(frontEndMessage.size()==0))
            {
                model.put("auto",auto);
                modelAndView = "web/admin/autos/processAutoAddPictures";
            }
            else if(operation.equals("show disable"))
            {
                autoPictureGraps.setEnabled(DISABLE);
                autoPictureGraps.setLastvalue(LASTVALUE);

                modelAndView = "web/admin/autos/managerAutos";
                
                autos =autoDao.findAll(autoPictureGraps.getEnabled());

                autoPictureGraps.setAutos(autos);

                model.put("autos",autoPictureGraps.getNext());

                session.setAttribute("autopicturegraps",autoPictureGraps);


            }
            else if(operation.equals("show enable"))
            {
                modelAndView = "web/admin/autos/managerAutos";

                autoPictureGraps.setEnabled(ENABLED);
                autoPictureGraps.setLastvalue(LASTVALUE);

                modelAndView = "web/admin/autos/managerAutos";

                autos =autoDao.findAll(autoPictureGraps.getEnabled());

                autoPictureGraps.setAutos(autos);

                model.put("autos",autoPictureGraps.getNext());

                session.setAttribute("autopicturegraps",autoPictureGraps);

            }else
            {

                autoPictureGraps.setEnabled(ENABLED);
                autoPictureGraps.setLastvalue(LASTVALUE);

                autoDao.enabled(ENABLED);
                modelAndView = "web/admin/autos/managerAutos";
                autos =autoDao.findAll(autoPictureGraps.getEnabled());
                autoPictureGraps.setAutos(autos);
                model.put("autos",autoPictureGraps.getNext());
                session.setAttribute("autopicturegraps",autoPictureGraps);

            }

        return new ModelAndView(modelAndView, model);

    }



}