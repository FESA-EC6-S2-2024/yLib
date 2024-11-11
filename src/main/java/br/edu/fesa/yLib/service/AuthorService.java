package br.edu.fesa.yLib.service;

import br.edu.fesa.yLib.model.Author;
import br.edu.fesa.yLib.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    public Author findById(int id) {
        return authorRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Author not found"));
    }

    @Transactional
    public Author save(Author author) {
        return authorRepository.save(author);
    }

    @Transactional
    public Author update(int id, Author authorDetails) {
        Author author = findById(id);
        author.setName(authorDetails.getName());
        author.setCountry(authorDetails.getCountry());
        author.setBirthDate(authorDetails.getBirthDate());
        return authorRepository.save(author);
    }

    @Transactional
    public void delete(int id) {
        Author author = findById(id);
        authorRepository.delete(author);
    }
}
