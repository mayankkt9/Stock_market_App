import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import org.json.JSONException;


public class Frame1 {

	private JFrame frame;
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame1 window = new Frame1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Frame1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(500, 500, 1000, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 105, 341, 447);
		frame.getContentPane().add(scrollPane);
		
		
		
		
		
		
		DefaultTableModel modelo=new DefaultTableModel();
		table = new JTable(modelo);
		table.setModel(new DefaultTableModel(
				new Object[][]{
				},
				new String[] {
						"Company","Purchase Price","Current Price"
				}
				
				));
		
		scrollPane.setViewportView(table);
		
		JButton btnAdd = new JButton("ADD");
		
		btnAdd.setBounds(377, 101, 117, 29);
		frame.getContentPane().add(btnAdd);
		
		JLabel lblCompanyName = new JLabel("COMPANY NAME");
		lblCompanyName.setBounds(387, 142, 107, 16);
		frame.getContentPane().add(lblCompanyName);
		
		
		AllStock obj=new AllStock();
		obj.allstocklist();
		JComboBox comboBox =new AutoComboBox(obj.stockname);
		
		
		comboBox.setBounds(377, 170, 117, 29);
		frame.getContentPane().add(comboBox);
		comboBox.setSelectedIndex(0);
		
		JLabel lblPurchasePrice = new JLabel("PURCHASE PRICE");
		lblPurchasePrice.setBounds(552, 142, 117, 16);
		frame.getContentPane().add(lblPurchasePrice);
		
		textField = new JTextField();
		textField.setBounds(552, 170, 134, 28);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		String x = String.valueOf(comboBox.getSelectedItem());
		int y=comboBox.getSelectedIndex();
		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				int index1=comboBox.getSelectedIndex();
				
				int num=table.getModel().getColumnCount();
				Object [] comp=new Object[num];
				comp[0]=String.valueOf(comboBox.getSelectedItem());
				comp[1]=textField.getText();
				MakeUrl getprice=new MakeUrl();
				double currentprice=0;
				try {
					currentprice=getprice.make(index1);
				} catch (IOException | JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				comp[2]=currentprice;
				
				((DefaultTableModel)table.getModel()).addRow(comp);
			}
		});
		
		
		
		
		
		
		
		
		
		
	}
}
