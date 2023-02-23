package me.isayaksh.swagger.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor @AllArgsConstructor
public class MemberForm {

    private String email;
    private String password;
    private String username;

    public Member toEntity() {
        return Member.create(email, password, username);
    }

}
