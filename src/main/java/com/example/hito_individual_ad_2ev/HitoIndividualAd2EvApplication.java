package com.example.hito_individual_ad_2ev;

import com.example.hito_individual_ad_2ev.domain.Role;
import com.example.hito_individual_ad_2ev.infrastructure.database.entitites.User;
import com.example.hito_individual_ad_2ev.infrastructure.database.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HitoIndividualAd2EvApplication {

    public static void main(String[] args) {
        SpringApplication.run(HitoIndividualAd2EvApplication.class, args);
    }
}
