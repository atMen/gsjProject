package customer.tcrj.com.zsproject.first.fwzx;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.tsy.sdk.myokhttp.MyOkHttp;
import com.tsy.sdk.myokhttp.response.GsonResponseHandler;
import com.tsy.sdk.myokhttp.response.JsonResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import customer.tcrj.com.zsproject.ApiConstants;
import customer.tcrj.com.zsproject.MyApp;
import customer.tcrj.com.zsproject.R;
import customer.tcrj.com.zsproject.Utils.Constant;
import customer.tcrj.com.zsproject.Utils.Utils;
import customer.tcrj.com.zsproject.adapter.MainMenuAdapter;
import customer.tcrj.com.zsproject.adapter.MainMenuListAdapter;
import customer.tcrj.com.zsproject.adapter.zcgsAdapter;
import customer.tcrj.com.zsproject.adapter.zcgssAdapter;
import customer.tcrj.com.zsproject.base.BaseActivity;
import customer.tcrj.com.zsproject.bean.MenuEntity;
import customer.tcrj.com.zsproject.bean.flInfo;
import customer.tcrj.com.zsproject.bean.pxInfo;
import customer.tcrj.com.zsproject.bean.tpxwInfo;
import customer.tcrj.com.zsproject.bean.tzInfo;
import customer.tcrj.com.zsproject.bean.zcgsInfo;
import customer.tcrj.com.zsproject.bean.zcgssInfo;
import customer.tcrj.com.zsproject.widget.MyGridView;
import customer.tcrj.com.zsproject.widget.MyListView;

public class fwzx2Activity extends BaseActivity implements AdapterView.OnItemClickListener {

    @BindView(R.id.more)
    TextView more;

    @BindView(R.id.noData)
    TextView noData;

    @BindView(R.id.txtTitle)
    TextView txtTitle;
    @BindView(R.id.btnback)
    ImageView btnback;

    @BindView(R.id.tv_xslc)
    TextView tv_xslc;

    @BindView(R.id.listview_my)
    MyListView listview_my;

    @BindView(R.id.grid_sign)
    public MyGridView myGridView;



    zcgssAdapter adapter1;
    MainMenuListAdapter adapterlist;
    private MyOkHttp mMyOkhttp;


    @Override
    protected int setLayout() {
        return R.layout.activity_fwzx2;
    }

    @Override
    protected void setView() {
        mMyOkhttp = MyApp.getInstance().getMyOkHttp();
    }

    @Override
    protected void setData() {
        txtTitle.setText("政策公示");
        getDataFromNet();
        adapter1 = new zcgssAdapter(this);
        myGridView.setOnItemClickListener(this);
        getGirdData("Njyma2");


    }

    private void getGirdData(String code) {

        JSONObject jsonObject = new JSONObject();

        try {
            jsonObject.put("parentId", code);



        } catch (JSONException e) {
            e.printStackTrace();
        }

        mMyOkhttp.post()
                .url(ApiConstants.zcgs_s_listApi)
                .jsonParams(jsonObject.toString())
                .enqueue(new GsonResponseHandler<zcgssInfo>() {
                    @Override
                    public void onFailure(int statusCode, String error_msg) {


                    }

                    @Override
                    public void onSuccess(int statusCode, zcgssInfo response) {
                        listinfo = response.getListinfo();
                        adapter1.setData(listinfo);
                        myGridView.setAdapter(adapter1);
                    }
                });
    }

    List<zcgssInfo.ListinfoBean> listinfo;
    List<tpxwInfo.ListinfoBean> content;
    public void getDataFromNet() {

        showLoadingDialog("加载中..");

        JSONObject jsonObject = new JSONObject();

        try {

            jsonObject.put("pagesize", "10");
            jsonObject.put("pageindex","1");
            jsonObject.put("siteId", ApiConstants.siteId);
            jsonObject.put("id","");
            jsonObject.put("hits","true");


        } catch (JSONException e) {
            e.printStackTrace();
        }

        mMyOkhttp.post()
                .url(ApiConstants.xwdt_tpxwlistApi)
                .jsonParams(jsonObject.toString())
                .enqueue(new GsonResponseHandler<tpxwInfo>() {
                    @Override
                    public void onFailure(int statusCode, String error_msg) {

                        Log.e("TAG","失败");
                        hideLoadingDialog();
//                      Toast.makeText(mContext, "服务器连接错误", Toast.LENGTH_SHORT).show();
                        if(listview_my != null){
                            listview_my.setVisibility(View.GONE);
                        }

                        if(noData != null){
                            noData.setVisibility(View.VISIBLE);
                        }

                    }

                    @Override
                    public void onSuccess(int statusCode, tpxwInfo response) {
//                        Toast.makeText(mContext, response.getMessage(), Toast.LENGTH_SHORT).show();

                        Log.e("TAG","info:"+response.toString());
                        hideLoadingDialog();
                        content = response.getListinfo();
//                        Log.e("TAG","info:"+content.size());
                        if(content != null && content.size() > 0){
                            listview_my.setVisibility(View.VISIBLE);
                            noData.setVisibility(View.GONE);
                            adapterlist = new MainMenuListAdapter(fwzx2Activity.this);
                            adapterlist.setData(response);
                            listview_my.setAdapter(adapterlist);
                        }else{
                            listview_my.setVisibility(View.GONE);
                            noData.setVisibility(View.VISIBLE);
                        }




                    }
                });





//        mMyOkhttp.post()
//                .url(ApiConstants.tzlistApi+"07321bc2cd")
//                .addParam("pageSize","5")
//                .addParam("pageIndex","1")
//                .enqueue(new GsonResponseHandler<tzInfo>() {
//                    @Override
//                    public void onFailure(int statusCode, String error_msg) {
//                        Log.e("TAG","失败");
//                        hideLoadingDialog();
////                      Toast.makeText(mContext, "服务器连接错误", Toast.LENGTH_SHORT).show();
//                        if(listview_my != null){
//                            listview_my.setVisibility(View.GONE);
//                        }
//
//                        if(noData != null){
//                            noData.setVisibility(View.VISIBLE);
//                        }
//
//
//                    }
//
//                    @Override
//                    public void onSuccess(int statusCode, tzInfo response) {
//                        Log.e("TAG","info:"+response.toString());
//                        hideLoadingDialog();
//                        content = response.getData();
////                        Log.e("TAG","info:"+content.size());
//                        if(content != null && content.size() > 0){
//                            listview_my.setVisibility(View.VISIBLE);
//                            noData.setVisibility(View.GONE);
//                            adapterlist = new MainMenuListAdapter(fwzx2Activity.this);
//                            adapterlist.setData(response);
//                            listview_my.setAdapter(adapterlist);
//                        }else{
//                            listview_my.setVisibility(View.GONE);
//                            noData.setVisibility(View.VISIBLE);
//                        }
//
//                    }
//                });
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "点击事件："+listinfo.get(position).getId(), Toast.LENGTH_SHORT).show();

        Bundle bundle = new Bundle();
        bundle.putString("id",listinfo.get(position).getId());
        toClass(this,zcgsinfoActivity.class,bundle);
    }

    @OnClick({R.id.more,R.id.tv_xslc,R.id.btnback})
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.more:
                break;
            case R.id.tv_xslc:
//                getGirdData();
                break;
//
            case R.id.btnback:
                finish();
                break;
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



}
