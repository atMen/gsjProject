package customer.tcrj.com.zsproject.bean;

import java.util.List;

/**
 * Created by leict on 2018/7/5.
 */

public class flInfo {

    /**
     * errorCode : SUCCESS
     * data : [{"lawyerHouseId":"402894b364346ef10164347159460003","lawyerHouseName":"绿地律师所","lawyers":[{"bz":"阿萨德","departmentId":"","email":"tison100@163.com","id":"402894b364346ef10164347274fc0006","joinJobTime":"2018-06-18","lawyerHouseId":"402894b364346ef10164347159460003","lawyerHouseName":"绿地律师所","lxdh":"18191550855","name":"高春虎","optime":{"date":5,"day":4,"hours":14,"minutes":18,"month":6,"seconds":30,"time":1530771510546,"timezoneOffset":-480,"year":118},"photo":"/web.files/uploadfile//2018-06-28/20180628033009575.jpg","scly":"阿萨德阿萨德阿萨德","sex":"1","status":"1","userId":"1","zgzsbh":"3234567890123456789","zmal":"具体刑事辩护业务如下：\n\n（一） 在侦查阶段为犯罪嫌疑人提供法律帮助\n\n1、 会见犯罪嫌疑人；\n\n2、 了解涉嫌罪名和有关案件的情况；\n\n3、 为犯罪嫌疑人提供法律咨询；\n\n4、 为犯罪嫌疑人申请取保候审；\n\n5、 代理申诉和控告。\n\n（二） 在审查起诉阶段担任辩护人和诉讼代理人\n\n1、 查阅、摘抄、复制案件有关材料；\n\n2、 与犯罪嫌疑人会见和通信；\n\n3、 调查和收集案件的有关证件；\n\n4、 提出辩护意见、代理意见或申诉意见；\n\n5、 向人民检察院反映意见。"}]}]
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
         * lawyerHouseId : 402894b364346ef10164347159460003
         * lawyerHouseName : 绿地律师所
         * lawyers : [{"bz":"阿萨德","departmentId":"","email":"tison100@163.com","id":"402894b364346ef10164347274fc0006","joinJobTime":"2018-06-18","lawyerHouseId":"402894b364346ef10164347159460003","lawyerHouseName":"绿地律师所","lxdh":"18191550855","name":"高春虎","optime":{"date":5,"day":4,"hours":14,"minutes":18,"month":6,"seconds":30,"time":1530771510546,"timezoneOffset":-480,"year":118},"photo":"/web.files/uploadfile//2018-06-28/20180628033009575.jpg","scly":"阿萨德阿萨德阿萨德","sex":"1","status":"1","userId":"1","zgzsbh":"3234567890123456789","zmal":"具体刑事辩护业务如下：\n\n（一） 在侦查阶段为犯罪嫌疑人提供法律帮助\n\n1、 会见犯罪嫌疑人；\n\n2、 了解涉嫌罪名和有关案件的情况；\n\n3、 为犯罪嫌疑人提供法律咨询；\n\n4、 为犯罪嫌疑人申请取保候审；\n\n5、 代理申诉和控告。\n\n（二） 在审查起诉阶段担任辩护人和诉讼代理人\n\n1、 查阅、摘抄、复制案件有关材料；\n\n2、 与犯罪嫌疑人会见和通信；\n\n3、 调查和收集案件的有关证件；\n\n4、 提出辩护意见、代理意见或申诉意见；\n\n5、 向人民检察院反映意见。"}]
         */

        private String lawyerHouseId;
        private String lawyerHouseName;
        private List<LawyersBean> lawyers;

        public String getLawyerHouseId() {
            return lawyerHouseId;
        }

        public void setLawyerHouseId(String lawyerHouseId) {
            this.lawyerHouseId = lawyerHouseId;
        }

        public String getLawyerHouseName() {
            return lawyerHouseName;
        }

        public void setLawyerHouseName(String lawyerHouseName) {
            this.lawyerHouseName = lawyerHouseName;
        }

        public List<LawyersBean> getLawyers() {
            return lawyers;
        }

        public void setLawyers(List<LawyersBean> lawyers) {
            this.lawyers = lawyers;
        }

