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
        stream(alivePoints).forEach(point -> assertThat(cellGrid.getCell(point).getStatus(), is(ALIVE)));
    }

    @Test
    public void should_get_dead_cell_when_given_off_edge_point() {
        Point[] offEdgePoints = {new Point(0, 0), new Point(-1, 1), new Point(1, -1), new Point(1, 2), new Point(2, 1)};
        CellGrid cellGrid = new CellGrid(1, 1, new Point[]{new Point(1, 1)});
        stream(offEdgePoints).forEach(point -> assertThat(cellGrid.getCell(point).getStatus(), is(DEAD)));
    }
}
