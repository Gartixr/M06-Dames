package damas.entity;
// Generated 31-ene-2021 22:17:47 by Hibernate Tools 4.3.1



/**
 * Movimientos generated by hbm2java
 */
public class Movimientos  implements java.io.Serializable {


     private Integer id;
     private int fila;
     private int columna;
     private int filaDestino;
     private int columnaDestino;

    public Movimientos() {
    }

    public Movimientos(int fila, int columna, int filaDestino, int columnaDestino) {
       this.fila = fila;
       this.columna = columna;
       this.filaDestino = filaDestino;
       this.columnaDestino = columnaDestino;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public int getFila() {
        return this.fila;
    }
    
    public void setFila(int fila) {
        this.fila = fila;
    }
    public int getColumna() {
        return this.columna;
    }
    
    public void setColumna(int columna) {
        this.columna = columna;
    }
    public int getFilaDestino() {
        return this.filaDestino;
    }
    
    public void setFilaDestino(int filaDestino) {
        this.filaDestino = filaDestino;
    }
    public int getColumnaDestino() {
        return this.columnaDestino;
    }
    
    public void setColumnaDestino(int columnaDestino) {
        this.columnaDestino = columnaDestino;
    }




}

