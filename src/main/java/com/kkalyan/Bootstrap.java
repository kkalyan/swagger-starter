package com.kkalyan;

import com.wordnik.swagger.model.*;
import com.wordnik.swagger.config.*;

import javax.servlet.http.HttpServlet;


public class Bootstrap extends HttpServlet {
  static {
    ApiInfo info = new ApiInfo("User App",null,null,null,null,null);
    ConfigFactory.config().setApiInfo(info);
  }
}
