package edu.egg.spring.service;

import edu.egg.spring.entity.BookEntity;
import edu.egg.spring.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    @Transactional
    public void create(BookEntity bookDto) {
        BookEntity book = new BookEntity();
        //book.setTotalCopies((short)(bookDto.getTotalCopies()+currentTotalCopies()));
        book.setTotalCopies(bookDto.getTotalCopies());//tiene que ser automatico

        book.setIsbn(bookDto.getIsbn());
        book.setTitle(bookDto.getTitle());
        book.setYear(bookDto.getYear());
        bookDto.setGivenCopies((short) 0);
        book.setGivenCopies(bookDto.getGivenCopies());//debe ser automatico
        book.setRemainingCopies(bookDto.getRemainingCopies());//debe ser automatico
        bookDto.setDeleted(false);
        book.setDeleted(bookDto.getDeleted());
        bookDto.setUp(true);
        book.setUp(bookDto.getUp());
        book.setAuthor(bookDto.getAuthor());
        //book.setPublisher(bookDto.getPublisher());
        bookRepository.save(book);
    }

    private short remainingCopies(short total){
        return (short) (total-given);//ver video de buscar por titulo
        //si encuentra libros prestados con el mismo titulo
        //cantidad de prestados igual a cantidad de prestados de dicho libro
    }

    @Transactional(readOnly = true)
    private short currentTotalCopies(){
        return (short)bookRepository.findAll().size();
    }


    @Transactional
    public void update(BookEntity bookDto) {
        BookEntity book = bookRepository.findById(bookDto.getId()).get();

        book.setIsbn(bookDto.getIsbn());
        book.setTitle(bookDto.getTitle());
        book.setYear(bookDto.getYear());
        book.setTitle(bookDto.getTitle());
        book.setGivenCopies(bookDto.getGivenCopies());
        book.setRemainingCopies(bookDto.getRemainingCopies());
        book.setDeleted(bookDto.getDeleted());
        book.setAuthor(bookDto.getAuthor());
       // book.setPublisher(bookDto.getPublisher());
        bookRepository.save(book);
    }

    @Transactional(readOnly = true)
    public BookEntity getById(Long id) {
        return bookRepository.findById(id).get();
    }

    @Transactional(readOnly = true)
    public List<BookEntity> getAll() {
        return bookRepository.findAll();
    }

    @Transactional
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }
}
