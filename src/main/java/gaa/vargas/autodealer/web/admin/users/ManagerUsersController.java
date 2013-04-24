/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gaa.vargas.autodealer.web.admin.users;

 import gaa.vargas.autodealer.domain.User;
import gaa.vargas.autodealer.repository.UserDao;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author gabriel
 */
public class ManagerUsersController extends AbstractController {

    private UserDao userDao;
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }




    public ManagerUsersController() {
    }
    
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception {

        String value = request.getParameter("value");
        List<User> users = new ArrayList<User>();
        if (value==null)
        {
            users = userDao.findAll();

        }else if (value.isEmpty())
        {
            users = userDao.findAll();
        }else
        {
            // call the aspect to validate the fieldname
            users = userDao.findAllOrderBy(value);
        }
        return new ModelAndView("web/admin/users/managerUsers","users",users);

    }

}