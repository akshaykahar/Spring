package com.safety.DAO;


import java.util.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.safety.Model.Incident;


public interface IncidentDAO extends JpaRepository<Incident, Integer> {
	@Modifying
	@Query("update Incident i set i.incidentInfo=inputIncidentInfo  ,i.incidentDate = inputIncidentDate ")
	void setIncident(String incidentInfo,Date incidentDate);


}
