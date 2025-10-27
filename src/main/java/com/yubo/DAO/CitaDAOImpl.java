package com.yubo.DAO;


import com.yubo.Model.Cita;
import org.hibernate.Session;

import java.util.List;

public class CitaDAOImpl implements CitaDAO{
    @Override
    public void insertarCita(Session session, Cita c)
    {
        session.beginTransaction();
        session.save(c);
        session.getTransaction().commit();
    }

    @Override
    public void modificarCita(Session session, Cita c)
    {
        session.beginTransaction();
        session.update(c);
        session.getTransaction().commit();
    }

    @Override
    public void borrarCita(Session session, Cita c)
    {

        session.beginTransaction();
        session.delete(c);
        session.getTransaction().commit();
    }

    @Override
    public List<Cita> listarCita(Session session)
    {
        List<Cita> lista = session.createQuery("from Cita", Cita.class).list();
        return lista;

        //list.forEach(System.out::println);//version 1.8 de java
    }




}
