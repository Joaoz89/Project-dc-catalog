package com.devsuperior.dscatalog.projections;

import java.time.Instant;

public interface NotificationProjection {

	String getText();
	Instant getMoment();
}
