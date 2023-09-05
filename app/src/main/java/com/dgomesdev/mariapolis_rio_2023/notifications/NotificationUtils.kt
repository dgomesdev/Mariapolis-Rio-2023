package com.dgomesdev.mariapolis_rio_2023.notifications

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.dgomesdev.mariapolis_rio_2023.R
import com.dgomesdev.mariapolis_rio_2023.presentation.MainActivity

const val NOTIFICATION_REQUEST_CODE = 0
fun Context.showNotification(
    notificationTitle: String,
    notificationText: String,
    channelId: String,
    channelName: String,
    bigPicture: Bitmap
) {
    val contentPendingIntent = PendingIntent.getActivity(
        this,
        NOTIFICATION_REQUEST_CODE,
        Intent(this, MainActivity::class.java),
        PendingIntent.FLAG_IMMUTABLE
    )

    val notificationBuilder = NotificationCompat
        .Builder(
        this,
        channelId
    )
        .setSmallIcon(R.drawable.mariapolis_logo)
        .setContentTitle(notificationTitle)
        .setContentText(notificationText)
        .setContentIntent(contentPendingIntent)
        .setAutoCancel(true)
        .setPriority(NotificationCompat.PRIORITY_HIGH)
        .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
        .setStyle(
            if (channelName == "Time Out") NotificationCompat.BigPictureStyle().bigPicture(bigPicture) else NotificationCompat.BigTextStyle()
        )

    if (ActivityCompat.checkSelfPermission(
            this,
            Manifest.permission.POST_NOTIFICATIONS
        ) != PackageManager.PERMISSION_GRANTED
    ) {
        return
    }

    val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    notificationManager.createNotificationChannel(NotificationChannel(
        channelId,
        channelName,
        NotificationManager.IMPORTANCE_HIGH
    ))

    NotificationManagerCompat.from(this).notify(NOTIFICATION_REQUEST_CODE, notificationBuilder.build())
}