package Client;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MainUI {

	// êîìïîíåíòû èíòåðôåéñà
	ArrayList<StructureOfProductDB> productDBArray = new ArrayList<StructureOfProductDB>();
	ServerPullPusher serverPullPusher;
	String searchText;
	public Boolean visible = true;
	JFrame frame; // ôðåéì
	JButton groupsManagementButton; // êíîïêà îòêðûâàåò ìåíþ äîáàâëåíèÿ/óäàëåíèÿ
									// è ðåäàêòèðîâàíèÿ ãðóïï
	JButton goodsManagementButton; // êíîïêà îòêðûâàåò ìåíþ ïîñòóïëåíèÿ/ñïèñàíèÿ
									// è ðåäàêòèðîâàíèÿ òîâàðîâ
	JButton statisticsWindowButton; // êíîïêà îòêðûâàåò ìåíþ ñòàòèñòèêè
	JTextField searchFormTextField; // ôîðìà ïîèñêà òîâàðîâ
	JButton changesConfirmationButton; // êíîïêà ïîäòâåðæäàþùàÿ èçìåíåíèÿ â
										// òàáëèöå
	JList<?> groupsList; // ñïèñîê ãðóïï òîâàðîâ
	JLabel currentGroupLabel; // íàäïèñü îòîáðàæàåò òåêóùóþ âûáðàíóþ ãðóïïó
	JLabel totalLabel; // íàäïèñü "Çàãàëîì:" âíèçó ôîðìû
	JTable goodsOfGroupTable; // öåíòðàëüíàÿ òàáëèöà ñî ñïèñêîì òîâàðîâ ãðóïïû
	JTextField totalPriceTextField; // ôîðìà îòîáðàæåíèÿ ñóììàðíîé öåíû òîâàðîâ
									// ãðóïïû
	JTextField totalQuantityTextField; // ôîðìà îòîáðàæåíèÿ ñóììàðíîãî
										// êîëè÷åñòâà òîâàðîâ ãðóïïû

	MainUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		frame = new JFrame("Ñèñòåìà óïðàâë³ííÿ ñêëàäîì");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridBagLayout());

		componentsInitialization();// îïèñûâàåì êîìïîíåíòû
		componentsPlacing();// ðàçìåùàåì êîìïîíåíòû

		frame.setSize(1000, 600);
		// frame.pack();
		frame.setVisible(visible);
	}

	private void componentsPlacing() {

		// ðÿä 1

		// êíîïêà îòêðûâàåò ìåíþ äîáàâëåíèÿ/óäàëåíèÿ è ðåäàêòèðîâàíèÿ ãðóïï
		frame.add(groupsManagementButton, new GridBagConstraints(0, 0, 1, 1, 1,
				1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
				new Insets(2, 2, 2, 2), 0, 0));

		// êíîïêà îòêðûâàåò ìåíþ ïîñòóïëåíèÿ/ñïèñàíèÿ è ðåäàêòèðîâàíèÿ òîâàðîâ
		frame.add(goodsManagementButton, new GridBagConstraints(1, 0, 1, 1, 1,
				1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
				new Insets(2, 2, 2, 2), 0, 0));

		// êíîïêà îòêðûâàåò ìåíþ ñòàòèñòèêè
		frame.add(statisticsWindowButton, new GridBagConstraints(2, 0, 1, 1, 1,
				1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
				new Insets(2, 2, 2, 2), 0, 0));

		// ôîðìà ïîèñêà òîâàðîâ
		frame.add(searchFormTextField, new GridBagConstraints(3, 0, 1, 1, 1, 1,
				GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
				new Insets(5, 2, 2, 2), 0, 0));
		// êíîïêà ïîäòâåðæäàþùàÿ èçìåíåíèÿ â òàáëèöå
		frame.add(changesConfirmationButton, new GridBagConstraints(4, 0, 1, 1,
				1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
				new Insets(2, 2, 5, 2), 0, 0));

		// ðÿä 2

		// íàäïèñü îòîáðàæàåò òåêóùóþ âûáðàíóþ ãðóïïó
		frame.add(currentGroupLabel, new GridBagConstraints(0, 1, 1, 4, 1, 1,
				GridBagConstraints.NORTH, GridBagConstraints.CENTER,
				new Insets(2, 2, 2, 2), 0, 0));

		// ðÿä 3

		// ???????

		// ðÿä 4

		// ñïèñîê ãðóïï òîâàðîâ
		frame.add(groupsList, new GridBagConstraints(0, 4, 1, 11, 1, 1,
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(2, 2, 2, 2), 0, 0));

		// öåíòðàëüíàÿ òàáëèöà ñî ñïèñêîì òîâàðîâ ãðóïïû
		frame.add(goodsOfGroupTable, new GridBagConstraints(1, 4, 10, 1, 1, 1,
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(2, 2, 2, 2), 0, 0));

		// ðÿä 5

		// íàäïèñü "Çàãàëîì:" âíèçó ôîðìû
		frame.add(totalLabel, new GridBagConstraints(1, 5, 1, 1, 1, 1,
				GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL,
				new Insets(2, 2, 8, 2), 0, 0));

		// ôîðìà îòîáðàæåíèÿ ñóììàðíîãî êîëè÷åñòâà òîâàðîâ ãðóïïû
		frame.add(totalQuantityTextField, new GridBagConstraints(2, 5, 1, 1, 1,
				1, GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL,
				new Insets(2, 2, 8, 2), 0, 0));

		// ôîðìà îòîáðàæåíèÿ ñóììàðíîé öåíû òîâàðîâ ãðóïïû
		frame.add(totalPriceTextField, new GridBagConstraints(3, 5, 1, 1, 1, 1,
				GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL,
				new Insets(2, 2, 8, 2), 0, 0));

	}

	private void componentsInitialization() {

		// êíîïêà îòêðûâàåò ìåíþ äîáàâëåíèÿ/óäàëåíèÿ è ðåäàêòèðîâàíèÿ ãðóïï
		groupsManagementButton = new JButton("Ðåäàãóâàííÿ ãðóïï");
		groupsManagementButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GroupsManagerUI();
			}
		});

		// êíîïêà îòêðûâàåò ìåíþ ïîñòóïëåíèÿ/ñïèñàíèÿ è ðåäàêòèðîâàíèÿ òîâàðîâ
		goodsManagementButton = new JButton("Äîäàòè/ñïèñàòè òîâàð");
		goodsManagementButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GoodsManagerUI();
			}
		});
		// êíîïêà îòêðûâàåò ìåíþ ñòàòèñòèêè
		statisticsWindowButton = new JButton("Ñòàòèñòèêà");

		// ôîðìà ïîèñêà òîâàðîâ
		searchFormTextField = new JTextField();
		searchFormTextField.setText("íàçâà òîâàðó");

		// íàäïèñü îòîáðàæàåò òåêóùóþ âûáðàíóþ ãðóïïó
		currentGroupLabel = new JLabel(
				"ÂÑÒÀÂÈÒÜ ÍÀÇÂÀÍÈÅ ÒÅÊÓÙÅÉ ÃÐÓÏÏÛ ÒÎÂÀÐÎÂ");

		// ñïèñîê ãðóïï òîâàðîâ
		groupsList = new JList();
		groupsList.setModel(collectionManager.doListModel())
		groupsList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				goodsOfGroupTable.removeAll();
				serverPullPusher.pushString("statistics")
				if (groupsList.getValue() != "Усі группи"){
				serverPullPusher.pushString("allGroups");
				productDBArray = serverPullPusher.pullProductList();
				}
				else{
				serverPullPusher.pushString("forGroup");
				serverPullPusher.pushString(groupsList.getValue());
				productDBArray = serverPullPusher.pullProductList();
				}
			}
		});

		// öåíòðàëüíàÿ òàáëèöà ñî ñïèñêîì òîâàðîâ ãðóïïû
		TableModel model = new MyTableModel(productDBArray);
		goodsOfGroupTable = new JTable(model);
		getContentPane().add(new JScrollPane(goodsOfGroupTable));

		// íàäïèñü "Çàãàëîì:" âíèçó ôîðìû
		totalLabel = new JLabel("Çàãàëîì: ");

		// ôîðìà îòîáðàæåíèÿ ñóììàðíîãî êîëè÷åñòâà òîâàðîâ ãðóïïû
		totalQuantityTextField = new JTextField();
		totalQuantityTextField.setText("ÊÎËÈ×ÅÑÒÂÎ ÒÎÂÀÐÎÂ");

		// ôîðìà îòîáðàæåíèÿ ñóììàðíîé öåíû òîâàðîâ ãðóïïû
		totalPriceTextField = new JTextField();
		totalPriceTextField.setText("ÖÅÍÀ ÒÎÂÀÐÎÂ");

		// êíîïêà ïîäòâåðæäàþùàÿ èçìåíåíèÿ â òàáëèöå
		changesConfirmationButton = new JButton("Ïîøóê");
		changesConfirmationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (searchText.equals("")) {
					new FailureWindowUI();
				} else {
					serverPullPusher.pushString("search");
					serverPullPusher.pushString(searchText);
					searchText = null;
				}
			}
		});
	}

	ActionListener actionListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {

			// ïîèñê
			if (e.getSource() == changesConfirmationButton) {
				searchText = searchFormTextField.getText();// ïðàâèëüíûé
															// ìåòîä????
				if (searchText != null) {
					serverPullPusher.pushString("search");
					serverPullPusher.pushString(searchText);
					searchText = null;
				} else
					new FailureWindowUI();
			}
		}
	};

	public static void main(String[] args) {
		new MainUI();
	}
}
