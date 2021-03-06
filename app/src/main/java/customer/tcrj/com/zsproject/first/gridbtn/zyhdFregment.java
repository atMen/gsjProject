package customer.tcrj.com.zsproject.first.gridbtn;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
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
import customer.tcrj.com.zsproject.adapter.FreshNewsAdapter;
import customer.tcrj.com.zsproject.adapter.zyhdAdapter;
import customer.tcrj.com.zsproject.base.BaseFragment;
import customer.tcrj.com.zsproject.base.NewsinfoActivity;
import customer.tcrj.com.zsproject.bean.qyListInfo;
import customer.tcrj.com.zsproject.bean.tpxwInfo;
import customer.tcrj.com.zsproject.widget.CustomLoadMoreView;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;

/**
 * Created by leict on 2018/4/19.
 */

public class zyhdFregment extends BaseFragment implements BaseQuickAdapter.OnItemClickListener {

//    @BindView(R.id.btnback)
//    public ImageView btnback;
//
//    @BindView(R.id.txtTitle)
//    public TextView title_tv;
    @BindView(R.id.recycler_view)
    public RecyclerView mRecyclerView;
    @BindView(R.id.mPtrFrameLayout)
    PtrFrameLayout mPtrFrameLayout;

    private MyOkHttp mMyOkhttp;
    private zyhdAdapter detailAdapter;
    private List<tpxwInfo.ListinfoBean> beanList;

    private int pageNum = 1;
    private boolean canPull = true;

    @Override
    protected int setLayout() {
        return R.layout.dy_fregment;
    }

    @Override
    protected void setView() {
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

        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerView.setAdapter(detailAdapter = new zyhdAdapter(beanList, mContext));
        detailAdapter.setPreLoadNumber(1);
        detailAdapter.setLoadMoreView(new CustomLoadMoreView());
        detailAdapter.setEnableLoadMore(true);
        detailAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        detailAdapter.setOnItemClickListener(this);
        detailAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                Log.e("TAG","点击重新加载数据");
                getData(pageNum);
            }
        }, mRecyclerView);

//        showSuccess();

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

            jsonObject.put("pagesize", "30");
            jsonObject.put("pageindex", num+"");
            jsonObject.put("siteId", ApiConstants.siteId);
            jsonObject.put("id", ApiConstants.ZYHD);


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

                        if(num > 1){
                            loadMoreData(null,true);
                        }else{
                            loadData(null,true);

                        }
                    }

                    @Override
                    public void onSuccess(int statusCode, tpxwInfo response) {
//                        Toast.makeText(mContext, response.getMessage(), Toast.LENGTH_SHORT).show();

                        if(response.getState() == 1){

                            if(num > 1){//上拉加载
                                loadMoreData(response,false);
                            }else{//下拉刷新
                                loadData(response.getListinfo(),false);
                            }

                        }



                    }
                });

    }

    //上拉加载更多数据
    private void loadMoreData(tpxwInfo response,boolean isError) {
        Log.e("TAG","loadMoreData");
        if (response == null) {
            Log.e("TAG","response == null:");
            if(isError){
                detailAdapter.loadMoreFail();
                Toast.makeText(mContext, getResources().getString(R.string.data_failed), Toast.LENGTH_SHORT).show();
            }else{
                detailAdapter.loadMoreFail();
            }

        } else {

            if(pageNum > response.getRecordCount()){//没有更多数据


                detailAdapter.loadMoreFail();
//              Toast.makeText(mContext, getResources().getString(R.string.data_nomore), Toast.LENGTH_SHORT).show();
            }else{
                List<tpxwInfo.ListinfoBean> content = response.getListinfo();
                Log.e("TAG","content:"+content.size());
                pageNum++;

                detailAdapter.addData(content);

                detailAdapter.loadMoreComplete();
            }

        }




    }

    //下拉刷新
    private void loadData(List<tpxwInfo.ListinfoBean> response,boolean isError) {

        if (response == null  || response.size() <= 0) {
            if(mPtrFrameLayout != null){
                mPtrFrameLayout.refreshComplete();
            }
            if(isError){
//                Toast.makeText(flfgListActivity.this, getResources().getString(R.string.data_failed), Toast.LENGTH_SHORT).show();
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
        tpxwInfo.ListinfoBean item = (tpxwInfo.ListinfoBean) adapter.getItem(position);

        String contentUrl = item.getId();
        if(contentUrl != null){
            Bundle bundle = new Bundle();
            bundle.putString("contentUrl",contentUrl);
            toClass(mContext,NewsinfoActivity.class,bundle);
        }else {
            T("未发现详细信息");
        }
    }
}
