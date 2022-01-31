package com.safety.Service;

import java.util.List;
import java.util.Optional;

import com.safety.Model.Incident;

public interface IncidentService {

	List<Incident> findallIncident();

	Incident addIncident(Incident incident);

	Optional<Incident> findByIncidentId(int incidentId);

	Incident updateIncident(int incidentId, Incident incident);

}
