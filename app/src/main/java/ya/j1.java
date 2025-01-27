package ya;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import com.martian.mibook.R;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.lib.model.data.MiReadingRecord;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.mvvm.tts.TTSReadManager;
import l9.m0;

/* loaded from: classes3.dex */
public class j1 {

    /* renamed from: a */
    public static final int f33256a = 888;

    public class a implements m0.c {

        /* renamed from: a */
        public final /* synthetic */ Context f33257a;

        /* renamed from: b */
        public final /* synthetic */ MiReadingRecord f33258b;

        public a(Context context, MiReadingRecord miReadingRecord) {
            this.f33257a = context;
            this.f33258b = miReadingRecord;
        }

        @Override // l9.m0.c
        public void a(Drawable drawable) {
            j1.this.c(this.f33257a, drawable instanceof BitmapDrawable ? ((BitmapDrawable) drawable).getBitmap() : null, this.f33258b);
        }

        @Override // l9.m0.c
        public void onError() {
            j1.this.c(this.f33257a, null, this.f33258b);
        }
    }

    public void b(Context context) {
        MiReadingRecord Z;
        if (TTSReadManager.q()) {
            return;
        }
        try {
            if (ba.h.e(context) && (Z = MiConfigSingleton.b2().M1().Z()) != null) {
                Book I = MiConfigSingleton.b2().M1().I(vb.e.l(Z.getSourceString()));
                if (I != null && !ba.l.q(I.getCover())) {
                    l9.m0.E(context, I.getCover(), new a(context, Z));
                }
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public final void c(Context context, Bitmap bitmap, MiReadingRecord miReadingRecord) {
        if (context == null) {
            return;
        }
        Intent b10 = kc.b.b(context);
        b10.setFlags(268435456);
        PendingIntent activities = PendingIntent.getActivities(context, 0, new Intent[]{b10, kc.b.c(context, miReadingRecord.getSourceString())}, 134217728);
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.remoteview_book_item_small);
        remoteViews.setTextViewText(R.id.remoteview_title, miReadingRecord.getBookName());
        remoteViews.setTextViewText(R.id.remoteview_chapter, miReadingRecord.getChapterTitle());
        if (bitmap != null) {
            remoteViews.setImageViewBitmap(R.id.remoteview_cover, bitmap);
        }
        Notification build = new NotificationCompat.Builder(context, "reading_record").setSmallIcon(R.drawable.ic_launcher).setContent(remoteViews).setCustomContentView(remoteViews).setPriority(1).setContentIntent(activities).setSound(null).setVibrate(new long[]{0}).setDefaults(8).build();
        build.flags = 16;
        NotificationManagerCompat.from(context).notify(f33256a, build);
    }
}
