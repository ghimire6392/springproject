package com.biswas.springjanweb.core.config.security;

import org.springframework.web.client.RestTemplate;

public class RestTempGetCountriesName {

    public static void main(String[] args) {

        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject("https://restcountries.eu/rest/v2/all", String.class);
        System.out.println(response);

    }

    static class Country {

        private String name;
        private long population;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public long getPopulation() {
            return population;
        }

        public void setPopulation(long population) {
            this.population = population;
        }
    }
}
