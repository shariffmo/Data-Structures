package assign_3_4;

import java.security.SecureRandom;
import java.util.*;



public class SmartAR {
	ArrayList<Car> carList = new ArrayList<Car>();;
	Hashtable<String, String> carMap = new Hashtable<String, String>();

	ArrayList<Car> pastCar = new ArrayList<>();

	int length;
	int thresh = 0;
	String name = "";
	int listing = 0;

	// default constructor for smartAR
	public SmartAR() {
		setThreshold(0);
		setKeyLength(6);
	}

	// parametrized constructor for smartAR
	public SmartAR(int threshold, int keyLength) {

		setThreshold(threshold);
		setKeyLength(keyLength);
	}

	// randomly generates a sequence containing n new non-existing keys of
	// alphanumeric characters
	public void generate(int n) {
		listing += n;
		System.out.println("number of listing: " + listing);

		// transfers everything from array list to a hash table
		if ((listing + n) >= thresh) {
			String key = "";
			String name = "";
			for (int i = 0; i < carList.size(); i++) {
				key = carList.get(i).getKey();
				name = carList.get(i).getName();
				carMap.put(key, name);
			}
			carList.clear();
		}

		for (int i = 0; i < n; i++) {
			add(generateRandomKey(length), generateRandomName());
		}

	}

	// add an entry for a given
	public void add(String key, String value) {
		if (listing < thresh) {
			Car c = new Car(key, value);
			carList.add(c);
		}

		else if (listing >= thresh) {
			carMap.put(key, value);
		}
	}

	// remove method for smartAR
	public void remove(String key) {
		listing--;
		System.out.println("number of listing: " + listing);

		// convert from hash to sequence when number of listing < threshold value
		if (listing <= thresh) {
			System.out.println("transfering hash to sequence");
			carMap.forEach((k, v) -> {
				Car c = new Car(k, v);
				carList.add(c);
			});
			carMap.clear();
		}

		// removing in arraylist
		if (listing < thresh) {
			for (int i = 0; i < carList.size(); i++) {
				Car temp = carList.get(i);
				if (temp.getKey().equals(key)) {
					carList.remove(temp);
				}
			}
		}

		// removing in hash
		else if (listing >= thresh) {
			String n = carMap.get(key);
			if (!(n.equals(null))) {
				carMap.remove(key);
			}
		}

		else {
			System.out.println("Key doesn't exist!");
		}
		

	}

	// next key method for smartAR
	public String nextKey(String key) {

		for (int i = 0; i < carList.size(); i++) {
			if (carList.get(i).getKey().equals(key)) {
				return carList.get(i + 1).getKey();
			}

		}

		return null;
	}

	// prev key method for smartAR
	public String prevKey(String key) {
		for (int i = 0; i < carList.size(); i++) {
			if (carList.get(i).getKey().equals(key) && carList.get(i - 1) != null) {
				return carList.get(i - 1).getKey();
			}

		}
		return null;
	}
	
	

//*****************************************************************************************

	// 100 <= threshold <= ~500,000 in order to know which ADT to implement, if
	// listing size is larger than threshold value, go to the if statement
	public void setThreshold(int threshold) 
	{
		thresh = threshold;

	}

	// sets fixed string length of keys
	public int setKeyLength(int value) {
		if (value < 6 || value > 12) {
			System.out.println("Invalid key length");
			System.exit(0);
		}
		length = value;
		return length;
	}

	// returns all keys as a sorted sequence (lexicographic order)
	public List<String> allKeys() {
		// if it is a sequence
		if (listing < thresh) {
			List<String> keys = new ArrayList<String>();
			for (int i = 0; i < carList.size(); i++) {
				keys.add(carList.get(i).getKey());
			}
			keys.sort(Comparator.naturalOrder());

			return keys;
		}

		if (listing >= thresh) {
			List<String> keys = new ArrayList<String>(carMap.keySet());
			Collections.sort(keys);
			return keys;
		}

		return null;
	}

	public String getValues(String key) {
		if (listing < thresh) {
			for (int i = 0; i < carList.size(); i++) {
				if (carList.get(i).getKey().equals(key)) {
					name = carList.get(i).getName();
				}
			}
		}

		if (listing >= thresh) {
			name = carMap.get(key);
		}

		return name;
	}

	// prev cars method for smartAR
	public List<String> previousCars(String key) {
		List<String> prevCars = new ArrayList<String>();
		for (int i = 0; i < pastCar.size(); i++) {
			if (pastCar.get(i).getKey().equals(key)) {
				prevCars.add(pastCar.get(i).getName());
			}
		}

		Collections.reverse(prevCars);
		;

		return prevCars;
	}

	// change values method for smartAR
	public void changeValue(String key, String name) {
		if (listing < thresh) {
			for (int i = 0; i < carList.size(); i++) {
				if (carList.get(i).getKey().equals(key)) {
					String temp = carList.get(i).getName();
					carList.get(i).setName(name);

					Car c = new Car(carList.get(i).getKey(), temp);
					pastCar.add(c);
				}
			}
		}

		if (listing >= thresh) {
			Car c = new Car(key, carMap.get(key));
			pastCar.add(c);

			carMap.replace(key, carMap.get(key), name);
		}

	}

	public String generateRandomKey(int keyLength) {
		String lowerCase = "abcdefghijklmnopqrstuvwxyz";
		String upperCase = lowerCase.toUpperCase();
		String number = "0123456789";

		String randomKey = lowerCase + upperCase + number;
		SecureRandom random = new SecureRandom();

		if (keyLength < 1)
			throw new IllegalArgumentException();

		StringBuilder sb = new StringBuilder(keyLength);

		for (int i = 0; i < keyLength; i++) {
			int rndCharAt = random.nextInt(randomKey.length());
			char rndChar = randomKey.charAt(rndCharAt);
			sb.append(rndChar);
		}
		return sb.toString();
	}

	public String generateRandomName() {
		String[] cars = { "Audi", "BMW", "Buick", "Cadillac", "Chevrolet", "Chrysler", "Dodge", "Ferrari", "Ford",
				"Lexus", "Honda", "GMC", "Hummer", "Hyundai", "Infiniti", "Jeep", "Jaguar", "Lamborghini", "Kia",
				"Lincoln", "Land Rover", "Lotus", "Mazda", "Mercedes-Benz", "Mercury", "Mitsubishi", "Nissan",
				"Porsche", "Subaru", "Toyota", "Volkswagen", "Volvo" };

		SecureRandom random = new SecureRandom();

		StringBuilder sb = new StringBuilder();

		int rndVal = random.nextInt(cars.length);
		sb.append(cars[rndVal]);

		return sb.toString();
	}

	public void print() {
		if (listing < thresh) {
			System.out.println("printing sequence");
			for (int i = 0; i < carList.size(); i++) {
				System.out.println(carList.get(i).toString());
			}
		}

		else if (listing >= thresh) {
			System.out.println("printing hash");
			for (Map.Entry<String, String> entry : carMap.entrySet()) {
				String key = entry.getKey();
				String value = entry.getValue();

				System.out.println("Key: " + key + " Value: " + value);
			}
		}
	}
}
