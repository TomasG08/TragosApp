package com.cursoandroid.appkotlin.data

import com.cursoandroid.appkotlin.data.model.Drink
import com.cursoandroid.appkotlin.vo.Resource

class DataSource {

     val generateTragosList = Resource.Success(listOf(
        Drink("https://cdn5.recetasdeescandalo.com/wp-content/uploads/2018/09/Coctel-margarita-como-prepararlo.-Receta-e-ingredientes.jpg","Margarita","Fresa, tequila y hielos"),
        Drink("https://ep00.epimg.net/elcomidista/imagenes/2012/08/23/receta/1345698000_134569_1345698000_noticia_normal.jpg","Michelada","Cerveza, limon y sal"),
        Drink("https://animalgourmet.com/wp-content/uploads/2017/05/perlas_negras-bebidas_MILIMA20161007_0341_8.jpg","Perla negra", "Jägermeister, redbull, hielos"),
        Drink("https://445725.smushcdn.com/570282/wp-content/uploads/2019/07/como-preparar-un-mojito-cubano-ingrediente-y-recetas.jpg?lossy=1&strip=1&webp=1", "Mojito","Ron, hierbabuena, sprite"),
        Drink("https://cdn2.cocinadelirante.com/sites/default/files/styles/gallerie/public/images/2019/04/receta-clericot-sin-alcohol.jpg", "Clericot","Vino tinto, frutas a elección, sprite")
    ))

}