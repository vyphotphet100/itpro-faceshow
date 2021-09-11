package com.itprofaceshow.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "room")
@Getter @Setter
@NoArgsConstructor
public class RoomEntity extends BaseEntity{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "host_username")
    private UserEntity hostUser;

    @OneToMany(mappedBy = "room")
    private List<MessageEntity> messages = new ArrayList<>();
}
