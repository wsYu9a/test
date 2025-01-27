package com.martian.ttbook.b.a.q;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.MimeTypeMap;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.martian.ttbook.b.a.k.n;
import com.martian.ttbook.b.a.q.f;
import com.martian.ttbook.b.a.q.g;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import java.io.File;

/* loaded from: classes4.dex */
public class h {

    /* renamed from: a */
    private com.martian.ttbook.b.a.q.f f15169a;

    /* renamed from: b */
    private DownloadManager f15170b;

    /* renamed from: c */
    private long f15171c;

    /* renamed from: d */
    private BroadcastReceiver f15172d;

    /* renamed from: e */
    private LinearLayout f15173e;

    /* renamed from: f */
    private TextView f15174f;

    /* renamed from: g */
    private g f15175g;

    /* renamed from: h */
    private String f15176h;

    /* renamed from: i */
    private String f15177i;

    /* renamed from: j */
    private f f15178j;
    private Context k;

    class a implements DownloadListener {
        a() {
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j2) {
            h.this.g(str);
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (h.this.f15169a.canGoBack()) {
                h.this.f15169a.goBack();
            } else {
                h.this.f15178j.onClose();
            }
        }
    }

    class c implements f.d {
        c() {
        }

        @Override // com.martian.ttbook.b.a.q.f.d
        public void onLoadCompleted() {
            h.this.c();
            h.this.r();
        }
    }

    class d implements g.a {
        d() {
        }

        @Override // com.martian.ttbook.b.a.q.g.a
        public void a() {
            h.this.r();
        }

        @Override // com.martian.ttbook.b.a.q.g.a
        public void a(long j2) {
            if (h.this.f15174f != null) {
                h.this.f15174f.setTextSize(18.0f);
                h.this.f15174f.setText("关闭");
            }
            if (j2 <= 600) {
                h.this.r();
            }
        }
    }

    class e extends BroadcastReceiver {

        /* renamed from: a */
        final /* synthetic */ long f15183a;

