package com.aggmoread.sdk.z.b.u;

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
import com.aggmoread.sdk.z.b.m.n;
import com.aggmoread.sdk.z.b.u.i;
import com.aggmoread.sdk.z.b.u.j;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import java.io.File;

/* loaded from: classes.dex */
public class k {

    /* renamed from: a */
    private i f5069a;

    /* renamed from: b */
    private DownloadManager f5070b;

    /* renamed from: c */
    private long f5071c;

    /* renamed from: d */
    private BroadcastReceiver f5072d;

    /* renamed from: e */
    private LinearLayout f5073e;

    /* renamed from: f */
    private TextView f5074f;

    /* renamed from: g */
    private j f5075g;

    /* renamed from: h */
    private String f5076h;

    /* renamed from: i */
    private String f5077i;

    /* renamed from: j */
    private f f5078j;

    /* renamed from: k */
    private Context f5079k;

    public class a implements DownloadListener {
        public a() {
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j10) {
            k.this.a(str);
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (k.this.f5069a.canGoBack()) {
                k.this.f5069a.goBack();
            } else {
                k.this.f5078j.onClose();
            }
        }
    }

    public class c implements i.d {
        public c() {
        }

        @Override // com.aggmoread.sdk.z.b.u.i.d
        public void a() {
            k.this.a();
            k.this.g();
        }
    }

    public class d implements j.a {
        public d() {
        }

        @Override // com.aggmoread.sdk.z.b.u.j.a
        public void a() {
            k.this.g();
        }

        @Override // com.aggmoread.sdk.z.b.u.j.a
        public void a(long j10) {
            if (k.this.f5074f != null) {
                k.this.f5074f.setTextSize(18.0f);
                k.this.f5074f.setText("关闭");
            }
            if (j10 <= 600) {
                k.this.g();
            }
        }
    }

    public class e extends BroadcastReceiver {

        /* renamed from: a */
        final /* synthetic */ long f5084a;

