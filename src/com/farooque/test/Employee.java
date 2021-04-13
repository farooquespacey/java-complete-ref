package com.farooque.test;

import java.util.HashSet;

public class Employee {

	String name;
	int age;

	public Employee(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Employee))
			return false;
		Employee employee = (Employee) obj;
		System.out.println("Name & Age equals? " + (employee.getAge() == this.getAge() && employee.getName() == this.getName()));
		System.out.println(" == " + this.name + "&&" + employee.name);
		System.out.println(" == " + this.age + "&&" + employee.age);
		return employee.getAge() == this.getAge() && employee.getName() == this.getName();
	}

	// commented

	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * result + age;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		System.out.println(result);
		return result;
	}

}

class ClientTest {
	public static void main(String[] args) {
		Employee employee = new Employee("rajeev", 24);
		Employee employee1WillBeAdded = new Employee("rajeev", 25);
		Employee employee2WillNotBeAdded = new Employee("rajeev", 24); 
		Employee employee3WillBeAdded = new Employee("rajeev123", 24);

		
		HashSet<Employee> employees = new HashSet<Employee>();
		employees.add(employee1WillBeAdded);
		employees.add(employee);
		System.out.println("Started");
		System.out.println("---> Added? " + employees.add(employee2WillNotBeAdded));// comparison will occur
		System.out.println("---> Added?? " + employees.add(employee3WillBeAdded));// comparison will occur since hashCode is same as of e and e2
//		System.out.println(
//				"employee.hashCode():  " + employee.hashCode() + "  employee2.hashCode():  " + employee2.hashCode());
	}
}