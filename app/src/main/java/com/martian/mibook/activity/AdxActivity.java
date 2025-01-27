package com.martian.mibook.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.martian.libcomm.utils.GsonUtils;
import com.martian.libugrowth.adx.response.LmEnv;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import java.util.HashMap;
import java.util.Random;

/* loaded from: classes3.dex */
public class AdxActivity extends Activity {

    /* renamed from: a */
    private static final String f10800a = "INTENT_ADX_URL";

    /* renamed from: b */
    private static final String f10801b = "INTENT_ADX_ENV";

    /* renamed from: c */
    private com.martian.mibook.e.c f10802c;

    /* renamed from: d */
    private String f10803d;

    private void a(String envGson) {
        com.martian.mibook.lib.model.g.b.s(this, "上报-落地页-加载");
        HashMap hashMap = new HashMap();
        if (!com.martian.libsupport.k.p(envGson)) {
            try {
                LmEnv lmEnv = (LmEnv) GsonUtils.b().fromJson(envGson, LmEnv.class);
                if (lmEnv != null) {
                    if (!com.martian.libsupport.k.p(lmEnv.getUa())) {
                        hashMap.put("User-Agent", lmEnv.getUa());
                    }
                    if (lmEnv.getHeader() != null) {
                        for (String str : lmEnv.getHeader().keySet()) {
                            hashMap.put(str, lmEnv.getHeader().get(str));
                        }
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        this.f10802c.f11774b.loadUrl(this.f10803d, hashMap);
        moveTaskToBack(true);
    }

    public static void b(Context context, String url, LmEnv lmEnv, int pageRate) {
        if (pageRate <= 0 || new Random().nextInt(100) <= pageRate) {
            Intent intent = new Intent(context, (Class<?>) AdxActivity.class);
            intent.putExtra(f10800a, url);
            if (lmEnv != null) {
                intent.putExtra(f10801b, GsonUtils.b().toJson(lmEnv));
            }
            intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
            context.startActivity(intent);
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        String stringExtra;
        super.onCreate(savedInstanceState);
        com.martian.mibook.e.c c2 = com.martian.mibook.e.c.c(getLayoutInflater());
        this.f10802c = c2;
        setContentView(c2.getRoot());
        if (savedInstanceState != null) {
            this.f10803d = savedInstanceState.getString(f10800a);
            stringExtra = savedInstanceState.getString(f10801b);
        } else {
            this.f10803d = getIntent().getStringExtra(f10800a);
            stringExtra = getIntent().getStringExtra(f10801b);
        }
        a(stringExtra);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.f10803d = intent.getStringExtra(f10800a);
        a(intent.getStringExtra(f10801b));
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(f10800a, this.f10803d);
        super.onSaveInstanceState(outState);
    }
}
