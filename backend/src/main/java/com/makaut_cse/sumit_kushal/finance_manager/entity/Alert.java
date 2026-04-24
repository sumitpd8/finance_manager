package com.makaut_cse.sumit_kushal.finance_manager.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.*;

@Entity
@Table(name = "alerts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Alert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long referenceId;

    private String referenceType;

    private String alertType;

    private String message;

    private LocalDate alertDate;

    private String status;

    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
}