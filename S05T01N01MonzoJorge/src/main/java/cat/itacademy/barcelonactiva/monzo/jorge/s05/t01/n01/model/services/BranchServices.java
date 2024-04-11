package cat.itacademy.barcelonactiva.monzo.jorge.s05.t01.n01.model.services;
import java.util.*;

import cat.itacademy.barcelonactiva.monzo.jorge.s05.t01.n01.model.dto.BranchDTO;
import cat.itacademy.barcelonactiva.monzo.jorge.s05.t01.n01.model.domain.Branch;


public interface BranchServices {

    BranchDTO addOffice(Branch branch);

    BranchDTO updateOffice(Branch branch);

    boolean deleteOffice(Integer id);

    BranchDTO getOneOffice(Integer id);

    List<BranchDTO> getAllOffice();

}
