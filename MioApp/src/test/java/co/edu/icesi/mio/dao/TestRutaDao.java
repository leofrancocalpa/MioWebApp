package co.edu.icesi.mio.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

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
import co.edu.icesi.mio.model.Tmio1Ruta;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MioAppApplication.class)
@Rollback
public class TestRutaDao {
	
	@Autowired
	private IRutaDao rutaDao;
	
	private Tmio1Ruta ruta;
	private Tmio1Ruta ruta1;
	private Tmio1Ruta ruta2;
	
	@Before
	public void setup() {
		
		ruta = new Tmio1Ruta();
		ruta.setActiva("Activa");
		ruta.setDescripcion("ruta 0");
		ruta.setDiaFin(new BigDecimal(5));
		ruta.setDiaInicio(new BigDecimal(1));
		ruta.setHoraFin(new BigDecimal(82800));
		ruta.setHoraInicio(new BigDecimal(28000));
		ruta.setNumero("A11");
		
		rutaDao.save(ruta);
		
		ruta1 = new Tmio1Ruta();
		ruta1.setActiva("Activa");
		ruta1.setDescripcion("ruta 1");
		ruta1.setDiaFin(new BigDecimal(6));
		ruta1.setDiaInicio(new BigDecimal(1));
		ruta1.setHoraFin(new BigDecimal(82800));
		ruta1.setHoraInicio(new BigDecimal(18000));
		ruta1.setNumero("A14");
		
		rutaDao.save(ruta1);
		
		ruta2 = new Tmio1Ruta();
		ruta2.setActiva("Activa");
		ruta2.setDescripcion("ruta 2");
		ruta2.setDiaFin(new BigDecimal(5));
		ruta2.setDiaInicio(new BigDecimal(1));
		ruta2.setHoraFin(new BigDecimal(82800));
		ruta2.setHoraInicio(new BigDecimal(18000));
		ruta2.setNumero("A17");
		
		rutaDao.save(ruta2);

	}
	
	@Test
	@Transactional
	public void testSave() {
		Tmio1Ruta newRuta = new Tmio1Ruta();
		newRuta.setActiva("Activa");
		newRuta.setDescripcion("ruta nueva");
		newRuta.setDiaFin(new BigDecimal(5));
		newRuta.setDiaInicio(new BigDecimal(1));
		newRuta.setHoraFin(new BigDecimal(82800));
		newRuta.setHoraInicio(new BigDecimal(18000));
		newRuta.setNumero("A11A");
		
		rutaDao.save(newRuta);
		assertNotNull(rutaDao.findById(newRuta.getId()));
	}
	
	@Test
	@Transactional
	public void testDelete() {
		Tmio1Ruta prueba = rutaDao.findById(ruta.getId());
		assertNotNull(prueba);
		rutaDao.delete(prueba);
		prueba = rutaDao.findById(ruta.getId());
		assertNull(prueba);
	}
	
	@Test
	@Transactional
	public void testUpdate() {
		Tmio1Ruta prueba = rutaDao.findById(ruta2.getId());
		BigDecimal diaFin = prueba.getDiaFin();
		prueba.setDiaFin(new BigDecimal(3));
		rutaDao.update(prueba);
		prueba = rutaDao.findById(ruta2.getId());
		assertNotEquals(diaFin, prueba.getDiaFin());
		assertEquals(new BigDecimal(3), prueba.getDiaFin());
	}
	
	@Test
	@Transactional
	public void testHorasEntre() {
		List<Tmio1Ruta> rutas = rutaDao.horarioEntre(new BigDecimal(18000), new BigDecimal(82800));
		assertNotNull(rutas);
		assertEquals(3, rutas.size());
	}
	
	public void testDiasEntre() {
		List<Tmio1Ruta> rutas = rutaDao.diasEntre(new BigDecimal(1), new BigDecimal(5));
		assertNotNull(rutas);
		assertEquals(2, rutas.size());
	}
	

}
