package com.capgemini.library.repository;

import com.capgemini.library.entity.LibraryBranch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryBranchRepository extends JpaRepository<LibraryBranch, Long> {
}

