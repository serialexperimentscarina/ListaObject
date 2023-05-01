package br.com.serialexperimentscarina.listaobject;

public interface ILista {
	
	public boolean isEmpty();
	public int size();
	public void addFirst(Object objeto);
	public void addLast(Object objeto) throws Exception;
	public void add(Object objeto, int pos) throws Exception;
	public void removeFirst() throws Exception;
	public void removeLast() throws Exception;
	public void remove(int pos) throws Exception;
	public Object get(int pos) throws Exception;

}
