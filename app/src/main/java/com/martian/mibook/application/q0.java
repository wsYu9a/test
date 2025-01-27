package com.martian.mibook.application;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import com.martian.libcomm.utils.GsonUtils;
import com.martian.mibook.activity.reader.ReadingActivity;
import com.martian.mibook.data.book.ContentProperty;
import com.martian.mibook.j.t2;
import com.martian.mibook.lib.model.data.MiReadingRecord;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.service.TtsService;
import com.martian.ttbookhd.R;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;

/* loaded from: classes.dex */
public class q0 {

    /* renamed from: a */
    public static final String f11578a = "EXTRA_BOOK_ID";

    /* renamed from: b */
    public static final int f11579b = 888;

    /* renamed from: c */
    private boolean f11580c;

    /* renamed from: d */
    private String f11581d;

    /* loaded from: classes3.dex */
    private static class a extends AsyncTask<String, Void, Bitmap> {

        /* renamed from: a */
        private final MiReadingRecord f11582a;

        public a(final MiReadingRecord record) {
            this.f11582a = record;
        }

        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Bitmap doInBackground(String... params) {
            return t2.a(params[0]);
        }

        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onPostExecute(final Bitmap bitmap) {
            Context applicationContext = com.martian.libmars.d.h.F().getApplicationContext();
            if (bitmap == null || applicationContext == null) {
                return;
            }
            Intent intent = new Intent(applicationContext, (Class<?>) ReadingActivity.class);
            intent.putExtra(q0.f11578a, this.f11582a.getSourceString());
            intent.setFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
            PendingIntent activity = PendingIntent.getActivity(applicationContext, 0, intent, 134217728);
            RemoteViews remoteViews = new RemoteViews(applicationContext.getPackageName(), R.layout.remoteview_book_item_small);
            remoteViews.setTextViewText(R.id.remoteview_title, this.f11582a.getBookName());
            remoteViews.setTextViewText(R.id.remoteview_chapter, this.f11582a.getChapterTitle());
            remoteViews.setImageViewBitmap(R.id.remoteview_cover, bitmap);
            Notification build = new NotificationCompat.Builder(applicationContext, applicationContext.getString(R.string.reading_record_channel_id)).setSmallIcon(R.drawable.ic_launcher).setContent(remoteViews).setCustomContentView(remoteViews).setPriority(1).setContentIntent(activity).setSound(null).setVibrate(new long[]{0}).setDefaults(8).build();
            build.flags = 16;
            NotificationManagerCompat.from(applicationContext).notify(888, build);
        }
    }

    public void a(final Context context) {
        MiReadingRecord k0;
        Book S;
        if (e()) {
            return;
        }
        try {
            if (com.martian.libsupport.f.d(context) && (k0 = MiConfigSingleton.V3().l3().k0()) != null && (S = MiConfigSingleton.V3().l3().S(com.martian.mibook.lib.model.manager.d.k(k0.getSourceString()))) != null && !com.martian.libsupport.k.p(S.getCover())) {
                new a(k0).execute(S.getCover());
            }
        } catch (Exception unused) {
        }
    }

    public void b(Context context, String ss, ContentProperty contentProperty) {
        if (this.f11580c) {
            c(context);
        }
        this.f11580c = true;
        this.f11581d = ss;
        try {
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString(MiConfigSingleton.G0, ss);
            bundle.putString(MiConfigSingleton.H0, GsonUtils.b().toJson(contentProperty));
            intent.setFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
            intent.setClass(context, TtsService.class);
            intent.putExtras(bundle);
            context.startService(intent);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void c(Context context) {
        if (this.f11580c) {
            this.f11580c = false;
            this.f11581d = "";
            context.stopService(new Intent(context, (Class<?>) TtsService.class));
        }
    }

    public String d() {
        return this.f11581d;
    }

    public boolean e() {
        return this.f11580c && !com.martian.libsupport.k.p(this.f11581d);
    }

    public boolean f(String ss) {
        return this.f11580c && !com.martian.libsupport.k.p(this.f11581d) && this.f11581d.equalsIgnoreCase(ss);
    }
}
