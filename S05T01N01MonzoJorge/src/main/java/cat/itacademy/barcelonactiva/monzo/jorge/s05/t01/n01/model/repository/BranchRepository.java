package cat.itacademy.barcelonactiva.monzo.jorge.s05.t01.n01.model.repository;

import cat.itacademy.barcelonactiva.monzo.jorge.s05.t01.n01.model.domain.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepository extends JpaRepository <Branch, Integer> {


}
