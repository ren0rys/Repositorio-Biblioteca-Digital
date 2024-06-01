import java.util.ArrayList;
import java.util.List;
/** Interfaz Subscriber que define el método de actualización para los suscriptores.*/
interface Subscriber {
    /** Método que se llama cuando hay una actualización para el suscriptor.
     * @param message el mensaje de actualización*/
    void update(String message);
}
/**La clase Subscription maneja una lista de suscriptores y proporciona métodos para suscribirse,
 * desuscribirse y notificar a los suscriptores.*/
class Subscription {
    private List<Subscriber> subscribers = new ArrayList<>();
/**Suscribe un nuevo suscriptor a la lista de suscriptores.
    * @param subscriber el suscriptor a añadir*/
    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }
/** Desuscribe un suscriptor de la lista de suscriptores.
     * @param subscriber es el suscriptor a remover
     */
    public void unsubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }
 /** Notifica a todos los suscriptores con un mensaje.
     * @param message es el mensaje a enviar a los suscriptores
     */
    public void notifySubscribers(String message) {
        for (Subscriber subscriber : subscribers) {
            subscriber.update(message);
        }
    }
 /**Obtiene la lista de suscriptores.
     * @return la lista de suscriptores
     */

    public List<Subscriber> getSubscribers() {
        return subscribers;
    }
}





