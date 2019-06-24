package capas.tareafinal.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(schema = "public", name = "sucursal")
public class Store {
	
	@Id
	@GeneratedValue(generator = "store_code_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "store_code_gen", sequenceName = "public.sucursal_codigo_seq", allocationSize = 1)
	@Column(name = "codigo")
	private Integer code;
	
	@NotBlank(message="El nombre es un campo obligatorio")
	@Column(name = "nombre")
	private String name;
	
	@NotBlank(message="La ubicación es un campo obligatorio ")
	@Column(name = "ubicacion")
	private String address;
	
	@Min(5)
	@NotNull
	@Column(name = "cantidad_mesas")
	private Integer numTables;
	
	@NotBlank(message="Debe proporcionr el nombre del gerente")
	@Column(name = "gerente")
	private String manager;
	
	@NotBlank(message="Debe proporcionar los horarios")
	@Column(name = "horarios")
	private String schedule;
	
	@OneToMany(mappedBy = "store", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	List<Employee> employees;

	public Store() {}
	
	public Store(Integer code, String name, String address, Integer numTables,
			String manager, String schedule, List<Employee> employees) {
		super();
		this.code = code;
		this.name = name;
		this.address = address;
		this.numTables = numTables;
		this.manager = manager;
		this.schedule = schedule;
		this.employees = employees;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getNumTables() {
		return numTables;
	}

	public void setNumTables(Integer numTables) {
		this.numTables = numTables;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
}
