package com.akpocs.demos.cntrls;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class HostInfoCntrl {
	
	private static Logger log = LoggerFactory.getLogger(HostInfoCntrl.class);

	@GetMapping("/hostinfo")
	public String getHostInfo() throws UnknownHostException {
		log.debug("getHostInfo()");
		
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern("MM/dd/yyyy 'at' hh:mm:ss a");
		String serverTime = ofPattern.format(LocalDateTime.now());
		InetAddress localHost = InetAddress.getLocalHost();
		String serverResponse = new StringBuilder().append(" IP ").append(localHost.getHostAddress())
							.append(" Host :").append(localHost.getHostName())
							.append(" @ ").append(serverTime)
							.toString();
		log.debug("Server resposne {} ", serverResponse);
		
		return serverResponse;
	}
}
