package pom.capgemini.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pom.capgemini.entity.Book;
import pom.capgemini.entity.BorrowRecord;
import pom.capgemini.entity.User;
import pom.capgemini.repository.BookRepository;
import pom.capgemini.repository.BorrowRecordRepository;
import pom.capgemini.repository.UserRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class BorrowRecordService {

    private final BorrowRecordRepository borrowRecordRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    public List<BorrowRecord> getAllBorrowRecords() {
        return borrowRecordRepository.findAll();
    }

    public BorrowRecord getBorrowRecordById(Long id) {
        return borrowRecordRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Borrow record not found with id: " + id));
    }

    public List<BorrowRecord> getBorrowRecordsByUserId(Long userId) {
        return borrowRecordRepository.findByUserId(userId);
    }

    public List<BorrowRecord> getActiveBorrowRecords() {
        return borrowRecordRepository.findByReturned(false);
    }

    public BorrowRecord borrowBook(Long userId, Long bookId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));

        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + bookId));

        if (!book.getAvailable()) {
            throw new RuntimeException("Book is not available: " + book.getTitle());
        }

        BorrowRecord borrowRecord = new BorrowRecord();
        borrowRecord.setUser(user);
        borrowRecord.setBook(book);
        borrowRecord.setBorrowDate(LocalDate.now());
        borrowRecord.setReturned(false);

        book.setAvailable(false);
        bookRepository.save(book);

        return borrowRecordRepository.save(borrowRecord);
    }

    public BorrowRecord returnBook(Long borrowRecordId) {
        BorrowRecord borrowRecord = getBorrowRecordById(borrowRecordId);

        if (borrowRecord.getReturned()) {
            throw new RuntimeException("Book has already been returned");
        }

        borrowRecord.setReturned(true);
        borrowRecord.setReturnDate(LocalDate.now());

        Book book = borrowRecord.getBook();
        book.setAvailable(true);
        bookRepository.save(book);

        return borrowRecordRepository.save(borrowRecord);
    }

    public void deleteBorrowRecord(Long id) {
        BorrowRecord borrowRecord = getBorrowRecordById(id);

        if (!borrowRecord.getReturned()) {
            Book book = borrowRecord.getBook();
            book.setAvailable(true);
            bookRepository.save(book);
        }

        borrowRecordRepository.delete(borrowRecord);
    }
}


