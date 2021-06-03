package io.github.iamraf.moviesrestapi.config;

import io.github.iamraf.moviesrestapi.entities.Movie;
import io.github.iamraf.moviesrestapi.repositories.MoviesRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class MoviesConfig {

    @Bean
    CommandLineRunner commandLineRunner(MoviesRepository repository) {
        return args -> {
            List<Movie> movies = List.of(
                    new Movie("Army of the Dead", "Following a zombie outbreak in Las Vegas, a group of mercenaries take the ultimate gamble, venturing into the quarantine zone to pull off the greatest heist ever attempted.", 2021),
                    new Movie("Eternals", "The saga of the Eternals, a race of immortal beings who lived on Earth and shaped its history and civilizations.", 2021),
                    new Movie("Cruella", "", 2021),
                    new Movie("A live-action prequel feature film following a young Cruella de Vil.", "", 2021),
                    new Movie("Wrath of Man", "The plot follows H, a cold and mysterious character working at a cash truck company responsible for moving hundreds of millions of dollars around Los Angeles each week.", 2021),
                    new Movie("A Quiet Place Part II", "Following the events at home, the Abbott family now face the terrors of the outside world. Forced to venture into the unknown, they realize the creatures that hunt by sound are not the only threats lurking beyond the sand path.", 2020),
                    new Movie("F9", "Cipher enlists the help of Jakob, Dom's younger brother to take revenge on Dom and his team.", 2021),
                    new Movie("Last Night in Soho", "A young girl, passionate about fashion design, is mysteriously able to enter the 1960s where she encounters her idol, a dazzling wannabe singer. But 1960s London is not what it seems, and time seems to fall apart with shady consequences.", 2021),
                    new Movie("The Woman in the Window", "An agoraphobic woman living alone in New York begins spying on her new neighbors, only to witness a disturbing act of violence.", 2021),
                    new Movie("Those Who Wish Me Dead", "A teenage murder witness finds himself pursued by twin assassins in the Montana wilderness with a survival expert tasked with protecting him -- and a forest fire threatening to consume them all.", 2021),
                    new Movie("The Mitchells vs the Machines", "A quirky, dysfunctional family's road trip is upended when they find themselves in the middle of the robot apocalypse and suddenly become humanity's unlikeliest last hope.", 2021));

            repository.saveAll(movies);
        };
    }
}
