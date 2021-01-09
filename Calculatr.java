import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.*; 
import java.io.*; 
import java.util.*; 
import java.awt.event.*; 
import javax.swing.JFrame; 
import javax.swing.*; 
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import javax.swing.JEditorPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Calculatr extends JFrame implements ActionListener{
	JTextField out;
	JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, m, s, add, eq, b0, cx, per;
	JButton div, A, B, C, D, E, F, par1, par2, lsh, rsh, nd2, mod, ce;
	JButton OR, XOR, NOT, AND, back, plusminus, lines;
	JButton norm, dots, qword, ms, mm;
	JLabel hex, dec, bin, oct;
	JButton hexv, decv, binv, octv;
	JLabel	prog;
	JPanel p;
	long var, var2;
	String op;
	Queue<Long> numstack = new LinkedList<Long>();
	Queue<String> opstack = new LinkedList<String>();
	Long num, num2;
	
	public Calculatr() {
		
		Border emptyBorder = BorderFactory.createEmptyBorder();
		
		p = new JPanel();
		Font mfont = new Font("Segoe UI", Font.PLAIN,75);
		Font pfont = new Font("Segoe UI", Font.PLAIN,20);
		p.setLayout(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		
		/////NONE START
		c.fill = GridBagConstraints.NONE;
		c.insets = new Insets(1,1,1,1);
		c.weightx = 0;
		c.weighty = 0;
		c.ipadx = 20;
		c.ipady = 20;
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		
		lines = new JButton();
		lines.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/3lines2.png"))));
		lines.setBorder(emptyBorder);
		lines.addMouseListener(new MouseListener() {
			public void mousePressed(MouseEvent e) {
				lines.setBackground(lines.getBackground().darker());
			}
			public void mouseEntered(MouseEvent e) {
				lines.setBackground(new Color(238, 238, 238).darker());
			}
			public void mouseClicked(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
				lines.setBackground(new Color(238, 238, 238));
			}
			public void mouseReleased(MouseEvent e) {
				lines.setBackground(new Color(238, 238, 238));
			}
		});
		lines.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    	lines.setBackground(new Color(238, 238, 238).darker());
		    }
		}); 
		c.gridx = 0;
		c.gridy = 0;
		p.add(lines, c);
		validate();
		
		c.ipadx = 5;
		c.ipady = 5;
		prog = new JLabel("Programmer");
		prog.setFont(pfont);
		c.gridwidth = 3;
		c.insets = new Insets(3,50,20,0); //top, left, bottom, right
		c.gridx = 0;
		c.gridy = 0;
		p.add(prog, c);
		c.gridwidth = 1;
		
		c.insets = new Insets(1,1,1,1);
		c.weightx = 1;
		c.weighty = 1;
		
		out = new JTextField("0");
		out.setFont(mfont);
		out.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		out.setBorder(emptyBorder);
		out.setBackground(new Color(238, 238, 238));
		out.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent documentEvent) {
				
		      }
		      public void insertUpdate(DocumentEvent documentEvent) {
		    	  if(dec.getForeground() == Color.blue) {
		    		  decv.setText("             " + out.getText());
			    	  hexv.setText("             " + Long.toHexString(Long.parseLong(out.getText())));
			    	  octv.setText("             " + Long.toOctalString(Long.parseLong(out.getText())));
			    	  binv.setText("             " + Long.toBinaryString(Long.parseLong(out.getText())));
		    	  }
		    	  else if(hex.getForeground() == Color.blue) {
		    		  decv.setText("             " + Long.parseLong(out.getText(), 16));
		    		  hexv.setText("             " + out.getText());
		    		  octv.setText("             " + Long.toOctalString(Long.parseLong(out.getText(), 16)));
		    		  binv.setText("             " + Long.toBinaryString(Long.parseLong(out.getText(), 16)));
		    	  }
		    	  else if(oct.getForeground() == Color.blue) {
		    		  decv.setText("             " + Long.parseLong(out.getText(), 8));
		    		  hexv.setText("             " + Long.toHexString(Long.parseLong(out.getText(), 8)));
		    		  octv.setText("             " + out.getText());
		    		  binv.setText("             " + Long.toBinaryString(Long.parseLong(out.getText(), 8)));
		    	  }
		    	  else if(bin.getForeground() == Color.blue) {
		    		  decv.setText("             " + Long.parseLong(out.getText(), 2));
		    		  hexv.setText("             " + Long.toHexString(Long.parseLong(out.getText(), 2)));
		    		  octv.setText("             " + Long.toOctalString(Long.parseLong(out.getText(), 2)));
		    		  binv.setText("             " + out.getText());
		    	  }
			    	
		      }
		      public void removeUpdate(DocumentEvent documentEvent) {
		    	  
			  }
		});
		
		c.gridx = 0;
		c.gridy = 1;
		c.ipadx = 500;
		c.ipady = 5;
		c.anchor = GridBagConstraints.EAST;
		c.gridwidth = 6;
		c.gridheight = 1;
		p.add(out, c);
		c.gridwidth = 1;
		c.gridheight = 1;
		
		
		
		////NONE START
		c.fill = GridBagConstraints.NONE;
		c.ipadx = 60;
		c.ipady = 20;
		c.weightx = 0;
		c.weighty = 0;
		
		c.gridwidth = 1;
		norm = new JButton();
		norm.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/normal3.png"))));
		norm.setBorder(emptyBorder);
		norm.addMouseListener(new MouseListener() {
			public void mousePressed(MouseEvent e) {
				norm.setBackground(norm.getBackground().darker());
			}
			public void mouseEntered(MouseEvent e) {
				norm.setBackground(new Color(238, 238, 238).darker());
			}
			public void mouseClicked(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
				norm.setBackground(new Color(238, 238, 238));
			}
			public void mouseReleased(MouseEvent e) {
				norm.setBackground(new Color(238, 238, 238));
			}
		});
		norm.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    	norm.setBackground(new Color(238, 238, 238).darker());
		    }
		}); 
		c.gridx = 0;
		c.gridy = 6;
		c.anchor = GridBagConstraints.WEST;
		p.add(norm, c);
		validate();
		
		dots = new JButton();
		dots.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/buttons3.png"))));
		dots.setBorder(emptyBorder);
		dots.addMouseListener(new MouseListener() {
			public void mousePressed(MouseEvent e) {
				dots.setBackground(dots.getBackground().darker());
			}
			public void mouseEntered(MouseEvent e) {
				dots.setBackground(new Color(238, 238, 238).darker());
			}
			public void mouseClicked(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
				dots.setBackground(new Color(238, 238, 238));
			}
			public void mouseReleased(MouseEvent e) {
				dots.setBackground(new Color(238, 238, 238));
			}
		});
		dots.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    	dots.setBackground(new Color(238, 238, 238).darker());
		    }
		}); 
		c.gridx = 1;
		c.gridy = 6;
		p.add(dots, c);
		validate();
		
		qword = new JButton("QWORD"); 
		qword.setBorder(emptyBorder);
		qword.addMouseListener(new MouseListener() {
			public void mousePressed(MouseEvent e) {
				qword.setBackground(qword.getBackground().darker());
			}
			public void mouseEntered(MouseEvent e) {
				qword.setBackground(new Color(238, 238, 238).darker());
			}
			public void mouseClicked(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
				qword.setBackground(new Color(238, 238, 238));
			}
			public void mouseReleased(MouseEvent e) {
				qword.setBackground(new Color(238, 238, 238));
			}
		});
		qword.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    	qword.setBackground(new Color(238, 238, 238).darker());
		    	if(qword.getText().contains("QWORD")) {
		    		qword.setText("DWORD");
		    	}
		    	else if(qword.getText().contains("DWORD")) {
		    		qword.setText("WORD");
		    	}
		    	else if(qword.getText().contains("WORD")) {
		    		qword.setText("BYTE");
		    	}
		    	else if(qword.getText().contains("BYTE")) {
		    		qword.setText("QWORD");
		    	}
		    	else {}
		    }
		}); 
		c.gridx = 2;
		c.gridy = 6;
		c.gridwidth = 2;
		c.anchor = GridBagConstraints.SOUTH;
		p.add(qword, c);
		c.gridwidth = 1;
		
		ms = new JButton("MS");
		ms.setBorder(emptyBorder);
		ms.addMouseListener(new MouseListener() {
			public void mousePressed(MouseEvent e) {
				ms.setBackground(ms.getBackground().darker());
			}
			public void mouseEntered(MouseEvent e) {
				ms.setBackground(new Color(238, 238, 238).darker());
			}
			public void mouseClicked(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
				ms.setBackground(new Color(238, 238, 238));
			}
			public void mouseReleased(MouseEvent e) {
				ms.setBackground(new Color(238, 238, 238));
			}
		});
		ms.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    	ms.setBackground(new Color(238, 238, 238).darker());
		    }
		}); 
		c.gridx = 4;
		c.anchor = GridBagConstraints.EAST;
		c.gridy = 6;
		p.add(ms, c);
		
		mm = new JButton("M-");
		mm.setBorder(emptyBorder);
		mm.addMouseListener(new MouseListener() {
			public void mousePressed(MouseEvent e) {
				mm.setBackground(mm.getBackground().darker());
			}
			public void mouseEntered(MouseEvent e) {
				mm.setBackground(new Color(238, 238, 238).darker());
			}
			public void mouseClicked(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
				mm.setBackground(new Color(238, 238, 238));
			}
			public void mouseReleased(MouseEvent e) {
				mm.setBackground(new Color(238, 238, 238));
			}
		});
		mm.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    	mm.setBackground(new Color(238, 238, 238).darker());
		    }
		}); 
		c.gridx = 5;
		c.gridy = 6;
		p.add(mm, c);
		
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.weighty = 1;
		////NONE END
		
		lsh = new JButton("Lsh");
		lsh.setBorder(emptyBorder);
		lsh.setBackground(new Color(219, 219, 219));
		lsh.addMouseListener(new MouseListener() {
			public void mousePressed(MouseEvent e) {
				lsh.setBackground(lsh.getBackground().darker());
			}
			public void mouseEntered(MouseEvent e) {
				lsh.setBackground(new Color(219, 219, 219).darker());
			}
			public void mouseClicked(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
				lsh.setBackground(new Color(219, 219, 219));
			}
			public void mouseReleased(MouseEvent e) {
				lsh.setBackground(new Color(219, 219, 219));
			}
		});
		lsh.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    	lsh.setBackground(new Color(219, 219, 219).darker());
		    }
		}); 
		c.gridx = 0;
		c.gridy = 7;
		p.add(lsh, c);
		
		rsh = new JButton("Rsh");
		rsh.setBorder(emptyBorder);
		rsh.setBackground(new Color(219, 219, 219));
		rsh.addMouseListener(new MouseListener() {
			public void mousePressed(MouseEvent e) {
				rsh.setBackground(rsh.getBackground().darker());
			}
			public void mouseEntered(MouseEvent e) {
				rsh.setBackground(new Color(219, 219, 219).darker());
			}
			public void mouseClicked(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
				rsh.setBackground(new Color(219, 219, 219));
			}
			public void mouseReleased(MouseEvent e) {
				rsh.setBackground(new Color(219, 219, 219));
			}
		});
		rsh.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    	rsh.setBackground(new Color(219, 219, 219).darker());
		    }
		}); 
		c.gridx = 1;
		c.gridy = 7;
		p.add(rsh, c);
		
		OR = new JButton("Or");
		OR.setBorder(emptyBorder);
		OR.setBackground(new Color(219, 219, 219));
		OR.addMouseListener(new MouseListener() {
			public void mousePressed(MouseEvent e) {
				OR.setBackground(OR.getBackground().darker());
			}
			public void mouseEntered(MouseEvent e) {
				OR.setBackground(new Color(219, 219, 219).darker());
			}
			public void mouseClicked(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
				OR.setBackground(new Color(219, 219, 219));
			}
			public void mouseReleased(MouseEvent e) {
				OR.setBackground(new Color(219, 219, 219));
			}
		});
		OR.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    	OR.setBackground(new Color(219, 219, 219).darker());
		    }
		}); 
		c.gridx = 2;
		c.gridy = 7;
		p.add(OR, c);
		
		XOR = new JButton("Xor");
		XOR.setBorder(emptyBorder);
		XOR.setBackground(new Color(219, 219, 219));
		XOR.addMouseListener(new MouseListener() {
			public void mousePressed(MouseEvent e) {
				XOR.setBackground(XOR.getBackground().darker());
			}
			public void mouseEntered(MouseEvent e) {
				XOR.setBackground(new Color(219, 219, 219).darker());
			}
			public void mouseClicked(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
				XOR.setBackground(new Color(219, 219, 219));
			}
			public void mouseReleased(MouseEvent e) {
				XOR.setBackground(new Color(219, 219, 219));
			}
		});
		XOR.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    	XOR.setBackground(new Color(219, 219, 219).darker());
		    }
		}); 
		c.gridx = 3;
		c.gridy = 7;
		p.add(XOR, c);
		
		NOT = new JButton("Not");
		NOT.setBorder(emptyBorder);
		NOT.setBackground(new Color(219, 219, 219));
		NOT.addMouseListener(new MouseListener() {
			public void mousePressed(MouseEvent e) {
				NOT.setBackground(NOT.getBackground().darker());
			}
			public void mouseEntered(MouseEvent e) {
				NOT.setBackground(new Color(219, 219, 219).darker());
			}
			public void mouseClicked(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
				NOT.setBackground(new Color(219, 219, 219));
			}
			public void mouseReleased(MouseEvent e) {
				NOT.setBackground(new Color(219, 219, 219));
			}
		});
		NOT.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    	NOT.setBackground(new Color(219, 219, 219).darker());
		    }
		}); 
		c.gridx = 4;
		c.gridy = 7;
		p.add(NOT, c);
		
		AND = new JButton("And");
		AND.setBorder(emptyBorder);
		AND.setBackground(new Color(219, 219, 219));
		AND.addMouseListener(new MouseListener() {
			public void mousePressed(MouseEvent e) {
				AND.setBackground(AND.getBackground().darker());
			}
			public void mouseEntered(MouseEvent e) {
				AND.setBackground(new Color(219, 219, 219).darker());
			}
			public void mouseClicked(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
				AND.setBackground(new Color(219, 219, 219));
			}
			public void mouseReleased(MouseEvent e) {
				AND.setBackground(new Color(219, 219, 219));
			}
		});
		AND.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    	AND.setBackground(new Color(219, 219, 219).darker());
		    }
		}); 
		c.gridx = 5;
		c.gridy = 7;
		p.add(AND, c);
		
		nd2 = new JButton("2nd");
		nd2.setBorder(emptyBorder);
		nd2.setBackground(new Color(219, 219, 219));
		nd2.addMouseListener(new MouseListener() {
			public void mousePressed(MouseEvent e) {
				nd2.setBackground(nd2.getBackground().darker());
			}
			public void mouseEntered(MouseEvent e) {
				nd2.setBackground(new Color(219, 219, 219).darker());
			}
			public void mouseClicked(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
				nd2.setBackground(new Color(219, 219, 219));
			}
			public void mouseReleased(MouseEvent e) {
				nd2.setBackground(new Color(219, 219, 219));
			}
		});
		nd2.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    	nd2.setBackground(new Color(219, 219, 219).darker());
		    }
		}); 
		c.gridx = 0;
		c.gridy = 8;
		p.add(nd2, c);
		
		mod = new JButton("Mod");
		mod.setBorder(emptyBorder);
		mod.setBackground(new Color(219, 219, 219));
		mod.addMouseListener(new MouseListener() {
			public void mousePressed(MouseEvent e) {
				mod.setBackground(mod.getBackground().darker());
			}
			public void mouseEntered(MouseEvent e) {
				mod.setBackground(new Color(219, 219, 219).darker());
			}
			public void mouseClicked(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
				mod.setBackground(new Color(219, 219, 219));
			}
			public void mouseReleased(MouseEvent e) {
				mod.setBackground(new Color(219, 219, 219));
			}
		});
		mod.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    	mod.setBackground(new Color(219, 219, 219).darker());
		    	if(opstack.isEmpty()) {
		    		var = Long.parseLong(out.getText());
			    	numstack.add(var);
			    	opstack.add("%");
			    	out.setText("");
		    	}
		    	else {
		    		var2 = Long.parseLong(out.getText());
		    		//var2 = Long.parseLong(out.getText().substring(out.getText().lastIndexOf("+") + 1,out.getText().length()));
		    		numstack.add(var2);
		    		var = varmod(numstack, opstack);
		    		out.setText(Long.toString(var));
		    		var = Long.parseLong(out.getText());
			    	numstack.add(var);
			    	opstack.add("%");
			    	out.setText("");
		    	}
		    }
		}); 
		c.gridx = 1;
		c.gridy = 8;
		p.add(mod, c);
		
		ce = new JButton("CE");
		ce.setBorder(emptyBorder);
		ce.setBackground(new Color(219, 219, 219));
		ce.addMouseListener(new MouseListener() {
			public void mousePressed(MouseEvent e) {
				ce.setBackground(ce.getBackground().darker());
			}
			public void mouseEntered(MouseEvent e) {
				ce.setBackground(new Color(219, 219, 219).darker());
			}
			public void mouseClicked(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
				ce.setBackground(new Color(219, 219, 219));
			}
			public void mouseReleased(MouseEvent e) {
				ce.setBackground(new Color(219, 219, 219));
			}
		});
		ce.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    	ce.setBackground(new Color(219, 219, 219).darker());
		    }
		}); 
		c.gridx = 2;
		c.gridy = 8;
		p.add(ce, c);
		
		cx = new JButton("C");
		cx.setBorder(emptyBorder);
		cx.setBackground(new Color(219, 219, 219));
		cx.addMouseListener(new MouseListener() {
			public void mousePressed(MouseEvent e) {
				cx.setBackground(cx.getBackground().darker());
			}
			public void mouseEntered(MouseEvent e) {
				cx.setBackground(new Color(219, 219, 219).darker());
			}
			public void mouseClicked(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
				cx.setBackground(new Color(219, 219, 219));
			}
			public void mouseReleased(MouseEvent e) {
				cx.setBackground(new Color(219, 219, 219));
			}
		});
		cx.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    	cx.setBackground(new Color(219, 219, 219).darker());
		    	out.setText("0");
		    }
		}); 
		c.gridx = 3;
		c.gridy = 8;
		p.add(cx, c);
		
		back = new JButton();
		back.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/back2.png"))));
		back.setBorder(emptyBorder);
		back.setBackground(new Color(219, 219, 219));
		back.addMouseListener(new MouseListener() {
			public void mousePressed(MouseEvent e) {
				back.setBackground(back.getBackground().darker());
			}
			public void mouseEntered(MouseEvent e) {
				back.setBackground(new Color(219, 219, 219).darker());
			}
			public void mouseClicked(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
				back.setBackground(new Color(219, 219, 219));
			}
			public void mouseReleased(MouseEvent e) {
				back.setBackground(new Color(219, 219, 219));
			}
		});
		back.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    	back.setBackground(new Color(250, 250, 250).darker());
		    	if(out.getText().equals("0")) {
					out.setText("0");
				}
				else {
					out.setText(Long.toString((Long.parseLong(out.getText()) / 10)));
				}
		    }
		}); 
		c.gridx = 4;
		c.gridy = 8;
		p.add(back, c);
		validate();
		
		div = new JButton("/");
		div.setBorder(emptyBorder);
		div.setBackground(new Color(219, 219, 219));
		div.addMouseListener(new MouseListener() {
			public void mousePressed(MouseEvent e) {
				div.setBackground(div.getBackground().darker());
			}
			public void mouseEntered(MouseEvent e) {
				div.setBackground(new Color(219, 219, 219).darker());
			}
			public void mouseClicked(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
				div.setBackground(new Color(219, 219, 219));
			}
			public void mouseReleased(MouseEvent e) {
				div.setBackground(new Color(219, 219, 219));
			}
		});
		div.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    	div.setBackground(new Color(219, 219, 219).darker());
		    	if(opstack.isEmpty()) {
		    		var = Long.parseLong(out.getText());
			    	numstack.add(var);
			    	opstack.add("/");
			    	out.setText("");
		    	}
		    	else {
		    		var2 = Long.parseLong(out.getText());
		    		//var2 = Long.parseLong(out.getText().substring(out.getText().lastIndexOf("+") + 1,out.getText().length()));
		    		numstack.add(var2);
		    		var = vardiv(numstack, opstack);
		    		out.setText(Long.toString(var));
		    		var = Long.parseLong(out.getText());
			    	numstack.add(var);
			    	opstack.add("/");
			    	out.setText("");
		    	}
		    	
		    }
		}); 
		c.gridx = 5;
		c.gridy = 8;
		p.add(div, c);
		
		A = new JButton("A");
		A.setBorder(emptyBorder);
		A.setBackground(new Color(250, 250, 250));
		A.addMouseListener(new MouseListener() {
			public void mousePressed(MouseEvent e) {
				if(A.isEnabled() == false) {
				}
				else {
					A.setBackground(A.getBackground().darker());
				}	
			}
			public void mouseEntered(MouseEvent e) {
				if(A.isEnabled() == false) {
				}
				else {
					A.setBackground(new Color(250, 250, 250).darker());
				}	
			}
			public void mouseClicked(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
				if(A.isEnabled() == false) {
				}
				else {
					A.setBackground(new Color(250, 250, 250));
				}
			}
			public void mouseReleased(MouseEvent e) {
				if(A.isEnabled() == false) {
				}
				else {	
					A.setBackground(new Color(250, 250, 250));
				}
			}
		});
		A.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    	A.setBackground(new Color(250, 250, 250).darker());
		    	if(out.getText().equals("0")) {
					out.setText("A");
				}
				else {
					out.setText(out.getText() + "A");
				}
		    }
		}); 
		c.gridx = 0;
		c.gridy = 9;
		p.add(A, c);
		
		B = new JButton("B");
		B.setBorder(emptyBorder);
		B.setBackground(new Color(250, 250, 250));
		B.addMouseListener(new MouseListener() {
			public void mousePressed(MouseEvent e) {
				if(B.isEnabled() == false) {
				}
				else {
					B.setBackground(B.getBackground().darker());
				}
			}
			public void mouseEntered(MouseEvent e) {
				if(B.isEnabled() == false) {
				}
				else {
					B.setBackground(new Color(250, 250, 250).darker());
				}
			}
			public void mouseClicked(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
				if(B.isEnabled() == false) {
				}
				else {
					B.setBackground(new Color(250, 250, 250));
				}
			}
			public void mouseReleased(MouseEvent e) {
				if(B.isEnabled() == false) {
				}
				else {
					B.setBackground(new Color(250, 250, 250));
				}
			}
		});
		B.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    	B.setBackground(new Color(250, 250, 250).darker());
		    	if(out.getText().equals("0")) {
					out.setText("B");
				}
				else {
					out.setText(out.getText() + "B");
				}
		    }
		}); 
		c.gridx = 1;
		c.gridy = 9;
		p.add(B, c);
		
		b7 = new JButton("7");
		b7.setBorder(emptyBorder);
		b7.setBackground(new Color(250, 250, 250));
		b7.addMouseListener(new MouseListener() {
			public void mousePressed(MouseEvent e) {
				if(b7.isEnabled() == false) {
				}
				else {
					b7.setBackground(b7.getBackground().darker());
				}
			}
			public void mouseEntered(MouseEvent e) {
				if(b7.isEnabled() == false) {
				}
				else {
					b7.setBackground(new Color(250, 250, 250).darker());
				}
			}
			public void mouseClicked(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
				if(b7.isEnabled() == false) {
				}
				else {
					b7.setBackground(new Color(250, 250, 250));
				}
			}
			public void mouseReleased(MouseEvent e) {
				if(b7.isEnabled() == false) {
				}
				else {
					b7.setBackground(new Color(250, 250, 250));
				}
			}
		});
		b7.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    	b7.setBackground(new Color(250, 250, 250).darker());
		    	if(out.getText().equals("0")) {
					out.setText("7");
				}
				else {
					out.setText(out.getText() + "7");
				}
		    }
		}); 
		c.gridx = 2;
		c.gridy = 9;
		p.add(b7, c);
		
		b8 = new JButton("8");
		b8.setBorder(emptyBorder);
		b8.setBackground(new Color(250, 250, 250));
		b8.addMouseListener(new MouseListener() {
			public void mousePressed(MouseEvent e) {
				if(b8.isEnabled() == false) {
				}
				else {
					b8.setBackground(b8.getBackground().darker());
				}
			}
			public void mouseEntered(MouseEvent e) {
				if(b8.isEnabled() == false) {
				}
				else {
					b8.setBackground(new Color(250, 250, 250).darker());
				}
			}
			public void mouseClicked(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
				if(b8.isEnabled() == false) {
				}
				else {
					b8.setBackground(new Color(250, 250, 250));
				}
			}
			public void mouseReleased(MouseEvent e) {
				if(b8.isEnabled() == false) {
				}
				else {
					b8.setBackground(new Color(250, 250, 250));
				}
			}
		});
		b8.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    	b8.setBackground(new Color(250, 250, 250).darker());
		    	if(out.getText().equals("0")) {
					out.setText("8");
				}
				else {
					out.setText(out.getText() + "8");
				}
		    }
		}); 
		c.gridx = 3;
		c.gridy = 9;
		p.add(b8, c);
		
		b9 = new JButton("9");
		b9.setBorder(emptyBorder);
		b9.setBackground(new Color(250, 250, 250));
		b9.addMouseListener(new MouseListener() {
			public void mousePressed(MouseEvent e) {
				if(b9.isEnabled() == false) {
				}
				else {
					b9.setBackground(b9.getBackground().darker());
				}
			}
			public void mouseEntered(MouseEvent e) {
				if(b9.isEnabled() == false) {
				}
				else {
					b9.setBackground(new Color(250, 250, 250).darker());
				}
			}
			public void mouseClicked(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
				if(b9.isEnabled() == false) {
				}
				else {
					b9.setBackground(new Color(250, 250, 250));
				}
			}
			public void mouseReleased(MouseEvent e) {
				if(b9.isEnabled() == false) {
				}
				else {
					b9.setBackground(new Color(250, 250, 250));
				}
			}
		});
		b9.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    	b9.setBackground(new Color(250, 250, 250).darker());
		    	if(out.getText().equals("0")) {
					out.setText("9");
				}
				else {
					out.setText(out.getText() + "9");
				}
		    }
		}); 
		c.gridx = 4;
		c.gridy = 9;
		p.add(b9, c);
		
		m = new JButton("X");
		m.setBorder(emptyBorder);
		m.setBackground(new Color(219, 219, 219));
		m.addMouseListener(new MouseListener() {
			public void mousePressed(MouseEvent e) {
				m.setBackground(m.getBackground().darker());
			}
			public void mouseEntered(MouseEvent e) {
				m.setBackground(new Color(219, 219, 219).darker());
			}
			public void mouseClicked(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
				m.setBackground(new Color(219, 219, 219));
			}
			public void mouseReleased(MouseEvent e) {
				m.setBackground(new Color(219, 219, 219));
			}
		});
		m.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    	m.setBackground(new Color(219, 219, 219).darker());
		    	if(opstack.isEmpty()) {
		    		var = Long.parseLong(out.getText());
			    	numstack.add(var);
			    	opstack.add("*");
			    	out.setText("");
		    	}
		    	else {
		    		var2 = Long.parseLong(out.getText());
		    		//var2 = Long.parseLong(out.getText().substring(out.getText().lastIndexOf("+") + 1,out.getText().length()));
		    		numstack.add(var2);
		    		var = varmult(numstack, opstack);
		    		out.setText(Long.toString(var));
		    		var = Long.parseLong(out.getText());
			    	numstack.add(var);
			    	opstack.add("*");
			    	out.setText("");
		    	}
		    }
		}); 
		c.gridx = 5;
		c.gridy = 9;
		p.add(m, c);
		
		C = new JButton("C");
		C.setBorder(emptyBorder);
		C.setBackground(new Color(250, 250, 250));
		C.addMouseListener(new MouseListener() {
			public void mousePressed(MouseEvent e) {
				if(C.isEnabled() == false) {
				}
				else {
					C.setBackground(C.getBackground().darker());
				}
			}
			public void mouseEntered(MouseEvent e) {
				if(C.isEnabled() == false) {
				}
				else {
					C.setBackground(new Color(250, 250, 250).darker());
				}
			}
			public void mouseClicked(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
				if(C.isEnabled() == false) {
				}
				else {
					C.setBackground(new Color(250, 250, 250));
				}
			}
			public void mouseReleased(MouseEvent e) {
				if(C.isEnabled() == false) {
				}
				else {
					C.setBackground(new Color(250, 250, 250));
				}
			}
		});
		C.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    	C.setBackground(new Color(250, 250, 250).darker());
		    	if(out.getText().equals("0")) {
					out.setText("C");
				}
				else {
					out.setText(out.getText() + "C");
				}
		    }
		}); 
		c.gridx = 0;
		c.gridy = 10;
		p.add(C, c);
		
		D = new JButton("D");
		D.setBorder(emptyBorder);
		D.setBackground(new Color(250, 250, 250));
		D.addMouseListener(new MouseListener() {
			public void mousePressed(MouseEvent e) {
				if(D.isEnabled() == false) {
				}
				else {
					D.setBackground(D.getBackground().darker());
				}
			}
			public void mouseEntered(MouseEvent e) {
				if(D.isEnabled() == false) {
				}
				else {
					D.setBackground(new Color(250, 250, 250).darker());
				}
			}
			public void mouseClicked(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
				if(D.isEnabled() == false) {
				}
				else {
					D.setBackground(new Color(250, 250, 250));
				}
			}
			public void mouseReleased(MouseEvent e) {
				if(D.isEnabled() == false) {
				}
				else {
					D.setBackground(new Color(250, 250, 250));
				}
			}
		});
		D.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    	D.setBackground(new Color(250, 250, 250).darker());
		    	if(out.getText().equals("0")) {
					out.setText("D");
				}
				else {
					out.setText(out.getText() + "D");
				}
		    }
		}); 
		c.gridx = 1;
		c.gridy = 10;
		p.add(D, c);
		
		b4 = new JButton("4");
		b4.setBorder(emptyBorder);
		b4.setBackground(new Color(250, 250, 250));
		b4.addMouseListener(new MouseListener() {
			public void mousePressed(MouseEvent e) {
				if(b4.isEnabled() == false) {
				}
				else {
					b4.setBackground(b4.getBackground().darker());
				}
			}
			public void mouseEntered(MouseEvent e) {
				if(b4.isEnabled() == false) {
				}
				else {
					b4.setBackground(new Color(250, 250, 250).darker());
				}
			}
			public void mouseClicked(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
				if(b4.isEnabled() == false) {
				}
				else {
					b4.setBackground(new Color(250, 250, 250));
				}
			}
			public void mouseReleased(MouseEvent e) {
				if(b4.isEnabled() == false) {
				}
				else {
					b4.setBackground(new Color(250, 250, 250));
				}
			}
		});
		b4.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    	b4.setBackground(new Color(250, 250, 250).darker());
				if(out.getText().equals("0")) {
					out.setText("4");
				}
				else {
					out.setText(out.getText() + "4");
				}
		    }
		}); 
		c.gridx = 2;
		c.gridy = 10;
		p.add(b4, c);
		
		b5 = new JButton("5");
		b5.setBorder(emptyBorder);
		b5.setBackground(new Color(250, 250, 250));
		b5.addMouseListener(new MouseListener() {
			public void mousePressed(MouseEvent e) {
				if(b5.isEnabled() == false) {
				}
				else {
					b5.setBackground(b5.getBackground().darker());
				}
			}
			public void mouseEntered(MouseEvent e) {
				if(b5.isEnabled() == false) {
				}
				else {
					b5.setBackground(new Color(250, 250, 250).darker());
				}
			}
			public void mouseClicked(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
				if(b5.isEnabled() == false) {
				}
				else {
					b5.setBackground(new Color(250, 250, 250));
				}
			}
			public void mouseReleased(MouseEvent e) {
				if(b5.isEnabled() == false) {
				}
				else {
					b5.setBackground(new Color(250, 250, 250));
				}
			}
		});
		b5.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    	b5.setBackground(new Color(250, 250, 250).darker());
				if(out.getText().equals("0")) {
					out.setText("5");
				}
				else {
					out.setText(out.getText() + "5");
				}
		    }
		}); 
		c.gridx = 3;
		c.gridy = 10;
		p.add(b5, c);
		
		b6 = new JButton("6");
		b6.setBorder(emptyBorder);
		b6.setBackground(new Color(250, 250, 250));
		b6.addMouseListener(new MouseListener() {
			public void mousePressed(MouseEvent e) {
				if(b6.isEnabled() == false) {
				}
				else {
					b6.setBackground(b6.getBackground().darker());
				}
			}
			public void mouseEntered(MouseEvent e) {
				if(b6.isEnabled() == false) {
				}
				else {
					b6.setBackground(new Color(250, 250, 250).darker());
				}
			}
			public void mouseClicked(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
				if(b6.isEnabled() == false) {
				}
				else {
					b6.setBackground(new Color(250, 250, 250));
				}
			}
			public void mouseReleased(MouseEvent e) {
				if(b6.isEnabled() == false) {
				}
				else {
					b6.setBackground(new Color(250, 250, 250));
				}
			}
		});
		b6.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    	b6.setBackground(new Color(250, 250, 250).darker());
				if(out.getText().equals("0" )) {
					out.setText("6");
				}
				else {
					out.setText(out.getText() + "6");
				}
		    }
		}); 
		c.gridx = 4;
		c.gridy = 10;
		p.add(b6, c);
		
		s = new JButton("-");
		s.setBorder(emptyBorder);
		s.setBackground(new Color(219, 219, 219));
		s.addMouseListener(new MouseListener() {
			public void mousePressed(MouseEvent e) {
				s.setBackground(s.getBackground().darker());
			}
			public void mouseEntered(MouseEvent e) {
				s.setBackground(new Color(219, 219, 219).darker());
			}
			public void mouseClicked(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
				s.setBackground(new Color(219, 219, 219));
			}
			public void mouseReleased(MouseEvent e) {
				s.setBackground(new Color(219, 219, 219));
			}
		});
		s.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    	s.setBackground(new Color(219, 219, 219).darker());
		    	if(opstack.isEmpty()) {
		    		var = Long.parseLong(out.getText());
			    	numstack.add(var);
			    	opstack.add("-");
			    	out.setText("");
		    	}
		    	else {
		    		var2 = Long.parseLong(out.getText());
		    		//var2 = Long.parseLong(out.getText().substring(out.getText().lastIndexOf("+") + 1,out.getText().length()));
		    		numstack.add(var2);
		    		var = varsub(numstack, opstack);
		    		out.setText(Long.toString(var));
		    		var = Long.parseLong(out.getText());
			    	numstack.add(var);
			    	opstack.add("-");
			    	out.setText("");
		    	}
		    }
		}); 
		c.gridx = 5;
		c.gridy = 10;
		p.add(s, c);
		
		E = new JButton("E");
		E.setBorder(emptyBorder);
		E.setBackground(new Color(250, 250, 250));
		E.addMouseListener(new MouseListener() {
			public void mousePressed(MouseEvent e) {
				if(E.isEnabled() == false) {
				}
				else {
					E.setBackground(E.getBackground().darker());
				}
			}
			public void mouseEntered(MouseEvent e) {
				if(E.isEnabled() == false) {
				}
				else {
					E.setBackground(new Color(250, 250, 250).darker());
				}
			}
			public void mouseClicked(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
				if(E.isEnabled() == false) {
				}
				else {
					E.setBackground(new Color(250, 250, 250));
				}
			}
			public void mouseReleased(MouseEvent e) {
				if(E.isEnabled() == false) {
				}
				else {
					E.setBackground(new Color(250, 250, 250));
				}
			}
		});
		E.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    	E.setBackground(new Color(250, 250, 250).darker());
		    	if(out.getText().equals("0")) {
					out.setText("E");
				}
				else {
					out.setText(out.getText() + "E");
				}
		    }
		}); 
		c.gridx = 0;
		c.gridy = 11;
		p.add(E, c);
		
		F = new JButton("F");
		F.setBorder(emptyBorder);
		F.setBackground(new Color(250, 250, 250));
		F.addMouseListener(new MouseListener() {
			public void mousePressed(MouseEvent e) {
				if(F.isEnabled() == false) {
				}
				else {
					F.setBackground(F.getBackground().darker());
				}
			}
			public void mouseEntered(MouseEvent e) {
				if(F.isEnabled() == false) {
				}
				else {
					F.setBackground(new Color(250, 250, 250).darker());
				}
			}
			public void mouseClicked(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
				if(F.isEnabled() == false) {
				}
				else {
					F.setBackground(new Color(250, 250, 250));
				}
			}
			public void mouseReleased(MouseEvent e) {
				if(F.isEnabled() == false) {
				}
				else {
					F.setBackground(new Color(250, 250, 250));
				}
			}
		});
		F.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    	F.setBackground(new Color(250, 250, 250).darker());
		    	if(out.getText().equals("0")) {
					out.setText("F");
				}
				else {
					out.setText(out.getText() + "F");
				}
		    }
		}); 
		c.gridx = 1;
		c.gridy = 11;
		p.add(F, c);
		
		b1 = new JButton("1");
		b1.setBorder(emptyBorder);
		b1.setBackground(new Color(250, 250, 250));
		b1.addMouseListener(new MouseListener() {
			public void mousePressed(MouseEvent e) {
				b1.setBackground(b1.getBackground().darker());
			}
			public void mouseEntered(MouseEvent e) {
				b1.setBackground(new Color(250, 250, 250).darker());
			}
			public void mouseClicked(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
				b1.setBackground(new Color(250, 250, 250));
			}
			public void mouseReleased(MouseEvent e) {
				b1.setBackground(new Color(250, 250, 250));
			}
		});
		b1.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    	b1.setBackground(new Color(250, 250, 250).darker());
				if(out.getText().equals("0")) {
					out.setText("1");
				}
				else {
					out.setText(out.getText() + "1");
				}
		    }
		}); 
		c.gridx = 2;
		c.gridy = 11;
		p.add(b1, c);
		
		b2 = new JButton("2");
		b2.setBorder(emptyBorder);
		b2.setBackground(new Color(250, 250, 250));
		b2.addMouseListener(new MouseListener() {
			public void mousePressed(MouseEvent e) {
				if(b2.isEnabled() == false) {
				}
				else {
					b2.setBackground(b2.getBackground().darker());
				}
			}
			public void mouseEntered(MouseEvent e) {
				if(b2.isEnabled() == false) {
				}
				else {
					b2.setBackground(new Color(250, 250, 250).darker());
				}
			}
			public void mouseClicked(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
				if(b2.isEnabled() == false) {
				}
				else {
					b2.setBackground(new Color(250, 250, 250));
				}
			}
			public void mouseReleased(MouseEvent e) {
				if(b2.isEnabled() == false) {
				}
				else {
					b2.setBackground(new Color(250, 250, 250));
				}
			}
		});
		b2.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    	b2.setBackground(new Color(250, 250, 250).darker());
				if(out.getText().equals("0")) {
					out.setText("2");
				}
				else {
					out.setText(out.getText() + "2");
				}
		    }
		}); 
		c.gridx = 3;
		c.gridy = 11;
		p.add(b2, c);
		
		b3 = new JButton("3");
		b3.setBorder(emptyBorder);
		b3.setBackground(new Color(250, 250, 250));
		b3.addMouseListener(new MouseListener() {
			public void mousePressed(MouseEvent e) {
				if(b3.isEnabled() == false) {
				}
				else {
					b3.setBackground(b3.getBackground().darker());
				}
			}
			public void mouseEntered(MouseEvent e) {
				if(b3.isEnabled() == false) {
				}
				else {
					b3.setBackground(new Color(250, 250, 250).darker());
				}
			}
			public void mouseClicked(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
				if(b3.isEnabled() == false) {
				}
				else {
					b3.setBackground(new Color(250, 250, 250));
				}
			}
			public void mouseReleased(MouseEvent e) {
				if(b3.isEnabled() == false) {
				}
				else {
					b3.setBackground(new Color(250, 250, 250));
				}
			}
		});
		b3.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    	b3.setBackground(new Color(250, 250, 250).darker());
				if(out.getText().equals("0")) {
					out.setText("3");
				}
				else {
					out.setText(out.getText() + "3");
				}
		    }
		}); 
		c.gridx = 4;
		c.gridy = 11;
		p.add(b3, c);
		
		add = new JButton("+");
		add.setBorder(emptyBorder);
		add.setBackground(new Color(219, 219, 219));
		add.addMouseListener(new MouseListener() {
			public void mousePressed(MouseEvent e) {
				add.setBackground(add.getBackground().darker());
			}
			public void mouseEntered(MouseEvent e) {
				add.setBackground(new Color(219, 219, 219).darker());
			}
			public void mouseClicked(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
				add.setBackground(new Color(219, 219, 219));
			}
			public void mouseReleased(MouseEvent e) {
				add.setBackground(new Color(219, 219, 219));
			}
		});
		
		add.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    	add.setBackground(new Color(219, 219, 219).darker());
		    	
		    	if(opstack.isEmpty()) {
		    		var = Long.parseLong(out.getText());
			    	numstack.add(var);
			    	opstack.add("+");
			    	out.setText("");
		    	}
		    	else {
		    		var2 = Long.parseLong(out.getText());
		    		//var2 = Long.parseLong(out.getText().substring(out.getText().lastIndexOf("+") + 1,out.getText().length()));
		    		numstack.add(var2);
		    		var = varadd(numstack, opstack);
		    		out.setText(Long.toString(var));
		    		var = Long.parseLong(out.getText());
			    	numstack.add(var);
			    	opstack.add("+");
			    	out.setText("");
		    	}
		    }
		}); 
		c.gridx = 5;
		c.gridy = 11;
		p.add(add, c);
		
		par1 = new JButton("(");
		par1.setBorder(emptyBorder);
		par1.setBackground(new Color(219, 219, 219));
		par1.addMouseListener(new MouseListener() {
			public void mousePressed(MouseEvent e) {
				par1.setBackground(par1.getBackground().darker());
			}
			public void mouseEntered(MouseEvent e) {
				par1.setBackground(new Color(219, 219, 219).darker());
			}
			public void mouseClicked(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
				par1.setBackground(new Color(219, 219, 219));
			}
			public void mouseReleased(MouseEvent e) {
				par1.setBackground(new Color(219, 219, 219));
			}
		});
		par1.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    	par1.setBackground(new Color(219, 219, 219).darker());
		    }
		}); 
		c.gridx = 0;
		c.gridy = 12;
		p.add(par1, c);
		
		par2 = new JButton(")");
		par2.setBorder(emptyBorder);
		par2.setBackground(new Color(219, 219, 219));
		par2.addMouseListener(new MouseListener() {
			public void mousePressed(MouseEvent e) {
				par2.setBackground(par2.getBackground().darker());
			}
			public void mouseEntered(MouseEvent e) {
				par2.setBackground(new Color(219, 219, 219).darker());
			}
			public void mouseClicked(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
				par2.setBackground(new Color(219, 219, 219));
			}
			public void mouseReleased(MouseEvent e) {
				par2.setBackground(new Color(219, 219, 219));
			}
		});
		par2.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    	par2.setBackground(new Color(219, 219, 219).darker());
		    }
		});
		c.gridx = 1;
		c.gridy = 12;
		p.add(par2, c);
		
		plusminus = new JButton("+/-");
		plusminus.setBorder(emptyBorder);
		plusminus.setBackground(new Color(219, 219, 219));
		plusminus.addMouseListener(new MouseListener() {
			public void mousePressed(MouseEvent e) {
				plusminus.setBackground(plusminus.getBackground().darker());
			}
			public void mouseEntered(MouseEvent e) {
				plusminus.setBackground(new Color(219, 219, 219).darker());
			}
			public void mouseClicked(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
				plusminus.setBackground(new Color(219, 219, 219));
			}
			public void mouseReleased(MouseEvent e) {
				plusminus.setBackground(new Color(219, 219, 219));
			}
		});
		plusminus.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    	plusminus.setBackground(new Color(219, 219, 219).darker());
		    }
		});
		c.gridx = 2;
		c.gridy = 12;
		p.add(plusminus, c);
		
		b0 = new JButton("0");
		b0.setBorder(emptyBorder);
		b0.setBackground(new Color(250, 250, 250));
		b0.addMouseListener(new MouseListener() {
			public void mousePressed(MouseEvent e) {
				b0.setBackground(b0.getBackground().darker());
			}
			public void mouseEntered(MouseEvent e) {
				b0.setBackground(new Color(250, 250, 250).darker());
			}
			public void mouseClicked(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
				b0.setBackground(new Color(250, 250, 250));
			}
			public void mouseReleased(MouseEvent e) {
				b0.setBackground(new Color(250, 250, 250));
			}
		});
		b0.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    	b0.setBackground(new Color(250, 250, 250).darker());
				if(out.getText().equals("0")) {
					out.setText("0");
				}
				else {
					out.setText(out.getText() + "0");
				}
		    }
		});
		c.gridx = 3;
		c.gridy = 12;
		p.add(b0, c);
		
		per = new JButton(".");
		per.setBorder(emptyBorder);
		per.setBackground(new Color(219, 219, 219));
		per.addMouseListener(new MouseListener() {
			public void mousePressed(MouseEvent e) {
				per.setBackground(per.getBackground().darker());
			}
			public void mouseEntered(MouseEvent e) {
				per.setBackground(new Color(219, 219, 219).darker());
			}
			public void mouseClicked(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
				per.setBackground(new Color(219, 219, 219));
			}
			public void mouseReleased(MouseEvent e) {
				per.setBackground(new Color(219, 219, 219));
			}
		});
		per.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    	per.setBackground(new Color(219, 219, 219).darker());
		    }
		});
		c.gridx = 4;
		c.gridy = 12;
		p.add(per, c);
		
		eq = new JButton("=");
		eq.setBorder(emptyBorder);
		eq.setBackground(new Color(219, 219, 219));
		eq.addMouseListener(new MouseListener() {
			public void mousePressed(MouseEvent e) {
				eq.setBackground(eq.getBackground().darker());
			}
			public void mouseEntered(MouseEvent e) {
				eq.setBackground(new Color(219, 219, 219).darker());
			}
			public void mouseClicked(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
				eq.setBackground(new Color(219, 219, 219));
			}
			public void mouseReleased(MouseEvent e) {
				eq.setBackground(new Color(219, 219, 219));
			}
		});
		eq.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    	eq.setBackground(new Color(219, 219, 219).darker());
		    	if(opstack.contains("+")) {
		    		var2 = Long.parseLong(out.getText());
		    		//var2 = Long.parseLong(out.getText().substring(out.getText().lastIndexOf("+") + 1,out.getText().length()));
		    		numstack.add(var2);
		    		var = varadd(numstack, opstack);
		    		out.setText(Long.toString(var));
		    	}
		    	if(opstack.contains("-")) {
		    		var2 = Long.parseLong(out.getText());
		    		//var2 = Long.parseLong(out.getText().substring(out.getText().lastIndexOf("-") + 1,out.getText().length()));
		    		numstack.add(var2);
		    		var = varsub(numstack, opstack);
		    		out.setText(Long.toString(var));
		    	}
		    	if(opstack.contains("*")) {
		    		var2 = Long.parseLong(out.getText());
		    		//var2 = Long.parseLong(out.getText().substring(out.getText().lastIndexOf("*") + 1,out.getText().length()));
		    		numstack.add(var2);
		    		var = varmult(numstack, opstack);
		    		out.setText(Long.toString(var));
		    	}
		    	if(opstack.contains("/")) {
		    		var2 = Long.parseLong(out.getText());
		    		//var2 = Long.parseLong(out.getText().substring(out.getText().lastIndexOf("/") + 1,out.getText().length()));
		    		numstack.add(var2);
		    		var = vardiv(numstack, opstack);
		    		out.setText(Long.toString(var));
		    	}
		    	if(opstack.contains("%")) {
		    		var2 = Long.parseLong(out.getText());
		    		//var2 = Long.parseLong(out.getText().substring(out.getText().lastIndexOf("%") + 1,out.getText().length()));
		    		numstack.add(var2);
		    		var = varmod(numstack, opstack);
		    		out.setText(Long.toString(var));
		    	}
		    }
		});
		c.gridx = 5;
		c.gridy = 12;
		p.add(eq, c);
		
	/////NONE START
			c.fill = GridBagConstraints.NONE;
			c.anchor = GridBagConstraints.FIRST_LINE_START;
			c.ipadx = 500;
			c.ipady = 20;
			c.weightx = 0;
			c.weighty = 0;
			
			ButtonGroup group = new ButtonGroup();
			hexv = new JButton("             " + "0");
			decv = new JButton("             " + "0");
			octv = new JButton("             " + "0");
			binv = new JButton("             " + "0");
			group.add(hexv);
			group.add(decv);
			group.add(octv);
			group.add(binv);
			hex = new JLabel("HEX");
			hexv.setBorder(emptyBorder);
			hexv.addMouseListener(new MouseListener() {
				public void mousePressed(MouseEvent e) {
					hexv.setBackground(hexv.getBackground().darker());
				}
				public void mouseEntered(MouseEvent e) {
					hexv.setBackground(new Color(238, 238, 238).darker());
				}
				public void mouseClicked(MouseEvent e) {
				}
				public void mouseExited(MouseEvent e) {
					hexv.setBackground(new Color(238, 238, 238));
				}
				public void mouseReleased(MouseEvent e) {
					hexv.setBackground(new Color(238, 238, 238));
				}
			});
			hexv.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					hexv.setBackground(new Color(238, 238, 238).darker());
					
					decv.setForeground(Color.black);
					dec.setForeground(Color.black);
					hexv.setForeground(Color.blue);
					hex.setForeground(Color.blue);
					octv.setForeground(Color.black);
					oct.setForeground(Color.black);
					binv.setForeground(Color.black);
					bin.setForeground(Color.black);
					
					out.setText(hexv.getText().substring(13,hexv.getText().length()));
					
					A.setEnabled(true);
					B.setEnabled(true);
					C.setEnabled(true);
					D.setEnabled(true);
					E.setEnabled(true);
					F.setEnabled(true);
					b9.setEnabled(true);
					b8.setEnabled(true);
					b7.setEnabled(true);
					b6.setEnabled(true);
					b5.setEnabled(true);
					b4.setEnabled(true);
					b3.setEnabled(true);
					b2.setEnabled(true);
				}
			});
			hexv.setHorizontalAlignment(SwingConstants.LEFT);
			hexv.add(hex);
			c.gridx = 0;
			c.gridy = 2;
			c.gridwidth = 6;
			p.add(hexv, c);
			
			
			dec = new JLabel("DEC");
			decv.setBorder(emptyBorder);
			decv.addMouseListener(new MouseListener() {
				public void mousePressed(MouseEvent e) {
					decv.setBackground(decv.getBackground().darker());
				}
				public void mouseEntered(MouseEvent e) {
					decv.setBackground(new Color(238, 238, 238).darker());
				}
				public void mouseClicked(MouseEvent e) {
				}
				public void mouseExited(MouseEvent e) {
					decv.setBackground(new Color(238, 238, 238));
				}
				public void mouseReleased(MouseEvent e) {
					decv.setBackground(new Color(238, 238, 238));
				}
			});
			decv.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					decv.setBackground(new Color(238, 238, 238).darker());
					
					decv.setForeground(Color.blue);
					dec.setForeground(Color.blue);
					hexv.setForeground(Color.black);
					hex.setForeground(Color.black);
					octv.setForeground(Color.black);
					oct.setForeground(Color.black);
					binv.setForeground(Color.black);
					bin.setForeground(Color.black);
					
					out.setText(decv.getText().substring(13,decv.getText().length()));
					
					A.setEnabled(false);
					B.setEnabled(false);
					C.setEnabled(false);
					D.setEnabled(false);
					E.setEnabled(false);
					F.setEnabled(false);
					b9.setEnabled(true);
					b8.setEnabled(true);
					b7.setEnabled(true);
					b6.setEnabled(true);
					b5.setEnabled(true);
					b4.setEnabled(true);
					b3.setEnabled(true);
					b2.setEnabled(true);
				}
			});
			decv.setHorizontalAlignment(SwingConstants.LEFT);
			decv.add(dec);
			decv.setForeground(Color.blue);
			dec.setForeground(Color.blue);
			
			A.setEnabled(false);
			B.setEnabled(false);
			C.setEnabled(false);
			D.setEnabled(false);
			E.setEnabled(false);
			F.setEnabled(false);
			
			c.gridx = 0;
			c.gridy = 3;
			c.gridwidth = 6;
			p.add(decv, c);
			
			
			oct = new JLabel("OCT");
			octv.setBorder(emptyBorder);
			octv.addMouseListener(new MouseListener() {
				public void mousePressed(MouseEvent e) {
					octv.setBackground(octv.getBackground().darker());
				}
				public void mouseEntered(MouseEvent e) {
					octv.setBackground(new Color(238, 238, 238).darker());
				}
				public void mouseClicked(MouseEvent e) {
				}
				public void mouseExited(MouseEvent e) {
					octv.setBackground(new Color(238, 238, 238));
				}
				public void mouseReleased(MouseEvent e) {
					octv.setBackground(new Color(238, 238, 238));
				}
			});
			octv.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					octv.setBackground(new Color(238, 238, 238).darker());
					
					decv.setForeground(Color.black);
					dec.setForeground(Color.black);
					hexv.setForeground(Color.black);
					hex.setForeground(Color.black);
					octv.setForeground(Color.blue);
					oct.setForeground(Color.blue);
					binv.setForeground(Color.black);
					bin.setForeground(Color.black);
					
					out.setText(octv.getText().substring(13,octv.getText().length()));
					
					A.setEnabled(false);
					B.setEnabled(false);
					C.setEnabled(false);
					D.setEnabled(false);
					E.setEnabled(false);
					F.setEnabled(false);
					b9.setEnabled(false);
					b8.setEnabled(false);
					b7.setEnabled(true);
					b6.setEnabled(true);
					b5.setEnabled(true);
					b4.setEnabled(true);
					b3.setEnabled(true);
					b2.setEnabled(true);
				}
			});
			octv.setHorizontalAlignment(SwingConstants.LEFT);
			octv.add(oct);
			c.gridx = 0;
			c.gridy = 4;
			c.gridwidth = 6;
			p.add(octv, c);
			
			
			bin = new JLabel("BIN");
			binv.setBorder(emptyBorder);
			binv.addMouseListener(new MouseListener() {
				public void mousePressed(MouseEvent e) {
					binv.setBackground(binv.getBackground().darker());
				}
				public void mouseEntered(MouseEvent e) {
					binv.setBackground(new Color(238, 238, 238).darker());
				}
				public void mouseClicked(MouseEvent e) {
				}
				public void mouseExited(MouseEvent e) {
					binv.setBackground(new Color(238, 238, 238));
				}
				public void mouseReleased(MouseEvent e) {
					binv.setBackground(new Color(238, 238, 238));
				}
			});
			binv.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					binv.setBackground(new Color(238, 238, 238).darker());
					
					decv.setForeground(Color.black);
					dec.setForeground(Color.black);
					hexv.setForeground(Color.black);
					hex.setForeground(Color.black);
					octv.setForeground(Color.black);
					oct.setForeground(Color.black);
					binv.setForeground(Color.blue);
					bin.setForeground(Color.blue);
					
					out.setText(binv.getText().substring(13,binv.getText().length()));
					
					A.setEnabled(false);
					B.setEnabled(false);
					C.setEnabled(false);
					D.setEnabled(false);
					E.setEnabled(false);
					F.setEnabled(false);
					b9.setEnabled(false);
					b8.setEnabled(false);
					b7.setEnabled(false);
					b6.setEnabled(false);
					b5.setEnabled(false);
					b4.setEnabled(false);
					b3.setEnabled(false);
					b2.setEnabled(false);
				}
			});
			binv.setHorizontalAlignment(SwingConstants.LEFT);
			binv.add(bin);
			c.gridx = 0;
			c.gridy = 5;
			c.gridwidth = 6;
			p.add(binv, c);
			
			c.fill = GridBagConstraints.BOTH;
			
			////NONE END
			
	
		add(p);	
	}
	
	public long varadd(Queue s, Queue o) {
		num = null;
		while(numstack.size() > 0) {
			if(num == null) {
				num = (Long)s.remove();
			}
			
			String oper = (String)o.remove();
			num2 = (Long)s.remove();
			//use if and contains("+") to make the operator work
			if(oper.contains("+"))
			{
				num = num + num2;
			}
		}
		return num;
	}
	
	public long varsub(Queue s, Queue o) {
		num = null;
		while(numstack.size() > 0) {
			if(num == null) {
				num = (Long)s.remove();
			}
			
			String oper = (String)o.remove();
			num2 = (Long)s.remove();
			if(oper.contains("-"))
			{
				num = num - num2;
			}
		}
		return num;
	}
	
	public long varmult(Queue s, Queue o) {
		num = null;
		while(numstack.size() > 0) {
			if(num == null) {
				num = (Long)s.remove();
			}
			
			String oper = (String)o.remove();
			num2 = (Long)s.remove();
			if(oper.contains("*"))
			{
				num = num * num2;
			}
		}
		return num;
	}
	
	public long vardiv(Queue<Long> s, Queue o) {
		num = null;
		
		while(numstack.size() > 0) {
			if(num == null) {
				num = (Long)s.remove();
			}
			
			String oper = (String)o.remove();
			num2 = (Long)s.remove();
			if(oper.contains("/"))
			{
				num = num / num2;
			}
		}
		return num;
	}
	
	public long varmod(Queue s, Queue o) {
		num = null;
		
		while(numstack.size() > 0) {
			if(num == null) {
				num = (Long)s.remove();
			}
			
			String oper = (String)o.remove();
			num2 = (Long)s.remove();
			if(oper.contains("%"))
			{
				num = num % num2;
			}
		}
		return num;
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}
	
}
