package com.cloud.gateway.proxies;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

import com.cloud.gateway.books.BooksDestination;

import reactor.core.publisher.Mono;

@Service
public class BookServiceProxy {

	private BooksDestination booksDestination;

	private WebClient client;

	public BookServiceProxy(BooksDestination orderDestinations, WebClient client) {
		this.booksDestination = orderDestinations;
		this.client = client;
	}

	public Mono<Book> findOrderById(String orderId) {
		Mono<ClientResponse> response = client
				.get()
				.uri(booksDestination.getBooksServiceUrl() + "/book/{bookId}", orderId)
				.exchange();
		return response.flatMap(resp -> {
			switch (resp.statusCode()) {
			case OK:
				return resp.bodyToMono(Book.class);
			case NOT_FOUND:
				return Mono.error(new BookNotFoundException());
			default:
				return Mono.error(new RuntimeException("Unknown" + resp.statusCode()));
			}
		});
	}

}