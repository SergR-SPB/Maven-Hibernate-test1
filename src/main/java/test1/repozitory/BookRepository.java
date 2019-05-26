package test1.repozitory;

import test1.model.Book;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class BookRepository {

    //Инициализация с помощью EntityManager
    private EntityManager entityManager;

    public BookRepository(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    // Метод findById()вызывает EntityManagerfind()метод, который извлекает сущность данного класса с заданным первичным ключом.
    // Проверяет значение на null и возвращает либо действительную книгу , завернутую в Optional, либо Optional.empty().
    public Optional<Book> findById (Integer id){
        Book book = entityManager.find(Book.class, id);
        return book != null ? Optional.of(book) : Optional.empty();
    }

    //findAll()метод создает новый запрос, используя JPQL, для получения всех книг.
    public List<Book> findAll() {
        return entityManager.createQuery("from Book").getResultList();
    }

    //createQuery()Метод создает Queryэкземпляр, который поддерживает множество setterметодов, напримерsetParameter(),
    public Optional<Book> findByName(String name){
        Book book = entityManager.createQuery("SELECT b FROM Book b WHERE b.name = :name", Book.class)
                .setParameter("name",name)
                .getSingleResult();
        return book != null ? Optional.of(book) : Optional.empty();
    }


    public Optional<Book> findByNameNamedQuery(String name) {
        Book book = entityManager.createNamedQuery("Book.findByName", Book.class)
                .setParameter("name", name)
                .getSingleResult();
        return book != null ? Optional.of(book) : Optional.empty();
    }

    //save()метод сохраняет a Bookв базе данных.
    public Optional<Book> save(Book book) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(book);
            entityManager.getTransaction().commit();
            return Optional.of(book);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }


}
