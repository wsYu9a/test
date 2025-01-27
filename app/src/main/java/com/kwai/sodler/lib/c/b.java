package com.kwai.sodler.lib.c;

import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes2.dex */
public final class b implements Comparable<b> {
    public boolean Ig;
    public String aKB;
    public boolean aKC;
    public String aKT;
    public String aKU;
    public long aKV;
    public String aKW;
    public boolean aKX = false;
    public boolean aKY = true;
    public HashMap<String, String> aKZ = new HashMap<>(10);
    public List<String> aLa;
    public List<String> aLb;
    public ClassLoader aLc;
    public String version;

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public int compareTo(@NonNull b bVar) {
        return -this.version.compareTo(bVar.version);
    }

    public final String toString() {
        return "RemotePluginInfo{pluginId='" + this.aKT + "', version='" + this.version + "', downloadUrl='" + this.aKU + "', fileSize=" + this.aKV + ", enable=" + this.Ig + ", md5sum='" + this.aKW + "', onlyWifiDownload=" + this.aKX + ", onlyWifiRetryDownload=" + this.aKY + ", soMd5s=" + this.aKZ + ", hostPackages=" + this.aLa + ", hostInterfaces=" + this.aLb + '}';
    }
}
