/**
 * Observer
 * @author AnoshinVasili
 *
 * @param <T>
 */
public interface Observer<T> {
	 void Add(T person);

     void Remove(T person);
}
