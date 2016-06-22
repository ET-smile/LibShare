package com.main.lib.lf.share.tempShareCom;

import android.app.Activity;
import android.widget.Toast;

import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.bean.SocializeEntity;
import com.umeng.socialize.controller.UMServiceFactory;
import com.umeng.socialize.controller.UMSocialService;
import com.umeng.socialize.controller.listener.SocializeListeners;
import com.umeng.socialize.media.QQShareContent;
import com.umeng.socialize.media.QZoneShareContent;
import com.umeng.socialize.media.SinaShareContent;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.sso.QZoneSsoHandler;
import com.umeng.socialize.sso.SinaSsoHandler;
import com.umeng.socialize.sso.UMQQSsoHandler;
import com.umeng.socialize.weixin.controller.UMWXHandler;
import com.umeng.socialize.weixin.media.CircleShareContent;
import com.umeng.socialize.weixin.media.WeiXinShareContent;

/**
 * Created by longf on 2016/5/18.
 */
public class TempShareVSDefaultHelper {
    // 首先在您的Activity中添加如下成员变量
    final UMSocialService mController;
    //    private Context mContext;
    private Activity activity;
    private String mShareUrl, mTitle, mShareContent;
    private UMImage mImage;

    public TempShareVSDefaultHelper(Activity act) {
        mController = UMServiceFactory.getUMSocialService("com.umeng.share");
        activity = act;

        SocializeListeners.SnsPostListener mSnsPostListener = new SocializeListeners.SnsPostListener() {

            @Override
            public void onStart() {

            }

            @Override
            public void onComplete(SHARE_MEDIA platform, int stCode,
                                   SocializeEntity entity) {
                if (stCode == 200) {
                    Toast.makeText(activity, "分享成功", Toast.LENGTH_SHORT)
                            .show();
                } else {
                    Toast.makeText(activity,
                            "分享失败 : error code : " + stCode, Toast.LENGTH_SHORT)
                            .show();
                }
            }
        };
        mController.registerListener(mSnsPostListener);
//        addQQPlatForm();
//        addQQQZonePlatform();
//        addSinaPlatForm();
//        addWXPlatform();
    }

    public void initShareHelper(String shareUrl, String title, String shareContent, UMImage image) {
        mImage = image;
        mShareUrl = shareUrl;
        mTitle = title;
        mShareContent = shareContent;
        addQQQZonePlatform();
        addSinaPlatForm();
        addWXPlatform();
//        mImage = image;
//        mShareUrl = shareUrl;
//        mTitle = title;
//        mShareContent = shareContent;
//        initQQShareContent();
//        initCircleShareContent();
//        initQQZoneShareContent();
//        initSinaShareContent();
//        initWXShareContent();
        showShare();
    }

    private void addSinaPlatForm() {
        // 添加新浪SSO授权
        SinaSsoHandler handler = new SinaSsoHandler();
        handler.setTargetUrl("http://lingkj.com/");
        mController.getConfig().setSsoHandler(new SinaSsoHandler());
    }

    private SinaShareContent initSinaShareContent() {
        SinaShareContent sinaShare = new SinaShareContent();
        sinaShare.setTitle(mTitle);
        sinaShare.setShareContent(mShareContent);
        sinaShare.setTargetUrl(mShareUrl);
        if (mImage != null) {
            sinaShare.setShareImage(mImage);
        }
        return sinaShare;
    }

    private void addQQPlatForm() {
        // 添加QQ支持, 并且设置QQ分享内容的target url
        UMQQSsoHandler qqSsoHandler = new UMQQSsoHandler(activity,
                TempShareConfig.APPID_QQ, TempShareConfig.APPKEY_QQ);
        qqSsoHandler.addToSocialSDK();
    }

    private QQShareContent initQQShareContent() {
        QQShareContent qqShare = new QQShareContent();
//        SinaShareContent sinaShare = new SinaShareContent();
        qqShare.setTitle(mTitle);
        qqShare.setShareContent(mShareContent);
        qqShare.setTargetUrl(mShareUrl);
        if (mImage != null) {
            qqShare.setShareImage(mImage);
        }
        return qqShare;
    }

    private QZoneShareContent initQQZoneShareContent() {
        QZoneShareContent qqZoneShare = new QZoneShareContent();
//        SinaShareContent sinaShare = new SinaShareContent();
        qqZoneShare.setTitle(mTitle);
        qqZoneShare.setShareContent(mShareContent);
        qqZoneShare.setTargetUrl(mShareUrl);
        if (mImage != null) {
            qqZoneShare.setShareImage(mImage);
        }
        return qqZoneShare;
    }

