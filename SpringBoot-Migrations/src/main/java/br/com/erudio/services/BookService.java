package br.com.erudio.services;

import br.com.erudio.converter.DozerConverter;
import br.com.erudio.data.model.Book;
import br.com.erudio.data.model.Person;
import br.com.erudio.data.vo.v1.BookVO;
import br.com.erudio.data.vo.v1.PersonVO;
import br.com.erudio.exception.ResourceNotFoundException;
import br.com.erudio.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository repository;

    public BookVO create(BookVO bookVO) {
        Book entity = DozerConverter.parseObject(bookVO, Book.class);
        return DozerConverter.parseObject(repository.save(entity), BookVO.class);
    }

    public BookVO update(BookVO bookVO) {
        Book entity = repository.findById(bookVO.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));
        entity.setAuthor(bookVO.getAuthor());
        entity.setPrice(bookVO.getPrice());
        entity.setTitle(bookVO.getTitle());
        entity.setLaunchDate(bookVO.getLaunchDate());
        return DozerConverter.parseObject(repository.save(entity), BookVO.class);
    }

    public void delete(Integer id) {
        Book entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));
        repository.delete(entity);
    }

    public BookVO findById(Integer id) {
        return DozerConverter.parseObject(repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this id")), BookVO.class);
    }

    public List<BookVO> findAll() {
        return DozerConverter.parseListObjects(repository.findAll(), BookVO.class);
    }


}
