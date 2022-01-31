package com.safety;
	
	import static org.junit.jupiter.api.Assertions.assertEquals;
	import static org.mockito.Mockito.when;

	import java.util.Date;
	import java.util.List;
	import java.util.stream.Collectors;
	import java.util.stream.Stream;

	import org.junit.jupiter.api.Test;
	import org.junit.runner.RunWith;
	import org.mockito.stubbing.OngoingStubbing;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.boot.test.context.SpringBootTest;
	import org.springframework.boot.test.mock.mockito.MockBean;
	import org.springframework.test.context.junit4.SpringRunner;

	import com.safety.Model.Incident;
	import com.safety.DAO.IncidentDAO;
import com.safety.Service.IncidentService;

	@RunWith(SpringRunner.class)
	@SpringBootTest
	public class IncidentTest {
		@MockBean
		IncidentDAO repository;
		
		@Autowired
		IncidentService service;

		@Test
		 public void getAllIncidentTest() {
			
			 Date incidentDate=null;
		
			OngoingStubbing<List<Incident>> thenReturn = when(repository.findAll()).thenReturn
					(Stream.of( new Incident(1, "collapse",incidentDate)).collect(Collectors.toList()));       
			assertEquals(1,service.findallIncident().size());
		}
		
		@Test
		public void saveIncident() {
			Incident incident =new Incident(1, "collapse", null);
			when(repository.save(incident)).thenReturn(incident);
			assertEquals(incident,service.addIncident(incident));
		}

}
