package com.cfs.BookAPI.controller;

import com.cfs.BookAPI.entity.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/books")
public class BookController {
    private Map<Long, Book> BookDB = new HashMap<>();

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks()
    {
        return ResponseEntity.ok(new ArrayList<>(BookDB.values()));
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book)
    {
        BookDB.put(book.getId(),book);
        return ResponseEntity.status(HttpStatus.CREATED).body(book);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id)
    {
      Book book = BookDB.get(id);
      if (book == null)
      {
          ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
      }
      return ResponseEntity.ok().body(book);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateBook(@PathVariable Long id, @RequestBody Book book)
    {
       Book existing= BookDB.get(id);
       if (existing==null)
       {
           ResponseEntity.status(HttpStatus.NOT_FOUND).build();
       }
       BookDB.put(book.getId(),book);
       return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Book> updatePrice(@PathVariable Long id, @RequestBody Double newPrice)
    {
        Book existing= BookDB.get(id);
        if (existing==null)
        {
            ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        existing.setPrice(newPrice);
        BookDB.put(id,existing);
        return ResponseEntity.ok(existing);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id)
    {
        Book existing= BookDB.remove(id);
        if (existing==null)
        {
            ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
