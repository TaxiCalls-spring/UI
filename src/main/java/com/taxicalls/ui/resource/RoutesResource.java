package com.taxicalls.ui.resource;

import com.taxicalls.ui.model.Route;
import com.taxicalls.ui.services.RoutesService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RoutesResource {

    @Autowired
    protected RoutesService routesService;

    protected Logger logger = Logger.getLogger(RoutesResource.class.getName());

    public RoutesResource() {
        this.routesService = new RoutesService();
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
//        binder.setAllowedFields("accountNumber", "searchText");
    }

    @RequestMapping("/routes/{id}")
    public String getRoute(Model model, @PathVariable("id") Long id) {
        logger.log(Level.INFO, "getRoute() invoked: {0}", id);
        Route route = routesService.getRoute(id);
        logger.log(Level.INFO, "getRoute() found: {0}", route);
        model.addAttribute("route", route);
        return "route";
    }

    @RequestMapping("/routes")
    public String getRoutes(Model model) {
        logger.log(Level.INFO, "getRoutes() invoked");
        List<Route> routes = routesService.getRoutes();
        logger.log(Level.INFO, "getRoutes() found: {0}", routes);
        model.addAttribute("routes", routes);
        return "routes";
    }

}
