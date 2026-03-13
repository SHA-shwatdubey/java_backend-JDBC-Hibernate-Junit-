package pom.capgemini.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pom.capgemini.entity.BorrowRecord;

import java.util.List;
import java.util.Optional;

@Repository
public interface BorrowRecordRepository extends JpaRepository<BorrowRecord, Long> {

    List<BorrowRecord> findByUserId(Long userId);

    List<BorrowRecord> findByBookId(Long bookId);

    List<BorrowRecord> findByReturned(Boolean returned);

    List<BorrowRecord> findByUserIdAndReturned(Long userId, Boolean returned);

    Optional<BorrowRecord> findByBookIdAndReturnedFalse(Long bookId);
}


