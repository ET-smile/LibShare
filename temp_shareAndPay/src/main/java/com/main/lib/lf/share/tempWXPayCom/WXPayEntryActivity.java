package com.main.lib.lf.share.tempWXPayCom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;

/**
 * Created by longf on 2016/5/18.
 */
public class WXPayEntryActivity extends AppCompatActivity implements IWXAPIEventHandler {
    private static final String TAG = "MicroMsg.SDKSample.WXPayEntryActivity";

    private IWXAPI api;
    private String PAY_ORDER_TYPE_KEY = "";
    private String orderNumber = "";
    private String goodsDetail = "";
    private String orderId = "";


//	@Override
//	protected void initViews(Bundle savedInstanceState) {
//		api = WXAPIFactory.createWXAPI(this, Constants.APP_ID);
//		api.handleIntent(getIntent(), this);
//
//
//	}



    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        api.handleIntent(intent, this);
    }

    @Override
    public void onReq(BaseReq req) {
    }

    @Override
    public void onResp(BaseResp resp) {
      /*  Debug.error(TAG, "onPayFinish, errCode = " + resp.errCode);


        Bundle orginData = (Bundle) MainApplication.getInstance().getExtralObj(com.lingkj.app.medgretraining.config.Constants.TEMP_KEY);
        goodsDetail = orginData.getString(com.lingkj.app.medgretraining.config.Constants.PAY_GOODS_DETAIL);
        orderNumber = orginData.getString(com.lingkj.app.medgretraining.config.Constants.PAY_ORDER_NUMBER);
        orderId = orginData.getString(com.lingkj.app.medgretraining.config.Constants.PAY_ORDER_ID);
        PAY_ORDER_TYPE_KEY = orginData.getString(com.lingkj.app.medgretraining.config.Constants.PAY_ORDER_TYPE_KEY);

        Debug.error("-------PAY_ORDER_TYPE_KEY---------"+PAY_ORDER_TYPE_KEY);
        Debug.error("-------orderId---------"+orderId);
        Debug.error("-------orderNumber---------"+orderNumber);
        Debug.error("-------goodsDetail---------"+goodsDetail);

        if (resp.getType() == ConstantsAPI.COMMAND_PAY_BY_WX) {
            int code = resp.errCode;
            String msg = "";
            Intent intent;
            switch (code) {
                case 0:
                    msg = "支付成功！";
                    SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
                    String date = sDateFormat.format(new java.util.Date());

                    payOrder("2","",date,orderNumber, SFLoginConfig.sf_getMuseId(),SFLoginConfig.sf_getPwd(),SFLoginConfig.sf_getOnLineKey());

//					if (PAY_ORDER_TYPE_KEY.equals(com.lingkj.app.medgretraining.config.Constants.PAY_ORDER_TYPE_VALUE_GGODS)){
//						Debug.error("---------1---------------");
//						payOrder("2","",date,orderNumber);
//					}else if (PAY_ORDER_TYPE_KEY.equals(com.lingkj.app.medgretraining.config.Constants.PAY_ORDER_TYPE_VALUE_BAG)){
//						Debug.error("---------2---------------");
//						payOrder("2","",date,goodsDetail);
//					}else if (PAY_ORDER_TYPE_KEY.equals(com.lingkj.app.medgretraining.config.Constants.PAY_ORDER_TYPE_VALUE_GROUP_BUY_GOODS)){
//						Debug.error("---------3--------------");
//						payOrder("2","",date,orderNumber);
//					}
//					Debug.error("---------4---------------");


                    break;
                case -1:
                    msg = "支付失败！"+resp.errStr;
                    break;
                case -2:
                    msg = "您取消了支付！";
                    break;

                default:
                    msg = "支付失败！";
                    break;
            }

        }*/
    }




/*
	*//** 支付订单
     *
     * @param payment
     * @param tradeNo
     * @param payTime
     * @param outTradeNo
     *//*
	private void payOrder(String payment,String tradeNo,String payTime,String outTradeNo){
		Debug.error("---------5---------------");
		RemoteApiFactory.executeMethod(RemoteApiFactory.createRemoteApi(TempAction.class).payOrder(payment, tradeNo, payTime, outTradeNo), new RemoteApiFactory.OnCallBack<TempResponse>() {
			@Override
			public void onSucceed(TempResponse data) {
				Debug.error(data.toString());
				Debug.error("---------6---------------");
				if (data.getType()==1){
					Debug.error("---------7--------------");
					Intent intent = new Intent(getTempContext(), ActPayment.class);

					intent.putExtra(com.lingkj.app.medgretraining.config.Constants.PAY_GOODS_DETAIL,goodsDetail);
					intent.putExtra(com.lingkj.app.medgretraining.config.Constants.PAY_ORDER_NUMBER,orderNumber);
					intent.putExtra(com.lingkj.app.medgretraining.config.Constants.PAY_ORDER_ID,orderId);
					intent.putExtra(com.lingkj.app.medgretraining.config.Constants.WEI_XIN_PAY_SUCCESS_KEY, com.lingkj.app.medgretraining.config.Constants.WEI_XIN_PAY_SUCCESS_VALUES);
					startActivity(intent);

				}
				finish();
			}

			@Override
			public void onCompleted() {

			}

			@Override
			public void onError(Throwable e) {

			}
		});

	}*/


    /**
     *1.4.9支付商品订单（张馨予）
     * @param payment
     * @param tradeNo
     * @param payTime
     * @param outTradeNo
     * @param museId
     * @param musePwd
     * @param museOnlineTag
     */
//    private void payOrder (String payment,String tradeNo,String payTime,String outTradeNo ,String museId,String musePwd,String museOnlineTag) {
//
//        RemoteApiFactory.executeMethod(RemoteApiFactory.createRemoteApi(TempAction.class).payOrder(payment,tradeNo,payTime,outTradeNo,museId,musePwd,museOnlineTag), new RemoteApiFactory.OnCallBack<PespActMysetup>() {
//            @Override
//            public void onSucceed(PespActMysetup data) {
//
//                Debug.error("支付成功回调---"+data.toString());
//
//
//
//            }
//
//            @Override
//            public void onCompleted() {
//                dismissProgressDialog();
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//        });
//    }

}
