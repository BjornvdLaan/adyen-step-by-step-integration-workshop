package com.adyen.workshop.configurations;

import com.adyen.Client;
import com.adyen.Config;
import com.adyen.enums.Environment;
import com.adyen.service.checkout.PaymentsApi;
import com.adyen.util.HMACValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DependencyInjectionConfiguration {
    private final ApplicationConfiguration applicationConfiguration;

    public DependencyInjectionConfiguration(ApplicationConfiguration applicationConfiguration) {
        this.applicationConfiguration = applicationConfiguration;
    }

    @Bean
    Client client() {
        // Step 4
        var config = new Config();
        return new Client(config);
    }

    @Bean
    PaymentsApi paymentsApi(){
        // Step 4
        return new PaymentsApi(client());
    }

    @Bean
    HMACValidator hmacValidator() {
        // Step 4
        return new HMACValidator();
    }
}
