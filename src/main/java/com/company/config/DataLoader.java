package com.company.config;

import com.company.model.User;
import com.company.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final UserRepository userRepo;
    private final BCryptPasswordEncoder encoder;

    public DataLoader(UserRepository userRepo, BCryptPasswordEncoder encoder) {
        this.userRepo = userRepo;
        this.encoder = encoder;
    }

    @Override
    public void run(String... args) {
        if (userRepo.count() == 0) {
            userRepo.save(User.builder()
                    .username("admin")
                    .password(encoder.encode("admin123"))
                    .role("ADMIN")
                    .enabled(true)
                    .build());

            userRepo.save(User.builder()
                    .username("user")
                    .password(encoder.encode("user123"))
                    .role("USER")
                    .enabled(true)
                    .build());
        }
    }
}
