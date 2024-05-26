package com.nosetr.firebase.auth.config;

import java.io.FileInputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

/**
 * Configuration class to initialize the Firebase Admin SDK.
 */
@Configuration
public class FirebaseConfig {

	@Value("${firebase.key}")
	private String firebaseKey;
	
	@Bean
	public FirebaseApp initializeFirebase() throws IOException {
		File file = ResourceUtils.getFile("classpath:firebase-service-account.json");

		FileInputStream serviceAccount = new FileInputStream(file);

		FirebaseOptions options = FirebaseOptions.builder()
				.setCredentials(GoogleCredentials.fromStream(serviceAccount))
				.build();

		return (FirebaseApp.getApps()
				.isEmpty()) ? FirebaseApp.initializeApp(options) : FirebaseApp.getInstance();
	}

	/**
	 * An additional FirebaseAuth bean that uses the FirebaseApp instance.
	 * This ensures that FirebaseAuth can be injected into other classes.
	 */
	@Bean
	public FirebaseAuth firebaseAuth(FirebaseApp firebaseApp) {
		return FirebaseAuth.getInstance(firebaseApp);
	}
}
