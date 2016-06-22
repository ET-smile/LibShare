package com.main.lib.lf.share.tempShareCom;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.main.lib.lf.R;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.bean.SocializeEntity;
import com.umeng.socialize.bean.StatusCode;
import com.umeng.socialize.controller.UMServiceFactory;
import com.umeng.socialize.controller.UMSocialService;
import com.umeng.socialize.controller.listener.SocializeListeners;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.sso.QZoneSsoHandler;
import com.umeng.socialize.sso.UMQQSsoHandler;
import com.umeng.socialize.weixin.controller.UMWXHandler;

/**
 * Created by longf on 2016/5/18.
 */
public class TempShareVSCustomHelper extends PopupWindow implements View.OnClickListener{
    private UMSocialService mController = UMServiceFactory.getUMSocialService("com.umeng.share");
    private Activity mActivity;
    private String mShareUrl, mTitle, mShareContent;
    private UMImage mImage;
    public TempShareVSCustomHelper(Activity activity, String shareUrl, String title, String shareContent, UMImage image) {
        super(activity);
        this.mActivity = activity;
        mImage = image;
        mShareUrl = shareUrl;
        mTitle = title;
        mShareContent = shareContent;
        initView(activity);
        addQQQZonePlatform();
        addWXPlatform();
    }

    @SuppressWarnings("deprecation")
    private void initView(Context context) {
        View rootView = LayoutInflater.from(context).inflate(R.layout.temp_custom_share_board_layout, null);
        rootView.findViewById(R.id.temp_share_wechat).setOnClickListener(this);
        rootView.findViewById(R.id.temp_share_circle).setOnClickListener(this);
        rootView.findViewById(R.id.temp_share_qq).setOnClickListener(this);
        rootView.findViewById(R.id.temp_share_qzone).setOnClickListener(this);
        setContentView(rootView);
        setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        setFocusable(true);
        setBackgroundDrawable(new BitmapDrawable());
        setTouchable(true);
    }
    public void showShare(){
        showAtLocation(mActivity.getWindow().getDecorView(), Gravity.BOTTOM,0,0);

    }
    @Override
    public void onClick(View v) {
//        switch (v.getId()){
//            case R.id.temp_share_circle:
//                break;
//        }

        int i = v.getId();
        if (i == R.id.temp_share_wechat) {
            performShare(SHARE_MEDIA.WEIXIN);

        } else if (i == R.id.temp_share_circle) {
            performShare(SHARE_MEDIA.WEIXIN_CIRCLE);

        } else if (i == R.id.temp_share_qq) {
            performShare(SHARE_MEDIA.QQ);

        } else if (i == R.id.temp_share_qzone) {
            performShare(SHARE_MEDIA.QZONE);

        }
    }

    private void performShare(SHARE_MEDIA platform) {
        mController.setShareContent(mShareContent);
        mController.setShareImage(mImage);
        mController.setAppWebSite(mShareUrl);
        mController.postShare(mActivity, platform, new SocializeListeners.SnsPostListener() {

            @Override
            public void onStart() {

            }

            @Override
            public void onComplete(SHARE_MEDIA platform, int eCode, SocializeEntity entity) {
                String showText = platform.toString();
                if (eCode == StatusCode.ST_CODE_SUCCESSED) {
                    showText += "平台分享成功";
                } else {
                    showText += "平台分享失败";
                }
                Toast.makeText(mActivity, showText, Toast.LENGTH_SHORT).show();
                dismiss();
            }
        });
    }
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
        UMQQSsoHandler qqSsoHandler = new UMQQSsoHandler(mActivity,
                TempShareConfig.APPID_QQ, TempShareConfig.APPKEY_QQ);
        qqSsoHandler.setTargetUrl(mShareUrl);
        qqSsoHandler.setTitle(mTitle);

        qqSsoHandler.addToSocialSDK();

        // 添加QZone平台
        QZoneSsoHandler qZoneSsoHandler = new QZoneSsoHandler(mActivity, TempShareConfig.APPID_QQ, TempShareConfig.APPKEY_QQ);
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
        UMWXHandler wxHandler = new UMWXHandler(mActivity, TempShareConfig.APPID_weixin, TempShareConfig.SECRET_weixin);
        wxHandler.setTargetUrl(mShareUrl);
        wxHandler.setTitle(mTitle);
        wxHandler.addToSocialSDK();
        // 支持微信朋友圈
        UMWXHandler wxCircleHandler = new UMWXHandler(mActivity, TempShareConfig.APPID_weixin, TempShareConfig.SECRET_weixin);
        wxCircleHandler.setToCircle(true);
        wxCircleHandler.setTitle(mTitle);
        wxCircleHandler.setTargetUrl(mShareUrl);
        wxCircleHandler.addToSocialSDK();
    }

}
