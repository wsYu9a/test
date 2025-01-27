package com.opos.mobad.q.a;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;

/* loaded from: classes4.dex */
public class l {

    /* renamed from: a */
    public com.opos.mobad.ad.h f23367a;

    /* renamed from: b */
    private Context f23368b;

    /* renamed from: g */
    private AdItemData f23373g;

    /* renamed from: h */
    private MaterialData f23374h;

    /* renamed from: c */
    private boolean f23369c = false;

    /* renamed from: d */
    private volatile boolean f23370d = false;

    /* renamed from: e */
    private long f23371e = -1;

    /* renamed from: f */
    private boolean f23372f = false;

    /* renamed from: i */
    private boolean f23375i = false;

    /* renamed from: com.opos.mobad.q.a.l$1 */
    class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Object[] f23376a;

        AnonymousClass1(Object[] objArr) {
            objArr = objArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.opos.mobad.ad.h hVar;
            if (l.this.f23369c || !l.this.f23370d || (hVar = l.this.f23367a) == null) {
                return;
            }
            hVar.a(objArr);
        }
    }

    public l(Context context, com.opos.mobad.ad.h hVar) {
        this.f23368b = context;
        this.f23367a = hVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0034, code lost:
    
        r6.append("安装完成");
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x004a, code lost:
    
        if (r5.f23375i != false) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x002d, code lost:
    
        if (r5.f23375i != false) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x002f, code lost:
    
        r6.append("打开");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.CharSequence a(android.text.SpannableStringBuilder r6, android.text.SpannableString r7, long r8) {
        /*
            Method dump skipped, instructions count: 244
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.q.a.l.a(android.text.SpannableStringBuilder, android.text.SpannableString, long):java.lang.CharSequence");
    }

    private String a(String str) {
        if (!TextUtils.isEmpty(str)) {
            str = str + "s";
        }
        return this.f23368b.getString(R.string.opos_mob_reward_count, str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0031, code lost:
    
        if (r4.f23375i != false) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0062, code lost:
    
        if (r4.f23375i != false) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001c, code lost:
    
        if (r4.f23375i != false) goto L92;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String a(java.lang.String r5, long r6) {
        /*
            Method dump skipped, instructions count: 242
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.q.a.l.a(java.lang.String, long):java.lang.String");
    }

    private void a(Object... objArr) {
        this.f23370d = true;
        com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.q.a.l.1

            /* renamed from: a */
            final /* synthetic */ Object[] f23376a;

            AnonymousClass1(Object[] objArr2) {
                objArr = objArr2;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.opos.mobad.ad.h hVar;
                if (l.this.f23369c || !l.this.f23370d || (hVar = l.this.f23367a) == null) {
                    return;
                }
                hVar.a(objArr);
            }
        });
    }

    private String b(String str) {
        if (!TextUtils.isEmpty(str)) {
            str = str + "s";
        }
        return this.f23368b.getString(R.string.opos_mob_reward_count_install, str);
    }

    private String c(String str) {
        if (!TextUtils.isEmpty(str)) {
            str = str + "s";
        }
        return this.f23375i ? this.f23368b.getString(R.string.opos_mob_reward_count_open, str) : this.f23368b.getString(R.string.opos_mob_reward_count_open_without_install, str);
    }

    private long f(long j2) {
        long K = this.f23373g.K();
        if (j2 <= 0) {
            j2 = this.f23374h.u();
        }
        if (K <= 0) {
            K = j2;
        } else if (j2 > 0) {
            K = Math.min(K, j2);
        }
        long max = Math.max(0L, K);
        long j3 = this.f23371e;
        if (j3 >= max) {
            return 0L;
        }
        return Math.max(0L, max - j3);
    }

    public void a() {
        if (this.f23370d || this.f23369c || !this.f23373g.z()) {
            return;
        }
        a(new Object[0]);
    }

    public void a(long j2) {
        this.f23371e = j2;
        if (this.f23370d || this.f23369c) {
            return;
        }
        if (this.f23373g.v() && this.f23373g.K() > 0 && j2 >= this.f23373g.K()) {
            a(new Object[0]);
        }
        if (this.f23373g.y() && this.f23372f && this.f23371e >= this.f23373g.K()) {
            a(new Object[0]);
        }
    }

    public void a(AdItemData adItemData, MaterialData materialData) {
        this.f23373g = adItemData;
        this.f23374h = materialData;
        this.f23370d = false;
        this.f23372f = false;
        this.f23371e = -1L;
        this.f23375i = com.opos.cmn.an.h.d.a.d(this.f23368b, this.f23374h.k());
    }

    public void a(AdItemData adItemData, String str) {
        if (this.f23370d || this.f23369c || !this.f23373g.x() || adItemData.C()) {
            return;
        }
        adItemData.d(true);
        AdItemData adItemData2 = this.f23373g;
        if (adItemData2 != null && ((!TextUtils.isEmpty(adItemData2.f()) && !TextUtils.isEmpty(adItemData.f()) && this.f23373g.f().equals(adItemData.f())) || (!TextUtils.isEmpty(this.f23373g.c()) && !TextUtils.isEmpty(adItemData.c()) && this.f23373g.c().equals(adItemData.c())))) {
            this.f23373g.d(true);
        }
        a(new Object[0]);
    }

    public void b(long j2) {
        this.f23371e = j2;
        if (this.f23370d || this.f23369c || !this.f23373g.v()) {
            return;
        }
        a(new Object[0]);
    }

    public void b(AdItemData adItemData, String str) {
        if (this.f23370d || this.f23369c) {
            return;
        }
        this.f23375i = true;
        if (!this.f23373g.w() || adItemData.C()) {
            return;
        }
        adItemData.d(true);
        AdItemData adItemData2 = this.f23373g;
        if (adItemData2 != null && ((!TextUtils.isEmpty(adItemData2.f()) && !TextUtils.isEmpty(adItemData.f()) && this.f23373g.f().equals(adItemData.f())) || (!TextUtils.isEmpty(this.f23373g.c()) && !TextUtils.isEmpty(adItemData.c()) && this.f23373g.c().equals(adItemData.c())))) {
            this.f23373g.d(true);
        }
        a(new Object[0]);
    }

    public boolean b() {
        return this.f23370d;
    }

    public CharSequence c(long j2) {
        com.opos.cmn.an.f.a.b("", "getRewardLastTips = " + this.f23370d);
        if (this.f23370d || this.f23373g.A()) {
            return "";
        }
        if (this.f23373g.v() && this.f23373g.K() <= 0 && this.f23374h.u() <= 0) {
            return "";
        }
        long f2 = f(j2);
        double d2 = f2;
        Double.isNaN(d2);
        String valueOf = String.valueOf(Math.round(d2 / 1000.0d));
        SpannableString spannableString = new SpannableString(valueOf);
        spannableString.setSpan(new ForegroundColorSpan(this.f23368b.getResources().getColor(android.R.color.holo_red_dark)), 0, valueOf.length(), 33);
        return a(new SpannableStringBuilder(), spannableString, f2);
    }

    public void c() {
        if (this.f23370d || this.f23369c) {
            return;
        }
        this.f23372f = true;
        if (this.f23373g.y()) {
            if (this.f23373g.K() <= 0 || this.f23371e >= this.f23373g.K()) {
                a(new Object[0]);
            }
        }
    }

    public String d(long j2) {
        return (this.f23373g.v() || this.f23373g.x() || this.f23373g.w()) ? e(j2) : "";
    }

    public boolean d() {
        if (this.f23370d || this.f23369c) {
            return false;
        }
        this.f23370d = true;
        com.opos.mobad.service.a.a().a(this.f23373g.g(), 5, this.f23373g.f(), this.f23373g.b(), (this.f23373g.i().size() <= 0 || this.f23373g.i().get(0) == null) ? "" : this.f23373g.i().get(0).aa(), this.f23373g.a(), this.f23373g.J());
        a(new Object[0]);
        return true;
    }

    public String e(long j2) {
        String str;
        if (j2 <= 0) {
            j2 = this.f23374h.u();
        }
        if (this.f23373g.K() > 0) {
            j2 = j2 > 0 ? Math.min(this.f23373g.K(), j2) : this.f23373g.K();
        }
        long max = Math.max(j2, 0L);
        long j3 = this.f23371e;
        if (j3 > 0) {
            max = Math.max(0L, max - j3);
        }
        if (max > 0) {
            double d2 = max;
            Double.isNaN(d2);
            str = String.valueOf(Math.round(d2 / 1000.0d));
        } else {
            str = "";
        }
        if (!this.f23370d) {
            return a(str, max);
        }
        if (!TextUtils.isEmpty(str)) {
            str = str + "s";
        }
        return this.f23368b.getString(R.string.opos_mob_reward_tips, str);
    }

    public void e() {
        this.f23370d = false;
        this.f23369c = true;
    }
}
