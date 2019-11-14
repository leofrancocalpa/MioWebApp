package co.edu.icesi.mio.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.time.LocalDate;
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
import co.edu.icesi.mio.model.Tmio1Conductore;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MioAppApplication.class)
@Rollback
public class TestConductorDao {
	
	@Autowired
	private IConductorDao conductorDao;
	
	Tmio1Conductore conductor;
	Tmio1Conductore conductor1;

	@Before
	public void setup() {
		conductor = new Tmio1Conductore();
		conductor.setCedula("1234");
		conductor.setApellidos("Rodriguez");
		conductor.setNombre("Rodrigo");
		conductor.setFechaNacimiento(LocalDate.of(1998, 02, 19));
		conductor.setFechaContratacion(LocalDate.of(2011, 06, 03));
		
		conductorDao.save(conductor);
		
		conductor1 = new Tmio1Conductore();
		conductor1.setCedula("12345");
		conductor1.setApellidos("Ramirez");
		conductor1.setNombre("Rodrigo");
		conductor1.setFechaNacimiento(LocalDate.of(1996, 02, 19));
		conductor1.setFechaContratacion(LocalDate.of(2012, 06, 03));
		
		conductorDao.save(conductor1);
	}
	
	@Test
	@Transactional
	public void testGuardar() {
		Tmio1Conductore conductor = new Tmio1Conductore();
		conductor.setCedula("111");
		conductor.setApellidos("Rodrigez");
		conductor.setNombre("Rodrigo");
		conductor.setFechaNacimiento(LocalDate.of(1998, 02, 19));
		conductor.setFechaContratacion(LocalDate.of(2011, 06, 03));
		
		Tmio1Conductore prueba = conductorDao.findByID(conductor.getCedula());
		assertNull(prueba);
		conductorDao.save(conductor);
		prueba = conductorDao.findByID(conductor.getCedula());
		assertNotNull(prueba);
	}
	
	@Test
	@Transactional	
	public void testDelete() {
		conductorDao.delete(conductor);
		Tmio1Conductore prueba = conductorDao.findByID(conductor.getCedula());
		assertNull(prueba);
	}
	
	@Test
	@Transactional
	public void testUpdate() {
		Tmio1Conductore prueba = conductorDao.findByID(conductor.getCedula());
		assertEquals("Rodrigo", prueba.getNombre());
		prueba.setNombre("Paco");
		conductorDao.update(prueba);
		prueba = conductorDao.findByID(conductor.getCedula());
		assertNotEquals("Rodrigo", prueba.getNombre());
		assertEquals("Paco", prueba.getNombre());
	}
	
	@Test
	@Transactional
	public void testBuscarPorNombre() {
		List<Tmio1Conductore> conductores = conductorDao.findByName("Rodrigo");
		assertNotNull(conductores);
		assertEquals(2, conductores.size());
	}
	
	@Test
	@Transactional
	public void testBuscarPorApellido() {
		List<Tmio1Conductore> conductores = conductorDao.findByLastName("Rodriguez");
		assertNotNull(conductores);
		assertEquals(1, conductores.size());
	}
	
}
