package hibernateBean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "emp")
public class hibernateEmpBean implements Serializable {

	
	private static final long serialVersionUID = -7755442501302419620L;
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="city")
	private String city;
	@Column(name="salary")
	private int salary;
	@Column(name="joining_date")
	private Date joining_date;

	

	public hibernateEmpBean(String name, String city, int salary,
			Date joining_date) {
		super();
		this.name = name;
		this.city = city;
		this.salary = salary;
		this.joining_date = joining_date;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "hibernateEmpBean [id=" + id + ", name=" + name + ", city="
				+ city + ", salary=" + salary + ", joining_date="
				+ joining_date + "]";
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Date getJoining_date() {
		return joining_date;
	}

	public void setJoining_date(Date joining_date) {
		this.joining_date = joining_date;
	}

}
