package cn.vlion.ad.inland.base.natives;

import android.graphics.Bitmap;
import android.widget.ImageView;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class VlionNativeAdData {
    private String brandUrl;
    private ComplianceInfo complianceInfo;
    private String description;
    private int imageHeight;
    private int imageWidth;
    private List<String> imgList;
    private int interactionType;
    private boolean isClosedVolume;
    private Bitmap logoBitmap;
    private int playMode;
    private double price;
    private String title;
    private int videoHeight;
    private int videoWidth;
    private int is_circulation = 0;
    private int autoPlay = 3;
    private String videoUrl = "";
    private String videoCover = "";
    private int vlionNativeType = 0;
    private int imageScale = 4;

    public static class ComplianceInfo {
        private String PermissionUrl;
        private String appName;
        private String appVersion;
        private String developerName;
        private String functionDescUrl;
        private String privacyUrl;

        public String getAppName() {
            return this.appName;
        }

        public String getAppVersion() {
            return this.appVersion;
        }

        public String getDeveloperName() {
            return this.developerName;
        }

        public String getFunctionDescUrl() {
            return this.functionDescUrl;
        }

        public String getPermissionUrl() {
            return this.PermissionUrl;
        }

        public String getPrivacyUrl() {
            return this.privacyUrl;
        }

        public void setAppName(String str) {
            this.appName = str;
        }

        public void setAppVersion(String str) {
            this.appVersion = str;
        }

        public void setDeveloperName(String str) {
            this.developerName = str;
        }

        public void setFunctionDescUrl(String str) {
            this.functionDescUrl = str;
        }

        public void setPermissionUrl(String str) {
            this.PermissionUrl = str;
        }

        public void setPrivacyUrl(String str) {
            this.privacyUrl = str;
        }
    }

    public class VlionInteractionType {
        public static final int INTERACTION_TYPE_DOWNLOAD = 2;
        public static final int INTERACTION_TYPE_LANDING_PAGE = 1;

        public VlionInteractionType() {
        }
    }

    public int getAutoPlay() {
        return this.autoPlay;
    }

    public String getBrandUrl() {
        return this.brandUrl;
    }

    public ComplianceInfo getComplianceInfo() {
        return this.complianceInfo;
    }

    public String getDescription() {
        return this.description;
    }

    public int getImageHeight() {
        return this.imageHeight;
    }

    public ImageView.ScaleType getImageScale() {
        ImageView.ScaleType scaleType = ImageView.ScaleType.FIT_CENTER;
        try {
            int i10 = this.imageScale;
            if (i10 == 2) {
                scaleType = ImageView.ScaleType.CENTER_CROP;
            } else if (i10 == 3) {
                scaleType = ImageView.ScaleType.FIT_XY;
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
        return scaleType;
    }

    public int getImageWidth() {
        return this.imageWidth;
    }

    public List<String> getImgList() {
        List<String> list = this.imgList;
        return list == null ? new ArrayList() : list;
    }

    public int getInteractionType() {
        return this.interactionType;
    }

    public int getIs_circulation() {
        return this.is_circulation;
    }

    public Bitmap getLogoBitmap() {
        return this.logoBitmap;
    }

    public int getPlayMode() {
        return this.playMode;
    }

    public double getPrice() {
        return this.price;
    }

    public String getTitle() {
        return this.title;
    }

    public String getVideoCover() {
        return this.videoCover;
    }

    public int getVideoHeight() {
        return this.videoHeight;
    }

    public int getVideoScale() {
        return this.imageScale;
    }

    public String getVideoUrl() {
        return this.videoUrl;
    }

    public int getVideoWidth() {
        return this.videoWidth;
    }

    public int getVlionNativeType() {
        return this.vlionNativeType;
    }

    public boolean isClosedVolume() {
        return this.isClosedVolume;
    }

    public void setAutoPlay(int i10) {
        this.autoPlay = i10;
    }

    public void setBrandUrl(String str) {
        this.brandUrl = str;
    }

    public void setClosedVolume(boolean z10) {
        this.isClosedVolume = z10;
    }

    public void setComplianceInfo(ComplianceInfo complianceInfo) {
        this.complianceInfo = complianceInfo;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setImageHeight(int i10) {
        this.imageHeight = i10;
    }

    public void setImageScale(int i10) {
        this.imageScale = i10;
    }

    public void setImageWidth(int i10) {
        this.imageWidth = i10;
    }

    public void setImgList(List<String> list) {
        this.imgList = list;
    }

    public void setInteractionType(int i10) {
        this.interactionType = i10;
    }

    public void setIs_circulation(int i10) {
        this.is_circulation = i10;
    }

    public void setLogoBitmap(Bitmap bitmap) {
        this.logoBitmap = bitmap;
    }

    public void setPlayMode(int i10) {
        this.playMode = i10;
    }

    public void setPrice(double d10) {
        this.price = d10;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setVideoCover(String str) {
        this.videoCover = str;
    }

    public void setVideoHeight(int i10) {
        this.videoHeight = i10;
    }

    public void setVideoUrl(String str) {
        this.videoUrl = str;
    }

    public void setVideoWidth(int i10) {
        this.videoWidth = i10;
    }

    public void setVlionNativeType(int i10) {
        this.vlionNativeType = i10;
    }
}
