package com.capgemini.library.service;

import com.capgemini.library.entity.Book;
import com.capgemini.library.entity.Loan;
import com.capgemini.library.entity.Member;
import com.capgemini.library.exception.ResourceNotFoundException;
import com.capgemini.library.repository.BookRepository;
import com.capgemini.library.repository.LoanRepository;
import com.capgemini.library.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LoanService {

    private final LoanRepository loanRepository;
    private final BookRepository bookRepository;
    private final MemberRepository memberRepository;

    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }

    public Loan getLoanById(Long loanId) {
        return loanRepository.findById(loanId)
                .orElseThrow(() -> new ResourceNotFoundException("Loan not found with id: " + loanId));
    }

    public List<Loan> getLoansByMember(Long memberId) {
        return loanRepository.findByMemberMemberId(memberId);
    }

    @Transactional
    public Loan issueBook(Long memberId, Long bookId, LocalDate dueDate) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new ResourceNotFoundException("Member not found with id: " + memberId));
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + bookId));

        if (book.getCopiesAvailable() <= 0) {
            throw new RuntimeException("No available copies for book: " + book.getTitle());
        }

        book.setCopiesAvailable(book.getCopiesAvailable() - 1);
        bookRepository.save(book);

        Loan loan = Loan.builder()
                .book(book)
                .member(member)
                .issueDate(LocalDate.now())
                .dueDate(dueDate)
                .loanStatus("ISSUED")
                .build();

        return loanRepository.save(loan);
    }

    @Transactional
    public Loan returnBook(Long loanId) {
        Loan loan = getLoanById(loanId);

        if ("RETURNED".equals(loan.getLoanStatus())) {
            throw new RuntimeException("Book already returned for loan id: " + loanId);
        }

        loan.setReturnDate(LocalDate.now());

        if (loan.getReturnDate().isAfter(loan.getDueDate())) {
            loan.setLoanStatus("LATE");
        } else {
            loan.setLoanStatus("RETURNED");
        }

        Book book = loan.getBook();
        book.setCopiesAvailable(book.getCopiesAvailable() + 1);
        bookRepository.save(book);

        return loanRepository.save(loan);
    }
}


