package com.vivo.mobilead.model;

import android.text.TextUtils;
import com.vivo.ad.model.p;
import com.vivo.ad.model.t;
import com.vivo.ad.model.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes4.dex */
public class e {
    public static final Long l = 3000L;

    /* renamed from: a */
    public int f29577a;

    /* renamed from: b */
    public long f29578b;

    /* renamed from: c */
    public long f29579c;

    /* renamed from: d */
    public List<p> f29580d = new ArrayList();

    /* renamed from: e */
    public List<p> f29581e = new ArrayList();

    /* renamed from: f */
    public HashMap<String, List<t>> f29582f = new HashMap<>();

    /* renamed from: g */
    public HashMap<String, List<t>> f29583g = new HashMap<>();

    /* renamed from: h */
    public HashMap<Integer, Long> f29584h = new HashMap<>();

    /* renamed from: i */
    public HashMap<String, String> f29585i = new HashMap<>();

    /* renamed from: j */
    public HashMap<Integer, HashMap<String, x>> f29586j = new HashMap<>();
    public HashMap<String, a> k = new HashMap<>();

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.f29585i.put(str, str2);
    }

    public static class a {

        /* renamed from: a */
        public String f29587a;

        /* renamed from: b */
        public HashMap<String, String> f29588b = new HashMap<>();

        /* renamed from: c */
        public HashMap<String, Integer> f29589c = new HashMap<>();

        public void a(String str, String str2) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return;
            }
            this.f29588b.put(str, str2);
        }

        public void a(String str, Integer num) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.f29589c.put(str, num);
        }
    }

    public void a(a aVar) {
        if (aVar != null) {
            this.k.put(aVar.f29587a, aVar);
        }
    }
}
