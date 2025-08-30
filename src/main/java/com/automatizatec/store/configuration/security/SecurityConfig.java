package com.automatizatec.store.configuration.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        // Puedes personalizar los parámetros de Argon2 o dejar los defaults
        return new Argon2PasswordEncoder(
                16,    // saltLength (recomendado >= 16)
                32,    // hashLength (recomendado >= 32)
                1,     // parallelism (número de hilos)
                1 << 12, // memory (en KB, 4096 KB = 4MB)
                3      // iterations (vueltas de cálculo)
        );
    }
}
