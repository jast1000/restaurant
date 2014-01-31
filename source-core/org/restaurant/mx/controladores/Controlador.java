package org.restaurant.mx.controladores;

import java.util.List;

/**
 *
 * @author JAST
 */
public abstract class Controlador<T> {

	public abstract boolean eliminar(T clazz);

	public abstract boolean actualizar(T clazz);

	public abstract boolean agregar(T clazz);

	public abstract T buscar(Object id);

	public abstract List<T> listar();

	public abstract String listaCampos();
}
