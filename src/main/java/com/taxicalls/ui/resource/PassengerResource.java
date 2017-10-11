package com.taxicalls.ui.resource;

import com.taxicalls.ui.model.Address;
import com.taxicalls.ui.model.Coordinate;
import com.taxicalls.ui.service.PassengerService;
import com.taxicalls.ui.model.Passenger;
import com.taxicalls.ui.model.Route;
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
public class PassengerResource {

    @Autowired
    protected PassengerService passengerService;

    protected Logger logger = Logger.getLogger(PassengerResource.class.getName());

    @InitBinder
    public void initBinder(WebDataBinder binder) {
//        binder.setAllowedFields("accountNumber", "searchText");
    }

    @RequestMapping("/passengers/{id}")
    public String getPassenger(Model model, @PathVariable("id") Integer id) {
        logger.log(Level.INFO, "getPassenger() invoked: {0}", id);
        Passenger passenger = passengerService.getPassenger(id);
        logger.log(Level.INFO, "getPassenger() found: {0}", passenger);
        model.addAttribute("passenger", passenger);
        return "passenger";
    }

    @RequestMapping("/passengers")
    public String getPassengers(Model model) {
        logger.log(Level.INFO, "getPassengers() invoked");
        List<Passenger> passengers = passengerService.getPassengers();
        logger.log(Level.INFO, "getPassengers() found: {0}", passengers);
        model.addAttribute("passengers", passengers);
        return "passengers";
    }

    @RequestMapping("/trip")
    public String trup(Model model) {
        model.addAttribute("searchCriteria", new SearchCriteria());
        return "trip";
    }

    @RequestMapping("/availableRoutes")
    public String getAvailableRoutes(Model model, SearchCriteria searchCriteria) {
        Address adressFrom = new Address(new Coordinate(searchCriteria.getAddressFrom(), searchCriteria.getAddressFrom()));
        Address addressTo = new Address(new Coordinate(searchCriteria.getAddressTo(), searchCriteria.getAddressTo()));
        Route route = new Route(adressFrom, addressTo);
        List<Route> routes = passengerService.getAvailableRoutes(route);
        model.addAttribute("routes", routes);
        return "passengers";
    }

}
