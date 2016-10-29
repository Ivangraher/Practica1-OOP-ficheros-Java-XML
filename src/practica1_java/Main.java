package practica1_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import utilidades_libreria.Fichero;
import utilidades_libreria.InputData;

public class Main {

    private static Fichero miFichero;
    private static ListaCliente misClientes;

    public static void main(String[] args) {
        miFichero = new Fichero("cliente.xml");
        misClientes = (ListaCliente) miFichero.leer();
        if (misClientes == null) {
            misClientes = new ListaCliente();
        }
        int opcion;
        do {
            mostrarmenu();
            opcion = InputData.pedirEntero("Selecciona una de las opciones del menú:");
            switch (opcion) {
                case 1:
                    altaCliente();
                    break;

                case 2:
                    altaPresupuesto();
                    break;

                case 3:
                    presupuestosPendientes();
                    break;

                case 4:
                    listadoPresupuestos_Cliente();
                    break;

                case 5:
                    presupuestosRechazados();
                    break;

                case 6:
                    listadoClientes();
                    break;

                case 7:
                    cambiarEstado_Presupuesto();
                    break;

                case 8:
                    System.out.println("Has salido del menú");
                    break;
            }
        } while (opcion != 8);
    }

    private static void mostrarmenu() {
        System.out.println("---Gestionar datos---");
        System.out.println("1- Nuevo cliente");
        System.out.println("2- Nuevo presupuesto");
        System.out.println("3- Presupuestos pendientes (de aceptar o rechazar).");
        System.out.println("4- Listado de presupuestos de un cliente determinado");
        System.out.println("5- Listado de presupuestos rechazados");
        System.out.println("6- Listado de clientes");
        System.out.println("7- Cambiar estado presupuesto");
        System.out.println("8 - Salir");
    }

    private static void altaCliente() {
        String nombre = cadenaNoVacia("Escribe tu nombre:");
        String apellido = cadenaNoVacia("Escribe tu apellido:");
        String telefono = cadenaNoVacia("Escribe tu telefono");
        if (misClientes.existeTelefono(telefono)) {
            System.out.println("El telefono ya esta registrado");
        } else {
            String cliente_vip = cadenaNoVacia("¿Eres cliente VIP?(S/N)");
            boolean vip;
            if (cliente_vip.equalsIgnoreCase("S")) {
                vip = true;
            } else {
                vip = false;
            }
            Cliente c = new Cliente(nombre, apellido, telefono, vip);
            misClientes.altaCliente(c);
            miFichero.grabar(misClientes);
        }
    }

    private static void altaPresupuesto() {
        String telefono = cadenaNoVacia("Escribe el telefono:");
        if (misClientes.existeTelefono(telefono)) {
            System.out.println("El cliente con este telefono ya esta registrado");
            Integer numero_presupuesto = InputData.pedirEntero("Escribe el numero del presupuesto");
            for (Cliente c : misClientes.getListaClientes()) {
                for (Presupuesto presu : c.getLista().getListaPresupuestos()) {
                    if (presu.getNumero_presupuesto() == numero_presupuesto) {
                        System.out.println("Este nº de presusupuesto ya esta registrado");
                    } else if(presu.getNumero_presupuesto() != numero_presupuesto){
                        String concepto = InputData.pedirCadena("Escribe el concepto del presupuesto:");
                        double precio_total = InputData.pedirDouble("Escribe el precio del presupuesto");
                        String estado = cadenaNoVacia("El presupuesto esta acceptado, rechazado o pendiente: A/R/P");
                        c = misClientes.obtenerTelefonoCliente(telefono);
                        presu = new Presupuesto(numero_presupuesto, concepto, precio_total, estado);
                        // Añadimos el presupuesto a la lista de presupuestos del cliente
                        c.getLista().altaPresupuesto(presu);
                        miFichero.grabar(misClientes);
                    }else {
                altaCliente();
                altaPresupuesto();
            }
                }
            }

        }
    }

    private static String cadenaNoVacia(String msg) {
        String cadena;
        do {
            cadena = InputData.pedirCadena(msg);
            if (cadena.equals("")) {
                System.out.println("No se puede dejar en blanco");
            }
        } while (cadena.equals(""));
        return cadena;
    }

    private static void presupuestosPendientes() {
        for (Cliente c : misClientes.getListaClientes()) {
            for (Presupuesto presu : c.getLista().getListaPresupuestos()) {
                if (presu.getEstado().equalsIgnoreCase("P")) {
                    System.out.println(" El cliente " + c.getNombre() + " con apellido " + c.getApellido() + " tiene " + presu + " pendientes ");
                }
            }
        }
    }

    private static void listadoPresupuestos_Cliente() {
        String telefono = cadenaNoVacia("Escribe el telefono:");
        Cliente c = misClientes.obtenerTelefonoCliente(telefono);
        if (c != null) {
            for (Presupuesto presu : c.getLista().getListaPresupuestos()) {
                System.out.println(presu.toString());
            }

        }
    }

    private static void presupuestosRechazados() {
        for (Cliente c : misClientes.getListaClientes()) {
            for (Presupuesto presu : c.getLista().getListaPresupuestos()) {
                if (presu.getEstado().equalsIgnoreCase("R")) {
                    System.out.println(" El cliente " + c.getNombre() + " con apellido " + c.getApellido() + " tiene " + presu + " rechazados ");
                }
            }
        }
    }

    private static void listadoClientes() {
        for (Cliente c : misClientes.getListaClientes()) {
            for (Presupuesto presu : c.getLista().getListaPresupuestos()) {
                System.out.println(" El cliente " + c + " " + " tiene " + presu);
            }
        }
    }

    private static void cambiarEstado_Presupuesto() {
        Integer numero_presupuesto = InputData.pedirEntero("Escribe el nº del presupuesto:");
        for (Cliente c : misClientes.getListaClientes()) {
            for (Presupuesto presu : c.getLista().getListaPresupuestos()) {
                if (numero_presupuesto == presu.getNumero_presupuesto()) {
                    System.out.println(presu.getEstado());
                    String estado = cadenaNoVacia("El presupuesto esta acceptado, rechazado o pendiente: A/R/P");
                    presu.setEstado(estado);
                    miFichero.grabar(misClientes);
                } else {
                    System.out.println("El presupuesto solicitado con ese nº no existe");
                }
            }
        }
    }

}
