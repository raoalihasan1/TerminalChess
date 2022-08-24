package chess;
import java.lang.*;

public class Bishop extends Piece{

	public Bishop(PieceColour pc){
		if (pc.equals(PieceColour.WHITE)){
			this.setSymbol("♗");
			this.colour=PieceColour.WHITE;
		}
		else if (pc.equals(PieceColour.BLACK)){
			this.setSymbol("♝");
			this.colour=PieceColour.BLACK;
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

		if(Math.abs(i1 - i0) != Math.abs(j1 - j0)){
			return false;
		}

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
}
