package co.edu.icesi.mio;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;

import co.edu.icesi.mio.model.Tmio1Bus;
import co.edu.icesi.mio.model.Tmio1Conductore;
import co.edu.icesi.mio.model.Tmio1Ruta;
import co.edu.icesi.mio.model.Tmio1Servicio;
import co.edu.icesi.mio.model.Tmio1ServicioPK;
import co.edu.icesi.mio.model.UserApp;
import co.edu.icesi.mio.model.UserType;
import co.edu.icesi.mio.repositories.BusesRepository;
import co.edu.icesi.mio.repositories.ConductoresRepository;
import co.edu.icesi.mio.repositories.RutasRepository;
import co.edu.icesi.mio.repositories.UserRepository;
import co.edu.icesi.mio.services.ServicioService;


@SpringBootApplication
public class MioAppApplication {
	@Autowired
	UserRepository userRepository;
	@Autowired
	BusesRepository busesRepositories;
	@Autowired
	RutasRepository rutasRepository;
	@Autowired
	ConductoresRepository conductorRepository;
	@Autowired
	ServicioService servService;
	
	@Bean
	public Java8TimeDialect java8TimeDialect() {
		return new Java8TimeDialect();
	}

	public static void main(String[] args) {
		SpringApplication.run(MioAppApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner runner() {
		return (args) -> {
			// BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

			UserApp user = new UserApp();
			user.setCedula("1234");
			user.setUsername("admin");
			//user.setPassword(passwordEncoder.encode("123"));
			user.setPassword("{noop}123");
			user.setType(UserType.admin);
			userRepository.save(user);
			System.out.println(userRepository);
			System.out.println(userRepository.findByUsername("admin"));;
			
			
			UserApp user2 = new UserApp();		
			user2.setCedula("12345");
			user2.setUsername("juan");
			//user2.setPassword(passwordEncoder.encode("123"));
			user2.setPassword("{noop}123");
			user2.setType(UserType.operator);
			userRepository.save(user2);
			
			
			Tmio1Bus bus1 = new Tmio1Bus();
			bus1.setCapacidad(new BigDecimal(86));
			bus1.setMarca("Volvo");
			bus1.setModelo(new BigDecimal(1998));
			bus1.setPlaca("VDS123");
			bus1.setTipo("T");
//			busesRepositories.save(bus1);
			
			Tmio1Bus bus2 = new Tmio1Bus();
			bus2.setCapacidad(new BigDecimal(36));
			bus2.setMarca("Volvo");
			bus2.setModelo(new BigDecimal(2005));
			bus2.setPlaca("TBT383");
			bus2.setTipo("P");
//			busesRepositories.save(bus2);
			
			Tmio1Ruta ruta1 = new Tmio1Ruta();
			ruta1.setActiva("Activa");
			ruta1.setDescripcion("Ruta solo festivos");
			ruta1.setNumero("A11");
			ruta1.setDiaFin(new BigDecimal(7));
			ruta1.setDiaInicio(new BigDecimal(1));
			ruta1.setHoraFin(new BigDecimal(22));
			ruta1.setHoraInicio(new BigDecimal(6));
//			rutasRepository.save(ruta1);
			
			Tmio1Ruta ruta2 = new Tmio1Ruta();
			ruta2.setActiva("Activa");
			ruta2.setDescripcion("Ruta solo festivos");
			ruta2.setNumero("E21");
			ruta2.setDiaFin(new BigDecimal(7));
			ruta2.setDiaInicio(new BigDecimal(1));
			ruta2.setHoraFin(new BigDecimal(22));
			ruta2.setHoraInicio(new BigDecimal(6));
//			rutasRepository.save(ruta2);
			
			Tmio1Conductore cond1 = new Tmio1Conductore();
			cond1.setCedula("1234444");
			cond1.setApellidos("Paco y Luis");
			cond1.setNombre("Hugo");
			LocalDate nacimiento = LocalDate.of(1998, 3, 3);
			cond1.setFechaNacimiento(nacimiento);
			LocalDate contra = LocalDate.of(2000, 3, 3);
			cond1.setFechaContratacion(contra);
//			conductorRepository.save(cond1);
			
			Tmio1Conductore cond2 = new Tmio1Conductore();
			cond2.setCedula("1332456");
			cond2.setApellidos("Brito Delgado");
			cond2.setNombre("Alan");
			LocalDate nacimiento2 = LocalDate.of(1990, 3, 3);
			cond2.setFechaNacimiento(nacimiento2);
			LocalDate contra2 = LocalDate.of(2010, 3, 3);
			cond2.setFechaContratacion(contra2);
//			conductorRepository.save(cond2);
			
			Tmio1ServicioPK serPk = new Tmio1ServicioPK();
			serPk.setCedulaConductor(cond1.getCedula());
			serPk.setIdBus(bus1.getId());
			serPk.setIdRuta(ruta1.getId());
			serPk.setFechaInicio(LocalDate.of(2019, 10, 1));
			serPk.setFechaFin(LocalDate.of(2019, 10, 15));
			serPk.setHash(serPk.hashCode());
			
			Tmio1Servicio serv = new Tmio1Servicio();
			serv.setId(serPk);
			serv.setTmio1Bus(bus1);
			serv.setTmio1Conductore(cond1);
			serv.setTmio1Ruta(ruta1);
//			servService.save(serv);
		};
	}


}
