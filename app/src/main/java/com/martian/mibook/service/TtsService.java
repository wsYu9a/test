package com.martian.mibook.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.PowerManager;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import com.martian.libcomm.utils.GsonUtils;
import com.martian.libmars.utils.w0;
import com.martian.libsupport.k;
import com.martian.libsupport.l;
import com.martian.mibook.activity.reader.ReadingActivity;
import com.martian.mibook.application.MiBookManager;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.application.l0;
import com.martian.mibook.application.q0;
import com.martian.mibook.data.book.ContentProperty;
import com.martian.mibook.h.f;
import com.martian.mibook.j.t2;
import com.martian.mibook.lib.model.data.MiReadingContent;
import com.martian.mibook.lib.model.data.MiReadingRecord;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.lib.model.data.abs.Chapter;
import com.martian.mibook.lib.model.data.abs.ChapterContent;
import com.martian.mibook.lib.model.data.abs.ChapterList;
import com.martian.mibook.tts.TTSController;
import com.martian.ttbookhd.R;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import java.lang.ref.WeakReference;

/* loaded from: classes4.dex */
public class TtsService extends Service implements f.a {

    /* renamed from: a */
    public static final String f14100a = "tts_action";

    /* renamed from: b */
    public static final String f14101b = "tts_action_play";

    /* renamed from: c */
    public static final String f14102c = "tts_action_previous";

    /* renamed from: d */
    public static final String f14103d = "tts_action_next";

    /* renamed from: e */
    public static final String f14104e = "tts_action_close";

    /* renamed from: f */
    public static final String f14105f = "tts_action_speed";

    /* renamed from: g */
    public static final String f14106g = "tts_action_timer";

    /* renamed from: h */
    public static final String f14107h = "tts_action_setting";

    /* renamed from: i */
    public static final String f14108i = "tts_action_sync";

    /* renamed from: j */
    public static final String f14109j = "tts_action_position";
    public static final String k = "tts_action_end_position";
    public static final String l = "tts_action_sync_reader_position";
    public static final String m = "tts_action_sync_tts_position";
    public static final String n = "tts_to_activity_notification";
    public static final String o = "tts_to_activity_chapter_index";
    public static final String p = "tts_to_activity_content_index";
    public static final String q = "tts_to_activity_source_string";
    public static final String r = "tts_to_activity_play";
    public static final String s = "tts_to_activity_pause";
    public static final String t = "tts_to_activity_exit";
    public static final String u = "tts_to_activity_position";
    public static final String v = "tts_to_activity_timer";
    public static final String w = "tts_to_activity_control";
    private static final int x = 88108;
    private static final int y = -2;
    private static final int z = -3;
    private com.martian.mibook.h.f A;
    private Book C;
    private MiReadingRecord D;
    private String E;
    private ChapterList F;
    private TTSController G;
    private MiReadingContent H;
    private MiReadingContent I;
    private MiReadingContent J;
    private ContentProperty K;
    private int L;
    private int P;
    private boolean R;
    private Handler S;
    private Runnable T;
    private Bitmap V;
    private RemoteViews W;
    private Notification X;
    private AudioManager Z;
    private AudioManager.OnAudioFocusChangeListener a0;
    private PowerManager.WakeLock B = null;
    private int M = -2;
    private int N = -1;
    private long O = -1;
    private int Q = -2;
    private long U = -1;
    private boolean Y = false;
    private BroadcastReceiver b0 = new d();

    class a extends com.martian.mibook.lib.model.d.f {
        a() {
        }

        @Override // com.martian.mibook.lib.model.d.f
        public void a(boolean loading) {
        }

        @Override // com.martian.mibook.lib.model.d.f
        public void c(ChapterList chapterList) {
            if (chapterList == null || chapterList.getCount() == 0) {
                TtsService.this.z();
            } else {
                TtsService.this.F = chapterList;
                TtsService.this.E();
            }
        }

        @Override // com.martian.mibook.lib.model.d.f
        public void d(b.d.c.b.c errorResult) {
            TtsService.this.z();
        }
    }

    class b extends com.martian.mibook.lib.model.d.f {
        b() {
        }

        @Override // com.martian.mibook.lib.model.d.f
        public void a(boolean loading) {
        }

