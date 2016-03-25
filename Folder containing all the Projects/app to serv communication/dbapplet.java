import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.net.*;

public class dbapplet extends Applet implements ActionListener
{
	TextField tf;
	Button b;
	
	public void init()
	{
		add(new Label("Send any SQL Select Query to Servlet:"));
		b = new Button("Execute");
		b.addActionListener(this);
		tf = new TextField(30);
		add(tf);
		add(b);
	}//init()
	
	public void actionPerformed(ActionEvent ae)
	{
		try
		{
			URL myurl = new URL("http://localhost:9090/appser/urldbservlet?name="+tf.getText().replace(' ','+'));
			AppletContext apc = getAppletContext();
			apc.showDocument(myurl,"servlet");
		}//try
		catch(Exception ewl)
		{
			ewl.printStackTrace();
		}//catch
		
	}//actionPerformed
}//class