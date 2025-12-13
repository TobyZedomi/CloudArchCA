package movieSystem.controller;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import movieSystem.business.*;
import movieSystem.persistence.*;
import movieSystem.service.MovieService;
import java.util.*;

@Controller
@Slf4j
public class IndexController {

    @Autowired
    private MovieService movieService;

    /**
     * Login page
     * @return the login page
     */
    @GetMapping("/")
    public String userIndex() {
        return "user_index";
    }

    /**
     * The register page
     * @return the register page
     */
    @GetMapping("/user_indexSignUp")
    public String userIndexSignUp() {
        return "user_indexSignUp";
    }

    // add these .add model from list of movies from movie db into index controller

    /**
     * Is the home page where the most popular movies are displayed
     * @param session holds the logged-in users information
     * @param model holds information for the view
     * @return the index page if teh user is logged in and the notValidUser page if the user isn't logged in
     */
    @GetMapping("/index")
    public String home(HttpSession session, Model model) {


        if(session.getAttribute("loggedInUser") != null) {

            // favourite list session
            User u = (User) session.getAttribute("loggedInUser");

            /// movie db get most popular movies

            List<MovieTest> movies = movieService.getMovies();

            // create new list to add the movies from the movie db into
            List<MovieTest> newMovie = new ArrayList<>();

            GenreDao genreDao = new GenreDaoImpl("database.properties");

            // loop through the movie db list and reduce the size by 2
            for (int i = 0; i < movies.size() - 2; i++) {


                // if any backdrop image is unavailable it will not add it to the new arraylist
                if (movies.get(i).getBackdrop_path() != null && movies.get(i).getGenre_ids().length > 0) {
                    movies.get(i).setGenreName(genreDao.getGenreById(Integer.parseInt(movies.get(i).getGenre_ids()[0])).getName());
                    // add the movies from the movie db into the new arraylist
                    newMovie.add(movies.get(i));
                    model.addAttribute("movies", newMovie);
                }


            }

            for (int i = 0; i < movies.size(); i++) {

                List<MovieTrailer> trailers = movieService.getTrailer(movies.get(i).getId());
                model.addAttribute("trailers", trailers);
            }


            return "index";
        }

        return "notValidUser";
    }

    /**
     * Is the page where the movies are being displayed by the genre name the users chooses
     * @param session holds the logged-in users information
     * @param model holds information for the view
     * @return the movie index page and the notValidUser page when the user isnt logged in
     */

    @GetMapping("/movie_index")
    public String movieIndex(HttpSession session, Model model) {

        if(session.getAttribute("loggedInUser") != null) {

            User u = (User) session.getAttribute("loggedInUser");

            GenreDao genreDao = new GenreDaoImpl("database.properties");


            List<GenreTest> genres = movieService.getGenres();
            model.addAttribute("genres", genres);

            String genreId = (String) session.getAttribute("genreId2");

            if (genreId != null) {

                List<MovieTest> movieByGenres = movieService.getMoviesByGenre(genreId);

                List<MovieTest> newMovie = new ArrayList<>();

                for (int i = 0; i < movieByGenres.size() - 2; i++) {


                    if (movieByGenres.get(i).getBackdrop_path() != null && movieByGenres.get(i).getGenre_ids().length > 0) {
                        movieByGenres.get(i).setGenreName(genreDao.getGenreById(Integer.parseInt(genreId)).getName());
                        newMovie.add(movieByGenres.get(i));
                        model.addAttribute("movieByGenres", newMovie);
                    }


                }

                // genre by id and get the name

                // use a session for this based on the controller method view movie by genre, testing branch

                GenreTest genre = genreDao.getGenreById(Integer.parseInt(genreId));

                model.addAttribute("genreName", genre.getName());

                return "movie_index";

            }

            else{

                toViewMoviesByGenreMovieIndex(model, session);

                return "movie_index";
            }
        }
        return "notValidUser";
    }



    @GetMapping("/logout_index")
    public String userIndex2() {
        return "logout_index";
    }

    /**
     * I steh page the users sees when the registration is a success. The user will see the most popular movies
     * @param session holds the logged-in users information
     * @param model holds information for the view
     * @return registerSuccessUser page and the notValidUser page if the users isn't logged in
     */
    @GetMapping("/registerSuccessUser")
    public String regIndex(HttpSession session, Model model) {

        if(session.getAttribute("loggedInUser") != null) {

            List<MovieTest> movies = movieService.getMovies();

            // create new list to add the movies from the movie db into
            List<MovieTest> newMovie = new ArrayList<>();

            // loop through the movie db list and reduce the size by 2
            for (int i = 0; i < movies.size() - 2; i++) {

                // if any backdrop image is unavailable it will not add it to the new arraylist
                if (movies.get(i).getBackdrop_path() != null) {
                    // add the movies from the movie db into the new arraylist
                    newMovie.add(movies.get(i));
                    model.addAttribute("movies", newMovie);
                }
            }
            return "registerSuccessUser";
        }
        return "notValidUser";
    }

    /**
     * Page for if the movie video entered by the user doesn't exist
     * @param session holds the logged-in users information
     * @param model holds information for the view
     * @return noVideo page and notValidUser page when the user isn't logged in
     */
    @GetMapping("/noVideo")
    public String noVideosForMovie(HttpSession session, Model model) {

        if(session.getAttribute("loggedInUser") != null) {

            return "noVideo";
        }

        return "notValidUser";
    }

    private void toViewMoviesByGenreMovieIndex(Model model, HttpSession session){

        User u = (User) session.getAttribute("loggedInUser");

        List<GenreTest> genres = movieService.getGenres();
        model.addAttribute("genres", genres);


        List<MovieTest> movieByGenres = movieService.getMoviesByGenre("878");

        List<MovieTest> newMovie = new ArrayList<>();

        for (int i = 0; i < movieByGenres.size() - 2; i++) {

            if (movieByGenres.get(i).getBackdrop_path() != null && movieByGenres.get(i).getGenre_ids().length > 0) {
                movieByGenres.get(i).setGenreName("Science Fiction");
                newMovie.add(movieByGenres.get(i));
                model.addAttribute("movieByGenres", newMovie);
            }

        }

        // genre by id and get the name

        GenreDao genreDao = new GenreDaoImpl("database.properties");

        GenreTest genre = genreDao.getGenreById(878);

        model.addAttribute("genreName", genre.getName());
    }


}
