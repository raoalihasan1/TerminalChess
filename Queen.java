package chess;
import java.lang.*;

public class Queen extends Piece{

	public Queen(PieceColour pc){
		if (pc.equals(PieceColour.WHITE)){
			this.colour=PieceColour.WHITE;
			this.setSymbol("♕");
		}
		else if (pc.equals(PieceColour.BLACK)){
			this.colour=PieceColour.BLACK;
			this.setSymbol("♛");
		}
	}

	public String getSymbol(){
		return super.getSymbol();
	}

	public PieceColour getColour(){
		return super.getColour();
	}

	@Override
	public boolean isLegitMove(int i0, int j0, int i1, int j1) {

		int y = j0;

		if(Board.hasPiece(i1, j1) && Board.getPiece(i1, j1).getColour()==this.colour){
			return false;
		}

		if(i0 == i1 && j0 != j1){
			if(j0 > j1){
				for(int i = (j0-1); i > j1; i--){
					if(Board.hasPiece(i1, i)){
						return false;
					}
				}
			}
			else if(j0 < j1){
				for(int i = (j0+1); i < j1; i++){
					if(Board.hasPiece(i1, i)){
						return false;
					}
				}
			}
			return true;
		}
		else if(j0 == j1 && i0 != i1){
			if(i0 > i1){
				for(int i = (i0-1); i > i1; i--){
					if(Board.hasPiece(i, j1)){
						return false;
					}
				}
			}
			else if(i0 < i1){
				for(int i = (i0+1); i < i1; i++){
					if(Board.hasPiece(i, j1)){
						return false;
					}
				}
			}
			return true;
		}
		else if(Math.abs(i1-i0) == Math.abs(j1-j0)){
			if(i0 > i1 && j0 > j1){
				y--;
				for(int i = (i0-1); i > i1; i--){
					if(Board.hasPiece(i, y)){
						return false;
					}
					y--;
				}
			}
			else if(i0 > i1 && j0 < j1){
				y++;
				for(int i = (i0-1); i > i1; i--){
					if(Board.hasPiece(i, y)){
						return false;
					}
					y++;
				}
			}
			else if(i0 < i1 && j0 > j1){
				y--;
				for(int i = (i0+1); i < i1; i++){
					if(Board.hasPiece(i, y)){
						return false;
					}
					y--;
				}
			}
			else if(i0 < i1 && j0 < j1){
				y++;
				for(int i = (i0+1); i < i1; i++){
					if(Board.hasPiece(i, y)){
						return false;
					}
					y++;
				}
			}
			else {
				return false;
			}
			return true;
		}
		return false;
	}
}
