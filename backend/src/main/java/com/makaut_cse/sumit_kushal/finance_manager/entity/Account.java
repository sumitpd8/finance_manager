package com.makaut_cse.sumit_kushal.finance_manager.entity;

import com.makaut_cse.sumit_kushal.finance_manager.enums.AccountType;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "accounts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account_name", nullable = false)
    private String accountName;

    @Enumerated(EnumType.STRING)
    @Column(name = "account_type", nullable = false)
    private AccountType accountType;

    @Column(name = "current_balance")
    private BigDecimal currentBalance;

    @Column(name = "credit_limit")
    private BigDecimal creditLimit;

    @Column(name = "interest_rate")
    private BigDecimal interestRate;

    @Column(name = "payment_due_day")
    private Integer paymentDueDay;

    @Column(name = "remaining_balance")
    private BigDecimal remainingBalance;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}