package hellojpa;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Member {

    @Id
    private Long id;
    @Column(name = "name",nullable = false,length = 10,columnDefinition = "varchar(100) default 'empty'")      //객체는 username, db는 name. not null 제약이 걸린다.
    private String username;
    private Integer age;
    @Enumerated(EnumType.STRING)    //enum 타입,기본값인 ORDINARY는 쓰지말자
    private RoleType roleType;
    @Temporal(TemporalType.TIMESTAMP)   // 날짜 타입,생성일자
    private Date createdDate;
    @Temporal(TemporalType.TIMESTAMP)   // 수정날짜
    private Date lastModifiedDate;

    private LocalDate testLocalDate;    // 최신버전에서는 @Temporal을 쓰지 않아도 된다.
    private LocalDateTime testLocalDateTime;

    @Lob    // varchar를 넘어서는 큰 데이터르 넘기고 싶을 떄
    private String description;



    public Member() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
