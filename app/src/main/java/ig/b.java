package ig;

import android.database.Cursor;
import android.text.TextUtils;
import com.tanx.exposer.achieve.AdMonitorType;
import com.tanx.exposer.achieve.retry.AdMonitorRetryType;
import hg.d;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a */
    public long f26995a;

    /* renamed from: b */
    public String f26996b;

    /* renamed from: c */
    public String f26997c;

    /* renamed from: d */
    public String f26998d;

    /* renamed from: e */
    public AdMonitorType f26999e;

    /* renamed from: f */
    public String f27000f;

    /* renamed from: g */
    public d f27001g;

    /* renamed from: h */
    public final int f27002h;

    /* renamed from: i */
    public AtomicInteger f27003i;

    /* renamed from: j */
    public long f27004j;

    /* renamed from: k */
    public String f27005k;

    /* renamed from: l */
    public AdMonitorRetryType f27006l;

    public b(String str, String str2, AdMonitorType adMonitorType, String str3, String str4, int i10) {
        this.f26995a = -1L;
        this.f27003i = new AtomicInteger(0);
        this.f27006l = AdMonitorRetryType.MEMORY;
        this.f26996b = str;
        this.f26997c = str2;
        this.f26999e = adMonitorType;
        this.f26998d = str3;
        this.f27000f = str4;
        this.f27002h = i10;
        long currentTimeMillis = System.currentTimeMillis();
        this.f27005k = sg.b.a(currentTimeMillis, "yyyy-MM-dd");
        this.f27004j = currentTimeMillis + 86400000;
    }

    public long a() {
        return this.f27004j;
    }

    public String b() {
        return this.f27005k;
    }

    public int c() {
        return this.f27002h;
    }

    public long d() {
        return this.f26995a;
    }

    public void e(long j10) {
        this.f26995a = j10;
    }

    public void f(AdMonitorRetryType adMonitorRetryType) {
        this.f27006l = adMonitorRetryType;
    }

    public void g(d dVar) {
        this.f27001g = dVar;
    }

    public AtomicInteger h() {
        return this.f27003i;
    }

    public String i() {
        return this.f26997c;
    }

    public d j() {
        return this.f27001g;
    }

    public String k() {
        return this.f26996b;
    }

    public AdMonitorType l() {
        return this.f26999e;
    }

    public AdMonitorRetryType m() {
        return this.f27006l;
    }

    public String n() {
        return this.f27000f;
    }

    public String o() {
        return this.f26998d;
    }

    public b(Cursor cursor) {
        this.f26995a = -1L;
        this.f27003i = new AtomicInteger(0);
        this.f27006l = AdMonitorRetryType.MEMORY;
        this.f26995a = cursor.getLong(cursor.getColumnIndex("id"));
        this.f26999e = AdMonitorType.valueOf(cursor.getString(cursor.getColumnIndex("monitor_type")));
        this.f26996b = cursor.getString(cursor.getColumnIndex("monitor_url"));
        this.f26997c = cursor.getString(cursor.getColumnIndex("monitor_original_url"));
        this.f26998d = cursor.getString(cursor.getColumnIndex("monitor_url_host"));
        this.f27000f = cursor.getString(cursor.getColumnIndex("monitor_url_hash"));
        this.f27003i = new AtomicInteger(cursor.getInt(cursor.getColumnIndex("retry_times")));
        this.f27002h = cursor.getInt(cursor.getColumnIndex("max_retry_times"));
        this.f27005k = cursor.getString(cursor.getColumnIndex("date"));
        this.f27004j = cursor.getLong(cursor.getColumnIndex("expire_time"));
        String string = cursor.getString(cursor.getColumnIndex("monitor_extra_params"));
        if (TextUtils.isEmpty(string)) {
            return;
        }
        try {
            this.f27001g = new d(string);
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
    }
}
