package com.ss.ipfinder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class IPFinder extends JFrame implements ActionListener
{
	
	private static final long serialVersionUID = -2216410507551053728L;
	private JLabel findIPLabel;
	private JTextField enterUrlTxtFld;
	private JButton getUrlBtn;
	
	public IPFinder()
	{
		super("IP Finder App");
		findIPLabel = new JLabel("Enter a valid URL");
		findIPLabel.setBounds(150,100,150,30);
		add(findIPLabel);
				
		enterUrlTxtFld = new JTextField("here !");
		enterUrlTxtFld.setBounds(150,200,150,30);
		add(enterUrlTxtFld);
				
		getUrlBtn = new JButton("PROCESS");
		getUrlBtn.addActionListener(this);
		getUrlBtn.setBounds(200,400,150,30);
		add(getUrlBtn);
				
		setLayout(null);
		setVisible(true);
		setSize(500,600);
		
	}
	
	public static void main(String[] args) 
	{
		new IPFinder();

	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		String url = enterUrlTxtFld.getText().toString();
		
		try {
			
			InetAddress address =  InetAddress.getByName(url);
			String hostIPAdd = address.getHostAddress().toString();
			JOptionPane.showMessageDialog(this, hostIPAdd);
		}
		catch(UnknownHostException e)
		{
			JOptionPane.showMessageDialog(this, e.toString());
		}
		
		
	}

}
