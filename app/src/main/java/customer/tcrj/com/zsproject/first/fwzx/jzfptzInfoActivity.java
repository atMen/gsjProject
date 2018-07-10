package customer.tcrj.com.zsproject.first.fwzx;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.tsy.sdk.myokhttp.MyOkHttp;
import com.tsy.sdk.myokhttp.response.GsonResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import customer.tcrj.com.zsproject.ApiConstants;
import customer.tcrj.com.zsproject.MyApp;
import customer.tcrj.com.zsproject.R;
import customer.tcrj.com.zsproject.adapter.jzfptzAdapter;
import customer.tcrj.com.zsproject.adapter.zxwjAdapter;
import customer.tcrj.com.zsproject.base.BaseActivity;
import customer.tcrj.com.zsproject.bean.jzfptzInfo;
import customer.tcrj.com.zsproject.bean.tpxwInfo;
import customer.tcrj.com.zsproject.widget.CustomLoadMoreView;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;


public class jzfptzInfoActivity extends BaseActivity implements BaseQuickAdapter.OnItemClickListener {


    @BindView(R.id.btnback)
    public ImageView btnback;

    @BindView(R.id.txtTitle)
    public TextView title_tv;
    @BindView(R.id.recycler_view)
    public RecyclerView mRecyclerView;
    @BindView(R.id.mPtrFrameLayout)
    PtrFrameLayout mPtrFrameLayout;

    private MyOkHttp mMyOkhttp;
    private jzfptzAdapter detailAdapter;
    private List<jzfptzInfo.ProvinceBean> beanList;

    private int pageNum = 1;
    private boolean canPull = true;

    private String id;


    @Override
    protected int setLayout() {
        return R.layout.activity_zcgsinfo;
    }

    @Override
    protected void setView() {

        id = getIntent().getStringExtra("id");
        mMyOkhttp = MyApp.getInstance().getMyOkHttp();

        mPtrFrameLayout.disableWhenHorizontalMove(true);
        mPtrFrameLayout.setPtrHandler(new PtrHandler() {
            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {

                if(!canPull){
                    return false;
                }
                return PtrDefaultHandler.checkContentCanBePulledDown(frame, mRecyclerView, header);
            }

            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                getData();

            }
        });
        beanList = new ArrayList<>();

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(detailAdapter = new jzfptzAdapter(beanList, this));
        detailAdapter.setPreLoadNumber(1);
        detailAdapter.setEnableLoadMore(false);
        detailAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        detailAdapter.setOnItemClickListener(this);

//      showSuccess();

    }

    //错误页面的点击回调，重新加载数据
    @Override
    public void onRetry() {
        getData();
    }

    @Override
    protected void setData() {
        getData();
    }

    //获取网络数据
    private void getData() {

        JSONObject jsonObject = new JSONObject();

        try {

            jsonObject.put("cityId", "");
            jsonObject.put("countyId", "");



        } catch (JSONException e) {
            e.printStackTrace();
        }

        mMyOkhttp.post()
                .url(ApiConstants.sjfp_tz_listApi)
                .jsonParams(jsonObject.toString())
                .enqueue(new GsonResponseHandler<jzfptzInfo>() {
                    @Override
                    public void onFailure(int statusCode, String error_msg) {



                            loadData(null,true);


                    }

                    @Override
                    public void onSuccess(int statusCode, jzfptzInfo response) {
//                        Toast.makeText(mContext, response.getMessage(), Toast.LENGTH_SHORT).show();


                        List<jzfptzInfo.ProvinceBean> province = response.getProvince();
                        loadData(response.getProvince(),false);






                    }
                });

    }


    //下拉刷新
    private void loadData(List<jzfptzInfo.ProvinceBean> response,boolean isError) {

        if (response == null  || response.size() <= 0) {
            if(mPtrFrameLayout != null){
                mPtrFrameLayout.refreshComplete();
            }
            if(isError){
//              Toast.makeText(flfgListActivity.this, getResources().getString(R.string.data_failed), Toast.LENGTH_SHORT).show();
                showFaild();
            }else{
                showEmptyView();
            }
            canPull = false;

        } else {

            canPull = true;
            pageNum++;
            detailAdapter.setNewData(response);
            if(mPtrFrameLayout != null){
                mPtrFrameLayout.refreshComplete();
            }
            showSuccess();
        }
    }




    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

    }
}
