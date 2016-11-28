package CSC110.monopoly.Game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import CSC110.monopoly.Input.AskForInput;
import CSC110.monopoly.board.GameBoard;
import CSC110.monopoly.player.Piece;
import CSC110.monopoly.player.PieceName;
import CSC110.monopoly.player.Player;

public class Game {

	private Player[] players = new Player[0];
	private GameBoard gameBoard;
	
	public Player[] GetPlayers(){
		return players;
	}
	
	public void Play() throws IOException{
		while(!isGameOver()){
			for(int i = 0; i < players.length; i++){
				players[i].TakeTurn();
			}
		}
	}
	
	private boolean isGameOver(){
		boolean onePlayerLeft = false;
		for(int i = 0; i < players.length; i++){
			if(!players[i].IsBankrupt()){
				if(onePlayerLeft){
					return false;
				}else{
					onePlayerLeft = true;
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		System.out.println("Welcome to Monopoly!");
		do{
			_NewGame().Play();
		}while(_askToReplay());
	}
	
	public static Game _NewGame() throws IOException{
		Game gm = new Game();
		gm.gameBoard = GameBoard._NewGameBoard(gm);
		gm.players = _initializePlayers(gm.gameBoard);
		return gm;
	}
	
	private static ArrayList<PieceName> piecesTaken = new ArrayList<PieceName>();
	private static Player[] _initializePlayers(GameBoard board) throws IOException{
		int count = AskForInput.numOfPlayers();
		Player[] plas = new Player[count];
		for(int i = 0; i < plas.length; i++){
			PieceName pn = AskForInput._EnumInput(piecesTaken);
			piecesTaken.add(pn);
			plas[i] = Piece._PlayerInit(pn, board);
		}
		piecesTaken.clear();
		return plas;
	}
	
	public static int _DiceRoll () {
		return (new Random().nextInt(6)+1);
	}
	
	private static boolean _askToReplay () throws IOException {
		boolean userInput = AskForInput.boolInput("Would you like to play again?","Y","N");
		
		if (userInput){
			System.out.println("A new game has been made!");
		}else {
			System.out.println("Thanks for playing!");
		}
		
		return userInput;
	}
	
	public static void _Stall() throws IOException{
		System.out.println("\n[Hit Enter to Continue]\n");
		new BufferedReader(new InputStreamReader(System.in)).readLine();
	}

	public void RemovePlayer(Piece piece) {
		Player[] plas = new Player[players.length-1];
		boolean hitPiece = false;
		for(int i = 0; i < players.length; i++){
			int index = (hitPiece)? i-1 : i;
			if(players[i] == piece){
				hitPiece = true;
			}else{
				plas[index] = players[i];
			}
		}
		
		players = plas;
	}
}
