/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.Scanner;

/**
 *
 * @author lucho
 */
public class Cuenta {
    
    private int numeroCuenta;
    private String nombre;
    private String apellido;
    private int dni;
    private double saldoActual;

    public Cuenta() {
        saldoActual=0;
    }

    public Cuenta(int numeroCuenta, String nombre, String apellido, int dni) {
        this.numeroCuenta = numeroCuenta;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public double getSaldoActual() {
        return saldoActual;
    }

    public void setSaldoActual(double saldoAcual) {
        this.saldoActual = saldoActual;
    }

    public Cuenta crearCuenta(){
        
        Scanner leer = new Scanner(System.in);
                
        System.out.println("Ingrese el nro de cuenta: ");
        numeroCuenta = leer.nextInt();
        
        System.out.println("Ingrese el Nombre: ");
        nombre = leer.next();
        
        System.out.println("Ingrese el Apellido: ");
        apellido = leer.next();
        
        System.out.println("Ingrese el nro de DNI: ");
        dni = leer.nextInt();
        
        
        Cuenta cta = new Cuenta(numeroCuenta, nombre, apellido, dni );
        
       return cta; 
        
    }
    
    public void ingresarFondos(){
        
        Scanner leer = new Scanner(System.in);
        double ingreso;
        
        System.out.println("Ingrese la cantidad a depositar: ");
        ingreso = leer.nextInt();
        
        saldoActual += ingreso;
        
        
    }
    
    public void retirarFondos(){
        
        Scanner leer = new Scanner(System.in);
        double retiro;
        
        System.out.println("Ingrese la cantidad a retirar: ");
        retiro = leer.nextInt();
        
        if (retiro> saldoActual){
            saldoActual = 0;             
    }else{
            saldoActual -= retiro;
        }
    }
    
    public void extraccionRapida(){
        
        Scanner leer = new Scanner(System.in);
        double retiro;
        String rta;
        
        System.out.println("Acepta la extracción rápida (si/no): ");
        rta = leer.next();
        
        if (rta.equalsIgnoreCase("si")){
            System.out.println("Esta retirando el 20% de su saldo. Retiro = "+ (saldoActual*0.20) );
            saldoActual = (saldoActual*0.8);
            
        }else{
            System.out.println("No retiro fondos");
        }         
       
        
    }
    
    
    public void opcionOperacion (){
        
        String rta;
        int opcion;
        Scanner leer = new Scanner(System.in);
        
        do {
           
            System.out.println("----------------------------");    
            System.out.println("Selecciones una operacion: ");
            System.out.println("1-Consulta saldo");
            System.out.println("2-Consulta datos");
            System.out.println("3-Deposito");
            System.out.println("4-Retiro");
            System.out.println("5-Retiro rapido");
            System.out.println("----------------------------");    
            opcion= leer.nextInt();
            System.out.println("----------------------------");   
            
        switch (opcion){
            case 1:
                System.out.println("Saldo actual: $"+ getSaldoActual());
                break;
            case 2:
                System.out.println(toString());  
                break;
            case 3:
                ingresarFondos();
                System.out.println("Saldo actual: $"+ getSaldoActual());
                break;
            case 4:
                retirarFondos();
                System.out.println("Saldo actual: $"+ getSaldoActual());
                break;
            case 5:
                extraccionRapida();
                System.out.println("Saldo actual: $"+ getSaldoActual());
                break;
            default:
                System.out.println("Opcion no admitida");               
                           
        }
            
            System.out.println("Desea salir: (si/no): ");
            rta = leer.next();
            
        } while (!rta.equals("si"));
        
        
        
        
    }

    @Override
    public String toString() {
        return "Cuenta{" + "numeroCuenta=" + numeroCuenta + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", saldoActual=" + saldoActual + '}';
    }
        
        
    
    
    
}

    