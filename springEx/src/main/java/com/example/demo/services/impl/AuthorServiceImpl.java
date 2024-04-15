package com.example.demo.services.impl;

import com.example.demo.constants.GlobalConstants;
import com.example.demo.entities.Author;
import com.example.demo.repostiroties.AuthorRepository;
import com.example.demo.services.AuthorService;
import com.example.demo.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    private AuthorRepository authorRepository;
    private FileUtil fileUtil;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository, FileUtil fileUtil) {
        this.authorRepository = authorRepository;
        this.fileUtil = fileUtil;
    }

    @Override
    public void seedAuthors() throws IOException {
        if (authorRepository.count() != 0){
            return;
        }
        String[] fileContent = fileUtil.readFileContent(GlobalConstants.AUTHOR_FILE_PATH);

        Arrays.stream(fileContent)
                .forEach(row -> {
                    String[] authorData = row.split("\\s+");
                    String firstName = authorData[0];
                    String lastName = authorData[1];
                    authorRepository.saveAndFlush(new Author(firstName,lastName));
                });
    }

    @Override
    public int getCountOfAuthors() {
        return (int) authorRepository.count();
    }

    @Override
    public Author getAuthorWithId(int id) {
        return authorRepository.findById((long) id).orElseThrow();
    }

}
