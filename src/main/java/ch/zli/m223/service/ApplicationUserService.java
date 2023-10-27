package ch.zli.m223.service;

import java.util.Arrays;
import java.util.HashSet;

import org.eclipse.microprofile.jwt.Claims;

import ch.zli.m223.model.ApplicationUser;
import io.smallrye.jwt.build.Jwt;

public class ApplicationUserService {
    // public login(ApplicationUser applicationUser){
    //     return applicationUser;
    // }

        public static void generateToken(String[] args) {
        String token = Jwt.issuer("https://example.com/issuer")
                .upn("jdoe@quarkus.io")
                .groups(new HashSet<>(Arrays.asList("User", "Admin")))
                .claim(Claims.birthdate.name(), "2001-07-13")
                .sign();
        System.out.println(token);
    }
}
