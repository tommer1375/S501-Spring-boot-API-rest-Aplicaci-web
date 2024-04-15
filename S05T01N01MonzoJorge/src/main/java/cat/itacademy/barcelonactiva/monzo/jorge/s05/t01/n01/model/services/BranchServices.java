package cat.itacademy.barcelonactiva.monzo.jorge.s05.t01.n01.model.services;
import java.util.*;


import cat.itacademy.barcelonactiva.monzo.jorge.s05.t01.n01.model.dto.BranchDTO;
import cat.itacademy.barcelonactiva.monzo.jorge.s05.t01.n01.model.domain.Branch;


public interface BranchServices {

    BranchDTO addBranch(BranchDTO branchDTO);

    BranchDTO updateBranch(Integer id, Branch branch);

    boolean deleteBranch(Integer id);

    BranchDTO getOneBranch(Integer id);

    List<BranchDTO> getAllBranch();

}
