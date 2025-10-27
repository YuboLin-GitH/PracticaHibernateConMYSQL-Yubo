package com.yubo.Model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Cita")
public class Cita implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "idCita")
    private int idCita;

    @Column(name = "fechaCita")
    private Date fechaCita;

    @Column(name = "nombreEsp")
    private String nombreEsp;

    @ManyToOne
    @JoinColumn(name="idPaciente",referencedColumnName="idPaciente")
    private Paciente paciente;


    public Cita() {
    }

    public Cita(int idCita, Date fechaCita, String nombreEsp) {
        this.idCita = idCita;
        this.fechaCita = fechaCita;
        this.nombreEsp = nombreEsp;
    }

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public Date getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(Date fechaCita) {
        this.fechaCita = fechaCita;
    }


    public String getNombreEsp() {
        return nombreEsp;
    }

    public void setNombreEsp(String nombreEsp) {
        this.nombreEsp = nombreEsp;
    }

    @Override
    public String toString() {
        return "Cita{" +
                "idCita=" + idCita +
                ", fechaCita=" + fechaCita +
                ", nombreEsp='" + nombreEsp + '\'' +
                '}';
    }
    public Paciente getPaciente() { return paciente; }
    public void setPaciente(Paciente paciente) { this.paciente = paciente; }
}
