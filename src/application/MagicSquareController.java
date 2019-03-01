package application;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import model.*;
import customExceptions.*;

public class MagicSquareController {
	
	@FXML private Label lblNumber;
	@FXML private TextField txtLevel;
	@FXML private TextField txtStart;
	@FXML private TextField txtTrack;
	@FXML private GridPane theMatrix;
	@FXML private VBox theVB;
	
	private int level;
	private int row;
	private int column;
	private String track;
	
	private int[][] mm;
	
	private MagicSquare mySq;
	
	public void create() {
		
		try {
			
			GridPane magicMatrix = new GridPane();
			theMatrix.add(magicMatrix, 0, 1);
			magicMatrix.setAlignment(Pos.CENTER);
			magicMatrix.setGridLinesVisible(false);
			magicMatrix.setVgap(8);
			magicMatrix.setHgap(12);
			
			level = mySq.selectLevel(txtLevel.getText());
			row = mySq.calcRow(txtStart.getText(), level);
			column = mySq.calcColumn(txtStart.getText(), level);
			track = mySq.setTrack(txtTrack.getText());
			
			int cont = 1;
			
			String mn = Integer.toString(mySq.calculateMagicNumber(level));
			lblNumber.setText("The magic number is: " + mn);
			mm = new int[level][level];
			
			//process
			if(track.equalsIgnoreCase("ne")) {
				
				for(int num=1; num <= (level*level); num++) {
					
					magicMatrix.add(new Label(Integer.toString(num)), column, row);
					mm[row][column] = num;
					
					if(cont == level && row != level-1) {
						
						cont = 1;
						
						row++;
						
					}else if(cont == level && row == level-1) {
						
						cont = 1;
						
						row = 0;
						
					}else {
						
						if(row != 0 && column != level-1) {
							
							row--;
							column++;
							cont++;
							
						}else if(row == 0 && column != level-1) {
							
							row = level-1;
							column++;
							cont++;
							
						}else if(row != 0 && column == level-1) {
							
							row--;
							column = 0;
							cont++;
							
						}else if(row == 0 && column == level-1) {
							
							row = level-1;
							column = 0;
							cont++;
							
						}
						
					}
					
				}
				
			}else if(track.equalsIgnoreCase("nw")) {
				
				for(int num=1; num <= (level*level); num++) {
					
					magicMatrix.add(new Label(Integer.toString(num)), column, row);
					mm[row][column] = num;
					
					if(cont == level && row != level-1) {
						
						cont = 1;
						
						row++;
						
					}else if(cont == level && row == level-1) {
						
						cont = 1;
						
						row = 0;
						
					}else {
						
						if(row != 0 && column != 0) {
							
							row--;
							column--;
							cont++;
							
						}else if(row == 0 && column != 0) {
							
							row = level-1;
							column--;
							cont++;
							
						}else if(row != 0 && column == 0) {
							
							row--;
							column = level-1;
							cont++;
							
						}else if(row == 0 && column == 0) {
							
							row = level-1;
							column = level-1;
							cont++;
							
						}
						
					}
					
				}
				
			}
			
			if (mySq.calcMagic(mm, Integer.parseInt(mn)) == true) {
				
				System.out.println("magico");
				
				theVB.getChildren().add(new Label("this is a magic square!!"));
				
			}else {
				
				System.out.println("no magico");
				
				theVB.getChildren().add(new Label("this is not a magic square :("));
				
			}
			
		}catch(NonOddLevelException nonOdd) {
			
			System.out.println("the introduced level "+ txtLevel.getText() +" is not an odd number");
			System.out.println(nonOdd.getMessage());
			
		}catch(NonValidTrackException nonValid) {
			
			System.out.println("the introduced track "+ txtLevel.getText() +" is not a supported option");
			System.out.println(nonValid.getMessage());
			
		}catch(IllegalArgumentException ex) {
			System.out.println("you did something stupid and managed to break the program! try  again");
			System.out.println(ex.getMessage());
			
		}catch(IndexOutOfBoundsException outBound) {
			
			System.out.println("Sorry, something went wrong");
			System.out.println(outBound.getMessage());
			
		}
		
	}
	
	public void initialize() {
		
		mySq = new MagicSquare();
		
	}
	
}
