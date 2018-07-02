package customer.tcrj.com.zsproject.first;


import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jaeger.library.StatusBarUtil;
import com.tsy.sdk.myokhttp.MyOkHttp;
import com.tsy.sdk.myokhttp.response.GsonResponseHandler;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import customer.tcrj.com.zsproject.ApiConstants;
import customer.tcrj.com.zsproject.MainActivity;
import customer.tcrj.com.zsproject.MyApp;
import customer.tcrj.com.zsproject.R;
import customer.tcrj.com.zsproject.adapter.MainMenuAdapter;
import customer.tcrj.com.zsproject.adapter.MainMenuListAdapter;
import customer.tcrj.com.zsproject.base.BaseFragment;
import customer.tcrj.com.zsproject.bean.MenuEntity;
import customer.tcrj.com.zsproject.bean.tpxwInfo;
import customer.tcrj.com.zsproject.bean.tzInfo;
import customer.tcrj.com.zsproject.first.fgdtj.fgdtjActivity;
import customer.tcrj.com.zsproject.first.fwzx.fwzx2Activity;
import customer.tcrj.com.zsproject.first.gridbtn.xwdtInfoActivity;
import customer.tcrj.com.zsproject.first.jzfp.jzfpActivity;
import customer.tcrj.com.zsproject.first.zcgs.zcgsActivity;
import customer.tcrj.com.zsproject.widget.GlideImageLoader;
import customer.tcrj.com.zsproject.widget.MyGridView;
import customer.tcrj.com.zsproject.widget.MyListView;


/**
 * Created by leict on 2018/3/22.
 */

public class FirstFragment extends BaseFragment implements AdapterView.OnItemClickListener, OnBannerListener {

    @BindView(R.id.more)
    TextView more;

    @BindView(R.id.noData)
    TextView noData;

    @BindView(R.id.listview_my)
    MyListView listview_my;

    @BindView(R.id.grid_sign)
    public MyGridView myGridView;

    @BindView(R.id.banner)
    Banner banner;

    MainMenuAdapter adapter1;
    MainMenuListAdapter adapterlist;
    private MyOkHttp mMyOkhttp;

    @Override
    protected int setLayout() {
        return R.layout.first_fragment;
    }

    @Override
    protected void setView() {
        mMyOkhttp = MyApp.getInstance().getMyOkHttp();
        titles = new ArrayList<>();
    }


    @Override
    protected void setData() {
        getDataFromNet();
        geticonDataFromNet();
        CharSequence[] sign = this.getResources().getStringArray(R.array.firdt_btn_name);
        TypedArray imagesign = this.getResources().obtainTypedArray(R.array.image_menu_sign);
        List<MenuEntity> dataList = new ArrayList<>();
        adapter1 = new MainMenuAdapter(mContext);

        for (int i = 0; i < sign.length; i++) {
            MenuEntity quick = new MenuEntity();
            quick.setMenuId(i);
            quick.setImageId(imagesign.getResourceId(i, 0));
            quick.setMenuName(sign[i].toString());
            dataList.add(quick);
        }

        adapter1.setData(dataList);
        myGridView.setAdapter(adapter1);
        myGridView.setOnItemClickListener(this);
        listview_my.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                T(position+"被点击");
//                tzInfo.DataBean dataBean = content.get(position);
//                Bundle bundle = new Bundle();
//                bundle.putSerializable("ztinfo",dataBean);
//                toClass(mContext, PushMessageActivity.class,bundle);
            }
        });

    }

    private void geticonDataFromNet() {
        JSONObject jsonObject = new JSONObject();

        try {
            jsonObject.put("pagesize", "4");
            jsonObject.put("pageindex", "1");
            jsonObject.put("siteId", ApiConstants.siteId);
            jsonObject.put("id", ApiConstants.YWDT);


        } catch (JSONException e) {
            e.printStackTrace();
        }

        mMyOkhttp.post()
                .url(ApiConstants.xwdt_tpxwlistApi)
                .jsonParams(jsonObject.toString())
                .enqueue(new GsonResponseHandler<tpxwInfo>() {
                    @Override
                    public void onFailure(int statusCode, String error_msg) {

                        Toast.makeText(mContext, error_msg, Toast.LENGTH_SHORT).show();


                    }

                    @Override
                    public void onSuccess(int statusCode, tpxwInfo response) {
//                        Toast.makeText(mContext, response.getMessage(), Toast.LENGTH_SHORT).show();

                        if(response.getState() == 1){

                            bannerList = response.getListinfo();
//                            bannerList1 = response.getData().get(1);

                            Log.e("TAG","bannerList"+bannerList.size());
                            if(bannerList.size()>0 ){

                                for(int i = 0;i < bannerList.size(); i++){
                                    titles.add(bannerList.get(i).getTitle());

                                    Log.e("TAG","msg"+bannerList.get(i).getThumbUrl());
                                }
                                setBannerData(bannerList);
//                                icon_title.setText(bannerList.get(0).getTitle());
                            }

                        }
                    }
                });
    }


