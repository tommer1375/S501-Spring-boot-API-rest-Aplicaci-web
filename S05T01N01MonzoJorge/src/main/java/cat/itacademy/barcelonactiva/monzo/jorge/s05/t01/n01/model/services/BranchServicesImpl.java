package cat.itacademy.barcelonactiva.monzo.jorge.s05.t01.n01.model.services;

import cat.itacademy.barcelonactiva.monzo.jorge.s05.t01.n01.model.domain.Branch;
import cat.itacademy.barcelonactiva.monzo.jorge.s05.t01.n01.model.dto.BranchDTO;
import cat.itacademy.barcelonactiva.monzo.jorge.s05.t01.n01.model.repository.BranchRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BranchServicesImpl implements BranchServices {

    @Autowired
    private final BranchRepository branchRepository;

    @Override
    public BranchDTO addBranch(BranchDTO branchDTO) {

        if (branchRepository.existsBynameBranchAndcountryBranch(branchDTO.getNameBranch(), branchDTO.getCountryBranch())) {
            throw new RuntimeException("Ya existe una sucursal con el mismo nombre y país.");

        } else {
            Branch branch = DTOtoEntity(branchDTO);
            branch = branchRepository.save(branch);
            return EntitytoDTO(branch);
        }

    }
    @Override
    public BranchDTO updateBranch (int id, BranchDTO branchDTO){


    }

    @Override
    public BranchDTO getOneBranch (int id){
        Branch findingBranch = branchRepository.findById(id).orElse(null);
        return (findingBranch  != null) ? EntitytoDTO(findingBranch ) : null;
    }

    @Override
    public List<BranchDTO> getAllBranch() {
        List<Branch> branchs = branchRepository.findAll();
        return branchs.stream()
                .map(BranchServicesImpl::EntitytoDTO)
                .collect(Collectors.toList());
    }

    private static Branch DTOtoEntity(BranchDTO branchDTO) {
        Branch branch = new Branch();
        branch.setPk_BranchID(branchDTO.getPk_BranchID());
        branch.setNameBranch(branchDTO.getNameBranch());
        branch.setCountryBranch(branchDTO.getCountryBranch());
        return branch;
    }
    private static BranchDTO EntitytoDTO (Branch branch) {
        BranchDTO branchDTO = new BranchDTO();
        branchDTO.setPk_BranchID(branch.getPk_BranchID());
        branchDTO.setNameBranch(branch.getNameBranch());
        branchDTO.setCountryBranch(branch.getCountryBranch());
        branchDTO.setTypeBranch(branchDTO.checkCountryBranch());
        return branchDTO;
    }

}
