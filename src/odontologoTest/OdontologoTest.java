package odontologoTest;

import com.company.daos.IDao;
import com.company.daos.impl.OdontologoDaoMemoriaImpl;
import com.company.modelos.Odontologo;
import com.company.servicios.OdontologoService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


public class OdontologoTest {



import java.util.ArrayList;

    public class OdontologoTest {

        @Test
        public void testRegistrarOdontologo() {
            // Crear el servicio y el DAO
            IDao<Odontologo> odontologoDao = new OdontologoDaoMemoriaImpl(new ArrayList<>()); // Pasa una lista vacía o preexistente
            OdontologoService odontologoService = new OdontologoService(odontologoDao);

            // Crear algunos odontólogos y registrarlos
            Odontologo o1 = new Odontologo(1, "Juan", "Perez");
            Odontologo o2 = new Odontologo(2, "Ana", "Gomez");

            odontologoService.guardarOdontologo(o1);
            odontologoService.guardarOdontologo(o2);

        }
    }


}
