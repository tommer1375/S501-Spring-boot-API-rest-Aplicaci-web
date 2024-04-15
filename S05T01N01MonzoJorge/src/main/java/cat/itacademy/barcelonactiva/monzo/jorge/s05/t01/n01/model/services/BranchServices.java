package cat.itacademy.barcelonactiva.monzo.jorge.s05.t01.n01.model.services;
import java.util.*;


import cat.itacademy.barcelonactiva.monzo.jorge.s05.t01.n01.model.dto.BranchDTO;
import cat.itacademy.barcelonactiva.monzo.jorge.s05.t01.n01.model.domain.Branch;


public interface BranchServices {

    BranchDTO addBranch(Branch branch);

    BranchDTO updateBranch(Branch branch);

    boolean deleteBranch(Integer id);

    BranchDTO getOneBranchDTO(Integer id);

    Branch getOneBranch (Integer id);

    List<BranchDTO> getAllBranch();

}
