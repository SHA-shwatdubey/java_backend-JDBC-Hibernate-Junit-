package com.capgemini.library.controller;

import com.capgemini.library.entity.LibraryBranch;
import com.capgemini.library.service.BranchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/branches")
@RequiredArgsConstructor
public class BranchController {

    private final BranchService branchService;

    @PostMapping
    public ResponseEntity<LibraryBranch> createBranch(@RequestBody LibraryBranch branch) {
        return new ResponseEntity<>(branchService.addBranch(branch), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LibraryBranch> getBranchById(@PathVariable Long id) {
        return ResponseEntity.ok(branchService.getBranchById(id));
    }

    @GetMapping
    public ResponseEntity<List<LibraryBranch>> listBranches() {
        return ResponseEntity.ok(branchService.getAllBranches());
    }

    @PutMapping("/{id}")
    public ResponseEntity<LibraryBranch> updateBranch(@PathVariable Long id, @RequestBody LibraryBranch branch) {
        return ResponseEntity.ok(branchService.updateBranch(id, branch));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBranch(@PathVariable Long id) {
        branchService.deleteBranch(id);
        return ResponseEntity.noContent().build();
    }
}

