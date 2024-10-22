/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.fesa.yLib.model;

import br.edu.fesa.yLib.enumerator.HistoryType;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Classe que representa o histórico de logs do sistema.
 * 
 * @author [Seu Nome]
 */
@Entity
@Table(name = "TB_LOG_HISTORY", schema = "LIBRARY")
public class LogHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_LOG")
    private int id;

    @Column(name = "ERROR_MESSAGE", nullable = false, length = 255)
    private String errorMessage;

    @Column(name = "LOG_DATE", nullable = false)
    private LocalDateTime logDate;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ID_USER", referencedColumnName = "ID_USER")
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(name = "HISTORY_TYPE", nullable = false)
    private HistoryType historyType;
    
    public LogHistory() {
    }

    public LogHistory(String errorMessage, LocalDateTime logDate, User user, HistoryType historyType) {
        this.errorMessage = errorMessage;
        this.logDate = logDate;
        this.user = user;
        this.historyType = historyType;
    }

    public LogHistory(int id, String errorMessage, LocalDateTime logDate, User user, HistoryType historyType) {
        this.id = id;
        this.errorMessage = errorMessage;
        this.logDate = logDate;
        this.user = user;
        this.historyType = historyType;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public LocalDateTime getLogDate() {
        return logDate;
    }

    public void setLogDate(LocalDateTime logDate) {
        this.logDate = logDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public HistoryType getHistoryType() {
        return historyType;
    }

    public void setHistoryType(HistoryType historyType) {
        this.historyType = historyType;
    }
}
