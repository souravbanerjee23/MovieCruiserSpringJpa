package com.cognizant.moviecruiser.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.moviecruiser.repository.MovieRepository;
import com.cognizant.moviecruiser.dao.MovieDao;
import com.cognizant.moviecruiser.model.Movie;

@Service("movieService")
public class MovieService {
	@Autowired
	MovieDao movieDao;

	@Autowired
	MovieRepository movieRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger(MovieService.class);

	public void setMenuItemDao(MovieDao moviedao) {
		this.movieDao = moviedao;
	}

	@Transactional
	public List<Movie> getMovieListAdmin() {
		LOGGER.info("start");
		return movieRepository.findAll();

	}

	@Transactional
	public List<Movie> getMovieListCustomer() {
		LOGGER.info("start");
		return movieRepository.findByActiveAndDateOfLaunchLessThan(true, new Date());

	}

	@Transactional
	public Movie getMovie(long movieId) {
		LOGGER.info("start");
		return movieRepository.getOne(movieId);

	}

	@Transactional
	public void modifyMovie(Movie movie) {
		LOGGER.info("start");
		movieRepository.save(movie);

	}

}
