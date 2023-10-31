package com.souleima.biscuits.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nomBisc", types = { Biscuit.class })
public interface BiscuitProjection {
	public String getNomBiscuit();
}

