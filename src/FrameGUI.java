import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.Border;

// main frame menu
public class FrameGUI extends JFrame implements ActionListener {
	private JLabel l0 = new JLabel("  Point-of-Sale System   ");

	private JLabel l1 = new JLabel(" ICE-CREAM Flavor ");
	private JLabel l2 = new JLabel(" Decorator ");
	private JButton b0 = new JButton(" [New IceCream] ");

	private Flavor flavor1 = new Flavor(" Chocolate ", 20);
	private JButton b1 = new JButton(" [" + flavor1.getName() + ", $ "
			+ flavor1.getPrice() + "] ");
	private Decorator deco1 = new Decorator(" M&M ", 5);
	private JButton b2 = new JButton(" [" + deco1.getName() + ", $ "
			+ deco1.getPrice() + "] ");
	private JTextField t1 = new JTextField(" Select one flavor only! ", 20);

	private Flavor flavor2 = new Flavor(" Vanilla ", 20);
	private JButton b3 = new JButton(" [" + flavor2.getName() + ", $ "
			+ flavor1.getPrice() + "] ");
	private Decorator deco2 = new Decorator(" Strawberry ", 4);
	private JButton b4 = new JButton(" [" + deco2.getName() + ", $ "
			+ deco2.getPrice() + "] ");
	private JTextField t2 = new JTextField(" Please select decorator!  ", 20);

	private JTextField t3 = new JTextField(" Total: ", 20);

	private JButton b5 = new JButton(" [System Administrator] ");

	private Flavor flavor3 = new Flavor("  ", 0);
	private JButton b6 = new JButton(" ");
	private Decorator deco3 = new Decorator("  ", 0);
	private JButton b7 = new JButton(" ");

	private JButton b8 = new JButton(" Add ");
	private JButton b9 = new JButton(" Remove ");

	private JPanel p1 = new JPanel();

	private int totalprice = 0;
	private boolean flagf1 = true;
	private boolean flagf2 = true;
	private boolean flagf3 = true;
	private boolean flagd1 = true;
	private boolean flagd2 = true;
	private boolean flagd3 = true;

	private String newFlavor = "";
	private int newFlavorPrice = 0;
	private String newDeco = "";
	private int newDecoPrice = 0;

	private AddDialog d;

	public FrameGUI(String s) {
		super(s);
		init_System();
		Container content = getContentPane();
		content.setLayout(new FlowLayout());
		Font f = new Font("TimesRoman", Font.BOLD, 20);
		p1.setLayout(new GridLayout(5, 3));
		l0.setFont(f);
		content.add(l0);
		p1.add(l1);
		p1.add(l2);
		p1.add(b0);
		p1.add(b1);
		p1.add(b2);
		p1.add(t1);
		p1.add(b3);
		p1.add(b4);
		p1.add(t2);
		p1.add(b6);
		p1.add(b7);
		p1.add(t3);
		p1.add(b5);
		p1.add(b8);
		p1.add(b9);

		Component[] clist = p1.getComponents();
		for (int i = 0; i < clist.length; i++) {
			Component c = clist[i];
			((JComponent) c).setBorder(BorderFactory.createLineBorder(
					Color.black, 1));
		}
		content.add(p1);

		b0.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);

		setSize(700, 300);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		Object target = e.getSource();

		// choose the first flavor
		if (target == b1) {
			if (this.flagf1 && this.flagf2 && this.flagf3) {
				t1.setText(" Chocolate has been selected!");
				this.totalprice += flavor1.getPrice();
				t3.setText(" Total: $ " + this.totalprice);
				this.flagf1 = false;
			} else if (this.flagf1 && !this.flagf2 && this.flagf3) {
				t1.setText(" Chocolate has been selected!");
				this.totalprice = this.totalprice - flavor2.getPrice()
						+ flavor1.getPrice();
				t3.setText(" Total: $ " + this.totalprice);
				this.flagf1 = false;
				this.flagf2 = true;
			} else if (this.flagf1 && this.flagf2 && !this.flagf3) {
				t1.setText(" Chocolate has been selected!");
				this.totalprice = this.totalprice - flavor3.getPrice()
						+ flavor1.getPrice();
				t3.setText(" Total: $ " + this.totalprice);
				this.flagf1 = false;
				this.flagf3 = true;
			}
		}

