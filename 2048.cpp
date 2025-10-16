#include <iostream>
#include <cstdlib>
#include <ctime>
#include <iomanip>
#include <conio.h> // for getch() on Windows

using namespace std;

const int SIZE = 4;
int grid[SIZE][SIZE];

// Initialize grid
void initGrid() {
    for (int i = 0; i < SIZE; i++)
        for (int j = 0; j < SIZE; j++)
            grid[i][j] = 0;
}

// Add random tile (2 or 4)
void addRandomTile() {
    int empty[SIZE * SIZE][2];
    int count = 0;
    for (int i = 0; i < SIZE; i++)
        for (int j = 0; j < SIZE; j++)
            if (grid[i][j] == 0) {
                empty[count][0] = i;
                empty[count][1] = j;
                count++;
            }
    if (count > 0) {
        int r = rand() % count;
        grid[empty[r][0]][empty[r][1]] = (rand() % 2 + 1) * 2;
    }
}

// Print grid
void printGrid() {
    cout << "\n";
    for (int i = 0; i < SIZE; i++) {
        for (int j = 0; j < SIZE; j++) {
            if (grid[i][j] == 0)
                cout << setw(5) << ".";
            else
                cout << setw(5) << grid[i][j];
        }
        cout << "\n\n";
    }
}

// Slide left
bool slideLeft() {
    bool moved = false;
    for (int i = 0; i < SIZE; i++) {
        int temp[SIZE] = {0};
        int idx = 0;
        for (int j = 0; j < SIZE; j++) {
            if (grid[i][j] != 0) {
                if (temp[idx] == 0) {
                    temp[idx] = grid[i][j];
                } else if (temp[idx] == grid[i][j]) {
                    temp[idx++] *= 2;
                    moved = true;
                } else {
                    temp[++idx] = grid[i][j];
                }
                if (j != idx) moved = true;
            }
        }
        for (int j = 0; j < SIZE; j++)
            grid[i][j] = temp[j];
    }
    return moved;
}

// Rotate grid 90° clockwise
void rotateGrid() {
    int temp[SIZE][SIZE];
    for (int i = 0; i < SIZE; i++)
        for (int j = 0; j < SIZE; j++)
            temp[j][SIZE - 1 - i] = grid[i][j];
    for (int i = 0; i < SIZE; i++)
        for (int j = 0; j < SIZE; j++)
            grid[i][j] = temp[i][j];
}

// Move tiles based on arrow key
bool move(int key) {
    bool moved = false;
    switch(key) {
        case 72: // up arrow
            rotateGrid(); rotateGrid(); rotateGrid();
            moved = slideLeft();
            rotateGrid();
            break;
        case 80: // down arrow
            rotateGrid();
            moved = slideLeft();
            rotateGrid(); rotateGrid(); rotateGrid();
            break;
        case 75: // left arrow
            moved = slideLeft();
            break;
        case 77: // right arrow
            rotateGrid(); rotateGrid();
            moved = slideLeft();
            rotateGrid(); rotateGrid();
            break;
    }
    return moved;
}

// Check if game is over
bool gameOver() {
    for (int i = 0; i < SIZE; i++)
        for (int j = 0; j < SIZE; j++)
            if (grid[i][j] == 0) return false;

    for (int i = 0; i < SIZE; i++)
        for (int j = 0; j < SIZE-1; j++)
            if (grid[i][j] == grid[i][j+1]) return false;

    for (int j = 0; j < SIZE; j++)
        for (int i = 0; i < SIZE-1; i++)
            if (grid[i][j] == grid[i+1][j]) return false;

    return true;
}

int main() {
    srand(time(0));
    initGrid();
    addRandomTile();
    addRandomTile();
    printGrid();

    while (true) {
        cout << "Use arrow keys to move tiles.\n";
        int ch = _getch(); // first input
        if (ch == 224) {   // arrow keys are detected in 2 steps
            int arrow = _getch(); // second input gives actual key code
            if (move(arrow)) {
                addRandomTile();
                printGrid();
            } else {
                cout << "Invalid move or no tiles moved.\n";
            }
        }

        if (gameOver()) {
            cout << "Game Over!\n";
            break;
        }
    }

    return 0;
}
