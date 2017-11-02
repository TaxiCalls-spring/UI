package com.taxicalls.ui.services;

import com.taxicalls.ui.model.Passenger;
import com.taxicalls.ui.model.Route;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PassengerService {

    @Autowired
    @LoadBalanced
    protected RestTemplate restTemplate;

    protected String serviceUrl = "http://PASSENGER";

    protected Logger logger = Logger.getLogger(PassengerService.class.getName());

    /**
     * The RestTemplate works because it uses a custom request-factory that uses
     * Ribbon to look-up the service to use. This method simply exists to show
     * this.
     */
    @PostConstruct
    public void demoOnly() {
        // Can't do this in the constructor because the RestTemplate injection
        // happens afterwards.
        logger.log(Level.WARNING, "The RestTemplate request factory is {0}", restTemplate.getRequestFactory().getClass());
    }

    public Passenger getPassenger(Long id) {
        logger.log(Level.INFO, "getPassenger() invoked: for {0}", id);
        return restTemplate.getForObject(serviceUrl + "/passengers/{id}", Passenger.class, id);
    }

    public List<Passenger> getPassengers() {
        logger.log(Level.INFO, "getPassengers() invoked");
        return restTemplate.getForObject(serviceUrl + "/passengers", List.class);
    }

    public List<Route> getAvailableRoutes(Route route) {
        logger.log(Level.INFO, "getAvailableRoutes() invoked");
        return restTemplate.postForObject(serviceUrl + "/trip", route, List.class);
    }
    
    public void chooseDriver(Route route) {
        logger.log(Level.INFO, "getAvailableRoutes() invoked", route);
        restTemplate.postForObject(serviceUrl + "/chooseDriver", route, Route.class);
    }

}
