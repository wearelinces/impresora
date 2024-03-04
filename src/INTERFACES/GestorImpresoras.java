/**
 * 
 */
package INTERFACES;

import MODEL.Impresora;

/**
 * @author ofici
 *
 */
public interface GestorImpresoras {
	void guardar(Impresora impresora);

	void listar();

	Impresora buscarPorModelo(String modelo);

	void editar(String modelo, long nuevaSerie, float nuevoPrecio);

	void eliminar(String modelo);
}
