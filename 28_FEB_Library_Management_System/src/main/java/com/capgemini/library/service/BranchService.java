package com.capgemini.library.service;

import com.capgemini.library.entity.LibraryBranch;
import com.capgemini.library.exception.ResourceNotFoundException;
import com.capgemini.library.repository.LibraryBranchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BranchService {

    private final LibraryBranchRepository branchRepository;

    public List<LibraryBranch> getAllBranches() {
        return branchRepository.findAll();
    }

    public LibraryBranch getBranchById(Long branchId) {
        return branchRepository.findById(branchId)
                .orElseThrow(() -> new ResourceNotFoundException("Branch not found with id: " + branchId));
    }

    public LibraryBranch addBranch(LibraryBranch branch) {
        return branchRepository.save(branch);
    }

    public LibraryBranch updateBranch(Long branchId, LibraryBranch branch) {
        LibraryBranch existing = getBranchById(branchId);
        existing.setName(branch.getName());
        existing.setLocation(branch.getLocation());
        existing.setContactNumber(branch.getContactNumber());
        return branchRepository.save(existing);
    }

    public void deleteBranch(Long branchId) {
        branchRepository.deleteById(branchId);
    }
}

