package com.fastcampus.jpa.bookmanager.jpa.bookmanager.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

//
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Builder
@Entity
@Table(name = "user_table", indexes = { @Index(columnList = "name")}, uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @NonNull
    private String email;

    @Column(updatable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;


//    @Transient      // DB레코드에는 처리하지 않지만 객체를 따로 사용 가능
//    private String testData;

//    @OneToMany(fetch = FetchType.EAGER)
//    private List<Address> address;

    @PrePersist
    public void prePersist(){
        System.out.println(">>> prePersist");
    }

    @PostPersist
    public void postPersist(){
        System.out.println(">>> postPersist");
    }

    @PreUpdate
    public void preUpdate(){
        System.out.println(">>> preUpdate");
    }

    @PostUpdate
    public void postUpdate(){
        System.out.println(">>> postUpdate");
    }

    @PreRemove
    public void preRemove(){
        System.out.println(">>> preRemove");
    }

    @PostRemove
    public void postRemove(){
        System.out.println(">>> postRemove");
    }

    @PostLoad
    public void postLoad(){
        System.out.println(">>> postLoad");
    }
}
