/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hola_mundo;

import java.util.Scanner;

/**
 *
 * @author Jaime Andres Angel M
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Número 1: ");
        int n1 = Integer.parseInt(sc.nextLine());
        System.out.print("Número 2: ");
        int n2 = Integer.parseInt(sc.nextLine());
        
        System.out.println("\nEl resultado sumar los dos números es: "+(n1+n2));
    }
    
}