        public static class LawyersBean {
            /**
             * bz : 阿萨德
             * departmentId :
             * email : tison100@163.com
             * id : 402894b364346ef10164347274fc0006
             * joinJobTime : 2018-06-18
             * lawyerHouseId : 402894b364346ef10164347159460003
             * lawyerHouseName : 绿地律师所
             * lxdh : 18191550855
             * name : 高春虎
             * optime : {"date":5,"day":4,"hours":14,"minutes":18,"month":6,"seconds":30,"time":1530771510546,"timezoneOffset":-480,"year":118}
             * photo : /web.files/uploadfile//2018-06-28/20180628033009575.jpg
             * scly : 阿萨德阿萨德阿萨德
             * sex : 1
             * status : 1
             * userId : 1
             * zgzsbh : 3234567890123456789
             * zmal : 具体刑事辩护业务如下：

             （一） 在侦查阶段为犯罪嫌疑人提供法律帮助

             1、 会见犯罪嫌疑人；

             2、 了解涉嫌罪名和有关案件的情况；

             3、 为犯罪嫌疑人提供法律咨询；

             4、 为犯罪嫌疑人申请取保候审；

             5、 代理申诉和控告。

             （二） 在审查起诉阶段担任辩护人和诉讼代理人

             1、 查阅、摘抄、复制案件有关材料；

             2、 与犯罪嫌疑人会见和通信；

             3、 调查和收集案件的有关证件；

             4、 提出辩护意见、代理意见或申诉意见；

             5、 向人民检察院反映意见。
             */

            private String bz;
            private String departmentId;
            private String email;
            private String id;
            private String joinJobTime;
            private String lawyerHouseId;
            private String lawyerHouseName;
            private String lxdh;
            private String name;
            private OptimeBean optime;
            private String photo;
            private String scly;
            private String sex;
            private String status;
            private String userId;
            private String zgzsbh;
            private String zmal;

            public String getBz() {
                return bz;
            }

            public void setBz(String bz) {
                this.bz = bz;
            }

            public String getDepartmentId() {
                return departmentId;
            }

            public void setDepartmentId(String departmentId) {
                this.departmentId = departmentId;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getJoinJobTime() {
                return joinJobTime;
            }

            public void setJoinJobTime(String joinJobTime) {
                this.joinJobTime = joinJobTime;
            }

            public String getLawyerHouseId() {
                return lawyerHouseId;
            }

            public void setLawyerHouseId(String lawyerHouseId) {
                this.lawyerHouseId = lawyerHouseId;
            }

            public String getLawyerHouseName() {
                return lawyerHouseName;
            }

            public void setLawyerHouseName(String lawyerHouseName) {
                this.lawyerHouseName = lawyerHouseName;
            }

            public String getLxdh() {
                return lxdh;
            }

            public void setLxdh(String lxdh) {
                this.lxdh = lxdh;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public OptimeBean getOptime() {
                return optime;
            }

            public void setOptime(OptimeBean optime) {
                this.optime = optime;
            }

            public String getPhoto() {
                return photo;
            }

            public void setPhoto(String photo) {
                this.photo = photo;
            }

            public String getScly() {
                return scly;
            }

            public void setScly(String scly) {
                this.scly = scly;
            }

            public String getSex() {
                return sex;
            }

            public void setSex(String sex) {
                this.sex = sex;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getUserId() {
                return userId;
            }

            public void setUserId(String userId) {
                this.userId = userId;
            }

            public String getZgzsbh() {
                return zgzsbh;
            }

            public void setZgzsbh(String zgzsbh) {
                this.zgzsbh = zgzsbh;
            }

            public String getZmal() {
                return zmal;
            }

            public void setZmal(String zmal) {
                this.zmal = zmal;
            }

            public static class OptimeBean {
                /**
                 * date : 5
                 * day : 4
                 * hours : 14
                 * minutes : 18
                 * month : 6
                 * seconds : 30
                 * time : 1530771510546
                 * timezoneOffset : -480
                 * year : 118
                 */

                private int date;
                private int day;
                private int hours;
                private int minutes;
                private int month;
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
}
