package com.biswas.springjanweb.core.config.security;

import com.biswas.springjanweb.user.entity.User;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuthUtil {

    public static User getLoggedUser() {

        //logged in users object
        //logged in user's information - userDetailBean
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetailBean) {
                                                //casting
            UserDetailBean userDetailBean = (UserDetailBean) principal;
            return userDetailBean.getUser();
        }
        return null;

    }
}
