import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;



/**
 * @author ahmad
 *
 */
public class Main extends JFrame implements ActionListener {
	// create a frame
	static JFrame f;

	// create a textfield
	static JTextField l;

	// store operator and operands
	String s0, s1, s2;

	// default constructor
	Main()
    {
        s0 = s1 = s2 = "";
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
		
		// create a frame
        f = new JFrame("calculator");
 
        tryCatsh();
 
        // create a object of class
        Main c = new Main();
 
        // create a textfield
        l = new JTextField(16);
 
        // set the textfield to non editable
        l.setEditable(false);
 
        // create number buttons and some operators
        JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, ba, bs, bd, bm, be, beq, beq1;
 
        // create number buttons
        b0 = new JButton("0");
        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b7 = new JButton("7");
        b8 = new JButton("8");
        b9 = new JButton("9");
 
        // equals button
        beq1 = new JButton("=");
 
        // create operator buttons
        ba = new JButton("+");
        bs = new JButton("-");
        bd = new JButton("/");
        bm = new JButton("*");
        beq = new JButton("C");
 
        // create . button
        be = new JButton(".");
 
        // create a panel
        JPanel p = new JPanel();
 
        // add action listeners
        bm.addActionListener(c);
        bd.addActionListener(c);
        bs.addActionListener(c);
        ba.addActionListener(c);
        b9.addActionListener(c);
        b8.addActionListener(c);
        b7.addActionListener(c);
        b6.addActionListener(c);
        b5.addActionListener(c);
        b4.addActionListener(c);
        b3.addActionListener(c);
        b2.addActionListener(c);
        b1.addActionListener(c);
        b0.addActionListener(c);
        be.addActionListener(c);
        beq.addActionListener(c);
        beq1.addActionListener(c);
 
        // add elements to panel
        addElemnt(b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, ba, bs, bd, bm, be, beq, beq1, p);
 
        // set Background of panel
        p.setBackground(Color.blue);
 
        // add panel to frame
        f.add(p);
 
        f.setSize(200, 220);
        f.show();
	}

	/**
	 * 
	 */
	private static void tryCatsh() {
		try {
            // set look and feel
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
	}

	/**
	 * @param b0
	 * @param b1
	 * @param b2
	 * @param b3
	 * @param b4
	 * @param b5
	 * @param b6
	 * @param b7
	 * @param b8
	 * @param b9
	 * @param ba
	 * @param bs
	 * @param bd
	 * @param bm
	 * @param be
	 * @param beq
	 * @param beq1
	 * @param p
	 */
	private static void addElemnt(JButton b0, JButton b1, JButton b2, JButton b3, JButton b4, JButton b5, JButton b6,
			JButton b7, JButton b8, JButton b9, JButton ba, JButton bs, JButton bd, JButton bm, JButton be, JButton beq,
			JButton beq1, JPanel p) {
		p.add(l);
        p.add(ba);
        p.add(b1);
        p.add(b2);
        p.add(b3);
        p.add(bs);
        p.add(b4);
        p.add(b5);
        p.add(b6);
        p.add(bm);
        p.add(b7);
        p.add(b8);
        p.add(b9);
        p.add(bd);
        p.add(be);
        p.add(b0);
        p.add(beq);
        p.add(beq1);
	}
	 public void actionPerformed(ActionEvent e)
	    {
	        String s = e.getActionCommand();
	 
	        // if the value is a number
	        if ((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) == '.') {
	            // if operand is present then add to second no
	            if (!s1.equals(""))
	                s2 = s2 + s;
	            else
	                s0 = s0 + s;
	 
	            // set the value of text
	            l.setText(s0 + s1 + s2);
	        }
	        else if (s.charAt(0) == 'C') {
	            // clear the one letter
	            s0 = s1 = s2 = "";
	 
	            // set the value of text
	            l.setText(s0 + s1 + s2);
	        }
	        else if (s.charAt(0) == '=') {
	 
	            double te;
	 
	            // store the value in 1st
	            te = storeTheValue();
	 
	            // set the value of text
	            l.setText(s0 + s1 + s2 + "=" + te);
	 
	            // convert it to string
	            s0 = Double.toString(te);
	 
	            s1 = s2 = "";
	        }
	        else {
	            tocheackIfThereWasOp(s);
	 
	            // set the value of text
	            l.setText(s0 + s1 + s2);
	        }
	    }

	/**
	 * @return
	 */
	private double storeTheValue() {
		double te;
		if (s1.equals("+"))
		    te = (Double.parseDouble(s0) + Double.parseDouble(s2));
		else if (s1.equals("-"))
		    te = (Double.parseDouble(s0) - Double.parseDouble(s2));
		else if (s1.equals("/"))
		    te = (Double.parseDouble(s0) / Double.parseDouble(s2));
		else
		    te = (Double.parseDouble(s0) * Double.parseDouble(s2));
		return te;
	}

	/**
	 * @param s
	 */
	private void tocheackIfThereWasOp(String s) {
		// if there was no operand
		if (s1.equals("") || s2.equals(""))
		    s1 = s;
		// else evaluate
		else {
		    double te;
 
		    te = storeTheValue();
 
		    // convert it to string
		    s0 = Double.toString(te);
 
		    // place the operator
		    s1 = s;
 
		    // make the operand blank
		    s2 = "";
		}
	}

}
