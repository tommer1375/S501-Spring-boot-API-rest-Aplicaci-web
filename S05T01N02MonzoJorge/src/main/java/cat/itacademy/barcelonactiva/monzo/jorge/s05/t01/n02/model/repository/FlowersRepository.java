package cat.itacademy.barcelonactiva.monzo.jorge.s05.t01.n02.model.repository;

import cat.itacademy.barcelonactiva.monzo.jorge.s05.t01.n02.model.domain.Flowers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlowersRepository extends JpaRepository <Flowers, Integer> {

}
