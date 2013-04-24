/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gaa.vargas.autodealer.web.admin.users;


import gaa.vargas.autodealer.domain.Authorities;
import gaa.vargas.autodealer.domain.AuthoritiesType;
import gaa.vargas.autodealer.domain.AuthoritiesTypeChecked;
import gaa.vargas.autodealer.domain.Message;
import gaa.vargas.autodealer.domain.User;
import gaa.vargas.autodealer.repository.AuthoritiesDao;
import gaa.vargas.autodealer.repository.UserDao;
import gaa.vargas.autodealer.services.checked.AuthoritiesChecked;
import gaa.vargas.autodealer.services.checked.AuthoritiesCheckedImpl;
import gaa.vargas.autodealer.services.validate.ValidateUser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author gabriel
 */
public class ProcessUserController extends AbstractController {

    UserDao userDao;
    	AuthoritiesDao authoritiesDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setAuthoritiesDao(AuthoritiesDao authoritiesDao) {
        this.authoritiesDao = authoritiesDao;
    }


    public ProcessUserController() {
    }
    
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception {

            String operation = ServletRequestUtils.getStringParameter(request,"operation");
            String userid = ServletRequestUtils.getStringParameter(request,"userid");
            
            
            ValidateUser userValidator = new ValidateUser();
            userValidator.validateNotNullorEmptyUserId(userid);
            List<Message> frontEndMessage = userValidator.getMessages();
            
            
            
            Map<String,Object> model = new HashMap<String,Object>();
            String modelAndView="index";
   
            if (operation.equals("add"))
            {
                List<Authorities> userAuthos = new ArrayList<Authorities>();
                List<AuthoritiesType> types = new ArrayList<AuthoritiesType>();
                List<AuthoritiesTypeChecked> typesChecked = new ArrayList<AuthoritiesTypeChecked>();
                types = authoritiesDao.findAuthoritiesTypes();
                AuthoritiesChecked authoChecked = new AuthoritiesCheckedImpl();
                typesChecked = authoChecked.findAuthoritiesChecked(userAuthos, types);
                model.put("authoritiestypes",typesChecked);
                modelAndView = "web/admin/users/processAddUser";

            }else if(operation.equals("disable")&&(frontEndMessage.size()==0))
            {
                int userID = Integer.parseInt(userid);
                userDao.disable(userID);
                modelAndView = "web/admin/users/successUser";

            }else if(operation.equals("enabled")&&(frontEndMessage.size()==0))
            {
                int userID = Integer.parseInt(userid);
                userDao.enabled(userID);
                modelAndView = "web/admin/users/successUser";

            }else if(operation.equals("change")&&(frontEndMessage.size()==0))
            {
                User user = userDao.findByUserId(Integer.parseInt(userid));
                List<Authorities> userAuthos = authoritiesDao.findAllAuthoritiesOfUsername(user.getUserid());

                List<AuthoritiesType> types = new ArrayList<AuthoritiesType>();
                List<AuthoritiesTypeChecked> typesChecked = new ArrayList<AuthoritiesTypeChecked>();
                types = authoritiesDao.findAuthoritiesTypes();
               
                AuthoritiesChecked authoChecked = new AuthoritiesCheckedImpl();
                typesChecked = authoChecked.findAuthoritiesChecked(userAuthos, types);
                model.put("authoritiestypes",typesChecked);
                model.put("user", user);
                modelAndView = "web/admin/users/processChangeUser";

            }else if(operation.equals("change password")&&(frontEndMessage.size()==0))
            {
                User user = userDao.findByUserId(Integer.parseInt(userid));
                model.put("user", user);
                modelAndView = "web/admin/users/processChangePasswordUser";

            }else
            {
                modelAndView = "web/admin/users/processUser";
                String errorMessage = "Error: Please ask your administrator";
                model.put("errorMessage",errorMessage);
            }

        return new ModelAndView(modelAndView, model);



    }

}