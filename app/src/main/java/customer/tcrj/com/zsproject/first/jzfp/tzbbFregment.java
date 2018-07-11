package customer.tcrj.com.zsproject.first.jzfp;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.tsy.sdk.myokhttp.MyOkHttp;
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
import customer.tcrj.com.zsproject.adapter.zcgsAdapter;
import customer.tcrj.com.zsproject.base.BaseFragment;
import customer.tcrj.com.zsproject.bean.zcgsInfo;
import customer.tcrj.com.zsproject.first.fwzx.fwzx2Activity;
import customer.tcrj.com.zsproject.first.fwzx.jzfptzInfoActivity;
import customer.tcrj.com.zsproject.widget.BottomStyleDialog;
import customer.tcrj.com.zsproject.widget.MyGridView;

/**
 * Created by leict on 2018/7/4.
 */

public class tzbbFregment extends BaseFragment implements AdapterView.OnItemClickListener, BottomStyleDialog.OnItemClickListener {

    @BindView(R.id.grid_sign)
    public MyGridView myGridView;
    @BindView(R.id.layout_work_naturejob)
    LinearLayout layout_work_naturejob;
    @BindView(R.id.layout_qx)
    LinearLayout layout_qx;
    @BindView(R.id.tv_work_naturejob)
    TextView tv_work_naturejob;
    @BindView(R.id.tv_pp)
    TextView tv_pp;
    @BindView(R.id.ck_qx)
    TextView ck_qx;
    @BindView(R.id.sj)
    TextView sj;

    zcgsAdapter adapter1;

    List<zcgsInfo> zcgsInfo;

    private String sjname = null;

    private MyOkHttp mMyOkhttp;

    @Override
    protected int setLayout() {
        return R.layout.tzbb_fragment;
    }

    @Override
    protected void setView() {
        mMyOkhttp = MyApp.getInstance().getMyOkHttp();
    }

    @Override
    protected void setData() {
        getGirdData("");
        adapter1 = new zcgsAdapter(mContext);
        myGridView.setOnItemClickListener(this);


    }
    private void getGirdData(String code) {
//        String cityJson = Utils.getJson(this, Constant.CITY_DATA);
//
//        zcgsInfo zcgsInfo = new Gson().fromJson(cityJson, zcgsInfo.class);
//        adapter1.setData(zcgsInfo.getListinfo());
//        myGridView.setAdapter(adapter1);


        JSONObject jsonObject = new JSONObject();

        try {
            jsonObject.put("parentId", code);



        } catch (JSONException e) {
            e.printStackTrace();
        }

        mMyOkhttp.post()
                .url(ApiConstants.zcgs_listApi)
                .jsonParams(jsonObject.toString())
                .enqueue(new JsonResponseHandler() {
                    @Override
                    public void onFailure(int statusCode, String error_msg) {



                    }

                    @Override
                    public void onSuccess(int statusCode, JSONArray response) {
                        Log.e("TAG","JSONArray"+response.toString());



                        zcgsInfo = parseNoHeaderJArray(response.toString());
                        if(isdialog){
                            showDialog();
                        }else {

                            adapter1.setData(zcgsInfo);
                            myGridView.setAdapter(adapter1);
                        }



                    }
                });
    }

    private void showDialog() {
        dialog = new BottomStyleDialog(mContext,zcgsInfo);
        dialog.setOnItemClickListener(this);
        dialog.show();
    }

//    private void getGirdData(String s) {
//        String cityJson = Utils.getJson(mContext, s);
//
//        zcgsInfo = new Gson().fromJson(cityJson, zcgsInfo.class);
//    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
    BottomStyleDialog dialog;
    private boolean isqx = false;
    private boolean isdialog = false;
    private String cityCode = null;
    private String cityCode1 = null;

    @OnClick({R.id.layout_work_naturejob,R.id.layout_qx,R.id.ck_qx,R.id.sj})
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.layout_work_naturejob:
                cityCode = null;
                isqx = true;
                isdialog = true;
                getGirdData("");

                break;

            case R.id.layout_qx:

                if(sjname != null){
                    isqx = false;
                    isdialog = true;
                    getGirdData(cityCode1);

                }else {
                    T("请选择市级");
                }

                break;
//
            case R.id.ck_qx:

                if(cityCode != null){
//                    toClass(mContext,jzfpqxtzInfoActivity.class);
                }else {
                    T("请选择区县");
                }
                break;

            case R.id.sj:
                //审批结果查询
                toClass(mContext,jzfptzInfoActivity.class);
                break;

            default:

        }
    }

    @Override
    public void onItemClick(zcgsInfo listinfoBean) {
        if(dialog != null && dialog.isShowing()){
            dialog.dismiss();
        }

        if(isqx){
            sjname = listinfoBean.getName();
            cityCode1 = listinfoBean.getId();
            tv_work_naturejob.setText(listinfoBean.getName());
            tv_pp.setText("请选择区县");
        }else {
            cityCode = listinfoBean.getId();
            tv_pp.setText(listinfoBean.getName());
        }


    }



    private List<zcgsInfo> parseNoHeaderJArray(String strByJson) {

        //Json的解析类对象
        JsonParser parser = new JsonParser();
        //将JSON的String 转成一个JsonArray对象
        JsonArray jsonArray = parser.parse(strByJson).getAsJsonArray();

        Gson gson = new Gson();
        List<zcgsInfo> userBeanList = new ArrayList<>();

        //加强for循环遍历JsonArray
        for (JsonElement user : jsonArray) {
            //使用GSON，直接转成Bean对象
            zcgsInfo userBean = gson.fromJson(user, zcgsInfo.class);
            userBeanList.add(userBean);
        }
        return userBeanList;
    }
}
