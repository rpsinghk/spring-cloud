package com.cloud.httpsession;

import java.io.Console;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import redis.clients.jedis.Jedis;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SessionControllTests {

	private Jedis jedis;
	private TestRestTemplate testRestTemplate;
	private TestRestTemplate testRestTemplateWithAuth;
	private String testUrl = "http://localhost:8080/";

	@Before
	public void clearRedisData() {
		testRestTemplate = new TestRestTemplate();
		testRestTemplateWithAuth = new TestRestTemplate("admin", "password", null);

		jedis = new Jedis("localhost", 6379);
		jedis.flushAll();
	}

	@Test
	public void testUnauthenticatedCantAccess() {
		ResponseEntity<String> result = testRestTemplate.getForEntity(testUrl, String.class);
		Object o = result.getStatusCode();
		assertEquals(HttpStatus.UNAUTHORIZED, o);
		System.err.println(o);
	}

	@Test
	public void testRedisControlsSession() {

		ResponseEntity<String> result = testRestTemplateWithAuth.getForEntity(testUrl, String.class);
		assertEquals("hello admin", result.getBody()); // login worked

		Set<String> redisResult = jedis.keys("*");
		assertTrue(redisResult.size() > 0); // redis is populated with session data

		String sessionCookie = result.getHeaders().get("Set-Cookie").get(0).split(";")[0];
		HttpHeaders headers = new HttpHeaders();
		headers.add("Cookie", sessionCookie);
		HttpEntity<String> httpEntity = new HttpEntity<>(headers);

		result = testRestTemplate.exchange(testUrl, HttpMethod.GET, httpEntity, String.class);
		assertEquals("hello admin", result.getBody()); // access with session works worked

		jedis.flushAll(); // clear all keys in redis

		result = testRestTemplate.exchange(testUrl, HttpMethod.GET, httpEntity, String.class);
		assertEquals(HttpStatus.UNAUTHORIZED, result.getStatusCode());
		// access denied after sessions are removed in redis
	}

}
