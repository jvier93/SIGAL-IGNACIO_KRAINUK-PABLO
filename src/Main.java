import com.company.daos.impl.OdontologoDaoH2Impl;
import com.company.database.H2Connection;
import com.company.modelos.Odontologo;
import com.company.servicios.OdontologoService;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {


        Odontologo odontologo1 = new Odontologo(123,"Pepep", "Perez");
        Odontologo odontologo2 = new Odontologo(3,1221212313,"Pepep", "Perez");
        OdontologoService odontologoService = new OdontologoService(new OdontologoDaoH2Impl());
        System.out.println(odontologoService.guardarOdontologo(odontologo1));
        System.out.println(odontologoService.buscarOdontologoPorId(10));
        System.out.println(odontologoService.buscarTodosLosOdontologos().size());
        odontologoService.eliminarOdontologo(1);
        System.out.println(odontologoService.buscarTodosLosOdontologos().size());
        odontologoService.actualizarOdontologo(odontologo2);
        System.out.println(odontologoService.buscarOdontologoPorId(3));




    }
}