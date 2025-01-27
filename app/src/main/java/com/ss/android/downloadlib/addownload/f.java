package com.ss.android.downloadlib.addownload;

import android.net.Uri;
import android.text.TextUtils;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes4.dex */
public class f {

    /* renamed from: a */
    private final ConcurrentHashMap<String, String> f21453a;

    /* renamed from: b */
    private final ConcurrentHashMap<String, String> f21454b;

    public static class a {

        /* renamed from: a */
        private static f f21455a = new f();
    }

    public /* synthetic */ f(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static f a() {
        return a.f21455a;
    }

    private String c(String str) {
        try {
            Uri parse = Uri.parse(str);
            String scheme = parse.getScheme();
            String lastPathSegment = parse.getLastPathSegment();
            if (!TextUtils.equals("https", scheme) || !lastPathSegment.endsWith(".apk")) {
                return null;
            }
            this.f21453a.put(str, lastPathSegment);
            return lastPathSegment;
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public void b(String str) {
        Iterator<Map.Entry<String, String>> it = this.f21454b.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> next = it.next();
            if (TextUtils.equals(next.getValue(), str)) {
                it.remove();
                this.f21453a.remove(next.getKey());
            }
        }
    }

    private f() {
        this.f21453a = new ConcurrentHashMap<>();
        this.f21454b = new ConcurrentHashMap<>();
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || this.f21454b.containsKey(str2)) {
            return;
        }
        this.f21454b.put(str2, str);
    }

    public String a(String str) {
        if (TextUtils.isEmpty(str) || this.f21454b.isEmpty() || !this.f21454b.containsKey(str)) {
            return null;
        }
        String c10 = c(str);
        if (this.f21453a.containsValue(c10)) {
            for (Map.Entry<String, String> entry : this.f21453a.entrySet()) {
                if (TextUtils.equals(entry.getValue(), c10)) {
                    String str2 = this.f21454b.get(entry.getKey());
                    this.f21454b.put(str, str2);
                    if (!this.f21453a.containsKey(str)) {
                        this.f21453a.put(str, c10);
                    }
                    return str2;
                }
            }
        }
        return this.f21454b.get(str);
    }

    public String a(DownloadModel downloadModel) {
        String c10 = c(downloadModel.getDownloadUrl());
        if (c10 == null || TextUtils.isEmpty(c10)) {
            return null;
        }
        String md5Hex = DownloadUtils.md5Hex(c10 + downloadModel.getPackageName());
        this.f21454b.put(downloadModel.getDownloadUrl(), md5Hex);
        return md5Hex;
    }
}
