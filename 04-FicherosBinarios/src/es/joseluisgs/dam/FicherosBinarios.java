package es.joseluisgs.dam;

import es.joseluisgs.dam.model.Empleado;

import java.io.*;
import java.util.Stack;

public class FicherosBinarios {
    public static void testEscribirFicheroBinario() {

        // Rutas de ficheros
        ObjectOutputStream f = null;
        File fichero = null;

        Empleado empleado1=new Empleado("Fernando", "Ureña", 23, 800);
        Empleado empleado2=new Empleado("Antonio", "Lopez", 35, 1000);

        Stack<Empleado> pila= new Stack<Empleado>();

        pila.add(empleado1);
        pila.add(empleado2);

        try{
            fichero = new File("empleados");
            f = new ObjectOutputStream(new FileOutputStream(fichero));
            //Escribimos en un fichero
            // podríamos escribir un array list o arbol si todos son
            // serializables
            System.out.println("Escribiendo objetos binarios en:"+fichero.getAbsolutePath());
            f.writeObject(empleado1);
            f.writeObject(empleado2);
            f.writeObject(pila);
            System.out.println("Escritos");
        }catch(IOException e){
            //e.printStackTrace();
        } finally {
            try {
                // Nuevamente aprovechamos el finally para
                // asegurarnos que se cierra el fichero.
                if (f != null)
                    f.close();
                System.out.println("Fichero cerrado");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void testLeerFicheroBinario(){
        // Rutas de ficheros
        ObjectInputStream f = null;
        File fichero = null;

        try{
            fichero = new File("empleados");
            f = new ObjectInputStream(new FileInputStream(fichero));
            //Escribimos en un fichero
            // podríamos escribir un array list o arbol si todos son
            // serializables
            System.out.println("Leyendo objetos binarios en:"+fichero.getAbsolutePath());

            // Se lee el primer objeto
            Empleado emp1 = (Empleado)f.readObject();
            System.out.println(emp1.toString());
            Empleado emp2 = (Empleado)f.readObject();
            System.out.println(emp2.toString());
            Stack<Empleado> pila= (Stack<Empleado>) f.readObject();
            System.out.println(pila.pop().toString());
            System.out.println(pila.pop().toString());
            System.out.println(pila.empty());
                /*
                while(aux!=null){
                    if (aux instanceof Empleado){
                        System.out.println(aux.toString());
                    }
                    // Leemos si hay mas objetos
                    aux=(Empleado)f.readObject();

                }
                */
        }catch(IOException e){
            //e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            System.err.println("Clases Incompatibles");
        } finally {
            try {
                // Nuevamente aprovechamos el finally para
                // asegurarnos que se cierra el fichero.
                if (f != null)
                    f.close();
                System.out.println("Fichero cerrado");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

}
