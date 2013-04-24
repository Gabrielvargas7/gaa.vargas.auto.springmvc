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
public class CreateUserController extends AbstractController {

    UserDao userDao;
    AuthoritiesDao authoritiesDao;

    public void setAuthoritiesDao(AuthoritiesDao authoritiesDao) {
        this.authoritiesDao = authoritiesDao;
    }
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public CreateUserController() {
    }
    
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception
    {

        //String modelAndView ="redirect:/admin/users/managerUsers.htm";
        String modelAndView ="web/admin/users/successUser";
        
        Map<String,Object> model = new HashMap<String,Object>();
        
        User user = new User();
        user.setFirstname( request.getParameter("firstname"));
        user.setLastname(  request.getParameter("lastname"));
        user.setUsername(  request.getParameter("email"));
        user.setPassword(  request.getParameter("password"));
        user.setAddress(   request.getParameter("address"));
        user.setCity(      request.getParameter("city"));
        user.setState(     request.getParameter("state"));
        user.setZip(       request.getParameter("zip"));
        user.setPhone1(    request.getParameter("cellphone"));
        user.setPhone2(    request.getParameter("homephone"));
        user.setEnabled(1);
        user.setActive("yes");

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
        userValidator.validateUserAdd(user);
        List<Message> frontEndMessages = userValidator.getMessages();
        
        
        if (frontEndMessages.size()==0)
        {
            // Add to database
            String encryptedPassword = PasswordService.getInstance().encrypt( request.getParameter("password"));
            user.setPassword(encryptedPassword);
            UserFilter userFilter = new UserFilterImpl();
            userFilter.toLowerCaseUserString(user);
            userDao.insert(user, userAuthos);
            String successMessage  = request.getParameter("email")+" user successfully added";
            model.put("successMessage",successMessage);
        }else
        {
            List<AuthoritiesType> types = new ArrayList<AuthoritiesType>();
            List<AuthoritiesTypeChecked> typesChecked = new ArrayList<AuthoritiesTypeChecked>();
            types = authoritiesDao.findAuthoritiesTypes();

            AuthoritiesChecked authoChecked = new AuthoritiesCheckedImpl();
            typesChecked = authoChecked.findAuthoritiesChecked(userAuthos, types);

            model.put("authoritiestypes",typesChecked);
            modelAndView = "web/admin/users/processAddUser";
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