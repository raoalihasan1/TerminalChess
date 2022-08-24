package chess;
import java.lang.*;

public class Pawn extends Piece{

	public Pawn(PieceColour pc){
		if (pc.equals(PieceColour.WHITE)){
			this.setSymbol("♙");
			this.colour=PieceColour.WHITE;
		}
		else if (pc.equals(PieceColour.BLACK)){
			this.setSymbol("♟");
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

		if(Board.hasPiece(i1, j1) && Board.getPiece(i1, j1).getColour()==this.colour){
			return false;
		}
		else if(i1 < i0 && this.colour == PieceColour.BLACK){
			return false;
		}
		else if(i1 > i0 && this.colour == PieceColour.WHITE){
			return false;
		}
		else {
			if(j0 == j1){
				if((i1 == (i0 + 1) && this.colour == PieceColour.BLACK) || (i1 == (i0 - 1) && this.colour==PieceColour.WHITE)){
					if(!Board.hasPiece(i1, j1)){
						return true;
					}
				}
				else if((i1 == (i0 + 2) && this.colour == PieceColour.BLACK) || (i1 == (i0 - 2) && this.colour==PieceColour.WHITE)){
					if((!Board.hasPiece(i0+1, j1) && !Board.hasPiece(i1, j1) && i0 == 1 && this.colour==PieceColour.BLACK) || (!Board.hasPiece(i0-1, j1) && !Board.hasPiece(i1, j1) && i0 == 6 &&  this.colour==PieceColour.WHITE)){
						return true;
					}
				}
				return false;
			}
			else if((j1 == (j0 - 1) || j1 == (j0+1)) && (i1 == (i0+1) || i1 == (i0-1))){
				if(Board.hasPiece(i1, j1) && !(Board.getPiece(i1, j1).getColour()==this.colour)){
					return true;
				}
				return false;
			}
		}
		return false;
	}
}
