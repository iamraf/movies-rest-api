package io.github.iamraf.moviesrestapi.config;

import io.github.iamraf.moviesrestapi.entities.Movie;
import io.github.iamraf.moviesrestapi.entities.User;
import io.github.iamraf.moviesrestapi.repositories.MoviesRepository;
import io.github.iamraf.moviesrestapi.repositories.UsersRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DataConfig {

    @Bean
    CommandLineRunner commandLineRunner(MoviesRepository moviesRepository, UsersRepository usersRepository) {
        return args -> {
            List<Movie> movies = List.of(
                    new Movie("Army of the Dead", "Following a zombie outbreak in Las Vegas, a group of mercenaries take the ultimate gamble, venturing into the quarantine zone to pull off the greatest heist ever attempted.", 2021),
                    new Movie("Eternals", "The saga of the Eternals, a race of immortal beings who lived on Earth and shaped its history and civilizations.", 2021),
                    new Movie("Cruella", "A live-action prequel feature film following a young Cruella de Vil.", 2021),
                    new Movie("Wrath of Man", "The plot follows H, a cold and mysterious character working at a cash truck company responsible for moving hundreds of millions of dollars around Los Angeles each week.", 2021),
                    new Movie("A Quiet Place Part II", "Following the events at home, the Abbott family now face the terrors of the outside world. Forced to venture into the unknown, they realize the creatures that hunt by sound are not the only threats lurking beyond the sand path.", 2020),
                    new Movie("F9", "Cipher enlists the help of Jakob, Dom's younger brother to take revenge on Dom and his team.", 2021),
                    new Movie("Last Night in Soho", "A young girl, passionate about fashion design, is mysteriously able to enter the 1960s where she encounters her idol, a dazzling wannabe singer. But 1960s London is not what it seems, and time seems to fall apart with shady consequences.", 2021),
                    new Movie("The Woman in the Window", "An agoraphobic woman living alone in New York begins spying on her new neighbors, only to witness a disturbing act of violence.", 2021),
                    new Movie("Those Who Wish Me Dead", "A teenage murder witness finds himself pursued by twin assassins in the Montana wilderness with a survival expert tasked with protecting him -- and a forest fire threatening to consume them all.", 2021),
                    new Movie("The Mitchells vs the Machines", "A quirky, dysfunctional family's road trip is upended when they find themselves in the middle of the robot apocalypse and suddenly become humanity's unlikeliest last hope.", 2021),
                    new Movie("Spiral", "A criminal mastermind unleashes a twisted form of justice in Spiral, the terrifying new chapter from the book of Saw.", 2021),
                    new Movie("The Tomorrow War", "A family man is drafted to fight in a future war where the fate of humanity relies on his ability to confront the past.", 2021),
                    new Movie("Old", "This summer, visionary filmmaker M. Night Shyamalan unveils a chilling, mysterious new thriller about a family on a tropical holiday who discover that the secluded beach where they are relaxing for a few hours is somehow causing them to age rapidly - reducing their entire lives into a single day.", 2021),
                    new Movie("Mortal Kombat", "MMA fighter Cole Young seeks out Earth's greatest champions in order to stand against the enemies of Outworld in a high stakes battle for the universe.", 2021),
                    new Movie("The Unholy", "A hearing-impaired girl is visited by the Virgin Mary and can suddenly hear, speak, and heal the sick. As people flock to witness her miracles, terrifying events unfold. Are they the work of the Virgin Mary or something much more sinister?", 2021),
                    new Movie("A Quiet Place", "In a post-apocalyptic world, a family is forced to live in silence while hiding from monsters with ultra-sensitive hearing.", 2018),
                    new Movie("Jungle Cruise", "Based on Disneyland's theme park ride where a small riverboat takes a group of travelers through a jungle filled with dangerous animals and reptiles but with a supernatural element.", 2021),
                    new Movie("The Conjuring: The Devil Made Me Do It", "The Warrens investigate a murder that may be linked to a demonic possession.", 2021),
                    new Movie("Nobody", "A bystander who intervenes to help a woman being harassed by a group of men becomes the target of a vengeful drug lord.", 2021),
                    new Movie("Zack Snyder's Justice League", "Determined to ensure Superman's ultimate sacrifice was not in vain, Bruce Wayne aligns forces with Diana Prince with plans to recruit a team of metahumans to protect the world from an approaching threat of catastrophic proportions.", 2021));

            moviesRepository.saveAll(movies);

            List<User> users = List.of(
                    new User("test", "test", "test@test.com"),
                    new User("Kappa", "Keepo", "kappakeepo@gmail.com"));

            usersRepository.saveAll(users);
        };
    }
}
