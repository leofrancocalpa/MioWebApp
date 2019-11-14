package co.edu.icesi.mio.dao;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.edu.icesi.mio.MioAppApplication;
import co.edu.icesi.mio.model.Tmio1Bus;
import co.edu.icesi.mio.model.Tmio1Conductore;
import co.edu.icesi.mio.model.Tmio1Ruta;
import co.edu.icesi.mio.model.Tmio1Servicio;
import co.edu.icesi.mio.model.Tmio1ServicioPK;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MioAppApplication.class)
@Rollback
public class TestConsultasAdicionalesDao {
	
	@Autowired
	private IServicioDao servicioDao;
	@Autowired 
	private IConductorDao conductorDao;
	@Autowired
	private IRutaDao rutaDao;
	@Autowired
	private IBusDao busDao;
	
	private Tmio1Conductore cond;
	private Tmio1Conductore cond1;
	private Tmio1Servicio serv;
	private Tmio1Servicio serv1;
	private Tmio1Ruta ruta;
	private Tmio1Ruta ruta1;
	private Tmio1Bus bus;
	private Tmio1Bus bus1;

	@Before
	public void setUp() {
		cond = new Tmio1Conductore();
		cond.setCedula("1234");
		conductorDao.save(cond);

		cond1 = new Tmio1Conductore();
		cond1.setCedula("1235");
		conductorDao.save(cond1);
		
		ruta = new Tmio1Ruta();
		ruta.setNumero("A11");
		rutaDao.save(ruta);
		
		ruta1 = new Tmio1Ruta();
		ruta1.setNumero("A14");
		rutaDao.save(ruta1);
		
		bus = new Tmio1Bus();
		bus.setCapacidad(new BigDecimal(86));
		bus.setMarca("Volvo");
		bus.setModelo(new BigDecimal(1998));
		bus.setPlaca("VDS123");
		bus.setTipo("T");
		busDao.save(bus);

		
		bus1 = new Tmio1Bus();
		bus1.setCapacidad(new BigDecimal(36));
		bus1.setMarca("Volvo");
		bus1.setModelo(new BigDecimal(2005));
		bus1.setPlaca("TBT383");
		bus1.setTipo("P");
		busDao.save(bus1);

		
		Tmio1ServicioPK serPk = new Tmio1ServicioPK();
		serPk.setCedulaConductor(cond.getCedula());
		serPk.setIdBus(bus.getId());
		serPk.setIdRuta(ruta.getId());
		serPk.setFechaInicio(LocalDate.of(2019, 10, 1));
		serPk.setFechaFin(LocalDate.of(2019, 10, 15));
		serPk.setHash(serPk.hashCode());
		
		serv = new Tmio1Servicio();
		serv.setId(serPk);
//		serv.setTmio1Conductore(cond);
		List<Tmio1Servicio> conServ = new ArrayList<>();
		cond.setTmio1Servicios(conServ);
		cond.addTmio1Servicio(serv);
//		serv.setTmio1Ruta(ruta);
		List<Tmio1Servicio> rutServ = new ArrayList<>();
		ruta.setTmio1Servicios(rutServ);
		ruta.addTmio1Servicio(serv);
//		serv.setTmio1Bus(bus);
		List<Tmio1Servicio> busServ = new ArrayList<>();
		bus.setTmio1Servicios(busServ);
		bus.addTmio1Servicio(serv);
		
		servicioDao.save(serv);
		
		Tmio1ServicioPK serPk1 = new Tmio1ServicioPK();
		serPk1.setCedulaConductor(cond1.getCedula());
		serPk1.setIdBus(bus1.getId());
		serPk1.setIdRuta(ruta1.getId());
		serPk1.setFechaInicio(LocalDate.of(2019, 10, 1));
		serPk1.setFechaFin(LocalDate.of(2019, 10, 10));
		serPk1.setHash(serPk1.hashCode());
		
		serv1 = new Tmio1Servicio();
		serv1.setId(serPk1);
//		serv1.setTmio1Conductore(cond1);
		List<Tmio1Servicio> conServ1 = new ArrayList<>();
		cond1.setTmio1Servicios(conServ1);
		cond1.addTmio1Servicio(serv1);
//		serv1.setTmio1Ruta(ruta);
		List<Tmio1Servicio> rutServ1 = new ArrayList<>();
		ruta1.setTmio1Servicios(rutServ1);
		ruta1.addTmio1Servicio(serv1);
//		serv1.setTmio1Bus(bus1);
		List<Tmio1Servicio> busServ1 = new ArrayList<>();
		bus1.setTmio1Servicios(busServ1);
		bus1.addTmio1Servicio(serv1);
		
		servicioDao.save(serv1);
		
		
	}
	
	@Test
	@Transactional
	public void testBuscarConductores() {
		
		List<Tmio1Conductore> conductores = servicioDao.conductoresConServiciosVigentes(LocalDate.of(2019, 10, 16));
		for(Tmio1Conductore c : conductores) {
//			System.out.println(c.getCedula());
		}
	}
	
	@Test
	@Transactional
	public void testRutasServicios() {
		
		List<Tmio1Ruta> rutas = servicioDao.rutasConServiciosVigentes(LocalDate.of(2019, 10, 11));
		assertEquals(1, rutas.size());
		for(int i=0; i<rutas.size(); i++) {
			System.out.println(rutas.get(i).getNumero()+">><<");
			assertEquals("A11", rutas.get(i).getNumero());
		}
	}

}
