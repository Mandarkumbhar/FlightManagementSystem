package com.training.sprint1;

import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.training.sprint1.entities.Airport;
import com.training.sprint1.entities.Booking;
import com.training.sprint1.entities.Flight;
import com.training.sprint1.entities.Passenger;
import com.training.sprint1.entities.Role;
import com.training.sprint1.entities.Schedule;
import com.training.sprint1.entities.ScheduledFlight;
import com.training.sprint1.entities.User;
import com.training.sprint1.exception.BookingNotFoundException;
import com.training.sprint1.repository.IBookingRepository;
import com.training.sprint1.service.BookingService;

@SpringBootTest
public class BookingTest {

	@Mock
	IBookingRepository bRepo;
	
	@InjectMocks
	BookingService bookService;
	
	
	List<User> userList;
	User user1, user2, user3;
	
	List<Booking> bookings = new ArrayList<>();
	Booking book1, book2, book3;
	
	List<Passenger> passengers = new ArrayList<>();
	Passenger pass1, pass2;
	
	
	Flight flight1, flight2;
	
	
	//_____________________________________________________________
	Airport a1 = new Airport(11l, "Bombay Airlines", "Mumbai");
	Airport a2 = new Airport(12l, "Pune Airlines", "Pune");
	Airport a3 = new Airport(12l, "Thane Airlines", "Thane");
	Airport a4 = new Airport(12l, "Jaipur Airlines", "Jaipur");
	Airport a5 = new Airport(12l, "Raipur Airlines", "Raipur");
	Airport a6 = new Airport(12l, "Bangalore Airlines", "Bangalore");
	
	Schedule s1 =  new Schedule(a1, a2,LocalDate.of(2021, 8, 23) ,LocalTime.of(6, 30), LocalTime.of(7, 30));
	Schedule s2 =  new Schedule(a3, a4, LocalDate.of(2021, 8, 24) ,LocalTime.of(8, 30), LocalTime.of(9, 00));
	Schedule s3 =  new Schedule(a5, a6,LocalDate.of(2021, 8, 25) , LocalTime.of(4, 30), LocalTime.of(6, 00));
	
	ScheduledFlight Sflight1 = new ScheduledFlight(flight1, 10, s1);
	ScheduledFlight Sflight2 = new ScheduledFlight(flight1, 15, s2);
	ScheduledFlight Sflight3 = new ScheduledFlight(flight2, 12, s3);
	
	
	
	@SuppressWarnings("deprecation")
	@Before(value = "")
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}
	
	@BeforeEach
	void setUp() throws Exception {
		
		
		
		
		user1 = new User(Role.USER, "User1", "123", "User1.@gmail.com", "123456789l", bookings);
		user2 = new User(Role.USER, "User2", "456", "User2.@gmail.com", "456123789l", bookings);
		user3 = new User(Role.USER, "User3", "789", "User3.@gmail.com", "789456123l", bookings);

		//___________________________________________________________
		book1 = new Booking(user1, LocalDate.of(2021, 8, 10), passengers,  Sflight1, 75);
		book2 = new Booking(user2, LocalDate.of(2021, 8, 11), passengers,  Sflight2, 60);
		book3 = new Booking(user3, LocalDate.of(2021, 8, 12), passengers, Sflight3, 40);
		
		bookings.add(book1);
		bookings.add(book2);
		bookings.add(book3);
		
		user1.setBookings(bookings);
		
		
		//___________________________________________________________
		pass1 = new Passenger( "Pass1", 15, 123456l, 40.0);
		pass2 = new Passenger( "Pass2", 25, 125645l, 60.0);
		
		passengers.add(pass1);
		passengers.add(pass2);
		
		
		//____________________________________________________________
		flight1 = new Flight(441l, "indigo", "337 boeing", 120);
		flight2 = new Flight(441l, "Emirates", "777 Passengers", 100);
		
		
		
		
	}
		
		@AfterEach
		void tearDown() throws Exception {
		}

		@Test
		public void addBkookingTest() {
			when(bRepo.save(book1)).thenReturn(book1);
			Assertions.assertEquals(book1, bookService.addBooking(book1));
		}
		
		
		@Test
		public void ModifyBookingTest() throws BookingNotFoundException {
			when(bRepo.findById(book1.getBookingId())).thenReturn(Optional.of(book1));
			when(bRepo.save(book1)).thenReturn(book3);
			Assertions.assertEquals(book3, bookService.modifyBooking(book1));

		}
		
		
		@Test
		public void deleteBookingTest() throws BookingNotFoundException {
			when(bRepo.findById(book1.getBookingId())).thenReturn(Optional.of(book1));
			Assertions.assertEquals(book1, bookService.deleteBooking(book1.getBookingId()));
	
		}
		
		
		@Test
		public void viewAllBookingsTest() throws BookingNotFoundException {
			when(bRepo.findAll()).thenReturn(bookings);
			Assertions.assertEquals(3, bookService.viewAllBookings().size());
		}
		
		

}

