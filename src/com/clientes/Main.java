package com.clientes;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.clases.Clientes;
import com.clases.Empresas;
import com.clases.Producto;

public class Main {
	
	static Scanner in = new Scanner(System.in);
	

	public static void main(String[] args) {
		
		
		ArrayList<Clientes> clientes = new ArrayList<Clientes>();
		ArrayList<Producto> productos = new ArrayList<Producto>();
		ArrayList<Empresas> empresas = new ArrayList<Empresas>();
		
		String menu = "Hola, empezemos la gestión:\n" 
				+ "        * 1 Agregar cliente\n" 
				+ "         * 2 Editar cliente\n"
				+ "         * 3 Eliminar cliente\n" 
				+ "         * 4 Agregar productos\n"
				+ "         * 5 Registrar empresa\n"
				+ "         * 6 conocer valor producto por empresa o persona(polimorfismo)\n"
				+ "         * 0 salir de la aplicacion";

		// Uso clico do while() para iniciar menu
		Integer opMenu = new Integer(0);
		/**
		 * Segun el concepto de polimorfismo un objeto puede tener multiples formas con
		 * la estructura de clase que se entrega por favor implementar el concepto de
		 * poliformismo
		 */
		
		boolean salida= false;

		do {
			try {

				System.out.println(menu);
				String opcion = in.next();

				opMenu = Integer.parseInt(opcion);

				switch (opMenu.toString()) {
					case "1": clientes.add(addCustomer());
						break;
						
					case "2": if(clientes.size()==0) {
								System.out.println("No se han ingresado clientes.");
								}else {
									updateCustomer(clientes);
								} 
						break;
					case "3":if(clientes.size()==0) {
						System.out.println("No se han ingresado clientes.");
						}else {
							removeCustomer(clientes);
						} 
						break;
					case "4": productos.add(addProduct());
						break;
					case "5": empresas.add(addCompany());
						break;
					case "6":
						break;
					case "0":
						System.out.println("Muchas gracias por usar nuestra app, hasta luego");
						salida= false;
						break;
					default:
						System.out.println("El valor ingresado no es una opcion de menu");
						break;
				}
			} catch (InputMismatchException | NumberFormatException e) {
				System.out.println("Valor Invalido");
				salida=true;
			}

		} while (!opMenu.toString().equals("0") || salida);
		in.close();
		
		
	}
	
	
	//////////Agregar Cliente//////////////////
	
	public static Clientes addCustomer() {
		Clientes cliente = new Clientes();
		
		System.out.println("Ingresa el nombre del cliente ");
		cliente.setNombre(in.next());
		
		System.out.println("Ingresa el telefono");
		cliente.setTelefono(in.next());
		
		System.out.println("Ingresa la direccion");
		cliente.setDireccion(in.next());
		
		return cliente;
	};
	
	
	
	
     //////////Modificar Cliente//////////////////
	
	public static void updateCustomer(ArrayList<Clientes> clientes) {
		System.out.println("Los siguuientes son los clientes que puedes editar:");
		boolean encontrado= false;
		int indx= 0;
		
		for(int i=0; i< clientes.size(); i++) {
			System.out.println(clientes.get(i).getNombre());
		}
		
		System.out.println("Escribe el nombre del cliente que quieres editar");
		String nombreCambio= in.next();
		
		for(int i=0; i< clientes.size(); i++) {
			Clientes auxCliente= clientes.get(i);
			
			if(nombreCambio.equalsIgnoreCase(auxCliente.getNombre())) {
				System.out.println("Ingresa el nuevo nombre del cliente ");
				auxCliente.setNombre(in.next());
				
				System.out.println("Ingresa el nuevo telefono del cliente");
				auxCliente.setTelefono(in.next());
				
				System.out.println("Ingresa la nueva direccion cliente");
				auxCliente.setDireccion(in.next());
				encontrado=true;
				indx= i;
				break;
			}
		}
		
		if(!encontrado) {
			System.out.println("El cliente que ingresaste no existe.");
		} else {
			System.out.println("Actualizado con exito");
			System.out.println("Nombre: "+ clientes.get(indx).getNombre());
			System.out.println("Telefono: "+ clientes.get(indx).getTelefono());
			System.out.println("Direccion: "+ clientes.get(indx).getDireccion());
		}
	}
	
	
//////////Eliminar Cliente//////////////////
	
