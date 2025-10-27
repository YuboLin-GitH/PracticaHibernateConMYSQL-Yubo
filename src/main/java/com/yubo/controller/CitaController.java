package com.yubo.controller;


import com.yubo.DAO.CitaDAO;
import com.yubo.DAO.CitaDAOImpl;
import com.yubo.DAO.EspecialidadDAO;
import com.yubo.Model.Cita;
import com.yubo.Model.Especialidad;
import com.yubo.Model.Paciente;
import com.yubo.util.AlertUtils;
import com.yubo.util.HibernateUtil;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.hibernate.Session;
import java.time.LocalDate;
import java.time.ZoneId;



import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


public class CitaController {
    private final CitaDAO citaDAO = new CitaDAOImpl();
    @FXML
    public TextField tfTelefono;
    @FXML
    public TextField tfNombre;
    @FXML
    public TextField tfDireccion;
    @FXML
    public TextField tfDNI;

    @FXML
    public Button btVerCita;
    @FXML
    public Button btNuevaCita;
    @FXML
    public Button btBorrarCita;
    @FXML
    public Button btModificarCita;

    @FXML
    public DatePicker dpFechaCita;

    @FXML
    public ComboBox<Especialidad> cbEspecialidad;

    @FXML
    public TableView<Cita> tvCitasPaciente;
    @FXML
    private TableColumn<Cita, Integer> colIdCita;
    @FXML
    private TableColumn<Cita, Date> colFecha;
    @FXML
    private TableColumn<Cita, String> colEspecialidad;



    private Paciente paciente;

    private Cita citaSeleccionada;


    @FXML
    public void initialize() {

        colIdCita.setCellValueFactory(new PropertyValueFactory<>("idCita"));
        colFecha.setCellValueFactory(new PropertyValueFactory<>("fechaCita"));
        colEspecialidad.setCellValueFactory(new PropertyValueFactory<>("nombreEsp"));

        cargarEspecialidades();

        enlazarSeleccionDeTabla();

    }


    public void cargarDatos() {
        //modoEdicion(false);
        tvCitasPaciente.getItems().clear();

        try (Session session = HibernateUtil.getSession()){
            List<Cita> citas= citaDAO.listarCita(session);
            List<Cita> estePaciente = new ArrayList<>();
            for (Cita c : citas) {
                if (c.getPaciente() != null && c.getPaciente().getIdPaciente() == paciente.getIdPaciente()) {
                    estePaciente.add(c);
                }
            }
            tvCitasPaciente.setItems(FXCollections.observableList(estePaciente));
        }
    }


    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
        mostrarDatosPaciente();
    }
    private void mostrarDatosPaciente() {
        tfNombre.setText(paciente.getNombre());
        tfDireccion.setText(paciente.getDireccion());
        tfTelefono.setText(String.valueOf(paciente.getTelefono()));
        tfDNI.setText(paciente.getDni());

        tfDNI.setDisable(true);
        tfNombre.setDisable(true);
        tfDireccion.setDisable(true);
        tfTelefono.setDisable(true);
    }


    private void cargarEspecialidades() {
        EspecialidadDAO especialidadDAO = new EspecialidadDAO();
        try {

            List<Especialidad> especialidades = especialidadDAO.obtenerEspecialidad();
            if (especialidades.isEmpty()) {
                AlertUtils.mostrarError("Error al obtener las especialidades");
                return;
            }

            cbEspecialidad.getItems().addAll(especialidades);

            for (Especialidad esp : especialidades) {
                if ("Cirugia".equals(esp.getNombreEsp())) {
                    cbEspecialidad.setValue(esp);
                    break;
                }
            }
        } catch (Exception e) {

            AlertUtils.mostrarError("Error：" + e.getMessage());
            e.printStackTrace();
        }
    }
    private void enlazarSeleccionDeTabla() {
        tvCitasPaciente.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                citaSeleccionada = newVal;
            if (newVal.getFechaCita() != null) {
                dpFechaCita.setValue(
                        newVal.getFechaCita().toInstant()
                                .atZone(java.time.ZoneId.systemDefault())
                                .toLocalDate()
                );
            }

                for (Especialidad esp : cbEspecialidad.getItems()) {
                    if (esp.getNombreEsp().equals(newVal.getNombreEsp())) {
                        cbEspecialidad.setValue(esp);
                        break;
                    }
                }
            }
        });
    }


    @FXML
    public void verCita() {
        cargarDatos();
    }

    @FXML
    public void nuevaCita() {

        LocalDate fechaSeleccionada = dpFechaCita.getValue();
        Especialidad espSeleccionada = cbEspecialidad.getValue();
        if (fechaSeleccionada == null || espSeleccionada == null) {
            AlertUtils.mostrarError("Elegir fecha de cita o Especialidad");
            return;
        }
        try(Session session = HibernateUtil.getSession()) {
            Cita c = new Cita();
            c.setFechaCita(Date.valueOf(fechaSeleccionada));
            c.setNombreEsp(espSeleccionada.getNombreEsp());
            c.setPaciente(paciente);

            citaDAO.insertarCita(session, c);

            AlertUtils.mostrarInformacion("Cita insertada correctamente");
            cargarDatos();
            limpiarCajas();

        }catch (Exception e){
            System.out.println("Error de Insertar Cita");
        }
    }




    private void limpiarCajas() {
        dpFechaCita.setValue(null);
        cbEspecialidad.setValue(null);
    }

}
 