		// choose or cancel the first decorator
		if (target == b2) {
			if (this.flagd1 && this.flagd2 && this.flagd3) {
				t2.setText(" M&M selected!");
				this.totalprice += deco1.getPrice();
				t3.setText(" Total: $ " + this.totalprice);
				this.flagd1 = false;
			} else if (this.flagd1 && !this.flagd2 && this.flagd3) {
				t2.setText(" M&M and Strawberry selected!");
				this.totalprice += deco1.getPrice();
				t3.setText(" Total: $ " + this.totalprice);
				this.flagd1 = false;
			} else if (!this.flagd1 && this.flagd2 && this.flagd3) {
				t2.setText(" No decorator selected!");
				this.totalprice -= deco1.getPrice();
				t3.setText(" Total: $ " + this.totalprice);
				this.flagd1 = true;
			} else if (!this.flagd1 && !this.flagd2 && this.flagd3) {
				t2.setText(" Strawberry selected!");
				this.totalprice -= deco1.getPrice();
				t3.setText(" Total: $ " + this.totalprice);
				this.flagd1 = true;
			} else if (this.flagd1 && this.flagd2 && !this.flagd3) {
				t2.setText(" M&M and " + deco3.getName() + " selected!");
				this.totalprice += deco1.getPrice();
				t3.setText(" Total: $ " + this.totalprice);
				this.flagd1 = false;
			} else if (this.flagd1 && !this.flagd2 && !this.flagd3) {
				t2.setText(" M&M, Strawberry and " + deco3.getName()
						+ " selected!");
				this.totalprice += deco1.getPrice();
				t3.setText(" Total: $ " + this.totalprice);
				this.flagd1 = false;
			} else if (!this.flagd1 && this.flagd2 && !this.flagd3) {
				t2.setText(" " + deco3.getName() + " selected!");
				this.totalprice -= deco1.getPrice();
				t3.setText(" Total: $ " + this.totalprice);
				this.flagd1 = true;
			} else if (!this.flagd1 && !this.flagd2 && !this.flagd3) {
				t2.setText(" Strawberry and " + deco3.getName() + " selected!");
				this.totalprice -= deco1.getPrice();
				t3.setText(" Total: $ " + this.totalprice);
				this.flagd1 = true;
			}
		}

		// choose the second flavor
		if (target == b3) {
			if (this.flagf1 && this.flagf2 && this.flagf3) {
				t1.setText(" Vanilla has been selected!");
				this.totalprice += flavor2.getPrice();
				t3.setText(" Total: $ " + this.totalprice);
				this.flagf2 = false;
			} else if (this.flagf2 && !this.flagf1 && this.flagf3) {
				t1.setText(" Vanilla has been selected!");
				this.totalprice = this.totalprice - flavor1.getPrice()
						+ flavor2.getPrice();
				t3.setText(" Total: $ " + this.totalprice);
				this.flagf2 = false;
				this.flagf1 = true;
			} else if (this.flagf2 && this.flagf1 && !this.flagf3) {
				t1.setText(" Vanilla has been selected!");
				this.totalprice = this.totalprice - flavor3.getPrice()
						+ flavor2.getPrice();
				t3.setText(" Total: $ " + this.totalprice);
				this.flagf2 = false;
				this.flagf3 = true;
			}
		}

		// choose or cancel the second decorator
		if (target == b4) {
			if (this.flagd1 && this.flagd2 && this.flagd3) {
				t2.setText(" Strawberry selected!");
				this.totalprice += deco2.getPrice();
				t3.setText(" Total: $ " + this.totalprice);
				this.flagd2 = false;
			} else if (this.flagd2 && !this.flagd1 && this.flagd3) {
				t2.setText(" M&M and Strawberry selected!");
				this.totalprice += deco2.getPrice();
				t3.setText(" Total: $ " + this.totalprice);
				this.flagd2 = false;
			} else if (!this.flagd2 && this.flagd1 && this.flagd3) {
				t2.setText(" No decorator selected!");
				this.totalprice -= deco2.getPrice();
				t3.setText(" Total: $ " + this.totalprice);
				this.flagd2 = true;
			} else if (!this.flagd2 && !this.flagd1 && this.flagd3) {
				t2.setText(" M&M selected!");
				this.totalprice -= deco2.getPrice();
				t3.setText(" Total: $ " + this.totalprice);
				this.flagd2 = true;
			} else if (this.flagd1 && this.flagd2 && !this.flagd3) {
				t2.setText(" Strawberry and " + deco3.getName() + " selected!");
				this.totalprice += deco2.getPrice();
				t3.setText(" Total: $ " + this.totalprice);
				this.flagd2 = false;
			} else if (this.flagd2 && !this.flagd1 && !this.flagd3) {
				t2.setText(" M&M, Strawberry and " + deco3.getName()
						+ " selected!");
				this.totalprice += deco2.getPrice();
				t3.setText(" Total: $ " + this.totalprice);
				this.flagd2 = false;
			} else if (!this.flagd2 && this.flagd1 && !this.flagd3) {
				t2.setText(" " + deco3.getName() + " selected!");
				this.totalprice -= deco2.getPrice();
				t3.setText(" Total: $ " + this.totalprice);
				this.flagd2 = true;
			} else if (!this.flagd2 && !this.flagd1 && !this.flagd3) {
				t2.setText(" M&M and " + deco3.getName() + " selected!");
				this.totalprice -= deco2.getPrice();
				t3.setText(" Total: $ " + this.totalprice);
				this.flagd2 = true;
			}
		}

