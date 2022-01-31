package com.safety.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safety.DAO.IncidentDAO;
import com.safety.Model.Incident;

@Service

public class IncidentServiceimpl implements IncidentService{
	@Autowired
	IncidentDAO dao;
    
	@Override
	public Incident addIncident(Incident incident) {
		// TODO Auto-generated method stub
		Incident inc=dao.save(incident);
		return inc;
	}
    
	@Override
	public List<Incident> findallIncident() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}
    
	@Override
	public Optional<Incident> findByIncidentId(int incidentId) {
		// TODO Auto-generated method stub
		return dao.findById(incidentId);
	}
    
	public Incident updateIncident(Incident incident) {
		// TODO Auto-generated method stub
		return dao.save(incident);
	}

	@Override
	public Incident updateIncident(int incidentId, Incident incident) {
		// TODO Auto-generated method stub
		return dao.save(incident);
	}

	
	    






}