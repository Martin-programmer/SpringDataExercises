package com.example.demo.services.impl;

import com.example.demo.constants.GlobalConstants;
import com.example.demo.entities.Author;
import com.example.demo.entities.Book;
import com.example.demo.entities.Category;
import com.example.demo.repostiroties.BookRepository;
import com.example.demo.services.AuthorService;
import com.example.demo.services.BookService;
import com.example.demo.services.CategoryService;
import com.example.demo.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Transactional
@Service
public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;
    private FileUtil fileUtil;
    private AuthorService authorService;
    private CategoryService categoryService;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, FileUtil fileUtil, AuthorService authorService
    , CategoryService categoryService) {
        this.bookRepository = bookRepository;
        this.fileUtil = fileUtil;
        this.authorService = authorService;
        this.categoryService = categoryService;
    }

    @Override
    public void seedBooks() throws IOException {
        if (bookRepository.count() != 0){
            return;
        }
        String[] fileContent = fileUtil.readFileContent(GlobalConstants.BOOKS_FILE_PATH);

        Arrays.stream(fileContent)
                .forEach(row -> {
                    String[] bookParams = row.split("\\s+");
                    int editionType = Integer.parseInt(bookParams[0]);
                    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("d/M/yyyy");
                    LocalDate date = LocalDate.parse(bookParams[1],dateTimeFormatter);
                    int copies = Integer.parseInt(bookParams[2]);
                    BigDecimal price = new BigDecimal(bookParams[3]);
                    int ageRestriction = Integer.parseInt(bookParams[4]);
                    StringBuilder sb = new StringBuilder();
                    for (int i = 5; i < bookParams.length; i++) {
                        sb.append(bookParams[i]).append(" ");
                    }
                    String title = sb.toString();
                    Book book = new Book(editionType, date, copies, price, ageRestriction, title);
                    Author author = getRandomAuthor();
                    book.setAuthor(author);
                    Set<Category> categories = getRandomCategories();
                    book.setCategories(categories);
                    bookRepository.saveAndFlush(book);
                });
    }

    @Override
    public List<Book> getAllBooksAfter2000() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
        LocalDate releaseDate = LocalDate.parse("31/12/2000",formatter);
        return this.bookRepository.findAllByReleaseDateAfter(releaseDate);
    }

    private Set<Category> getRandomCategories() {
        Set<Category> categories = new HashSet<>();
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            int categoryId = random.nextInt((categoryService.categoriesCount()-1))+1;
            categories.add(categoryService.getCategoryById(categoryId));
        }
        return categories;
    }

    private Author getRandomAuthor() {
        Random random = new Random();
        int randomValue = random.nextInt(authorService.getCountOfAuthors()) + 1;
        return authorService.getAuthorWithId(randomValue);
    }
}
