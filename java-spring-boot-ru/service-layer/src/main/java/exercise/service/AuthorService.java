package exercise.service;

import exercise.dto.AuthorCreateDTO;
import exercise.dto.AuthorDTO;
import exercise.dto.AuthorUpdateDTO;
import exercise.exception.ResourceNotFoundException;
import exercise.mapper.AuthorMapper;
import exercise.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    // BEGIN
    @Autowired AuthorRepository authorRepository;

    @Autowired AuthorMapper authorMapper;

    public List<AuthorDTO> getAllAuthors() {
        return authorRepository
                .findAll()
                .stream()
                .map(authorMapper::map)
                .toList();
    }

    public AuthorDTO getAuthorById(Long id) {
        var maybeAuthor = authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author with id " + id + "not found"));
        var authorDTO = authorMapper.map(maybeAuthor);
        return authorDTO;
    }
    public AuthorDTO createAuthor(AuthorCreateDTO data) {
        var author = authorMapper.map(data);
        authorRepository.save(author);
        return authorMapper.map(author);
    }

    public AuthorDTO updateAuthor(AuthorUpdateDTO data, Long id) {
        var maybeAuthor = authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author with id " + id + "not found"));
        authorMapper.update(data, maybeAuthor);
        authorRepository.save(maybeAuthor);
        var authorDTO = authorMapper.map(maybeAuthor);
        return authorDTO;
    }
    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }
    // END
}
