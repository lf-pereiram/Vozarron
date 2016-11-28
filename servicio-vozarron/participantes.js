/**
* Se crea el modelo de películas para la base de datos mongo 
*/
var mongoose = require('mongoose'),
Schema   = mongoose.Schema;

 //esquema del modelo
 var participanteSchema = new Schema({
 	nombre:    { type: String },
 	edad:     { type: Number },
 	rol: 	  { type: Number},
 	numVotos: { type: Number},
 	url:   { type: String },
 	estado:  { type: Boolean }
});

//se exporta el esquema creado
module.exports = mongoose.model('Participante', participanteSchema);
