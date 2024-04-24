package com.example.happyuapp;
import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

import androidx.core.app.NotificationCompat;

import java.util.Calendar;

public class NotificationScheduler extends BroadcastReceiver {
    private static final int NOTIFICATION_ID_MOTIVATION = 1;
    private static final int NOTIFICATION_ID_RECOMMANDATION = 2;
    private static final String CHANNEL_ID = "MyChannel";

    @Override
    public void onReceive(Context context, Intent intent) {
        if ("com.example.notification.TEST_NOTIFICATION".equals(intent.getAction())) {
            // C'est la notification planifiée toutes les 2 heures
            showMotivationNotification(context);
        } else {
            // C'est la notification de recommandation
            showRecommandationNotification(context);
        }
    }

    public void scheduleNotification(Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

        Intent intentMotivation = new Intent(context, NotificationScheduler.class);
        intentMotivation.setAction("com.example.notification.TEST_NOTIFICATION");
        PendingIntent pendingIntentMotivation = PendingIntent.getBroadcast(context, 0, intentMotivation, PendingIntent.FLAG_UPDATE_CURRENT);

        // Set the alarm to start at 2-hour intervals
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR_OF_DAY, 2);

        alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                AlarmManager.INTERVAL_HOUR * 2, pendingIntentMotivation);

        // Schedule recommandation notification for once a day
        scheduleRecommandationNotification(context);
    }

    private void showMotivationNotification(Context context) {
        String[] motivationMessages = {
                "Consultez votre état de santé aujourd'hui.",
                "Prenez quelques minutes pour méditer et calmer votre esprit.",
                "Faites une activité que vous aimez pour améliorer votre humeur.",
                "Planifiez une pause bien méritée pour vous ressourcer.",
                "Pensez à vos objectifs et planifiez des actions pour les atteindre."

        };

        int randomIndex = (int) (Math.random() * motivationMessages.length);
        String selectedMotivation = motivationMessages[randomIndex];

        showNotification(context, NOTIFICATION_ID_MOTIVATION,
                "Motivation du jour", selectedMotivation);
    }

    private void scheduleRecommandationNotification(Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

        Intent intentRecommandation = new Intent(context, NotificationScheduler.class);
        PendingIntent pendingIntentRecommandation = PendingIntent.getBroadcast(context, 1, intentRecommandation, PendingIntent.FLAG_UPDATE_CURRENT);

        // Set the alarm to start at midnight and repeat once a day
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 14);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.add(Calendar.DAY_OF_MONTH, 1);

        alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                AlarmManager.INTERVAL_DAY, pendingIntentRecommandation);
    }

    private void showRecommandationNotification(Context context) {
        showNotification(context, NOTIFICATION_ID_RECOMMANDATION,
                "Recommandation du jour", "Bonjour! Veuillez consulter votre état aujourd'hui s'il vous plaît.");
    }


    private void showNotification(Context context, int notificationId, String title, String content) {
        // Créer un Intent pour ouvrir votre activité principale
        Intent intent = new Intent(context, Notification.class);
        intent.putExtra("notification_title", title); // Ajouter le titre de la notification en tant que donnée supplémentaire
        intent.putExtra("notification_content", content); // Ajouter le contenu de la notification en tant que donnée supplémentaire
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        // Créer la notification
        createNotificationChannel(context);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.drawable.img) // Spécifier l'icône de l'application
                .setContentTitle(title)
                .setContentText(content)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pendingIntent) // Définir le PendingIntent pour l'ouverture de l'activité
                .setAutoCancel(true);

        // Afficher la notification
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(notificationId, builder.build());
    }



    private void createNotificationChannel(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "My Channel";
            String description = "Channel for well-being notifications";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;

            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);

            NotificationManager notificationManager = context.getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}