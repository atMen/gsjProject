package customer.tcrj.com.zsproject.base;

import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.tsy.sdk.myokhttp.MyOkHttp;
import com.tsy.sdk.myokhttp.response.GsonResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import butterknife.BindView;
import butterknife.OnClick;
import customer.tcrj.com.zsproject.ApiConstants;
import customer.tcrj.com.zsproject.MyApp;
import customer.tcrj.com.zsproject.R;
import customer.tcrj.com.zsproject.bean.newInfo;


public class NewsinfoActivity extends BaseActivity {


    @BindView(R.id.webView)
    WebView mWebView;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.txtTitle)
    TextView txtTitle;
    @BindView(R.id.sub_title)
    TextView sub_title;
    @BindView(R.id.date)
    TextView date;
    @BindView(R.id.source)
    TextView source;
    @BindView(R.id.number)
    TextView number;
    @BindView(R.id.btnback)
    ImageView btnback;

    private String contentUrl;
    private MyOkHttp mMyOkhttp;
    @Override
    protected int setLayout() {
        return R.layout.activity_newsinfo;
    }

    @Override
    protected void setView() {
        mMyOkhttp = MyApp.getInstance().getMyOkHttp();
        contentUrl = getIntent().getStringExtra("contentUrl");
        txtTitle.setText("新闻详情页");

        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
    }

    @Override
    protected void setData() {

        getDataFromNet();
//      mWebView.loadData(contentUrl, "text/html; charset=UTF-8",null);

    }

    private void getDataFromNet() {
        showLoadingDialog("正在加载...");
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("id", contentUrl);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        mMyOkhttp.post()
                .url(ApiConstants.xwdt_xq_listApi)
                .jsonParams(jsonObject.toString())
                .enqueue(new GsonResponseHandler<newInfo>() {
                    @Override
                    public void onFailure(int statusCode, String error_msg) {
                        hideLoadingDialog();
                        Toast.makeText(NewsinfoActivity.this, error_msg, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onSuccess(int statusCode, newInfo response) {
                        hideLoadingDialog();
                        if(response.getState() == 1){
                            initview(response.getEntity());
                            String newContent = getNewContent(response.getEntity().getInfoContent());

                            mWebView.loadData(newContent, "text/html; charset=UTF-8", null);
                        }
                    }
                });

    }

    public static String getNewContent(String htmltext){
        try {
            Document doc= Jsoup.parse(htmltext);
            Elements elements=doc.getElementsByTag("img");
            for (Element element : elements) {
                element.attr("width","100%").attr("height","auto");
            }

            return doc.toString();
        } catch (Exception e) {
            return htmltext;
        }
    }


    private void initview(newInfo.EntityBean response) {
        title.setText(response.getTitle());
        sub_title.setText(response.getFtitle());
        date.setText(response.getShowTime());
        source.setText("来源："+response.getSource());
    }

    /**
     * 拦截返回键
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // 是否触发按键为back键
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            back();
            return true;
            // 如果不是back键正常响应
        } else {
            return super.onKeyDown(keyCode, event);
        }
    }

    private void back() {
        if (mWebView.canGoBack()) {
            mWebView.goBack();
        } else {
            finish();
        }
    }

    @OnClick({R.id.btnback})
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnback:

                finish();
                break;
            default:
                break;

        }
    }


}
