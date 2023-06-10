

import enum


import re


BOARD_SIZE = 3


def printBoard():
    board = [[' ' for x in range(BOARD_SIZE)] for x in range(BOARD_SIZE) ]
    print('    ', end='')
    for i in range(BOARD_SIZE):
        print(i, end='    ')
    print()
    for i, row in enumerate(board):
        print(i, row)



def main():
    
    while True:
        printBoard()
        col, row = input('inserisci colonna e riga: ').split()
        print(col, row)
        



if  __name__ == '__main__':
    main()



    
