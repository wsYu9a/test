package cn.vlion.ad.inland.base;

import android.text.TextUtils;
import com.martian.mibook.lib.account.MiUserManager;
import com.martian.rpauth.MartianRPUserManager;

/* loaded from: classes.dex */
public final class i1 {

    /* renamed from: c */
    public static final i1 f2913c = new i1(20000, "No Match AD Type");

    /* renamed from: d */
    public static final i1 f2914d;

    /* renamed from: e */
    public static final i1 f2915e;

    /* renamed from: f */
    public static final i1 f2916f;

    /* renamed from: g */
    public static final i1 f2917g;

    /* renamed from: h */
    public static final i1 f2918h;

    /* renamed from: i */
    public static final i1 f2919i;

    /* renamed from: a */
    public final int f2920a;

    /* renamed from: b */
    public final String f2921b;

    static {
        new i1(20001, "Load Image Load Bitmap Null");
        new i1(20006, "Load Webview Url Empty");
        f2914d = new i1(20002, "player on path error");
        f2915e = new i1(20003, "player error");
        new i1(MiUserManager.f13852h, "Load Video Path Not Exists");
        new i1(MartianRPUserManager.f16186j, "Load Video File Not Exists");
        new i1(20008, "Show Ad ,But Ad Not Ready");
        f2916f = new i1(20009, "Vlion custom AppId is empty");
        f2917g = new i1(20010, "Vlion custom TagId is empty");
        f2918h = new i1(20011, "Vlion custom config is null");
        f2919i = new i1(20012, "Vlion data is not ready");
    }

    public i1(int i10, String str) {
        str = TextUtils.isEmpty(str) ? "unknown error" : str;
        this.f2920a = i10;
        this.f2921b = str;
    }

    public final String toString() {
        StringBuilder a10 = l1.a("VlionAdError{errorCode=");
        a10.append(this.f2920a);
        a10.append(", errorMessage='");
        a10.append(this.f2921b);
        a10.append('\'');
        a10.append('}');
        return a10.toString();
    }
}
