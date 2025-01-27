package com.kwad.library.solder.lib.c;

import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes3.dex */
public final class b implements Comparable<b> {
    public boolean Lc;
    public String amQ;
    public boolean amR;
    public String ann;
    public String ano;
    public long anp;
    public String anq;
    public boolean anr = false;
    public boolean ans = true;
    public HashMap<String, String> ant = new HashMap<>(10);
    public List<String> anu;
    public List<String> anv;
    public ClassLoader anw;
    public String version;

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public int compareTo(@NonNull b bVar) {
        return -this.version.compareTo(bVar.version);
    }

    public final String toString() {
        return "RemotePluginInfo{pluginId='" + this.ann + "', version='" + this.version + "', downloadUrl='" + this.ano + "', fileSize=" + this.anp + ", enable=" + this.Lc + ", md5sum='" + this.anq + "', onlyWifiDownload=" + this.anr + ", onlyWifiRetryDownload=" + this.ans + ", soMd5s=" + this.ant + ", hostPackages=" + this.anu + ", hostInterfaces=" + this.anv + '}';
    }
}