	public static void removeCustomer(ArrayList<Clientes> clientes) {
		System.out.println("Los siguientes son los clientes que puedes eliminar:");
		boolean encontrado= false;
		int indx= 0;
		
		for(int i=0; i< clientes.size(); i++) {
			System.out.println(clientes.get(i).getNombre());
		}
		
		System.out.println("Escribe el nombre del cliente que quieres eliminar");
		String nombreCambio= in.next();
		
		for(int i=0; i< clientes.size(); i++) {
			Clientes auxCliente= clientes.get(i);
			
			if(nombreCambio.equalsIgnoreCase(auxCliente.getNombre())) {
				clientes.remove(i);
				encontrado=true;
				indx= i;
				break;
			}
		}
		
		if(!encontrado) {
			System.out.println("El cliente que ingresaste no existe.");
		} else {
			System.out.println("Eliminado con exito");
		}
	}
	
	//////////Agregar producto/////////////////
		
	public static Producto addProduct() {
		Clientes cliente = new Clientes();
		Producto producto = new Producto() {
			
			@Override
			public double ofertaValor() {
				return 0;
			}
		};
			
		
		System.out.println("Ingresa el nombre del producto ");
		producto.setNombre(in.next());
		
		System.out.println("Ingresa las caracteristicas del producto ");
		producto.setCarateristicas(in.next());
		
		producto.setIdProducto(String.valueOf(Math.random()*100+1));
		
		System.out.println("Ingresa las condiciones del producto ");
		producto.setCondiciones(in.next());
		
		boolean control = false;
		while(!control) {
        try {
        	System.out.println("Ingresa el valor del producto");
    		String valor=in.next();
            producto.setValor(Double.parseDouble(valor));
            control= true;
        } catch (NumberFormatException ex) {
            System.out.println("Valor errado");
            control = false;
        }}
		
		return producto;
	}
	
	/////////Agregar Empresa//////////////
	
	public static Empresas addCompany() {
		Empresas empresa= new Empresas();
		
		System.out.println("Ingresa el tipo documento de la empresa ");
		empresa.setTipDoc(in.next());
		
		System.out.println("Ingresa el documento de la empresa");
		empresa.setDocumento(in.next());
		
		System.out.println("Ingresa el representante de la empresa");
		empresa.setRepresentante(in.next());
		
		return empresa;
	};
	
	
	////////////////Agregar producto a una empresa o cliente////////
	
	public static void aggProductToCompanyOrCustomer() {
		
		Integer opMenu = new Integer(0);
		boolean salida= false;

		do {
			try {
				System.out.println("Elige una opción si deseas agregar el producto:\n" 
						+ "        * 1 Agregar a cliente\n"
						+ "         * 2 Agregar a empresa\n" 
						+ "         * 3 Agregar a cliente y empresa\n"
						+ "         * 4 Omitir\n");
				String opcion = in.next();

				opMenu = Integer.parseInt(opcion);

				switch (opMenu.toString()) {
					case "1": 
						break;
					case "2":  
						break;
					case "3":
						break;
					case "0":
						salida= false;
						break;
					default:
						System.out.println("El valor ingresado no es una opcion de menu");
						break;
				}
			} catch (InputMismatchException | NumberFormatException e) {
				System.out.println("Valor Invalido");
				salida=true;
			}

		} while (!opMenu.toString().equals("0") || salida);
	}
	


	
	
	
}
