package kata.conway;

import static kata.conway.CellStatus.*;

public class Cell {
    private CellStatus status;
    private int aliveNeighbourAmount;

    public Cell(CellStatus status) {
        this.status = status;
        this.aliveNeighbourAmount = 0;
    }

    public Cell generateNext() {
        return ((status == ALIVE && aliveNeighbourAmount == 2) || aliveNeighbourAmount == 3) ?
                new Cell(ALIVE) : new Cell(DEAD);
    }

    public void setAliveNeighbourAmount(int aliveNeighbourAmount) {
        this.aliveNeighbourAmount = aliveNeighbourAmount;
    }

    public CellStatus getStatus() {
        return status;
    }

    public int getAliveNeighbourAmount() {
        return aliveNeighbourAmount;
    }
}
