package net.proselyte.springbootdemo.repository;

import net.proselyte.springbootdemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//смысл в том, что в JpaRepository уже реализовали основные методы
//и мне уже не нужно создавать самому создавать все запросы самому
//Generics: класс который нужно реализовать и тип айдишника
public interface UserRepository extends JpaRepository<User, Long> {
    //а в самом интерфейсе можем реализовывать свои запросы
    //для данного проекта нам нет нужды создавать свои запросы
    //например
//    List<String> findByLastName(String lastName);


}
