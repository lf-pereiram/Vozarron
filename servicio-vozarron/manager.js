var mongoose = require("mongoose");

//permite cargar el modelo generado
var Participante  = mongoose.model("Participante");
var Entrenador = mongoose.model("Entrenador");

/*
 ** Consultas en la base de datos sobre los participantes
*/
//permite listar todos los Participantes en la base de datos
exports.buscarTodosLosParticipantes = function(req, res) {
  Participante.find(function(err, Participantes) {
    if(err) res.send(500, err.message);

    res.status(200).jsonp(Participantes);
  });
};

//permite agregar un nuevo Participante
exports.agregarParticipante = function(req, res) {
  var participante = new Participante({
    nombre:    req.body.nombre,
    edad:     req.body.edad,
    entrenador: req.body.entrenador,
    rol:  req.body.rol,
    numVotos: req.body.numVotos,
    urlVideo:   req.body.urlVideo,
    estado: req.body.estado
  });

  participante.save(function(err, Participante) {
    if(err) return res.status(500).send( err.message);
    res.status(200).jsonp(Participante);
  });

};

exports.buscarPorID = function(req, res) {
  Participante.findById(req.params.id, function(err, Participante) {
    if(err) return res.send(500, err.message);
    res.status(200).jsonp(Participante);
  });
};

exports.actualizarParticipante = function(req, res) {
  Participante.findById(req.params.id, function(err, Participante) {
    Participante.nombre   = req.body.nombre;
    Participante.edad    = req.body.edad;
    Participante.entrenador = req.body.entrenador;
    Participante.rol = req.body.rol;
    Participante.numVotos = req.body.numVotos;
    Participante.urlVideo  = req.body.urlVideo;
    Participante.estado = req.body.estado;

    Participante.save(function(err) {
      if(err) return res.status(500).send(err.message);
      res.status(200).jsonp(Participante);
    });
  });
};

exports.eliminarParticipante = function(req, res) {
  Participante.findById(req.params.id, function(err, Participante) {
    Participante.remove(function(err) {
      if(err) return res.status(500).send(err.message);
      res.status(200).send();
    })
  });
};