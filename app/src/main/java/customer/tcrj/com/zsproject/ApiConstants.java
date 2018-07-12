package customer.tcrj.com.zsproject;

/**
 * desc:
 * author: Will .
 * date: 2017/9/2 .
 */
public class ApiConstants {


  public static final String siteId = "nEFVji";

  public static final String TPXW = "YnEFZv";
  public static final String YWDT = "qQZbUf";
  public static final String ZXWJ1 = "iuy63u";
  public static final String ZXWJ2 = "63YfUj";
  public static final String TZGG = "NzqQNn";
  public static final String LDJH = "na6jAv";
  public static final String ZYHD = "a6r2Ez";
  public static final String MTGZ = "BZjmqi";


//http://192.168.20.240:8181/
public static final String URLBASE8080 = "http://192.168.20.240:8080/";
  public static final String URLBASE = "http://192.168.20.240:8181/";
  public static final String BASEIMAGE = "http://192.168.20.240:8080/web.files";


    /**
     * 新闻动态
     */
    public static final String xwdt_tpxwlistApi = URLBASE+"drosin_cms/baseRest/findInfoList";






  /**
   * 新闻动态
   */
  public static final String xwdt_xq_listApi = URLBASE+"drosin_cms/baseRest/findInfoDetails";


  /**
   * sxipept/courseWare/getCourseWareList
   */
  public static final String fwzx_pxlistApi = URLBASE8080+"sxipept/courseWare/getCourseWareList";


  /**
   * /sxipept/aidpoor/getDeptInfoList
   */
  public static final String zcgs_listApi = URLBASE8080+"sxipept/aidpoor/getDeptInfoList";

  /**
   * 借贷信息
   */
  public static final String fwzx_jr_listApi = URLBASE8080+"sxipept/serviceCentre/getProductList";

  /**
   * 银行信息
   */
  public static final String jr_bank_listApi = URLBASE8080+"sxipept/serviceCentre/getBankList";
  /**
   * 法律服务
   */
  public static final String fwzx_fl_listApi = URLBASE8080+"sxipept/serviceCentre/findLawyerInfo";


  /**
   * 栏目获取
   */
  public static final String zcgs_s_listApi = URLBASE+"drosin_cms/baseRest/findCategoryListByPid";

  /**
   * 栏目获取
   */
  public static final String sjfp_tz_listApi = URLBASE8080+"sxipept/aidpoor/getAidPoorStatisticalList";
}
