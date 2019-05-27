package test1.model;

import javax.persistence.*;


@Entity

public class Client {

    @Id
    @GeneratedValue
    private Integer id;
    private Integer idClient;
    private String name;
    private Integer age;

    @ManyToOne
    @JoinColumn(name = "idProduct")
    private Product product;

    @OneToMany
    @JoinColumn (name ="idOrder")
    private Order order;

    @JoinColumn(name = "idDetail")
    private Detail detail;

    public Client() {
    }

    public Client(Integer idClient, String name, Integer age) {
        this.idClient = idClient;
        this.name = name;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", idClient=" + idClient +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", product=" + product +
                ", order=" + order +
                ", detail=" + detail +
                '}';
    }
}
}
