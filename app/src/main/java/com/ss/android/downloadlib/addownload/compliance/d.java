package com.ss.android.downloadlib.addownload.compliance;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.downloadlib.g.c;
import com.ss.android.downloadlib.g.m;
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
public class d extends LruCache<Long, Bitmap> {

    /* renamed from: a */
    private final Map<Long, SoftReference<a>> f21299a;

    /* renamed from: com.ss.android.downloadlib.addownload.compliance.d$1 */
    public class AnonymousClass1 implements c.a<Object, Object> {

        /* renamed from: a */
        final /* synthetic */ long f21300a;

        public AnonymousClass1(long j10) {
            j10 = j10;
        }

        @Override // com.ss.android.downloadlib.g.c.a
        public Object a(Object obj) {
            SoftReference softReference = (SoftReference) d.this.f21299a.remove(Long.valueOf(j10));
            if (softReference == null || softReference.get() == null) {
                return null;
            }
            ((a) softReference.get()).a(d.this.get(Long.valueOf(j10)));
            return null;
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.compliance.d$2 */
    public class AnonymousClass2 implements c.a<Object, Object> {

        /* renamed from: a */
        final /* synthetic */ String f21302a;

        /* renamed from: b */
        final /* synthetic */ long f21303b;

        /* renamed from: c */
        final /* synthetic */ long f21304c;

        public AnonymousClass2(String str, long j10, long j11) {
            str = str;
            j11 = j10;
            j10 = j11;
        }

        @Override // com.ss.android.downloadlib.g.c.a
        public Object a(Object obj) {
            BufferedInputStream bufferedInputStream;
            Throwable th2;
            IDownloadHttpConnection downloadWithConnection;
            try {
                downloadWithConnection = DownloadComponentManager.downloadWithConnection(true, 0, str, null);
            } catch (Exception e10) {
                e = e10;
                bufferedInputStream = null;
            } catch (Throwable th3) {
                bufferedInputStream = null;
                th2 = th3;
                DownloadUtils.safeClose(bufferedInputStream);
                throw th2;
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
                    int i10 = options.outWidth;
                    int i11 = options.outHeight;
                    int a10 = m.a(k.a(), 60.0f);
                    options.inSampleSize = d.b(a10, a10, options);
                    options.inJustDecodeBounds = false;
                    bufferedInputStream.reset();
                    Bitmap decodeStream = BitmapFactory.decodeStream(bufferedInputStream, null, options);
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt("ttdownloader_type", "load_bitmap");
                        jSONObject.putOpt("bm_original_w", Integer.valueOf(i10));
                        jSONObject.putOpt("bm_original_h", Integer.valueOf(i11));
                        jSONObject.putOpt("bm_bytes", Integer.valueOf(decodeStream == null ? -1 : decodeStream.getByteCount()));
                    } catch (Exception e11) {
                        e11.printStackTrace();
                    }
                    com.ss.android.downloadlib.d.a.a().a("ttd_pref_monitor", jSONObject, j11);
                    d.this.put(Long.valueOf(j10), decodeStream);
                    DownloadUtils.safeClose(bufferedInputStream);
                } catch (Throwable th4) {
                    th2 = th4;
                    DownloadUtils.safeClose(bufferedInputStream);
                    throw th2;
                }
            } catch (Exception e12) {
                e = e12;
                com.ss.android.downloadlib.e.c.a().a(e, "BitmapCache loadBitmap");
                DownloadUtils.safeClose(bufferedInputStream);
                return null;
            }
            return null;
        }
    }

    public interface a {
        void a(Bitmap bitmap);
    }

    public static class b {

        /* renamed from: a */
        private static d f21306a = new d();
    }

