package ee.bcs.myApp.library.bookauthor;

import ee.bcs.myApp.library.author.Author;
import ee.bcs.myApp.library.book.Book;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-25T11:42:37+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.14.1 (JetBrains s.r.o.)"
)
@Component
public class BookAuthorMapperImpl implements BookAuthorMapper {

    @Override
    public BookAuthor toEntity(BookAuthorDto bookAuthorDto) {
        if ( bookAuthorDto == null ) {
            return null;
        }

        BookAuthor bookAuthor = new BookAuthor();

        bookAuthor.setBook( bookAuthorDtoToBook( bookAuthorDto ) );
        bookAuthor.setAuthor( bookAuthorDtoToAuthor( bookAuthorDto ) );
        bookAuthor.setId( bookAuthorDto.getId() );

        return bookAuthor;
    }

    @Override
    public BookAuthorDto toDto(BookAuthor bookAuthor) {
        if ( bookAuthor == null ) {
            return null;
        }

        BookAuthorDto bookAuthorDto = new BookAuthorDto();

        bookAuthorDto.setBookId( bookAuthorBookId( bookAuthor ) );
        bookAuthorDto.setBookTitle( bookAuthorBookTitle( bookAuthor ) );
        bookAuthorDto.setBookYear( bookAuthorBookYear( bookAuthor ) );
        bookAuthorDto.setAuthorId( bookAuthorAuthorId( bookAuthor ) );
        bookAuthorDto.setAuthorFirstName( bookAuthorAuthorFirstName( bookAuthor ) );
        bookAuthorDto.setAuthorLastName( bookAuthorAuthorLastName( bookAuthor ) );
        bookAuthorDto.setId( bookAuthor.getId() );

        return bookAuthorDto;
    }

    @Override
    public List<BookAuthorDto> toDtos(List<BookAuthor> bookAuthors) {
        if ( bookAuthors == null ) {
            return null;
        }

        List<BookAuthorDto> list = new ArrayList<BookAuthorDto>( bookAuthors.size() );
        for ( BookAuthor bookAuthor : bookAuthors ) {
            list.add( toDto( bookAuthor ) );
        }

        return list;
    }

    @Override
    public void updateEntity(BookAuthorDto bookAuthorDto, BookAuthor bookAuthor) {
        if ( bookAuthorDto == null ) {
            return;
        }

        if ( bookAuthor.getBook() == null ) {
            bookAuthor.setBook( new Book() );
        }
        bookAuthorDtoToBook1( bookAuthorDto, bookAuthor.getBook() );
        if ( bookAuthor.getAuthor() == null ) {
            bookAuthor.setAuthor( new Author() );
        }
        bookAuthorDtoToAuthor1( bookAuthorDto, bookAuthor.getAuthor() );
        if ( bookAuthorDto.getId() != null ) {
            bookAuthor.setId( bookAuthorDto.getId() );
        }
    }

    protected Book bookAuthorDtoToBook(BookAuthorDto bookAuthorDto) {
        if ( bookAuthorDto == null ) {
            return null;
        }

        Book book = new Book();

        book.setId( bookAuthorDto.getBookId() );
        book.setTitle( bookAuthorDto.getBookTitle() );
        book.setYear( bookAuthorDto.getBookYear() );

        return book;
    }

    protected Author bookAuthorDtoToAuthor(BookAuthorDto bookAuthorDto) {
        if ( bookAuthorDto == null ) {
            return null;
        }

        Author author = new Author();

        author.setId( bookAuthorDto.getAuthorId() );
        author.setFirstName( bookAuthorDto.getAuthorFirstName() );
        author.setLastName( bookAuthorDto.getAuthorLastName() );

        return author;
    }

    private Integer bookAuthorBookId(BookAuthor bookAuthor) {
        if ( bookAuthor == null ) {
            return null;
        }
        Book book = bookAuthor.getBook();
        if ( book == null ) {
            return null;
        }
        Integer id = book.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String bookAuthorBookTitle(BookAuthor bookAuthor) {
        if ( bookAuthor == null ) {
            return null;
        }
        Book book = bookAuthor.getBook();
        if ( book == null ) {
            return null;
        }
        String title = book.getTitle();
        if ( title == null ) {
            return null;
        }
        return title;
    }

    private Integer bookAuthorBookYear(BookAuthor bookAuthor) {
        if ( bookAuthor == null ) {
            return null;
        }
        Book book = bookAuthor.getBook();
        if ( book == null ) {
            return null;
        }
        Integer year = book.getYear();
        if ( year == null ) {
            return null;
        }
        return year;
    }

    private Integer bookAuthorAuthorId(BookAuthor bookAuthor) {
        if ( bookAuthor == null ) {
            return null;
        }
        Author author = bookAuthor.getAuthor();
        if ( author == null ) {
            return null;
        }
        Integer id = author.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String bookAuthorAuthorFirstName(BookAuthor bookAuthor) {
        if ( bookAuthor == null ) {
            return null;
        }
        Author author = bookAuthor.getAuthor();
        if ( author == null ) {
            return null;
        }
        String firstName = author.getFirstName();
        if ( firstName == null ) {
            return null;
        }
        return firstName;
    }

    private String bookAuthorAuthorLastName(BookAuthor bookAuthor) {
        if ( bookAuthor == null ) {
            return null;
        }
        Author author = bookAuthor.getAuthor();
        if ( author == null ) {
            return null;
        }
        String lastName = author.getLastName();
        if ( lastName == null ) {
            return null;
        }
        return lastName;
    }

    protected void bookAuthorDtoToBook1(BookAuthorDto bookAuthorDto, Book mappingTarget) {
        if ( bookAuthorDto == null ) {
            return;
        }

        if ( bookAuthorDto.getBookId() != null ) {
            mappingTarget.setId( bookAuthorDto.getBookId() );
        }
        if ( bookAuthorDto.getBookTitle() != null ) {
            mappingTarget.setTitle( bookAuthorDto.getBookTitle() );
        }
        if ( bookAuthorDto.getBookYear() != null ) {
            mappingTarget.setYear( bookAuthorDto.getBookYear() );
        }
    }

    protected void bookAuthorDtoToAuthor1(BookAuthorDto bookAuthorDto, Author mappingTarget) {
        if ( bookAuthorDto == null ) {
            return;
        }

        if ( bookAuthorDto.getAuthorId() != null ) {
            mappingTarget.setId( bookAuthorDto.getAuthorId() );
        }
        if ( bookAuthorDto.getAuthorFirstName() != null ) {
            mappingTarget.setFirstName( bookAuthorDto.getAuthorFirstName() );
        }
        if ( bookAuthorDto.getAuthorLastName() != null ) {
            mappingTarget.setLastName( bookAuthorDto.getAuthorLastName() );
        }
    }
}
