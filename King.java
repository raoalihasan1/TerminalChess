package chess;
import java.lang.*;
public class King extends Piece{

	public King(PieceColour pc){
		if (pc.equals(PieceColour.WHITE)){
			this.setSymbol("♔");
			this.colour=PieceColour.WHITE;
		}
		else if (pc.equals(PieceColour.BLACK)){
			this.setSymbol("♚");
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

		if(i0 == i1 && j1 != j0){
			if(j1 == (j0+1) || j1 == (j0-1)){
				if(Board.hasPiece(i1, j1) && Board.getPiece(i1, j1).getColour()==this.colour){
					return false;
				}
				else {
					return true;
				}
			}
			else {
				return false;
			}
		}
		else if(j0 == j1 && i1 != i0){
			if(i1 == (i0+1) || i1 == (i0-1)){
				if(Board.hasPiece(i1, j1) && Board.getPiece(i1, j1).getColour()==this.colour){
					return false;
				}
				else {
					return true;
				}
			}
			else {
				return false;
			}
		}
		else if((Math.abs(i1 - i0) == 1 && Math.abs(j1 - j0) == 1)){
			if(Board.hasPiece(i1, j1) && Board.getPiece(i1, j1).getColour()==this.colour){
				return false;
			}
			else {
				return true;
			}
		}
		else {
			return false;
		}

	}
}
