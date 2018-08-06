package com.freesoft.wssintegration.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Builder
@Setter(AccessLevel.PROTECTED)
public class LoginEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @Column(name = "SESSION_ID")
    private String sessionId;

    @Column(name = "OCCURRED_AT")
    private Long occurredAt;

}
