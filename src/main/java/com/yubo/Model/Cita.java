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
    @Column(name = "IdPaciente")
    private int IdPaciente;
    @Column(name = "IdEsp")
    private int IdEsp;
    @Column(name = "nombreEsp")
    private String nombreEsp;

    @ManyToOne
    @JoinColumn(name="idPaciente",referencedColumnName="idPaciente")
    private Paciente paciente;


    public Cita() {
    }

    public Cita(int idCita, Date fechaCita, int fkIdPaciente, int fkIdEsp, String nombreEsp) {
        this.idCita = idCita;
        this.fechaCita = fechaCita;
        this.IdPaciente = fkIdPaciente;
        this.IdEsp = fkIdEsp;
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

    public int getFkIdPaciente() {
        return IdPaciente;
    }

    public void setFkIdPaciente(int fkIdPaciente) {
        this.IdPaciente = fkIdPaciente;
    }

    public int getFkIdEsp() {
        return IdEsp;
    }

    public void setFkIdEsp(int fkIdEsp) {
        this.IdEsp = fkIdEsp;
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
                ", fkIdPaciente=" + IdPaciente +
                ", fkIdEsp=" + IdEsp +
                ", nombreEsp='" + nombreEsp + '\'' +
                '}';
    }
}
