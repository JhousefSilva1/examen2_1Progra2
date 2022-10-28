import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class estudiante{


    static Scanner entrada = new Scanner(System.in);
    
    
    static String nombre;
    static int edad;
    static double promedio;

    static double MejorPromedio=0;
    static double PeorPromedio=0;
 

    public static void main(String [] args) {
    
        menu();
       // IngresarDatos();
        //name1LeerDatos();

    }

    //menu switch case
    public static void menu() {
        int opcion;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("1. Ingresar datos\n2. Leer datos\n3. Salir"));
            switch (opcion) {
                case 1:
                    IngresarDatos();
                    break;
                case 2:
                    LeerDatos();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion no valida");
                    break;
            }
        } while (opcion != 3);
    }
    
    
    public static void IngresarDatos(){

        //crear archivo binario
        try{
            DataOutputStream archivo = new DataOutputStream(new FileOutputStream("estudiante.dat"));

            int cant=5;

            //registrar 5 estudiantes

            for(int i=0; i<cant; i++){
                System.out.println("Ingrese el nombre del estudiante: ");
                nombre = entrada.nextLine();
                System.out.println("Ingrese la edad del estudiante: ");
                edad = entrada.nextInt();
                System.out.println("Ingrese el promedio del estudiante: ");
                promedio = entrada.nextDouble();
                entrada.nextLine();

                //escribir en el archivo
                archivo.writeUTF(nombre);
                archivo.writeInt(edad);
                archivo.writeDouble(promedio);
            }
    
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al crear el archivo");
        }

    
    }

    //leer el archuvo binario
    public static void LeerDatos(){
        try{
            DataInputStream archivo = new DataInputStream(new FileInputStream("estudiante.dat"));

            int cant=5;

            //registrar 5 estudiantes

            for(int i=0; i<cant; i++){
                nombre = archivo.readUTF();
                edad = archivo.readInt();
                promedio = archivo.readDouble();

                System.out.println("Nombre: "+nombre);
                System.out.println("Edad: "+edad);
                System.out.println("Promedio: "+promedio);
            }
    
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al crear el archivo");
        }
    }
//mejor promedio
    /**
     * 
     */
    public static void mejorPromedio() {
        
        try{
            try (DataInputStream archivo = new DataInputStream(new FileInputStream("estudiante.dat"))) {
                int cant=5;

                

                for(int i=0; i<cant; i++){
                    nombre = archivo.readUTF();
                    edad = archivo.readInt();
                    promedio = archivo.readDouble();

                    System.out.println("Nombre: "+nombre);
                    System.out.println("Edad: "+edad);
                    System.out.println("Promedio: "+promedio);

                    if(promedio>MejorPromedio){
                        MejorPromedio=promedio;
                    }

                }

                JOptionPane.showMessageDialog(null, "El mejor promedio es: "+MejorPromedio);
            }
        
    }catch(Exception e){
        JOptionPane.showMessageDialog(null, "Error al crear el archivo");
    }
    }   

    //peor promedio
    public static void peorPromedio() {
        

        
        try{
            try (DataInputStream archivo = new DataInputStream(new FileInputStream("estudiante.dat"))) {
                int cant=5;

                

                for(int i=0; i<cant; i++){
                    nombre = archivo.readUTF();
                    edad = archivo.readInt();
                    promedio = archivo.readDouble();

                    System.out.println("Nombre: "+nombre);
                    System.out.println("Edad: "+edad);
                    System.out.println("Promedio: "+promedio);

                    if(PeorPromedio<MejorPromedio){
                        PeorPromedio=promedio;
                    }

                }

                JOptionPane.showMessageDialog(null, "El peor promedio es: "+PeorPromedio);
            }


 
    }catch(Exception e){
    JOptionPane.showMessageDialog(null, "Error al crear el archivo");
    }
    }   


}

    
    
