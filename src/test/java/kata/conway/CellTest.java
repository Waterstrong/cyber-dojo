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
        currAliveCell.setAliveNeighbourAmount(0);

        Cell nextGenCell = currAliveCell.generateNext();

        assertThat(nextGenCell.getStatus(), is(DEAD));
    }

    @Test
    public void should_alive_cell_dies_in_next_generation_when_has_one_alive_neighbour() {
        currAliveCell.setAliveNeighbourAmount(1);

        Cell nextGenCell = currAliveCell.generateNext();

        assertThat(nextGenCell.getStatus(), is(DEAD));
    }

    @Test
    public void should_alive_cell_still_alive_in_next_generation_when_has_two_alive_neighbours() {
        currAliveCell.setAliveNeighbourAmount(2);

        Cell nextGenCell = currAliveCell.generateNext();

        assertThat(nextGenCell.getStatus(), is(ALIVE));
    }

    @Test
    public void should_alive_cell_still_alive_in_next_generation_when_has_three_alive_neighbours() {
        currAliveCell.setAliveNeighbourAmount(3);

        Cell nextGenCell = currAliveCell.generateNext();

        assertThat(nextGenCell.getStatus(), is(ALIVE));
    }

    @Test
    public void should_alive_cell_dies_in_next_generation_when_has_more_than_three_alive_neighbours() {
        currAliveCell.setAliveNeighbourAmount(4);

        Cell nextGenCell = currAliveCell.generateNext();

        assertThat(nextGenCell.getStatus(), is(DEAD));
    }

    @Test
    public void should_dead_cell_go_alive_in_next_generation_when_has_three_alive_neighbours() {
        currDeadCell.setAliveNeighbourAmount(3);

        Cell nextGenCell = currDeadCell.generateNext();

        assertThat(nextGenCell.getStatus(), is(ALIVE));
    }

    @Test
    public void should_dead_cell_still_dead_in_next_generation_when_not_has_three_alive_neighbours() {
        currDeadCell.setAliveNeighbourAmount(2);

        Cell nextGenCell = currDeadCell.generateNext();

        assertThat(nextGenCell.getStatus(), is(DEAD));
    }

    @Test
    public void should_get_zero_alive_neighbour_when_init_cell() {
        assertThat(new Cell(ALIVE).getAliveNeighbourAmount(), is(0));
    }
}
