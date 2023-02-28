package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Embedded
    private Address address;

    // mappedBy를 설정하면 연관관계의 주인을 넘겨주고 읽기 전용으로 변경된다.
    // 따라서 이 List에 뭘 넣든 데이터베이스는 반영하지 않음.
    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();

}
