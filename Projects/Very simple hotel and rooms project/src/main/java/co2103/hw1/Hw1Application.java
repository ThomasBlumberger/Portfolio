package co2103.hw1;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import co2103.hw1.domain.Hotel;
import co2103.hw1.domain.Room;



@SpringBootApplication
public class Hw1Application implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(Hw1Application.class, args);
	}
	
	public static List<Hotel> hotels = new ArrayList<>();
	public static List<Room> rooms = new ArrayList<>();
	
	@Override
	public void run(String... args) {

		
		Room one = new Room();
		one.setName("Room One");
		one.setDescription("One Large Room with a Kingsize Bed");
		one.setCategory("Room");
		one.setGuests(0);
		rooms.add(one);
		
		one = new Room();
		one.setName("Room Two");
		one.setDescription("Medium sized room with a single bed");
		one.setCategory("Room");
		one.setGuests(0);
		rooms.add(one);

		Hotel a = new Hotel();
		a.setDescription("5* Hotel in the countryside");
		a.setId(1);
		a.setName("Tom's Hotel & Spa");
		a.setRooms(rooms);
		hotels.add(a);

		}
}