package br.com.serialexperimentscarina.listaobject;

public class ListaObject implements ILista{
	
	No primeiro;
	
	public ListaObject() {
		primeiro = null;
	}

	@Override
	public boolean isEmpty() {
		return (primeiro == null);
	}

	@Override
	public int size() {
		int cont = 0;
		No auxiliar = primeiro;
		
		while (auxiliar != null) {
			auxiliar = auxiliar.proximo;
			cont++;;
		}
		return cont;
	}

	@Override
	public void addFirst(Object objeto) {
		No elemento = new No();
		elemento.objeto = objeto;
		elemento.proximo = primeiro;
		primeiro = elemento;
	}

	@Override
	public void addLast(Object objeto) throws Exception {
		No elemento = new No();
		elemento.objeto = objeto;
		elemento.proximo = null;
		if (isEmpty()) {
			primeiro = elemento;
		} else {
			No ultimo = getNo(size() - 1);
			ultimo.proximo = elemento;
		}
	}

	@Override
	public void add(Object objeto, int pos) throws Exception {
		if (isEmpty() && pos != 0) {
			throw new Exception("Lista vazia!");
		}
		if (pos < 0 || pos > size()) {
			throw new Exception("Posição inválida!");
		}
		if (pos == 0) {
			addFirst(objeto);
		} else if (pos == size()) {
			addLast(objeto);
		} else {
			No elemento = new No();
			No anterior = getNo(pos - 1);
			
			elemento.objeto = objeto;
			elemento.proximo = anterior.proximo;
			anterior.proximo = elemento;
		}
	}

	@Override
	public void removeFirst() throws Exception {
		if (isEmpty()) {
			throw new Exception("Lista vazia!");
		}
		primeiro = primeiro.proximo;
	}

	@Override
	public void removeLast() throws Exception {
		if (isEmpty()) {
			throw new Exception("Lista vazia!");
		}
		if (size() == 1) {
			removeFirst();
		} else {
			No anterior = getNo(size() - 2);
			anterior.proximo = null;
		}
	}

	@Override
	public void remove(int pos) throws Exception {
		if (isEmpty()) {
			throw new Exception("Lista vazia!");
		}
		if (pos < 0 || pos >= size()) {
			throw new Exception("Posição inválida!");
		}
		if (pos == 0) {
			removeFirst();
		} else if (pos == size() - 1) {
			removeLast();
		} else {
			No atual = getNo(pos);
			No anterior = getNo(pos - 1);
			
			anterior.proximo = atual.proximo;
		}
	}

	@Override
	public Object get(int pos) throws Exception {
		return getNo(pos).objeto;
	}
	
	private No getNo(int pos) throws Exception{
		if (isEmpty()) {
			throw new Exception("Lista vazia!");
		}
		if (pos < 0 || pos >= size()) {
			throw new Exception("Posição inválida!");
		}
		No auxiliar = primeiro;
		int cont = 0;
		
		while (cont < pos) {
			auxiliar = auxiliar.proximo;
			cont++;;
		}
		return auxiliar;
	}

}
