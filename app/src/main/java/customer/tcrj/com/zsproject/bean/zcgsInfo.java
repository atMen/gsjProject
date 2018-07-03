package customer.tcrj.com.zsproject.bean;

import java.util.List;

/**
 * Created by leict on 2018/7/3.
 */

public class zcgsInfo {


    private List<ListinfoBean> Listinfo;

    public List<ListinfoBean> getListinfo() {
        return Listinfo;
    }

    public void setListinfo(List<ListinfoBean> Listinfo) {
        this.Listinfo = Listinfo;
    }

    public static class ListinfoBean {
        /**
         * address :
         * adminId : ,402894b363f80f6b0163f862f7ab0078,,402894b363f80f6b0163f87aeb6c007b,,402894b363f80f6b0163f87b5375007d,
         * adminIdName :
         * code : 610112
         * deleted : 0
         * deptManager :
         * deptManagerName :
         * id : aab2c7e4927e48bb90c4602bd5cd2f71
         * isParent : true
         * name : 未央区
         * note :
         * optime : {"date":13,"day":3,"hours":16,"minutes":32,"month":5,"nanos":881000000,"seconds":32,"time":1528878752881,"timezoneOffset":-480,"year":118}
         * parentId : ebeac7f05c334cd6bb365545018bdad9
         * path : #1#b88dc1f20e27423984559a3ee15877da#ebeac7f05c334cd6bb365545018bdad9#aab2c7e4927e48bb90c4602bd5cd2f71#
         * sort : 1
         */

        private String address;
        private String adminId;
        private String adminIdName;
        private String code;
        private String deleted;
        private String deptManager;
        private String deptManagerName;
        private String id;
        private boolean isParent;
        private String name;
        private String note;
        private OptimeBean optime;
        private String parentId;
        private String path;
        private int sort;

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getAdminId() {
            return adminId;
        }

        public void setAdminId(String adminId) {
            this.adminId = adminId;
        }

        public String getAdminIdName() {
            return adminIdName;
        }

        public void setAdminIdName(String adminIdName) {
            this.adminIdName = adminIdName;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getDeleted() {
            return deleted;
        }

        public void setDeleted(String deleted) {
            this.deleted = deleted;
        }

        public String getDeptManager() {
            return deptManager;
        }

        public void setDeptManager(String deptManager) {
            this.deptManager = deptManager;
        }

        public String getDeptManagerName() {
            return deptManagerName;
        }

        public void setDeptManagerName(String deptManagerName) {
            this.deptManagerName = deptManagerName;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public boolean isIsParent() {
            return isParent;
        }

        public void setIsParent(boolean isParent) {
            this.isParent = isParent;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getNote() {
            return note;
        }

        public void setNote(String note) {
            this.note = note;
        }

        public OptimeBean getOptime() {
            return optime;
        }

        public void setOptime(OptimeBean optime) {
            this.optime = optime;
        }

        public String getParentId() {
            return parentId;
        }

        public void setParentId(String parentId) {
            this.parentId = parentId;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

        public static class OptimeBean {
            /**
             * date : 13
             * day : 3
             * hours : 16
             * minutes : 32
             * month : 5
             * nanos : 881000000
             * seconds : 32
             * time : 1528878752881
             * timezoneOffset : -480
             * year : 118
             */

            private int date;
            private int day;
            private int hours;
            private int minutes;
            private int month;
            private int nanos;
            private int seconds;
            private long time;
            private int timezoneOffset;
            private int year;

            public int getDate() {
                return date;
            }

            public void setDate(int date) {
                this.date = date;
            }

            public int getDay() {
                return day;
            }

            public void setDay(int day) {
                this.day = day;
            }

            public int getHours() {
                return hours;
            }

            public void setHours(int hours) {
                this.hours = hours;
            }

            public int getMinutes() {
                return minutes;
            }

            public void setMinutes(int minutes) {
                this.minutes = minutes;
            }

            public int getMonth() {
                return month;
            }

            public void setMonth(int month) {
                this.month = month;
            }

            public int getNanos() {
                return nanos;
            }

            public void setNanos(int nanos) {
                this.nanos = nanos;
            }

            public int getSeconds() {
                return seconds;
            }

            public void setSeconds(int seconds) {
                this.seconds = seconds;
            }

            public long getTime() {
                return time;
            }

            public void setTime(long time) {
                this.time = time;
            }

            public int getTimezoneOffset() {
                return timezoneOffset;
            }

            public void setTimezoneOffset(int timezoneOffset) {
                this.timezoneOffset = timezoneOffset;
            }

            public int getYear() {
                return year;
            }

            public void setYear(int year) {
                this.year = year;
            }
        }
    }
}
