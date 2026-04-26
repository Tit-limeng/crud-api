package com.crud.crud_api.entity ;

import jakarta.persistence.*;
import lombok.Data ;
import java.util.UUID;
@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id ;
    private String username ;
}
