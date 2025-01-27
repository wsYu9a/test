package com.ss.android.downloadlib.addownload.compliance;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.downloadlib.addownload.pa;
import com.ss.android.downloadlib.lg.i;
import com.ss.android.downloadlib.lg.nt;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.network.IDownloadHttpConnection;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.ss.android.socialbase.downloader.utils.LruCache;
import java.io.BufferedInputStream;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class g extends LruCache<Long, Bitmap> {

    /* renamed from: j */
    private final Map<Long, SoftReference<j>> f24115j;

    /* renamed from: com.ss.android.downloadlib.addownload.compliance.g$1 */
    class AnonymousClass1 implements i.j<Object, Object> {

        /* renamed from: j */
        final /* synthetic */ long f24116j;

        AnonymousClass1(long j2) {
            j2 = j2;
        }

        @Override // com.ss.android.downloadlib.lg.i.j
        public Object j(Object obj) {
            SoftReference softReference = (SoftReference) g.this.f24115j.remove(Long.valueOf(j2));
            if (softReference == null || softReference.get() == null) {
                return null;
            }
            ((j) softReference.get()).j(g.this.get(Long.valueOf(j2)));
            return null;
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.compliance.g$2 */
    class AnonymousClass2 implements i.j<Object, Object> {

        /* renamed from: i */
        final /* synthetic */ long f24118i;

        /* renamed from: j */
        final /* synthetic */ String f24119j;
        final /* synthetic */ long zx;

        AnonymousClass2(String str, long j2, long j3) {
            str = str;
            j3 = j2;
            j2 = j3;
        }

        @Override // com.ss.android.downloadlib.lg.i.j
        public Object j(Object obj) {
            BufferedInputStream bufferedInputStream;
            Throwable th;
            IDownloadHttpConnection downloadWithConnection;
            try {
                downloadWithConnection = DownloadComponentManager.downloadWithConnection(true, 0, str, null);
            } catch (Exception e2) {
                e = e2;
                bufferedInputStream = null;
            } catch (Throwable th2) {
                bufferedInputStream = null;
                th = th2;
                DownloadUtils.safeClose(bufferedInputStream);
                throw th;
            }
            if (downloadWithConnection == null) {
                DownloadUtils.safeClose(null);
                return null;
            }
            bufferedInputStream = new BufferedInputStream(downloadWithConnection.getInputStream());
            try {
                try {
                    bufferedInputStream.mark(bufferedInputStream.available());
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeStream(bufferedInputStream, null, options);
                    int i2 = options.outWidth;
                    int i3 = options.outHeight;
                    int j2 = nt.j(pa.getContext(), 60.0f);
                    options.inSampleSize = g.zx(j2, j2, options);
                    options.inJustDecodeBounds = false;
                    bufferedInputStream.reset();
                    Bitmap decodeStream = BitmapFactory.decodeStream(bufferedInputStream, null, options);
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt("ttdownloader_type", "load_bitmap");
                        jSONObject.putOpt("bm_original_w", Integer.valueOf(i2));
                        jSONObject.putOpt("bm_original_h", Integer.valueOf(i3));
                        jSONObject.putOpt("bm_bytes", Integer.valueOf(decodeStream == null ? -1 : decodeStream.getByteCount()));
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    com.ss.android.downloadlib.g.j.j().j("ttd_pref_monitor", jSONObject, j3);
                    g.this.put(Long.valueOf(j2), decodeStream);
                    DownloadUtils.safeClose(bufferedInputStream);
                } catch (Throwable th3) {
                    th = th3;
                    DownloadUtils.safeClose(bufferedInputStream);
                    throw th;
                }
            } catch (Exception e4) {
                e = e4;
                com.ss.android.downloadlib.q.i.j().j(e, "BitmapCache loadBitmap");
                DownloadUtils.safeClose(bufferedInputStream);
                return null;
            }
            return null;
        }
    }

    public interface j {
        void j(Bitmap bitmap);
    }

    private static class zx {

        /* renamed from: j */
        private static g f24120j = new g();
    }

    /* synthetic */ g(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static int zx(int i2, int i3, BitmapFactory.Options options) {
        int i4 = options.outWidth;
        if (i4 > i2 || options.outHeight > i3) {
            return Math.min(Math.round(i4 / i2), Math.round(options.outHeight / i3));
        }
        return 1;
    }

    private g() {
        super(8, 8);
        this.f24115j = new HashMap();
    }

    public static g j() {
        return zx.f24120j;
    }

    public void j(long j2, @NonNull j jVar) {
        if (get(Long.valueOf(j2)) != null) {
            jVar.j(get(Long.valueOf(j2)));
        } else {
            this.f24115j.put(Long.valueOf(j2), new SoftReference<>(jVar));
        }
    }

    public void j(long j2, long j3, String str) {
        if (get(Long.valueOf(j2)) != null) {
            SoftReference<j> remove = this.f24115j.remove(Long.valueOf(j2));
            if (remove == null || remove.get() == null) {
                return;
            }
            remove.get().j(get(Long.valueOf(j2)));
            return;
        }
        if (TextUtils.isEmpty(str)) {
            q.j(12, j3);
        } else {
            com.ss.android.downloadlib.lg.i.j(new i.j<Object, Object>() { // from class: com.ss.android.downloadlib.addownload.compliance.g.2

                /* renamed from: i */
                final /* synthetic */ long f24118i;

                /* renamed from: j */
                final /* synthetic */ String f24119j;
                final /* synthetic */ long zx;

                AnonymousClass2(String str2, long j32, long j22) {
                    str = str2;
                    j3 = j32;
                    j2 = j22;
                }

                @Override // com.ss.android.downloadlib.lg.i.j
                public Object j(Object obj) {
                    BufferedInputStream bufferedInputStream;
                    Throwable th;
                    IDownloadHttpConnection downloadWithConnection;
                    try {
                        downloadWithConnection = DownloadComponentManager.downloadWithConnection(true, 0, str, null);
                    } catch (Exception e2) {
                        e = e2;
                        bufferedInputStream = null;
                    } catch (Throwable th2) {
                        bufferedInputStream = null;
                        th = th2;
                        DownloadUtils.safeClose(bufferedInputStream);
                        throw th;
                    }
                    if (downloadWithConnection == null) {
                        DownloadUtils.safeClose(null);
                        return null;
                    }
                    bufferedInputStream = new BufferedInputStream(downloadWithConnection.getInputStream());
                    try {
                        try {
                            bufferedInputStream.mark(bufferedInputStream.available());
                            BitmapFactory.Options options = new BitmapFactory.Options();
                            options.inJustDecodeBounds = true;
                            BitmapFactory.decodeStream(bufferedInputStream, null, options);
                            int i2 = options.outWidth;
                            int i3 = options.outHeight;
                            int j22 = nt.j(pa.getContext(), 60.0f);
                            options.inSampleSize = g.zx(j22, j22, options);
                            options.inJustDecodeBounds = false;
                            bufferedInputStream.reset();
                            Bitmap decodeStream = BitmapFactory.decodeStream(bufferedInputStream, null, options);
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.putOpt("ttdownloader_type", "load_bitmap");
                                jSONObject.putOpt("bm_original_w", Integer.valueOf(i2));
                                jSONObject.putOpt("bm_original_h", Integer.valueOf(i3));
                                jSONObject.putOpt("bm_bytes", Integer.valueOf(decodeStream == null ? -1 : decodeStream.getByteCount()));
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                            com.ss.android.downloadlib.g.j.j().j("ttd_pref_monitor", jSONObject, j3);
                            g.this.put(Long.valueOf(j2), decodeStream);
                            DownloadUtils.safeClose(bufferedInputStream);
                        } catch (Throwable th3) {
                            th = th3;
                            DownloadUtils.safeClose(bufferedInputStream);
                            throw th;
                        }
                    } catch (Exception e4) {
                        e = e4;
                        com.ss.android.downloadlib.q.i.j().j(e, "BitmapCache loadBitmap");
                        DownloadUtils.safeClose(bufferedInputStream);
                        return null;
                    }
                    return null;
                }
            }, (Object) null).j(new i.j<Object, Object>() { // from class: com.ss.android.downloadlib.addownload.compliance.g.1

                /* renamed from: j */
                final /* synthetic */ long f24116j;

                AnonymousClass1(long j22) {
                    j2 = j22;
                }

                @Override // com.ss.android.downloadlib.lg.i.j
                public Object j(Object obj) {
                    SoftReference softReference = (SoftReference) g.this.f24115j.remove(Long.valueOf(j2));
                    if (softReference == null || softReference.get() == null) {
                        return null;
                    }
                    ((j) softReference.get()).j(g.this.get(Long.valueOf(j2)));
                    return null;
                }
            }).j();
        }
    }
}
