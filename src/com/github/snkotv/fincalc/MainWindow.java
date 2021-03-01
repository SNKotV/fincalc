package com.github.snkotv.fincalc;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.Locale;
import java.awt.event.ActionEvent;

public class MainWindow {

	private JFrame frame;
	private JTextField tfFv;
	private JTextField tfPv;
	private JTextField tfR;
	private JTextField tfN;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
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
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("\u0424\u0438\u043D\u0430\u043D\u0441\u043E\u0432\u044B\u0439 \u043A\u0430\u043B\u044C\u043A\u0443\u043B\u044F\u0442\u043E\u0440");
		frame.setBounds(100, 100, 630, 460);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane);
		
		JTabbedPane simpleInterest = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("\u041F\u0440\u043E\u0441\u0442\u043E\u0439 \u043F\u0440\u043E\u0446\u0435\u043D\u0442", null, simpleInterest, null);
		
		JPanel loanInterest = new JPanel();
		simpleInterest.addTab("\u0421\u0441\u0443\u0434\u043D\u044B\u0439 \u043F\u0440\u043E\u0446\u0435\u043D\u0442 (r)", null, loanInterest, null);
		loanInterest.setBackground(Color.WHITE);
		
		JLabel lblFv = new JLabel("FV =");
		lblFv.setFont(new Font("Tahoma", Font.PLAIN, 28));
		
		tfFv = new JTextField();
		tfFv.setFont(new Font("Tahoma", Font.PLAIN, 28));
		tfFv.setColumns(10);
		
		JLabel lbPv = new JLabel("PV =");
		lbPv.setFont(new Font("Tahoma", Font.PLAIN, 28));
		
		tfPv = new JTextField();
		tfPv.setFont(new Font("Tahoma", Font.PLAIN, 28));
		tfPv.setColumns(10);
		
		JLabel lblR = new JLabel("r   =");
		lblR.setFont(new Font("Tahoma", Font.PLAIN, 28));
		
		tfR = new JTextField();
		tfR.setFont(new Font("Tahoma", Font.PLAIN, 28));
		tfR.setColumns(10);
		
		JLabel lblN = new JLabel("n   =");
		lblN.setFont(new Font("Tahoma", Font.PLAIN, 28));
		
		tfN = new JTextField();
		tfN.setFont(new Font("Tahoma", Font.PLAIN, 28));
		tfN.setColumns(10);
		
		JTextArea txtrPv = new JTextArea();
		txtrPv.setWrapStyleWord(true);
		txtrPv.setLineWrap(true);
		txtrPv.setEditable(false);
		txtrPv.setFont(new Font("Serif", Font.PLAIN, 18));
		txtrPv.setText("PV - \u0441\u043E\u0432\u0440\u0435\u043C\u0435\u043D\u043D\u0430\u044F \u0432\u0435\u043B\u0438\u0447\u0438\u043D\u0430 \u0434\u0435\u043D\u0435\u0433, \u0438\u043B\u0438 \u0432\u0435\u043B\u0438\u0447\u0438\u043D\u0430 \u043F\u0435\u0440\u0432\u043E\u043D\u0430\u0447\u0430\u043B\u044C\u043D\u043E\u0439 \u0434\u0435\u043D\u0435\u0436\u043D\u043E\u0439 \u0441\u0443\u043C\u043C\u044B\r\nFV - \u0431\u0443\u0434\u0443\u0449\u0435\u0435 \u0437\u043D\u0430\u0447\u0435\u043D\u0438\u0435 \u0434\u0435\u043D\u0435\u0433 (\u043D\u0430\u0440\u0430\u0449\u0435\u043D\u043D\u0430\u044F \u0441\u0443\u043C\u043C\u0430)\r\nr - \u0441\u0442\u0430\u0432\u043A\u0430\r\nn - \u043F\u0440\u043E\u0434\u043E\u043B\u0436\u0438\u0442\u0435\u043B\u044C\u043D\u043E\u0441\u0442\u044C \u043F\u0435\u0440\u0438\u043E\u0434\u0430 \u043D\u0430\u0447\u0438\u0441\u043B\u0435\u043D\u0438\u044F \u043F\u0440\u043E\u0446\u0435\u043D\u0442\u0430 \u0432 \u0433\u043E\u0434\u0430\u0445\r\n");
		
		JButton btnCalculate = new JButton("\u0412\u044B\u0447\u0438\u0441\u043B\u0438\u0442\u044C");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int flags[] = new int[4];
				flags[0] = tfFv.getText().equals("") ? 1 : 0;
				flags[1] = tfPv.getText().equals("") ? 1 : 0;
				flags[2] = tfR.getText().equals("") ? 1 : 0;
				flags[3] = tfN.getText().equals("") ? 1 : 0;
				
				int fsum = 0;
				for (int i = 0; i < 4; i++) {
					fsum += flags[i];
				}
				
				if (fsum > 1) {
					JOptionPane.showMessageDialog(null, "\u041D\u0435\u0434\u043E\u0441\u0442\u0430\u0442\u043E\u0447\u043D\u043E \u0434\u0430\u043D\u043D\u044B\u0445 \u0434\u043B\u044F \u043F\u0440\u043E\u0432\u0435\u0434\u0435\u043D\u0438\u044F \u0432\u044B\u0447\u0438\u0441\u043B\u0435\u043D\u0438\u0439", "Error!", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				if (flags[0] == 1) {
					double fv, pv, r, n;
					try {
						pv = Double.parseDouble(tfPv.getText());						
					} catch(Exception exc) {
						JOptionPane.showMessageDialog(null, "\u041F\u043E\u043B\u0435 PV \u0434\u043E\u043B\u0436\u043D\u043E \u0441\u043E\u0434\u0435\u0440\u0436\u0430\u0442\u044C \u0447\u0438\u0441\u043B\u043E", "Error!", JOptionPane.ERROR_MESSAGE);
						return;
					}
					try {
						r = Double.parseDouble(tfR.getText());						
					} catch(Exception exc) {
						JOptionPane.showMessageDialog(null, "\u041F\u043E\u043B\u0435 r \u0434\u043E\u043B\u0436\u043D\u043E \u0441\u043E\u0434\u0435\u0440\u0436\u0430\u0442\u044C \u0447\u0438\u0441\u043B\u043E", "Error!", JOptionPane.ERROR_MESSAGE);
						return;
					}
					try {
						n = Double.parseDouble(tfN.getText());						
					} catch(Exception exc) {
						JOptionPane.showMessageDialog(null, "\u041F\u043E\u043B\u0435 n \u0434\u043E\u043B\u0436\u043D\u043E \u0441\u043E\u0434\u0435\u0440\u0436\u0430\u0442\u044C \u0447\u0438\u0441\u043B\u043E", "Error!", JOptionPane.ERROR_MESSAGE);
						return;
					}
					fv = pv * (1 + r * n);
					tfFv.setText(String.format(Locale.US, "%.4f", fv));
					
				} else if (flags[1] == 1) {
					double fv, pv, r, n;
					try {
						fv = Double.parseDouble(tfFv.getText());						
					} catch(Exception exc) {
						JOptionPane.showMessageDialog(null, "\u041F\u043E\u043B\u0435 FV \u0434\u043E\u043B\u0436\u043D\u043E \u0441\u043E\u0434\u0435\u0440\u0436\u0430\u0442\u044C \u0447\u0438\u0441\u043B\u043E", "Error!", JOptionPane.ERROR_MESSAGE);
						return;
					}
					try {
						r = Double.parseDouble(tfR.getText());						
					} catch(Exception exc) {
						JOptionPane.showMessageDialog(null, "\u041F\u043E\u043B\u0435 r \u0434\u043E\u043B\u0436\u043D\u043E \u0441\u043E\u0434\u0435\u0440\u0436\u0430\u0442\u044C \u0447\u0438\u0441\u043B\u043E", "Error!", JOptionPane.ERROR_MESSAGE);
						return;
					}
					try {
						n = Double.parseDouble(tfN.getText());						
					} catch(Exception exc) {
						JOptionPane.showMessageDialog(null, "\u041F\u043E\u043B\u0435 n \u0434\u043E\u043B\u0436\u043D\u043E \u0441\u043E\u0434\u0435\u0440\u0436\u0430\u0442\u044C \u0447\u0438\u0441\u043B\u043E", "Error!", JOptionPane.ERROR_MESSAGE);
						return;
					}
					pv = fv / (1 + r * n);
					tfPv.setText(String.format(Locale.US, "%.4f", pv));
				} else if (flags[2] == 1) {
					double fv, pv, r, n;
					try {
						fv = Double.parseDouble(tfFv.getText());						
					} catch(Exception exc) {
						JOptionPane.showMessageDialog(null, "\u041F\u043E\u043B\u0435 FV \u0434\u043E\u043B\u0436\u043D\u043E \u0441\u043E\u0434\u0435\u0440\u0436\u0430\u0442\u044C \u0447\u0438\u0441\u043B\u043E", "Error!", JOptionPane.ERROR_MESSAGE);
						return;
					}
					try {
						pv = Double.parseDouble(tfPv.getText());						
					} catch(Exception exc) {
						JOptionPane.showMessageDialog(null, "\u041F\u043E\u043B\u0435 PV \u0434\u043E\u043B\u0436\u043D\u043E \u0441\u043E\u0434\u0435\u0440\u0436\u0430\u0442\u044C \u0447\u0438\u0441\u043B\u043E", "Error!", JOptionPane.ERROR_MESSAGE);
						return;
					}
					try {
						n = Double.parseDouble(tfN.getText());						
					} catch(Exception exc) {
						JOptionPane.showMessageDialog(null, "\u041F\u043E\u043B\u0435 n \u0434\u043E\u043B\u0436\u043D\u043E \u0441\u043E\u0434\u0435\u0440\u0436\u0430\u0442\u044C \u0447\u0438\u0441\u043B\u043E", "Error!", JOptionPane.ERROR_MESSAGE);
						return;
					}
					r = (fv / pv - 1) / n;
					tfR.setText(String.format(Locale.US, "%.4f", r));
				} else {
					double fv, pv, r, n;
					try {
						fv = Double.parseDouble(tfFv.getText());						
					} catch(Exception exc) {
						JOptionPane.showMessageDialog(null, "\u041F\u043E\u043B\u0435 FV \u0434\u043E\u043B\u0436\u043D\u043E \u0441\u043E\u0434\u0435\u0440\u0436\u0430\u0442\u044C \u0447\u0438\u0441\u043B\u043E", "Error!", JOptionPane.ERROR_MESSAGE);
						return;
					}
					try {
						pv = Double.parseDouble(tfPv.getText());						
					} catch(Exception exc) {
						JOptionPane.showMessageDialog(null, "\u041F\u043E\u043B\u0435 PV \u0434\u043E\u043B\u0436\u043D\u043E \u0441\u043E\u0434\u0435\u0440\u0436\u0430\u0442\u044C \u0447\u0438\u0441\u043B\u043E", "Error!", JOptionPane.ERROR_MESSAGE);
						return;
					}
					try {
						r = Double.parseDouble(tfR.getText());						
					} catch(Exception exc) {
						JOptionPane.showMessageDialog(null, "\u041F\u043E\u043B\u0435 r \u0434\u043E\u043B\u0436\u043D\u043E \u0441\u043E\u0434\u0435\u0440\u0436\u0430\u0442\u044C \u0447\u0438\u0441\u043B\u043E", "Error!", JOptionPane.ERROR_MESSAGE);
						return;
					}
					n = (fv / pv - 1) / r;
					tfN.setText(String.format(Locale.US, "%.4f", n));
				}
			}
		});
		btnCalculate.setFont(new Font("Tahoma", Font.PLAIN, 28));
		
		JButton btnClear = new JButton("\u041E\u0447\u0438\u0441\u0442\u0438\u0442\u044C");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfFv.setText("");
				tfPv.setText("");
				tfR.setText("");
				tfN.setText("");
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 28));
		
		JButton btnQuit = new JButton("\u0412\u044B\u0439\u0442\u0438");
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnQuit.setFont(new Font("Tahoma", Font.PLAIN, 28));
		GroupLayout gl_loanInterest = new GroupLayout(loanInterest);
		gl_loanInterest.setHorizontalGroup(
			gl_loanInterest.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_loanInterest.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_loanInterest.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_loanInterest.createSequentialGroup()
							.addComponent(lblFv, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(tfFv, GroupLayout.PREFERRED_SIZE, 262, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_loanInterest.createSequentialGroup()
							.addComponent(lbPv, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfPv, 0, 0, Short.MAX_VALUE))
						.addGroup(gl_loanInterest.createSequentialGroup()
							.addComponent(lblR, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfR, 0, 0, Short.MAX_VALUE))
						.addGroup(gl_loanInterest.createSequentialGroup()
							.addComponent(lblN, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfN, 0, 0, Short.MAX_VALUE))
						.addGroup(gl_loanInterest.createSequentialGroup()
							.addComponent(btnCalculate)
							.addGap(18)
							.addComponent(btnClear, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_loanInterest.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_loanInterest.createSequentialGroup()
							.addGap(18)
							.addComponent(txtrPv, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)
							.addGap(18))
						.addGroup(Alignment.TRAILING, gl_loanInterest.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnQuit, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
							.addGap(26))))
		);
		gl_loanInterest.setVerticalGroup(
			gl_loanInterest.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_loanInterest.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_loanInterest.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_loanInterest.createSequentialGroup()
							.addGroup(gl_loanInterest.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblFv, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
								.addComponent(tfFv, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_loanInterest.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_loanInterest.createSequentialGroup()
									.addGap(19)
									.addComponent(lbPv, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_loanInterest.createSequentialGroup()
									.addGap(18)
									.addComponent(tfPv, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)))
							.addGroup(gl_loanInterest.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_loanInterest.createSequentialGroup()
									.addGap(19)
									.addComponent(lblR, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_loanInterest.createSequentialGroup()
									.addGap(18)
									.addComponent(tfR, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)))
							.addGroup(gl_loanInterest.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_loanInterest.createSequentialGroup()
									.addGap(19)
									.addComponent(lblN, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_loanInterest.createSequentialGroup()
									.addGap(18)
									.addComponent(tfN, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))))
						.addComponent(txtrPv, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
					.addGroup(gl_loanInterest.createParallelGroup(Alignment.LEADING)
						.addComponent(btnCalculate, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
						.addGroup(gl_loanInterest.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnClear, GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
							.addComponent(btnQuit, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)))
					.addContainerGap())
		);
		loanInterest.setLayout(gl_loanInterest);
		
		JPanel discountPercentage = new JPanel();
		discountPercentage.setBackground(Color.WHITE);
		simpleInterest.addTab("\u0423\u0447\u0435\u0442\u043D\u044B\u0439 \u043F\u0440\u043E\u0446\u0435\u043D\u0442 (d)", null, discountPercentage, null);
		
		JLabel label = new JLabel("FV =");
		label.setFont(new Font("Tahoma", Font.PLAIN, 28));
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 28));
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("PV =");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 28));
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 28));
		textField_1.setColumns(10);
		
		JLabel lblD = new JLabel("d   =");
		lblD.setFont(new Font("Tahoma", Font.PLAIN, 28));
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 28));
		textField_2.setColumns(10);
		
		JLabel label_3 = new JLabel("n   =");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 28));
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 28));
		textField_3.setColumns(10);
		
		JButton button = new JButton("\u0412\u044B\u0447\u0438\u0441\u043B\u0438\u0442\u044C");
		button.setFont(new Font("Tahoma", Font.PLAIN, 28));
		
		JButton button_1 = new JButton("\u041E\u0447\u0438\u0441\u0442\u0438\u0442\u044C");
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 28));
		
		JTextArea textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setText("PV - \u0441\u043E\u0432\u0440\u0435\u043C\u0435\u043D\u043D\u0430\u044F \u0432\u0435\u043B\u0438\u0447\u0438\u043D\u0430 \u0434\u0435\u043D\u0435\u0433, \u0438\u043B\u0438 \u0432\u0435\u043B\u0438\u0447\u0438\u043D\u0430 \u043F\u0435\u0440\u0432\u043E\u043D\u0430\u0447\u0430\u043B\u044C\u043D\u043E\u0439 \u0434\u0435\u043D\u0435\u0436\u043D\u043E\u0439 \u0441\u0443\u043C\u043C\u044B\r\nFV - \u0431\u0443\u0434\u0443\u0449\u0435\u0435 \u0437\u043D\u0430\u0447\u0435\u043D\u0438\u0435 \u0434\u0435\u043D\u0435\u0433 (\u043D\u0430\u0440\u0430\u0449\u0435\u043D\u043D\u0430\u044F \u0441\u0443\u043C\u043C\u0430)\r\nr - \u0441\u0442\u0430\u0432\u043A\u0430\r\nn - \u043F\u0440\u043E\u0434\u043E\u043B\u0436\u0438\u0442\u0435\u043B\u044C\u043D\u043E\u0441\u0442\u044C \u043F\u0435\u0440\u0438\u043E\u0434\u0430 \u043D\u0430\u0447\u0438\u0441\u043B\u0435\u043D\u0438\u044F \u043F\u0440\u043E\u0446\u0435\u043D\u0442\u0430 \u0432 \u0433\u043E\u0434\u0430\u0445\r\n");
		textArea.setLineWrap(true);
		textArea.setFont(new Font("Serif", Font.PLAIN, 18));
		textArea.setEditable(false);
		
		JButton button_2 = new JButton("\u0412\u044B\u0439\u0442\u0438");
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 28));
		GroupLayout gl_discountPercentage = new GroupLayout(discountPercentage);
		gl_discountPercentage.setHorizontalGroup(
			gl_discountPercentage.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_discountPercentage.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_discountPercentage.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_discountPercentage.createSequentialGroup()
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 262, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_discountPercentage.createSequentialGroup()
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_1, 0, 0, Short.MAX_VALUE))
						.addGroup(gl_discountPercentage.createSequentialGroup()
							.addComponent(lblD, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_2, 0, 0, Short.MAX_VALUE))
						.addGroup(gl_discountPercentage.createSequentialGroup()
							.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_3, 0, 0, Short.MAX_VALUE))
						.addGroup(gl_discountPercentage.createSequentialGroup()
							.addComponent(button)
							.addGap(18)
							.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_discountPercentage.createParallelGroup(Alignment.TRAILING)
						.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
					.addGap(21))
		);
		gl_discountPercentage.setVerticalGroup(
			gl_discountPercentage.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_discountPercentage.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_discountPercentage.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_discountPercentage.createSequentialGroup()
							.addGroup(gl_discountPercentage.createParallelGroup(Alignment.BASELINE)
								.addComponent(label, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_discountPercentage.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_discountPercentage.createSequentialGroup()
									.addGap(19)
									.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_discountPercentage.createSequentialGroup()
									.addGap(18)
									.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)))
							.addGroup(gl_discountPercentage.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_discountPercentage.createSequentialGroup()
									.addGap(19)
									.addComponent(lblD, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_discountPercentage.createSequentialGroup()
									.addGap(18)
									.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)))
							.addGroup(gl_discountPercentage.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_discountPercentage.createSequentialGroup()
									.addGap(19)
									.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_discountPercentage.createSequentialGroup()
									.addGap(18)
									.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))))
						.addComponent(textArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_discountPercentage.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_discountPercentage.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
							.addGroup(gl_discountPercentage.createParallelGroup(Alignment.BASELINE)
								.addComponent(button_1, GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
								.addComponent(button_2, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)))
						.addGroup(gl_discountPercentage.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
							.addGap(1)))
					.addGap(12))
		);
		discountPercentage.setLayout(gl_discountPercentage);
		
		JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("\u0421\u043B\u043E\u0436\u043D\u044B\u0439 \u043F\u0440\u043E\u0446\u0435\u043D\u0442", null, tabbedPane_2, null);
	}
}
