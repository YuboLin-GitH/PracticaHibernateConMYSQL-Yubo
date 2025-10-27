DROP DATABASE IF EXISTS Medico;
CREATE DATABASE Medico;
Use Medico;


CREATE TABLE IF NOT EXISTS Paciente(
idPaciente int unsigned auto_increment NOT NULL primary key,
dni varchar(9),
nombre varchar(30),
password varchar(64),
direccion varchar(100),
telefono int(9) 
 )ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=1;
 
  INSERT INTO Paciente  VALUES
 (1,"12345678A","David",SHA2("david",256),"c/ AAA", 611222333),
 (2,"34564546B","Angel",SHA2("angel",256),"c/ BBB", 611512183),
 (3,"62145448C","Lucia",SHA2("lucia",256),"c/ CCC", 611224013),
 (4,"91321654D","Martina",SHA2("martina",256),"c/ DDD", 618434555),
 (5,"51248345E","Sofia",SHA2("sofia",256),"c/ EEE", 649161161),
 (6,"84345876F","Hugo",SHA2("hugo",256), "c/ FFF", 616713488),
 (7,"81431548G","Leo",SHA2("leo",256),"c/ GGG", 668453178),
 (8,"11501548H","Daniel",SHA2("daniel",256),"c/ HHH", 691246578);
 


 CREATE TABLE IF NOT EXISTS Cita(
 idCita int unsigned auto_increment NOT NULL primary key,
 fechaCita date,
 nombreEsp varchar(30),
 idPaciente int unsigned

 )ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=1;


INSERT INTO Cita (fechaCita, nombreEsp, idPaciente) VALUES
('2024-12-10', "Cardiología", 1),
('2024-12-12', "Traumatología", 2),
('2024-12-15', "Neumología", 3),
('2024-12-08', "Psiquiatría", 4),
('2024-12-11', "Dermatología", 5),
('2024-12-18', "Cirugia", 6);
