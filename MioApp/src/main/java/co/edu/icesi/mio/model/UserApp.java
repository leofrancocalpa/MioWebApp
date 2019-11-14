package co.edu.icesi.mio.model;

import java.io.Serializable;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name="users_app")
@NamedQuery(name="UserApp.findAll", query="SELECT t FROM UserApp t")
public class UserApp implements Serializable {
	private static final long serialVersionUID = 1L;

	
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private long id;
	@Id
	private String cedula;
//	@NotBlank
	private String username;
//	@NotBlank
	private String password;
//	@NotBlank
	private String name;
//	@NotBlank
	private String lastname;
	
	private UserType type;

}
