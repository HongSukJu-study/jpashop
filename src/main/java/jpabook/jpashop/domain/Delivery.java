package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Delivery {

    @Id @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
    private Order order;

    @Embedded
    private Address address;

    // ORDINAL일 경우에 순서대로 숫자가 들어가는데, 나중에 어떤 타입이 추가되면 큰일나기 때문에 STRING을 사용하자.
    @Enumerated(value = EnumType.STRING)
    private DeliveryStatus status;
}
