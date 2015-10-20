package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import model.Game;
//Alex Yee
public class TextView extends JPanel implements Observer{
	private Game game;
	private JTable table;
	private TableModel model;
	private JTextArea jta;
	public TextView(Game game) {
		this.game = game;
		
	
		model = new AbstractTableModel(){

			@Override
			public int getRowCount() {

				return 10;
			}

			@Override
			public int getColumnCount() {
				return 10;
			}

			@Override
			public Object getValueAt(int rowIndex, int columnIndex) {
				if (!game.getStatus()){
					return "[" + game.map.getRoom(rowIndex, columnIndex).toStringWhenDone() + "]";
				}
				return "[" + game.map.getRoom(rowIndex, columnIndex).toString() + "]";
			}
			
		};
		table = new JTable(model);
		add(table, BorderLayout.CENTER);
		jta = new JTextArea();
		add(jta, BorderLayout.SOUTH);
	}


	@Override
	public void update(Observable o, Object arg) {
		game = (Game) o;
		table.updateUI();
		jta.setText(game.getMessage());
		
	}
	

}
