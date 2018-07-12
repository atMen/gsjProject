package customer.tcrj.com.zsproject.bean;

import java.util.List;

/**
 * Created by leict on 2018/7/12.
 */

public class bankInfo
{

    /**
     * errorCode : SUCCESS
     * data : [{"address":"西安市高新区","departmentId":"5850e3a801f041ea994ef5b517516659","description":"","id":"ff8080816488b31c01648c1162a10018","logo":"/uploadfile//2018-07-12/20180712091824503.jpg","logoName":"1531358426(1).jpg","name":"中国银行","note":"","optime":{"date":12,"day":4,"hours":9,"minutes":18,"month":6,"nanos":972000000,"seconds":26,"time":1531358306972,"timezoneOffset":-480,"year":118},"userId":"ff80808164881cef01648866864f018b"},{"address":"西安市高新区","departmentId":"5850e3a801f041ea994ef5b517516659","description":"","id":"ff8080816488b31c01648c112c300016","logo":"/uploadfile//2018-07-12/20180712091810714.jpg","logoName":"1531358394(1).jpg","name":"西安银行","note":"","optime":{"date":12,"day":4,"hours":9,"minutes":18,"month":6,"nanos":36000000,"seconds":13,"time":1531358293036,"timezoneOffset":-480,"year":118},"userId":"ff80808164881cef01648866864f018b"},{"address":"西安市高新区","departmentId":"5850e3a801f041ea994ef5b517516659","description":"","id":"ff8080816488b31c01648c1102d60014","logo":"/uploadfile//2018-07-12/20180712091751552.jpg","logoName":"logo.jpg","name":"长安银行","note":"","optime":{"date":12,"day":4,"hours":9,"minutes":18,"month":6,"nanos":376000000,"seconds":2,"time":1531358282376,"timezoneOffset":-480,"year":118},"userId":"ff80808164881cef01648866864f018b"}]
     */

    private String errorCode;
    private List<DataBean> data;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * address : 西安市高新区
         * departmentId : 5850e3a801f041ea994ef5b517516659
         * description :
         * id : ff8080816488b31c01648c1162a10018
         * logo : /uploadfile//2018-07-12/20180712091824503.jpg
         * logoName : 1531358426(1).jpg
         * name : 中国银行
         * note :
         * optime : {"date":12,"day":4,"hours":9,"minutes":18,"month":6,"nanos":972000000,"seconds":26,"time":1531358306972,"timezoneOffset":-480,"year":118}
         * userId : ff80808164881cef01648866864f018b
         */

        private String address;
        private String departmentId;
        private String description;
        private String id;
        private String logo;
        private String logoName;
        private String name;
        private String note;
        private OptimeBean optime;
        private String userId;

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getDepartmentId() {
            return departmentId;
        }

        public void setDepartmentId(String departmentId) {
            this.departmentId = departmentId;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public String getLogoName() {
            return logoName;
        }

        public void setLogoName(String logoName) {
            this.logoName = logoName;
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

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public static class OptimeBean {
            /**
             * date : 12
             * day : 4
             * hours : 9
             * minutes : 18
             * month : 6
             * nanos : 972000000
             * seconds : 26
             * time : 1531358306972
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
