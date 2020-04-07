import java.awt.*;
import javax.swing.JButton; 
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;


class JTextFieldLimit extends PlainDocument {
	  private int limit;
	  JTextFieldLimit(int limit) {
	    super();
	    this.limit = limit;
	  }

	  JTextFieldLimit(int limit, boolean upper) {
	    super();
	    this.limit = limit;
	  }

	  public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
	    if (str == null)
	      return;

	    if ((getLength() + str.length()) <= limit) {
	      super.insertString(offset, str, attr);
	    }
	  }
	}

public class JFrameTest {
 
	    final static boolean shouldFill = true; 
	    final static boolean shouldWeightX = true; 
	     static boolean RIGHT_TO_LEFT = false; 
	    
	 
	    public static void addComponentsToPane(Container pane) { 
	        if (RIGHT_TO_LEFT) { 
	            pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT); 
	        } 
	 
	        JButton btnG,btnO,btnPx,btnSx,btnSub,btnS;
	        JTextField tf1 ,tf2;
	        
	        pane.setLayout(new GridBagLayout()); 
	        GridBagConstraints c = new GridBagConstraints(); 
	         
	        if (shouldFill) { 
	            // натуральная высота, максимальная ширина 
	            c.fill = GridBagConstraints.HORIZONTAL; 
	        } 
	 
	        btnG = new JButton("Готово"); 
	        c.fill = GridBagConstraints.HORIZONTAL; 
	        c.weighty = 0; 
	        c.weightx = 0;
	        c.gridx = 0; 
	        c.gridy = 3; 
	        pane.add(btnG, c); 
	 
	        btnO = new JButton("Отмена"); 
	        c.fill = GridBagConstraints.HORIZONTAL;
	        c.weighty = 1;
	        c.weightx = 2; 
	        c.gridx = 1; 
	        c.gridy = 3; 
	        pane.add(btnO, c); 
	         
	        btnSx = new JButton("Suffix"); 
	        c.fill = GridBagConstraints.HORIZONTAL; 
	        c.weightx = 2; 
	        c.gridx = 1; 
	        c.gridy = 4; 
	        pane.add(btnSx, c); 
	        btnSx.setEnabled(false);
	 
	        btnPx = new JButton("Prefix"); 
	        c.fill = GridBagConstraints.HORIZONTAL;  
	        c.weightx = 2; 
	        c.gridx = 0; 
	        c.gridy = 4; 
	        pane.add(btnPx, c); 
	        btnPx.setEnabled(false);
	 
	        btnSub = new JButton("Substring"); 
	        c.fill = GridBagConstraints.HORIZONTAL;
	        c.weightx = 2; 
	        c.gridx = 0;       
	        c.gridy = 5;       
	        pane.add(btnSub, c); 
	        btnSub.setEnabled(false);
	        
	        btnS = new JButton("SubS"); 
	        c.fill = GridBagConstraints.HORIZONTAL;
	        c.weightx = 2; 
	        c.gridx = 1;       
	        c.gridy = 5;       
	        pane.add(btnS, c);
	        btnS.setEnabled(false);
	 
	        tf1 = new JTextField();
	        c.fill = GridBagConstraints.HORIZONTAL;
	        c.gridx =0;
	        c.gridy=1;
	        tf1.setDocument(new JTextFieldLimit(9));
	        pane.add(tf1,c);
	        tf1.addCaretListener(new CaretListener() {
				public void caretUpdate(CaretEvent e) {
					String str = tf1.getText();
					int m = str.length();
					boolean res;
					if (m==0)
						res = false;
					else
						res =true;
				}
			});
	        
	        tf2 = new JTextField();
	        c.fill = GridBagConstraints.HORIZONTAL;
	        c.gridx =1;
	        c.gridy=1;
	        tf2.setDocument(new JTextFieldLimit(5));
	        pane.add(tf2,c);
	    
	
	    btnG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = tf1.getText();
				int m = str.length();
				boolean res;
				if (m==0)
					 res = false;
				else
					res =true;
				String sub = tf2.getText();
				int n = sub.length();
				boolean re;
				if (n==0)
					re = false;
				else
					re =true;
				
				if ((res)&&(re)){
					
				tf1.setEditable(false);
				tf2.setEditable(false);
				btnSx.setEnabled(true);
				btnPx.setEnabled(true);
				btnSub.setEnabled(true);
				btnS.setEnabled(true);
				}else {
					btnSx.setEnabled(false);
					btnPx.setEnabled(false);
					btnSub.setEnabled(false);
					btnS.setEnabled(false);
				}
			}
	    });
	    
	    
	    btnO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf1.setText("");
				tf2.setText("");
				tf1.setEditable(true);
				tf2.setEditable(true);
				btnSx.setEnabled(false);
				btnPx.setEnabled(false);
				btnSub.setEnabled(false);
				btnS.setEnabled(false);
			}
		});
	    
	    tf2.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				String sub = tf2.getText();
				int n = sub.length();
				boolean re;
				if (n==0)
					re = false;
				else
					re =true;
			}
		});
	    
	    
	    btnSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = tf1.getText();
				String sub = tf2.getText();
				boolean res1 = Subclass.Substring(str,sub);
				if(res1) 
					JOptionPane.showMessageDialog(null, "Является подстрокой");
				else 
					JOptionPane.showMessageDialog(null, "Не является подстрокой");
			}
		});
	    
	    btnPx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = tf1.getText();
				String sub = tf2.getText();
				boolean res1 = Subclass.isPrefix(str,sub);
				if(res1) 
					JOptionPane.showMessageDialog(null, "Является префиксом");
				else 
					JOptionPane.showMessageDialog(null, "Не является префиксом");
			}
		});

	    

		btnSx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = tf1.getText();
				String sub = tf2.getText(); 
					
				
				boolean res1 = Subclass.isSuffix(str,sub);
				if(res1) 
					JOptionPane.showMessageDialog(null, "Является суффиксом");
				else 
					JOptionPane.showMessageDialog(null, "Не является суффиксом");
			}
		});
	    
		
		btnS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = tf1.getText();
				String sub = tf2.getText();
				int n = str.length();
				int m = sub.length();		
			boolean res1 = Subclass.isSubsequence(sub,str,m,n);
				if(res1) 
					JOptionPane.showMessageDialog(null, "Является подпоследовательностью");
				else 
					JOptionPane.showMessageDialog(null, "Не является подпоследовательностью");
			}
		});
		
		}
	public static void createGUI()
    {
        JFrame frame = new JFrame("Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(300, 150));
        
        addComponentsToPane(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);          
   }
	
	
	
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
	       javax.swing.SwingUtilities.invokeLater(new Runnable() {
	           public void run() {
	               createGUI();
	           }
	       });

	}

}
