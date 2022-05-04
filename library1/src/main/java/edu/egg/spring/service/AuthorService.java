package edu.egg.spring.service;

import edu.egg.spring.entity.AuthorEntity;
import edu.egg.spring.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;

    @Transactional
    public void create(AuthorEntity authorDto) {
        AuthorEntity author = new AuthorEntity();
        author.setName(authorDto.getName());
        authorDto.setUp(true);
        authorDto.setDeleted(false);
        author.setUp(authorDto.getUp());
        author.setDeleted(authorDto.getDeleted());
        authorRepository.save(author);
    }

    @Transactional
    public void update(AuthorEntity authorDto) {
        AuthorEntity author = authorRepository.findById(authorDto.getId()).get();
        author.setName(authorDto.getName());
        author.setUp(authorDto.getUp());
        author.setDeleted(authorDto.getDeleted());
        authorRepository.save(author);
    }

    @Transactional(readOnly = true)
    public AuthorEntity getById(Long id) {
        return authorRepository.findById(id).get();
    }

    @Transactional(readOnly = true)
    public List<AuthorEntity> getAll() {
        return authorRepository.findAll();
    }


    @Transactional
    public void deleteById(Long id) {
        authorRepository.deleteById(id);
    }

    @Transactional
    public void up(Long id) {
        AuthorEntity author = authorRepository.findById(id).get();
        author.setUp(!author.getUp());
        authorRepository.save(author);
    }
}
