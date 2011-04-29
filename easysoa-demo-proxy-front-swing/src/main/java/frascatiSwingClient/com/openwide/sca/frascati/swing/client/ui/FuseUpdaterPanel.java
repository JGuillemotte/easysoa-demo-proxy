package frascatiSwingClient.com.openwide.sca.frascati.swing.client.ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import frascatiSwingClient.com.openwide.sca.frascati.swing.client.updater.FuseIntentUpdater;
import frascatiSwingClient.com.openwide.sca.frascati.swing.client.updater.FuseIntentUpdaterImpl;

public class FuseUpdaterPanel extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8658925188002807337L;
	private JLabel mrnParamLabel;
	private JLabel fuseIntentMessage;
	private JTextField mrnParameter;
	private JTextField fuseMessage;
	private JButton mrnUpdate;
	private JButton intentRearm;
	
	public FuseUpdaterPanel(){
		super();
		build();
	}	

	private void build(){
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;		
		
		// User Parameter label
		mrnParamLabel = new JLabel();
		mrnParamLabel.setText("Max request number : ");
		c.gridx = 0;
		c.gridy = 0;
		add(mrnParamLabel, c);
		
		// User parameter Textfield
		mrnParameter = new JTextField();
		mrnParameter.setColumns(10);
		c.gridx = 1;
		c.gridy = 0;		
		add(mrnParameter, c);
		
		// Hot update button
		mrnUpdate = new JButton();
		mrnUpdate.setText("Hot update");
		mrnUpdate.addActionListener(this);
		c.gridx = 2;
		c.gridy = 0;		
		add(mrnUpdate, c);

		// Fuse message label label
		fuseIntentMessage = new JLabel();
		fuseIntentMessage.setText("Fuse intent message : ");
		c.gridx = 0;
		c.gridy = 1;
		add(fuseIntentMessage, c);		
		
		// Fuse intent message
		fuseMessage = new JTextField();
		fuseMessage.setColumns(10);
		fuseMessage.setEditable(false);
		c.gridx = 1;
		c.gridy = 1;		
		add(fuseMessage, c);		
		
		// Rearm fuse button
		intentRearm = new JButton();
		intentRearm.setText("Rearm fuse");
		intentRearm.addActionListener(this);
		c.gridx = 2;
		c.gridy = 1;		
		add(intentRearm, c);
	}

	public void actionPerformed(ActionEvent e) {
		System.out.println("Action performed !");
		if(e.getSource().equals(mrnUpdate)){
			System.out.println("Update fuse intent action !!");
		} else if(e.getSource().equals(intentRearm)) {
			System.out.println("Rearm fuse intent action !!");
			FuseIntentUpdater fuseUpdater = new FuseIntentUpdaterImpl();
			try {
				fuseUpdater.rearmFuse();
			} 
			catch(Exception ex) {
				System.out.println("Error occurs during the rearm of fuse : " + ex.getMessage());
				ex.printStackTrace();
			}
		}
	}
	
	
}
