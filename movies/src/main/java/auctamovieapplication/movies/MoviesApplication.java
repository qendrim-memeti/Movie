package auctamovieapplication.movies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication
public class MoviesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviesApplication.class, args);


		String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=master;user=sa;password=your_password";

		try {
			System.out.print("Connecting to SQL Server ... ");
			try (Connection connection = DriverManager.getConnection(connectionUrl)) {
				System.out.println("Done.");
			}
		} catch (Exception e) {
			System.out.println();
			e.printStackTrace();
		}
	}
}