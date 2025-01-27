package com.jd.ad.sdk.jad_xk;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import androidx.media3.session.SessionCommand;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.jd.ad.sdk.fdt.utils.JsonUtils;
import com.jd.ad.sdk.jad_zm.jad_ly;
import com.jd.ad.sdk.jad_zm.jad_mz;
import com.jd.ad.sdk.logger.Logger;
import com.martian.libmars.activity.PermissionActivity;
import com.sigmob.sdk.base.k;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class jad_iv implements jad_ly.jad_an {
    public ConcurrentLinkedQueue<jad_dq> jad_cp;
    public com.jd.ad.sdk.jad_xk.jad_cp jad_dq;
    public ConcurrentLinkedQueue<jad_dq> jad_er;
    public final AtomicBoolean jad_an = new AtomicBoolean(false);
    public final AtomicInteger jad_bo = new AtomicInteger(1);
    public boolean jad_fs = true;
    public String jad_jt = "";

    public class jad_an implements Runnable {
        public final /* synthetic */ JSONObject jad_an;

        public jad_an(JSONObject jSONObject) {
            this.jad_an = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            ContentResolver jad_an;
            com.jd.ad.sdk.jad_pc.jad_dq jad_dqVar;
            StringBuilder jad_an2 = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("event: ");
            jad_an2.append(this.jad_an);
            Logger.d(jad_an2.toString());
            jad_iv jad_ivVar = jad_iv.this;
            jad_dq jad_an3 = jad_iv.jad_an(this.jad_an);
            jad_iv.this.getClass();
            com.jd.ad.sdk.jad_pc.jad_cp jad_cp = com.jd.ad.sdk.jad_re.jad_an.jad_cp();
            String str = (jad_cp == null || (jad_dqVar = jad_cp.jad_bo) == null) ? "" : jad_dqVar.jad_an;
            if (jad_ivVar.jad_cp == null) {
                jad_ivVar.jad_cp = new ConcurrentLinkedQueue<>();
            }
            if (jad_ivVar.jad_er == null) {
                jad_ivVar.jad_er = new ConcurrentLinkedQueue<>();
            }
            jad_ivVar.jad_cp.add(jad_an3);
            if (jad_ivVar.jad_fs) {
                com.jd.ad.sdk.jad_xk.jad_cp jad_cpVar = jad_ivVar.jad_dq;
                if (jad_cpVar != null) {
                    jad_cpVar.jad_an(jad_an3, jad_ivVar.jad_jt);
                }
            } else {
                String str2 = jad_ivVar.jad_jt;
                synchronized (com.jd.ad.sdk.jad_tg.jad_an.class) {
                    List<String> list = com.jd.ad.sdk.jad_tg.jad_an.jad_an;
                    if (!TextUtils.isEmpty(str2)) {
                        try {
                            if (!TextUtils.isEmpty(jad_an3.jad_an().toString()) && (jad_an = com.jd.ad.sdk.jad_tg.jad_an.jad_an()) != null) {
                                Uri parse = Uri.parse(com.jd.ad.sdk.jad_tg.jad_an.jad_bo() + "db_event/" + k.f18185q);
                                ContentValues contentValues = new ContentValues();
                                contentValues.put(NotificationCompat.CATEGORY_EVENT, jad_an3.jad_an().toString());
                                contentValues.put(ContentProviderManager.PLUGIN_PROCESS_NAME, str2);
                                contentValues.put(PermissionActivity.f12046p, Integer.valueOf(jad_an3.jad_an));
                                jad_an.update(parse, contentValues, null, null);
                            }
                        } catch (Exception e10) {
                            Logger.w("Exception while multi process saving events: ", e10.getMessage());
                        }
                    }
                }
            }
            if (jad_ivVar.jad_cp.size() >= jad_ivVar.jad_bo.get()) {
                jad_ivVar.jad_an(str);
            }
        }
    }

    public class jad_bo implements Runnable {
        public final /* synthetic */ String[] jad_an;

        public jad_bo(String[] strArr) {
            this.jad_an = strArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.jd.ad.sdk.jad_zm.jad_fs jad_an = jad_jt.jad_an();
                for (int i10 = 0; i10 < this.jad_an.length; i10++) {
                    jad_ly.jad_bo jad_an2 = com.jd.ad.sdk.jad_zm.jad_bo.jad_an();
                    jad_an2.jad_er = this.jad_an[i10];
                    jad_an2.jad_bo = jad_an;
                    jad_an2.jad_cp = SessionCommand.COMMAND_CODE_LIBRARY_GET_LIBRARY_ROOT;
                    jad_an2.jad_dq = 100000;
                    jad_an2.jad_jt = jad_iv.this;
                    jad_an2.jad_an(com.jd.ad.sdk.jad_ep.jad_bo.jad_bo);
                }
            } catch (Exception e10) {
                Logger.w("Exception while gw event: ", e10.getMessage());
            }
        }
    }

    public static class jad_cp {
        public static final jad_iv jad_an = new jad_iv();
    }

    public void jad_bo(JSONObject jSONObject) {
        jad_er.jad_an.execute(new jad_an(jSONObject));
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x02e2  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x036d  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0395 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x02c5  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0281  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.jd.ad.sdk.jad_xk.jad_dq jad_an(org.json.JSONObject r17) {
        /*
            Method dump skipped, instructions count: 948
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_xk.jad_iv.jad_an(org.json.JSONObject):com.jd.ad.sdk.jad_xk.jad_dq");
    }

    public static jad_dq jad_an(String str, int i10) {
        JSONObject jSONObject = new JSONObject();
        JsonUtils.put(jSONObject, "tp", 5);
        JsonUtils.put(jSONObject, "extp", 1);
        JsonUtils.put(jSONObject, "ercd", Integer.valueOf(com.jd.ad.sdk.jad_wj.jad_an.CRASH_ERROR.jad_an));
        JsonUtils.put(jSONObject, "erin", str);
        JsonUtils.put(jSONObject, "crt", Integer.valueOf(i10));
        return jad_an(jSONObject);
    }

    public final synchronized void jad_an(String str) {
        ConcurrentLinkedQueue<jad_dq> concurrentLinkedQueue;
        try {
            try {
                concurrentLinkedQueue = this.jad_cp;
            } catch (Exception unused) {
                this.jad_an.set(false);
            }
            if (concurrentLinkedQueue != null && !concurrentLinkedQueue.isEmpty() && !this.jad_an.get()) {
                if (com.jd.ad.sdk.jad_vi.jad_an.jad_bo) {
                    return;
                }
                this.jad_an.set(true);
                Iterator<jad_dq> it = this.jad_cp.iterator();
                for (int i10 = 0; i10 < this.jad_bo.get(); i10++) {
                    if (it.hasNext()) {
                        this.jad_er.add(it.next());
                    }
                }
                if (this.jad_er.isEmpty()) {
                    return;
                }
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                byte[] jad_an2 = jad_jt.jad_an(this.jad_er);
                if (jad_an2 == null) {
                    return;
                }
                com.jd.ad.sdk.jad_zm.jad_er jad_erVar = new com.jd.ad.sdk.jad_zm.jad_er(jad_an2);
                com.jd.ad.sdk.jad_zm.jad_fs jad_an3 = jad_jt.jad_an();
                jad_ly.jad_bo jad_an4 = com.jd.ad.sdk.jad_zm.jad_bo.jad_an();
                jad_an4.jad_er = str;
                jad_an4.jad_fs = jad_erVar;
                jad_an4.jad_bo = jad_an3;
                jad_an4.jad_cp = SessionCommand.COMMAND_CODE_LIBRARY_GET_LIBRARY_ROOT;
                jad_an4.jad_dq = 100000;
                jad_an4.jad_jt = this;
                jad_an4.jad_an(com.jd.ad.sdk.jad_ep.jad_bo.jad_bo);
                jad_an();
            }
        } finally {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0093, code lost:
    
        if (r0.inTransaction() != false) goto L264;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00ad, code lost:
    
        r2.jad_an.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00ab, code lost:
    
        if (r0.inTransaction() != false) goto L264;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void jad_an() {
        /*
            Method dump skipped, instructions count: 353
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_xk.jad_iv.jad_an():void");
    }

    public void jad_an(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return;
        }
        jad_er.jad_an.execute(new jad_bo(strArr));
    }

    @Override // com.jd.ad.sdk.jad_zm.jad_ly.jad_an
    public void jad_an(jad_mz jad_mzVar) {
        String str;
        com.jd.ad.sdk.jad_pc.jad_dq jad_dqVar;
        this.jad_an.set(false);
        if (this.jad_cp.size() >= this.jad_bo.get()) {
            com.jd.ad.sdk.jad_pc.jad_cp jad_cp2 = com.jd.ad.sdk.jad_re.jad_an.jad_cp();
            if (jad_cp2 != null && (jad_dqVar = jad_cp2.jad_bo) != null) {
                str = jad_dqVar.jad_an;
            } else {
                str = "";
            }
            jad_an(str);
        }
    }

    @Override // com.jd.ad.sdk.jad_zm.jad_ly.jad_an
    public void jad_an(int i10, String str) {
        this.jad_an.set(false);
    }
}
