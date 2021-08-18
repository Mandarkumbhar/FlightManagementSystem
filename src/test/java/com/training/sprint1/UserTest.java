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
import com.training.sprint1.exception.RecordNotFoundException;
import com.training.sprint1.exception.UserNotFoundException;
import com.training.sprint1.repository.IUserRepository;
import com.training.sprint1.service.UserService;

@SpringBootTest
public class UserTest {
	
		@Mock
		IUserRepository userRepo;
		
		@InjectMocks
		UserService userService;
		
		
		List<User> userList;
		User user1, user2, user3;
		
		List<Booking> bookings = new ArrayList<>();
		Booking book1, book2;
		
		List<Passenger> passengers = new ArrayList<>();
		Passenger pass1, pass2;
		
		List<Flight> flights = new ArrayList<>();
		Flight flight1, flight2;
		
		
		//_____________________________________________________________
		Airport a1 = new Airport(11l, "Bombay Airlines", "Mumbai");
		Airport a2 = new Airport(12l, "Pune Airlines", "Pune");
		Airport a3 = new Airport(12l, "Thane Airlines", "Thane");
		Airport a4 = new Airport(12l, "Jaipur Airlines", "Jaipur");
		
		Schedule s1 =  new Schedule(a1, a2,LocalDate.of(2021, 8, 23) ,LocalTime.of(6, 30), LocalTime.of(7, 30));
		Schedule s2 =  new Schedule(a3, a4,LocalDate.of(2021, 8, 24) ,LocalTime.of(8, 30), LocalTime.of(9, 00));
		
		ScheduledFlight Sflight1 = new ScheduledFlight(flight1, 10, s1);
		ScheduledFlight Sflight2 = new ScheduledFlight(flight2, 15, s2);
		
		
		
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
			userList = new ArrayList<>();
			user1 = new User(Role.USER, "User1", "123", "User1.@gmail.com", "123456789l", bookings);
			
			user2 = new User(Role.USER, "User2", "456", "User2.@gmail.com", "456123789l", bookings);
			
			user3 = new User(Role.USER, "User3", "789", "User3.@gmail.com", "789456123l", bookings);
		
			userList.add(user1);
			userList.add(user2);
			userList.add(user3);
			
			//___________________________________________________________
			book1 = new Booking(user1, LocalDate.of(2021, 8, 10), passengers, 200.0, Sflight1, 75);
			book2 = new Booking(user2, LocalDate.of(2021, 8, 11), passengers, 350.0, Sflight2, 60);
			
			bookings.add(book1);
			bookings.add(book2);
			
			user1.setBookings(bookings);
			
			
			//___________________________________________________________
			pass1 = new Passenger("Pass1", 15, 123456l, 40.0);
			pass2 = new Passenger("Pass2", 25, 125645l, 60.0);
			
			passengers.add(pass1);
			passengers.add(pass2);
			
			
			//____________________________________________________________
			flight1 = new Flight(441l, "indigo", "337 boeing", 120);
			flight2 = new Flight(441l, "Emirates", "777 Passengers", 100);
			
			
			flights.add(flight1);
			flights.add(flight2);
	
			
		}
			
			@AfterEach
			void tearDown() throws Exception {
			}

			@Test
			public void addUserTest() {
				when(userRepo.save(user1)).thenReturn(user1);
				Assertions.assertEquals(user1, userService.addUser(user1));
			}
			
			
			@Test
			public void updateUserTest() throws RecordNotFoundException {
				when(userRepo.findById(user1.getId())).thenReturn(Optional.of(user1));
				when(userRepo.save(user1)).thenReturn(user3);
				try {
					Assertions.assertEquals(user3, userService.updateUser(user1));
				} catch (UserNotFoundException e) {
					e.getMessage();
				}
			}
			
			
			@Test
			public void deleteUserTest() throws RecordNotFoundException {
				when(userRepo.findById(user1.getId())).thenReturn(Optional.of(user1));
				try {
					Assertions.assertEquals(user1, userService.deleteUser(user1.getId()));
				} catch (UserNotFoundException e) {
					e.getMessage();
				}
			}
			
			
			@Test
			public void viewAllUsersTest() throws RecordNotFoundException {
				when(userRepo.findAll()).thenReturn(userList);
				Assertions.assertEquals(3, userService.viewAllUsers().size());
			}
			
			

}
