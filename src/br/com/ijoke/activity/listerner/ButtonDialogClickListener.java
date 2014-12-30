package br.com.ijoke.activity.listerner;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

import br.com.ijoke.activity.callback.DialogCallback;

/**
 * 
 * @author root
 *
 */
public class ButtonDialogClickListener implements OnClickListener {

	private DialogCallback callback;
	
	public ButtonDialogClickListener(DialogCallback callback){
		this.callback = callback; 
	}
	
	@Override
	public void onClick(DialogInterface dialog, int which) {
		switch (which) {
		case DialogInterface.BUTTON_POSITIVE: 
			dialog.cancel();
			callback.confirm();
			break;
		case DialogInterface.BUTTON_NEGATIVE: 
			dialog.cancel();
			callback.cancel();
			break;	
			
		default:
			break;
		}
		
	}

}
