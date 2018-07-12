package customer.tcrj.com.zsproject.first.zcgs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import butterknife.OnClick;
import customer.tcrj.com.zsproject.ApiConstants;
import customer.tcrj.com.zsproject.MyApp;
import customer.tcrj.com.zsproject.R;
import customer.tcrj.com.zsproject.adapter.bankAdapter;
import customer.tcrj.com.zsproject.adapter.jrAdapter;
import customer.tcrj.com.zsproject.adapter.zxwjAdapter;
import customer.tcrj.com.zsproject.base.BaseActivity;
import customer.tcrj.com.zsproject.bean.bankInfo;
import customer.tcrj.com.zsproject.bean.qyListInfo;
import customer.tcrj.com.zsproject.bean.tpxwInfo;
import customer.tcrj.com.zsproject.widget.CustomLoadMoreView;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;

public class yhActivity extends BaseActivity implements BaseQuickAdapter.OnItemClickListener {

    @BindView(R.id.txtTitle)
    TextView txtTitle;
    @BindView(R.id.btnback)
    ImageView btnback;
    @BindView(R.id.ed_tv)
    EditText ed_tv;
    @BindView(R.id.recycler_view)
    public RecyclerView mRecyclerView;
    @BindView(R.id.mPtrFrameLayout)
    PtrFrameLayout mPtrFrameLayout;


    private MyOkHttp mMyOkhttp;
    private bankAdapter detailAdapter;
    private List<bankInfo.DataBean> beanList;

    private int pageNum = 1;
    private boolean canPull = true;

    @Override
    protected int setLayout() {
        return R.layout.activity_yh;
    }

    @OnClick({R.id.btnback,R.id.ll_ss})
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnback:
                finish();
                break;

        }
    }

    @Override
    protected void setView() {

        txtTitle.setText("选择银行");

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
                pageNum = 1;
              getData(pageNum);

            }
        });
        beanList = new ArrayList<>();



        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(detailAdapter = new bankAdapter(beanList, this));
        detailAdapter.setPreLoadNumber(1);
        detailAdapter.setLoadMoreView(new CustomLoadMoreView());
        detailAdapter.setEnableLoadMore(false);
        detailAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        detailAdapter.setOnItemClickListener(this);
        detailAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                Log.e("TAG","点击重新加载数据");
//                getData(pageNum);
            }
        }, mRecyclerView);


    }

    //错误页面的点击回调，重新加载数据
    @Override
    public void onRetry() {
        getData(pageNum);
    }

    @Override
    protected void setData() {
        getData(pageNum);
    }


    //获取网络数据
    private void getData(final int num) {

        JSONObject jsonObject = new JSONObject();

        try {

//            jsonObject.put("page", num+"");
//            jsonObject.put("size", "20");
            jsonObject.put("id", "");

        } catch (JSONException e) {
            e.printStackTrace();
        }

        mMyOkhttp.post()
                .url(ApiConstants.jr_bank_listApi)
                .jsonParams(jsonObject.toString())
                .enqueue(new GsonResponseHandler<bankInfo>() {
                    @Override
                    public void onFailure(int statusCode, String error_msg) {

                        Toast.makeText(yhActivity.this, error_msg, Toast.LENGTH_SHORT).show();

                        if(num > 1){
//                            loadMoreData(null,true);
                        }else{
                            loadData(null,true);

                        }
                    }

                    @Override
                    public void onSuccess(int statusCode, bankInfo response) {

                        if("SUCCESS".equals(response.getErrorCode())){

                            if(num > 1){//上拉加载
//                                loadMoreData(response,false);
                            }else{//下拉刷新
                                loadData(response.getData(),false);
                            }

                        }



                    }
                });

    }

    //上拉加载更多数据
//    private void loadMoreData(bankInfo response,boolean isError) {
//        Log.e("TAG","loadMoreData");
//        if (response == null) {
//            Log.e("TAG","response == null:");
//            if(isError){
//                detailAdapter.loadMoreFail();
//                Toast.makeText(yhActivity.this, getResources().getString(R.string.data_failed), Toast.LENGTH_SHORT).show();
//            }else{
//                detailAdapter.loadMoreFail();
//            }
//
//        } else {
//
//            if(pageNum > response.getData().getTotalPages()){//没有更多数据
//                Log.e("TAG","没有更多数据"+response.getData().getTotalPages());
//
//
//                    detailAdapter.loadMoreFail();
//
//
////                Toast.makeText(mContext, getResources().getString(R.string.data_nomore), Toast.LENGTH_SHORT).show();
//            }else{
//                List<qyListInfo.DataBean.ContentBean> content = response.getData().getContent();
//                Log.e("TAG","content:"+content.size());
//                pageNum++;
//
//                    detailAdapter.addData(content);
//
//
//                detailAdapter.loadMoreComplete();
//            }
//
//        }
//
//
//
//
//    }

    //下拉刷新
    private void loadData(List<bankInfo.DataBean> response,boolean isError) {

        if (response == null  || response.size() <= 0) {
            if(mPtrFrameLayout != null){
                mPtrFrameLayout.refreshComplete();
            }
            if(isError){
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
            disableLoadMoreIfNotFullPage(mRecyclerView,response.size());
        }
    }


    public void disableLoadMoreIfNotFullPage(RecyclerView recyclerView, final int size) {
        detailAdapter.setEnableLoadMore(false);
        if (recyclerView == null) return;
        RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();
        if (manager == null) return;
        if (manager instanceof LinearLayoutManager) {
            final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) manager;

                recyclerView.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        //要等到列表显示出来才可以去获取：findLastCompletelyVisibleItemPosition
                        if ((linearLayoutManager.findLastCompletelyVisibleItemPosition() + 1) != size) {
                            detailAdapter.setEnableLoadMore(true);
                        }

                        Log.e("TAG","测试："+(linearLayoutManager.findLastCompletelyVisibleItemPosition() + 1));
                    }
                }, 1000);



        }
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        bankInfo.DataBean response = (bankInfo.DataBean) adapter.getItem(position);
        Intent intent = new Intent();
        intent.putExtra("bankId", response.getId());
        intent.putExtra("bankName", response.getName());
        setResult(2, intent);
        finish();

    }
}
