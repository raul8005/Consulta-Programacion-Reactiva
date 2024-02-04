
import akka.actor.ActorSystem //framework para construir sistemas concurrentes y distribuidos
import akka.stream.scaladsl.{Sink, Source}//proporciona un modelo de programación reactiva para el procesamiento de flujos de datos

object Ejemplo extends App{//Heredala capacidad de tener un método main a traves de
                                   // extends APP
    // Crea el sistema de actores
    // permite construir sistemas concurrentes y distribuidos de maneraescalable
    implicit val system: ActorSystem = ActorSystem("ReactiveExampleSystem")

    // Define un flujo de datos con números fijos
    //OBSERVABLE
    val numerosFijos = List(20, 55, 30, 70, 40, 90, 60)

    // Creamos un flujo de datos a partir de la lista de números
    val flujonumerosFijos = Source(numerosFijos)

    // Definimos un flujo de datos que filtre solo números mayores que 50
    val numerosFiltrados = flujonumerosFijos.filter(_ > 50)

    // Crea un flujo de numeros enteros y lo imprimimos
    // Define un sumidero que imprime los números filtrados
    val printSink = Sink.foreach[Int](num => println(s"Número filtrado: $num"))

    // Conecta el flujo de generación, el flujo de filtro y el sumidero
    val reactivePipeline = numerosFiltrados.to(printSink)

    // Ejecuta el flujo de datos
    reactivePipeline.run()

    //Esta es la etapa final del flujo de datos
    Thread.sleep(2000)//Espera un tiempo, luego que termine el sistema
    system.terminate()// Una vez finalizada la transmicion, terminamos el sistema de actores

}