        public e(long j10) {
            this.f5084a = j10;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getLongExtra(DownloadConstants.EXTRA_DOWNLOAD_ID, -1L) == this.f5084a) {
                k.this.d();
            }
        }
    }

    public interface f {

        /* renamed from: a */
        public static final f f5086a = new a();

        public static class a implements f {
            @Override // com.aggmoread.sdk.z.b.u.k.f
            public boolean canSkip() {
                return false;
            }

            @Override // com.aggmoread.sdk.z.b.u.k.f
            public void onClose() {
            }

            @Override // com.aggmoread.sdk.z.b.u.k.f
            public void onShow() {
            }
        }

        boolean canSkip();

        void onClose();

        void onShow();
    }

    public k(Context context, String str, String str2, f fVar) {
        this.f5076h = "";
        f fVar2 = f.f5086a;
        this.f5079k = context;
        this.f5076h = str;
        this.f5077i = str2;
        this.f5078j = fVar;
    }

    public void d() {
        Uri uriForDownloadedFile = this.f5070b.getUriForDownloadedFile(this.f5071c);
        if (uriForDownloadedFile != null) {
            if (Build.VERSION.SDK_INT < 24) {
                a(uriForDownloadedFile);
                return;
            }
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(uriForDownloadedFile, "application/vnd.android.package-archive");
            intent.addFlags(1);
            intent.addFlags(268435456);
            this.f5079k.startActivity(intent);
        }
    }

    private File f() {
        File file = null;
        if (this.f5071c != -1) {
            DownloadManager.Query query = new DownloadManager.Query();
            query.setFilterById(this.f5071c);
            query.setFilterByStatus(8);
            Cursor query2 = this.f5070b.query(query);
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

    public void g() {
        this.f5078j.canSkip();
        this.f5074f.setText("×");
        this.f5074f.setTextSize(30.0f);
        this.f5074f.setOnClickListener(new b());
    }

    public View a(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        this.f5073e = linearLayout;
        linearLayout.setOrientation(1);
        LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        linearLayout2.setOrientation(0);
        this.f5073e.setBackgroundColor(Color.parseColor("#dddddd"));
        this.f5073e.addView(linearLayout2);
        this.f5074f = new TextView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        this.f5074f.setPadding(30, 8, 30, 8);
        this.f5074f.setLayoutParams(layoutParams);
        this.f5074f.setTextColor(Color.parseColor("#FFFFFF"));
        linearLayout2.addView(this.f5074f);
        TextView textView = new TextView(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        textView.setLayoutParams(layoutParams2);
        textView.setPadding(0, 0, 30, 0);
        textView.setTextSize(18.0f);
        textView.setText(this.f5076h);
        textView.setSingleLine(true);
        textView.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        textView.setTextColor(Color.parseColor("#FFFFFF"));
        linearLayout2.addView(textView);
        i iVar = new i(context);
        this.f5069a = iVar;
        iVar.a(new c());
        this.f5069a.a(textView);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, 0);
        layoutParams3.weight = 1.0f;
        this.f5069a.setLayoutParams(layoutParams3);
        this.f5073e.addView(this.f5069a);
        j jVar = new j(new d(), 3000L, 1000L);
        this.f5075g = jVar;
        jVar.start();
        return this.f5073e;
    }

    public void b() {
        BroadcastReceiver broadcastReceiver = this.f5072d;
        if (broadcastReceiver != null) {
            this.f5079k.unregisterReceiver(broadcastReceiver);
        }
        i iVar = this.f5069a;
        if (iVar != null) {
            iVar.loadDataWithBaseURL(null, "", "text/html", "utf-8", null);
            ((ViewGroup) this.f5069a.getParent()).removeView(this.f5069a);
            this.f5069a.removeAllViews();
            this.f5069a.destroy();
            this.f5069a = null;
        }
    }

    public boolean c() {
        i iVar = this.f5069a;
        if (iVar == null || !iVar.canGoBack()) {
            return false;
        }
        this.f5069a.goBack();
        return true;
    }

    public void e() {
        try {
        } catch (Exception e10) {
            e10.printStackTrace();
            g();
        }
        if (!this.f5077i.startsWith("http:") && !this.f5077i.startsWith("https:")) {
            this.f5079k.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.f5077i)));
            this.f5078j.onClose();
            this.f5078j.onShow();
            this.f5069a.setDownloadListener(new a());
        }
        this.f5069a.loadUrl(this.f5077i);
        this.f5078j.onShow();
        this.f5069a.setDownloadListener(new a());
    }

    public void a() {
        j jVar = this.f5075g;
        if (jVar != null) {
            jVar.cancel();
            this.f5075g = null;
        }
    }

    private void a(long j10) {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE");
        e eVar = new e(j10);
        this.f5072d = eVar;
        this.f5079k.registerReceiver(eVar, intentFilter, "android.intent.permission.DOWNLOAD_COMPLETE", n.a());
    }

    private void a(Uri uri) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        File f10 = f();
        if (f10.exists()) {
            intent.setDataAndType(Uri.fromFile(f10), "application/vnd.android.package-archive");
            intent.addFlags(268435456);
            this.f5079k.startActivity(intent);
        }
    }

    public void a(String str) {
        try {
            Uri parse = Uri.parse(str);
            this.f5070b = (DownloadManager) this.f5079k.getSystemService("download");
            DownloadManager.Request request = new DownloadManager.Request(parse);
            request.setAllowedNetworkTypes(3);
            request.setAllowedOverRoaming(false);
            request.setMimeType(MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(str)));
            request.setNotificationVisibility(1);
            request.setTitle("download...");
            Toast.makeText(this.f5079k, "正在下载APP", 1).show();
            request.setVisibleInDownloadsUi(true);
            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, System.currentTimeMillis() + ".apk");
            long enqueue = this.f5070b.enqueue(request);
            this.f5071c = enqueue;
            a(enqueue);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }
}
