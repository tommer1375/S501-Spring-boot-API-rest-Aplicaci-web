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
    private BranchRepository branchRepository;

    @Override
    public BranchDTO addBranch(Branch branch) {
        return convertToDTO(branchRepository.save(branch));
    }


    @Override
    public BranchDTO updateBranch(Branch branch) {
        Optional<Branch> branchDb = branchRepository.findById(branch.getPk_BranchID());
        if (branchDb.isPresent()) {
            Branch branchUpdate = branchDb.get();
            branchUpdate.setPk_BranchID(branch.getPk_BranchID());
            branchUpdate.setNameBranch(branch.getNameBranch());
            branchUpdate.setCountryBranch(branch.getCountryBranch());
            return convertToDTO(branchRepository.save(branchUpdate));
        } else {
            throw new RuntimeException("Branch not found: " + branch.getPk_BranchID());
        }
    }
    @Override
    public boolean deleteBranch(Integer id) {
        Optional<Branch> branchDb = branchRepository.findById(id);
        if (branchDb.isPresent()){
            branchRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
    @Override
    public BranchDTO getOneBranchDTO(Integer id) {
        Optional<Branch> branchDb = branchRepository.findById(id);
        if (branchDb.isPresent()){
            return convertToDTO(branchDb.get());
        } else {
            throw new RuntimeException("Branch not found: " + id);
        }
    }

    @Override
    public Branch getOneBranch(Integer id) {
        Optional<Branch> branchDb = branchRepository.findById(id);
        if (branchDb.isPresent()){
            return branchDb.get();
        } else {
            throw new RuntimeException("Branch not found: " + id);
        }

    }

    @Override
    public List<BranchDTO> getAllBranch() {
        List<Branch> branchList = branchRepository.findAll();
        List<BranchDTO> branchDTOList = branchList.stream().map(office -> convertToDTO(office)).collect(Collectors.toList());
        return branchDTOList;
    }

    private BranchDTO convertToDTO(Branch branch) {
        return new BranchDTO(branch.getPk_BranchID(), branch.getNameBranch(), branch.getCountryBranch());
    }

}