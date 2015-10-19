package view;

import java.awt.BorderLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import model.Game;

public class TextView extends JPanel implements Observer{
	private Game game;
	private JTable table;
	private TableModel model;
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
				return "[" + game.map.getRoom(rowIndex, columnIndex).toString() + "]";
			}
			
		};
		table = new JTable(model);
		add(table, BorderLayout.CENTER);
	}


	@Override
	public void update(Observable o, Object arg) {
		game = (Game) o;
		table.updateUI();
	}

}
