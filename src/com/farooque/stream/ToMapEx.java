package com.farooque.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ToMapEx {

	public static void main(String[] args) {
		String phrase = "Farooque is noobie at programming at";
		List<String> words = Arrays.asList(phrase.split(" "));
//		Map<String, Integer> wordMap = words.stream()
//				.collect(Collectors.toMap(word -> word, word -> 1, (v1, v2) -> v1 + v2, LinkedHashMap::new));
		Map<String, Long> wordMap = words.stream()
				.collect(Collectors.groupingBy(word -> word, Collectors.counting()));
		System.out.println(wordMap.getClass());
		System.out.println(wordMap);
		List<Person> lisOfPerson = new ArrayList<>();
		Person per = new Person("far", "TN", "vlr");
		lisOfPerson.add(per);
		lisOfPerson.add(per);
		lisOfPerson.add(new Person("som", "xy", "gwa"));
		lisOfPerson.add(new Person("uc", "TN", "amb"));
		lisOfPerson.add(new Person("zab", "TN", "vish"));
		lisOfPerson.add(new Person("fais", "KA", "vish"));
		lisOfPerson.add(new Person("ibu", "KA", ""));

		Map<String, List<Person>> personMap = lisOfPerson.stream().collect(Collectors.groupingBy(Person::getState));
		personMap.keySet().forEach(k -> {
			System.out.println(k);
			personMap.get(k).forEach(p -> System.out.println(k + " -> " + p));
		});
	}

	static class Person {
		String name;
		String state;
		String city;

		public Person(String name, String state, String city) {
			this.name = name;
			this.state = state;
			this.city = city;
			// TODO Auto-generated constructor stub
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		@Override
		public String toString() {
			return "Person [name=" + name + ", state=" + state + ", city=" + city + "]";
		}

		@Override
		public boolean equals(Object o) {
			if (o == this)
				return true;
			if (!(o instanceof Person))
				return false;
			Person pn = (Person) o;
			return pn.name == name && pn.state == state && pn.city == city;
		}

		// Typical hashCode method
		@Override
		public int hashCode() {
			int result = name.hashCode();
			result = 31 * result + state.hashCode();
			result = 31 * result + city.hashCode();
			return result;
		}

	}

}
