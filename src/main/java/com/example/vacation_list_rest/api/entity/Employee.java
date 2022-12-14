package com.example.vacation_list_rest.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message = "Имя не заполнено.")
    @Size(min = 2, max = 45, message = "Имя не соответствует размеру.")
    private String name;

    @Size(min = 11, max = 12, message = "Не корректный размер номера телефона.")
    private String phone;
    @NotNull(message = "Заполните почту.")
    @Email(message = "Электронная почта не соответствует шаблону.")
    @Size(min = 6,max = 45, message = "Электронная почта не соответствует размеру.")
    private String email;
    @Size(min = 6, max = 45, message = "Телеграмм id не соответствует размеру.")
    private String telegramId;
    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "vacation",
    joinColumns = @JoinColumn(name = "userId"),
    inverseJoinColumns = @JoinColumn(name = "id"))
    private List<Vacation> vacationList;

    public Employee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelegramId() {
        return telegramId;
    }

    public void setTelegramId(String telegramId) {
        this.telegramId = telegramId;
    }

    public List<Vacation> getVacationList() {
        return vacationList;
    }

    public void setVacationList(List<Vacation> vacationList) {
        this.vacationList = vacationList;
    }
}
