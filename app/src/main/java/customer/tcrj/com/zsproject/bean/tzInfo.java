package customer.tcrj.com.zsproject.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by leict on 2018/5/10.
 */

public class tzInfo implements Serializable{

    /**
     * PageIndex : 1
     * PageSize : 2
     * TotalItemCount : 2
     * TotalPageCount : 1
     * Data : [{"ID":1,"Title":"测试","IsRelease":true,"Content":"<p>暗示法法士大夫撒旦法<\/p>","ReleaseDate":"2018-05-10T00:00:00","OrderID":1,"CreateStaffID":1,"CreateTime":"2018-05-10T11:29:30.853","UpdateStaffID":1,"UpdateTime":"2018-05-10T15:08:15.453"},{"ID":2,"Title":"大范围地方","IsRelease":true,"Content":"<p>消息信息<\/p>","ReleaseDate":"2018-05-10T00:00:00","OrderID":0,"CreateStaffID":1,"CreateTime":"2018-05-10T15:09:26.58","UpdateStaffID":null,"UpdateTime":null}]
     */

    private int PageIndex;
    private int PageSize;
    private int TotalItemCount;
    private int TotalPageCount;
    private List<DataBean> Data;

    public int getPageIndex() {
        return PageIndex;
    }

    public void setPageIndex(int PageIndex) {
        this.PageIndex = PageIndex;
    }

    public int getPageSize() {
        return PageSize;
    }

    public void setPageSize(int PageSize) {
        this.PageSize = PageSize;
    }

    public int getTotalItemCount() {
        return TotalItemCount;
    }

    public void setTotalItemCount(int TotalItemCount) {
        this.TotalItemCount = TotalItemCount;
    }

    public int getTotalPageCount() {
        return TotalPageCount;
    }

    public void setTotalPageCount(int TotalPageCount) {
        this.TotalPageCount = TotalPageCount;
    }

    public List<DataBean> getData() {
        return Data;
    }

    public void setData(List<DataBean> Data) {
        this.Data = Data;
    }

    public static class DataBean implements Serializable{
        /**
         * ID : 1
         * Title : 测试
         * IsRelease : true
         * Content : <p>暗示法法士大夫撒旦法</p>
         * ReleaseDate : 2018-05-10T00:00:00
         * OrderID : 1
         * CreateStaffID : 1
         * CreateTime : 2018-05-10T11:29:30.853
         * UpdateStaffID : 1
         * UpdateTime : 2018-05-10T15:08:15.453
         */

        private int ID;
        private String Title;
        private boolean IsRelease;
        private String Content;
        private String ReleaseDate;
        private int OrderID;
        private int CreateStaffID;
        private String CreateTime;
        private int UpdateStaffID;
        private String UpdateTime;

        public int getID() {
            return ID;
        }

        public void setID(int ID) {
            this.ID = ID;
        }

        public String getTitle() {
            return Title;
        }

        public void setTitle(String Title) {
            this.Title = Title;
        }

        public boolean isIsRelease() {
            return IsRelease;
        }

        public void setIsRelease(boolean IsRelease) {
            this.IsRelease = IsRelease;
        }

        public String getContent() {
            return Content;
        }

        public void setContent(String Content) {
            this.Content = Content;
        }

        public String getReleaseDate() {
            return ReleaseDate;
        }

        public void setReleaseDate(String ReleaseDate) {
            this.ReleaseDate = ReleaseDate;
        }

        public int getOrderID() {
            return OrderID;
        }

        public void setOrderID(int OrderID) {
            this.OrderID = OrderID;
        }

        public int getCreateStaffID() {
            return CreateStaffID;
        }

        public void setCreateStaffID(int CreateStaffID) {
            this.CreateStaffID = CreateStaffID;
        }

        public String getCreateTime() {
            return CreateTime;
        }

        public void setCreateTime(String CreateTime) {
            this.CreateTime = CreateTime;
        }

        public int getUpdateStaffID() {
            return UpdateStaffID;
        }

        public void setUpdateStaffID(int UpdateStaffID) {
            this.UpdateStaffID = UpdateStaffID;
        }

        public String getUpdateTime() {
            return UpdateTime;
        }

        public void setUpdateTime(String UpdateTime) {
            this.UpdateTime = UpdateTime;
        }
    }
}
