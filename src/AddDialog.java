import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

// dialog for adding new flavor and decorator
public class AddDialog extends JDialog implements ActionListener {

	private Flavor f;
	private Decorator d;

	private JLabel l0 = new JLabel("  Add Flavor and Decorator ");

	private JLabel l1 = new JLabel(" Flavor Name");
	private JLabel l2 = new JLabel(" Flavor Price");
	private JLabel l3 = new JLabel(" Decorator Name");
	private JLabel l4 = new JLabel(" Decorator Price");

	private JTextField t1 = new JTextField(15);
	private JTextField t2 = new JTextField(15);
	private JTextField t3 = new JTextField(15);
	private JTextField t4 = new JTextField(15);

	private JButton b1 = new JButton(" Confirm ");
	private JButton b2 = new JButton(" Reset ");

	private JPanel p1 = new JPanel();

	public AddDialog() {
		super();

		Container content = getContentPane();
		content.setLayout(new FlowLayout());
		Font f = new Font("TimesRoman", Font.BOLD, 20);
		p1.setLayout(new GridLayout(10, 2));
		l0.setFont(f);
		content.add(l0);
		p1.add(l1);
		p1.add(t1);
		p1.add(l2);
		p1.add(t2);
		p1.add(l3);
		p1.add(t3);
		p1.add(l4);
		p1.add(t4);
		p1.add(b1);
		p1.add(b2);

		Component[] clist = p1.getComponents();
		for (int i = 0; i < clist.length; i++) {
			Component c = clist[i];
			((JComponent) c).setBorder(BorderFactory.createLineBorder(
					Color.black, 1));
		}
		content.add(p1);

		b1.addActionListener(this);
		b2.addActionListener(this);

		setSize(300, 300);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object target = e.getSource();
		if (target == b1) {
			try {
				this.f = new Flavor(t1.getText(),
						Integer.parseInt(t2.getText()));
				this.d = new Decorator(t3.getText(), Integer.parseInt(t4
						.getText()));
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null,
						"Please enter vaild information!", "WARNING",
						JOptionPane.WARNING_MESSAGE);
			}

		}

		if (target == b2) {
			t1.setText("");
			t2.setText("");
			t3.setText("");
			t4.setText("");
		}

	}

	public Flavor getFlavor() {
		return this.f;
	}

	public Decorator getDeco() {
		return this.d;
	}
}
