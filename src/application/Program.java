package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();
        while (true) {
            try {
                UI.clearScreen();
                UI.printBoard(chessMatch.getPieces()); // Assuming UI is a class that has a method to print the board
                System.out.println();
                System.out.println("Source: ");
                ChessPosition source = UI.readChessPosition(sc);

                boolean[][] possibleMoves = chessMatch.possibleMoves(source);
                UI.clearScreen();
                UI.printBoard(chessMatch.getPieces(), possibleMoves); // Assuming this method prints the board with possible moves highlighted

                System.out.println();
                System.out.println("Target: ");
                ChessPosition target = UI.readChessPosition(sc);

                ChessPiece capturedPiece = chessMatch.performChessMov(source, target);
            } catch (ChessException e) {
                System.out.println(e.getMessage());
                sc.nextLine(); // Clear the buffer
            }catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                sc.nextLine(); // Clear the buffer
            }
        }
    }
}
