package com.divinacomedia.controller;

import com.divinacomedia.model.User;
import com.divinacomedia.service.UserService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Carlos A. Gil
 */
@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserController {
    /**
     * Se crea instancia de Userservice
     */
    @Autowired
    private UserService userService;

    /**
     *
     * @return Lista de usuarios
     */
    @GetMapping("/all")
    public List<User> getAll() {
        return userService.getAll();
    }

    /**
     *
     * @param id
     * @return Usuario por ID
     */
    @GetMapping("/{id}")
    public Optional <User> getUser(@PathVariable("id") int id) {
        return userService.getUser(id);
    }

    /**
     *
     * @param user
     * @return Crea usuario  nuevo
     */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody User user) {
        return userService.create(user);
    }

    /**
     *
     * @param user
     * @return Actualiza usuario
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User update(@RequestBody User user) {
        return userService.update(user);
    }

    /**
     *
     * @param id
     * @return Elimina usuario por ID
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return userService.delete(id);
    }

    /**
     *
     * @param email
     * @param password
     * @return Autentica usuario por email password
     */
    @GetMapping("/{email}/{password}")
    public User authenticateUser(@PathVariable("email") String email, @PathVariable("password") String password) {
        return userService.authenticateUser(email, password);
    }

    /**
     *
     * @param email
     * @return booleano Verificando la existencia de un email
     */
    @GetMapping("/emailexist/{email}")
    public boolean emailExists(@PathVariable("email") String email) {
        return userService.emailExists(email);
    }

    @GetMapping("/birthday/{month}")
    public List<User> listBirthtDayMonth(@PathVariable("month") String month){
        return userService.listBirthtDayMonth(month);
    }
}
