/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.edu.fesa.yLib.enumerator;

/**
 *
 * @author 081220023
 */
public enum UserGender {
    MALE(0),
    FEMALE(1),
    OTHER(2); 
    
    private final int id;

    // Construtor para o enum
    UserGender(int id) {
        this.id = id;
    }

    // Getter para o id
    public int getId() {
        return id;
    }
}
