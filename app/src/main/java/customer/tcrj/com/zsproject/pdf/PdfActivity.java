package customer.tcrj.com.zsproject.pdf;

import android.Manifest;
import android.app.Dialog;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnErrorListener;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;
import com.github.barteksc.pdfviewer.util.FitPolicy;
import com.jaeger.library.StatusBarUtil;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.FileCallback;
import com.lzy.okgo.model.Progress;
import com.lzy.okgo.model.Response;

import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

import customer.tcrj.com.zsproject.ApiConstants;
import customer.tcrj.com.zsproject.R;


public class PdfActivity extends AppCompatActivity implements View.OnClickListener {

    private PDFView pdfView;
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private TextView pageTv, pageTv1,txtTitle,tv_onemore;
    private ImageView btnback;
    private LinearLayout ll_pdf;
    private int p;



    boolean isError = true;

    private void downloadFile(String url) {
        showLoadingDialog("正在加载");
        File file = new File(url);
        String fileName = file.getName();
        String localFileName = getCacheDir().getAbsolutePath() + fileName;
        File localFile = new File(localFileName);
        if (localFile.exists() && isError) {
            Log.e("TAG","isError "+isError);
            openFile(localFile);
            return;
        }
        OkGo.<File>get(url).tag(this).execute(new FileCallback(getCacheDir().getAbsolutePath(), fileName) {
            @Override
            public void onSuccess(Response<File> response) {
                hideLoadingDialog();
                Log.e("TAG", "onSuccess: 下载成功"+response.body().getAbsolutePath());
                if (response.body().exists()) {
                    openFile(response.body());
                }
            }

            @Override
            public void onError(Response<File> response) {
                hideLoadingDialog();
                Log.e("TAG", "onError:downloadProgress ---" + response.getException().getMessage());
                Log.e("TAG", "onError: 下载失败");
                isError = false;
                tv_onemore.setVisibility(View.VISIBLE);
                ll_pdf.setVisibility(View.GONE);
            }

            @Override
            public void downloadProgress(Progress progress) {
                Log.e("TAG", "onError:downloadProgress ---" + progress.currentSize);
            }
        });
    }

    private void openFile(File absolutePath) {

        Log.e("TAG","openFile"+absolutePath);

        pdfView.fromFile(absolutePath)
                .enableAnnotationRendering(true)
                .scrollHandle(new DefaultScrollHandle(this))
                .spacing(10) // in dp
                .pageFitPolicy(FitPolicy.BOTH)
                .onError(new OnErrorListener() {
                    @Override
                    public void onError(Throwable t) {
                        Log.e("TAG","加载错误");
                        isError = false;
                        tv_onemore.setVisibility(View.VISIBLE);
                        ll_pdf.setVisibility(View.GONE);

                    }
                })

                .load();


    }
    private String file;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        StatusBarUtil.setTranslucentForImageViewInFragment(this, 5,null);


        //获取动态权限
        getPermission();
        pdfView = (PDFView) findViewById(R.id.pdfView);
        pageTv = (TextView) findViewById(R.id.pageTv);
        pageTv1 = (TextView) findViewById(R.id.pageTv1);
        txtTitle = (TextView) findViewById(R.id.txtTitle);
        btnback = (ImageView) findViewById(R.id.btnback);
        tv_onemore = (TextView) findViewById(R.id.tv_onemore);
        ll_pdf = (LinearLayout) findViewById(R.id.ll_pdf);

        txtTitle.setText("资料详情");
        btnback.setOnClickListener(this);
        tv_onemore.setOnClickListener(this);
        file = getIntent().getStringExtra("cover");
        Log.e("TAG","cover:"+file);
        downloadFile(file);

    }

    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };


    private void getPermission() {
        int hasWriteContactsPermission = ContextCompat.checkSelfPermission(PdfActivity.this,
                Manifest.permission.READ_EXTERNAL_STORAGE);
        if (hasWriteContactsPermission != PackageManager.PERMISSION_GRANTED) {
            if (!ActivityCompat.shouldShowRequestPermissionRationale(PdfActivity.this,
                    Manifest.permission.READ_EXTERNAL_STORAGE)) {
                ActivityCompat.requestPermissions(PdfActivity.this,
                        PERMISSIONS_STORAGE, REQUEST_EXTERNAL_STORAGE);
            }

            ActivityCompat.requestPermissions(PdfActivity.this,
                    PERMISSIONS_STORAGE, REQUEST_EXTERNAL_STORAGE);
        }

        while ((ContextCompat.checkSelfPermission(PdfActivity.this,
                Manifest.permission.READ_EXTERNAL_STORAGE)) != PackageManager.PERMISSION_GRANTED) {
        }
    }

    protected Dialog mLoadingDialog = null;
    protected void showLoadingDialog(String str) {
        if (mLoadingDialog != null) {
            TextView tv = (TextView) mLoadingDialog.findViewById(R.id.tv_load_dialog);
            tv.setText(str);
            mLoadingDialog.show();
        }
    }

    protected void hideLoadingDialog() {
        if (mLoadingDialog != null && mLoadingDialog.isShowing()) {
            mLoadingDialog.dismiss();
        }
    }




    private int number = -1;
    Timer timer;
    TimerTask timerTask;

    Handler handlerTime = new Handler() {
        public void handleMessage(Message msg) {

            number++;
//            num.setText(number+"");

        }
    };


    private Handler handlerStopTime = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    stopTime();
                    break;
                case 1:
                    startTime();
                    break;
                default:
                    break;
            }
            super.handleMessage(msg);
        }
    };

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        Message msg = new Message();
        msg.what = 0;
        handlerStopTime.sendMessage(msg);
        super.onPause();
    }

    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        Message msg = new Message();
        msg.what = 1;
        handlerStopTime.sendMessage(msg);
        super.onResume();
    }

    private void startTime() {
        if (timer == null) {
            timer = new Timer();
        }
        if (timerTask == null) {
            timerTask = new TimerTask() {

                @Override
                public void run() {
                    Message msg = new Message();
                    msg.what = 0;
                    handlerTime.sendMessage(msg);
                }
            };
        }
        if (timer != null && timerTask != null) {
            timer.schedule(timerTask, 0, 1000);
        }
    }

    private void stopTime(){
        if(timer!=null){
            timer.cancel();
            timer=null;
        }
        if(timerTask!=null){
            timerTask.cancel();
            timerTask=null;
        }
    }




    @Override
    protected void onDestroy() {
        super.onDestroy();
        //当activity销毁的时候，保存当前的页数，下次打开的时候，直接翻到这个页
//        SPUtils.put(MainActivity.this, "page", p);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.btnback:
                finish();
                break;
            case R.id.tv_onemore:
                tv_onemore.setVisibility(View.GONE);
                ll_pdf.setVisibility(View.VISIBLE);
                if(file != null){
                    Log.e("TAG","onemore file:"+file);
                    downloadFile(ApiConstants.BASEIMAGE+file);
                }

                break;
        }

    }


}
