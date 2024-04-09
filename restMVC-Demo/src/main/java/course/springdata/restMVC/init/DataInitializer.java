package course.springdata.restMVC.init;

import course.springdata.restMVC.dao.PostRepository;
import course.springdata.restMVC.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class DataInitializer implements CommandLineRunner {
    @Autowired
    private PostRepository postRepo;
    @Override
    public void run(String... args) throws Exception {
        if (postRepo.count() == 0) {
            postRepo.saveAll(List.of(
                    new Post("New  in spring", "Spring Boot is fancy ...", "Martin",
                            Set.of("Spring", "java", "spring boot")),
                    new Post("Reactive spring", "Web Flux is here ...", "Martin",
                            Set.of("Spring", "java", "reactor")),
                    new Post("Easy to Test", "WebTestClient is easy ...", "Martin",
                            Set.of("Spring", "java", "web test client"))
            ));
        }
    }
}
