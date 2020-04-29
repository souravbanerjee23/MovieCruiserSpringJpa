package com.cognizant.moviecruiser.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.util.DateUtil;

public class MovieServiceTest {

	static {
		System.setProperty("org.slf4j.simpleLogger.defaultLogLevel", "debug");
	}

	private static final Logger LOGGER = LoggerFactory.getLogger(MovieServiceTest.class);

	private static MovieService movieService;

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		movieService = context.getBean(MovieService.class);

		 testGetMovieListAdmin();
		// testGetMovieListCustomer() ;
		//testGetMovie();
		 testModifyMovie();
	}

	public static void testGetMovieListAdmin() {
		LOGGER.info("start");
		List<Movie> movies = movieService.getMovieListAdmin();
		LOGGER.debug("Movies{}", movies);
		LOGGER.info("end");
	}

	public static void testGetMovieListCustomer() {
		LOGGER.info("start");
		List<Movie> movies = movieService.getMovieListCustomer();
		LOGGER.debug("Movies{}", movies);
		LOGGER.info("end");
	}

	public static void testGetMovie() {
		LOGGER.info("start");
		Movie movies = movieService.getMovie(1);
		LOGGER.debug("Movies{}", movies);
		LOGGER.info("end");
	}

	public static void testModifyMovie() {
		LOGGER.info("start");
		Movie movie = new Movie(1, "The Martian", "$2,514,512,988", true, DateUtil.convertToDate("16/08/2022"),
				"Fiction", false);
		movieService.modifyMovie(movie);
		List<Movie> movies = movieService.getMovieListAdmin();
		LOGGER.debug("Movies{}", movies);
		LOGGER.info("end");
	}
}