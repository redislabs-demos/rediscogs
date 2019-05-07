package com.redislabs.rediscogs;

import java.io.Serializable;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@ConfigurationProperties(prefix = "")
@EnableAutoConfiguration
@Data
public class RediscogsConfiguration {

	private int searchResultsLimit = 20;
	private long imageDelay = 3000;
	private String userAttribute = "username";
	private String likesAttribute = "likes";
	private String likesStream = "likes:stream";
	private int maxLikes = 10;
	private StompConfig stomp = new StompConfig();

	@Data
	public static class StompConfig implements Serializable {
		private static final long serialVersionUID = 706007058202655483L;
		private String host = "localhost";
		private int port = 8080;
		private String endpoint = "/websocket";
		private String destinationPrefix = "/topic";
		private String likesTopic = destinationPrefix + "/likes";

	}

}