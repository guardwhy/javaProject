package cn.guardwhy.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 需要导入lombok
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String name; // 用户name
    private int age; // 用户年龄
    private String sex; // 性别
}
