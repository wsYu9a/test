package cn.vlion.ad.inland.base;

import cn.vlion.ad.inland.ad.javabean.VlionCustomParseAdData;
import cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig;
import cn.vlion.ad.inland.base.javabean.VlionServiceConfig;
import cn.vlion.ad.inland.base.javabean.VlionServiceConfigParse;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/* loaded from: classes.dex */
public final class t4 {
    public static int a(VlionServiceConfig.DataBean.TemplatesBean templatesBean) {
        if (templatesBean == null) {
            try {
                if (templatesBean.getMain() == null && templatesBean.getMain().getStyle() == null) {
                    return -1;
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
        if (templatesBean.getMain().getStyle().equals("BANNER_P_MAIN_300_150")) {
            return 1;
        }
        if (templatesBean.getMain().getStyle().equals("BANNER_P_MAIN_300_200")) {
            return 2;
        }
        if (templatesBean.getMain().getStyle().equals("BANNER_P_MAIN_300_250")) {
            return 3;
        }
        if (templatesBean.getMain().getStyle().equals("BANNER_P_MAIN_300_45")) {
            return 4;
        }
        if (templatesBean.getMain().getStyle().equals("BANNER_P_MAIN_300_75")) {
            return 5;
        }
        if (templatesBean.getMain().getStyle().equals("BANNER_P_MAIN_320_50")) {
            return 6;
        }
        return templatesBean.getMain().getStyle().equals("BANNER_P_MAIN_345_194") ? 7 : -1;
    }

    public static int b(VlionServiceConfig.DataBean.TemplatesBean templatesBean) {
        if (templatesBean != null) {
            try {
                if (templatesBean.getMain() != null && templatesBean.getMain().getStyle() != null) {
                    if (templatesBean.getMain().getStyle().equals("FEED_P_MAIN_UP_TEXT")) {
                        return 1;
                    }
                    if (templatesBean.getMain().getStyle().equals("FEED_P_MAIN_UP_IMAGE")) {
                        return 2;
                    }
                    if (templatesBean.getMain().getStyle().equals("FEED_P_MAIN_TEXT_FLOAT")) {
                        return 3;
                    }
                    if (templatesBean.getMain().getStyle().equals("FEED_P_MAIN_LEFT_TEXT")) {
                        return 4;
                    }
                    if (templatesBean.getMain().getStyle().equals("FEED_P_MAIN_LEFT_IMAGE")) {
                        return 5;
                    }
                    if (templatesBean.getMain().getStyle().equals("FEED_P_MAIN_THREE_IMAGE")) {
                        return 6;
                    }
                    if (templatesBean.getMain().getStyle().equals("FEED_P_MAIN_VERTICAL")) {
                        return 7;
                    }
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
        return -1;
    }

    public static VlionServiceConfig.DataBean.TemplatesBean a(VlionCustomParseAdData vlionCustomParseAdData, VlionAdapterADConfig vlionAdapterADConfig) {
        List<VlionServiceConfig.DataBean.AdBean.PlacementBean.TemplateConfigBean> templateConfigBean;
        if (vlionAdapterADConfig != null && vlionAdapterADConfig.getTemplateConfigBean() != null && vlionAdapterADConfig.getTemplateConfigBean().size() != 0 && vlionCustomParseAdData != null) {
            try {
                if (vlionCustomParseAdData.getBidBean() != null && (templateConfigBean = vlionAdapterADConfig.getTemplateConfigBean()) != null && templateConfigBean.size() > 0 && templateConfigBean.get(0) != null) {
                    return VlionServiceConfigParse.getInstance().getTemplatesBean(templateConfigBean.get(0).getId());
                }
            } catch (Throwable th2) {
                LogVlion.e("getBannerModelUi Exception=" + th2);
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
        return null;
    }

    public static int b(VlionCustomParseAdData vlionCustomParseAdData, VlionAdapterADConfig vlionAdapterADConfig) {
        List<VlionServiceConfig.DataBean.AdBean.PlacementBean.TemplateConfigBean> templateConfigBean;
        if (vlionAdapterADConfig != null && vlionAdapterADConfig.getTemplateConfigBean() != null && vlionAdapterADConfig.getTemplateConfigBean().size() != 0 && vlionCustomParseAdData != null) {
            try {
                if (vlionCustomParseAdData.getBidBean() != null && (templateConfigBean = vlionAdapterADConfig.getTemplateConfigBean()) != null && templateConfigBean.size() > 0 && templateConfigBean.get(0) != null) {
                    return VlionServiceConfigParse.getInstance().getTemplatesBean(templateConfigBean.get(0).getId()).getMain().getIs_circulation();
                }
            } catch (Throwable th2) {
                p.a(th2, "getNativeModel_Is_circulation Exception=", th2);
            }
        }
        return 0;
    }

    public static VlionServiceConfig.DataBean.TemplatesBean a(VlionAdapterADConfig vlionAdapterADConfig, VlionCustomParseAdData vlionCustomParseAdData, boolean z10) {
        VlionServiceConfig.DataBean.TemplatesBean templatesBean;
        if (vlionAdapterADConfig != null) {
            try {
                if (vlionAdapterADConfig.getTemplateConfigBean() != null && vlionAdapterADConfig.getTemplateConfigBean().size() != 0 && vlionCustomParseAdData != null && vlionCustomParseAdData.getBidBean() != null) {
                    List<VlionServiceConfig.DataBean.AdBean.PlacementBean.TemplateConfigBean> templateConfigBean = vlionAdapterADConfig.getTemplateConfigBean();
                    if (vlionCustomParseAdData.getBidBean().getImage() != null && vlionCustomParseAdData.getBidBean().getImage().size() > 1) {
                        VlionServiceConfig.DataBean.TemplatesBean templatesBean2 = VlionServiceConfigParse.getInstance().getTemplatesBean("FEED_P_MAIN_THREE_IMAGE");
                        if (templatesBean2 == null) {
                            return null;
                        }
                        for (int i10 = 0; i10 < templateConfigBean.size(); i10++) {
                            if (templateConfigBean.get(i10).getId() == templatesBean2.getId()) {
                                return templatesBean2;
                            }
                        }
                    }
                    if (z10 && (templatesBean = VlionServiceConfigParse.getInstance().getTemplatesBean("FEED_P_MAIN_VERTICAL")) != null) {
                        for (int i11 = 0; i11 < templateConfigBean.size(); i11++) {
                            if (templateConfigBean.get(i11).getId() == templatesBean.getId()) {
                                return templatesBean;
                            }
                        }
                    }
                    if (templateConfigBean.size() == 1 && templateConfigBean.get(0) != null) {
                        return VlionServiceConfigParse.getInstance().getTemplatesBean(templateConfigBean.get(0).getId());
                    }
                    ArrayList arrayList = new ArrayList();
                    int i12 = 0;
                    for (int i13 = 0; i13 < templateConfigBean.size(); i13++) {
                        VlionServiceConfig.DataBean.AdBean.PlacementBean.TemplateConfigBean templateConfigBean2 = templateConfigBean.get(i13);
                        VlionServiceConfig.DataBean.TemplatesBean templatesBean3 = VlionServiceConfigParse.getInstance().getTemplatesBean(templateConfigBean2.getId());
                        if (templatesBean3 != null && templatesBean3.getMain() != null && templatesBean3.getMain().getStyle() != null && !templatesBean3.getMain().getStyle().equals("FEED_P_MAIN_THREE_IMAGE") && !templatesBean3.getMain().getStyle().equals("FEED_P_MAIN_VERTICAL")) {
                            arrayList.add(templateConfigBean2);
                            i12 += templateConfigBean2.getWeight();
                        }
                    }
                    if (i12 == 0) {
                        return VlionServiceConfigParse.getInstance().getTemplatesBean("FEED_P_MAIN_UP_TEXT");
                    }
                    int nextInt = new Random().nextInt(i12);
                    LogVlion.e("VlionCustomUiModelUtils initModelUi =" + nextInt);
                    int i14 = 0;
                    for (int i15 = 0; i15 < arrayList.size(); i15++) {
                        VlionServiceConfig.DataBean.AdBean.PlacementBean.TemplateConfigBean templateConfigBean3 = (VlionServiceConfig.DataBean.AdBean.PlacementBean.TemplateConfigBean) arrayList.get(i15);
                        if (templateConfigBean3 != null) {
                            i14 += templateConfigBean3.getWeight();
                            LogVlion.e("VlionCustomUiModelUtils temNumber =" + i14);
                            if (i14 >= nextInt) {
                                return VlionServiceConfigParse.getInstance().getTemplatesBean(templateConfigBean3.getId());
                            }
                        }
                    }
                    return VlionServiceConfigParse.getInstance().getTemplatesBean("FEED_P_MAIN_UP_TEXT");
                }
                return null;
            } catch (Throwable th2) {
                LogVlion.e("getFeedModelUi Exception=" + th2);
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
        return null;
    }

    public static VlionServiceConfig.DataBean.TemplatesBean a(VlionAdapterADConfig vlionAdapterADConfig) {
        int id2;
        if (vlionAdapterADConfig == null || vlionAdapterADConfig.getTemplateConfigBean() == null || vlionAdapterADConfig.getTemplateConfigBean().size() == 0) {
            return null;
        }
        try {
            List<VlionServiceConfig.DataBean.AdBean.PlacementBean.TemplateConfigBean> templateConfigBean = vlionAdapterADConfig.getTemplateConfigBean();
            if (templateConfigBean.size() != 1 || templateConfigBean.get(0) == null) {
                int nextInt = new Random().nextInt(100);
                LogVlion.e("VlionCustomUiModelUtils initModelUi =" + nextInt);
                int i10 = 0;
                for (int i11 = 0; i11 < templateConfigBean.size(); i11++) {
                    VlionServiceConfig.DataBean.AdBean.PlacementBean.TemplateConfigBean templateConfigBean2 = templateConfigBean.get(i11);
                    if (templateConfigBean2 != null) {
                        i10 += templateConfigBean2.getWeight();
                        LogVlion.e("VlionCustomUiModelUtils temNumber =" + i10);
                        if (i10 >= nextInt) {
                            id2 = templateConfigBean2.getId();
                        }
                    }
                }
                return null;
            }
            id2 = templateConfigBean.get(0).getId();
            return VlionServiceConfigParse.getInstance().getTemplatesBean(id2);
        } catch (Throwable th2) {
            s4.a("getModelUi Exception=", th2);
            return null;
        }
    }
}
