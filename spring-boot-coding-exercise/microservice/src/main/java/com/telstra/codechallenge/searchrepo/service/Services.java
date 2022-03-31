package com.telstra.codechallenge.searchrepo.service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientException;

import com.telstra.codechallenge.searchrepo.dto.UserList;
import com.telstra.codechallenge.searchrepo.dto.Users;

import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author NARENDRA
 */
@Service
@Slf4j
public class Services {

	private static final Logger log=LoggerFactory.getLogger(Services.class);;
	@Value("${base.uri}")
	private String url;

	@Value("${base.path}")
	private String path;

	public List<Users> getUsersList(long noOfRepo) {
		UserList userslist=null;
		try {
			userslist = WebClient.create(url).post()
					.uri(uriBuilder -> uriBuilder.path(path).queryParam("q", "created:>`date -v-7d '+%Y-%m-%d'`")
							.queryParam("sort", "stars").queryParam("order", "desc").build())
					.retrieve().bodyToMono(UserList.class).block();
			return userslist.getUsers().stream().limit(noOfRepo).collect(Collectors.toList());
		} catch (WebClientException ex) {
			log.error("Exception occurred while querying api {}", ex.getMessage());
		}
		return Collections.emptyList();
	}
}
