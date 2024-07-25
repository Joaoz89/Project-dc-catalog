package com.devsuperior.dscatalog.projections;

import java.time.Instant;
import java.util.List;
import java.util.Set;

import com.devsuperior.dscatalog.entities.Deliver;
import com.devsuperior.dscatalog.entities.Lesson;

public interface EnrollmentProjection {
	
	Long getUserId();
	Long getOfferId();
	
	Instant getEnrollMoment();
	Instant getRefundMoment();
	Boolean getAvailable();
	Boolean getOnlyUpdate();
	String getName();
	
	Instant getStartMoment();
	Instant getEndMoment();
	String getEdition();
	
	
}
