package com.sigmob.sdk.base.common;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.bm;
import com.czhj.sdk.common.ThreadPool.ThreadPoolFactory;
import com.czhj.sdk.common.models.AdCache;
import com.czhj.sdk.common.utils.FileUtil;
import com.czhj.sdk.common.utils.ImageManager;
import com.czhj.sdk.common.utils.Md5Util;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.volley.VolleyError;
import com.czhj.volley.toolbox.DownloadItem;
import com.czhj.volley.toolbox.FileDownloadRequest;
import com.czhj.volley.toolbox.FileDownloader;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.rtb.AdPrivacy;
import com.sigmob.sdk.base.models.rtb.BidResponse;
import com.sigmob.sdk.base.models.rtb.MaterialMeta;
import com.sigmob.sdk.base.models.rtb.ResponseAsset;
import com.sigmob.sdk.base.models.rtb.ResponseAssetVideo;
import com.sigmob.sdk.base.models.rtb.Template;
import com.sigmob.sdk.videocache.h;
import com.sigmob.windad.WindAdError;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes4.dex */
public class h {

    /* renamed from: t */
    public static com.sigmob.sdk.videocache.h f17767t;

    /* renamed from: v */
    public static volatile ImageManager f17769v;

    /* renamed from: w */
    public static BaseAdUnit f17770w;

    /* renamed from: d */
    public String f17777d;

    /* renamed from: e */
    public String f17778e;

    /* renamed from: i */
    public String f17782i;

    /* renamed from: j */
    public String f17783j;

    /* renamed from: n */
    public static final Integer f17761n = 0;

    /* renamed from: o */
    public static final Integer f17762o = 1;

    /* renamed from: p */
    public static final Integer f17763p = 2;

    /* renamed from: q */
    public static final Integer f17764q = 3;

    /* renamed from: r */
    public static h f17765r = null;

    /* renamed from: s */
    public static Map<String, BaseAdUnit> f17766s = new HashMap();

    /* renamed from: u */
    public static HashMap<String, Integer> f17768u = new HashMap<>();

    /* renamed from: x */
    public static HashMap<String, BidResponse> f17771x = new HashMap<>();

    /* renamed from: y */
    public static HashMap<String, Integer> f17772y = new HashMap<>();

    /* renamed from: z */
    public static Map<String, List<BaseAdUnit>> f17773z = new HashMap();

    /* renamed from: a */
    public Map<String, String> f17774a = new HashMap();

    /* renamed from: b */
    public HashMap<String, Long> f17775b = new HashMap<>();

    /* renamed from: c */
    public HashSet<e> f17776c = new HashSet<>();

    /* renamed from: f */
    public final FileDownloadRequest.FileDownloadListener f17779f = new a();

    /* renamed from: g */
    public ArrayList<BaseAdUnit> f17780g = new ArrayList<>();

    /* renamed from: h */
    public HashMap<String, AdCache> f17781h = new HashMap<>();

    /* renamed from: k */
    public HashMap<String, f> f17784k = new HashMap<>();

    /* renamed from: l */
    public HashMap<String, AdCache> f17785l = new HashMap<>();

    /* renamed from: m */
    public Map<String, AdCache> f17786m = new HashMap();

    public class a implements FileDownloadRequest.FileDownloadListener {
        public a() {
        }

        @Override // com.czhj.volley.toolbox.FileDownloadRequest.FileDownloadListener
        public void downloadProgress(DownloadItem downloadItem, long j10, long j11) {
        }

        @Override // com.czhj.volley.toolbox.FileDownloadRequest.FileDownloadListener
        public void onCancel(DownloadItem downloadItem) {
            h.f17768u.put(Md5Util.md5(downloadItem.url), h.f17764q);
            Iterator it = h.this.f17776c.iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                BaseAdUnit a10 = eVar.a();
                if (a10 != null && downloadItem.type == DownloadItem.FileType.FILE && a10.getEndCardZipPath().equals(downloadItem.filePath)) {
                    eVar.b(a10);
                }
            }
        }

