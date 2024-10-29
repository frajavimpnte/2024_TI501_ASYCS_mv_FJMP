/*
*   ITESS-TICS 
*   Agosto-Diciembre 2024
*   Análsisis de Señales y Sistemas de Comunicaciones
*   Unidad 1. Introducción a Señales
*   Actividad: Operaciones con números complejos
*   Docente: Franacisco Javier Montecillo Puente
*   Programador: FJMP
*   Fecha: 04 de Agosto 2024
*/

package com.fjmp.pojo;

public class ComplexNumber {
    private float a;
    private float b;
    private float mod;
    private float arg;

    public ComplexNumber() {
    }

    public ComplexNumber(float a, float b) {
        this.a = a;
        this.b = b;
    }

    public float getA() {
        return a;
    }

    public void setA(float a) {
        this.a = a;
    }

    public float getB() {
        return b;
    }

    public void setB(float b) {
        this.b = b;
    }

    public void setMod(float mod) {
        this.mod = mod;
    }

    public void setArg(float arg) {
        this.arg = arg;
    }
    
    
    
    public ComplexNumber add (ComplexNumber c){
        ComplexNumber r= new ComplexNumber();
        r.setA(a+c.getA());
        r.setB(b+c.getB());
        return r;
    }

    public ComplexNumber sub (ComplexNumber c){
        ComplexNumber r= new ComplexNumber();
        r.setA(a-c.getA());
        r.setB(b-c.getB());
        return r;
    }
    
    public ComplexNumber mult (ComplexNumber c){
        ComplexNumber r= new ComplexNumber();
        r.setA(a*c.a - b*c.b);
        r.setB(a*c.b + c.a*b);
        return r;
    }
    
    public ComplexNumber conj (){
        ComplexNumber c = new ComplexNumber();
        c.setA(a);
        c.setB(b);
        return c;
    }
     
    public ComplexNumber div (ComplexNumber c){
        ComplexNumber cconj = c.conj();
        ComplexNumber num = this.mult(cconj);
        ComplexNumber den = cconj.mult(c);
        
        ComplexNumber d = new ComplexNumber();
        d.setA(num.a/den.a);
        d.setB(num.b/den.a);
        return d;
    }
    
    public void polarRad() {
        mod = (float) Math.sqrt(a*a + b*b);
        arg = (float) Math.atan2(b, a);
        arg = arg < 0? (float)(arg + Math.PI):arg;
    }
    
     public void polarDeg() {
        mod = (float) Math.sqrt(a*a + b*b);
        arg = (float) Math.atan2(b, a);
        arg = arg < 0? (float)(arg + Math.PI):arg;
        arg = (float) Math.toDegrees(arg);
    }
    
    public void rectangularRad() {
        a = (float) (mod * Math.cos(arg));
        b = (float) (mod * Math.sin(arg));
    }
    
    public void rectangularDeg() {
        a = (float) (mod * Math.cos(  Math.toRadians(arg)) );
        b = (float) (mod * Math.sin(  Math.toRadians(arg)) );
    }
    
    public ComplexNumber scalar(float c) {
         ComplexNumber r= new ComplexNumber();
         r.setA(a*c);
         r.setB(b*c);
         return r;
    }

    public static ComplexNumber i2n(int n) {
        ComplexNumber i0 = new ComplexNumber();
        i0.setA(1);
        
        
        if (n == 0) return i0;
                
        ComplexNumber i1 = new ComplexNumber(0,1);  // 1, 5,  9  mod 4 => 1
        ComplexNumber i2 = new ComplexNumber(-1,0); // 6, 10, 14 mod 4 => 2
        
        ComplexNumber i3 = new ComplexNumber(0,-1); // 7, 11, 15 mod 4 => 3
        
        ComplexNumber i4 = new ComplexNumber(1,0);  // 8, 12, 16 mod 4 => 0
        
        ComplexNumber res = null;
        switch(n % 4) {
            case 0: res = i4; break;
            case 1: res = i1; break;
            case 2: res = i2; break;
            case 3: res = i3; break;
        }
        return res;
    }
     
    @Override
    public String toString() {
        return a +","+b;
        //return "ComplexNumber{" + "a=" + a + ", b=" + b + '}';
    }
    
    public String toStringPolar() {
        return "ComplexNumber{" + "mod=" + mod + ", arg=" + arg + '}';
    }
    
    public ComplexNumber exp() {
        return new ComplexNumber ( 
                (float) (Math.exp(a)*Math.cos(b)),
                (float) (Math.exp(a)*Math.sin(b)));
    }
    
    public static ComplexNumber exp(ComplexNumber c) {
        return new ComplexNumber ( 
                (float) (Math.exp(c.a)*Math.cos(c.b)),
                (float) (Math.exp(c.a)*Math.sin(c.b)));
    }
}
