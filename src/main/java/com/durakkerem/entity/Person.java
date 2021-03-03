package com.durakkerem.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tbl_Person")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"}) // adreslerin id leri eşitse aynı adrestir demek için
@ToString
public class Person {

    @Id
    @SequenceGenerator(name = "seq_person",allocationSize = 1 )
    @GeneratedValue(generator = "seq_person",strategy = GenerationType.SEQUENCE)
    @Column(name = "Id")
    private Long id;
    @Column(name = "name",length = 99)
    private String name;
    @Column(name = "surname",length = 99)
    private String surname;

    @OneToMany
    @JoinColumn(name = "person_address_id")
    private List<Address> addresses; //join
}
