/**
 * 
 */
package IMPLEMENTACION;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import INTERFACES.GestorImpresoras;
import MODEL.Impresora;

/**
 * @author ofici
 *
 */
public class ImpresorasImpl implements GestorImpresoras {
    private List<Impresora> impresoras = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
	
    @Override
    public void guardar(Impresora impresora) {
        // Verificar si ya existe una impresora con el mismo modelo
        boolean existe = false;
        for (Impresora imp : impresoras) {
            if (imp.getModelo().equalsIgnoreCase(impresora.getModelo())) {
                existe = true;
                break;
            }
        }

        if (!existe) {
            impresoras.add(impresora);
            System.out.println("Impresora guardada correctamente.");
        } else {
            System.out.println("Ya existe una impresora con ese modelo.");
            // Solicitar un nuevo nombre/modelo para la impresora
            System.out.print("Ingrese un nuevo modelo de impresora: ");
            String nuevoModelo = scanner.nextLine();
            // Crear una nueva impresora con el nuevo modelo
            Impresora nuevaImpresora = new Impresora(nuevoModelo, impresora.getSerie(), impresora.getPrecio());
            // Llamar de nuevo a guardar con la nueva impresora
            guardar(nuevaImpresora);
        }
    }

    @Override
    public void listar() {
        // Implementaci�n del m�todo listar
        for (Impresora impresora : impresoras) {
            System.out.println(impresora);
        }
    }

    @Override
    public Impresora buscarPorModelo(String modelo) {
        // Implementaci�n del m�todo buscarPorModelo
        for (Impresora impresora : impresoras) {
            if (impresora.getModelo().equalsIgnoreCase(modelo)) {
                return impresora;
            }
        }
        return null;
    }

    @Override
    public void editar(String modelo, long nuevaSerie, float nuevoPrecio) {
        // Implementaci�n del m�todo editar
        Impresora impresora = buscarPorModelo(modelo);
        if (impresora != null) {
            impresora.setSerie(nuevaSerie);
            impresora.setPrecio(nuevoPrecio);
            System.out.println("Impresora editada correctamente.");
        } else {
            System.out.println("No se encontr� una impresora con ese modelo.");
        }
    }

    @Override
    public void eliminar(String modelo) {
        // Implementaci�n del m�todo eliminar
        Impresora impresora = buscarPorModelo(modelo);
        if (impresora != null) {
            impresoras.remove(impresora);
            System.out.println("Impresora eliminada correctamente.");
        } else {
            System.out.println("No se encontr� una impresora con ese modelo.");
        }
    }
}