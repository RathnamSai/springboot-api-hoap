package com.hoap.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Validated
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Valid
    @Column(name = "firstName")
    @Size(min = 1, max = 100)
    private String firstName;
    @Valid
    @Column(name = "lastName")
    @Size(min = 1, max = 100)
    private String lastName;

    @Id
    @Valid
    @Column(name = "email")
    @NotNull(message = "Email Id is required")
    @Size(min = 1, max = 100)
    private String email;

    @Valid
    @Column(name = "password")
    @Size(min = 1, max = 100)
    private String password;

    private LocalDateTime createdOn;
    private LocalDateTime lastLoggedOn;

}