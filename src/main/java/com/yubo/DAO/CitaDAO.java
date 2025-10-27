package com.yubo.DAO;

import com.yubo.Model.Cita;
import org.hibernate.Session;

import java.util.List;

public interface CitaDAO {
    void insertarCita(Session session, Cita c);

    void modificarCita(Session session,Cita c);

    void borrarCita(Session session, Cita c);

    List<Cita> listarCita(Session session);
}
