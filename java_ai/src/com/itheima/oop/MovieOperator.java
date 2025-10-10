package com.itheima.oop;

import java.util.Scanner;

public class MovieOperator {
    private Movie[] movies;

    public MovieOperator(Movie[] movies){
        this.movies = movies;
    }
    public void printAllMovies() {
        for (Movie movie : movies) {
            System.out.println(movie.getId() +"\t"+ movie.getName() + "\t" + movie.getActor());
        }
    }

    public void searchMovieById() {
        System.out.println("plz intput the id of the movie you want to search");
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        for (Movie movie : movies) {
            if (movie.getId() == id) {
                System.out.println("the info of the movie is " + movie.getName() + "\t" + movie.getActor());
                return;
            }
        }
        System.out.println("the info of the movie is not found");
    }
}
