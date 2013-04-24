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
import gaa.vargas.autodealer.services.encryption.PasswordService;
import gaa.vargas.autodealer.services.filter.UserFilter;
import gaa.vargas.autodealer.services.filter.UserFilterImpl;

import gaa.vargas.autodealer.services.validate.ValidateUser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author gabriel
 */
public class ChangeUserController extends AbstractController {

    UserDao userDao;
    AuthoritiesDao authoritiesDao;

    public void setAuthoritiesDao(AuthoritiesDao authoritiesDao) {
        this.authoritiesDao = authoritiesDao;
    }
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public ChangeUserController() {
    }
    
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception
    {

        //String modelAndView ="redirect:/admin/users/managerUsers.htm";
        String modelAndView ="web//admin/users/successUser";
        boolean changePassword = false;
        Map<String,Object> model = new HashMap<String,Object>();
        
        User user = new User();
        user.setUserid( Integer.parseInt(request.getParameter("userid")));
        user.setFirstname( request.getParameter("firstname"));
        user.setLastname(  request.getParameter("lastname"));
        user.setUsername(  request.getParameter("email"));
        user.setAddress(   request.getParameter("address"));
        user.setCity(      request.getParameter("city"));
        user.setState(     request.getParameter("state"));
        user.setZip(       request.getParameter("zip"));
        user.setPhone1(    request.getParameter("cellphone"));
        user.setPhone2(    request.getParameter("homephone"));
     
        String[] authorities = request.getParameterValues("authorities");
        List<String>  authos = new ArrayList<String>();
        if (authorities!= null)
        {
            authos = Arrays.asList(authorities);
        }
   
        List<Authorities> userAuthos = new ArrayList<Authorities>();
        for(String autho: authos)
        {
            Authorities singleAutho = new Authorities();
            singleAutho.setAuthority(autho);
            singleAutho.setDescription(authoritiesDao.findAuthoritiesTypeDescription(autho));
            userAuthos.add(singleAutho);
        }
        
        ValidateUser  userValidator = new ValidateUser();
        userValidator.validateUserChange(user,changePassword);
        List<Message> frontEndMessages = userValidator.getMessages();


        
        if (frontEndMessages.size()==0)
        {
            UserFilter userFilter = new UserFilterImpl();
            userFilter.toLowerCaseUserString(user);
         
            User userOldValues = userDao.findByUserId(user.getUserid());
            user.setActive(userOldValues.getActive());
            user.setEnabled(userOldValues.getEnabled());
            user.setCreated_date(userOldValues.getCreated_date());
            // Add to database
            if(changePassword)
            {
                String encryptedPassword = PasswordService.getInstance().encrypt(request.getParameter("password"));
                user.setPassword(encryptedPassword);

            }else
            {
                user.setPassword(userOldValues.getPassword());
            }

            userDao.update(user,userAuthos);
            String successMessage  = request.getParameter("email")+" user successfully change";
            model.put("successMessage",successMessage);

        }else
        {
            List<AuthoritiesType> types = new ArrayList<AuthoritiesType>();
            List<AuthoritiesTypeChecked> typesChecked = new ArrayList<AuthoritiesTypeChecked>();
            types = authoritiesDao.findAuthoritiesTypes();
            AuthoritiesChecked authoChecked = new AuthoritiesCheckedImpl();
            typesChecked = authoChecked.findAuthoritiesChecked(userAuthos, types);

            model.put("authoritiestypes",typesChecked);
            modelAndView = "web/admin/users/processChangeUser";

            model.put("user", user);
            for(Message frontEndMessage: frontEndMessages)
            {
                model.put("m"+frontEndMessage.getName(),frontEndMessage.getDescription());
            }
           return new ModelAndView(modelAndView,model);

        }
        return new ModelAndView(modelAndView,model);

    }

}