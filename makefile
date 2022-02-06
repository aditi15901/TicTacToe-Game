CM =javac#compiler
CR=java

all: board tictactoe run

tictactoe: 
	$(CM) TicTacToe.java

board: 
	$(CM) Board.java

run: 
	$(CR) TicTacToe

clean:
	rm -rf *.class