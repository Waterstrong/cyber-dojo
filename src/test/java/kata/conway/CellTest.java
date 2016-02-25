package kata.conway;

import static kata.conway.CellStatus.ALIVE;
import static kata.conway.CellStatus.DEAD;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class CellTest {

    private final Cell currAliveCell = new Cell(ALIVE);
    private final Cell currDeadCell = new Cell(DEAD);

    @Test
    public void should_alive_cell_dies_in_next_generation_when_has_zero_alive_neighbour() {
        currAliveCell.setAliveNeighbourCount(0);

        Cell nextGenCell = currAliveCell.generateNext();

        assertThat(nextGenCell.getStatus(), is(DEAD));
    }

    @Test
    public void should_alive_cell_dies_in_next_generation_when_has_one_alive_neighbour() {
        currAliveCell.setAliveNeighbourCount(1);

        Cell nextGenCell = currAliveCell.generateNext();

        assertThat(nextGenCell.getStatus(), is(DEAD));
    }

    @Test
    public void should_alive_cell_still_alive_in_next_generation_when_has_two_alive_neighbours() {
        currAliveCell.setAliveNeighbourCount(2);

        Cell nextGenCell = currAliveCell.generateNext();

        assertThat(nextGenCell.getStatus(), is(ALIVE));
    }

    @Test
    public void should_alive_cell_still_alive_in_next_generation_when_has_three_alive_neighbours() {
        currAliveCell.setAliveNeighbourCount(3);

        Cell nextGenCell = currAliveCell.generateNext();

        assertThat(nextGenCell.getStatus(), is(ALIVE));
    }

    @Test
    public void should_alive_cell_dies_in_next_generation_when_has_more_than_three_alive_neighbours() {
        currAliveCell.setAliveNeighbourCount(4);

        Cell nextGenCell = currAliveCell.generateNext();

        assertThat(nextGenCell.getStatus(), is(DEAD));
    }

    @Test
    public void should_dead_cell_go_alive_in_next_generation_when_has_three_alive_neighbours() {
        currDeadCell.setAliveNeighbourCount(3);

        Cell nextGenCell = currDeadCell.generateNext();

        assertThat(nextGenCell.getStatus(), is(ALIVE));
    }

    @Test
    public void should_dead_cell_still_dead_in_next_generation_when_not_has_three_alive_neighbours() {
        currDeadCell.setAliveNeighbourCount(2);

        Cell nextGenCell = currDeadCell.generateNext();

        assertThat(nextGenCell.getStatus(), is(DEAD));
    }
}
