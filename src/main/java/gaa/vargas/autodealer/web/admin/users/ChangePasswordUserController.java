/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gaa.vargas.autodealer.web.admin.users;


 import gaa.vargas.autodealer.domain.Message;
import gaa.vargas.autodealer.domain.User;
import gaa.vargas.autodealer.repository.UserDao;
import gaa.vargas.autodealer.services.encryption.PasswordService;

import gaa.vargas.autodealer.services.validate.ValidateUser;

import java.util.ArrayList;
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
public class ChangePasswordUserController extends AbstractController {

    UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public ChangePasswordUserController() {
    }
    
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception
    {


        String modelAndView ="web/admin/users/successUser";
        boolean changePassword = true;
        Map<String,Object> model = new HashMap<String,Object>();
        
        User user = new User();
        user.setUserid( Integer.parseInt(request.getParameter("userid")));
        User userOldValues = userDao.findByUserId(user.getUserid());
        user = userOldValues;
        user.setPassword(  request.getParameter("password"));

        ValidateUser  userValidator = new ValidateUser();
        userValidator.validateUserPassword(user.getPassword());
        List<Message> frontEndMessages = userValidator.getMessages();

        if (frontEndMessages.size()==0)
        {
            String encryptedPassword = PasswordService.getInstance().encrypt(request.getParameter("password"));
            user.setPassword(encryptedPassword);
            userDao.changePassword(user);
            String successMessage  = user.getUsername()+" user successfully change";
            model.put("successMessage",successMessage);
        }else
        {
           modelAndView = "web/admin/users/processChangePasswordUser";
            model.put("user", user);
            for(Message frontEndMessage: frontEndMessages)
            {
                model.put("m"+frontEndMessage.getName(),frontEndMessage.getDescription());
            }
        }
        return new ModelAndView(modelAndView,model);

    }

}