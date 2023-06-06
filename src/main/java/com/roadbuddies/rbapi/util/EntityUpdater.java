package com.roadbuddies.rbapi.util;

import java.lang.reflect.Field;

public class EntityUpdater {

	/**
	 * On utilise la reflexion de java.lang pour update une entité
	 * On déclare dans un tableau les fields (Les attributs) 
	 * On attribut par la suite les nouvelles valeur dans l'entité existante.
	 * 
	 * Ca évite la redondence du code
	 * @param <T>
	 * @param existingEntity
	 * @param newEntity
	 * @return
	 */
	public static <T> T updateEntity (T existingEntity, T newEntity) {
		
		Class<?> entityClass = existingEntity.getClass();
		Field[] fields = entityClass.getDeclaredFields();
		
		for (Field field : fields) {
			try {
				
				field.setAccessible(true);
				Object newValue = field.get(newEntity);
				if (newValue != null) {
					field.set(existingEntity, newEntity);
				}
				
			} catch (IllegalAccessException e) {
				// Exception a gerer au cas ou, ca se passe mal 
				// Pour l'instant pas d'idée de pourquoi ca pourrait mal se passer 
			}
		}
		
		return existingEntity;
	}
}
