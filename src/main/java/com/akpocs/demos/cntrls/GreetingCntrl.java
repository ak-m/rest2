package com.akpocs.demos.cntrls;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/greeting")
@Slf4j
public class GreetingCntrl {

	private static Logger log = LoggerFactory.getLogger(GreetingCntrl.class);

	@GetMapping("/greet")
	public String getGreeting() {
		log.debug("Got getGreeting");
		InetAddress ip = null;
		String hostname = null;
		try {
			ip = InetAddress.getLocalHost();
			hostname = ip.getHostName();
			System.out.println("Your current IP address : " + ip);
			System.out.println("Your current Hostname : " + hostname);

		} catch (UnknownHostException e) {

			e.printStackTrace();
		}

		StringBuilder sb = new StringBuilder();
		sb.append("Host: ").append(hostname).append(" IP: ").append(ip).append(" Servertime: ")
				.append(LocalDateTime.now());

		String ServerResponse = sb.toString();

		log.debug("Server Greeting Response {}", ServerResponse);
		return ServerResponse;

	}

}
