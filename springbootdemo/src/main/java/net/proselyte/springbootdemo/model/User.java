package net.proselyte.springbootdemo.model;

import lombok.Data;

import javax.persistence.*;

@Data// Lombok аннотация вставляет поумолчании геттеры сеттеры и тустринг
@Entity//аннотация подразумевает работу в бд
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//это строчка
    //только из-за настроек в бд id = autoincrement
    private Long id;

    //я так понимаю, что колонки можно не прописывать, но так как
    // у нас не совпадают имена в бд, то приходится
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;



}