//    设置轮播图数据
    List<tpxwInfo.ListinfoBean> bannerList;
    private List<String> titles;
    private void setBannerData(List<tpxwInfo.ListinfoBean> bannerList) {

        banner.setImages(bannerList)
                .setBannerTitles(titles)
                .setImageLoader(new GlideImageLoader())
                .setOnBannerListener(this)
                .start()
                .updateBannerStyle(BannerConfig.NUM_INDICATOR_TITLE);


    }

    List<tzInfo.DataBean> content;
    public void getDataFromNet() {

        showLoadingDialog("加载中..");
        mMyOkhttp.post()
                .url(ApiConstants.tzlistApi+"07321bc2cd")
                .addParam("pageSize","5")
                .addParam("pageIndex","1")
                .enqueue(new GsonResponseHandler<tzInfo>() {
                    @Override
                    public void onFailure(int statusCode, String error_msg) {
                        Log.e("TAG","失败");
                        hideLoadingDialog();
//                      Toast.makeText(mContext, "服务器连接错误", Toast.LENGTH_SHORT).show();
                        listview_my.setVisibility(View.GONE);
                        noData.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onSuccess(int statusCode, tzInfo response) {
                        Log.e("TAG","info:"+response.toString());
                        hideLoadingDialog();
                        content = response.getData();
//                        Log.e("TAG","info:"+content.size());
                        if(content != null && content.size() > 0){
                            listview_my.setVisibility(View.VISIBLE);
                            noData.setVisibility(View.GONE);
                            adapterlist = new MainMenuListAdapter(mContext);
                            adapterlist.setData(response);
                            listview_my.setAdapter(adapterlist);
                        }else{
                            listview_my.setVisibility(View.GONE);
                            noData.setVisibility(View.VISIBLE);
                        }

                    }
                });
    }


    @OnClick({R.id.more})
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.more:

                break;
//
//            case R.id.ll_cxlc:
//                toClass(mContext,MainActivity.class);//产销流程
//                break;
//
//            case R.id.ll_zsmsq:
//                toClass(mContext,ZScodeActivity.class);//追溯码申请
//                break;
//
//            case R.id.ll_spjg:
//                toClass(mContext,MainActivity.class);//审批结果查询
//                break;

        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.e("TAG","position:"+position);
        switch (position){
            case 0:
                toClass(mContext,xwdtInfoActivity.class);//新闻动态
                break;
            case 1:
                toClass(mContext,fwzx2Activity.class);//政策公示
                break;
            case 2:
                toClass(mContext,zcgsActivity.class);//服务中心

                break;
            case 3:
//                toClass(mContext,tsListActivity.class);//投诉
                break;
            case 4:
                toClass(mContext,jzfpActivity.class);//精准扶贫
                break;
            case 5:
                toClass(mContext,fgdtjActivity.class);//非公党团
                break;
            case 6:
//                toClass(mContext,xzzfListActivity.class);//行政执法
                break;
            case 7:
//                toClass(mContext,BaiduMapActivity.class);//地图位置
                break;
        }
    }


//    @Override
//    public void onClick(View v) {
//
////        switch (v.getId()){
////
////            case R.id.ll_xxks:
////                toClass(mContext,XxkcActivity.class);//学习考试
////                break;
////            case R.id.ll_xxcx:
////                toClass(mContext,XxcxActivity.class);//信息查询
////                break;
////            case R.id.ll_hdjl:
////                toClass(mContext,hdjlnewActivity.class);//互动交流
////                break;
////            case R.id.ll_xxfb:
////                toClass(mContext,releaseActivity.class);//信息发布
////                break;
////
////        }
//
//    }

    //如果你需要考虑更好的体验，可以这么操作
    @Override
    public void onStart() {
        super.onStart();
        //开始轮播
        banner.startAutoPlay();
    }

    @Override
    public void onStop() {
        super.onStop();
        //结束轮播
        banner.stopAutoPlay();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
//        mMZBanner.pause();//暂停轮播
    }
//    tpxwInfo.ListinfoBean
    @Override
    public void OnBannerClick(int position) {
//        tpxwInfo.ListinfoBean dataBean = bannerList.get(position);
//        Bundle bundle = new Bundle();
//        bundle.putSerializable("picInfo",dataBean);
//        toClass(mContext,NewsDetailActivity.class,bundle);

        T(position+"");
    }

}
