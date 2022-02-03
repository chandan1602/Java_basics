package java11features;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Version;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

//HTTP Client API in java.net.http is now standard
//java9(introduced)->java10(updated)->java11(standard feature)
public class BHttpClient {
	public static void main(String[] args) throws IOException, InterruptedException {
		HttpClient httpClient = HttpClient.newBuilder()
				.version(Version.HTTP_1_1)
				.connectTimeout(Duration.ofSeconds(10))
				.build();
		
		HttpRequest httpRequest = HttpRequest.newBuilder()
				.GET()
				.uri(URI.create("https://www.httpbin.org/get"))
				.setHeader("User-Agent", "Java 11 HttpCient Bot")
				.build();
		
		HttpResponse<String> response = 
				httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
		HttpHeaders headers = response.headers();
		headers.map().forEach((k, v) -> System.out.println(k + ":" + v));
		
		System.out.println(response.statusCode());
	    System.out.println(response.body());
	}
}
