package br.com.erudio.controller;

import br.com.erudio.data.vo.v1.BookVO;
import br.com.erudio.services.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "Book", tags = "Book")
@RestController
@RequestMapping("api/book/v1")
public class BookController {

    @Autowired
    private BookService services;

    @ApiOperation(value = "Find all books")
    @GetMapping(produces = {"application/json", "application/xml", "application/x-yaml"})
    public List<BookVO> findAll() {
        List<BookVO> list = services.findAll();
        list.forEach(b -> b.add(WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(BookController.class).findById(b.getId())
        ).withSelfRel()));
        return list;
    }

    @GetMapping(value = "/{id}", produces = {"application/json", "application/xml", "application/x-yaml"})
    public BookVO findById(@PathVariable("id") Integer id) {
        BookVO entity = services.findById(id);
        entity.add(WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(BookController.class).findAll()
        ).withRel("List book"));
        return entity;
    }


    @PostMapping(produces = {"application/json", "application/xml", "application/x-yaml"},
            consumes = {"application/json", "application/xml", "application/x-yaml"}
    )
    public BookVO create(@RequestBody BookVO bookVO) {
        BookVO entity = services.create(bookVO);
        entity.add(WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(BookController.class).findAll()
        ).withRel("List book"));
        return entity;
    }


    @PutMapping(produces = {"application/json", "application/xml", "application/x-yaml"},
            consumes = {"application/json", "application/xml", "application/x-yaml"}
    )
    public BookVO update(@RequestBody BookVO bookVO) {
        BookVO entity = services.update(bookVO);
        entity.add(WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(BookController.class).findAll()
        ).withRel("List book"));
        return entity;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        services.delete(id);
        return ResponseEntity.ok().build();
    }


}
