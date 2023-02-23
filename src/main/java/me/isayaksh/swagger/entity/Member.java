package me.isayaksh.swagger.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@AllArgsConstructor @NoArgsConstructor
public class Member {

    @Id @GeneratedValue(strategy = IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(unique = true)
    private String email;
    private String password;
    private String username;

    public static Member create(String email, String password, String username) {
        Member member = new Member();
        member.email = email;
        member.password = password;
        member.username = username;
        return member;
    }

    public void update(String email, String password, String username) {
        this.email = (email != null) ? email : this.email;
        this.password = (password != null) ? password : this.password;
        this.username = (username != null) ? username : this.username;
    }
}
