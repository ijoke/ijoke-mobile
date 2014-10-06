package br.com.ijoke.utils;

import br.com.ijoke.activity.callback.DialogCallback;
import br.com.ijoke.activity.listerner.ButtonDialogClickListener;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;


/**
 * 
 * @author Wagner jeronimo
 *
 */
public class AndroidUtils {
	
	public static Intent openActivity(Activity context, Class<?> activity ){
		Intent i = new Intent(context, activity);
		context.startActivityForResult(i, 1);
		return i;
	}
	
	
	public static void showMessageDlg(String title, String msg, Context context){
		AlertDialog alertDialog = new AlertDialog.Builder(context).create();
		alertDialog.setTitle(title);
		alertDialog.setMessage(msg);
		alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK", new OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.cancel();
			}
		});
		alertDialog.show();
	}
	
	public static void showConfirmDlg(String title, String msg, Context context, DialogCallback callback ){
		AlertDialog alertDialog = new AlertDialog.Builder(context).create();
		alertDialog.setTitle(title);
		alertDialog.setMessage(msg);
		OnClickListener listener = new ButtonDialogClickListener(callback);
		alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Sim",listener);
		alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Não", listener);
		alertDialog.show();
	}
	

}
