/**
 * 
 */
package MAIN;

import java.util.Scanner;

import IMPLEMENTACION.ImpresorasImpl;
import INTERFACES.GestorImpresoras;
import MODEL.Impresora;

/**
 * @author ofici
 *
 */
public class Principal {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		GestorImpresoras gestorImpresoras = new ImpresorasImpl();

		int opcion;
		do {
			System.out.println("Menu Principal");
			System.out.println("1---Guardar");
			System.out.println("2---Listar");
			System.out.println("3---Buscar por modelo");
			System.out.println("4---Editar buscando por modelo");
			System.out.println("5---Eliminar buscando por modelo");
			System.out.println("6---Salir");
			System.out.print("Seleccione una opción: ");
			opcion = scanner.nextInt();
			scanner.nextLine(); 

			switch (opcion) {
			case 1:
				System.out.print("Ingrese el modelo de la impresora: ");
				String modelo = scanner.nextLine();
				System.out.print("Ingrese el número de serie de la impresora: ");
				long serie = scanner.nextLong();
				System.out.print("Ingrese el precio de la impresora: ");
				float precio = scanner.nextFloat();
				scanner.nextLine(); 
				gestorImpresoras.guardar(new Impresora(modelo, serie, precio));
				break;
			case 2:
				gestorImpresoras.listar();
				break;
			case 3:
				System.out.print("Ingrese el modelo de la impresora a buscar: ");
				String modeloBuscar = scanner.nextLine();
				Impresora impresoraEncontrada = gestorImpresoras.buscarPorModelo(modeloBuscar);
				if (impresoraEncontrada != null) {
					System.out.println("Impresora encontrada: " + impresoraEncontrada);
				} else {
					System.out.println("No se encontró una impresora con ese modelo.");
				}
				break;
			case 4:
				System.out.print("Ingrese el modelo de la impresora a editar: ");
				String modeloEditar = scanner.nextLine();
				System.out.print("Ingrese la nueva serie de la impresora: ");
				long nuevaSerie = scanner.nextLong();
				System.out.print("Ingrese el nuevo precio de la impresora: ");
				float nuevoPrecio = scanner.nextFloat();
				scanner.nextLine(); 
				gestorImpresoras.editar(modeloEditar, nuevaSerie, nuevoPrecio);
				break;
			case 5:
				System.out.print("Ingrese el modelo de la impresora a eliminar: ");
				String modeloEliminar = scanner.nextLine();
				gestorImpresoras.eliminar(modeloEliminar);
				break;
			case 6:
				System.out.println("Saliendo del programa...");
				break;
			default:
				System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
			}
		} while (opcion != 6);

		scanner.close();
	}
}
