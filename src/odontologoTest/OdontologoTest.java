package odontologoTest;

import com.company.daos.IDao;
import com.company.daos.impl.OdontologoDaoH2Impl;
import com.company.daos.impl.OdontologoDaoMemoriaImpl;
import com.company.database.H2Connection;
import com.company.modelos.Odontologo;
import com.company.servicios.OdontologoService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import java.util.ArrayList;
import java.util.List;



public class OdontologoTest {

    private OdontologoService odontologoService;

        @Test
        public void testBuscarTodosLosOdontologosEnH2() {


            //DADO
            H2Connection.createTable();
            odontologoService = new OdontologoService(new OdontologoDaoH2Impl());

            Odontologo o1 = new Odontologo(1, "Juan", "Perez");
            Odontologo o2 = new Odontologo(2, "Ana", "Gomez");

            odontologoService.guardarOdontologo(o1);
            odontologoService.guardarOdontologo(o2);

            //CUANDO
            List<Odontologo> todosLosOdontologos = new ArrayList<>();
            todosLosOdontologos = odontologoService.buscarTodosLosOdontologos();


            //ENTONCES
            assertEquals(2, todosLosOdontologos.size());

        }

    @Test
    public void testBuscarTodosLosOdontologosEnMemoria() {

       //DADO
        odontologoService = new OdontologoService(new OdontologoDaoMemoriaImpl(new ArrayList<>()));

        Odontologo o1 = new Odontologo(1, "Juan", "Perez");
        Odontologo o2 = new Odontologo(2, "Ana", "Gomez");

        odontologoService.guardarOdontologo(o1);
        odontologoService.guardarOdontologo(o2);

        //CUANDO
        List<Odontologo> todosLosOdontologos = new ArrayList<>();
        todosLosOdontologos = odontologoService.buscarTodosLosOdontologos();


        //ENTONCES
        assertEquals(2, todosLosOdontologos.size());



    }




}



