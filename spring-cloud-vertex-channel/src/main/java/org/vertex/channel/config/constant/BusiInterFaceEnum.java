package org.vertex.channel.config.constant;

/**
 * Description:
 * author: yu.hb
 * Date: 2019-03-05
 */
public enum BusiInterFaceEnum {

    XXX_KEY("1001","loanCreditApplyConver","POST",true),

    ;


    public final String serviceId; //接口id
    public final String msgConverBean; // 接口请求数据转化处理类
    public final String reqMethod; // 接口请求方式
    public final boolean isApproval;

    BusiInterFaceEnum(String serviceId, String msgConverBean,String reqMethod, boolean isApproval) {
        this.serviceId = serviceId;
        this.msgConverBean = msgConverBean;
        this.reqMethod = reqMethod;
        this.isApproval = isApproval;
    }

    public static String getMsgConverBean(String serviceId) {
        BusiInterFaceEnum[] values = BusiInterFaceEnum.values();
        for(BusiInterFaceEnum value : values) {
            if (value.serviceId.equals(serviceId)) {
                return value.msgConverBean;
            }
        }
        return null;
    }

    public static String getReqMethod(String serviceId) {
        BusiInterFaceEnum[] values = BusiInterFaceEnum.values();
        for(BusiInterFaceEnum value : values) {
            if (value.serviceId.equals(serviceId)) {
                return value.reqMethod;
            }
        }
        return null;
    }

    public static boolean isApproval(String serviceId) {
        BusiInterFaceEnum[] values = BusiInterFaceEnum.values();
        for(BusiInterFaceEnum value : values) {
            if (value.serviceId.equals(serviceId)) {
                return value.isApproval;
            }
        }
        return false;
    }
}
