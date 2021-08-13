package com.example.mywidget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.widget.RemoteViews;

public class WidgetProvider extends AppWidgetProvider {
    private static final String TAG = "WidgetProvider";

    @Override
    public void onUpdate(Context context,
                         AppWidgetManager appWidgetManager,
                         int[] appWidgetIds) {

        Special totoroItem = new Special(R.string.totoro, R.drawable.totoro);
        int imageId = totoroItem.getImageId();
        String totoroName = context.getString(totoroItem.getNameId());

        for (int widgetId : appWidgetIds) {
            RemoteViews remoteViews = new RemoteViews(
                    context.getPackageName(), R.layout.widget_layout);
            remoteViews.setTextViewText(R.id.totoroImage, totoroName);
            remoteViews.setImageViewResource(R.id.totoroImage, imageId);
            appWidgetManager.updateAppWidget(widgetId, remoteViews);

        }

    }
}
