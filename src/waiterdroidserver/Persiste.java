package waiterdroidserver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Persiste implements Serializable {

	/*
	 * Cria os atributos da classe.
	 */
	private static ObjectInputStream entrada;
	private static ObjectOutputStream saida;

	/**
	 * Método que checa a existência de um arquivo.
	 * @param arq
	 * @return true || false
	 */
	public static boolean abrir(String arq)
	{

			try {
                                File f = new File(arq);
				entrada = new ObjectInputStream(new FileInputStream(f));
				entrada.close();
				return true;
			} catch (FileNotFoundException e) {
                                System.out.print(e.toString());
				return false;
			} catch (IOException e) {
                                System.out.print(e.toString());
				return false;
			}
	}

	/**
	 * Método que grava um objeto no arquivo indicado.
	 * Retorna true em caso positivo, e false em caso negativo.
	 * @param arq, obj
	 * @return true || false
	 */
	public static boolean gravar(String arq, Object obj)
	{
		try {
                        File f = new File(arq);
			saida = new ObjectOutputStream(new FileOutputStream(f));
			saida.writeObject(obj);
			saida.close();
			return true;
		} catch (IOException e) {
                        System.out.print(e.toString());
			return false;
		}
	}

	/**
	 * Método que lê um objeto no arquivo indicado.
	 * Retorna um objeto da superclasse Object em caso positivo, e null em caso negativo.
	 * @param arq
	 * @return obj || false
	 */
	public static Object ler(String arq)
	{
		try {
                        File f = new File(arq);
			entrada = new ObjectInputStream(new FileInputStream(f));
			Object obj = entrada.readObject();
			entrada.close();
			return obj;
		} catch (IOException e) {
                        System.out.print(e.toString());
			return null;
		} catch (ClassNotFoundException e) {
                        System.out.print(e.toString());
			return null;
		}
	}
}