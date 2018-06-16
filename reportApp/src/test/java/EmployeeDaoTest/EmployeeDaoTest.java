package EmployeeDaoTest;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Ignore;
import org.junit.Test;

import com.org.andreorg.web.dao.EmployeeDao;
import com.org.andreorg.web.model.Employee;


public class EmployeeDaoTest {
	EmployeeDao employeeDao = new EmployeeDao();

	//TODO remove/Ignore all this tests? without mock data is nonsense
	//This class will be used to test data Validation methods of adding/updating employee for example
	
	@Ignore
	@Test
	public void testDBConnection() {
		List<Employee> employees = new ArrayList<Employee>();
		String fName = getRandomString();
		String lName = getRandomString();

		Employee employee1 = createEmployee(fName, lName);
		employees.add(employee1);
		employeeDao.addEmployees(employees);
		Employee employeeFromDb = employeeDao.getEmployeeByID(employee1.getEmpID());
		assertEquals(fName, employeeFromDb.getFirstName());
		assertEquals(lName, employeeFromDb.getLastName());
	}

	@Test
	public void testAddAndGetEmployee() {
		List<Employee> employees = new ArrayList<Employee>();
		String fName = getRandomString();
		String lName = getRandomString();

		Employee employee1 = createEmployee(fName, lName);
		employees.add(employee1);
		employeeDao.addEmployees(employees);
		Employee employeeFromDb = employeeDao.getEmployeeByID(employee1.getEmpID());
		assertEquals(fName, employeeFromDb.getFirstName());
		assertEquals(lName, employeeFromDb.getLastName());
	}
	
	@Test
	public void testAddThenDeleteEmployee() {
		List<Employee> employees = new ArrayList<Employee>();
		String fName = getRandomString();
		String lName = getRandomString();

		Employee employee1 = createEmployee(fName, lName);
		employees.add(employee1);
		employeeDao.addEmployees(employees);
		employeeDao.deleteEmployees(employees);

		Employee employeeFromDb = employeeDao.getEmployeeByID(employee1.getEmpID());
		assertNull(employeeFromDb);
	}
	
	@Test
	public void testGetAllEmployees() {
		List<Employee> employees = employeeDao.getAllEmployees();
		
		for(Employee employee: employees) {
			System.out.println(employee.toString()); 
			assertNotNull(employee.getEmpID());
		}
	}
	
	@Test
	public void testUpdateEmployees() {
		List<Employee> employees = new ArrayList<Employee>();
		Employee employeeFromDb = employeeDao.getEmployeeByID(1);
		employees.add(employeeFromDb);
		employeeFromDb.setSalary(20000);
		employeeDao.updateEmployees(employees);	
	}

	private Employee createEmployee(String fName, String lName) {
		Employee employee1 = new Employee(fName, lName, 1000, 2, 243234, getRandomString());
		return employee1;
	}

	private String getRandomString() {
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 10) { // length of the random string.
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString();
		return saltStr;

	}
}
