package com.taxicalls.ui;

import com.taxicalls.ui.services.PassengerService;
import com.taxicalls.ui.resource.PassengerResource;
import com.taxicalls.ui.resource.HomeController;
import com.taxicalls.ui.resource.RoutesResource;
import com.taxicalls.ui.services.RoutesService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(useDefaultFilters = false) // Disable component scanner
public class WebServer {

    /**
     * Run the application using Spring Boot and an embedded servlet engine.
     *
     * @param args Program arguments - ignored.
     */
    public static void main(String[] args) {
        SpringApplication.run(WebServer.class, args);
    }

    /**
     * A customized RestTemplate that has the ribbon load balancer build in.
     * Note that prior to the "Brixton"
     *
     * @return
     */
    @LoadBalanced
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public PassengerService passengerService() {
        return new PassengerService();
    }

    @Bean
    public PassengerResource passengerResource() {
        return new PassengerResource();
    }

    @Bean
    public RoutesService routesService() {
        return new RoutesService();
    }

    @Bean
    public RoutesResource routesResource() {
        return new RoutesResource();
    }

    @Bean
    public HomeController homeController() {
        return new HomeController();
    }
}
