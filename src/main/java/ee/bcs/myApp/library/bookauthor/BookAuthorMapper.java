package ee.bcs.myApp.library.bookauthor;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface BookAuthorMapper {
    @Mapping(source = "bookId", target = "book.id")
    @Mapping(source = "bookTitle", target = "book.title")
    @Mapping(source = "bookYear", target = "book.year")
    @Mapping(source = "authorId", target = "author.id")
    @Mapping(source = "authorFirstName", target = "author.firstName")
    @Mapping(source = "authorLastName", target = "author.lastName")
    BookAuthor toEntity(BookAuthorDto bookAuthorDto);


    @InheritInverseConfiguration(name = "toEntity")
    BookAuthorDto toDto(BookAuthor bookAuthor);

    @Mapping(target = "id", ignore = true)
    List<BookAuthorDto> toDtos(List<BookAuthor> bookAuthors);


    @InheritConfiguration(name = "toEntity")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(BookAuthorDto bookAuthorDto, @MappingTarget BookAuthor bookAuthor);
}
