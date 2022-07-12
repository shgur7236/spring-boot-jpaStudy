package com.fastcampus.jpa.bookmanager.jpa.bookmanager.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@EntityListeners(value = MyEntityListener.class)
public class UserHistory implements Auditable{

    @Id
    @GeneratedValue
    private Long id;

    private Long userId;

    private String email;

    private String name;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
