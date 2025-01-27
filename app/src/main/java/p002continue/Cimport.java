package p002continue;

import bh.a0;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.martian.libmars.activity.PermissionActivity;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p002continue.b;

/* renamed from: continue.import */
/* loaded from: classes4.dex */
public final class Cimport implements Serializable {

    /* renamed from: break */
    public boolean f21break;

    /* renamed from: case */
    public final int f22case;

    /* renamed from: do */
    public final String f23do;

    /* renamed from: else */
    public final String f24else;

    /* renamed from: for */
    public final String f25for;

    /* renamed from: goto */
    public final String f26goto;

    /* renamed from: if */
    public final String f27if;

    /* renamed from: new */
    public final long f28new;

    /* renamed from: this */
    public final List<String> f29this;

    /* renamed from: try */
    public final boolean f30try;

    public Cimport(String str, String str2, String str3, long j10, boolean z10, int i10, String str4, String str5, List<String> list, boolean z11) {
        ArrayList arrayList = new ArrayList();
        this.f29this = arrayList;
        this.f23do = str;
        this.f27if = str2;
        this.f25for = str3;
        this.f28new = j10;
        this.f30try = z10;
        this.f22case = i10;
        this.f24else = str4;
        this.f26goto = str5;
        arrayList.addAll(list);
        this.f21break = z11;
    }

    /* renamed from: do */
    public static Cimport m48do(String str) {
        try {
            return m49do(new JSONObject(str));
        } catch (JSONException e10) {
            throw new RuntimeException(e10);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Cimport.class != obj.getClass()) {
            return false;
        }
        Cimport cimport = (Cimport) obj;
        if (this.f28new == cimport.f28new && this.f30try == cimport.f30try && this.f22case == cimport.f22case && Objects.equals(this.f23do, cimport.f23do) && Objects.equals(this.f27if, cimport.f27if) && Objects.equals(this.f25for, cimport.f25for) && Objects.equals(this.f29this, cimport.f29this)) {
            return Objects.equals(this.f24else, cimport.f24else);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f23do;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f27if;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f25for;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        long j10 = this.f28new;
        int i10 = (((((hashCode3 + ((int) (j10 ^ (j10 >>> 32)))) * 31) + (this.f30try ? 1 : 0)) * 31) + this.f22case) * 31;
        String str4 = this.f24else;
        return this.f29this.hashCode() + ((((i10 + (str4 != null ? str4.hashCode() : 0)) * 31) + (this.f21break ? 1 : 0)) * 31);
    }

    /* renamed from: if */
    public final void m52if(File file) {
        a0.s(file);
        a0.u(file.getParentFile());
        a0.i(file, m50do().toString().getBytes("UTF-8"));
    }

    public final String toString() {
        return m50do().toString();
    }

    /* renamed from: do */
    public static Cimport m49do(JSONObject jSONObject) {
        String optString = jSONObject.optString("id", "");
        String optString2 = jSONObject.optString(TTDownloadField.TT_DOWNLOAD_URL, "");
        String optString3 = jSONObject.optString("md5", "");
        long optLong = jSONObject.optLong("size", 0L);
        int optInt = jSONObject.optInt("version", 0);
        String optString4 = jSONObject.optString("decoder", DownloadSettingKeys.BugFix.DEFAULT);
        String optString5 = jSONObject.optString(PermissionActivity.f12046p, "");
        boolean optBoolean = jSONObject.optBoolean("delete", false);
        boolean optBoolean2 = jSONObject.optBoolean("isFromLocal", false);
        String optString6 = jSONObject.optString("sharedSos", null);
        ArrayList arrayList = new ArrayList();
        if (optString6 != null) {
            try {
                JSONArray jSONArray = new JSONArray(optString6);
                for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                    arrayList.add((String) jSONArray.get(i10));
                }
            } catch (JSONException unused) {
            }
        }
        return new Cimport(optString, optString2, optString3, optLong, optBoolean, optInt, optString4, optString5, arrayList, optBoolean2);
    }

    /* renamed from: do */
    public final JSONObject m50do() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", this.f23do);
            jSONObject.put(TTDownloadField.TT_DOWNLOAD_URL, this.f27if);
            jSONObject.put("md5", this.f25for);
            jSONObject.put("size", this.f28new);
            jSONObject.put("delete", this.f30try);
            jSONObject.put("version", this.f22case);
            jSONObject.put("decoder", this.f24else);
            jSONObject.put("isFromLocal", this.f21break);
            jSONObject.put("sharedSos", this.f29this);
            return jSONObject;
        } catch (JSONException e10) {
            throw new RuntimeException(e10);
        }
    }

    /* renamed from: do */
    public final byte[] m51do(byte[] bArr) {
        if ("2".equals(this.f24else)) {
            String substring = this.f26goto.substring(0, 16);
            String substring2 = this.f26goto.substring(16);
            Charset charset = StandardCharsets.UTF_8;
            return b.a.a(bArr, substring.getBytes(charset), substring2.getBytes(charset));
        }
        if ("1".equals(this.f24else)) {
            return b.a.a(bArr, this.f26goto.getBytes(StandardCharsets.UTF_8), b.f25192a);
        }
        DownloadSettingKeys.BugFix.DEFAULT.equals(this.f24else);
        return bArr;
    }

    /* renamed from: do */
    public static Cimport m47do(File file) {
        try {
            return m48do(a0.t(file));
        } catch (IOException unused) {
            return null;
        }
    }
}
