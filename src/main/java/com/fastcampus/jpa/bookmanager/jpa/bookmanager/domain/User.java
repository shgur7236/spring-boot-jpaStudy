package com.fastcampus.jpa.bookmanager.jpa.bookmanager.domain;

import com.fastcampus.jpa.bookmanager.jpa.bookmanager.domain.listener.Auditable;
import com.fastcampus.jpa.bookmanager.jpa.bookmanager.domain.listener.UserEntityListener;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

//
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Builder
@Entity
@EntityListeners(value = {AuditingEntityListener.class, UserEntityListener.class})
@Table(name = "user_table") //indexes = { @Index(columnList = "name")}, uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})
public class User extends BaseEntity  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @NonNull
    private String email;

//    @Column(updatable = false)
//    @CreatedDate
//    private LocalDateTime createdAt;
//
//    @LastModifiedDate

//    private LocalDateTime updatedAt;

//    @Transient      // DB레코드에는 처리하지 않지만 객체를 따로 사용 가능
//    private String testData;

//    @OneToMany(fetch = FetchType.EAGER)
//    private List<Address> address;

//    @PrePersist
//    public void prePersist(){
//        this.createdAt = LocalDateTime.now();
//        this.updatedAt = LocalDateTime.now();
//    }
//
//    @PreUpdate
//    public void preUpdate(){
//        this.updatedAt = LocalDateTime.now();
//    }


}