        e(long j2) {
            this.f15183a = j2;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getLongExtra(DownloadConstants.EXTRA_DOWNLOAD_ID, -1L) == this.f15183a) {
                h.this.l();
            }
        }
    }

    public interface f {

        /* renamed from: a */
        public static final f f15185a = new a();

        static class a implements f {
            a() {
            }

            @Override // com.martian.ttbook.b.a.q.h.f
            public boolean canSkip() {
                return false;
            }

            @Override // com.martian.ttbook.b.a.q.h.f
            public void onClose() {
            }

            @Override // com.martian.ttbook.b.a.q.h.f
            public void onShow() {
            }
        }

        boolean canSkip();

        void onClose();

        void onShow();
    }

    public h(Context context, String str, String str2, f fVar) {
        this.f15176h = "";
        this.f15178j = f.f15185a;
        this.k = context;
        this.f15176h = str;
        this.f15177i = str2;
        this.f15178j = fVar;
    }

    public void c() {
        g gVar = this.f15175g;
        if (gVar != null) {
            gVar.cancel();
            this.f15175g = null;
        }
    }

    private void d(long j2) {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE");
        e eVar = new e(j2);
        this.f15172d = eVar;
        this.k.registerReceiver(eVar, intentFilter, "android.intent.permission.DOWNLOAD_COMPLETE", n.a());
    }

    private void e(Uri uri) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        File p = p();
        if (p.exists()) {
            intent.setDataAndType(Uri.fromFile(p), AdBaseConstants.MIME_APK);
            intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
            this.k.startActivity(intent);
        }
    }

    public void g(String str) {
        try {
            Uri parse = Uri.parse(str);
            this.f15170b = (DownloadManager) this.k.getSystemService("download");
            DownloadManager.Request request = new DownloadManager.Request(parse);
            request.setAllowedNetworkTypes(3);
            request.setAllowedOverRoaming(false);
            request.setMimeType(MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(str)));
            request.setNotificationVisibility(1);
            request.setTitle("download...");
            Toast.makeText(this.k, "正在下载APP", 1).show();
            request.setVisibleInDownloadsUi(true);
            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, System.currentTimeMillis() + ".apk");
            long enqueue = this.f15170b.enqueue(request);
            this.f15171c = enqueue;
            d(enqueue);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void l() {
        Uri uriForDownloadedFile = this.f15170b.getUriForDownloadedFile(this.f15171c);
        if (uriForDownloadedFile != null) {
            if (Build.VERSION.SDK_INT < 24) {
                e(uriForDownloadedFile);
                return;
            }
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(uriForDownloadedFile, AdBaseConstants.MIME_APK);
            intent.addFlags(1);
            intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
            this.k.startActivity(intent);
        }
    }

    private File p() {
        File file = null;
        if (this.f15171c != -1) {
            DownloadManager.Query query = new DownloadManager.Query();
            query.setFilterById(this.f15171c);
            query.setFilterByStatus(8);
            Cursor query2 = this.f15170b.query(query);
            if (query2 != null) {
                if (query2.moveToFirst()) {
                    String string = query2.getString(query2.getColumnIndex("local_uri"));
                    if (!TextUtils.isEmpty(string)) {
                        file = new File(Uri.parse(string).getPath());
                    }
                }
                query2.close();
            }
        }
        return file;
    }

    public void r() {
        this.f15178j.canSkip();
        this.f15174f.setText("×");
        this.f15174f.setTextSize(30.0f);
        this.f15174f.setOnClickListener(new b());
    }

    public View a(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        this.f15173e = linearLayout;
        linearLayout.setOrientation(1);
        LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        linearLayout2.setOrientation(0);
        this.f15173e.setBackgroundColor(Color.parseColor("#dddddd"));
        this.f15173e.addView(linearLayout2);
        this.f15174f = new TextView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        this.f15174f.setPadding(30, 8, 30, 8);
        this.f15174f.setLayoutParams(layoutParams);
        this.f15174f.setTextColor(Color.parseColor("#FFFFFF"));
        linearLayout2.addView(this.f15174f);
        TextView textView = new TextView(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        textView.setLayoutParams(layoutParams2);
        textView.setPadding(0, 0, 30, 0);
        textView.setTextSize(18.0f);
        textView.setText(this.f15176h);
        textView.setSingleLine(true);
        textView.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        textView.setTextColor(Color.parseColor("#FFFFFF"));
        linearLayout2.addView(textView);
        com.martian.ttbook.b.a.q.f fVar = new com.martian.ttbook.b.a.q.f(context);
        this.f15169a = fVar;
        fVar.e(new c());
        this.f15169a.d(textView);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, 0);
        layoutParams3.weight = 1.0f;
        this.f15169a.setLayoutParams(layoutParams3);
        this.f15173e.addView(this.f15169a);
        g gVar = new g(new d(), 3000L, 1000L);
        this.f15175g = gVar;
        gVar.start();
        return this.f15173e;
    }

    public void i() {
        BroadcastReceiver broadcastReceiver = this.f15172d;
        if (broadcastReceiver != null) {
            this.k.unregisterReceiver(broadcastReceiver);
        }
        com.martian.ttbook.b.a.q.f fVar = this.f15169a;
        if (fVar != null) {
            fVar.loadDataWithBaseURL(null, "", "text/html", "utf-8", null);
            ((ViewGroup) this.f15169a.getParent()).removeView(this.f15169a);
            this.f15169a.removeAllViews();
            this.f15169a.destroy();
            this.f15169a = null;
        }
    }

    public boolean k() {
        com.martian.ttbook.b.a.q.f fVar = this.f15169a;
        if (fVar == null || !fVar.canGoBack()) {
            return false;
        }
        this.f15169a.goBack();
        return true;
    }

    public void o() {
        try {
        } catch (Exception e2) {
            e2.printStackTrace();
            r();
        }
        if (!this.f15177i.startsWith("http:") && !this.f15177i.startsWith("https:")) {
            this.k.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.f15177i)));
            this.f15178j.onClose();
            this.f15178j.onShow();
            this.f15169a.setDownloadListener(new a());
        }
        this.f15169a.loadUrl(this.f15177i);
        this.f15178j.onShow();
        this.f15169a.setDownloadListener(new a());
    }
}
