package test1.model;

import javax.persistence.*;

/* Идентефикация Book как обьект JPA*/
@Entity

//Переопределение имени таблицы для сохранения сущности
@Table(name = "BOOK")

//Определение запросов на языке запросов JPA, которые в последствии могут быть полученны и выполненны EntityManager
@NamedQueries({
        @NamedQuery(name = "Book.findByName",
                query = "SELECT b FROM Book b WHERE b.name = :name"),
        @NamedQuery(name = "Boor.findAll",
                query = "SELECT b FROM Book b")
})
public class Book {
    //Первичный ключ Book
    @Id

    //Сообщение JPA, что база банных должна генерировать первичный ключ, когда сущность сохраняется в базе данных.
    @GeneratedValue
    private Integer id;
    private String name;

    //Сообщение JPA, что у ОДНОГО АВТОРА может быть МНОГО КНИГ
    @ManyToOne
    @JoinColumn(name = "Autor_ID")
    private Author author;

    public Book() {
    }

    public Book(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Book(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book { id=" + id + ", name = " + name + '\'' + ", author =" + author.getName()+"}";
    }

}
