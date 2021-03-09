package com.spring.springcaffemore.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Caffe {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "caffe_id")
    private Long id;

    private String name;
}
