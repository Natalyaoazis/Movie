package ru.netology.afisha;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovieManagerTest {
    MovieManager manager = new MovieManager();
    private MovieItem first = new MovieItem(1, "Бладшот", "боевик");
    private MovieItem second = new MovieItem(2, "Вперед", "мультфильм");
    private MovieItem third = new MovieItem(3, "Отель Белград", "комедия");
    private MovieItem fourth = new MovieItem(4, "Джентельмены", "боевик");
    private MovieItem fifth = new MovieItem(5, "Человек-невидимка", "ужасы");
    private MovieItem sixth = new MovieItem(6, "Троли. Мировой Тур", "мультфильм");
    private MovieItem seventh = new MovieItem(7, "Номер один", "комедия");
    private MovieItem eighth = new MovieItem(8, "Один дома", "комедия");
    private MovieItem ninth = new MovieItem(9, "Тупой и еще тупее", "комедия");
    private MovieItem tenth = new MovieItem(10, "Брюс всемогущий", "комедия");
    private MovieItem eleventh = new MovieItem(11, "нет", "комедия");

@Test
    public void shouldGetAll() {
    manager.save(first);
    manager.save(second);
    manager.save(third);
    manager.save(fourth);
    manager.save(fifth);
    manager.save(sixth);
    manager.save(seventh);
    manager.save(eighth);
    manager.save(ninth);
    manager.save(tenth);
    MovieItem[] expected = new MovieItem[]{tenth, ninth,eighth,seventh,sixth,fifth, fourth, third,second, first};
    MovieItem[] actual = manager.getAll();
    assertArrayEquals(expected, actual);
}
    @Test
    public void shouldGetMin() {
        manager.save(first);
        MovieItem[] expected = new MovieItem[]{first};
        MovieItem[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }
@Test
    public void shouldGetMoreMin() {
    manager.save(first);
    manager.save(second);
    manager.save(third);
    manager.save(fourth);
    manager.save(fifth);
    MovieItem[] expected = new MovieItem[]{fifth, fourth, third,second, first};
    MovieItem[] actual = manager.getAll();
    assertArrayEquals(expected, actual);
}
@Test
    public void shouldGetNone() {
    MovieItem[] expected = new MovieItem[0];
    MovieItem[] actual = manager.getAll();
    assertArrayEquals(expected, actual);
}
@Test
    public void shouldGetMoreLimit() {
    MovieManager manager = new MovieManager(11);
    manager.save(first);
    manager.save(second);
    manager.save(third);
    manager.save(fourth);
    manager.save(fifth);
    manager.save(sixth);
    manager.save(seventh);
    manager.save(eighth);
    manager.save(ninth);
    manager.save(tenth);
    manager.save(eleventh);
    MovieItem[] expected = new MovieItem[]{eleventh,tenth, ninth,eighth,seventh,sixth,fifth, fourth, third,second, first};
    MovieItem[] actual = manager.getAll();
    assertArrayEquals(expected, actual);
}
    @Test
    public void shouldGetLessLimit() {
        MovieManager manager = new MovieManager(9);
        manager.save(first);
        manager.save(second);
        manager.save(third);
        manager.save(fourth);
        manager.save(fifth);
        manager.save(sixth);
        manager.save(seventh);
        manager.save(eighth);
        manager.save(ninth);
        MovieItem[] expected = new MovieItem[]{ninth,eighth,seventh,sixth,fifth, fourth, third,second, first};
        MovieItem[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

}