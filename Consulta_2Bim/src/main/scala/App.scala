
import akka.actor.{Actor, ActorSystem, Props}

// Case class que contiene el mensaje del contador
case class ContadorMensaje(numero: Int)

// Clase Actor contador
class ActorContador extends Actor {

  var contador: Int = 0

  // Función para manejar los mensajes que recibe el actor, en este caso mensajes de tipo ContadorMensaje
  def receive: Receive = {
    case ContadorMensaje(numero) =>
      contador += numero
      sender() ! s"Contador actual: $contador"
  }
}

// Clase Actor consumidor
class ActorConsumidor extends Actor {
  // Función para manejar los mensajes que recibe el actor
  def receive: Receive = {
    case mensaje: String =>
      println(s"Mensaje recibido: $mensaje")
  }
}

object App {
  @main
  def main =
    // Declaramos el sistema de actores
    val system = ActorSystem("SistemaMensajes")

    // Crea los actores contador y consumidor
    val actorContador = system.actorOf(Props(new ActorContador), "actorContador")
    val actorConsumidor = system.actorOf(Props(new ActorConsumidor), "actorConsumidor")


    // Simulamos el envío de mensajes desde el contador al consumidor
    actorContador.!(ContadorMensaje(1))(actorConsumidor)

    // Esperar un tiempo para procesar los mensajes
    Thread.sleep(1000)

    // Detener el sistema de actores
    system.terminate()
}
