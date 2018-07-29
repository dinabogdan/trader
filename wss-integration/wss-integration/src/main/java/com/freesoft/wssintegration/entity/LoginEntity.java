package com.freesoft.wssintegration.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Builder
public class LoginEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @Column(name = "SESSION_ID")
    private String sessionId;

    @Column(name = "OCCURRED_AT")
    private Long occurredAt;

}