        @Override // com.martian.mibook.lib.model.d.f
        public void c(ChapterList chapterList) {
            if (chapterList == null || chapterList.getCount() == 0) {
                TtsService.this.a0("获取章节内容失败");
            } else {
                TtsService.this.F = chapterList;
                TtsService.this.E();
            }
        }

        @Override // com.martian.mibook.lib.model.d.f
        public void d(b.d.c.b.c errorResult) {
            TtsService.this.a0("获取 内容失败");
        }
    }

    class c implements TTSController.b {
        c() {
        }

        @Override // com.martian.mibook.tts.TTSController.b
        public void a() {
            TtsService.this.G.t(MiConfigSingleton.V3().z4());
            TtsService.this.R();
            TtsService.this.d0();
        }

        @Override // com.martian.mibook.tts.TTSController.b
        public void b() {
            TtsService.this.a0("听书出错");
            if (TtsService.this.G.q()) {
                TtsService.this.L();
            }
            TtsService.this.f();
        }

        @Override // com.martian.mibook.tts.TTSController.b
        public void c(final boolean moveForward) {
            if (TtsService.this.O < 0 || System.currentTimeMillis() - TtsService.this.O >= 3000) {
                TtsService.this.I();
            } else if (TtsService.this.G.q()) {
                TtsService.this.L();
            }
        }

        @Override // com.martian.mibook.tts.TTSController.b
        public void d() {
            TtsService.this.a0("听书启动失败");
            TtsService.this.f();
        }
    }

