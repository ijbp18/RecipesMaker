val listaIngredientes: List<String> =
    listOf("Agua", "Leche", "Carne", "Verduras", "Frutas", "Cereal", "Huevos", "Aceite")

fun main() {
    showMenu()
}

fun showMenu() {

    var listaIngredientesSeleccionados: MutableList<String> = arrayListOf()

    do {
        val menuStr: String = """
        :: Bienvenido a Recipe Maker ::


        Selecciona la opción deseada
        1. Hacer una receta
        2. Ver mis recetas
        3. Salir
        """.trimIndent()
        println(menuStr)

        val userSelection: String? = readLine()

        var exit = false
        when (userSelection?.toInt()) {
            1 -> listaIngredientesSeleccionados = makeRecipe()
            2 -> viewRecipe(listaIngredientesSeleccionados)
            3 -> {
                println("Seleccionó la opción salir, bye!")
                exit = true
            }
            else -> println("Seleccione una opción válida")
        }

    } while (!exit)
}


fun viewRecipe(listaIngredientesSeleccionados: MutableList<String>) {

    if (listaIngredientesSeleccionados.isNotEmpty()) {
        println("Los ingredientes seleccionados para tu receta son:")
        for ((index, ingrediente) in listaIngredientesSeleccionados.withIndex()) {
            println("| ${index.plus(1)}- $ingrediente")
        }
    } else println("No tienes ingredientes hasta el momento :(")


}

fun makeRecipe(): MutableList<String> {

    val listaIngSeleccionado: MutableList<String> = arrayListOf()
    do {
        println("\nSeleccione uno o más ingredientes necesarios para tu receta\nElija el número correspondiente al ingrediente")
        for ((index, ingrediente) in listaIngredientes.withIndex()) {
            println("| ${index.plus(1)} : $ingrediente")
        }
        println("| 0 Para regresar al menú principa")

        val ingredienteSelection: Int = readLine()?.toInt() ?: 0
        if (ingredienteSelection != 0) {
            println("\nEl ingrediente que eligió es ${listaIngredientes[ingredienteSelection.minus(1)]}")
            listaIngSeleccionado.add(listaIngredientes[ingredienteSelection.minus(1)])
        }

    } while (ingredienteSelection != 0)

    return listaIngSeleccionado

}
