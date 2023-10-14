package br.com.fiap.dao;

public interface Dao<E> {
	
	public void cadastrar(E p) throws Exception;
	
	public void alterar(E p) throws Exception;
	
	public E consultaNome(String nome) throws Exception;
	
//	public void apaga(long id) throws Exception;

}