package com.durakkerem.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tbl_Address")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"}) // adreslerin id leri eşitse aynı adrestir demek için
@ToString
public class Address implements Serializable {
    // JPA entitylerinin Serializable interface'inden gelmesi gerekiyor

    @Id
    @SequenceGenerator(name = "seq_address",allocationSize = 1 )
    @GeneratedValue(generator = "seq_address",strategy = GenerationType.SEQUENCE)
    @Column(name = "Id")
    private Long id;
    @Column(name = "address",length = 500)
    private String address;

    @Enumerated
    @Column(name = "addressType")
    private AddressType addressType;

    @Column(name = "active")
    private Boolean Active ;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "person_address_id")
    private Person person; //join


    public enum AddressType{
        HOME_ADDRESS,
        BUSINESS_ADDRESS,
        OTHER
    }





}
