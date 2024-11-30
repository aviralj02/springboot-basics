package com.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.Movie;
import com.demo.repository.MovieRepository;

@RestController
@RequestMapping(value = "/api/movies")
public class MovieController {
	
	@Autowired
	private MovieRepository movieRepo;
	
	@GetMapping
	@ResponseBody
	public List<Movie> getMovies(){
		return movieRepo.findAll();
	}
	
	@GetMapping("/saveMovie")
	@ResponseBody
	public Movie saveMovieToDb() {
		Movie m1 = new Movie();
		m1.setTitle("Something");
		m1.setReleaseYear(2020);
		m1.setRating(4.8);
		
		return movieRepo.save(m1);
	}
}
