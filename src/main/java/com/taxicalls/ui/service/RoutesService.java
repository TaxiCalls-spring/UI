package com.taxicalls.ui.service;

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
public class RoutesService {

    @Autowired
    @LoadBalanced
    protected RestTemplate restTemplate;

    protected String serviceUrl = "http://ROUTES";

    protected Logger logger = Logger.getLogger(RoutesService.class.getName());

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

    public Route getRoute(Integer id) {
        logger.log(Level.INFO, "getRoute() invoked: for {0}", id);
        return restTemplate.getForObject(serviceUrl + "/routes/{id}", Route.class, id);
    }

    public List<Route> getRoutes() {
        logger.log(Level.INFO, "getRoutes() invoked");
        return restTemplate.getForObject(serviceUrl + "/routes", List.class);
    }

}
