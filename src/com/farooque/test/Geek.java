package com.farooque.test;

import java.awt.Dimension;
import java.math.BigInteger;
import java.util.Comparator;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.function.Function;

class Geek implements Comparable<Geek> {

	public String name;
	public int id;
	public int hashCode;

	
	 
	public String getName() {
		System.out.println("Getting name " + name);
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		System.out.println("Getting Id " + id);
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getHashCode() {
		return hashCode;
	}

	public void setHashCode(int hashCode) {
		this.hashCode = hashCode;
	}

	Geek(String name, int id) {

		this.name = name;
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		System.out.println("Equals called");
		// checking if both the object references are
		// referring to the same object.
		if (this == obj)
			return true;

		// it checks if the argument is of the
		// type Geek by comparing the classes
		// of the passed argument and this object.
		// if(!(obj instanceof Geek)) return false; ---> avoid.
		if (obj == null || obj.getClass() != this.getClass())
			return false;

		// type casting of the argument.
		Geek geek = (Geek) obj;

		// comparing the state of argument with
		// the state of 'this' Object.
		return (geek.name == this.name && geek.id == this.id);
	}

	@Override
	public int hashCode() {

		// We are returning the Geek_id
		// as a hashcode value.
		// we can also return some
		// other calculated value or may
		// be memory address of the
		// Object on which it is invoked.
		// it depends on how you implement
		// hashCode() method.
		int result = hashCode;
		System.out.println("Hash called");
		if (result == 0) {
			System.out.print("Do Once ");
			result = Integer.hashCode(this.id);
			hashCode = result;
			System.out.println(hashCode);
		}
		System.out.println("Out " + result);
		return result;
	}

	@Override
	public int compareTo(Geek o) {
		int compare = Comparator.comparing(Geek::getName).thenComparing(Geek::getId).compare(this, o);
		System.out.println("Called " + compare);
		return compare;
	}
	
	  public static Comparator<String> getEmailDomainComparator(){
	        return (email1, email2) -> {
	            String emailDomain1 = (email1);
	            String emailDomain2 = (email2);
	            return 12;
	        };
	    }

}



class GeekChild extends Geek{

	GeekChild(String name, int id) {
		super(name, id);
	}
	
	@Override
	public String getName() {
		System.out.println("Getting name " + name);
		return name;
	}
	
	public int compareTo(GeekChild o) {
		Function<Geek, String> gName = Geek::getName;
		Comparator<GeekChild> gcComparator = goodCompare(gName, getEmailDomainComparator());
		
		
		Comparator<GeekChild> gcComparator1 = Comparator.comparing(gName);
		Comparator<GeekChild> gcComparator2 = gcComparator1.thenComparing(Geek::getId);
		int com = gcComparator2.compare(this, o);
		// OR 
		int compare = Comparator.<GeekChild, String>comparing(gName).thenComparing(Geek::getId).compare(this, o);
		
		
		System.out.println("Called " + compare);
		return compare;
	}

	public static <A, B> Comparator<A> goodCompare(Function<? super A, ? extends B> f, Comparator<B> cb) {
		// TODO Auto-generated method stub
		return null;
	}
}

// Driver code
class GFG {

	static HashSet<Geek> geekSet = new HashSet<>();

	public static void main(String[] args) throws InterruptedException {
		Geek g2 = new Geek("cba", 112);
		Thread r = new Thread(() -> {
			geekSet.add(g2);
			System.out.println("Added in Thread");
		});
		r.start();
		r.join();
		// creating the Objects of Geek class.
		Geek g1 = new Geek("abc", 1121);
		geekSet.add(g2);
		geekSet.add(g1);
		System.out.println("Size " + geekSet.size());

		Comparator<Employee> compareById = (o1, o2) -> Integer.compare(o1.getAge(), o2.getAge());

		Comparator<Geek> cc = Comparator.comparing((p) -> p.name);
		Comparator<Geek> cc1 = Comparator.comparing((p1) -> p1.id);
		Comparator<Geek> cc12 = cc.thenComparing(cc1);
		System.out.println("+++++++");
		TreeSet<Geek> tSet = new TreeSet<>();
		tSet.add(g1);
		System.out.println("Added 1 thing");
		tSet.add(g2);
		System.out.println(tSet.size());
		// HashSet<E>
		// TreeSet<E>
	}
}