package com.kwad.sdk.contentalliance.a.a;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;

/* loaded from: classes3.dex */
public final class b {
    public AdTemplate adTemplate;
    public com.kwad.sdk.contentalliance.a.a.a asp;
    public boolean isNoCache;
    public String manifest;
    public VideoPlayerStatus videoPlayerStatus;
    public String videoUrl;

    public static class a {
        private AdTemplate adTemplate;
        private com.kwad.sdk.contentalliance.a.a.a asp;
        private boolean isNoCache = false;
        private String manifest;
        private VideoPlayerStatus videoPlayerStatus;
        private String videoUrl;

        public a(AdTemplate adTemplate) {
            this.adTemplate = adTemplate;
        }

        public final b Cz() {
            return new b(this, (byte) 0);
        }

        public final a bm(boolean z10) {
            this.isNoCache = z10;
            return this;
        }

        public final a dc(String str) {
            this.videoUrl = str;
            return this;
        }

        public final a dd(String str) {
            this.manifest = str;
            return this;
        }

        public final a a(VideoPlayerStatus videoPlayerStatus) {
            this.videoPlayerStatus = videoPlayerStatus;
            return this;
        }

        public final a b(@NonNull com.kwad.sdk.contentalliance.a.a.a aVar) {
            this.asp = aVar;
            return this;
        }

        public a(String str) {
            this.videoUrl = str;
        }
    }

    public /* synthetic */ b(a aVar, byte b10) {
        this(aVar);
    }

    private b(a aVar) {
        this.asp = new com.kwad.sdk.contentalliance.a.a.a();
        this.isNoCache = false;
        this.adTemplate = aVar.adTemplate;
        this.videoUrl = aVar.videoUrl;
        this.manifest = aVar.manifest;
        this.videoPlayerStatus = aVar.videoPlayerStatus;
        if (aVar.asp != null) {
            this.asp.photoId = aVar.asp.photoId;
            this.asp.clickTime = aVar.asp.clickTime;
            this.asp.adStyle = aVar.asp.adStyle;
            this.asp.contentType = aVar.asp.contentType;
        }
        this.isNoCache = aVar.isNoCache;
    }
}
