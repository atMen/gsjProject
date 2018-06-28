package customer.tcrj.com.zsproject.first.jzfp;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.tsy.sdk.myokhttp.MyOkHttp;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import customer.tcrj.com.zsproject.MyApp;
import customer.tcrj.com.zsproject.R;
import customer.tcrj.com.zsproject.adapter.zxwjAdapter;
import customer.tcrj.com.zsproject.base.BaseFragment;
import customer.tcrj.com.zsproject.bean.qyListInfo;
import customer.tcrj.com.zsproject.widget.CustomLoadMoreView;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;

/**
 * Created by leict on 2018/4/19.
 */

public class tsncpFregment extends BaseFragment implements BaseQuickAdapter.OnItemClickListener {

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
    private zxwjAdapter detailAdapter;
    private List<qyListInfo.DataBean.ContentBean> beanList;

    private int pageNum = 1;
    private boolean canPull = true;

    @Override
    protected int setLayout() {
        return R.layout.tsncp_fregment;
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
//                getData(pageNum);

            }
        });
        beanList = new ArrayList<>();

        for(int i = 0;i< 5;i++){
            beanList.add(new qyListInfo.DataBean.ContentBean());
        }

        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerView.setAdapter(detailAdapter = new zxwjAdapter(beanList, mContext));
        detailAdapter.setPreLoadNumber(1);
        detailAdapter.setLoadMoreView(new CustomLoadMoreView());
        detailAdapter.setEnableLoadMore(true);
        detailAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        detailAdapter.setOnItemClickListener(this);
        detailAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                Log.e("TAG","点击重新加载数据");
//                getData(pageNum);
            }
        }, mRecyclerView);

        showSuccess();

    }

    //错误页面的点击回调，重新加载数据
    @Override
    public void onRetry() {
//        getData(pageNum);
    }

    @Override
    protected void setData() {
//        getData(pageNum);
    }


//    //获取网络数据
//    private void getData(final int num) {
//
//        JSONObject jsonObject = new JSONObject();
//
//        try {
//
//            jsonObject.put("page", num+"");
//            jsonObject.put("size", "20");
//
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//
//        mMyOkhttp.post()
//                .url(ApiConstants.dylistApi)
//                .jsonParams(jsonObject.toString())
//                .enqueue(new GsonResponseHandler<qyListInfo>() {
//                    @Override
//                    public void onFailure(int statusCode, String error_msg) {
//
//                        Toast.makeText(mContext, error_msg, Toast.LENGTH_SHORT).show();
//
//                        if(num > 1){
//                            loadMoreData(null,true);
//                        }else{
//                            loadData(null,true);
//
//                        }
//                    }
//
//                    @Override
//                    public void onSuccess(int statusCode, qyListInfo response) {
////                        Toast.makeText(mContext, response.getMessage(), Toast.LENGTH_SHORT).show();
//
//                        if(response.getErrorCode().equals("0")){
//
//                            if(num > 1){//上拉加载
//                                loadMoreData(response,false);
//                            }else{//下拉刷新
//                                loadData(response.getData().getContent(),false);
//                            }
//
//                        }
//
//
//
//                    }
//                });
//
//    }
//
//    //上拉加载更多数据
//    private void loadMoreData(qyListInfo response,boolean isError) {
//        Log.e("TAG","loadMoreData");
//        if (response == null) {
//            Log.e("TAG","response == null:");
//            if(isError){
//                detailAdapter.loadMoreFail();
//                Toast.makeText(mContext, getResources().getString(R.string.data_failed), Toast.LENGTH_SHORT).show();
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
//
//    //下拉刷新
//    private void loadData(List<qyListInfo.DataBean.ContentBean> response,boolean isError) {
//
//        if (response == null  || response.size() <= 0) {
//            if(mPtrFrameLayout != null){
//                mPtrFrameLayout.refreshComplete();
//            }
//            if(isError){
////                Toast.makeText(flfgListActivity.this, getResources().getString(R.string.data_failed), Toast.LENGTH_SHORT).show();
//                showFaild();
//            }else{
//                showEmptyView();
//            }
//            canPull = false;
//
//        } else {
//
//            canPull = true;
//            pageNum++;
//            detailAdapter.setNewData(response);
//            if(mPtrFrameLayout != null){
//                mPtrFrameLayout.refreshComplete();
//            }
//            showSuccess();
//            disableLoadMoreIfNotFullPage(mRecyclerView,response.size());
//        }
//    }
//
//
//    public void disableLoadMoreIfNotFullPage(RecyclerView recyclerView, final int size) {
//        detailAdapter.setEnableLoadMore(false);
//        if (recyclerView == null) return;
//        RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();
//        if (manager == null) return;
//        if (manager instanceof LinearLayoutManager) {
//            final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) manager;
//
//                recyclerView.postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//
//                        //要等到列表显示出来才可以去获取：findLastCompletelyVisibleItemPosition
//                        if ((linearLayoutManager.findLastCompletelyVisibleItemPosition() + 1) != size) {
//                            detailAdapter.setEnableLoadMore(true);
//                        }
//
//                        Log.e("TAG","测试："+(linearLayoutManager.findLastCompletelyVisibleItemPosition() + 1));
//                    }
//                }, 1000);
//
//
//
//        }
//    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

    }
}
