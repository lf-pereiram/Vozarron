// se importan las librerías necesarias
var express = require("express"),
app = express(),
bodyParser  = require("body-parser"),
methodOverride = require("method-override");

var mongoose = require("mongoose");

    // conexon con la base de datos
    mongoose.connect("mongodb://localhost/vozarron", function(err, res) {
      if(err) throw err;
      console.log('Base de datos conectada');
  });


//permite implementar y personalizar métodos HTTP.
app.use(bodyParser.urlencoded({ extended: false }));
app.use(bodyParser.json());
app.use(methodOverride());

//se obtiene la referencia a el modelo
var models = require('./participantes')(app, mongoose);
//se obtiene la referencia a los verbos
var ParticipanteCtrl = require('./manager');

//se usa para declarar la ruta de los verbos a usar en el servicio (get, put, delete, update)
var router = express.Router();

router.get('/', function(req, res) {
    res.send("Hola Android!!!");
});

router.get('/api', function(req, res) {
});

app.use(router);

//router para manejar todas las operaciones con los personajes
var participantes = express.Router();

participantes.route('/manager')
.get(ParticipanteCtrl.buscarTodosLosParticipantes)
.post(ParticipanteCtrl.agregarParticipante);

participantes.route('/manager/:id')
.get(ParticipanteCtrl.buscarPorID)
.put(ParticipanteCtrl.actualizarParticipante)
.delete(ParticipanteCtrl.eliminarParticipante);

app.use('/api', participantes);

// deja como oyente del servicio al puerto 3000
app.listen(3000, function() {
    console.log("Servidor Node corriendo en http://localhost:3000");
});