        @Override // com.czhj.volley.toolbox.FileDownloadRequest.FileDownloadListener
        public void onErrorResponse(DownloadItem downloadItem) {
            SigmobLog.e("onErrorResponse: ", downloadItem.error);
            h.f17768u.put(Md5Util.md5(downloadItem.url), h.f17764q);
            Iterator it = h.this.f17776c.iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                BaseAdUnit a10 = eVar.a();
                if (a10 != null && a10.getEndCardZipPath().equals(downloadItem.filePath) && downloadItem.type == DownloadItem.FileType.FILE) {
                    eVar.b(a10);
                }
            }
            h.this.new g(downloadItem).executeOnExecutor(ThreadPoolFactory.BackgroundThreadPool.getInstance().getExecutorService(), new Object[0]);
        }

        @Override // com.czhj.volley.toolbox.FileDownloadRequest.FileDownloadListener
        public void onSuccess(DownloadItem downloadItem) {
            h.f17768u.put(Md5Util.md5(downloadItem.url), h.f17764q);
            Iterator it = h.this.f17776c.iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                BaseAdUnit a10 = eVar.a();
                if (a10 != null && downloadItem.type == DownloadItem.FileType.FILE && a10.getEndCardZipPath().equals(downloadItem.filePath)) {
                    eVar.a(a10);
                }
            }
            h.this.new g(downloadItem).executeOnExecutor(ThreadPoolFactory.BackgroundThreadPool.getInstance().getExecutorService(), new Object[0]);
        }
    }

    public class b implements com.sigmob.sdk.videocache.d {

        /* renamed from: a */
        public final /* synthetic */ DownloadItem f17788a;

        /* renamed from: b */
        public final /* synthetic */ long f17789b;

        public b(DownloadItem downloadItem, long j10) {
            this.f17788a = downloadItem;
            this.f17789b = j10;
        }

        @Override // com.sigmob.sdk.videocache.d
        public void a(File file, String str, int i10) {
            SigmobLog.d(file + " onCacheAvailable " + i10);
            if (i10 != 100 || file == null || file.getAbsolutePath().endsWith("download")) {
                return;
            }
            h.f17767t.a(this);
            this.f17788a.networkMs = System.currentTimeMillis() - this.f17789b;
            h.this.new g(this.f17788a).executeOnExecutor(ThreadPoolFactory.BackgroundThreadPool.getInstance().getExecutorService(), new Object[0]);
        }

        @Override // com.sigmob.sdk.videocache.d
        public void a(String str, Throwable th2) {
            h.f17767t.a(this);
            this.f17788a.error = new VolleyError(WindAdError.ERROR_SIGMOB_VIDEO_FILE.getMessage());
            this.f17788a.networkMs = System.currentTimeMillis() - this.f17789b;
            h.this.new g(this.f17788a).executeOnExecutor(ThreadPoolFactory.BackgroundThreadPool.getInstance().getExecutorService(), new Object[0]);
            SigmobLog.e(str + " onCacheUnavailable ", th2);
        }
    }

    public class c implements FileDownloadRequest.FileDownloadListener {
        public c() {
        }

        @Override // com.czhj.volley.toolbox.FileDownloadRequest.FileDownloadListener
        public void downloadProgress(DownloadItem downloadItem, long j10, long j11) {
        }

        @Override // com.czhj.volley.toolbox.FileDownloadRequest.FileDownloadListener
        public void onCancel(DownloadItem downloadItem) {
        }

        @Override // com.czhj.volley.toolbox.FileDownloadRequest.FileDownloadListener
        public void onErrorResponse(DownloadItem downloadItem) {
        }

        @Override // com.czhj.volley.toolbox.FileDownloadRequest.FileDownloadListener
        public void onSuccess(DownloadItem downloadItem) {
        }
    }

    public class d implements FileDownloadRequest.FileDownloadListener {

        /* renamed from: a */
        public final /* synthetic */ f f17792a;

        /* renamed from: b */
        public final /* synthetic */ BaseAdUnit f17793b;

        public d(f fVar, BaseAdUnit baseAdUnit) {
            this.f17792a = fVar;
            this.f17793b = baseAdUnit;
        }

        @Override // com.czhj.volley.toolbox.FileDownloadRequest.FileDownloadListener
        public void downloadProgress(DownloadItem downloadItem, long j10, long j11) {
        }

        @Override // com.czhj.volley.toolbox.FileDownloadRequest.FileDownloadListener
        public void onCancel(DownloadItem downloadItem) {
        }

        @Override // com.czhj.volley.toolbox.FileDownloadRequest.FileDownloadListener
        public void onErrorResponse(DownloadItem downloadItem) {
            String message = downloadItem.error.getMessage();
            if (downloadItem.error.networkResponse != null) {
                message = message + " status code " + downloadItem.error.networkResponse.statusCode;
            }
            f fVar = this.f17792a;
            if (fVar != null) {
                fVar.d(this.f17793b, message);
            }
            SigmobLog.e("onErrorResponse: " + message);
        }

        @Override // com.czhj.volley.toolbox.FileDownloadRequest.FileDownloadListener
        public void onSuccess(DownloadItem downloadItem) {
            f fVar = this.f17792a;
            if (fVar != null) {
                fVar.d(this.f17793b, null);
            }
        }
    }

    public interface e {
        BaseAdUnit a();

        void a(BaseAdUnit baseAdUnit);

        void b(BaseAdUnit baseAdUnit);
    }

    public interface f {
        void d(BaseAdUnit baseAdUnit, String str);

        void i(BaseAdUnit baseAdUnit);
    }

    public class g extends AsyncTask<Object, Void, String> {

        /* renamed from: a */
        public DownloadItem f17795a;

        public g(DownloadItem downloadItem) {
            this.f17795a = downloadItem;
        }

        @Override // android.os.AsyncTask
        /* renamed from: a */
        public String doInBackground(Object... objArr) {
            WindAdError windAdError;
            String message;
            DownloadItem downloadItem = this.f17795a;
            if (downloadItem != null) {
                VolleyError volleyError = downloadItem.error;
                if (volleyError != null) {
                    return volleyError.toString();
                }
                String str = downloadItem.filePath;
                String extensionName = FileUtil.getExtensionName(str);
                String fileMd5 = Md5Util.fileMd5(str);
                if (TextUtils.isEmpty(this.f17795a.md5) || this.f17795a.md5.equalsIgnoreCase(fileMd5)) {
                    if (this.f17795a.type == DownloadItem.FileType.VIDEO) {
                        h.this.f17774a.put(str, fileMd5);
                        this.f17795a.status = 1;
                    } else if (TextUtils.isEmpty(extensionName) || !extensionName.equalsIgnoreCase("tgz")) {
                        DownloadItem downloadItem2 = this.f17795a;
                        if (downloadItem2.type == DownloadItem.FileType.MRAID_VIDEO) {
                            return null;
                        }
                        downloadItem2.status = 0;
                        windAdError = WindAdError.ERROR_SIGMOB_INFORMATION_LOSE;
                    } else {
                        try {
                            com.sigmob.sdk.base.utils.b.a(new File(str), new File(str.replace(".tgz", "/")));
                            this.f17795a.status = 1;
                        } catch (Throwable th2) {
                            this.f17795a.status = 0;
                            message = th2.getMessage();
                        }
                    }
                    return null;
                }
                this.f17795a.status = 0;
                windAdError = WindAdError.ERROR_SIGMOB_FILE_MD5;
                return windAdError.toString();
            }
            message = "Download Item is null";
            SigmobLog.e(message);
            windAdError = WindAdError.ERROR_SIGMOB_FILE_DOWNLOAD;
            return windAdError.toString();
        }

        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(String str) {
            DownloadItem downloadItem;
            DownloadItem.FileType fileType;
            super.onPostExecute(str);
            if (!TextUtils.isEmpty(str)) {
                FileUtil.deleteFile(this.f17795a.filePath);
            }
            Iterator it = new CopyOnWriteArrayList(h.this.f17780g).iterator();
            while (it.hasNext()) {
                BaseAdUnit baseAdUnit = (BaseAdUnit) it.next();
                f fVar = (f) h.this.f17784k.get(baseAdUnit.getUuid());
                if (this.f17795a.type == DownloadItem.FileType.VIDEO && baseAdUnit.getVideoPath().equals(this.f17795a.filePath)) {
                    downloadItem = this.f17795a;
                } else {
                    if ((this.f17795a.type != DownloadItem.FileType.FILE || !baseAdUnit.getEndCardZipPath().equals(this.f17795a.filePath)) && (fileType = (downloadItem = this.f17795a).type) != DownloadItem.FileType.ZIP_FILE) {
                        if (fileType == DownloadItem.FileType.MRAID_VIDEO) {
                        }
                    }
                    h.this.a(baseAdUnit, str, fVar);
                }
                b0.a(downloadItem, baseAdUnit, str, false);
                h.this.a(baseAdUnit, str, fVar);
            }
        }
    }

    /* renamed from: com.sigmob.sdk.base.common.h$h */
    public class AsyncTaskC0563h extends AsyncTask<Object, Void, ArrayList<DownloadItem>> {

        /* renamed from: a */
        public BaseAdUnit f17797a;

        /* renamed from: com.sigmob.sdk.base.common.h$h$a */
        public class a implements FileDownloadRequest.FileDownloadListener {
            public a() {
            }

            @Override // com.czhj.volley.toolbox.FileDownloadRequest.FileDownloadListener
            public void downloadProgress(DownloadItem downloadItem, long j10, long j11) {
            }

            @Override // com.czhj.volley.toolbox.FileDownloadRequest.FileDownloadListener
            public void onCancel(DownloadItem downloadItem) {
                SigmobLog.i("onPostExecute onCancel:" + downloadItem.url);
            }

            @Override // com.czhj.volley.toolbox.FileDownloadRequest.FileDownloadListener
            public void onErrorResponse(DownloadItem downloadItem) {
                SigmobLog.i("onPostExecute onErrorResponse:" + downloadItem.url);
            }

            @Override // com.czhj.volley.toolbox.FileDownloadRequest.FileDownloadListener
            public void onSuccess(DownloadItem downloadItem) {
                SigmobLog.i("onPostExecute onSuccess:" + downloadItem.url);
            }
        }

        public AsyncTaskC0563h(BaseAdUnit baseAdUnit) {
            this.f17797a = baseAdUnit;
        }

        @Override // android.os.AsyncTask
        /* renamed from: a */
        public ArrayList<DownloadItem> doInBackground(Object... objArr) {
            List<ResponseAsset> list;
            ResponseAssetVideo responseAssetVideo;
            DownloadItem a10;
            DownloadItem a11;
            DownloadItem a12;
            String str;
            try {
                ArrayList<DownloadItem> arrayList = new ArrayList<>();
                BaseAdUnit baseAdUnit = this.f17797a;
                if (baseAdUnit != null && baseAdUnit.getMaterial() != null) {
                    MaterialMeta material = this.f17797a.getMaterial();
                    if (!TextUtils.isEmpty(this.f17797a.getVideo_url())) {
                        long j10 = 0;
                        if (this.f17797a.isVideoExist()) {
                            str = Md5Util.fileMd5(this.f17797a.getVideoPath());
                            if (TextUtils.isEmpty(this.f17797a.getVideo_OriginMD5()) || this.f17797a.getVideo_OriginMD5().equalsIgnoreCase(str)) {
                                h.this.f17774a.put(this.f17797a.getVideoPath(), str);
                                j10 = new File(this.f17797a.getVideoPath()).length();
                            } else {
                                FileUtil.deleteFile(this.f17797a.getVideoPath());
                            }
                        } else {
                            str = null;
                        }
                        boolean checkVideoValid = this.f17797a.checkVideoValid();
                        DownloadItem downloadItem = new DownloadItem();
                        if (checkVideoValid && this.f17797a.isVideoExist()) {
                            downloadItem.url = this.f17797a.getVideo_url();
                            downloadItem.filePath = this.f17797a.getVideoPath();
                            downloadItem.type = DownloadItem.FileType.VIDEO;
                            downloadItem.md5 = str;
                            downloadItem.size = j10;
                            downloadItem.status = 1;
                            b0.a(downloadItem, this.f17797a, (String) null, true);
                        } else if (this.f17797a.getPlayMode() != 2) {
                            downloadItem.url = this.f17797a.getVideo_url();
                            downloadItem.filePath = this.f17797a.getVideoPath();
                            downloadItem.type = DownloadItem.FileType.VIDEO;
                            downloadItem.md5 = this.f17797a.getVideo_OriginMD5();
                            h.this.a(downloadItem, this.f17797a);
                            arrayList.add(downloadItem);
                        }
                    }
                    if (material.creative_type.intValue() == m.CreativeTypeVideo_Tar.b()) {
                        DownloadItem downloadItem2 = new DownloadItem();
                        downloadItem2.url = this.f17797a.getEndcard_url();
                        downloadItem2.filePath = this.f17797a.getEndCardZipPath();
                        downloadItem2.type = DownloadItem.FileType.FILE;
                        downloadItem2.md5 = this.f17797a.getEndCard_OriginMD5();
                        arrayList.add(downloadItem2);
                    }
                    Template template = this.f17797a.scene;
                    if (template != null && template.type.intValue() == 3 && (a12 = a(this.f17797a.scene)) != null) {
                        arrayList.add(a12);
                    }
                    Template template2 = material.main_template;
                    if (template2 != null && template2.type.intValue() == 3 && (a11 = a(material.main_template)) != null) {
                        arrayList.add(a11);
                    }
                    Template template3 = material.sub_template;
                    if (template3 != null && template3.type.intValue() == 3 && (a10 = a(material.sub_template)) != null) {
                        arrayList.add(a10);
                    }
                    if (this.f17797a.isCatchVideo() && (list = material.asset) != null && list.size() > 0) {
                        for (int i10 = 0; i10 < material.asset.size(); i10++) {
                            ResponseAsset responseAsset = material.asset.get(i10);
                            if (responseAsset != null && (responseAssetVideo = responseAsset.video) != null && !TextUtils.isEmpty(responseAssetVideo.url)) {
                                File b10 = h.n().b(responseAsset.video.url);
                                if (!b10.exists()) {
                                    DownloadItem downloadItem3 = new DownloadItem();
                                    downloadItem3.url = responseAsset.video.url;
                                    downloadItem3.filePath = b10.getAbsolutePath();
                                    downloadItem3.type = DownloadItem.FileType.MRAID_VIDEO;
                                    h.this.a(downloadItem3, this.f17797a);
                                    arrayList.add(downloadItem3);
                                }
                            }
                        }
                    }
                    SigmobLog.d("cache() adUnit = [" + this.f17797a.getCrid() + "] videoUrl = [" + this.f17797a.getVideo_url() + "] endcardUrl = [" + this.f17797a.getEndcard_url() + "]");
                    return arrayList;
                }
                return null;
            } catch (Throwable th2) {
                SigmobLog.e("AdUnitCheckCacheTask error: " + th2.getMessage());
                return null;
            }
        }

        public final DownloadItem a(Template template) {
            if (!TextUtils.isEmpty(template.context.utf8())) {
                String md5 = Md5Util.md5(template.context.utf8());
                File file = new File(com.sigmob.sdk.base.utils.d.c(com.sigmob.sdk.base.utils.d.f18409f), md5 + ".tgz");
                if (!file.exists()) {
                    DownloadItem downloadItem = new DownloadItem();
                    downloadItem.url = template.context.utf8();
                    downloadItem.filePath = file.getAbsolutePath();
                    downloadItem.type = DownloadItem.FileType.ZIP_FILE;
                    return downloadItem;
                }
            }
            return null;
        }

        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(ArrayList<DownloadItem> arrayList) {
            AdPrivacy adPrivacy;
            super.onPostExecute(arrayList);
            BaseAdUnit baseAdUnit = this.f17797a;
            if (baseAdUnit == null) {
                return;
            }
            MaterialMeta material = baseAdUnit.getMaterial();
            f fVar = (f) h.this.f17784k.get(this.f17797a.getUuid());
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            if (arrayList.size() == 0) {
                if (fVar != null) {
                    fVar.d(this.f17797a, null);
                }
                h.this.c(this.f17797a);
            } else {
                FileDownloader a10 = r.a();
                Iterator it = h.this.f17780g.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (((BaseAdUnit) it.next()).getUuid().equals(this.f17797a.getUuid())) {
                            break;
                        }
                    } else if (fVar != null) {
                        h.this.f17780g.add(this.f17797a);
                    }
                }
                Iterator<DownloadItem> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    DownloadItem next = it2.next();
                    String md5 = Md5Util.md5(next.url);
                    SigmobLog.d("downloader add  item " + next.url);
                    if (next.type != DownloadItem.FileType.VIDEO && (h.f17768u.get(md5) == null || ((Integer) h.f17768u.get(md5)).equals(h.f17764q))) {
                        h.f17768u.put(md5, h.f17762o);
                        a10.add(next, h.this.f17779f);
                    }
                }
            }
            if (material == null || (adPrivacy = material.ad_privacy) == null) {
                return;
            }
            String str = adPrivacy.privacy_template_url;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            String md52 = Md5Util.md5(str);
            File b10 = com.sigmob.sdk.base.utils.d.b(com.sigmob.sdk.base.utils.d.f18408e);
            File file = new File(b10, md52 + ".html");
            if (file.exists()) {
                SigmobLog.i("privacy_template_url:" + md52 + " is exists");
                return;
            }
            try {
                if (b10.exists() && b10.isDirectory()) {
                    for (File file2 : b10.listFiles()) {
                        if (file2.exists() && file2.isFile() && file2.delete()) {
                            SigmobLog.d("删除单个文件" + file2.getAbsolutePath() + "成功！");
                        }
                    }
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            DownloadItem downloadItem = new DownloadItem();
            downloadItem.url = str;
            downloadItem.filePath = file.getAbsolutePath();
            downloadItem.type = DownloadItem.FileType.OTHER;
            arrayList.add(downloadItem);
            r.a().add(downloadItem, new a());
        }
    }

    public static void e() {
        try {
            for (File file : FileUtil.orderByDate(com.sigmob.sdk.base.utils.d.k())) {
                long currentTimeMillis = System.currentTimeMillis() - (com.sigmob.sdk.base.l.w().O() * 3600000);
                if (file.exists() && currentTimeMillis > file.lastModified()) {
                    if (file.isFile()) {
                        if (!FileUtil.deleteFile(file.getAbsolutePath())) {
                            return;
                        }
                    } else if (file.isDirectory() && !FileUtil.deleteDirectory(file.getAbsolutePath())) {
                        return;
                    }
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void f() {
        try {
            FileUtil.deleteDirectory(com.sigmob.sdk.base.utils.d.b(com.sigmob.sdk.base.utils.d.f18407d).getAbsolutePath());
            h();
        } catch (Throwable th2) {
            SigmobLog.e(th2.getMessage());
        }
    }

    public static void g() {
        try {
            File[] orderByDate = FileUtil.orderByDate(com.sigmob.sdk.base.utils.d.a(com.sigmob.sdk.a.d()).getAbsolutePath());
            if (orderByDate == null || orderByDate.length <= 0) {
                return;
            }
            for (File file : orderByDate) {
                if (System.currentTimeMillis() - file.lastModified() > bm.f6899d) {
                    SigmobLog.i("Download APK files timeOut seven day and delete:" + file.getName() + ":" + file.delete());
                }
            }
        } catch (Throwable th2) {
            SigmobLog.e("clean Download APK file error", th2);
        }
    }

    public static void h() {
        try {
            for (File file : FileUtil.orderByDate(com.sigmob.sdk.base.utils.d.c(com.sigmob.sdk.base.utils.d.f18409f).getAbsolutePath())) {
                long currentTimeMillis = System.currentTimeMillis() - com.sigmob.sdk.base.l.w().N();
                if (file.exists() && currentTimeMillis > file.lastModified()) {
                    if (file.isFile()) {
                        if (!FileUtil.deleteFile(file.getAbsolutePath())) {
                            return;
                        }
                    } else if (file.isDirectory() && !FileUtil.deleteDirectory(file.getAbsolutePath())) {
                        return;
                    }
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void i() {
        String str;
        try {
            File[] clearCacheFileByCount = FileUtil.clearCacheFileByCount(FileUtil.orderByDate(com.sigmob.sdk.base.utils.d.h()), com.sigmob.sdk.base.l.w().E());
            if (clearCacheFileByCount == null) {
                str = "native ad file list is null";
            } else {
                str = "native ad file remain num: " + clearCacheFileByCount.length;
            }
            SigmobLog.i(str);
        } catch (Throwable th2) {
            SigmobLog.e("clean native ad file error", th2);
        }
    }

    public static void j() {
        String str;
        try {
            File[] clearCacheFileByCount = FileUtil.clearCacheFileByCount(a(FileUtil.orderByDate(com.sigmob.sdk.base.utils.d.i()), System.currentTimeMillis(), com.sigmob.sdk.base.l.w().N()), com.sigmob.sdk.base.l.w().L());
            if (clearCacheFileByCount == null) {
                str = "splash ad file list is null";
            } else {
                str = "splash ad file remain num: " + clearCacheFileByCount.length;
            }
            SigmobLog.i(str);
        } catch (Throwable th2) {
            SigmobLog.e("clean splash ad file error", th2);
        }
    }

    public static void k() {
        String str;
        try {
            File[] clearCacheFileByCount = FileUtil.clearCacheFileByCount(FileUtil.orderByDate(com.sigmob.sdk.base.utils.d.j()), com.sigmob.sdk.base.l.w().n() + com.sigmob.sdk.base.l.w().E());
            if (clearCacheFileByCount == null) {
                str = "splash ad file list is null";
            } else {
                str = "splash ad file remain num: " + clearCacheFileByCount.length;
            }
            SigmobLog.i(str);
        } catch (Throwable th2) {
            SigmobLog.e("clean splash ad file error", th2);
        }
    }

    public static void l() {
        try {
            File[] orderByDate = FileUtil.orderByDate(com.sigmob.sdk.base.utils.d.d());
            ArrayList arrayList = new ArrayList(Arrays.asList(orderByDate));
            for (File file : orderByDate) {
                if (!file.getPath().endsWith(".mp4") && !file.getPath().endsWith(".mp4.tmp") && !file.getPath().endsWith(".tgz") && !file.getPath().endsWith(".html")) {
                    arrayList.remove(file);
                }
            }
            File[] clearCacheFileByCount = FileUtil.clearCacheFileByCount((File[]) arrayList.toArray(new File[0]), 5);
            SigmobLog.i(clearCacheFileByCount == null ? "splash ad file list is null" : "splash ad file remain num: " + clearCacheFileByCount.length);
        } catch (Throwable th2) {
            SigmobLog.e("clean splash ad file error", th2);
        }
    }

    public static BaseAdUnit m() {
        return f17770w;
    }

    public static synchronized com.sigmob.sdk.videocache.h n() {
        com.sigmob.sdk.videocache.h hVar;
        synchronized (h.class) {
            try {
                if (f17767t == null) {
                    r();
                }
                hVar = f17767t;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return hVar;
    }

    public static synchronized ImageManager o() {
        ImageManager imageManager;
        synchronized (h.class) {
            try {
                if (f17769v == null) {
                    File file = new File(com.sigmob.sdk.base.utils.d.h());
                    synchronized (ImageManager.class) {
                        try {
                            if (f17769v == null) {
                                f17769v = new ImageManager(com.sigmob.sdk.a.d()).customCachePath(file);
                            }
                        } finally {
                        }
                    }
                }
                imageManager = f17769v;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return imageManager;
    }

    public static synchronized void r() {
        synchronized (h.class) {
            h.b bVar = new h.b(com.sigmob.sdk.a.d());
            try {
                bVar.a(new File(com.sigmob.sdk.base.utils.d.j()));
            } catch (Throwable th2) {
                SigmobLog.e("initHttpProxyCacheServer fail ", th2);
            }
            f17767t = bVar.a();
        }
    }

    public static synchronized h s() {
        h hVar;
        synchronized (h.class) {
            try {
                if (f17765r == null) {
                    f17765r = new h();
                }
                hVar = f17765r;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return hVar;
    }

    public String p() {
        return this.f17783j;
    }

    public String q() {
        return this.f17782i;
    }

    public static BaseAdUnit f(String str) {
        return f17766s.get(str);
    }

    public static Integer g(String str) {
        if (TextUtils.isEmpty(str) || !f17772y.containsKey(str)) {
            return 1;
        }
        return f17772y.get(str);
    }

    public static void i(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f17771x.remove(str);
    }

    public final String e(String str) {
        File b10;
        if (TextUtils.isEmpty(str) || (b10 = n().b(str)) == null || !b10.exists()) {
            return null;
        }
        return b10.getAbsolutePath();
    }

    public String h(String str) {
        return this.f17774a.get(str);
    }

    public void j(String str) {
        this.f17783j = str;
    }

    public void k(String str) {
        this.f17782i = str;
    }

    public static void d(BaseAdUnit baseAdUnit) {
        if (baseAdUnit == null || TextUtils.isEmpty(baseAdUnit.getUuid())) {
            return;
        }
        f17766s.remove(baseAdUnit.getUuid());
        f17773z.remove(baseAdUnit.getUuid());
    }

    public static void f(BaseAdUnit baseAdUnit) {
        f17770w = baseAdUnit;
    }

    public static void g(BaseAdUnit baseAdUnit) {
        a(baseAdUnit);
    }

    public void b(BaseAdUnit baseAdUnit) {
        if (baseAdUnit == null || TextUtils.isEmpty(baseAdUnit.getCrid()) || TextUtils.isEmpty(baseAdUnit.getAdslot_id())) {
            return;
        }
        Map<String, AdCache> a10 = a(baseAdUnit.getAd_type());
        if ((a10 == null || a10.size() <= 29) && a10 != null) {
            AdCache adCache = a10.get(baseAdUnit.getAdslot_id());
            ArrayList arrayList = new ArrayList();
            arrayList.add(baseAdUnit.getCrid());
            if (adCache != null) {
                arrayList.addAll(adCache.crids);
            }
            a10.put(baseAdUnit.getAdslot_id(), new AdCache(Integer.valueOf(baseAdUnit.getAd_type()), arrayList));
        }
    }

    public void c(BaseAdUnit baseAdUnit) {
        this.f17780g.remove(baseAdUnit);
        this.f17784k.remove(baseAdUnit.getUuid());
    }

    public void e(BaseAdUnit baseAdUnit) {
        Map<String, AdCache> a10;
        AdCache adCache;
        if (baseAdUnit == null || TextUtils.isEmpty(baseAdUnit.getAdslot_id()) || (a10 = a(baseAdUnit.getAd_type())) == null || (adCache = a10.get(baseAdUnit.getAdslot_id())) == null) {
            return;
        }
        ArrayList arrayList = new ArrayList(adCache.crids);
        if (arrayList.contains(baseAdUnit.getCrid())) {
            arrayList.remove(baseAdUnit.getCrid());
        }
        a10.put(baseAdUnit.getAdslot_id(), new AdCache(Integer.valueOf(baseAdUnit.getAd_type()), arrayList));
    }

    public static void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f17772y.remove(str);
    }

    public static List<BaseAdUnit> c(String str) {
        return f17773z.get(str);
    }

    public static BidResponse d(String str) {
        return f17771x.get(str);
    }

    public void a(e eVar) {
        if (eVar == null || this.f17776c.contains(eVar)) {
            return;
        }
        this.f17776c.add(eVar);
    }

    public void b(e eVar) {
        if (eVar == null || !this.f17776c.contains(eVar)) {
            return;
        }
        this.f17776c.remove(eVar);
    }

    public static void a(BaseAdUnit baseAdUnit) {
        if (baseAdUnit == null || TextUtils.isEmpty(baseAdUnit.getUuid())) {
            return;
        }
        f17766s.put(baseAdUnit.getUuid(), baseAdUnit);
    }

    public final void b(BaseAdUnit baseAdUnit, f fVar) {
        if (baseAdUnit != null) {
            File adPrivacyTemplateFile = baseAdUnit.getAdPrivacyTemplateFile();
            if (adPrivacyTemplateFile != null && !adPrivacyTemplateFile.exists()) {
                DownloadItem downloadItem = new DownloadItem();
                downloadItem.url = baseAdUnit.getadPrivacy().privacy_template_url;
                downloadItem.filePath = adPrivacyTemplateFile.getAbsolutePath();
                downloadItem.type = DownloadItem.FileType.OTHER;
                FileDownloader a10 = r.a();
                if (a10 != null) {
                    a10.add(downloadItem, new c());
                }
            }
            File file = new File(baseAdUnit.getSplashFilePath());
            if (file.exists()) {
                file.setLastModified(System.currentTimeMillis());
                if (fVar != null) {
                    fVar.d(baseAdUnit, null);
                    return;
                }
                return;
            }
            FileDownloader a11 = r.a();
            DownloadItem downloadItem2 = new DownloadItem();
            downloadItem2.filePath = baseAdUnit.getSplashFilePath();
            downloadItem2.url = baseAdUnit.getSplashURL();
            downloadItem2.type = DownloadItem.FileType.OTHER;
            downloadItem2.userRange = false;
            a11.add(downloadItem2, new d(fVar, baseAdUnit));
        }
    }

    public static void a(List<BaseAdUnit> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        f17773z.put(list.get(0).getUuid(), list);
    }

    public static void a(String str, BidResponse bidResponse) {
        if (TextUtils.isEmpty(str) || bidResponse == null) {
            return;
        }
        f17771x.put(str, bidResponse);
    }

    public static void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Integer num = f17772y.get(str);
        if (num != null) {
            f17772y.put(str, Integer.valueOf(num.intValue() + 1));
        } else {
            f17772y.put(str, 1);
        }
    }

    public void a(BaseAdUnit baseAdUnit, f fVar) {
        if (fVar != null) {
            fVar.i(baseAdUnit);
        }
        if (baseAdUnit == null) {
            SigmobLog.e("adUnit is null");
            if (fVar != null) {
                fVar.d(baseAdUnit, "adUnit is null");
                return;
            }
            return;
        }
        if (baseAdUnit.getAd_type() == 2) {
            b(baseAdUnit, fVar);
            return;
        }
        if (fVar != null) {
            this.f17784k.put(baseAdUnit.getUuid(), fVar);
        }
        try {
            new AsyncTaskC0563h(baseAdUnit).executeOnExecutor(ThreadPoolFactory.BackgroundThreadPool.getInstance().getExecutorService(), new Object[0]);
        } catch (Throwable th2) {
            SigmobLog.e("AdUnitCheckCacheTask execute error", th2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0017, code lost:
    
        if (r3 != null) goto L44;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(com.sigmob.sdk.base.models.BaseAdUnit r1, java.lang.String r2, com.sigmob.sdk.base.common.h.f r3) {
        /*
            r0 = this;
            if (r2 != 0) goto L17
            boolean r2 = r1.isVideoExist()
            if (r2 == 0) goto L16
            boolean r2 = r1.isEndCardIndexExist()
            if (r2 != 0) goto Lf
            goto L16
        Lf:
            if (r3 == 0) goto L1a
            r2 = 0
        L12:
            r3.d(r1, r2)
            goto L1a
        L16:
            return
        L17:
            if (r3 == 0) goto L1a
            goto L12
        L1a:
            r0.c(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.base.common.h.a(com.sigmob.sdk.base.models.BaseAdUnit, java.lang.String, com.sigmob.sdk.base.common.h$f):void");
    }

    public static File[] a(File[] fileArr, long j10, long j11) {
        if (fileArr == null || fileArr.length == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(Arrays.asList(fileArr));
        for (File file : fileArr) {
            long j12 = j10 - j11;
            if (file.exists() && j12 > file.lastModified()) {
                file.delete();
                arrayList.remove(file);
                SigmobLog.d("file delete " + file.getName());
            }
        }
        return (File[]) arrayList.toArray(new File[0]);
    }

    public Map<String, AdCache> a(int i10) {
        if (i10 == 1 || i10 == 4) {
            return this.f17781h;
        }
        if (i10 == 5) {
            return this.f17785l;
        }
        if (i10 != 6) {
            return null;
        }
        return this.f17786m;
    }

    public final void a(DownloadItem downloadItem, BaseAdUnit baseAdUnit) {
        if (f17767t != null) {
            String str = downloadItem.url;
            if (TextUtils.isEmpty(str) || f17767t.e(str)) {
                return;
            }
            String d10 = f17767t.d(str);
            f17767t.a(new b(downloadItem, System.currentTimeMillis()), str);
            com.sigmob.sdk.videocache.x.a(com.sigmob.sdk.a.d()).b(d10);
        }
    }

    public void a(String str, int i10) {
        Map<String, AdCache> a10;
        if (TextUtils.isEmpty(str) || (a10 = a(i10)) == null) {
            return;
        }
        a10.remove(str);
    }
}
