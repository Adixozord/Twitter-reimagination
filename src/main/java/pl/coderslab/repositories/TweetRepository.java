package pl.coderslab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entities.Tweeg;

import java.util.List;

public interface TweetRepository extends JpaRepository<Tweeg,Long> {

    Tweeg findTweegsByUserUsername(String username);

    Tweeg findTweegsByUserId(Long id);

    List<Tweeg> getAllTweegs();


}
