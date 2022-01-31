package com.safety.Controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.safety.Exception.RecordNotFoundException;
import com.safety.Model.Incident;
import com.safety.Service.IncidentService;

@EnableTransactionManagement
@RestController
@RequestMapping("/incident")
public class IncidentRestController {
    @Autowired
	IncidentService service;
    
	@PostMapping("/addIncident")
	public ResponseEntity<Incident> addIncident(@Validated @RequestBody Incident incident)
	{
			Incident e= service.addIncident(incident);
			System.out.println(e);
			
			return new ResponseEntity<Incident>(e,HttpStatus.OK);
		}
		

	@GetMapping
	public ResponseEntity<List<Incident>> fetchIncidents(){
		List<Incident> incident=service.findallIncident();
		return ResponseEntity.ok().body(incident);
	}
	@GetMapping("/{incidentId}")
	public ResponseEntity<List<Incident>> getIncidentById(@PathVariable int incidentId){
		
		Optional<Incident> incident = service.findByIncidentId(incidentId);
		if(incident.isPresent()) {
			return new ResponseEntity(incident.get(), HttpStatus.OK);
		}
		else {
			throw new RecordNotFoundException("Record not found...");
		}
	}
	@PutMapping("/{incidentId}")
	public ResponseEntity<Incident> updateIncident(@PathVariable int incidentId, @RequestBody Incident incident){
		Incident e=service.updateIncident(incidentId, incident);
		return new ResponseEntity<Incident>(e,HttpStatus.OK);
	}
	

}