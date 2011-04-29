package frascatiSwingClient.com.openwide.sca.frascati.swing.client.ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import frascatiSwingClient.com.openwide.sca.frascati.swing.client.messages.RequestSender;

public class FuseIntentPanel extends JPanel implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4814817891046615425L;
	private JLabel userParamLabel;
	private JTextField userParameter;
	private JButton sendRequestButton;
	private JLabel serverResponseLabel;
	private JTextField serverResponse;
	
	/**
	 * 
	 */
	public FuseIntentPanel(){
		super();
		build();
	}
	
	/**
	 * 
	 */
	private void build(){
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;		
		
		// User Parameter label
		userParamLabel = new JLabel();
		userParamLabel.setText("User parameter : ");
		c.gridx = 0;
		c.gridy = 0;
		add(userParamLabel, c);
		
		// User parameter Textfield
		userParameter = new JTextField();
		userParameter.setColumns(10);
		c.gridx = 1;
		c.gridy = 0;		
		add(userParameter, c);
		
		// Send request button
		sendRequestButton = new JButton();
		sendRequestButton.setText("Send request");
		sendRequestButton.addActionListener(this);
		c.gridx = 2;
		c.gridy = 0;		
		add(sendRequestButton, c);

		// server response label
		serverResponseLabel = new JLabel();
		serverResponseLabel.setText("Server response : ");
		c.gridx = 0;
		c.gridy = 1;	
		add(serverResponseLabel, c);
		
		// Server response
		serverResponse = new JTextField();
		serverResponse.setEditable(false);
		userParameter.setColumns(40);
		c.gridx = 1;
		c.gridy = 1;		
		add(serverResponse, c);		
	}

	/**
	 * 
	 */
	public void actionPerformed(ActionEvent e) {
		RequestSender rs = new RequestSender();
		serverResponse.setText(rs.sendRequest(userParameter.getText()));
	}
}