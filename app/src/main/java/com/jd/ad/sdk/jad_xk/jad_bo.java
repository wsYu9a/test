package com.jd.ad.sdk.jad_xk;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.jd.ad.sdk.jad_zm.jad_ly;
import com.jd.ad.sdk.jad_zm.jad_mz;
import com.jd.ad.sdk.logger.Logger;
import com.jd.ad.sdk.multi.BuildConfig;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import java.lang.reflect.UndeclaredThrowableException;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: classes2.dex */
public class jad_bo implements Thread.UncaughtExceptionHandler {
    public SharedPreferences jad_an;
    public Thread.UncaughtExceptionHandler jad_bo;

    /* renamed from: com.jd.ad.sdk.jad_xk.jad_bo$jad_bo */
    public static class C0358jad_bo {
        public static final jad_bo jad_an = new jad_bo();
    }

    public final synchronized void jad_an() {
        String str;
        byte[] jad_an2;
        com.jd.ad.sdk.jad_pc.jad_cp jad_cp = com.jd.ad.sdk.jad_re.jad_an.jad_cp();
        SharedPreferences sharedPreferences = this.jad_an;
        if (sharedPreferences != null && jad_cp != null && jad_cp.jad_bo != null) {
            if (com.jd.ad.sdk.jad_vi.jad_an.jad_bo) {
                return;
            }
            Map<String, ?> all = sharedPreferences.getAll();
            StringBuilder jad_an3 = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("crash uploadCrash size: ");
            jad_an3.append(all.size());
            Logger.d(jad_an3.toString());
            if (all.size() == 0) {
                return;
            }
            StringBuilder jad_an4 = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("crash uploadCrash size: ");
            jad_an4.append(all.size());
            Logger.d(jad_an4.toString());
            try {
                str = jad_cp.jad_bo.jad_an;
                ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
                Iterator<Map.Entry<String, ?>> it = all.entrySet().iterator();
                while (it.hasNext()) {
                    String str2 = (String) it.next().getValue();
                    if (!TextUtils.isEmpty(str2)) {
                        String replaceAll = str2.replaceAll("\u0001", " ");
                        concurrentLinkedQueue.add(jad_iv.jad_an(replaceAll, jad_an(replaceAll) ? 2 : 1));
                    }
                }
                jad_an2 = jad_jt.jad_an(concurrentLinkedQueue);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            if (jad_an2 == null) {
                return;
            }
            com.jd.ad.sdk.jad_zm.jad_fs jad_an5 = jad_jt.jad_an();
            jad_ly.jad_bo jad_an6 = com.jd.ad.sdk.jad_zm.jad_bo.jad_an();
            jad_an6.jad_fs = new com.jd.ad.sdk.jad_zm.jad_er(jad_an2);
            jad_an6.jad_bo = jad_an5;
            jad_an6.jad_er = str;
            jad_an6.jad_jt = new jad_an();
            jad_an6.jad_cp = 30000;
            jad_an6.jad_dq = 60000;
            jad_an6.jad_an(com.jd.ad.sdk.jad_ep.jad_bo.jad_bo);
        }
    }

    public final synchronized void jad_bo(Throwable th2) {
        String jad_an2;
        SharedPreferences sharedPreferences = this.jad_an;
        if (sharedPreferences == null) {
            return;
        }
        if (sharedPreferences.getAll() == null || this.jad_an.getAll().size() < 10) {
            try {
                jad_an2 = jad_an(th2);
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            if (TextUtils.isEmpty(jad_an2)) {
                return;
            }
            String concat = BuildConfig.VERSION_NAME.concat(":").concat(String.valueOf(com.jd.ad.sdk.jad_wj.jad_an.CRASH_ERROR.jad_an)).concat(":").concat(jad_an2);
            SharedPreferences.Editor edit = this.jad_an.edit();
            edit.putString(Long.toString(System.currentTimeMillis()), concat.trim());
            com.jd.ad.sdk.jad_pc.jad_an jad_an3 = com.jd.ad.sdk.jad_re.jad_an.jad_an();
            if (jad_an3 == null) {
                edit.commit();
                Logger.d("crash config is null, catch all errorInfo: " + concat);
                jad_an();
                return;
            }
            if (!"1".equals(jad_an3.jad_an)) {
                edit.commit();
                Logger.d("crash config's crt is 0, catch all errorInfo: " + concat);
                jad_an();
            } else if (jad_an(concat)) {
                edit.commit();
                Logger.d("crash config's crt is 1, catch sdk errorInfo: " + concat);
                jad_an();
            }
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(@NonNull Thread thread, @NonNull Throwable th2) {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
        try {
            if (th2 != null) {
                try {
                } catch (Exception e10) {
                    e10.printStackTrace();
                    uncaughtExceptionHandler = this.jad_bo;
                    if (uncaughtExceptionHandler == null || uncaughtExceptionHandler == this || (uncaughtExceptionHandler instanceof jad_bo)) {
                        return;
                    }
                }
                if (!(th2 instanceof UndeclaredThrowableException)) {
                    jad_bo(th2);
                    uncaughtExceptionHandler = this.jad_bo;
                    if (uncaughtExceptionHandler == null || uncaughtExceptionHandler == this || (uncaughtExceptionHandler instanceof jad_bo)) {
                        return;
                    }
                    uncaughtExceptionHandler.uncaughtException(thread, th2);
                    return;
                }
            }
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = this.jad_bo;
            if (uncaughtExceptionHandler2 == null || uncaughtExceptionHandler2 == this || (uncaughtExceptionHandler2 instanceof jad_bo)) {
                return;
            }
            uncaughtExceptionHandler2.uncaughtException(thread, th2);
        } catch (Throwable th3) {
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler3 = this.jad_bo;
            if (uncaughtExceptionHandler3 != null && uncaughtExceptionHandler3 != this && !(uncaughtExceptionHandler3 instanceof jad_bo)) {
                uncaughtExceptionHandler3.uncaughtException(thread, th2);
            }
            throw th3;
        }
    }

    public class jad_an implements jad_ly.jad_an {
        public jad_an() {
        }

        @Override // com.jd.ad.sdk.jad_zm.jad_ly.jad_an
        public void jad_an(jad_mz jad_mzVar) {
            jad_bo.this.jad_an.edit().clear().commit();
            Logger.d("crash report success " + jad_mzVar.toString());
        }

        @Override // com.jd.ad.sdk.jad_zm.jad_ly.jad_an
        public void jad_an(int i10, String str) {
            Logger.d("crash report fail " + i10 + ",  " + str);
        }
    }

    public static String jad_an(Throwable th2) {
        for (Throwable th3 = new Throwable(BuildConfig.VERSION_NAME, th2); th3 != null; th3 = th3.getCause()) {
            if (th3 instanceof UnknownHostException) {
                return "";
            }
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th2.printStackTrace(printWriter);
        printWriter.flush();
        String stringWriter2 = stringWriter.toString();
        return TextUtils.isEmpty(stringWriter2) ? "" : stringWriter2.length() > 512000 ? stringWriter2.substring(stringWriter2.length() - 512000) : stringWriter2;
    }

    public final boolean jad_an(String str) {
        return str.contains("com.jd.ad.sdk") || str.contains("jad") || str.contains("JAD");
    }
}
