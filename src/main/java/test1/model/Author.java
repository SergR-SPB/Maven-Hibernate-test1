package test1.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table( name = "AUTHOR")
@NamedQueries({
        @NamedQuery(name = "Author.findByName",
        query = "SELECT a FROM Author a WHERE a.name = :name")
})
public class Author {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    // Author Класс ведет список книг, написанных данным автором, который аннотируется @OneToMany аннотацией.
    // mappedByПоле сообщает Hibernate, что это поле хранится в Bookauthorсвойстве.
    // CascadeTypeперечисляемый тип, который определяет каскадные операции,
    // применяемые в данной связи.
    // В этом случае CascadeTypeопределяются операции, выполняемые над автором,
    // которые должны быть распространены на книгу.
    @OneToMany (mappedBy = "author", cascade = CascadeType.ALL)
    private List <Book> books = new ArrayList<>();

    public Author() {
    }
    public Author(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    public Author( String name) {
         this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void addBook(Book book) {
       books.add(book);
       book.setAuthor(this);
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", books=" + books +
                '}';
    }
}
