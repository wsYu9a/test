package com.czhj.volley.toolbox;

import com.czhj.volley.DefaultRetryPolicy;
import com.czhj.volley.Request;
import com.czhj.volley.VolleyError;
import com.czhj.volley.VolleyLog;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import m5.c;

/* loaded from: classes2.dex */
public class FileDownloadRequest extends Request<DownloadItem> {

    /* renamed from: a */
    public File f8761a;

    /* renamed from: b */
    public File f8762b;

    /* renamed from: c */
    public DownloadItem f8763c;

    /* renamed from: d */
    public long f8764d;

    /* renamed from: e */
    public final Object f8765e;

    /* renamed from: f */
    public FileDownloadListener f8766f;

    public interface FileDownloadListener {
        void downloadProgress(DownloadItem downloadItem, long j10, long j11);

        void onCancel(DownloadItem downloadItem);

        void onErrorResponse(DownloadItem downloadItem);

        void onSuccess(DownloadItem downloadItem);
    }

    public FileDownloadRequest(DownloadItem downloadItem, FileDownloadListener fileDownloadListener) {
        super(0, downloadItem.url, null);
        this.f8764d = 0L;
        this.f8765e = new Object();
        this.f8766f = null;
        File file = new File(downloadItem.filePath);
        this.f8761a = file;
        if (file.getParentFile() != null && !this.f8761a.getParentFile().exists()) {
            this.f8761a.getParentFile().mkdirs();
        }
        if (this.f8761a.exists()) {
            this.f8761a.delete();
        }
        this.f8763c = downloadItem;
        File file2 = new File(downloadItem.filePath + ".tmp");
        this.f8762b = file2;
        if (!downloadItem.userRange) {
            file2.delete();
        }
        this.f8766f = fileDownloadListener;
        setRetryPolicy(new DefaultRetryPolicy(10000, 2, 0.0f));
        setShouldCache(false);
        VolleyLog.d("FileDownloadRequest()  [ %s ], url = [%s]", downloadItem.filePath, downloadItem.url);
    }

    @Override // com.czhj.volley.Request
    public void cancel() {
        super.cancel();
        synchronized (this.f8765e) {
            this.f8766f = null;
        }
    }

    @Override // com.czhj.volley.Request
    public void deliverError(VolleyError volleyError) {
        this.f8763c.status = 0;
        if (this.f8761a.exists()) {
            this.f8761a.delete();
        }
        if (this.f8762b.exists()) {
            this.f8762b.delete();
        }
        DownloadItem downloadItem = this.f8763c;
        downloadItem.error = volleyError;
        this.f8766f.onErrorResponse(downloadItem);
    }

    @Override // com.czhj.volley.Request
    public void deliverResponse(DownloadItem downloadItem) {
        this.f8763c.status = 1;
        this.f8766f.onSuccess(downloadItem);
    }

    @Override // com.czhj.volley.Request
    public Map<String, String> getHeaders() {
        HashMap hashMap = new HashMap();
        this.f8764d = this.f8762b.length();
        hashMap.put(c.f28331o, c.f28350u0);
        hashMap.put(c.f28316j, "gzip");
        hashMap.put("Range", "bytes=" + this.f8764d + "-");
        addMarker("Range,bytes=" + this.f8764d + "-");
        return hashMap;
    }

    @Override // com.czhj.volley.Request
    public Request.Priority getPriority() {
        return Request.Priority.LOW;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:(18:83|(1:101)(1:(1:(2:95|(2:97|(2:99|100))))(2:92|93))|7|8|9|11|(1:13)(1:79)|14|15|16|17|(3:18|19|(1:74)(2:21|(1:59)(3:23|(6:28|29|30|31|32|34)(2:25|26)|27)))|61|62|64|65|66|67)(1:5)|16|17|(4:18|19|(0)(0)|27)|61|62|64|65|66|67) */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0120, code lost:
    
        com.czhj.volley.VolleyLog.v(r1.f8763c.url + " download  is cancel", new java.lang.Object[r9]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x01dd, code lost:
    
        com.czhj.volley.VolleyLog.v("Error occured when calling consumingContent", new java.lang.Object[0]);
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00fa A[Catch: all -> 0x00ff, TRY_ENTER, TryCatch #9 {all -> 0x00ff, blocks: (B:13:0x00fa, B:14:0x0106, B:79:0x0103), top: B:11:0x00f8 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x011a A[Catch: all -> 0x01b5, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x01b5, blocks: (B:17:0x010c, B:18:0x010e, B:21:0x011a, B:23:0x0143), top: B:16:0x010c }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x013a A[EDGE_INSN: B:74:0x013a->B:61:0x013a BREAK  A[LOOP:0: B:18:0x010e->B:27:0x018b], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0103 A[Catch: all -> 0x00ff, TryCatch #9 {all -> 0x00ff, blocks: (B:13:0x00fa, B:14:0x0106, B:79:0x0103), top: B:11:0x00f8 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public byte[] handleRawResponse(com.czhj.volley.toolbox.HttpResponse r19) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 511
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.czhj.volley.toolbox.FileDownloadRequest.handleRawResponse(com.czhj.volley.toolbox.HttpResponse):byte[]");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0121 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:78:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0111 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v24, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v31, types: [java.io.InputStream, java.util.zip.GZIPInputStream] */
    @Override // com.czhj.volley.Request
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.czhj.volley.Response<com.czhj.volley.toolbox.DownloadItem> parseNetworkResponse(com.czhj.volley.NetworkResponse r9) {
        /*
            Method dump skipped, instructions count: 403
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.czhj.volley.toolbox.FileDownloadRequest.parseNetworkResponse(com.czhj.volley.NetworkResponse):com.czhj.volley.Response");
    }

    public void setListener(FileDownloadListener fileDownloadListener) {
        this.f8766f = fileDownloadListener;
    }
}
