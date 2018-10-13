package com.yunduan.kanli.myblog.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity  //实体
public class User {

    @Id  // 主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //自增策略
    private Long id;

    private String name;

    private String email;

    protected User(){   //防止直接使用

    }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("User[id=%d,name='%s',email='%s']",id,name,email);
    }
}
