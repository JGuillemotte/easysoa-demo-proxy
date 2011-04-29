package frascatiSwingClient.com.openwide.sca.frascati.swing.client.ui;

import java.awt.FlowLayout;

import javax.swing.JFrame;

import frascatiSwingClient.com.openwide.sca.frascati.swing.client.messages.EventDispatcher;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4814817891046615425L;
	
	public MainFrame(){
		super();
		build();
	}
	
	private void build(){	
		setTitle("SCA Swing Client - Fuse intent updater");
		setSize(800,200);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		// Fuse Intent Panel
		FuseIntentPanel fip = new FuseIntentPanel();
		add(fip);
		
		// Fuse updater panel
		FuseUpdaterPanel fup = new FuseUpdaterPanel();
		add(fup);
		
		this.addWindowListener(new java.awt.event.WindowAdapter() {
	        public void windowClosing(java.awt.event.WindowEvent evt) {
	        		EventDispatcher.unsubscribe();
	        		System.exit(0);
	        } 
		} );

	}
}
