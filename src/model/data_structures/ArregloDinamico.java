package model.data_structures;

/**
 * 2019-01-23
 * Estructura de Datos Arreglo Dinamico de Strings.
 * El arreglo al llenarse (llegar a su maxima capacidad) debe aumentar su capacidad.
 * @author Fernando De la Rosa
 *
 */
public class ArregloDinamico<K extends Comparable<K>> implements IArregloDinamico<K> {
	/**
	 * Capacidad maxima del arreglo
	 */
	private int tamanoMax;
	/**
	 * Numero de elementos presentes en el arreglo (de forma compacta desde la posicion 0)
	 */
	private int tamanoAct;
	/**
	 * Arreglo de elementos de tamaNo maximo
	 */
	private K[] elementos;

	/**
	 * Construir un arreglo con la capacidad maxima inicial.
	 * @param max Capacidad maxima inicial
	 */
	public ArregloDinamico( int max )
	{
		elementos =  (K[]) new Comparable[max];
		tamanoMax = max;
		tamanoAct = 0;

	}

	@Override
	public int darCapacidad() {
		// TODO Auto-generated method stub
		return tamanoMax;
	}

	@Override
	public int darTamano() {
		// TODO Auto-generated method stub
		return tamanoAct;
	}

	@Override
	public K darElemento(int i) {
		// TODO Auto-generated method stub


		return elementos[i];
	}

	@Override
	public void agregar (K dato) {

		if(darCapacidad() == darTamano())
		{
			K[] copia = elementos; 
			tamanoMax = tamanoMax*2;
			elementos = (K[]) new Object[tamanoMax];
			for(int i = 0; i < copia.length; i++)
			{
				elementos[i] = copia[i];
			}
			elementos[tamanoAct] = dato;
			tamanoAct++;
		}
		else
		{
			elementos[tamanoAct]= dato;
		}

		// TODO Auto-generated method stub

	}

	@Override
	public K buscar(K dato) {
		
		K objetoBuscado = null;
		boolean encontro = false;
		
		
		for(int i = 0; i < elementos.length && !encontro; i++ )
		{
			if(elementos[i].compareTo(dato) == 0)
			{
				objetoBuscado = elementos[i];
			}
		}
		// TODO Auto-generated method stub
		return objetoBuscado;
	}

	@Override
	public K eliminar(K dato) {
		
		K datoAEliminar = null;
		boolean elimino = false;
		
		for(int i = 0; i < elementos.length; i++)
		{
			if(elementos[i].compareTo(dato) == 0)
			{
				datoAEliminar = elementos[i]; 
				K[] copia = elementos;
				 System.arraycopy(elementos, i + 1, copia,i, elementos.length - 1 - i);
				 elementos = copia;
				 tamanoAct--;
				 
				 
			}
		}
		// TODO Auto-generated method stub
		return datoAEliminar;
	}


}
