package customer.tcrj.com.zsproject.first.fwzx;

import android.content.res.TypedArray;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import com.tsy.sdk.myokhttp.MyOkHttp;
import com.tsy.sdk.myokhttp.response.GsonResponseHandler;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import customer.tcrj.com.zsproject.ApiConstants;
import customer.tcrj.com.zsproject.MyApp;
import customer.tcrj.com.zsproject.R;
import customer.tcrj.com.zsproject.adapter.MainMenuAdapter;
import customer.tcrj.com.zsproject.adapter.MainMenuListAdapter;
import customer.tcrj.com.zsproject.base.BaseActivity;
import customer.tcrj.com.zsproject.bean.MenuEntity;
import customer.tcrj.com.zsproject.bean.tzInfo;
import customer.tcrj.com.zsproject.widget.MyGridView;
import customer.tcrj.com.zsproject.widget.MyListView;

public class fwzx2Activity extends BaseActivity implements AdapterView.OnItemClickListener {

    @BindView(R.id.more)
    TextView more;

    @BindView(R.id.noData)
    TextView noData;

    @BindView(R.id.tv_xslc)
    TextView tv_xslc;

    @BindView(R.id.listview_my)
    MyListView listview_my;

    @BindView(R.id.grid_sign)
    public MyGridView myGridView;



    MainMenuAdapter adapter1;
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
        getDataFromNet();
        CharSequence[] sign = this.getResources().getStringArray(R.array.firdt_btn_name);
        TypedArray imagesign = this.getResources().obtainTypedArray(R.array.image_menu_sign);
        List<MenuEntity> dataList = new ArrayList<>();
        adapter1 = new MainMenuAdapter(this);

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
                        if(listview_my != null){
                            listview_my.setVisibility(View.GONE);
                        }

                        if(noData != null){
                            noData.setVisibility(View.VISIBLE);
                        }


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
                            adapterlist = new MainMenuListAdapter(fwzx2Activity.this);
                            adapterlist.setData(response);
                            listview_my.setAdapter(adapterlist);
                        }else{
                            listview_my.setVisibility(View.GONE);
                            noData.setVisibility(View.VISIBLE);
                        }

                    }
                });
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @OnClick({R.id.more,R.id.tv_xslc})
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.more:
                break;
            case R.id.tv_xslc:
                setGirdviewData();
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

    private void setGirdviewData(){
        CharSequence[] sign = this.getResources().getStringArray(R.array.firdt_btn_name);
        TypedArray imagesign = this.getResources().obtainTypedArray(R.array.image_menu_sign);
        List<MenuEntity> dataList = new ArrayList<>();
        adapter1 = new MainMenuAdapter(this);

        for (int i = 0; i < 1; i++) {
            MenuEntity quick = new MenuEntity();
            quick.setMenuId(i);
            quick.setImageId(imagesign.getResourceId(i, 0));
            quick.setMenuName(sign[i].toString());
            dataList.add(quick);
        }

        adapter1.setData(dataList);
        myGridView.setAdapter(adapter1);
    }
}
