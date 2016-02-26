package kata.conway;

import static java.util.Arrays.stream;
import static kata.conway.CellStatus.ALIVE;
import static kata.conway.CellStatus.DEAD;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.awt.*;

import org.junit.Test;

public class CellGridTest {

    @Test
    public void should_be_able_to_init_cell_grid() {
        Point[] alivePoints = new Point[]{new Point(2, 5), new Point(3, 4), new Point(3, 5)};
        CellGrid cellGrid = new CellGrid(4, 8, alivePoints);

        stream(alivePoints).forEach(point -> assertThat(cellGrid.getCellAt(point).getStatus(), is(ALIVE)));
        assertThat(cellGrid.getCellAt(new Point(2, 4)).getAliveNeighbourAmount(), is(3));
        assertThat(cellGrid.getCellAt(new Point(2, 5)).getAliveNeighbourAmount(), is(2));
    }

    @Test
    public void should_get_dead_cell_when_given_off_edge_point() {
        Point[] offEdgePoints = {new Point(0, 0), new Point(-1, 1), new Point(1, -1), new Point(1, 2), new Point(2, 1)};
        CellGrid cellGrid = new CellGrid(1, 1, new Point[]{new Point(1, 1)});

        stream(offEdgePoints).forEach(point -> assertThat(cellGrid.getCellAt(point).getStatus(), is(DEAD)));
    }

    @Test
    public void should_get_zero_alive_neighbour_when_given_one_plus_one_grid() {
        CellGrid cellGrid = new CellGrid(1, 1, new Point[]{new Point(1, 1)});
        int result = cellGrid.countAliveNeighbourAmount(new Point(1, 1));

        assertThat(result, is(0));
    }

    @Test
    public void should_get_three_alive_neighbour_when_given_two_plus_two_all_alive_cells_grid() {
        CellGrid cellGrid = new CellGrid(2, 2, new Point[]{new Point(1, 1), new Point(1, 2), new Point(2, 1), new Point(2, 2)});
        int result = cellGrid.countAliveNeighbourAmount(new Point(1, 1));

        assertThat(result, is(3));
    }

    @Test
    public void should_get_zero_alive_neighbour_when_given_off_edge_point() {
        CellGrid cellGrid = new CellGrid(1, 1, new Point[]{new Point(1, 1)});

        assertThat(cellGrid.countAliveNeighbourAmount(new Point(0, 1)), is(0));
        assertThat(cellGrid.countAliveNeighbourAmount(new Point(1, 0)), is(0));
        assertThat(cellGrid.countAliveNeighbourAmount(new Point(-1, -1)), is(0));
        assertThat(cellGrid.countAliveNeighbourAmount(new Point(2, 1)), is(0));
    }

    @Test
    public void should_be_able_to_go_next_generation() {
        Point[] alivePoints = new Point[]{new Point(2, 5), new Point(3, 4), new Point(3, 5)};
        CellGrid cellGrid = new CellGrid(4, 8, alivePoints);

        cellGrid.goNextGeneration();

        assertThat(cellGrid.getCellAt(new Point(2, 4)).getStatus(), is(ALIVE));
        assertThat(cellGrid.getCellAt(new Point(2, 5)).getAliveNeighbourAmount(), is(3));
    }

}
