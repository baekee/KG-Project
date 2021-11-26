
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class RSP_Ranking extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	String[] Rank = {"사칙연산", "가위바위보"};
	ArrayList <RSP> arr2 = new <RSP>ArrayList();
	int i;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RSP_Ranking frame = new RSP_Ranking();
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
	public RSP_Ranking() {
		setTitle("랭킹 확인 창");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 838, 537);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(RSP_Ranking.class.getResource("/images/HomeButton_mini.png")));
		btnNewButton.addMouseListener(new MouseAdapter() {	//Home Button click event
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				setVisible(false);
			}
		});
		btnNewButton.setBounds(12, 10, 100, 40);
		contentPane.add(btnNewButton);
		
		JComboBox comboBox = new JComboBox(Rank);	// combo box
		comboBox.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 15));
		comboBox.setSelectedIndex(1);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JComboBox cb =(JComboBox)arg0.getSource(); 	//콤보박스 알아내기
				int index = cb.getSelectedIndex();		// 선택된 아이템의 인덱스
				if(index ==0) {				
					dispose();
					setVisible(false);
					new Plus_Ranking().setVisible(true);
				}
				else {
					dispose();
					setVisible(false);
					new RSP_Ranking().setVisible(true);
				}
			}
		});
		
		comboBox.setBounds(12, 72, 123, 23);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("가위바위보 명예의 전당");	//명예의 전당
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(481, 88, 248, 48);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("<");
		btnNewButton_1.setIcon(new ImageIcon(RSP_Ranking.class.getResource("/images/Prev_mini.png")));
		btnNewButton_1.setBounds(163, 359, 41, 33);
		contentPane.add(btnNewButton_1);
		
		JButton button = new JButton("1");
		button.setIcon(new ImageIcon(RSP_Ranking.class.getResource("/images/1Button.png")));
		button.setBounds(216, 359, 41, 33);
		contentPane.add(button);
		
		JButton button_1 = new JButton("2");
		button_1.setIcon(new ImageIcon(RSP_Ranking.class.getResource("/images/2Button.png")));
		button_1.setBounds(267, 359, 41, 33);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("3");
		button_2.setIcon(new ImageIcon(RSP_Ranking.class.getResource("/images/3Button.png")));
		button_2.setBounds(319, 359, 41, 33);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton(">");
		button_3.setIcon(new ImageIcon(RSP_Ranking.class.getResource("/images/Next_mini.png")));
		button_3.setBounds(372, 359, 41, 33);
		contentPane.add(button_3);
		
		
		System.out.println(arr2.add(new RSP(NicknameCreate2.bb,RSP_Game.bb)));
		
		
		JTextArea textArea = new JTextArea("  " + arr2.toString().replace("[", "").replace("]", "").replace(",", ""));	// 유저 목록
		textArea.setFont(new Font("한컴 말랑말랑 Bold", Font.BOLD, 15));
		textArea.setBounds(193, 113, 196, 242);
		contentPane.add(textArea);
		textArea.setEditable(false);
		
		textField = new JTextField(arr2.toString().replace("[", "").replace("]", "").replace(",", ""));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("한컴 말랑말랑 Bold", Font.BOLD, 12));
		textField.setBounds(534, 146, 116, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setEditable(false);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(534, 178, 116, 21);
		contentPane.add(textField_1);
		textField_1.setEditable(false);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(534, 209, 116, 21);
		contentPane.add(textField_2);
		textField_2.setEditable(false);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(534, 240, 116, 21);
		contentPane.add(textField_3);
		textField_3.setEditable(false);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(534, 275, 116, 21);
		contentPane.add(textField_4);
		textField_4.setEditable(false);
		
		textField_5 = new JTextField();
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 15));
		textField_5.setText("\uB2C9\uB124\uC784 \uAC80\uC0C9");
		textField_5.setBounds(193, 86, 196, 23);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(RSP_Ranking.class.getResource("/images/rankBg.png")));
		lblNewLabel_1.setBounds(0, 0, 822, 498);
		contentPane.add(lblNewLabel_1);
	}
}
