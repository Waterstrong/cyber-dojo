package kata.conway;

import static kata.conway.CellStatus.*;

public class Cell {
    private static final int TWO = 2;
    private static final int THREE = 3;
    private final CellStatus status;
    private int aliveNeighbourCount;

    public Cell(CellStatus status) {
        this.status = status;
    }

    public Cell generateNext() {
        if(status == DEAD && aliveNeighbourCount == THREE) {
            return new Cell(ALIVE);
        }
        if(status == ALIVE && aliveNeighbourCount >= TWO && aliveNeighbourCount <= THREE) {
            return new Cell(ALIVE);
        }
        return new Cell(DEAD);
    }

    public void setAliveNeighbourCount(int aliveNeighbourCount) {
        this.aliveNeighbourCount = aliveNeighbourCount;
    }

    public CellStatus getStatus() {
        return status;
    }
}
