/**
 * @author El babili - 2023
 * 
 */

package fr.fms.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.logging.Logger;

public interface Dao<T> {
	public static Connection connection = BddConnection.getConnection();
	
	public static final Logger logger = Logger.getLogger(Dao.class.getName());
	
	/**
	 * ajout d'une nouvelle occurence en base
	 * @param obj correspond à un enregistrement
	 */
	public boolean create(T obj);	
	
	/**
	 * renvoi un objet correspondant à l'id en base
	 * @param id de l'objet
	 * @return l'objet correspondant, si non trouvé, renvoi null
	 */
	public T read(int id);		
	
	/**
	 * met à jour l'objet en base
	 * @param obj
	 * @return vrai si c'est fait, sinon faux
	 */
	public boolean update(T obj);	
	
	/**
	 * supprime un objet en base
	 * @param obj
	 * @return vrai si c'est fait, sinon faux
	 */
	public boolean delete(T obj);	
	
	/**
	 * renvoi tous les objets de la table correspondante
	 * @return ArrayList<T> correspondant 
	 */
	public ArrayList<T> readAll();
}