    //    private void addQQQZonePlatform(String appId,String appKey,String shareUrl){
////        String appId = "100424468";
////        String appKey = "c7394704798a158208a74ab60104f0ba";
//
//        // QQ空间
//        mController.getConfig().setSsoHandler(new SinaSsoHandler());
//        QZoneSsoHandler qZoneSsoHandler = new QZoneSsoHandler(activity,
//                appId, appKey);
//        qZoneSsoHandler.addToSocialSDK();
//
//    }
    private void addQQQZonePlatform() {
//        String appId = "100424468";
//        String appKey = "c7394704798a158208a74ab60104f0ba";
        // 添加QQ支持, 并且设置QQ分享内容的target url
//        UMQQSsoHandler qqSsoHandler = new UMQQSsoHandler(activity,
//                ConstantConfig.APPID_QQ, ConstantConfig.APPKEY_QQ);
//        qqSsoHandler.setTargetUrl("http://lingkj.com/");
//        qqSsoHandler.addToSocialSDK();
//
//        // 添加QZone平台
//        QZoneSsoHandler qZoneSsoHandler = new QZoneSsoHandler(activity, ConstantConfig.APPID_QQ, ConstantConfig.APPKEY_QQ);
//        qZoneSsoHandler.setTargetUrl("http://lingkj.com/");
//        qZoneSsoHandler.addToSocialSDK();
        UMQQSsoHandler qqSsoHandler = new UMQQSsoHandler(activity,
                TempShareConfig.APPID_QQ, TempShareConfig.APPKEY_QQ);
        qqSsoHandler.setTargetUrl(mShareUrl);
        qqSsoHandler.setTitle(mTitle);
        qqSsoHandler.addToSocialSDK();

        // 添加QZone平台
        QZoneSsoHandler qZoneSsoHandler = new QZoneSsoHandler(activity, TempShareConfig.APPID_QQ, TempShareConfig.APPKEY_QQ);
        qZoneSsoHandler.setTargetUrl(mShareUrl);
        qZoneSsoHandler.addToSocialSDK();
    }

    /**
     * @return
     * @功能描述 : 添加微信平台分享
     */
    private void addWXPlatform() {
        // 注意：在微信授权的时候，必须传递appSecret
        // wx967daebe835fbeac是你在微信开发平台注册应用的AppID, 这里需要替换成你注册的AppID
//        String appId = "wx967daebe835fbeac";
//        String appSecret = "5bb696d9ccd75a38c8a0bfe0675559b3";
        // 添加微信平台
//        UMWXHandler wxHandler = new UMWXHandler(activity, ConstantConfig.APPID_weixin, ConstantConfig.SECRET_weixin);
//        wxHandler.setTargetUrl("http://lingkj.com/");
//        wxHandler.addToSocialSDK();
//        // 支持微信朋友圈
//        UMWXHandler wxCircleHandler = new UMWXHandler(activity, ConstantConfig.APPID_weixin, ConstantConfig.SECRET_weixin);
//        wxCircleHandler.setToCircle(true);
//        wxCircleHandler.setTitle(mTitle);
//        wxCircleHandler.setTargetUrl("http://lingkj.com/");
//        wxCircleHandler.addToSocialSDK();
        // 添加微信平台
        UMWXHandler wxHandler = new UMWXHandler(activity, TempShareConfig.APPID_weixin, TempShareConfig.SECRET_weixin);
        wxHandler.setTargetUrl(mShareUrl);
        wxHandler.setTitle(mTitle);
        wxHandler.addToSocialSDK();
        // 支持微信朋友圈
        UMWXHandler wxCircleHandler = new UMWXHandler(activity, TempShareConfig.APPID_weixin, TempShareConfig.SECRET_weixin);
        wxCircleHandler.setToCircle(true);
        wxCircleHandler.setTitle(mTitle);
        wxCircleHandler.setTargetUrl(mShareUrl);
        wxCircleHandler.addToSocialSDK();
    }

    private WeiXinShareContent initWXShareContent() {
        WeiXinShareContent WeiXinShare = new WeiXinShareContent();
//        SinaShareContent sinaShare = new SinaShareContent();
        WeiXinShare.setTitle(mTitle);
        WeiXinShare.setShareContent(mShareContent);
        WeiXinShare.setTargetUrl(mShareUrl);
        if (mImage != null) {
            WeiXinShare.setShareImage(mImage);
        }
        return WeiXinShare;
    }

    private CircleShareContent initCircleShareContent() {
        CircleShareContent CircleShare = new CircleShareContent();
//        SinaShareContent sinaShare = new SinaShareContent();
        CircleShare.setTitle(mTitle);
        CircleShare.setShareContent(mShareContent);
        CircleShare.setTargetUrl(mShareUrl);
        if (mImage != null) {
            CircleShare.setShareImage(mImage);
        }
        return CircleShare;
    }

    private void addSinaPlatform() {
        mController.getConfig().setSsoHandler(new SinaSsoHandler());
    }

    /**
     * 打开分享面板
     */
    public void showShare() {
        mController.getConfig().setPlatforms(SHARE_MEDIA.WEIXIN, SHARE_MEDIA.WEIXIN_CIRCLE,
                SHARE_MEDIA.QQ, SHARE_MEDIA.QZONE
        );
        mController.setShareContent(mShareContent);
        mController.setShareImage(mImage);
        mController.setAppWebSite(mShareUrl);
        mController.openShare(activity, false);
//        mController.setShareContent(mShareContent);
//        mController.openShare(activity, false);
    }
}