    public /* synthetic */ d(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static int b(int i10, int i11, BitmapFactory.Options options) {
        int i12 = options.outWidth;
        if (i12 > i10 || options.outHeight > i11) {
            return Math.min(Math.round(i12 / i10), Math.round(options.outHeight / i11));
        }
        return 1;
    }

    private d() {
        super(8, 8);
        this.f21299a = new HashMap();
    }

    public static d a() {
        return b.f21306a;
    }

    public void a(long j10, @NonNull a aVar) {
        if (get(Long.valueOf(j10)) != null) {
            aVar.a(get(Long.valueOf(j10)));
        } else {
            this.f21299a.put(Long.valueOf(j10), new SoftReference<>(aVar));
        }
    }

    public void a(long j10, long j11, String str) {
        if (get(Long.valueOf(j10)) != null) {
            SoftReference<a> remove = this.f21299a.remove(Long.valueOf(j10));
            if (remove == null || remove.get() == null) {
                return;
            }
            remove.get().a(get(Long.valueOf(j10)));
            return;
        }
        if (TextUtils.isEmpty(str)) {
            g.a(12, j11);
        } else {
            com.ss.android.downloadlib.g.c.a(new c.a<Object, Object>() { // from class: com.ss.android.downloadlib.addownload.compliance.d.2

                /* renamed from: a */
                final /* synthetic */ String f21302a;

                /* renamed from: b */
                final /* synthetic */ long f21303b;

                /* renamed from: c */
                final /* synthetic */ long f21304c;

                public AnonymousClass2(String str2, long j112, long j102) {
                    str = str2;
                    j11 = j112;
                    j10 = j102;
                }

                @Override // com.ss.android.downloadlib.g.c.a
                public Object a(Object obj) {
                    BufferedInputStream bufferedInputStream;
                    Throwable th2;
                    IDownloadHttpConnection downloadWithConnection;
                    try {
                        downloadWithConnection = DownloadComponentManager.downloadWithConnection(true, 0, str, null);
                    } catch (Exception e10) {
                        e = e10;
                        bufferedInputStream = null;
                    } catch (Throwable th3) {
                        bufferedInputStream = null;
                        th2 = th3;
                        DownloadUtils.safeClose(bufferedInputStream);
                        throw th2;
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
                            int i10 = options.outWidth;
                            int i11 = options.outHeight;
                            int a10 = m.a(k.a(), 60.0f);
                            options.inSampleSize = d.b(a10, a10, options);
                            options.inJustDecodeBounds = false;
                            bufferedInputStream.reset();
                            Bitmap decodeStream = BitmapFactory.decodeStream(bufferedInputStream, null, options);
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.putOpt("ttdownloader_type", "load_bitmap");
                                jSONObject.putOpt("bm_original_w", Integer.valueOf(i10));
                                jSONObject.putOpt("bm_original_h", Integer.valueOf(i11));
                                jSONObject.putOpt("bm_bytes", Integer.valueOf(decodeStream == null ? -1 : decodeStream.getByteCount()));
                            } catch (Exception e11) {
                                e11.printStackTrace();
                            }
                            com.ss.android.downloadlib.d.a.a().a("ttd_pref_monitor", jSONObject, j11);
                            d.this.put(Long.valueOf(j10), decodeStream);
                            DownloadUtils.safeClose(bufferedInputStream);
                        } catch (Throwable th4) {
                            th2 = th4;
                            DownloadUtils.safeClose(bufferedInputStream);
                            throw th2;
                        }
                    } catch (Exception e12) {
                        e = e12;
                        com.ss.android.downloadlib.e.c.a().a(e, "BitmapCache loadBitmap");
                        DownloadUtils.safeClose(bufferedInputStream);
                        return null;
                    }
                    return null;
                }
            }, (Object) null).a(new c.a<Object, Object>() { // from class: com.ss.android.downloadlib.addownload.compliance.d.1

                /* renamed from: a */
                final /* synthetic */ long f21300a;

                public AnonymousClass1(long j102) {
                    j10 = j102;
                }

                @Override // com.ss.android.downloadlib.g.c.a
                public Object a(Object obj) {
                    SoftReference softReference = (SoftReference) d.this.f21299a.remove(Long.valueOf(j10));
                    if (softReference == null || softReference.get() == null) {
                        return null;
                    }
                    ((a) softReference.get()).a(d.this.get(Long.valueOf(j10)));
                    return null;
                }
            }).a();
        }
    }
}
