package com.dgomesdev.mariapolis_rio_2023.notifications

import android.content.Context
import android.graphics.BitmapFactory
import android.util.Log
import androidx.work.Data
import androidx.work.OneTimeWorkRequest
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.Worker
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import com.dgomesdev.mariapolis_rio_2023.R
import java.util.Calendar
import java.util.concurrent.TimeUnit

private const val NOTIFICATION_TITLE_KEY = "NOTIFICATION_TITLE_KEY"
private const val NOTIFICATION_CONTENT_KEY = "NOTIFICATION_CONTENT_KEY"
private const val NOTIFICATION_CHANNEL_ID = "NOTIFICATION_CHANNEL_ID"
private const val NOTIFICATION_CHANNEL_NAME = "NOTIFICATION_CHANNEL_NAME"
private const val BIG_PICTURE = "BIG_PICTURE"

class NotificationWorker(
    private val context: Context,
    workerParams: WorkerParameters,
) : Worker(context, workerParams) {
    override fun doWork(): Result {
        val title = inputData.getString(NOTIFICATION_TITLE_KEY)
            ?: throw IllegalArgumentException("title is required")
        val content = inputData.getString(NOTIFICATION_CONTENT_KEY)
            ?: throw IllegalArgumentException("content is required")
        val channelId = inputData.getString(NOTIFICATION_CHANNEL_ID)
            ?: throw IllegalArgumentException("channel id is required")
        val channelName = inputData.getString(NOTIFICATION_CHANNEL_NAME)
            ?: throw IllegalArgumentException("channel name is required")
        val bigPicture = inputData.getInt(BIG_PICTURE, R.drawable.mariapolis_logo)

        Log.d("NOTIFICATION", "Notification triggered with title: $title, content: $bigPicture")

        context.showNotification(
            title,
            content,
            channelId,
            channelName,
            BitmapFactory.decodeResource(context.resources, bigPicture)
        )
        return Result.success()
    }

    companion object {
        fun enableProgrammeBeginningNotification(context: Context, dailyWord: String, day: Int) {
            val date = Calendar.getInstance()
            date.set(2023, 8, day, 7, 30)
            val now = Calendar.getInstance()
            val initialDelay = (date.timeInMillis/1000L) - (now.timeInMillis/1000L)
            if (initialDelay > 0L) {
                val notificationImage = R.drawable.mariapolis_logo
                val inputData = workDataOf(
                    NOTIFICATION_TITLE_KEY to "Bom dia! Veja a frase do dia",
                    NOTIFICATION_CONTENT_KEY to dailyWord,
                    NOTIFICATION_CHANNEL_ID to "$",
                    NOTIFICATION_CHANNEL_NAME to "Frase do dia",
                    BIG_PICTURE to notificationImage
                )
                WorkManager.getInstance(context)
                    .enqueue(buildOneTimeRequest(initialDelay, inputData))
                Log.d("NOTIFICATION", "Frase do dia $day daqui a ${initialDelay/60/60} horas")
            }
        }

        fun enableTimeOutNotification(context: Context, day: Int) {
            val date = Calendar.getInstance()
            date.set(2023, 8, day, 12, 0)
            val now = Calendar.getInstance()
            val initialDelay = (date.timeInMillis/1000L) - (now.timeInMillis/1000L)
            if (initialDelay > 0L) {
                val notificationImage = R.drawable.timeout
                val inputData = workDataOf(
                    NOTIFICATION_TITLE_KEY to "Hora do Time Out",
                    NOTIFICATION_CONTENT_KEY to "Vamos rezar o Time Out",
                    NOTIFICATION_CHANNEL_ID to "2",
                    NOTIFICATION_CHANNEL_NAME to "Time Out",
                    BIG_PICTURE to notificationImage
                )
                WorkManager.getInstance(context)
                    .enqueue(buildOneTimeRequest(initialDelay, inputData))
                Log.d("NOTIFICATION", "Time Out do dia $day set with ${initialDelay/60/60} horas")
            }
        }

        private fun buildOneTimeRequest(
            initialDelay: Long,
            inputData: Data
        ): OneTimeWorkRequest =
            OneTimeWorkRequestBuilder<NotificationWorker>()
                .setInitialDelay(initialDelay, TimeUnit.SECONDS)
                .setInputData(inputData)
                .build()
    }
}