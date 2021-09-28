package ru.netology.afisha;


public class MovieManager {
    private MovieItem[] items = new MovieItem[0];
    private int countOfMovies = 10;

    public MovieManager() {
    }

    public MovieManager(int i) {
    }

//    public void MovieItem (int countOfMovies) {
//        this.countOfMovies = countOfMovies;
//    }

    public void save(MovieItem item) {
        int length = items.length + 1;
        MovieItem[] tmp = new MovieItem[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length-1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public MovieItem[] getAll() {
        int resultLength;
        if (items.length>countOfMovies) {
            resultLength = countOfMovies;
        } else {
            resultLength = items.length;
        }
        MovieItem[] result = new MovieItem[items.length];
        for (int i=0; i<result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }
}
