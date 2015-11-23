package ru.geekbrains.java1.ultimatetictactoe;


public class Field {
    Type[][] cells;

    public enum Type {
        X, O, N
    }

    Field() {
        cells = new Type[3][3];
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells.length; j++) {
                cells[j][i] = Type.N;
            }
        }
    }

    public void doShoot(Point point, Type type) {
        if (cells[point.getX()][point.getY()] == Type.X) {
            doShoot(Point.getRandomPoint(), type);
        }
        if (cells[point.getX()][point.getY()] == Type.O) {
            doShoot(Point.getRandomPoint(), type);
        }
        if (cells[point.getX()][point.getY()] == Type.N) {
            cells[point.getX()][point.getY()] = type;
        }
    }

    public void showField() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells.length; j++) {
                System.out.print(cells[j][i] + " ");
            }
            System.out.print("\n");
        }
    }

    public int setWinner() {
        if ((cells[0][0] == Type.X && cells[0][1] == Type.X && cells[0][2] == Type.X) ||
                (cells[1][0] == Type.X && cells[1][1] == Type.X && cells[1][2] == Type.X) ||
                (cells[2][0] == Type.X && cells[2][1] == Type.X && cells[2][2] == Type.X) ||
                (cells[0][0] == Type.X && cells[1][0] == Type.X && cells[2][0] == Type.X) ||
                (cells[0][1] == Type.X && cells[1][1] == Type.X && cells[2][1] == Type.X) ||
                (cells[0][2] == Type.X && cells[1][2] == Type.X && cells[2][2] == Type.X) ||
                (cells[0][0] == Type.X && cells[1][1] == Type.X && cells[2][2] == Type.X) ||
                (cells[0][2] == Type.X && cells[1][1] == Type.X && cells[2][0] == Type.X)) {
            return 1;
        }
        if ((cells[0][0] == Type.O && cells[0][1] == Type.O && cells[0][2] == Type.O) ||
                (cells[1][0] == Type.O && cells[1][1] == Type.O && cells[1][2] == Type.O) ||
                (cells[2][0] == Type.O && cells[2][1] == Type.O && cells[2][2] == Type.O) ||
                (cells[0][0] == Type.O && cells[1][0] == Type.O && cells[2][0] == Type.O) ||
                (cells[0][1] == Type.O && cells[1][1] == Type.O && cells[2][1] == Type.O) ||
                (cells[0][2] == Type.O && cells[1][2] == Type.O && cells[2][2] == Type.O) ||
                (cells[0][0] == Type.O && cells[1][1] == Type.O && cells[2][2] == Type.O) ||
                (cells[0][2] == Type.O && cells[1][1] == Type.O && cells[2][0] == Type.O)) {
            return 2;
        }
        if (cells[0][0] != Type.N && cells[0][1] != Type.N && cells[0][2] != Type.N &&
                cells[1][0] != Type.N && cells[1][1] != Type.N && cells[1][2] != Type.N &&
                cells[2][0] != Type.N && cells[2][1] != Type.N && cells[2][2] != Type.N) {
            return 0;
        }
        return 3;
    }

    public void resetField() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells.length; j++) {
                cells[j][i] = Type.N;
            }
        }
    }
}