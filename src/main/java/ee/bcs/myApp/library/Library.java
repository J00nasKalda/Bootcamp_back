package ee.bcs.myApp.library;

import ee.bcs.myApp.library.book.Book;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Library {
    private List<Book> books = new ArrayList<>();
}