		// choose the third flavor
		if (target == b6) {
			if (flavor3.getPrice() != 0) {
				if (this.flagf1 && this.flagf2 && this.flagf3) {
					t1.setText(" " + flavor3.getName() + " has been selected!");
					this.totalprice += flavor3.getPrice();
					t3.setText(" Total: $ " + this.totalprice);
					this.flagf3 = false;
				} else if (this.flagf2 && !this.flagf1 && this.flagf3) {
					t1.setText(" " + flavor3.getName() + " has been selected!");
					this.totalprice = this.totalprice - flavor1.getPrice()
							+ flavor3.getPrice();
					t3.setText(" Total: $ " + this.totalprice);
					this.flagf3 = false;
					this.flagf1 = true;
				} else if (!this.flagf2 && this.flagf1 && this.flagf3) {
					t1.setText(" " + flavor3.getName() + " has been selected!");
					this.totalprice = this.totalprice - flavor2.getPrice()
							+ flavor3.getPrice();
					t3.setText(" Total: $ " + this.totalprice);
					this.flagf3 = false;
					this.flagf2 = true;
				}
			} else {
				JOptionPane.showMessageDialog(null,
						"Please enter the third flavor!", "WARNING",
						JOptionPane.WARNING_MESSAGE);
			}
		}

		// choose or cancel the third decorator
		if (target == b7) {
			if (deco3.getPrice() != 0) {
				if (this.flagd1 && !this.flagd2 && !this.flagd3) {
					t2.setText(" Strawberry selected!");
					this.totalprice -= deco3.getPrice();
					t3.setText(" Total: $ " + this.totalprice);
					this.flagd3 = true;
				} else if (!this.flagd2 && !this.flagd1 && !this.flagd3) {
					t2.setText(" M&M and Strawberry selected!");
					this.totalprice -= deco3.getPrice();
					t3.setText(" Total: $ " + this.totalprice);
					this.flagd3 = true;
				} else if (this.flagd2 && this.flagd1 && !this.flagd3) {
					t2.setText(" No decorator selected!");
					this.totalprice -= deco3.getPrice();
					t3.setText(" Total: $ " + this.totalprice);
					this.flagd3 = true;
				} else if (this.flagd2 && !this.flagd1 && !this.flagd3) {
					t2.setText(" M&M selected!");
					this.totalprice -= deco3.getPrice();
					t3.setText(" Total: $ " + this.totalprice);
					this.flagd3 = true;
				} else if (this.flagd1 && !this.flagd2 && this.flagd3) {
					t2.setText(" Strawberry and " + deco3.getName()
							+ " selected!");
					this.totalprice += deco3.getPrice();
					t3.setText(" Total: $ " + this.totalprice);
					this.flagd3 = false;
				} else if (!this.flagd2 && !this.flagd1 && this.flagd3) {
					t2.setText(" M&M, Strawberry and " + deco3.getName()
							+ " selected!");
					this.totalprice += deco3.getPrice();
					t3.setText(" Total: $ " + this.totalprice);
					this.flagd3 = false;
				} else if (this.flagd2 && this.flagd1 && this.flagd3) {
					t2.setText(" " + deco3.getName() + " selected!");
					this.totalprice += deco3.getPrice();
					t3.setText(" Total: $ " + this.totalprice);
					this.flagd3 = false;
				} else if (this.flagd2 && !this.flagd1 && this.flagd3) {
					t2.setText(" M&M and " + deco3.getName() + " selected!");
					this.totalprice += deco3.getPrice();
					t3.setText(" Total: $ " + this.totalprice);
					this.flagd3 = false;
				}
			} else {
				JOptionPane.showMessageDialog(null,
						"Please enter the third decorator!", "WARNING",
						JOptionPane.WARNING_MESSAGE);
			}
		}

		// generator a new dialog for adding flavor and decorator
		if (target == b5) {

			this.d = new AddDialog();
			d.setVisible(true);

		}

		// add the new flavor and decorator into the main menu
		if (target == b8) {
			try {
				this.newFlavor = d.getFlavor().getName();
				this.newFlavorPrice = d.getFlavor().getPrice();
				this.newDeco = d.getDeco().getName();
				this.newDecoPrice = d.getDeco().getPrice();
				AddFlavor(this.newFlavor, this.newFlavorPrice);
				AddDeco(this.newDeco, this.newDecoPrice);
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null,
						"Please enter the third flavor and decorator!",
						"WARNING", JOptionPane.WARNING_MESSAGE);
			}

		}

		// remove the new flavor and decorator
		if (target == b9) {
			b6.setText("");
			b7.setText("");

		}

		// start a new transaction
		if (target == b0) {
			init_System();
		}
	}

	public void init_System() {
		t1.setText(" Select one flavor only! ");
		t2.setText(" Please select decorator!  ");
		t3.setText(" Total: ");
	}

	// add the third flavor
	public void AddFlavor(String name, int price) {
		this.flavor3 = new Flavor(name, price);
		this.b6.setText(" [" + flavor3.getName() + ", $ " + flavor3.getPrice()
				+ "] ");
	}

	// add the third decorator
	public void AddDeco(String name, int price) {
		this.deco3 = new Decorator(name, price);
		this.b7.setText(" [" + deco3.getName() + ", $ " + deco3.getPrice()
				+ "] ");
	}
}
