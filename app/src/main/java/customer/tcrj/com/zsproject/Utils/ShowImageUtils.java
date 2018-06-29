package customer.tcrj.com.zsproject.Utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;



import customer.tcrj.com.zsproject.R;

/**
 * Created by leict on 2018/6/20.
 */

public class ShowImageUtils {

    /**
     * (1)
     * 显示图片Imageview
     *
     * @param context  上下文
     * @param url      图片链接
     * @param imgeview 组件
     */
    public static void showImageView(Context context, String url,
                                     ImageView imgeview) {

        Glide.with(context)
                .load(url)
                .placeholder(R.drawable.ic_zwt)
                .error(R.drawable.ic_zwt)

                .into(imgeview);


    }

}
