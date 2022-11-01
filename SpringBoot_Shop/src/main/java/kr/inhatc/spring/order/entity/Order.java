package kr.inhatc.spring.order.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import kr.inhatc.spring.member.entity.Member;
import kr.inhatc.spring.order.constant.OrderStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name = "orders")
@NoArgsConstructor
public class Order {
    
    @Id
    @GeneratedValue()
    @Column(name = "order_id")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
    
    private LocalDateTime orderDate;
    
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
    
    private LocalDateTime regTime;
    
    private LocalDateTime updateTime;
}
