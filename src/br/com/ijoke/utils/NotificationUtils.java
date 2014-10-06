package br.com.ijoke.utils;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import br.com.ijoke.R;

public class NotificationUtils {

	
	 // Exibe a notificacao
    public static void criarNotificacao(Context context, CharSequence mensagemBarraStatus,
            CharSequence titulo, CharSequence mensagem, Class<?> activity) {
        // Recupera o serviço do NotificationManager
        NotificationManager nm = (NotificationManager) context.getSystemService(Activity.NOTIFICATION_SERVICE);
        
        // PendingIntent para executar a Activity se o usuário selecionar a notificação
        PendingIntent p = PendingIntent.getActivity(context, 0, new Intent(context, activity), 0);
        
        Notification n = new Notification.Builder(context)
        .setSmallIcon(R.drawable.ic_launcher)
        .setTicker(mensagemBarraStatus)
        .setWhen(System.currentTimeMillis())
        .setContentIntent(p)
        .setContentTitle(titulo)
        .setContentText(mensagem)
        .build();
        
        
 
        // Flag utilizada para remover a notificação da barra de status
        // quando o usuário clicar nela
        n.flags |= Notification.FLAG_AUTO_CANCEL;
 
        // Espera 100ms e vibra por 250ms, espera por mais 100ms e vibra por 500ms
        n.vibrate = new long[] { 100, 250, 100, 500 };
 
        // id da notificacao
        nm.notify(R.string.app_name, n);
    }
 
	
}