    class d extends BroadcastReceiver {
        d() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.media.AUDIO_BECOMING_NOISY".equals(intent.getAction()) && TtsService.this.G != null && TtsService.this.G.n()) {
                TtsService.this.j();
            }
        }
    }

    private static class e extends AsyncTask<String, Void, Bitmap> {

        /* renamed from: a */
        private final WeakReference<TtsService> f14114a;

        public e(TtsService service) {
            this.f14114a = new WeakReference<>(service);
        }

        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Bitmap doInBackground(String... params) {
            return t2.a(params[0]);
        }

        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onPostExecute(final Bitmap bitmap) {
            TtsService ttsService = this.f14114a.get();
            if (ttsService != null) {
                ttsService.Z(bitmap);
                ttsService.b0();
            }
        }
    }

    private class f implements com.martian.mibook.lib.model.d.e {

        /* renamed from: a */
        private final MiReadingContent f14115a;

        public f(MiReadingContent content) {
            this.f14115a = content;
        }

        @Override // com.martian.mibook.lib.model.d.e
        public void a(Chapter chapter, String shortContent) {
            this.f14115a.setChapter(chapter);
            if (!k.p(shortContent)) {
                this.f14115a.setShortContent(shortContent);
            }
            this.f14115a.setUnBounght();
        }

        @Override // com.martian.mibook.lib.model.d.e
        public void b(ChapterContent chapterContent) {
        }

        @Override // com.martian.mibook.lib.model.d.e
        public void c(ChapterContent chapterContent) {
            if (chapterContent == null) {
                return;
            }
            this.f14115a.setTitle(chapterContent.getTitle());
            this.f14115a.setChapterContent(chapterContent);
            MiBookManager.c2(this.f14115a, TtsService.this.K);
            this.f14115a.setReady();
            if (TtsService.this.M == -2 || TtsService.this.M == -3) {
                if (TtsService.this.N >= 0) {
                    TtsService.this.M = r4.N - 1;
                    TtsService.this.N = -1;
                } else {
                    TtsService.this.M = -1;
                }
                TtsService.this.I();
                if (TtsService.this.M == -3) {
                    TtsService.this.c();
                }
            }
        }

        @Override // com.martian.mibook.lib.model.d.e
        public void onLoading(boolean loading) {
            if (loading) {
                this.f14115a.setLoading();
            }
        }

        @Override // com.martian.mibook.lib.model.d.e
        public void onResultError(b.d.c.b.c errorResult) {
            this.f14115a.setError();
            this.f14115a.setErrCode(Integer.valueOf(errorResult.c()));
            this.f14115a.setErrMsg(errorResult.d());
            this.f14115a.setStackTrace(errorResult.e());
        }
    }

    private void B() {
        MiConfigSingleton.V3().l3().p(this.C, new a());
    }

    private Intent C(String action) {
        Intent intent = new Intent(f14100a);
        intent.putExtra(f14100a, action);
        return intent;
    }

    public void E() {
        this.K.setChapterSize(this.F.getCount());
        this.L = this.K.getChapterIndex();
        this.N = this.K.getContentIndex();
        O();
        l0.b().c(this);
        this.G = new TTSController(this, new c());
    }

    private boolean F() {
        int i2 = this.L;
        int i3 = this.P;
        if (i2 == i3 && this.M == this.Q + 1) {
            return true;
        }
        return i2 == i3 + 1 && this.R && this.M == 0;
    }

    /* renamed from: G */
    public /* synthetic */ void H(int i2) {
        if (i2 == -2 || i2 == -1) {
            if (this.G.q()) {
                L();
            }
        } else if (i2 == 1 && this.G.r()) {
            M();
        }
    }

    private void J() {
        this.L++;
        this.M = -3;
        this.H.reset();
        MiReadingContent miReadingContent = this.I;
        MiReadingContent miReadingContent2 = this.J;
        this.I = miReadingContent2;
        this.J = this.H;
        this.H = miReadingContent;
        if (miReadingContent2.isReady()) {
            this.M = -1;
        }
        I();
    }

    private void K() {
        this.L--;
        this.M = -3;
        this.J.reset();
        MiReadingContent miReadingContent = this.I;
        MiReadingContent miReadingContent2 = this.H;
        this.I = miReadingContent2;
        this.H = this.J;
        this.J = miReadingContent;
        if (miReadingContent2.isReady()) {
            this.M = -1;
        }
        I();
    }

    private void N() {
        if (!this.J.isEmpty() || this.L >= this.F.getCount() - 1) {
            return;
        }
        this.J.setChapterIndex(this.L + 1);
        g0(this.J);
    }

    private void O() {
        if (this.Y) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.media.AUDIO_BECOMING_NOISY");
        registerReceiver(this.b0, intentFilter);
        this.Y = true;
    }

    private void P() {
        AudioManager audioManager = this.Z;
        if (audioManager != null) {
            audioManager.abandonAudioFocus(this.a0);
            this.Z = null;
            this.a0 = null;
        }
    }

    private void Q() {
        PowerManager.WakeLock wakeLock = this.B;
        if (wakeLock != null) {
            wakeLock.release();
            this.B = null;
        }
    }

    public void R() {
        if (this.Z == null) {
            this.Z = (AudioManager) getSystemService("audio");
            this.a0 = new AudioManager.OnAudioFocusChangeListener() { // from class: com.martian.mibook.service.a
                @Override // android.media.AudioManager.OnAudioFocusChangeListener
                public final void onAudioFocusChange(int i2) {
                    TtsService.this.H(i2);
                }
            };
        }
        this.Z.requestAudioFocus(this.a0, 3, 1);
    }

    private void S() {
        this.H = new MiReadingContent();
        this.I = new MiReadingContent();
        this.J = new MiReadingContent();
        I();
    }

    private void T() {
        if (this.C != null) {
            if (this.D == null) {
                this.D = MiConfigSingleton.V3().l3().W(this.C.getSourceString());
            }
            MiReadingRecord miReadingRecord = this.D;
            if (miReadingRecord != null) {
                miReadingRecord.setChapterIndex(Integer.valueOf(this.L));
                this.D.setContentIndex(Integer.valueOf(this.M));
                this.D.setWithAd(false);
                MiConfigSingleton.V3().l3().V0(this.C, this.D);
            }
        }
    }

    public static void U(Context context, String action) {
        V(context, action, 0L);
    }

    public static void V(Context context, String action, long value) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent(f14100a);
        if (l.p()) {
            intent.setFlags(67108864);
        }
        intent.putExtra(f14100a, action);
        if (f14105f.equalsIgnoreCase(action)) {
            intent.putExtra(f14105f, value);
        }
        if (f14106g.equalsIgnoreCase(action)) {
            intent.putExtra(f14106g, value);
        }
        context.sendBroadcast(intent);
    }

    public static void W(Context context, String action, int chapterIndex, int contentIndex, int contentSize, boolean sync) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent(f14100a);
        intent.putExtra(f14100a, action);
        intent.putExtra(o, chapterIndex);
        intent.putExtra(p, contentIndex);
        intent.putExtra(k, contentIndex == contentSize - 1);
        intent.putExtra(l, sync);
        context.sendBroadcast(intent);
    }

    private void X(String action) {
        Y(action, false);
    }

    private void Y(String action, boolean manual) {
        if (!u.equalsIgnoreCase(action) || manual || F()) {
            Intent intent = new Intent(n);
            intent.putExtra(n, action);
            if (u.equalsIgnoreCase(action) || t.equalsIgnoreCase(action)) {
                intent.putExtra(o, this.L);
                intent.putExtra(p, this.M);
                intent.putExtra(q, this.E);
            } else if (v.equalsIgnoreCase(action)) {
                intent.putExtra(v, this.U);
            } else if (w.equalsIgnoreCase(action)) {
                intent.putExtra(w, manual || (this.L == this.P && this.M == this.Q));
            }
            sendBroadcast(intent);
        }
    }

    public void a0(String errMsg) {
        w0.a(this, errMsg);
    }

    public void b0() {
        NotificationManager notificationManager;
        Intent intent = new Intent(getApplicationContext(), (Class<?>) ReadingActivity.class);
        intent.putExtra(q0.f11578a, this.E);
        intent.setFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        PendingIntent activity = PendingIntent.getActivity(getApplicationContext(), 0, intent, 134217728);
        RemoteViews remoteViews = new RemoteViews(getApplicationContext().getPackageName(), R.layout.remoteview_book_tts_item);
        this.W = remoteViews;
        MiReadingContent miReadingContent = this.I;
        remoteViews.setTextViewText(R.id.tts_desc, miReadingContent == null ? "" : miReadingContent.getTitle());
        RemoteViews remoteViews2 = this.W;
        Book book = this.C;
        remoteViews2.setTextViewText(R.id.tts_name, book != null ? book.getBookName() : "");
        int i2 = this.L;
        if (i2 == 0) {
            this.W.setImageViewResource(R.id.tts_pre_chapter, R.drawable.tts_pre_chapter_unclickable);
        } else if (i2 == this.K.getChapterSize() - 1) {
            this.W.setImageViewResource(R.id.tts_next_chapter, R.drawable.tts_next_chapter_unclickable);
        }
        this.W.setOnClickPendingIntent(R.id.tts_play, PendingIntent.getBroadcast(getApplicationContext(), 0, C(f14101b), 134217728));
        this.W.setOnClickPendingIntent(R.id.tts_pre_chapter, PendingIntent.getBroadcast(getApplicationContext(), 1, C(f14102c), 134217728));
        this.W.setOnClickPendingIntent(R.id.tts_next_chapter, PendingIntent.getBroadcast(getApplicationContext(), 2, C(f14103d), 134217728));
        this.W.setOnClickPendingIntent(R.id.tts_close, PendingIntent.getBroadcast(getApplicationContext(), 3, C(f14104e), 134217728));
        Bitmap bitmap = this.V;
        if (bitmap == null || bitmap.isRecycled()) {
            this.W.setImageViewResource(R.id.tts_cover, R.drawable.cover_default);
        } else {
            this.W.setImageViewBitmap(R.id.tts_cover, this.V);
        }
        String string = getApplicationContext().getString(R.string.tts_channel_id);
        if (l.A() && (notificationManager = (NotificationManager) getSystemService(NotificationManager.class)) != null && notificationManager.getNotificationChannel(string) == null) {
            return;
        }
        Notification build = new NotificationCompat.Builder(getApplicationContext(), string).setSmallIcon(R.drawable.ic_launcher).setContent(this.W).setCustomContentView(this.W).setPriority(1).setContentIntent(activity).setSound(null).setVibrate(new long[]{0}).setDefaults(64).build();
        this.X = build;
        build.flags = 2;
        c0();
    }

    private void c0() {
        try {
            Notification notification = this.X;
            if (notification != null) {
                startForeground(x, notification);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void d0() {
        Book book;
        Bitmap bitmap;
        if (this.A == null) {
            this.A = new com.martian.mibook.h.f();
        }
        this.A.a(getApplicationContext(), this);
        S();
        if (!com.martian.libsupport.f.d(this) || (book = this.C) == null || k.p(book.getCover()) || this.C.isLocal() || !((bitmap = this.V) == null || bitmap.isRecycled())) {
            b0();
        } else {
            new e(this).execute(this.C.getCover());
        }
    }

    private void e0() {
        f0();
        long j2 = this.U;
        if (j2 < 0 || j2 < System.currentTimeMillis()) {
            return;
        }
        if (this.S == null) {
            this.S = new Handler();
        }
        if (this.T == null) {
            this.T = new Runnable() { // from class: com.martian.mibook.service.b
                @Override // java.lang.Runnable
                public final void run() {
                    TtsService.this.f();
                }
            };
        }
        this.S.postDelayed(this.T, this.U - System.currentTimeMillis());
    }

    private void f0() {
        Runnable runnable;
        Handler handler = this.S;
        if (handler == null || (runnable = this.T) == null) {
            return;
        }
        handler.removeCallbacks(runnable);
    }

    private void h0() {
        PowerManager.WakeLock wakeLock = this.B;
        if (wakeLock == null || !wakeLock.isHeld()) {
            y();
        }
    }

    private void i0() {
        try {
            BroadcastReceiver broadcastReceiver = this.b0;
            if (broadcastReceiver != null) {
                unregisterReceiver(broadcastReceiver);
                this.b0 = null;
            }
        } catch (Exception unused) {
        }
    }

    private void k0(int speed) {
        if (this.G == null) {
            return;
        }
        MiConfigSingleton.V3().N6(speed);
        this.G.t(speed);
        if (this.G.q()) {
            this.G.r();
        }
    }

    private void y() {
        try {
            Q();
            if (this.B == null) {
                this.B = ((PowerManager) getSystemService("power")).newWakeLock(536870913, getClass().getName());
            }
            this.B.setReferenceCounted(false);
            this.B.acquire(1200000L);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void z() {
        MiConfigSingleton.V3().l3().o(this.C, true, false, new b());
    }

    public void A() {
        if (!this.I.isReady() || this.M >= this.I.getEndPosSize() - 1) {
            J();
            return;
        }
        int i2 = this.M + 1;
        this.M = i2;
        if (i2 == 0) {
            this.G.x(this.I.getTitle() + "。" + this.I.getContent(this.M), true);
            j0();
        } else {
            this.G.x(this.I.getContent(i2), true);
        }
        this.O = System.currentTimeMillis();
        X(u);
        if (this.L == this.P && this.M == this.Q) {
            Y(w, true);
        }
        if (this.M == this.I.getEndPosSize() - 2) {
            N();
        }
        if (this.G.n()) {
            M();
        }
        T();
        h0();
    }

    public boolean D() {
        int i2;
        int i3;
        ChapterList chapterList = this.F;
        if (chapterList == null || (i2 = this.L) < 0 || i2 >= chapterList.getCount()) {
            f();
            return false;
        }
        MiReadingContent miReadingContent = this.I;
        if (miReadingContent == null || miReadingContent.isLoading()) {
            return false;
        }
        if (!this.I.isEmpty()) {
            return (this.I.isReady() && ((i3 = this.M) == -2 || i3 == -3)) ? false : true;
        }
        this.I.setChapterIndex(this.L);
        g0(this.I);
        return false;
    }

    public void I() {
        if (D()) {
            A();
        } else if (this.G.z()) {
            L();
        }
    }

    public void L() {
        RemoteViews remoteViews = this.W;
        if (remoteViews != null) {
            remoteViews.setImageViewResource(R.id.tts_play, R.drawable.tts_play);
            c0();
        }
        X(s);
    }

    public void M() {
        RemoteViews remoteViews = this.W;
        if (remoteViews != null) {
            remoteViews.setImageViewResource(R.id.tts_play, R.drawable.tts_pause);
            c0();
        }
        X(r);
    }

    public void Z(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        this.V = bitmap;
    }

    @Override // com.martian.mibook.h.f.a
    public void a(long targetTime) {
        this.U = targetTime;
        e0();
    }

    @Override // com.martian.mibook.h.f.a
    public void b() {
        int i2;
        if (this.G == null || (i2 = this.L) < 0 || i2 >= this.F.getCount() - 1 || !this.G.z()) {
            return;
        }
        J();
        c();
    }

    @Override // com.martian.mibook.h.f.a
    public void c() {
        Y(u, true);
    }

    @Override // com.martian.mibook.h.f.a
    public void d(long speed) {
        k0((int) speed);
    }

    @Override // com.martian.mibook.h.f.a
    public void e() {
        if (this.G.y(this)) {
            return;
        }
        a0("未找到可用的选项");
    }

    @Override // com.martian.mibook.h.f.a
    public void f() {
        X(t);
        MiConfigSingleton.V3().H4.c(this);
    }

    @Override // com.martian.mibook.h.f.a
    public void g(int chapterIndex, int contentIndex, boolean endPosition, boolean syncPosition) {
        TTSController tTSController;
        this.P = chapterIndex;
        this.Q = contentIndex;
        this.R = endPosition;
        Y(w, syncPosition);
        if (syncPosition) {
            if ((chapterIndex == this.L && contentIndex == this.M) || (tTSController = this.G) == null || !tTSController.z()) {
                return;
            }
            this.L = chapterIndex;
            this.M = -2;
            this.N = contentIndex;
            S();
        }
    }

    public void g0(final MiReadingContent content) {
        if (content == null || this.C == null || this.F == null) {
            return;
        }
        MiConfigSingleton.V3().l3().n(this.C, this.F, content.getChapterIndex(), new f(content));
    }

    @Override // com.martian.mibook.h.f.a
    public void h() {
        if (this.U > System.currentTimeMillis()) {
            X(v);
        }
        if (this.G.n()) {
            X(r);
        } else {
            X(s);
        }
    }

    @Override // com.martian.mibook.h.f.a
    public void i() {
        int i2;
        if (this.G == null || (i2 = this.L) <= 0 || i2 > this.F.getCount() - 1 || !this.G.z()) {
            return;
        }
        K();
        c();
    }

    @Override // com.martian.mibook.h.f.a
    public void j() {
        if (this.G.n()) {
            if (this.G.q()) {
                L();
            }
        } else if (this.G.r()) {
            M();
        }
    }

    public void j0() {
        if (this.W != null) {
            MiReadingContent miReadingContent = this.I;
            if (miReadingContent != null && !k.p(miReadingContent.getTitle())) {
                this.W.setTextViewText(R.id.tts_desc, this.I.getTitle());
            }
            int i2 = this.L;
            if (i2 == 0) {
                this.W.setImageViewResource(R.id.tts_pre_chapter, R.drawable.tts_pre_chapter_unclickable);
                this.W.setImageViewResource(R.id.tts_next_chapter, R.drawable.tts_next_chapter);
            } else if (i2 == this.K.getChapterSize() - 1) {
                this.W.setImageViewResource(R.id.tts_pre_chapter, R.drawable.tts_pre_chapter);
                this.W.setImageViewResource(R.id.tts_next_chapter, R.drawable.tts_next_chapter_unclickable);
            } else {
                this.W.setImageViewResource(R.id.tts_pre_chapter, R.drawable.tts_pre_chapter);
                this.W.setImageViewResource(R.id.tts_next_chapter, R.drawable.tts_next_chapter);
            }
            c0();
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
    }

    @Override // android.app.Service
    public void onDestroy() {
        stopForeground(true);
        T();
        TTSController tTSController = this.G;
        if (tTSController != null) {
            tTSController.u();
        }
        com.martian.mibook.h.f fVar = this.A;
        if (fVar != null) {
            fVar.c(this);
            this.A = null;
        }
        Bitmap bitmap = this.V;
        if (bitmap != null) {
            bitmap.recycle();
            this.V = null;
        }
        this.C = null;
        this.D = null;
        this.E = "";
        this.F = null;
        this.N = -1;
        this.U = -1L;
        MiReadingContent miReadingContent = this.H;
        if (miReadingContent != null) {
            miReadingContent.reset();
        }
        MiReadingContent miReadingContent2 = this.I;
        if (miReadingContent2 != null) {
            miReadingContent2.reset();
        }
        MiReadingContent miReadingContent3 = this.J;
        if (miReadingContent3 != null) {
            miReadingContent3.reset();
        }
        this.X = null;
        this.W = null;
        Q();
        P();
        i0();
        f0();
        MiConfigSingleton.V3().H4.c(this);
        l0.b().f(this);
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        Bundle extras;
        if (intent == null || (extras = intent.getExtras()) == null) {
            return 1;
        }
        this.E = extras.getString(MiConfigSingleton.G0);
        this.K = (ContentProperty) GsonUtils.b().fromJson(extras.getString(MiConfigSingleton.H0), ContentProperty.class);
        if (!k.p(this.E) && this.K != null) {
            Book T = MiConfigSingleton.V3().l3().T(this.E);
            this.C = T;
            if (T == null) {
                return 1;
            }
            B();
        }
        return 1;
    }
}
