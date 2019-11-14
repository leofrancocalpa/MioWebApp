package co.edu.icesi.mio.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
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

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MioAppApplication.class)
@Rollback
public class TestBusDao {

	@Autowired
	private IBusDao busDao;
	
	Tmio1Bus bus;
	Tmio1Bus bus1;
	Tmio1Bus bus2;
	
	@Before
	public void setup() {
		bus = new Tmio1Bus();
		BigDecimal capacidad = new BigDecimal(33);
		BigDecimal modelo = new BigDecimal(2004);
		bus.setCapacidad(capacidad);
		bus.setMarca("Volv");
		bus.setModelo(modelo);
		bus.setPlaca("QWE123");
		bus.setTipo("T");
		busDao.save(bus);
		
		bus1 = new Tmio1Bus();
		BigDecimal capacidad1 = new BigDecimal(33);
		BigDecimal modelo1 = new BigDecimal(2004);
		bus1.setCapacidad(capacidad1);
		bus1.setMarca("Volv");
		bus1.setModelo(modelo1);
		bus1.setPlaca("AWE123");
		bus1.setTipo("A");
		busDao.save(bus1);
		
		bus2 = new Tmio1Bus();
		BigDecimal capacidad2 = new BigDecimal(33);
		BigDecimal modelo2 = new BigDecimal(2004);
		bus2.setCapacidad(capacidad2);
		bus2.setMarca("Volv");
		bus2.setModelo(modelo2);
		bus2.setPlaca("ZWE123");
		bus2.setTipo("P");
		busDao.save(bus2);
	}
	
	@Test
	@Transactional()
	public void testSave() {
		
		Tmio1Bus encontrado = busDao.findById(bus.getId());
		System.out.println(">>>"+encontrado.getPlaca());
		assertEquals("QWE123", encontrado.getPlaca());
		assertTrue(true);
	}
	
	@Test
	@Transactional()
	public void testDelete() {
		Tmio1Bus prueba = busDao.findById(bus2.getId());
		assertNotNull(prueba);
		busDao.delete(prueba);
		Tmio1Bus prueba1 = busDao.findById(bus2.getId());
		assertNull(prueba1);
	}
	
	@Test
	@Transactional
	public void testUpdate() {
		Tmio1Bus prueba = busDao.findById(bus1.getId());
		String placa = prueba.getPlaca();
		prueba.setPlaca("FFF000");
		busDao.update(prueba);
		prueba = busDao.findById(bus1.getId());
		assertNotEquals(placa, prueba.getPlaca());
		assertEquals("FFF000", prueba.getPlaca());
	}
	
	@Test
	@Transactional()
	public void testBuscarPorPlaca() {
		
		Tmio1Bus encontrado = busDao.buscarPorPlaca(bus.getPlaca());
//		System.out.println(">>>"+encontrado.getPlaca());
		assertNotNull(encontrado);
		assertEquals(bus.getPlaca(), encontrado.getPlaca());
	}
	
	@Test
	@Transactional
	public void testBuscarPorMarca() {
		List<Tmio1Bus> buses = busDao.buscarPorMarca(bus.getMarca());
		assertNotNull(buses);
		assertEquals(3, buses.size());
	}
	
	@Test
	@Transactional
	public void testBuscarPorModelo() {
		List<Tmio1Bus> buses = busDao.buscarPorModelo(new BigDecimal(2004));
		assertNotNull(buses);
		assertEquals(3, buses.size());
		
	}

}
