package b.a.a.a.c.d.a;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.ComplianceInfo;
import com.bytedance.sdk.openadsdk.DislikeInfo;
import com.bytedance.sdk.openadsdk.DownloadStatusController;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.TTImage;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.vivo.mobilead.util.k0;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class h extends b.a.a.a.c.d.a.a<TTNativeAd> implements TTNativeAd {

    static class a extends b<TTNativeAd.AdInteractionListener> implements TTNativeAd.AdInteractionListener {
        /* JADX WARN: Multi-variable type inference failed */
        public a(TTNativeAd.AdInteractionListener adInteractionListener, String str, int i2) {
            super(str, i2);
            this.f4174c = adInteractionListener;
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
        public void onAdClicked(View view, TTNativeAd tTNativeAd) {
            k0.a(this.f4172a, this.f4173b);
            T t = this.f4174c;
            if (t != 0) {
                ((TTNativeAd.AdInteractionListener) t).onAdClicked(view, tTNativeAd);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
        public void onAdCreativeClick(View view, TTNativeAd tTNativeAd) {
            k0.a(this.f4172a, this.f4173b);
            T t = this.f4174c;
            if (t != 0) {
                ((TTNativeAd.AdInteractionListener) t).onAdCreativeClick(view, tTNativeAd);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
        public void onAdShow(TTNativeAd tTNativeAd) {
            k0.b(this.f4172a, this.f4173b);
            T t = this.f4174c;
            if (t != 0) {
                ((TTNativeAd.AdInteractionListener) t).onAdShow(tTNativeAd);
            }
        }
    }

    public h(TTNativeAd tTNativeAd, String str, int i2) {
        super(tTNativeAd, str, i2);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void destroy() {
        ((TTNativeAd) this.f4169a).destroy();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public Bitmap getAdLogo() {
        return ((TTNativeAd) this.f4169a).getAdLogo();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public View getAdView() {
        return ((TTNativeAd) this.f4169a).getAdView();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public int getAppCommentNum() {
        return ((TTNativeAd) this.f4169a).getAppCommentNum();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public int getAppScore() {
        return ((TTNativeAd) this.f4169a).getAppScore();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public int getAppSize() {
        return ((TTNativeAd) this.f4169a).getAppSize();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public String getButtonText() {
        return ((TTNativeAd) this.f4169a).getButtonText();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public ComplianceInfo getComplianceInfo() {
        return ((TTNativeAd) this.f4169a).getComplianceInfo();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public String getDescription() {
        return ((TTNativeAd) this.f4169a).getDescription();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public TTAdDislike getDislikeDialog(Activity activity) {
        return ((TTNativeAd) this.f4169a).getDislikeDialog(activity);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public DislikeInfo getDislikeInfo() {
        return ((TTNativeAd) this.f4169a).getDislikeInfo();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public DownloadStatusController getDownloadStatusController() {
        return ((TTNativeAd) this.f4169a).getDownloadStatusController();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public TTImage getIcon() {
        return ((TTNativeAd) this.f4169a).getIcon();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public List<TTImage> getImageList() {
        return ((TTNativeAd) this.f4169a).getImageList();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public int getImageMode() {
        return ((TTNativeAd) this.f4169a).getImageMode();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public int getInteractionType() {
        return ((TTNativeAd) this.f4169a).getInteractionType();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public Map<String, Object> getMediaExtraInfo() {
        return ((TTNativeAd) this.f4169a).getMediaExtraInfo();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public String getSource() {
        return ((TTNativeAd) this.f4169a).getSource();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public String getTitle() {
        return ((TTNativeAd) this.f4169a).getTitle();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    @Nullable
    public TTImage getVideoCoverImage() {
        return ((TTNativeAd) this.f4169a).getVideoCoverImage();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void registerViewForInteraction(@NonNull ViewGroup viewGroup, @NonNull View view, TTNativeAd.AdInteractionListener adInteractionListener) {
        ((TTNativeAd) this.f4169a).registerViewForInteraction(viewGroup, view, new a(adInteractionListener, this.f4170b, this.f4171c));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void render() {
        ((TTNativeAd) this.f4169a).render();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void setActivityForDownloadApp(@NonNull Activity activity) {
        ((TTNativeAd) this.f4169a).setActivityForDownloadApp(activity);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void setDislikeCallback(Activity activity, TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        ((TTNativeAd) this.f4169a).setDislikeCallback(activity, dislikeInteractionCallback);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void setDislikeDialog(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        ((TTNativeAd) this.f4169a).setDislikeDialog(tTDislikeDialogAbstract);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        ((TTNativeAd) this.f4169a).setDownloadListener(tTAppDownloadListener);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void setExpressRenderListener(TTNativeAd.ExpressRenderListener expressRenderListener) {
        ((TTNativeAd) this.f4169a).setExpressRenderListener(expressRenderListener);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void showInteractionExpressAd(Activity activity) {
        ((TTNativeAd) this.f4169a).showInteractionExpressAd(activity);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public TTAdDislike getDislikeDialog(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        return ((TTNativeAd) this.f4169a).getDislikeDialog(tTDislikeDialogAbstract);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void registerViewForInteraction(@NonNull ViewGroup viewGroup, @NonNull List<View> list, @Nullable List<View> list2, TTNativeAd.AdInteractionListener adInteractionListener) {
        ((TTNativeAd) this.f4169a).registerViewForInteraction(viewGroup, list, list2, new a(adInteractionListener, this.f4170b, this.f4171c));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void registerViewForInteraction(@NonNull ViewGroup viewGroup, @NonNull List<View> list, @Nullable List<View> list2, @Nullable View view, TTNativeAd.AdInteractionListener adInteractionListener) {
        ((TTNativeAd) this.f4169a).registerViewForInteraction(viewGroup, list, list2, view, new a(adInteractionListener, this.f4170b, this.f4171c));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void registerViewForInteraction(@NonNull ViewGroup viewGroup, @NonNull List<View> list, @NonNull List<View> list2, @Nullable List<View> list3, @Nullable View view, TTNativeAd.AdInteractionListener adInteractionListener) {
        ((TTNativeAd) this.f4169a).registerViewForInteraction(viewGroup, list, list2, list3, view, new a(adInteractionListener, this.f4170b, this.f4171c));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, List<View> list4, View view, TTNativeAd.AdInteractionListener adInteractionListener) {
        ((TTNativeAd) this.f4169a).registerViewForInteraction(viewGroup, list, list2, list3, list4, view, new a(adInteractionListener, this.f4170b, this.f4171c));
    }
}
