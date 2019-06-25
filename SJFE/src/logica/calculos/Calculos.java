package logica.calculos;

import java.util.HashMap;
import java.util.Random;

import logica.planificacion.Nodo;
import logica.planificacion.Planificacion;

public class Calculos {

    private Nodo cabeza;
    private Nodo bloqueado;
    private Planificacion planificador;
    private int tiempoTotal;
    private int contador;
    private HashMap<String, RegistroCalculo> registros;

    public Calculos() {
        this.tiempoTotal = 0;
        this.contador = 0;
        this.registros = new HashMap<String, RegistroCalculo>();
    }

    public HashMap<String, RegistroCalculo> getRegistros() {
        return this.registros;
    }

    public void setPlanificador(Planificacion planificador) {
        this.planificador = planificador;
        this.cabeza = this.planificador.getCabeza();
        this.bloqueado = this.planificador.getBloqueado();
    }

    public void agregar() {
        System.out.println(this.getClass().getName() + ".agregar(" + ")");
        Random rand = new Random();
//        int totalProcesos = 6;
        int totalProcesos = 1;
        int procesosEnMomento = 0;
        int rafaga = 0;
        int llegada=0;
        int prioridad = 0;
        this.contador = 0;
        while (totalProcesos > 0) {
//            System.out.println("1");
            procesosEnMomento = 1 + rand.nextInt(3);
            for (int i = 0; i < procesosEnMomento; i++) {
//                System.out.println("2");
//                System.out.println("tiempoTotal: " + tiempoTotal);
                this.planificador.temporizador(this.tiempoTotal);
                rafaga = 1 + rand.nextInt(12);
                prioridad = 1 + rand.nextInt(3);
                Nodo nodo = new Nodo(String.valueOf(this.contador));
                nodo.setLlegada(this.tiempoTotal);
                nodo.setRafaga(rafaga);
                nodo.setPrioridad(prioridad);
                System.out.println("Nodo "+i+" "+nodo);
                this.planificador.agregar(nodo);
                this.contador += 1;
            }
             
            ///
            this.planificador.temporizador(llegada);
            rafaga = 10;
            prioridad = 1;
            Nodo nodo1 = new Nodo(String.valueOf(this.contador));
            nodo1.setLlegada(llegada);
            nodo1.setRafaga(rafaga);
            nodo1.setPrioridad(prioridad);
            System.out.println("Nodo " + "1" + " " + nodo1);
            this.planificador.agregar(nodo1);
            this.contador += 1;
            llegada = llegada+1;
            ///
            this.planificador.temporizador(llegada);
            rafaga = 6;
            prioridad = 1;
            Nodo nodo2 = new Nodo(String.valueOf(this.contador));
            nodo2.setLlegada(llegada);
            nodo2.setRafaga(rafaga);
            nodo2.setPrioridad(prioridad);
            System.out.println("Nodo " + "2" + " " + nodo2);
            this.planificador.agregar(nodo2);
            this.contador += 1;
            llegada = llegada+1;
            ///
            this.planificador.temporizador(llegada);
            rafaga = 1;
            prioridad = 1;
            Nodo nodo3 = new Nodo(String.valueOf(this.contador));
            nodo3.setLlegada(llegada);
            nodo3.setRafaga(rafaga);
            nodo3.setPrioridad(prioridad);
            System.out.println("Nodo " + "3" + " " + nodo3);
            this.planificador.agregar(nodo3);
            this.contador += 1;
            llegada = llegada+1;
            ///
            this.planificador.temporizador(llegada);
            rafaga = 7;
            prioridad = 1;
            Nodo nodo4 = new Nodo(String.valueOf(this.contador));
            nodo4.setLlegada(llegada);
            nodo4.setRafaga(rafaga);
            nodo4.setPrioridad(prioridad);
            System.out.println("Nodo " + "1" + " " + nodo4);
            this.planificador.agregar(nodo4);
            this.contador += 1;
            llegada = llegada+1;
            ///
            this.planificador.temporizador(llegada);
            rafaga = 8;
            prioridad = 1;
            Nodo nodo5 = new Nodo(String.valueOf(this.contador));
            nodo5.setLlegada(llegada);
            nodo5.setRafaga(rafaga);
            nodo5.setPrioridad(prioridad);
            System.out.println("Nodo " + "5" + " " + nodo5);
            this.planificador.agregar(nodo5);
            this.contador += 1;
            llegada = llegada+1;
            ///
            this.planificador.temporizador(llegada);
            rafaga = 11;
            prioridad = 1;
            Nodo nodo6 = new Nodo(String.valueOf(this.contador));
            nodo6.setLlegada(llegada);
            nodo6.setRafaga(rafaga);
            nodo6.setPrioridad(prioridad);
            System.out.println("Nodo " + "6" + " " + nodo6);
            this.planificador.agregar(nodo6);
            this.contador += 1;
           llegada = llegada+1;
            ///
            this.planificador.temporizador(llegada);
            rafaga = 1;
            prioridad = 1;
            Nodo nodo7 = new Nodo(String.valueOf(this.contador));
            nodo7.setLlegada(llegada);
            nodo7.setRafaga(rafaga);
            nodo7.setPrioridad(prioridad);
            System.out.println("Nodo " + "7" + " " + nodo7);
            this.planificador.agregar(nodo7);
            this.contador += 1;
            llegada = llegada+1;
            ///
            /*
            if (rand.nextBoolean()) {
                System.out.println("3");
                this.planificador.temporizador(this.tiempoTotal);
                this.planificador.bloquear(this.tiempoTotal);
            }
             */
 /*
            if (rand.nextBoolean() && rand.nextBoolean() && rand.nextBoolean()) {
                System.out.println("4");
                this.planificador.temporizador(this.tiempoTotal);
                this.planificador.desbloquear(this.tiempoTotal);
            }
             */
            totalProcesos -= procesosEnMomento;
            this.tiempoTotal += 1;
        }
        Nodo recorre = this.planificador.getCabeza().getSig();
        //System.out.println("Nodo " + "0" + " " + this.planificador.getCabeza() + " ");
        int cont = 0;
        while (recorre != this.planificador.getCabeza()) {
            cont++;
            System.out.println("Nodo " + cont + " " + recorre + " ");
            recorre = recorre.getSig();
        }
        while (!this.bloqueado.getSig().equals(this.bloqueado)) {
            System.out.println("5");
            if (rand.nextBoolean()) {
                this.planificador.temporizador(this.tiempoTotal);
                this.planificador.desbloquear(this.tiempoTotal);
            }
        //    this.bloqueado = this.planificador.getBloqueado();
            this.tiempoTotal += 1;
        }
        while (this.tiempoTotal < 200) {
            System.out.println("6");
            this.planificador.temporizador(this.tiempoTotal);
            this.tiempoTotal += 1;
        }
    }

    public void calcular() {
        Nodo nodo = planificador.remover();
        int finalAnterior = 0;
        RegistroCalculo rc;
        while (!nodo.equals(this.cabeza)) {
            NodoCalculo nc = new NodoCalculo();
            if (this.registros.containsKey(nodo.getNombre())) {
                rc = this.registros.get(nodo.getNombre());
                nc.setBloqueado(rc.getFinalizacion());
            } else {
                rc = new RegistroCalculo(nodo.getNombre(), nodo.getLlegada(), nodo.getPrioridad());
                this.registros.put(nodo.getNombre(), rc);
                nc.setBloqueado(nodo.getLlegada());
            }
            nc.setRafaga(nodo.getRafaga());
            nc.setLlegada(nodo.getLlegada());
            if (nodo.getLlegada() > finalAnterior) {
                nc.setInicio(nodo.getLlegada());
                finalAnterior = nc.getInicio() + nc.getRafaga();
            } else {
                nc.setInicio(finalAnterior);
                finalAnterior += nc.getRafaga();
            }
            rc.addNodoRegistro(nc);
            nodo = planificador.remover();
        }
        this.tiempoTotal = finalAnterior;
    }

    public void limpiar() {
        this.registros.clear();

    }

}