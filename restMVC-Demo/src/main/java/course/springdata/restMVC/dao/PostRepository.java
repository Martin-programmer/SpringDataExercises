package course.springdata.restMVC.dao;

import course.springdata.restMVC.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
