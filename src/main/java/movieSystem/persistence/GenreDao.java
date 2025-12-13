package movieSystem.persistence;


import movieSystem.business.GenreTest;

import java.util.ArrayList;

public interface GenreDao {
    public ArrayList<GenreTest> getAllGenres();

    public GenreTest getGenreById(int id);

    public GenreTest getGenreByName(String name);
}
