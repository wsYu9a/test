package com.wbl.ad.yzz.bean;

import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.martian.mibook.application.MiConfigSingleton;
import com.tencent.open.SocialConstants;
import com.wbl.ad.yzz.network.b.b.x;
import java.io.Serializable;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b \u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b8\u00109R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001b\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010!\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\u000b\u001a\u0004\b\"\u0010\r\"\u0004\b#\u0010\u000fR\"\u0010$\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010\u001c\u001a\u0004\b%\u0010\u001e\"\u0004\b&\u0010 R\"\u0010'\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010\u001c\u001a\u0004\b'\u0010\u001e\"\u0004\b(\u0010 R$\u0010)\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010\u000b\u001a\u0004\b*\u0010\r\"\u0004\b+\u0010\u000fR$\u0010,\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010\u000b\u001a\u0004\b-\u0010\r\"\u0004\b.\u0010\u000fR$\u0010/\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u0010\u000b\u001a\u0004\b0\u0010\r\"\u0004\b1\u0010\u000fR\"\u00102\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107¨\u0006:"}, d2 = {"Lcom/wbl/ad/yzz/bean/ImageVideoBean;", "Ljava/io/Serializable;", "Lcom/wbl/ad/yzz/network/b/b/x;", MiConfigSingleton.u0, "Lcom/wbl/ad/yzz/network/b/b/x;", "getImage", "()Lcom/wbl/ad/yzz/network/b/b/x;", "setImage", "(Lcom/wbl/ad/yzz/network/b/b/x;)V", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "video", "getVideo", "setVideo", "", "type", "Ljava/lang/Integer;", "getType", "()Ljava/lang/Integer;", "setType", "(Ljava/lang/Integer;)V", "", "playOver", "Z", "getPlayOver", "()Z", "setPlayOver", "(Z)V", "link", "getLink", "setLink", "voice", "getVoice", "setVoice", "isPlaying", "setPlaying", SocialConstants.PARAM_APP_DESC, "getDesc", "setDesc", "scheme", "getScheme", "setScheme", "btn_txt", "getBtn_txt", "setBtn_txt", "curPlay", "I", "getCurPlay", "()I", "setCurPlay", "(I)V", "<init>", "()V", "wblsdk_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class ImageVideoBean implements Serializable {

    @f.b.a.e
    private String btn_txt;
    private int curPlay;

    @f.b.a.e
    private String desc;

    @f.b.a.e
    private x image;
    private boolean isPlaying;

    @f.b.a.e
    private String link;
    private boolean playOver;

    @f.b.a.e
    private String scheme;

    @f.b.a.e
    private String title;

    @f.b.a.e
    private Integer type;

    @f.b.a.e
    private String video;
    private boolean voice;

    public final String getBtn_txt() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15758, this, null);
    }

    public final int getCurPlay() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-15757, this, null);
    }

    public final String getDesc() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15760, this, null);
    }

    public final x getImage() {
        return (x) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15759, this, null);
    }

    public final String getLink() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15754, this, null);
    }

    public final boolean getPlayOver() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-15753, this, null);
    }

    public final String getScheme() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15756, this, null);
    }

    public final String getTitle() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15755, this, null);
    }

    public final Integer getType() {
        return (Integer) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15750, this, null);
    }

    public final String getVideo() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15749, this, null);
    }

    public final boolean getVoice() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-15752, this, null);
    }

    public final boolean isPlaying() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-15751, this, null);
    }

    public final void setBtn_txt(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15746, this, str);
    }

    public final void setCurPlay(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15745, this, Integer.valueOf(i2));
    }

    public final void setDesc(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15748, this, str);
    }

    public final void setImage(x xVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15747, this, xVar);
    }

    public final void setLink(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15774, this, str);
    }

    public final void setPlayOver(boolean z) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15773, this, Boolean.valueOf(z));
    }

    public final void setPlaying(boolean z) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15776, this, Boolean.valueOf(z));
    }

    public final void setScheme(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15775, this, str);
    }

    public final void setTitle(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15770, this, str);
    }

    public final void setType(Integer num) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15769, this, num);
    }

    public final void setVideo(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15772, this, str);
    }

    public final void setVoice(boolean z) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15771, this, Boolean.valueOf(z));
    }
}
