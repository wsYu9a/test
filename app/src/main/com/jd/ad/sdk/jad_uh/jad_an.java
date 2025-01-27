package com.jd.ad.sdk.jad_uh;

import android.text.TextUtils;
import com.jd.ad.sdk.fdt.thread.WorkExecutor;
import com.jd.ad.sdk.fdt.utils.ANEProxy;
import com.jd.ad.sdk.jad_qd.jad_jt;
import com.jd.ad.sdk.jad_uh.jad_bo;
import com.jd.ad.sdk.jad_xk.jad_fs;
import com.jd.ad.sdk.logger.Logger;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: classes2.dex */
public final class jad_an {
    public final Map<String, Object> jad_an = new HashMap();
    public final ReadWriteLock jad_bo = new ReentrantReadWriteLock();

    /* renamed from: com.jd.ad.sdk.jad_uh.jad_an$jad_an */
    public class RunnableC0355jad_an implements Runnable {
        public final /* synthetic */ String jad_an;
        public final /* synthetic */ Object jad_bo;

        public RunnableC0355jad_an(jad_an jad_anVar, String str, Object obj) {
            this.jad_an = str;
            this.jad_bo = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            jad_cp.jad_an((jad_dq) null, this.jad_an, this.jad_bo);
        }
    }

    public static final class jad_bo {
        public static final jad_an jad_an = new jad_an();
    }

    public boolean jad_an(String str, boolean z10) {
        try {
            return z10 ? this.jad_an.containsKey(str) : jad_jt.jad_dq(com.jd.ad.sdk.jad_fq.jad_cp.jad_an()) ? jad_bo.jad_an.jad_an.jad_an(str, z10) : jad_cp.jad_an(str);
        } catch (Exception unused) {
            return false;
        }
    }

    public synchronized void jad_bo(String str, Object obj) {
        try {
            try {
                if (this.jad_an.containsKey(str)) {
                    Object obj2 = this.jad_an.get(str);
                    if (obj2 != null && !obj2.equals(obj)) {
                        this.jad_an.put(str, obj);
                    }
                } else {
                    this.jad_an.put(str, obj);
                }
            } catch (Exception e10) {
                Logger.w("Exception while mem: ", e10.getMessage());
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public int jad_cp(String str) {
        Object jad_bo2 = jad_bo.jad_an.jad_bo(str);
        if (jad_bo2 == null || !(jad_bo2 instanceof Integer)) {
            return -1;
        }
        return ((Integer) jad_bo2).intValue();
    }

    public String jad_dq(String str) {
        Object jad_bo2 = jad_bo.jad_an.jad_bo(str);
        return (jad_bo2 == null || !(jad_bo2 instanceof String)) ? "" : (String) jad_bo2;
    }

    public void jad_an(String str, Object obj) {
        this.jad_bo.writeLock().lock();
        try {
            try {
                if (jad_jt.jad_dq(com.jd.ad.sdk.jad_fq.jad_cp.jad_an())) {
                    jad_bo.jad_an.jad_an.jad_an(str, obj);
                } else {
                    WorkExecutor.execute(new RunnableC0355jad_an(this, str, obj));
                }
                this.jad_bo.writeLock().unlock();
            } catch (Exception e10) {
                com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.CACHE_SAVE_CACHE_OTHER_ERROR;
                jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e10.getMessage()));
                this.jad_bo.writeLock().unlock();
            }
        } catch (Throwable th2) {
            this.jad_bo.writeLock().unlock();
            throw th2;
        }
    }

    public Object jad_bo(String str) {
        Object obj;
        this.jad_bo.readLock().lock();
        try {
        } catch (Exception unused) {
        } catch (Throwable th2) {
            this.jad_bo.readLock().unlock();
            throw th2;
        }
        if (this.jad_an.containsKey(str)) {
            obj = this.jad_an.get(str);
            this.jad_bo.readLock().unlock();
            return obj;
        }
        obj = null;
        this.jad_bo.readLock().unlock();
        return obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T jad_an(String str, Class<T> cls) {
        T t10;
        this.jad_bo.readLock().lock();
        T t11 = null;
        try {
            try {
                if (jad_jt.jad_dq(com.jd.ad.sdk.jad_fq.jad_cp.jad_an())) {
                    t10 = jad_bo.jad_an.jad_an.jad_an(str, (Class) cls);
                } else if (this.jad_an.containsKey(str)) {
                    t10 = jad_an(cls, this.jad_an.get(str));
                } else {
                    t10 = jad_an(cls, jad_cp.jad_an((jad_dq) null, str, (Class<?>) cls));
                }
                t11 = t10;
            } catch (Exception e10) {
                com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.CACHE_READ_CACHE_ERROR;
                jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e10.getMessage()));
                this.jad_bo.readLock().unlock();
            }
            return t11;
        } finally {
            this.jad_bo.readLock().unlock();
        }
    }

    public final <T> T jad_an(Class<T> cls, Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            String valueOf = String.valueOf(obj);
            if (TextUtils.isEmpty(valueOf)) {
                return null;
            }
            if (cls == String.class) {
                obj = (T) valueOf;
            } else if (cls == Integer.TYPE) {
                obj = (T) Integer.valueOf(valueOf);
            } else if (cls == Long.TYPE) {
                obj = (T) Long.valueOf(valueOf);
            } else if (cls == Float.TYPE) {
                obj = (T) Float.valueOf(valueOf);
            } else if (cls == Boolean.TYPE) {
                obj = (T) Boolean.valueOf(valueOf);
            } else if (cls == Double.TYPE) {
                obj = (T) Double.valueOf(valueOf);
            }
            return (T) obj;
        } catch (Exception e10) {
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.CACHE_READ_CACHE_ERROR;
            jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e10.getMessage()));
            return null;
        }
    }

    public void jad_an(String str, String str2) {
        byte[] bytes;
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                String ja2 = ANEProxy.ja(str2);
                if (!TextUtils.isEmpty(ja2) && (bytes = ja2.getBytes(StandardCharsets.UTF_8)) != null && bytes.length > 0) {
                    jad_bo.jad_an.jad_an(str, (Object) new String(bytes));
                }
            }
        } catch (Exception e10) {
            StringBuilder jad_an = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("Exception while s2ce: ");
            jad_an.append(e10.getMessage());
            Logger.w(jad_an.toString(), new Object[0]);
        }
    }

    public String jad_an(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            String str2 = (String) jad_bo.jad_an.jad_an(str, String.class);
            if (TextUtils.isEmpty(str2)) {
                return "";
            }
            String jb2 = ANEProxy.jb(str2);
            return TextUtils.isEmpty(jb2) ? "" : jb2;
        } catch (Exception e10) {
            StringBuilder jad_an = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("Exception while gfcd: ");
            jad_an.append(e10.getMessage());
            Logger.w(jad_an.toString(), new Object[0]);
            return "";
        }
    }
}
