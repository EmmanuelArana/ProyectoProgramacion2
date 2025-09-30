/*
Software para administrar las ventas de tiquetes en un cine.
Emmanuel Arana
Christian Mora
version 1.0
14 octubre 2025
 */
package com.mycompany.proyectoprogramacion2;
//Prueba numero 2

import java.text.DecimalFormat;
import java.util.Date;
import java.util.Scanner;

public class ProyectoProgramacion2 {

    public static void main(String[] args) {
        // Declaración de variables
        Scanner entrada = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("##.00");
        Date fecha = new Date();

        // Array
        int limiteEntrada = 50;// Aqui se restara los productos para el limite, es fijo para hacer la pruebas
        String[] cedula = new String[limiteEntrada];
        String[] nombreCliente = new String[limiteEntrada];
        double[] comprasClientes = new double[limiteEntrada];

        //Variables
        int entrada2DPrecio, entrada3DPrecio, entrada2DCantidad, entrada3DCantidad,
                i, opcion, submenuOpcion, indexCliente, indexCedula, indexCompraCliente;
        double impuesto, montoCobro, resultadoCalculoIva;
        boolean submenuEstado;
        
        //Hacer indexCliente, indexCedula, indexCompraCliente una solo index

        // Inicialización de variables
        i = 0;
        entrada2DPrecio = 2800;
        entrada3DPrecio = 3200;
        entrada2DCantidad = 0;
        entrada3DCantidad = 0;
        impuesto = 0.13;
        montoCobro = 7.0;
        resultadoCalculoIva = 0.0;
        submenuEstado = true;

        //Indices
        indexCliente = indexCedula = indexCompraCliente = 0;

        //Proceso de datos
        do {
            System.out.println("Digite la opcion que desee"
                    + "\n1) Nuevo Cliente"
                    + "\n2) Estadistica"
                    + "\n3) Salir del Sistema");
            opcion = entrada.nextInt();

            //Esto lo que hace es medir el limite de no ser superado
            if (indexCliente == limiteEntrada) {
                opcion = 4; // Para que salga
                System.out.println("No hay mas espacio para clientes");
            }
            if (indexCedula == limiteEntrada) {
                opcion = 4; // Para que salga
                System.out.println("No hay mas espacio para cedula");
            }
            if (indexCompraCliente == limiteEntrada) {
                opcion = 4; // Para que salga
                System.out.println("No hay mas espacio para compras");
            }

            switch (opcion) {
                case 1:

                    //Ciclo While
                    while (submenuEstado) {

                        System.out.println("Digite la opcion de submenu deseado"
                                + "\n1) Comprar producto"
                                + "\n2) Visualizar Venta"
                                + "\n3) Finalizar Venta");

                        //Entrada Usuario
                        submenuOpcion = entrada.nextInt();

                        switch (submenuOpcion) {
                            case 1:
                                System.out.println("Digite el nombre del cliente");
                                nombreCliente[indexCliente] = entrada.nextLine();
                                
                                System.out.println("Digite la cedula del Cliente");
                                cedula[indexCedula] = entrada.nextLine();
                                break;
                            case 2:
                                //Ademas hacer los calculos para que salga la factura bien
                                //Escribe por whats si lees esto Chris

                                //Salida de la factura
                                System.out.println("          CASH RECEIPT");
                                System.out.println("----------------------------------");
                                System.out.println("Shop:   " + "Cinema");
                                System.out.println("Date:   " + fecha);
                                System.out.println("Cliente " + nombreCliente[indexCliente]);
                                System.out.println("Cedula  " + cedula[indexCedula]);
                                System.out.println("----------------------------------");

                                System.out.println("Entrada 2D " + entrada2DCantidad + "* " + entrada2DPrecio);
                                System.out.println("Entrada 3D " + entrada3DCantidad + "* " + entrada3DPrecio);

                                System.out.println("----------------------------------");
                                System.out.printf("Impuesto:          " + df.format(impuesto));
                                System.out.println("Deduccion:        " + df.format(resultadoCalculoIva));
                                System.out.println("----------------------------------");
                                System.out.printf("Total:             " + df.format(montoCobro) + "\n\n");

                                break;
                            case 3:
                                //Aqui hacer el calculo de monto cobro
                                comprasClientes[indexCompraCliente] = montoCobro;
                                indexCompraCliente++;
                                submenuEstado = false;
                                //Esto es para recorrer todo el arreglo de clientes
                                indexCliente++;
                                break;
                            default:
                                System.out.println("Opcion de submenu no valida");

                        }//Cierra switch submenu
                    }
                    break;
                case 2:
                    System.out.println("Estadistica");
                    break;
                case 3:
                    System.out.println("Salir");
                    break;
                default:
                    System.out.println("Opcion invalida vuelva a intentarlo");
            }//Cierra switch menu
        } while (opcion != 3);

    }//Cierre main
}//Cierre Clase
