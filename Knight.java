package chess;

public class Knight extends Piece{

 	public Knight(PieceColour pc){
		if (pc.equals(PieceColour.WHITE)){
			this.setSymbol("♘");
			this.colour=PieceColour.WHITE;
		}
		else if (pc.equals(PieceColour.BLACK)){
			this.setSymbol("♞");
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
		if((i1 > i0 && i1 - i0 == 1 && (j1 - j0 == 2 || j1 - j0 == -2)) || (i1 < i0 && i0 - i1 == 1 && (j1 - j0 == 2 || j1 - j0 == -2)) ||  (i1 > i0 && i1 - i0 == 2 && (j1 - j0 == 1 || j1 - j0 == -1)) || (i1 < i0 && i0 - i1 == 2 && (j1 - j0 == 1 || j1 - j0 == -1))){
			if(Board.hasPiece(i1, j1)){
				return false;
			} else {
				return true;
			}
		} else {
			return false;
		}
	}
}
