package pom.capgemini.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pom.capgemini.entity.BorrowRecord;
import pom.capgemini.service.BorrowRecordService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/borrow")
@RequiredArgsConstructor
@Tag(name = "Borrow Records", description = "Borrow management APIs")
public class BorrowRecordController {

    private final BorrowRecordService borrowRecordService;

    @GetMapping
    @Operation(summary = "Get all borrow records")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved all borrow records"),
            @ApiResponse(responseCode = "401", description = "Unauthorized")
    })
    public ResponseEntity<List<BorrowRecord>> getAllBorrowRecords() {
        return ResponseEntity.ok(borrowRecordService.getAllBorrowRecords());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get borrow record by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved borrow record"),
            @ApiResponse(responseCode = "404", description = "Borrow record not found"),
            @ApiResponse(responseCode = "401", description = "Unauthorized")
    })
    public ResponseEntity<BorrowRecord> getBorrowRecordById(@PathVariable Long id) {
        return ResponseEntity.ok(borrowRecordService.getBorrowRecordById(id));
    }

    @GetMapping("/user/{userId}")
    @Operation(summary = "Get borrow records by user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved user's borrow records"),
            @ApiResponse(responseCode = "401", description = "Unauthorized")
    })
    public ResponseEntity<List<BorrowRecord>> getBorrowRecordsByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(borrowRecordService.getBorrowRecordsByUserId(userId));
    }

    @GetMapping("/active")
    @Operation(summary = "Get active borrow records")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved active borrow records"),
            @ApiResponse(responseCode = "401", description = "Unauthorized")
    })
    public ResponseEntity<List<BorrowRecord>> getActiveBorrowRecords() {
        return ResponseEntity.ok(borrowRecordService.getActiveBorrowRecords());
    }

    @PostMapping
    @Operation(summary = "Borrow a book")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Book borrowed successfully"),
            @ApiResponse(responseCode = "400", description = "Book not available or invalid data"),
            @ApiResponse(responseCode = "404", description = "User or Book not found"),
            @ApiResponse(responseCode = "401", description = "Unauthorized")
    })
    public ResponseEntity<BorrowRecord> borrowBook(@RequestBody Map<String, Long> request) {
        Long userId = request.get("userId");
        Long bookId = request.get("bookId");

        BorrowRecord borrowRecord = borrowRecordService.borrowBook(userId, bookId);
        return ResponseEntity.status(HttpStatus.CREATED).body(borrowRecord);
    }

    @PutMapping("/{id}/return")
    @Operation(summary = "Return a book")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Book returned successfully"),
            @ApiResponse(responseCode = "400", description = "Book already returned"),
            @ApiResponse(responseCode = "404", description = "Borrow record not found"),
            @ApiResponse(responseCode = "401", description = "Unauthorized")
    })
    public ResponseEntity<BorrowRecord> returnBook(@PathVariable Long id) {
        return ResponseEntity.ok(borrowRecordService.returnBook(id));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete borrow record")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Borrow record deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Borrow record not found"),
            @ApiResponse(responseCode = "401", description = "Unauthorized")
    })
    public ResponseEntity<Void> deleteBorrowRecord(@PathVariable Long id) {
        borrowRecordService.deleteBorrowRecord(id);
        return ResponseEntity.noContent().build();
    }
}


