import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Principale extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	private JTextField txt1;
	private JTextField txt2;
	private JTextField txt3;
	private JLabel lbl1;
	private JLabel lbl2;
	private JLabel lbl3;
	private JButton btnNewButton_1;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principale frame = new Principale();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principale() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 728, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		String[]  cols = {"col1", "col2","col3"};
		String[][] rows = {{"1","2","3"},{"1","2","3"},{"1","2","3"}};
		DefaultTableModel model = new DefaultTableModel(rows, cols) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 54, 678, 240);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(model);
		
		
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
		
				int row = table.getSelectedRow();
				
				if(row != -1) {
					lbl1.setText(table.getModel().getValueAt(row, 0).toString());
					lbl2.setText(table.getModel().getValueAt(row, 1).toString());
					lbl3.setText(table.getModel().getValueAt(row, 2).toString());
				}
				
			}
		});
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setHgap(30);
		panel.setBounds(5, 5, 678, 38);
		contentPane.add(panel);
		
		txt1 = new JTextField();
		panel.add(txt1);
		txt1.setColumns(10);
		
		txt2 = new JTextField();
		panel.add(txt2);
		txt2.setColumns(10);
		
		txt3 = new JTextField();
		panel.add(txt3);
		txt3.setColumns(10);
		
		JButton btnNewButton = new JButton("Ajouter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] newRow= {txt1.getText(),txt2.getText(),txt3.getText()};
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				model.addRow(newRow);
			}
		});
		panel.add(btnNewButton);
		
		lbl1 = new JLabel("New label");
		lbl1.setBounds(10, 319, 167, 14);
		contentPane.add(lbl1);
		
		lbl2 = new JLabel("New label");
		lbl2.setBounds(187, 319, 167, 14);
		contentPane.add(lbl2);
		
		lbl3 = new JLabel("New label");
		lbl3.setBounds(364, 319, 167, 14);
		contentPane.add(lbl3);
		
		btnNewButton_1 = new JButton("Supprimer");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int row = table.getSelectedRow();
				
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				
				model.removeRow(row);
			}
		});
		btnNewButton_1.setBounds(594, 359, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
