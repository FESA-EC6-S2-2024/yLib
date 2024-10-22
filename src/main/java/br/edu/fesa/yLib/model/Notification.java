/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.fesa.yLib.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Classe que representa uma notificação associada a um empréstimo no sistema.
 * 
 * @author [Seu Nome]
 */
@Entity
@Table(name = "TB_NOTIFICATION", schema = "LIBRARY")
public class Notification implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ID_LOAN", referencedColumnName = "ID_LOAN")
    private Loan loan;

    @Column(name = "NOTIFICATION_DATE", nullable = false)
    private LocalDateTime date;

    public Notification() {
    }

    public Notification(Loan loan, LocalDateTime date) {
        this.loan = loan;
        this.date = date;
    }

    // Getters and Setters
    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
