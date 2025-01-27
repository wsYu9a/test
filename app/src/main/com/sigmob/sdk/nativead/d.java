package com.sigmob.sdk.nativead;

import android.os.Bundle;
import com.czhj.volley.toolbox.DownloadItem;
import com.czhj.volley.toolbox.FileDownloadRequest;
import com.czhj.volley.toolbox.FileDownloader;
import com.sigmob.sdk.base.common.AdActivity;
import com.sigmob.sdk.base.common.o;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.rtb.MaterialMeta;
import com.sigmob.sdk.videoAd.BaseAdActivity;
import java.io.File;
import java.util.Map;

/* loaded from: classes4.dex */
public class d extends com.sigmob.sdk.base.common.x {

    /* renamed from: d */
    public NativeAdBroadcastReceiver f19940d;

    public class a implements FileDownloadRequest.FileDownloadListener {
        public a() {
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

    public interface b extends o.b, o.c {
        void g();

        void onAdDetailDismiss();

        void onAdDetailShow();
    }

    public d(o.b bVar) {
        super(bVar);
    }

    public static boolean a(MaterialMeta materialMeta) {
        return true;
    }

    @Override // com.sigmob.sdk.base.common.x
    public void b(BaseAdUnit baseAdUnit) {
        NativeAdBroadcastReceiver nativeAdBroadcastReceiver = this.f19940d;
        if (nativeAdBroadcastReceiver != null) {
            nativeAdBroadcastReceiver.b(nativeAdBroadcastReceiver);
            this.f19940d = null;
        }
        super.b(baseAdUnit);
    }

    @Override // com.sigmob.sdk.base.common.x
    public boolean a(BaseAdUnit baseAdUnit) {
        if (baseAdUnit.getMaterial() != null) {
            return a(baseAdUnit.getMaterial());
        }
        return false;
    }

    @Override // com.sigmob.sdk.base.common.x
    public void a(Map<String, Object> map, BaseAdUnit baseAdUnit) {
        super.a(map, baseAdUnit);
    }

    @Override // com.sigmob.sdk.base.common.x
    public void a(o.b bVar) {
        File adPrivacyTemplateFile = this.f18042b.getAdPrivacyTemplateFile();
        if (adPrivacyTemplateFile == null || adPrivacyTemplateFile.exists()) {
            return;
        }
        DownloadItem downloadItem = new DownloadItem();
        downloadItem.url = this.f18042b.getadPrivacy().privacy_template_url;
        downloadItem.filePath = adPrivacyTemplateFile.getAbsolutePath();
        downloadItem.type = DownloadItem.FileType.OTHER;
        FileDownloader a10 = com.sigmob.sdk.base.common.r.a();
        if (a10 != null) {
            a10.add(downloadItem, new a());
        }
    }

    @Override // com.sigmob.sdk.base.common.x
    public void a(BaseAdUnit baseAdUnit, Bundle bundle) {
        super.a(baseAdUnit, bundle);
        if (this.f19940d == null && (this.f18041a instanceof b)) {
            NativeAdBroadcastReceiver nativeAdBroadcastReceiver = new NativeAdBroadcastReceiver((b) this.f18041a, baseAdUnit.getUuid());
            this.f19940d = nativeAdBroadcastReceiver;
            nativeAdBroadcastReceiver.a(nativeAdBroadcastReceiver);
        }
        BaseAdActivity.a(com.sigmob.sdk.a.d(), AdActivity.class, baseAdUnit.getUuid(), bundle, BaseAdActivity.f20398e);
    }
}
