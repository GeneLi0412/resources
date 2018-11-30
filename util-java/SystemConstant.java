
package com.chngenesis.nebula.util;

import java.math.BigDecimal;

/**
 * 系统常量工具类
 *
 * @author Administrator
 */
public class SystemConstant {

    /**
     * 数据状态：未删除 0
     */
    public static final Integer NOT_DEL = 0;

    /**
     * 数据状态：已删除 1
     */
    public static final Integer DEL = 1;

    /**
     * 无效
     */
    public static final int INVALID = 0;

    /**
     * 有效
     */
    public static final int EFFECTIVE = 1;

    /**
     * 启用
     */
    public static final int START_USE = 1;

    /**
     * 停用
     */
    public static final int STOP_USE = 0;

    /**
     * 分类父级ID（最高级）
     */
    public static final String PARENT_ID = "0";

    /**
     * 低库存预警上浮倍率
     */
    public static final BigDecimal MULTIPLYING_POWER = new BigDecimal(1.1);

    /**
     * 就诊卡
     *
     * @author Administrator
     */
    public static final class patietnCard {
        /**
         * 锁定
         */
        public static final int LOCK = 1;

        /**
         * 未锁定
         */
        public static final int UNLOCKED = 0;

        /**
         * 挂失
         */
        public static final int LOST = -1;
    }

    /**
     * 就诊号状态
     */
    public static final class ClinicStatus {
        /**
         * 0;在诊
         */
        public static final int IN_THE_CLINIC = 0;
        /**
         * 1;诊毕
         */
        public static final int OUT_THE_CLINIC = 1;
        /**
         * 1;回诊
         */
        public static final int RETURN_THE_CLINIC = 2;
        /**
         * -1;作废
         */
        public static final int INVALID = -1;

        /**
         * 就诊方式： 门诊
         */
        public static final String OUTPATIENT_SERVICE = "3abccd3e24e148d6936267b3ccdb3d6f";

        /**
         * 就诊方式：住院
         */
        public static final String IN_HOSPITAL = "53717c579bab49e0b705fa71f4d143b8";
    }

    /**
     * 患者入径状态
     *
     * @author yanghaiyong
     */
    public static final class PatientPathwayStatus {
        /**
         * 0;已入径
         */
        public static final int HAS_ENTERING = 0;
        /**
         * 1;未入径
         */
        public static final int NOT_ENTERING = 1;
        /**
         * 2;已出径
         */
        public static final int HAS_OUTTING = 2;
    }

    public static final class DictionaryTypeConfig {

        public static final class UserOpenation {
            /**
             * 操作人
             */
            public static final String USER_OPERATION = "a43724ddf0b84974a68bc631a8c50b65";

            /**
             * 创建人
             */
            public static final String USER_CREATION = "93bb2080608649278369c620b617b0d2";

            /**
             * 结算人
             */
            public static final String USER_SETTLEMENT = "b59cf1befe4e410bb7cf2fc3906fd42c";

            /**
             * 开票人
             */
            public static final String USER_MAKE_INVOICE = "f238d1e43ac444218d76a1c46d860b80";

            /**
             * 作废人
             */
            public static final String USER_INVALID = "f238d1e43ac444218d76a1c46d860b81";

            /**
             * 删除人
             */
            public static final String USER_DELETE = "f238d1e43ac444218d76a1c46d860b84";

            /**
             * 审核人
             */
            public static final String USER_AUDIT = "f238d1e43ac444218d76a1c46d860b82";

            /**
             * 核定人
             */
            public static final String USER_CHECK = "f238d1e43ac444218d76a1c46d860b83";

            /**
             * 修改人
             */
            public static final String USER_UPDATE = "d6b28aac74e1400a87f323c0d982bcb9";

            /**
             * 打印人
             */
            public static final String USER_PRINT = "a412cdc935374372b74e8528dd5c4ac8";

            /**
             * 系统默认用户
             */
            public static final String SYSTEM_USER = "4256d7d7378e4ca6a4221f79896448ba";

            /**
             * 系统默认用户用户名
             */
            public static final String SYSTEM_USERNAME = "system";

            /**
             * 床位撤除人
             */
            public static final String REMOVE_BED = "4e45d58fa0ee4f16b5fd856e74e0e55d";
            /**
             * 床位增加人
             */
            public static final String ADD_BED = "68a6475da9774faf972e52f32ce7725c";

            /**
             * 床位启用人
             */
            public static final String START_USE_BED = "b4803087a9475556ba20786090db6413";

            /**
             * 出院操作人
             */
            public static final String OUT_HOSPITAL_USER = "489dd0c64e5d4699bc7ee3ebcbe21bf9";

            /**
             * 取消出院操作人
             */
            public static final String CANCEL_OUT_HOSPITAL_USER = "af2abd6e25044c4098270f2e43556166";

            /**
             * 临床路径新增人
             */
            public static final String CLINICAL_PATHWAY_CREATE_USER = "05755e02c956431bb6914d3c1977bb03";
        }

        public static final class stockReceipt {

            /**
             * 出库
             */
            public static final String LIBRARY_ID = "a311c022d327478fab6624ad8e2e964b";

            /**
             * 盘点
             */
            public static final String INVENTORY_ID = "fe354b895b654dcfa71a84c46da79fgh";

            /**
             * 处方出库配置ID
             */
            public static final String PRE_RECEIPT_CONFIG_ID = "a14aa4b76b134c3590184341ebac2222";

            /**
             * 处方退药配置ID
             */
            public static final String PRE_BACK_PILLS_ID = "5a1955d1653747a9acd29a637a8eecf0";

        }

        public static final class HospitalizationRegisters {

            /**
             * 入院病况
             */
            public static final String DISEASS_CONDITIONS_TYPEID = "d36791823ea24b5eb72243c53253f1cc";

            /**
             * 住院目的
             */
            public static final String HOSPITAL_PURPOSES_TYPEID = "1f859d30c70941509871e1460aa9b491";

            /**
             * 护理等级
             */
            public static final String Nursing_Grade_TYPEID = "1f859d30c70941509871e1460aa9b491";

            /**
             * 中医诊断
             */
            public static final String DIAOFTRAD_CHIN_MED = "d979ffe94ea04755abbc5cc4ce997c2c";

            /**
             * 西醫诊断
             */
            public static final String DIAOFTRAD_WEST_MED = "5d1e4d4d11ba4128bee6c19beeb8010b";

            /**
             * 民族医诊断
             */
            public static final String NATION_MED = "aed9f1436fdf474380c04471f1045c7e";

        }

    }

    /**
     * 药品医保
     *
     * @author YC
     */
    public static final class drugMedicare {

        /**
         * 甲类
         */
        public static final Integer FULL_AMOUNT = 1;

        /**
         * 乙类
         */
        public static final Integer UNFULL_AMOUN = 2;

        /**
         * 其他
         */
        public static final Integer OTHER = 0;

    }

    public static final class Configinfo {

        /**
         * 系统
         */
        public static final String CONFIG_SYSTEM = "1";

        /**
         * 用户
         */
        public static final String CONFIG_USER = "2";

    }

    public static final class IllnessRecordConfig {

        /**
         * 1.初诊
         */
        public static final Integer BOTH_THE = 1;

        /**
         * 2.复诊
         */
        public static final Integer VISIT = 2;
    }

    public static final class SystemConfigMessage {

        public static final String DEFAULT_PASSWORD = "123456";

        public static final String PARAMETER_ERROR = "参数错误";

        public static final String NOT_FOUND = "该数据已失效";

        public static final String SYSTEM_ERROR = "系统出现异常，请联系管理员";

        public static final String HQL_ERROR = "数据库操作失败";

        public static final String SUCCESS_MESSAGE = "请求成功";

        public static final String NO_DATA_EXIST = "数据不存在";

        public static final String KINDS_ID_DAYU = "分类不能超过5级";

        public static final String HAS_BEEN_DELETED = "已删除";

        public static final String NOT_ADMIN = "不是超级管理员";

        public static final String OPERATION_SUCCESSFULLY = "操作成功";

        public static final String OPERATION_FAILURE = "操作失败";

        public static final String DELETED_SUCCEED = "删除成功";

        public static final String DELETED_FAILURE = "删除失败";

        public static final String UPDATE_SUCCEED = "修改成功";

        public static final String UPDATE_FAILURE = "修改失败";

        public static final String SAVE_SUCCEED = "保存成功";

        public static final String SAVE_EXISTS = "数据已经存在";

        public static final String SAVE_FAILURE = "保存失败";

        public static final String RECOVER_SUCCEED = "恢复成功";

        public static final String RECOVER_FAILURE = "恢复失败";

        public static final String REGISTER_SUCCEED = "注册成功";

        public static final String REGISTER_FAILURE = "注册失败";

        public static final String USER_EXIST = "用户已存在";

        public static final String KINDS_TYPE_EXIST = "该类型已经存在";

        public static final String PROPERTY_GRADE_DAYU = "属性等级最大为三级，请重新添加";

        public static final String LOCKED_SUCCESSFULLY = "锁定成功";

        public static final String REPEATED_LOCK = "重复锁定";

        public static final String LOCK_FAILED = "锁定失败";

        public static final String STATUS_CODE_SUCCESS = "000";

        public static final String STATUS_CODE_FAILURE = "021";

        public static final String HAS_BEEN_LOCKED = "已被锁定";

        public static final String HAS_BEEN_CANCELED = "已被注销";

        public static final String RECEIPT_NOTEXIST = "单据不存在";

        public static final String PARENT_ID = "0";

        public static final String PATIENT_NOTEXIST = "患者不存在";

        public static final String REGISTRATION_NOTEXIST = "号池不存在";

        public static final String REGISTRATION_REPEAT = "患者已经挂过该号";

        public static final String WECHAT_MP_HASBIND = "已经绑定";

        public static final String WECHAT_MP_NOBIND_RECORD = "无绑定记录";

        public static final String VALIDITY_OF_VISIT_CARD = "该就诊卡不能使用";

        public static final String REGISTRATIONPOOL_SUCCESS = "该号池已挂满";

        public static final String REGISTRATIONPOOL_ABOUT_SUCCESS = "该号池已预约满";

        public static final String HAS_BEEN_REGISTERED = "该患者当天已挂号";

        public static final String WECHAT_MP_NOBIND_PATIENT = "无绑定患者信息";

        public static final String TEMPLATES_THE_SECTION = "存在该名称模板";

        public static final String FINAL_CLASSIFICATION = "该分类不为最后一级分类";

        public static final String EMR_HAS_THE_NEW = "该病例已新建，不能重复建立";

        public static final String EMR_HAS_THE_MUTEX = "该病例已有新建的互斥病历";

        public static final String TEMPLATE_STATUS_PROMPT = "当前模板状态未激活";

        public static final String TEMPLATE_CONTENT_STATUS = "该模板未创建模板内容";

        public static final String ARCHIVES_SUCCEED = "归档成功";

        public static final String ARCHIVES_FAILURE = "归档失败，无病历信息";

        public static final String CANCEL_SUCCEED = "取消归档成功";

        public static final String ARCHIVES_STATUS = "该患者病历已归档";

        public static final String TREATMENT_MISMATCH = "该用户无病历创建权限";

        public static final String USER_MODIFICATION_RIGHT = "此病例不是该用户创建无法修改";

        public static final String USER_MODIFICATION_INVALID = "此病例不是该用户创建无法作废";

        public static final String EMR_NO_SUBMIT = "该用户无提交权限";

        public static final String SUBMIT_SUCCEED = "提交成功";

        public static final String SUBMIT_FAILURE = "提交失败";

        public static final String RETURN_SUCCEED = "退回成功";

        public static final String SUBMIT_OPERATE = "患者未出院，提交失败";

        public static final String NOT_ARCHIVES_EMR = "未归档病历：";

        public static final String NOT_NURSE = "此护士无操作权限";

        public static final String RECEIVE_SUCCEED = "接收成功";

        public static final String UNTIE_SUCCEED = "解绑成功";

        public static final String BINDING_SUCCEED = "绑定成功";

        public static final String BINDING_FAILURE = "绑定失败";

        public static final String NO_WRITING = "无可书写模板";

        public static final String NO_PERMISSIONS = "无操作权限。";

        public static final String NO_DATA = "未查询得到相关数据";

        public static final String AUDIT_SUCCEED = "审核成功";

        public static final String CANCEL_AUDIT = "已取消审核";

        public static final String EMR_AUDIT = "病历已审核，不能修改";

        public static final String EMR_AUDIT_SUBMIT = "病历已审核，不能提交";

        public static final String USER_MODIFICATION_SUBMIT = "此病例已提交无法作废";

        public static final String EMR_EXAMINE = "有上级医师无法审核";

        public static final String EMR_AUDIT_USER = "该用户不是此病例审核人，不能取消审核";

        public static final String EMR_CANCEL_AUDIT = "该病例未审核";

        public static final String EMR_AUDIT_COMPLETE = "该病例已审核";

        public static final String EMR_NOT_SUBMIT = "该病例未提交，不能审核";

        public static final String AUDIT_NOT_SUPER_DOCTOR = "不是上级医生，无审核权限";

        public static final String EMR_TEMPLATE = "请添加病历模板";

        public static final String NO_SUBMIT_RECORD = "该电子病历无提交记录";

        public static final String NOT_SUBMIT_DOC = "不是病历提交上级医生";

        public static final String NOT_WRITE_DOC = "提交人与病历书写人不匹配";

        public static final String MRHP_SUBMIT = "该病案首页已提交或已接受";

        public static final String NOT_ARCHIVES_INFOM = "无归档信息";

        public static final String NOT_ARCHIVES = "当前状态为未归档";

        public static final String CANCEL_ARCHIVES_FAILURE = "该病例已有借阅复印记录，无法取消归档";
    }

    /**
     * 费用结算单类型标识
     *
     * @author zhanghengrui 2018-09-26
     */
    public static final class CostSettleTypeValue {
        /**
         * 0 结算
         */
        public static final int SETTLEMENT = 0;

        /**
         * 1 退费
         */
        public static final int REFUND = 1;
    }

    /**
     * 费用相关
     *
     * @author gongliang 2018-8-3
     */
    public static final class cost {

        /**
         * 1;已缴费
         */
        public static final int COST_ALREADY_SETTLED = 1;

        /**
         * 2;未缴费
         */
        public static final int COST_ALREADY_CREATED = 2;

        /**
         * 3;已作废
         */
        public static final int COST_ALREADY_ABANDONED = 3;

        /**
         * 4; 可退费
         */
        public static final int COST_ALREADY_REFUND = 4;

        /**
         * 5; 已退费
         */
        public static final int COST_REFUND_OVER = 5;

        /**
         * 1：已结算
         */
        public static final int COSTSUMMARY_ALREADY_SETTLED = 1;

        /**
         * 2：未结算
         */
        public static final int COSTSUMMARY_UNSETTLED = 2;

        /**
         * 减免信息key
         */
        public static final String COSTLIST_RESULT_REDUCEMSG = "msg";

        /**
         * 减免多少key
         */
        public static final String COSTLIST_RESULT_REDUCE = "reduce";

        /**
         * 收费项目key
         */
        public static final String COSTLIST_RESULT_COSTPRJ = "project";

        /**
         * 业务已完成
         */
        public static final int COSTBUSINESS_STATUS_DISPOSAL = 1;

        /**
         * 业务未完成
         */
        public static final int COSTBUSINESS_STATUS_UNDISPOSAL = 2;

        /**
         * 业务已作废
         */
        public static final int COSTBUSINESS_STATUS_ABANDONED = 3;

        /**
         * 收费项目启用
         */
        public static final Integer COST_PROJECT_ENABLE = 0;

        /**
         * 收费项目不启用
         */
        public static final Integer COST_PROJECT_NOT_ENABLE = 1;

        /**
         * 物价项目启用
         */
        public static final Integer PRICE_PROJECT_ENABLE = 0;

        /**
         * 物价项目不启用
         */
        public static final Integer PRICE_PROJECT_NOT_ENABLE = 1;
    }

    public static final class StatisticType {
        /**
         * 其他费用统计类型
         */
        public static String OTHER_TYPE = "7a413967d5674ce4a040600b2a526777";

    }

    /**
     * 币种
     */
    public static final class Currency {
        /**
         * 人民币
         */
        public static String RMB = "15223deac8094f5da7f4a20797b41532";

    }

    /**
     * 支付方式
     */
    public static final class Payment {
        /**
         * 现金
         */
        public static String CASH = "现金";

        /**
         * 转账
         */
        public static String TURN_MONEY = "转账";

        /**
         * 微信支付id
         */
        public static String WECHAT_PAY_ID = "42ed96bae18041b286ef4f21c9c1c000";

        /**
         * 现金id
         */
        public static final String CASH_ID = "e8bd43a11b4248e58660b2621b6e589e";

        /**
         * 是否现金支付 (0 为非现金支付, 1 为现金支付)
         *
         * @author gongliang 2018-10-10
         */
        public static final class IsCash {
            /**
             * 0 为非现金支付
             */
            public static Integer NO_CASH = 0;
            /**
             * 1 为现金支付
             */
            public static Integer CASH = 1;

        }
    }

    /**
     * 单据操作记录
     */
    public static final class ReceiptOperationCord {
        /**
         * 状态类型
         */
        public static final class Type {
            /**
             * 审核中
             */
            public static final int CREATE = 1;
            /**
             * 审核通过
             */
            public static final int REVIEW_AND_PASS = 2;

            /**
             * 审核未通过
             */
            public static final int UNAUDIT = 0;

            /**
             * 核查
             */
            public static final int CHECK = 3;
        }

        /**
         * 标示
         */
        public static final class Identification {

            /**
             * 审核中
             */
            public static final String CREATE = "create";
            /**
             * 审核通过
             */
            public static final String REVIEW_AND_PASS = "review_and_pass";

            /**
             * 审核未通过
             */
            public static final String UNAUDIT = "unaudit";

            /**
             * 核查
             */
            public static final String CHECK = "check";

        }

    }

    /**
     * 库存操作明细
     *
     * @author yaofei
     */
    public static final class StockOperationDetail {
        /**
         * 库存操作明细实体
         */
        public static final String STOCKOPERADETAIL = "stockoperadetail";

        /**
         * 数量
         */
        public static final String NUMBER = "number";

        /**
         * 单价
         */
        public static final String PRICE = "price";

    }

    /**
     * 收费项目
     */
    public static final class CostProjects {

        /**
         * 挂号费id(每个医院的挂号费是固定)
         */
        public static final String REGISTER_ID = "9a6c8d103f104932b5dc592697ef67c3";

        /**
         * 医嘱收费id
         */
        public static final String DOCTOR_ADVICE = "f1d8e34da4034fb0bd85e5bee8c33198";

        /**
         * 住院诊查费
         */
        public static final String CLINIC_COSTPROJECT = "a6e2d7cd293b4046bd7800d79a3a62f7";

        /**
         * 西药收费
         */
        public static final String WEST_COSTPROJECT = "9737f379c4484946a9f3199eb9bc8b1c";
        /**
         * 中成药收费
         */
        public static final String CPAN_COSTPROJECT = "3B2018F1A78C431AB5FC2432FF78FB27";

        /**
         * 中药收费
         */
        public static final String EAST_COSTPROJECT = "CFF780F2FFE842029CDF522627F1BA40";
        /**
         * 诊查费类型ID
         */
        public static final String CLINIC_TYPE_MONEY = "686ca646e1a0491c8f9d6184f34e0b03";

        /**
         * 卫材收费项目
         */
        public static final String EISAI_COST_PROJECT = "7dc322bfd46b4f7caa21e2dcdd9c0ec1";

        /**
         * 诊疗费
         */
        public static final String DIAGNOSISTREATMENT_COSTPROJECT = "9c8894989c6c4938967ebc4a5873d8be";

        public static final class CostType {
            /**
             * 卫材收费项目
             */
            public static final String EISAI_COST_PROJECT = "7dc322bfd46b4f7caa21e2dcdd9c0ec1";

            /**
             * 一般检查
             */
            public static final String GENERAL_INSPECT_PROJECT = "428FDFB1AA5140F5A36C6B25B9E9CC49";

            /**
             * 超声检查
             */
            public static final String SUPERSOUND_INSPECT_PROJECT = "2275903D1D194E51B3660937FA562B76";

            /**
             * 病理检查
             */
            public static final String PATHOLOGY_INSPECT_PROJECT = "BB4A7FC77D86453694BBB42BF2C73090";

            /**
             * 检验
             */
            public static final String CHECKOUT_PROJECT = "BF3D9E820B374C3AA0284A5B50E78A35";

            /**
             * 物理治疗
             */
            public static final String PHYSIC_TREAT_PROJECT = "7A03D10291244409B21ABAB39E34A77C";

            /**
             * 一般治疗
             */
            public static final String GENERAL_TREAT_PROJECT = "A7C79466F65240B3A3CA829621006316";

            /**
             * 放射治疗
             */
            public static final String RADIATION_TREAT_PROJECT = "84874AEFC0CF4385847A72303CD8E16D";

            /**
             * 手术治疗
             */
            public static final String OPERATOR_TREAT_PROJECT = "46E3B877D7A04A68B88571C77635DEFF";

            /**
             * 西药收费
             */
            public static final String WEST_COSTPROJECT = "37E9F4C359E24B2696435A6321160809";

            /**
             * 中药收费
             */
            public static final String EAST_COSTPROJECT = "7E2A123FD8BE438F8D18BEDF9C2689FB";
        }
    }

    public static final class DictionaryTypes {
        /**
         * 排班
         */
        public static final String SCHEDULING = "排班";
    }

    /**
     * 工作组
     */
    public static final class WorkGroups {

        /**
         * 工作组不存在
         */
        public static final String NOTEXIST = "工作组不存在";

        /**
         * 科室
         */
        public static final String DEPARTMENT = "科室";

        /**
         * 默认科室
         */
        public static final String THE_DEFAULT = "393f09581bcb49658317322bce4162f9";

        /**
         * 所有科室
         */
        public static final String WORKGROUPS_ALL = "a25785cadcd745849de0349f789ebb57";

    }

    /**
     * 挂号
     */
    public static final class Registrations {
        /**
         * 不存在
         */
        public static final String NOTEXIST = "挂号不存在";

        /**
         * 状态
         */
        public static final class Status {
            /**
             * 新建
             */
            public static final Integer CREATE = 0;

            /**
             * 作废
             */
            public static final Integer ABANDONED = -1;

            /**
             * 完成
             */

            public static final Integer FINISH = 1;

        }

        /**
         * 0 ：挂号
         */
        public static final Integer NO_ABOUT = 0;

        /**
         * 1 ;预约
         */
        public static final Integer ABOUT = 1;

        /**
         * 西医普通诊查
         */
        public static final String WEST_MEDICINE_COMMON = "b94e449caadb439089f003cb04d95b11";
    }

    /**
     * 挂号
     */
    public static final class RegistrationPools {
        /**
         * 号池不存在
         */
        public static final String NOTEXIST = "号池不存在";

        public static final class Status {
            /**
             * 已审核
             */
            public static final Integer SUCCESS = 1;

            /**
             * 已停止
             */
            public static final Integer STOP = 2;

            /**
             * 已作废
             */
            public static final Integer INVALID = -1;

            /**
             * 已新建
             */
            public static final Integer CREATE = 0;
        }
    }

    /**
     * 发票
     */
    public static final class Invoices {
        /**
         * 作废
         */
        public static final int ABANDONED = 3;

        /**
         * 已打印
         */
        public static final int PRINTED = 2;

        /**
         * 未打印
         */
        public static final int NO_PRINT = 1;

        /**
         * 发票类型启用
         */
        public static final int INVOICE_TYPE_ENABLE = 1;

        /**
         * 发票类型未启用
         */
        public static final int INVOICE_TYPE_UNENABLE = 0;

        /**
         * 发票库存正常
         */
        public static final int INVOICE_STOCK_NORMAL = 1;

        /**
         * 发票库存停用
         */
        public static final int INVOICE_STOCK_STOP = 0;

        /**
         * 发票业务类型父id
         */
        public static final String BUSINESSTYPE_PARENTID = "8186f1cd082f41ebbaa9aa4b690cfe3a";

        /**
         * 发票业务入库类型id
         */
        public static final String BUSINESSTYPE_STORAGEID = "ce8626a747214b1685a84a424a9a1f95";

        /**
         * 发票业务调拨类型id
         */
        public static final String BUSINESSTYPE_ALLOCATIONID = "364f860cb9fc494a89cea5a2b3adb6c3";

        /**
         * 发票业务开票类型id
         */
        public static final String BUSINESSTYPE_MAKEID = "7743698879904e9db2b865d95e174830";

        /**
         * 发票业务报损类型id
         */
        public static final String BUSINESSTYPE_BREAKAGE_ID = "8d6e1d5f67a54979adacb62ec096631e";

        /**
         * 发票配置操作类型父id
         */
        public static final String CONFIGOPERAT_PARENTID = "56b775cfe20545c0b20d48be5fd6dad9";

        /**
         * 发票门诊操作类型id
         */
        public static final String OUTPAT_DEPART_ID = "fcb5245049fe446282ddbb04093cc9a7";

    }

    /**
     * 打印
     *
     * @author yanghaiyong
     */
    public static final class PrintType {
        /**
         * 打印类型父级
         */
        public static final String PRINTTYPE = "ba887467e0474754967aa6d347d5aafa";
        /**
         * 瓶签
         */
        public static final String BOTTLE_LABEL = "f00f9c082972436fab6067ca68d0df30";
        /**
         * 输液
         */
        public static final String INFUSION = "fd87c32fe7f9400198744f0c0c63a93b";

        /**
         * 已打印
         */
        public static final Integer PRINTED = 2;

        /**
         * 未打印
         */
        public static final Integer NO_PRINT = 1;
    }

    /**
     * 不良事件
     */
    public static final class AdversEvents {
        /**
         * 药品不良事件
         */
        public static final String ADVERSDRUGEVENTS = "5a86da185ce64f1195fe0ccfbef5bf36";
        /**
         * 护理不良事件
         */
        public static final String ADVERSEVENTS = "b4bce2abd7104e89885c611cd03db144";
    }

    /**
     * 单据
     */
    public static final class Receipts {
        /**
         * 无记录
         */
        public static final Integer NODATA = -1;
        /**
         * 已新建
         */
        public static final Integer CREATED = 0;
        /**
         * 已修改
         */
        public static final Integer UPDATE = 1;
        /**
         * 已校准
         */
        public static final Integer CHECKED = 2;
        /**
         * 已审核
         */
        public static final Integer AUDITED = 3;
        /**
         * 已作废
         */
        public static final Integer INVALID = 4;

        /**
         * 不是已新建的单据
         */
        public static final String NOT_CREATED = "不是已新建的单据";
        /**
         * 单据已审核
         */
        public static final String HAS_AUDITED = "单据已审核";

        /**
         * 报损原因
         */
        public static final String LOSS_REASON = "ddba2a84f9854ac1be27445a92d8aee1";

        public static class ReceiptConfig {

            public static class ReceiptSort {
                /**
                 * 出库
                 */
                public static final String LIBRARY_ID = "82fde19ea53048e4b2677a8069370efc";

                /**
                 * 盘点
                 */
                public static final String INVENTORY_ID = "7473c04b7fdf452886fc3b4f03687fc0";

                /**
                 * 入库
                 */
                public static final String STORAGE_ID = "a6429a96f4d64141bcbe89d26da2456e";

                /**
                 * 拆分
                 */
                public static final String SPLIT_ID = "50274898d7714a01a188944ca948efb3";
                /**
                 * 报损单
                 */
                public static final String LOSSBILLS_ID = "e9250788aac8415fabcf4ba4a894f3aa";
                /**
                 * 调拨单
                 */
                public static final String ALLOCATION_ID = "b5760179285e4831b8adfb2a34e5be73";

                /**
                 * 普通调拨配置ID
                 */
                public static final String GENERAL__ALLOT_ID = "434e33741f9d47ce9ca6358d3e26e6b0";

                /**
                 * 药品申领单配置ID
                 */
                public static final String DRUG_APPLY_ID = "ade9e6301ec64715b9c30cacec7ea24f";

                /**
                 * 日常盘点配置ID
                 */
                public static final String DAILY_INVENTORY_ID = "66681b19c2da4067b7ed902390afdcae";

                /**
                 * 其它出库单配置ID
                 */
                public static final String OTHER_OUTBILLS_ID = "5511b392795f40338da70461f7913c8c";
                /**
                 * 库存报损单配置ID
                 */
                public static final String REPORT_LOSSBILLS_ID = "89096f9a9cda4cc08e8af8a6e54e180f";
                /**
                 * 初始化盘点配置id
                 */
                public static final String INIT_INVENTORY_ID = "4962ed7c7ed2473a8c87da6e172cba09";
                /**
                 * 采购入库配置id
                 */
                public static final String PURCHASE_PLAN_ID = "61610183b3164749af5db26c14880e90";
                /**
                 * 供应商退库配置id
                 */
                public static final String SUPPILER_RETIRING_ID = "c58ed9c0476c4c8081d6ef15cca2b0ca";

                /**
                 * 自动拆分配置id
                 */
                public static final String AUTOMATIC_SPLIT_ID = "80a6459b8b184ffab3e289850ced9bd4";

                /**
                 * 药房退药单据配置Id
                 */
                public static final String DRUG_REIRING_ID = "c40a1af1260c40f9bfa183d25b550545";

                /**
                 * 药库接收药房退药单据配置Id
                 */
                public static final String DRUG_ACCEPT_ID = "1388616b099b4dd4b768f70218138ee7";

                /**
                 * 病区退药单据配置Id
                 */
                public static final String WING_BACK_ID = "2ea02d4ec2a84750ac1b6f65dc8cb403";
            }

        }

        /**
         * 基础单据配置
         */
        public static final String BASE_BUSSINESS_TYPE = "f81c1206a87e4ae3a1e84e6bcf931bb0";
        /**
         * 入库单据配置
         */
        public static final String STORAGE_BUSSINESS_TYPE = "4b107c252a9c49cd970e17ff94f1ba5b";
        /**
         * 调拨单据配置
         */
        public static final String ALLOTSTORAGE_BUSSINESS_TYPE = "bb09171f7d0a4550b50bc79b77ea4dd3";
        /**
         * 出库单据配置
         */
        public static final String PLACING_BUSSINESS_TYPE = "51217f9b4c554fe6a85428a67398b0d8";
        /**
         * 盘点单据配置
         */
        public static final String INVENTORY_BUSSINESS_TYPE = "5701172b499e483ab00c235bac996445";
        /**
         * 拆分单据配置
         */
        public static final String SPLIT_BUSSINESS_TYPE = "2356257eaadc4cc0bbf5e6e1662a0015";
    }

    /**
     * 是否主诊断
     */
    public static final class Inspecting {
        /**
         * 0.否
         */
        public static final Integer PRIMARY_DIAGNOSIS = 0;
        /**
         * 1.是
         */
        public static final Integer NO_DIAGNOSIS = 1;

    }

    /**
     * 是否责任人
     */
    public static final class IsResponse {
        /**
         * 0.否
         */
        public static final Integer NO = 0;
        /**
         * 1.是
         */
        public static final Integer YES = 1;

    }

    /**
     * 疾病状态
     *
     * @author yangxiao
     */
    public static final class DiseaseState {
        /**
         * 0：疑似病
         */
        public static final Integer SUSPECTED_DISEASE = 0;
        /**
         * 1：确诊
         */
        public static final Integer CONFIRMED = 1;

        /**
         * 2： 作废
         */
        public static final Integer INVALID = 2;
    }

    /**
     * 是否是主诊断
     *
     * @author yangxiao
     */
    public static final class DiseaseMainDiagnosis {
        /**
         * 0：否
         */
        public static final Integer NO = 0;

        /**
         * 1： 是
         */
        public static final Integer YES = 1;
    }

    /**
     * 常量类
     *
     * @author yangxiao
     */
    public static final class Constant {
        /**
         * 常量0
         */
        public static final Integer CONSTANT_ZERO = 0;
    }

    /**
     * 医药脚注
     *
     * @author yangxiao
     */
    public static final class DrugFootnotes {

        /**
         * 中医脚注字典typeId
         */
        public static final String CHINESE_MEDICINE_ID = "de39523e4fb140afa7bccb43d1bdbec5";

        /**
         * 西医脚注
         */
        public static final String WESTERN_FOOTNOTES = "N/A";
    }

    /**
     * 药品类型关联表状态
     *
     * @author yangxiao
     */
    public static final class StateOfDrug {

        /**
         * 0： 有效
         */
        public static final Integer EFFECTIVE = 0;

        /**
         * 1： 无效
         */
        public static final Integer INVALID = 1;
    }

    /**
     * 医药类型
     *
     * @author yangxiao
     */
    public static final class MedicineType {

        /**
         * 药品类型
         */
        public static final String DRUG_TYPE = "1ab797c2fd104602b883c30c7f920e7a";

        /**
         * 西药
         */
        public static final String WMDRUG = "dffa58d4911a4002867e8ee5ae68b060";

        /**
         * 西药分类Id
         */
        public static final String CLASSIFICATION_WMDRUG = "1e99d4f9c70a40a78b23862ade93f31e";

        /**
         * 中药
         */
        public static final String CHDRUG = "2927e59402ab4e7cbacbd57b52a4ed54";

        /**
         * 中药分类Id
         */
        public static final String CLASSIFICATION_CHDRUG = "f764d7192c8c4727a660fd7d5c49434e";

        /**
         * 中成药
         */
        public static final String PATENT = "8574cef48fac498ca8f7f06479b96d09";

        /**
         * 中成药分类Id
         */
        public static final String CLASSIFICATION_PATENT = "4D3EA218D4AD4B3785E2EB171AB18C6E";

    }

    /**
     * 药品分类
     */
    public final class Classification_Type {
        /**
         * 大输液及其其他输液类型
         */
        public static final String CLASSIFICATION_BIGINFUSION = "147c1b0c0be141d4b3a674c6b40c3649";
    }

    /**
     * 药品对应处方类型id
     */
    public static final String TYPE_PRESCRIPTION = "4f247079442648dd8ee546ae2c558390";

    /**
     * 药品处方类型
     *
     * @author yangxiao
     */
    public static final class DrugPrescriptionType {

        /**
         * 麻醉 精一
         */
        public static final String SPIRITONE = "48d5dbb060bb4dd4a5e2f6c016728e6b";

        /**
         * 精二
         */
        public static final String SPIRITTWO = "fed3c01c9e81424f93a51ca6575e48c6";

        /**
         * 医嘱执行开药处方类型 0：西药
         */
        public static final Integer TYPE_WEST = 0;
        /**
         * 医嘱执行开药处方类型 1：中药
         */
        public static final Integer TYPE_EAST = 1;

    }

    /**
     * 处方类型
     *
     * @author yangxiao
     */
    public static final class PrescriptionType {

        /**
         * 普通处方
         */
        public static final String COMMON = "af15dd4469864b4ea8f20876da309dce";

        /**
         * 麻醉、精一
         */
        public static final String SPIRITONE = "6b5c4b2b16c9455c9eae47168b5aec7e";

        /**
         * 精二
         */
        public static final String SPIRITTWO = "1b3dffaa0f5e454bbd4b8919a868980d";

        /**
         * 处方类型ID
         */
        public static final String PRESCRIPTION_TYPE_ID = "592cb6fb4ffa46c7a7a3fcec6aa8b8e5";

    }

    /**
     * 发药类型
     */
    public static final String PREHAIRTYPEMEDICINE = "77460c6a4a564501a6eb9bae85b53248";

    /**
     * 费用类别
     */
    public static final String PRECOSTCATEGORIES = "efd44f53763b46e694ca2cdab875c56e";

    public static final class PrehairTypeMedicineDetail {

        /**
         * 自备药
         */
        public static final String BRING_YOUR_OWN = "804b0458f5ec475893b9ea137af49b7f";

        /**
         * 院内发药
         */
        public static final String IN_THE_PILLS = "4f80484bd9774a33a98b81270c0d012b";
    }

    /**
     * 药品调价单据
     *
     * @author yaofei
     */
    public static final class DrugPriceAdjustmentReceipts {
        /**
         * 已创建
         */
        public static final Integer CREATED = 0;

        /**
         * 已修改
         */
        public static final Integer MODIFYED = 1;

        /**
         * 已校准
         */
        public static final Integer CALIBRATED = 2;

        /**
         * 已审核
         */
        public static final Integer AUDITED = 3;
        /**
         * 已作废
         */
        public static final Integer ABANDONED = 4;
    }

    /**
     * 处方状态
     *
     * @author yangxiao
     */
    public static final class PrescriptioStatus {
        /**
         * -1;已作废
         */
        public static final Integer NOT_INVALID = -1;

        /**
         * 0;已新建
         */
        public static final Integer HAS_NEW = 0;

        /**
         * 1;已审核
         */
        public static final Integer HAS_OK = 1;

    }

    /**
     * 判断是否是就诊卡
     *
     * @author yangxiao
     */
    public static final class AttendanceCard {
        /**
         * 0;不是就诊卡
         */
        public static final Integer NOT_MEDICAL_CARD = 0;

        /**
         * 1;是就诊卡
         */
        public static final Integer MEDICAL_CARD = 1;

    }

    /**
     * 就诊卡状态 1.锁卡 0.未锁卡 -1.挂失
     *
     * @author yangxiao
     */
    public static final class ClinicCardStatus {
        /**
         * 0.未锁卡
         */
        public static final Integer NOT_LOCK_CARD = 0;

        /**
         * 1.锁卡
         */
        public static final Integer LOCK_CARD = 1;

        /**
         * -1.挂失
         */
        public static final Integer REPORT_LOSS = -1;
    }

    /**
     * 发药状态
     *
     * @author Administrator
     */
    public static final class DispensingStatus {
        /**
         * 0.未发药
         */
        public static final Integer NOT_DISPENSINGS = 0;

        /**
         * 1.已发药
         */
        public static final Integer ALREADY_DISPENSINGS = 1;

        /**
         * 已退药
         */
        public static final Integer BACK_PILLS = 2;
        
        /**
         * 已作废
         */
        public static final Integer INVALID = 3;

        /**
         * 发药成功
         */
        public static final String DISPENSING_SUCCESS = "发药成功";

        /**
         * 发药失败
         */
        public static final String DISPENSING_FAILURE = "发药失败";
    }

    /**
     * 仓库类型
     *
     * @author yangxiao
     */
    public static final class WarehouseType {
        /**
         * 仓库
         */
        public static final String WAREHOUSE = "61940eaa4df44726abcabced28a93650";

        /**
         * 货架
         */
        public static final String SHELVES = "b5c366ba3a29416e82c8091432d04063";
        /**
         * 门诊
         */
        public static final Integer SCOPE_OUT_DEPART = 0;

        /**
         * 住院
         */
        public static final Integer SCOPE_HOSPITAL = 1;

        /**
         * 全院
         */
        public static final Integer SCOPE_WHOLE_HOSPITAL = 2;

        /**
         * 不限
         */
        public static final Integer SCOPE_UNLIMITED = 3;
    }

    /**
     * 处方出库库存查询状态
     *
     * @author yangxiao
     */
    public static final class InventoryQueryStatus {
        /**
         * 0;最近临期
         */
        public static final Integer THE_PERIOD = 0;

        /**
         * 1;最小库存
         */
        public static final Integer MIN_INVENTORY = 1;

    }

    /**
     * 处置科室
     *
     * @author yangxiao
     */
    public static final class Department {

        /**
         * 处置科室 ：临床科室西药库
         */
        public static final String DISPOSAL_DEPARTMENT = "01ff5ebd975b4c2dbe04f116c84e4296";

        /**
         * 处置科室 ：临床库分组
         */
        public static final String DISPOSAL_GROUP = "154fce98957a46cc91380eaa03df8ab8";

        /**
         * 检验处置科室
         */
        public static final String TEST_ITEM_DISPOSAL_GROUP = "21F56110DE884D16B97C802D28D6B9FC";

        // TODO
        /**
         * 检验处置科室
         */
        public static final String CHECK_ITEM_DISPOSAL_GROUP = "9c70e56dfe334984ac5fb6b91266f12f";

    }

    /**
     * 微信公众号
     *
     * @author yaofei
     */

    public static final class WeChatMp {

        /**
         * 微信公众号菜单基本uri
         */
        public static final String MENU_COMMON_URI = "https;//api.weixin.qq.com/cgi-bin/menu";

        /**
         * 微信用户基本uri
         */
        public static final String USER_COMMON_URI = "https;//api.weixin.qq.com/cgi-bin/user";

    }

    /**
     * 微信支付
     */
    public static final class WeChatPay {

        /**
         * 刷卡支付
         */
        public static final class Micropay {
            /**
             * 结果码
             */
            public static class ResultCode {
                public static final String SUCCESS = "SUCCESS";
                public static final String FAIL = "FAIL";
            }

            /**
             * 错误码
             */
            public static class Errcode {
                /**
                 * 接口返回错误,支付结果未知
                 */
                public static final String SYSTEMERROR = "SYSTEMERROR";
                /**
                 * 用户支付中，需要输入密码
                 */
                public static final String USERPAYING = "USERPAYING";
            }

        }

        /**
         * 回调
         */
        public static class CallBack {
            /**
             * 业务完成
             */
            public static Integer COMPLETE = 1;
            /**
             * 业务未完成
             */
            public static Integer UNCOMPLETE = 0;

        }

        /**
         * 支付状态
         */
        public static class PayedStatus {

            /**
             * 已支付
             */
            public static Integer PAYED = 1;

            /**
             * 退款
             */
            public static Integer REFUND = 2;

            /**
             * 订单关闭
             */
            public static Integer CLOSED = 3;

            /**
             * 已撤销
             */
            public static Integer REVOKED = 4;

            /**
             * 用户正在支付
             */
            public static Integer PAYING = 5;
        }

    }

    /**
     * 小程序
     *
     * @author yaofei
     */
    public static final class WechatMinipro {

        public static final String BASE_PHOTOURL = "D;\\photo\\";

    }

    /**
     * 退费业务
     *
     * @author yangxiao
     */
    public static final class Refund {
        /**
         * 0 ：作废
         */
        public static final Integer THE_INVALID = 0;

        /**
         * 1 ;修改
         */
        public static final Integer THE_MODIFY = 1;
    }

    /**
     * 退费修改操作
     *
     * @author yangxiao
     */
    public static final class ModifyOperating {
        /**
         * 0 ：直接修改
         */
        public static final Integer DIRECTLY_MODIFYING = 0;

        /**
         * 1 ;先作废，在新增
         */
        public static final Integer INVALID_CHANGES = 1;
    }

    /**
     * 微信用户绑定状态
     *
     * @author yangxiao
     */
    public static final class WeChatStatus {
        /**
         * 0 ：绑定
         */
        public static final Integer BINDING = 0;

        /**
         * 1 ;解绑
         */
        public static final Integer UNBUNDLING = 1;
    }

    /**
     * 退款方式
     *
     * @author yangxiao
     */
    public static final class RefundPath {
        /**
         * 0 ：现金
         */
        public static final Integer CASH = 0;

        /**
         * 1 ;余额
         */
        public static final Integer BALANCE = 1;

        /**
         * 现金
         */
        public static final String CASH_REFUND = "7c1f197b29824626af0b23d4c57ace94";

        /**
         * 余额
         */
        public static final String BALANCE_REFUND = "6c20ba3083d14309a4aeb6e02306a0d8";
    }

    /**
     * 费用操作类型
     *
     * @author yangxiao
     */
    public static final class OperatingCost {
        /**
         * 0 ：收入
         */
        public static final Integer INCOME = 0;

        /**
         * 1 ;支出
         */
        public static final Integer SPENDING = 1;
    }

    /**
     * 是否已结算
     *
     * @author zhangyao
     */
    public static final class HaveYouSettledTheAccount {
        /**
         * 0 ：否
         */
        public static final Integer NO = 0;

        /**
         * 1 ;是
         */
        public static final Integer YES = 1;
    }

    /**
     * 患者余额管理单据类型
     *
     * @author yangxaio
     */
    public static final class PatFundManagement {

        /**
         * 余额预交款单据
         */
        public static final String PAYMENT_ADVANCE = "b8759eefc7cf4d028a7f07e2948f7b63";

        /**
         * 余额退款单据
         */
        public static final String REFUNDS_ADVANCE = "2606f610c64549ffac562a6a4f0bce52";
    }

    /**
     * 资金操作类型
     *
     * @author yangxiao
     */
    public static final class FundOperation {

        /**
         * 0;收入
         */
        public static final String INCOME = "收入";

        /**
         * 1;支出
         */
        public static final String SPENDING = "支出";
    }

    /**
     * 用床状态
     *
     * @author yangxiao
     */
    public static final class BedStatus {
        /**
         * 0 ：离床
         */
        public static final Integer FROM_BED = 0;

        /**
         * 1 ;用床
         */
        public static final Integer USED_BED = 1;
    }

    /**
     * 入院状态 -1.作废; 0.预约; 1.入院 ; 2.预出院;3.出院已结清;4.出院未结清
     *
     * @author yangxiao
     */
    public static final class AdmissionStatus {
        /**
         * -1.作废
         */
        public static final Integer ABANDONED = -1;
        /**
         * 0.预约
         */
        public static final Integer APPOINTMENT = 0;

        /**
         * 1.入院
         */
        public static final Integer ADMITTED = 1;

        /**
         * 2.预出院
         */
        public static final Integer CAN_OUT_HOSPITAL = 2;

        /**
         * 3.出院已结清
         */
        public static final Integer OUT_HOSPITAL = 3;

        /**
         * 4.出院未结清
         */
        public static final Integer OUT_HOSPITAL_FIELD = 4;

    }

    /**
     * 就诊所属
     *
     * @author yangxiao
     */
    public static final class DoctorBelongs {
        /**
         * 门诊
         */
        public static final String OUTPATIENT_SERVICE = "3abccd3e24e148d6936267b3ccdb3d6f";

        /**
         * 住院
         */
        public static final String IN_HOSPITAL = "53717c579bab49e0b705fa71f4d143b8";
    }

    /**
     * 电子病历模板 状态 0.激活 1.未激活
     *
     * @author yangxiao
     */
    public static final class ElectronicStatus {
        /**
         * 0 ：激活
         */
        public static final Integer ACTIVATION = 0;

        /**
         * 1 ;未激活
         */
        public static final Integer NOT_ACTIVATION = 1;
    }

    /**
     * 病历状态
     *
     * @author yangxiao
     */
    public static final class MedicalCondition {
        /**
         * 0 ：有效
         */
        public static final Integer EFFECTIVE = 0;

        /**
         * 1 ;作废
         */
        public static final Integer THE_INVALID = 1;
    }

    /**
     * 模板标示 0： 通用模板 1：个性化模板 2：基础模板
     *
     * @author yangxiao
     */
    public static final class GenericVersion {
        /**
         * 0 ：通用模板
         */
        public static final Integer GENERAL = 0;

        /**
         * 1 ：个性化模板
         */
        public static final Integer NOT_GENERAL = 1;

        /**
         * 2 ：基础模板
         */
        public static final Integer BASICS = 2;
    }

    /**
     * 药品操作权限
     *
     * @author Administrator
     */
    public static final class DrugAuthority {

        public static final String NO_POWER = "药品无权限";
    }

    /**
     * 账单状态
     *
     * @author Administrator
     */
    public static final class COSTBILLS {

        /**
         * 未结算
         */
        public static final Integer CREATE = 2;

        /**
         * 作废
         */
        public static final Integer ABANDONED = 3;

        /**
         * 已结算
         */

        public static final Integer FINISH = 1;

        /**
         * 账单下收费是否可拆分收费 0 不可以
         */
        public static final Integer NO_BREAKUP = 0;

        /**
         * 账单下收费是否可拆分收费 1 可以
         */
        public static final Integer IS_BREAKUP = 1;
    }

    /**
     * 项目类型
     */
    public static final class FeeType {

        /**
         * 项目类型父级
         */
        public static final String ZORE = "87c3195801944e96a6b8f8e2ee57e413";
        /**
         * 其他
         */
        public static final String OTHER = "87c3195801944e96a6b8f8e2ee57e431";
        /**
         * 西药
         */
        public static final String WEST = "d1dcc1499cb244b9a6bfa858e1a70dcc";
        /**
         * 中药
         */
        public static final String EAST = "41660a587c764355b42b76dcf0cdd0e2";
        /**
         * 中成药
         */
        public static final String CNAP = "41660a587c764355b42b76dcf0cdd0bd";
        /**
         * 药品
         */
        public static final String ONE = "87c3195801944e96a6b8f8e2ee57e417";
        /**
         * 诊疗
         */
        public static final String TWO = "98d3b0eedd0d48088a9a4dacf7fff9d6";
        /**
         * 材料
         */
        public static final String THREE = "d486e1b45f3c4c349ecb508dba57764a";
        /**
         * 检查
         */
        public static final String FOUR = "288dac6e31c54dff8acbf6afb7ba1665";
        /**
         * 检验
         */
        public static final String FIVE = "288dac6e31c54dff8acbf6afb7ba1666";
        /**
         * 手术
         */
        public static final String SIX = "288dac6e31c54dff8acbf6afb7ba1667";
        /**
         * 用血
         */
        public static final String SEVEN = "288dac6e31c54dff8acbf6afb7ba1668";

        /**
         * 西药处方
         */
        public static final String EIGHT = "288dac6e31c54dff8acbf6afb7ba1669";

        /**
         * 西药处方详情
         */
        public static final String NINE = "288dac6e31c54dff8acbf6afb7ba1670";

        /**
         * 中药处方
         */
        public static final String TEN = "288dac6e31c54dff8acbf6afb7ba1671";
        /**
         * 中药处方详情
         */
        public static final String ELEVEN = "288dac6e31c54dff8acbf6afb7ba1672";
        /**
         * 发药单
         */
        public static final String TWELVE = "288dac6e31c54dff8acbf6afb7ba1673";

        /**
         * 护理
         */
        public static final String FOURTEEN = "288dac6e31c54dff8acbf6afb7ba1674";

        /**
         * 病况
         */
        public static final String FIFTEEN = "288dac6e31c54dff8acbf6afb7ba1675";
        /**
         * 发药单详情
         */
        public static final String SIXTEEN = "288dac6e31c54dff8acbf6afb7ba1677";
        /**
         * 收费详情
         */
        public static final String SEVENTEEN = "288dac6e31c54dff8acbf6afb7ba1678";
        /**
         * 收费列表
         */
        public static final String EIGHTEEN = "288dac6e31c54dff8acbf6afb7ba1634";
        /**
         * 收费账单
         */
        public static final String NINETEEN = "288dac6e31c54dff8acbf6afb7ba1635";

    }

    /**
     * 用药途径常量类
     */
    public static final class DrugAndUseUsag_CONST {
        /**
         * 用药途径总父级
         */
        public static final String TYPE = "92a5efcb7e4e4ef9806993f93553ef2b";
    }

    /**
     * 医嘱常量类
     *
     * @author DengXiang 2018年3月22日
     */
    public static final class DoctorAdviceF {

        /**
         * 西药类别
         */
        public static final String CLASS_WEST = "876ddd74cbf84f9b914c6ba8956ead43";

        /**
         * 中药类别
         */
        public static final String CLASS_EAST = "d70aafb6a7d84e8c8025e896c920f704";

        /**
         * 中成药类别
         */
        public static final String CLASS_CNPA = "5d316c9a59b4407db310dffcd4ac0d7b";

        /**
         * 检查
         * <p>
         * 检查医嘱(医嘱类型)
         */
        public static final String CHECK_DOCTOR_ADVICE = "4e95e17740238321098428e";
        /**
         * 检验医嘱(医嘱类型)
         */
        public static final String TEST_DOCTOR_ADVICE = "70e84519e4e5644773951";

        /**
         * 手术医嘱(医嘱类型)
         */
        public static final String SURGERY_DOCTOR_ADVICE = "cf91a0ee42e847398b77e226d812cada";
        /**
         * 诊疗处置(材料,护理,病况)处置(医嘱类型)
         */
        public static final String TREATMENT_DOCTOR_ADIVCE = "cf91a0ee42e847398b77e226d812cadb";

        /**
         * 出院医嘱(医嘱事件)
         */
        public static final String OUT_HOSPITAL_DOCTOR_ADVICE = "8aad3942c4ab4bcf933fae4b4f47ff4c";

        /**
         * 死亡医嘱(医嘱事件)
         */
        public static final String DEATH_DOCTOR_ADVICE = "baca21e7a12d40bc913958fd0bb3cc8c";

        /**
         * 输血医嘱(医嘱事件)
         */
        public static final String TRANSFUSION_DOCTOR_ADVICE = "e0fc1443c5464b5d818037b91005a9af";
        /**
         * 用血医嘱
         */
        public static final String DOCTOR_ADVICE_BOOLD = "a256e47c33cd4685adb404a38dd843e5";

        /**
         * 检查(医嘱类型)
         */
        public static final String CLASS_CHECK = "4e95e17740238321098428e";

        /**
         * 检验(医嘱类型)
         */
        public static final String CLASS_TEST = "70e84519e4e5644773951";

        /**
         * 嘱托(医嘱类型)
         */
        public static final String ENTRUST_DOCTOR_ADVICE = "e8682e560444269960e62265";

        /**
         * 长期医嘱状态
         */
        public static final Integer LONG_TERM = 0;

        /**
         * 临时医嘱状态
         */
        public static final Integer TEMP_TERM = 1;

        /**
         * 长期医嘱
         */
        public static final String LONG_TERM_DOCTORADVICE = "dc281e8b64ad41d5aa8742929327cf46";

        /**
         * 临时医嘱
         */
        public static final String TEMPORARY_TERM_DOCTORADVICE = "9c56cd2fa99f463d866f089370f5192d";

        /**
         * 0.已录入
         */
        public static final Integer DOCTORADVICE_STATUES_ENTERING = 0;

        /**
         * 1.已审核
         */
        public static final Integer DOCTOR_ADVICE_STATUES_EXAMINE = 1;

        /**
         * 2.已提交
         */
        public static final Integer DOCTOR_ADVICE_STATUES_SUBMIT = 2;

        /**
         * 3.已校对
         */
        public static final Integer DOCTOR_ADVICE_STATUES_PROOF = 3;

        /**
         * 4.已取消
         */
        public static final Integer DOCTOR_ADVICE_STATUES_CANCEL = 4;

        /**
         * 5.已停止
         */
        public static final Integer DOCTOR_ADVICE_STATUES_STOP = 5;
        /**
         * 6.待停止
         */
        public static final Integer DOCTOR_ADVICE_STATUES_TOSTOP = 6;
        /**
         * 7.已作废
         */
        public static final Integer DOCTOR_ADVICE_STATUES_INVALID = 7;
        /**
         * 8.已执行
         */
        public static final Integer DOCTOR_ADVICE_STATUES_EXECUTE = 8;

        /**
         * 0.不备用
         */
        public static final Integer NOT_STANDBY_APPLICATION = 0;

        /**
         * 1.备用
         */
        public static final Integer YES_STANDBY_APPLICATION = 1;

        /**
         * 医嘱类别
         */
        public static final String DOCTOR_ADVICE_CATEGROY = "467f642f80e3424cbddcd2d63f8c82cf";

        /**
         * 西药频次
         */
        public static final String DRUG_FREQUENCY = "f54b14ee2ba74e2c9fd86023d31d132c";

        /**
         * 中药频次
         */
        public static final String CHDRUG_FREQUENCY = "6692aa6fcc2c4c08b2ba43e690251160";

        /**
         * 中成药频次(目前和西药一致)
         */
        public static final String CNPA_FREQUENCY = "6692aa6fcc2c4c08b2ba43e690251160";

        /**
         * 手术频次
         */
        public static final String SURGERY_FREQUENCY = "bde65a3e3de14a7eac60fa4ceb7010a7";

        /**
         * 用血频次
         */
        public static final String BLOOD_FREQUENCY = "3446d6cf1cfd4af78b0d3b65a25c0d77";

        /**
         * 检查频次
         */
        public static final String CHECK_FREQUENCY = "92cf86ad10a745eab1e5734ab1f6fda4";

        /**
         * 检验频次
         */
        public static final String TEST_FREQUENCY = "acbae54214a2437ba6c4edcde7992e8b";

        /**
         * 中药煎法
         */
        public static final String WEST_DECOCTION = "f1138a806cdf4f9da19c9b6d0218d9ff";

        // 手术医嘱是否启用
        /**
         * 0.启用
         */
        public static final Integer SURGERY_ITEM_ENABLED = 0;

        /**
         * 1.未启用
         */
        public static final Integer SURGERY_ITEM_UNENABLED = 1;

        /**
         * 输血品种
         */
        public static final String TRANBLOOD_BREED = "2f96e02b8486411eada728f007643a8f";

        /**
         * 用血类型
         */
        public static final String NEEDTRAN_TYPE = "309f26ab88994ef2bfa787687760a065";

        /**
         * 输血途径
         */
        public static final String TRANBLOOD_ROAD = "0c15a0f0fb0a4a84abd127505a566389";

        /**
         * 输血方式
         */
        public static final String TRANBLOOD_WAY = "3db8f1942e84a339bd3eaa54c6b4242";

        /**
         * 输血科室
         */
        public static final String TRANBLOOD_WORKING = "56397fc97b374c75b8c379015a40531e";

        /**
         * 输血频率
         */
        public static final String TRANBLOOD_FREQUENCY = "f54b14ee2ba74e2c9fd86023d31d132c";

        /**
         * 补录医嘱天数
         */
        public static final long RECORD_DAY_NUMBER = 5l;

        /**
         * 医嘱画线 0 否
         */
        public static final Integer DOCTOR_ADVICE_LINDRA_NO = 0;

        /**
         * 医嘱画线 1 是
         */
        public static final Integer DOCTOR_ADVICE_LINDRA_YES = 1;

        /**
         * 已校对
         */
        public static final Integer DOCTORADVICE_HAS_PROOF = 1;

        /**
         * 未校对
         */
        public static final Integer DOCTORADVICE_NO_PROOF = 0;
    }

    /**
     * 分包常量类
     *
     * @author zhangyao
     */
    public static final class SubcontractType {

        /**
         * 检查(分包类型)
         */
        public static final String CHECK = "a7717cf5161948d69ae4cb6f00d01495";

        /**
         * 检验(分包类型)
         */
        public static final String INSPECTION = "bbaba99709b444ccbab21e47c7259c66";

        /**
         * 诊疗(分包类型)
         */
        public static final String TREATMENT = "a91b0d3816d04df9ac39f6f6564b4957";

        /**
         * 手术(分包类型)
         */
        public static final String SURGERY = "c09155497a82472f8df048549e6f7093";

    }

    /**
     * 医嘱类型常量类
     *
     * @author zhangyao
     */
    public static final class DoctorAdviceTypeF {
        /**
         * 不管
         */
        public static final Integer STOP_OTHER_ADVICE_NOMATTER = 0;
        /**
         * 是
         */
        public static final Integer STOP_OTHER_ADVICE_YES = 1;
        /**
         * 否
         */
        public static final Integer STOP_OTHER_ADVICE_ON = 2;
        /**
         * 强制是
         */
        public static final Integer STOP_OTHER_ADVICE_FORCEIS = 3;
        /**
         * 强制否
         */
        public static final Integer STOP_OTHER_ADVICE_FORCESTODENY = 4;
    }

    /**
     * 临床路径配置常量类
     */
    public static final class ClinicalPathwayConfig_TYPE {
        /**
         * 待审核(创建) 0
         */
        public static final Integer CREATE = 0;

        /**
         * 启用 1
         */
        public static final Integer START_USE = 1;
        /**
         * 停用 2
         */
        public static final Integer STOP_USE = 2;
    }

    /**
     * 临床路径常量类
     */
    public static final class ClinicalPathway_TYPE {
        /**
         * 启用 0
         */
        public static final Integer START_USE = 0;
        /**
         * 停用 1
         */
        public static final Integer STOP_USE = 1;
    }

    /**
     * 变异评估结果常量类
     *
     * @author yanghaiyong
     */
    public static final class Assessment_TYPE {
        /**
         * 存在变异,继续本阶段治疗
         */
        public static final String ONE_REASON = "f96eb00d591311e8b441060400ef5315";
        /**
         * 进入下阶段治疗
         */
        public static final String TWO_REASON = "11088e37591411e8b441060400ef5315";
        /**
         * 存在变异,不适合当前路径,退出路径
         */
        public static final String THREE_REASON = "2b3d657f591411e8b441060400ef5315";
    }

    /**
     * 非变异评估结果常量类
     *
     * @author yanghaiyong
     */
    public static final class Not_Assessment_TYPE {
        /**
         * 阶段进行正常,进入下一阶段治疗
         */
        public static final String ONE_REASON = "a5ccfa81591311e8b441060400ef5315";
        /**
         * 完成所有路径阶段治疗
         */
        public static final String TWO_REASON = "b722d355591311e8b441060400ef5315";
    }

    /**
     * 医嘱类型常量类
     *
     * @author yanghaiyong
     */
    public static final class DoctorAdvice_TYPE {
        /**
         * 禁用
         */
        public static final Integer UNENABLE = 0;

        /**
         * 启用
         */
        public static final Integer ENABLE = 1;
    }

    /**
     * 患者路径阶段状态
     *
     * @author yanghaiyong
     */
    public static final class StageStatus_TYPE {
        /**
         * 正在治疗
         */
        public static final Integer TREATMENTING = 0;

        /**
         * 完成
         */
        public static final Integer FINISHED = 1;
    }

    /**
     * 证件类型
     *
     * @author yangxiao
     */
    public static final class DocumentType {
        /**
         * 身份证
         */
        public static final String ID_CARD = "973ff00ba3da49d9b1eaff06f1e79845";
        /**
         * 就诊卡
         */
        public static final String PATIENT_CARD = "14ead4ee463848c5b2ee77c2c923411a";
        /**
         * 军官证
         */
        public static final String SOLDIER_CARD = "0620d7bfae184467acb5406b975c1380";

        /**
         * 院内卡
         */
        public static final String IN_THE_CARD = "12ecb3daeb4c4f348d746e8327e94efd";
    }

    public static final class ClinicType {
        /**
         * 普卡
         */
        public static final String ORDINARY = "214dffd595594ef7ae41407548b5f5f5";
    }

    /**
     * 电子病历树结构高级查询排序方式
     * <p>
     * 0;患者姓名排序 1：入院时间排序 2;床号排序
     *
     * @author yangxiao
     */
    public static final class MedicalRecordsSorting {

        /**
         * 0;患者姓名排序
         */
        public static final Integer PATIENT_NAME = 0;

        /**
         * 1：入院时间排序
         */
        public static final Integer ADMISSION_TIME = 1;

        /**
         * 2;床号排序
         */

        public static final Integer BED_NUMBER = 2;
    }

    /**
     * 患者电子病历词条查询范围
     *
     * @author yangxiao
     */
    public static final class EmrEnquiryRange {
        /**
         * 0;医生个人
         */
        public static final Integer PERSONAL = 0;

        /**
         * 1：当前科室
         */
        public static final Integer ALL_DEPARTMENTS = 1;
    }

    /**
     * 药房类型
     */
    public static final class DrugWareHouseType {
        /**
         * 中药仓库
         */
        public static final String EAST_HOUSE = "1bf727945f9c413f8c56934086cfa5f0";

        /**
         * 门诊外科小仓库
         */
        public static final String WESTERN_HOUSE = "72C1F1D0711945F0E050007F0100539B";

        /**
         * 中成药仓库
         */

        public static final String PATENT_HOUSE = "1b9987ac830142a1bc323dd7f93e592d";

        /**
         * 临床仓库
         */
        public static final String CLINICAL_HOUSE = "01ff5ebd975b4c2dbe04f116c84e4296";

    }

    /**
     * 词条适用范围
     */
    public static final class EntryApplyScope {
        /**
         * 本人
         */
        public static final String SELF = "6a9a9d9b1ecf452e854eb24c01eeb0a7";

        /**
         * 本科室
         */
        public static final String OUR_DEPARTMENT = "70659d7265df472eaa9a524f98e72886";

        /**
         * 查询全部
         */
        public static final String ALL_ENTRY = "0";

        /**
         * 词条适用范围
         */
        public static final String SCOPE_ENTRY = "863e98ba40eb4a158fef0ad00ff148b4";
    }

    /**
     * 处方详情
     */
    public static final class PrescriptionDetail {

        /**
         * 处置类型
         */
        public static final class DisposalType {

            /**
             * 执行性质
             */
            public static final String DISPOSALTYPE_ID = "fa73c863aa924b84b2948230b00078f7";

            /**
             * 正常
             */
            public static final String NORMAL = "18699e551559404888890d6c4c3e3f3d";
            /**
             * 自备药
             */
            public static final String SELF_DRUG = "9cecc19787a04b7d864e74c57a50d13c";
            /**
             * 离院带药
             */
            public static final String AWAY_DRUG = "18699e551559404888890d6c4c3e3f3d";

            /**
             * 自取药
             */
            public static final String SELFGET_DRUG = "337bfa7a5f1040abaaade1b349f6958f";

        }

        /**
         * 检查检验
         *
         * @author DengXiang 2018年3月30日
         */
        public static final class CheckTest {

            /**
             * 检验申请单紧急状态
             */
            public static final class TestIsUrgency {
                /**
                 * 0 不紧急
                 */
                public static final Integer NO_URGENCY = 0;

                /**
                 * 1 紧急
                 */
                public static final Integer YES_URGENCY = 1;
            }

            /**
             * 样本送样单接收状态
             */
            public static final class SampleSheetAndDetails {

                /**
                 * 0,未接受
                 */
                public static final Integer UNACCEPTED = 0;

                /**
                 * 1,已接收
                 */
                public static final Integer ACCEPTED = 1;

                /**
                 * 2,拒收
                 */
                public static final Integer REJECTION = 2;
            }

            /**
             * 1.已发送
             */
            public static final Integer HAS_BEEN_SENT = 1;
            /**
             * 2.已作废
             */
            public static final Integer HAS_BEEN_CANCEL = 2;
            /**
             * 3.已完成
             */
            public static final Integer HAS_BEEN_FINISH = 3;
            /**
             * 4.已新建
             */
            public static final Integer HAS_BEEN_NEW = 4;
            /**
             * 5.未接收
             */
            public static final Integer UNRECEIVED = 5;

            // 检验 检查项目状态
            /**
             * 0.启用
             */
            public static final Integer PROJECT_ENABLED = 0;

            /**
             * 1.停用
             */
            public static final Integer PROJECT_STOPPED = 1;
            /**
             * 检查检验申请单： 0 新建
             */
            public static final Integer APPLY_NEW = 0;
            /**
             * 检查检验申请单： 1 提交
             */
            public static final Integer APPLY_SUBMIT = 1;
            /**
             * 检查检验申请单： 2 通过
             */
            public static final Integer APPLY_PASS = 2;
            /**
             * 检查检验申请单：3 未通过
             */
            public static final Integer APPLY_NOTPASS = 3;

        }
    }

    /**
     * 电子病历模板适用性别
     *
     * @author yangxiao
     */
    public static class TemplateSex {

        /**
         * 男
         */
        public static final String MAN = "1f14b01fa650400292068f5fad030a07";

        /**
         * 女
         */
        public static final String WEMAN = "c3a2b24400ec46d1aa6fbe70c2d702b1";

        /**
         * 女/男
         */
        public static final String MAN_WEMAN = "46bf165d2a624e40a580f174dc02cb20";

    }

    public static class Assert {

        /**
         * 報失
         */
        public static final String ASSERT_LOSS = "e4ba593c22f64feb94acb3b753a965d7";

        /**
         * 維修
         */
        public static final String ASSERT_REPAIR = "f402d06371bf4556afa283ea54724844";

        /**
         * 折舊
         */
        public static final String ASSERT_DEPRECIATION = "22d2f85fe97a4ca79bd3f703115ddea2";
    }

    /**
     * 电子病历适用频次
     *
     * @author yangxiao
     */
    public static class FrequencyUsage {

        /**
         * 0.多次使用
         */
        public static final Integer MORE_USE = 0;

        /**
         * 1.单次使用
         */
        public static final Integer SINGLE_USE = 1;

    }

    /**
     * 电子病历 与医嘱相关是否，书写频次限制 0：多次 1：单次
     *
     * @author yangxiao
     */
    public static class AdvFreUsage {

        /**
         * 0.多次使用
         */
        public static final Integer MORE_USE = 0;

        /**
         * 1.单次使用
         */
        public static final Integer SINGLE_USE = 1;
    }

    /**
     * 电子病历互斥状态
     *
     * @author yangxiao
     */
    public static class MutexStatus {

        /**
         * 0.否
         */
        public static final Integer NOT_MUTEX = 0;

        /**
         * 1.是
         */
        public static final Integer MUTEX = 1;

    }

    /**
     * 病案首页 状态 0.激活 1.未激活
     *
     * @author yangxiao
     */
    public static final class MrhpTemplateStatus {
        /**
         * 0 ：激活
         */
        public static final Integer ACTIVATION = 0;

        /**
         * 1 ;未激活
         */
        public static final Integer NOT_ACTIVATION = 1;
    }

    /**
     * 不良事件状态 0.激活 1.未激活
     *
     * @author Guoqing
     */
    public static final class AreTemplateStatus {
        /**
         * 0 ：激活
         */
        public static final Integer ACTIVATION = 0;

        /**
         * 1 ;未激活
         */
        public static final Integer NOT_ACTIVATION = 1;

        /**
         * 有效
         */
        public static final Integer EFFECTIVE = 0;

        /**
         * 作废
         */
        public static final Integer NOT_EFFECTIVE = 1;
    }

    /**
     * 0.未处理 1.已处理
     */
    public static final class AreStorageArchiveStatus {

        /**
         * 0 ：未处理
         */
        public static final Integer NOT_HANDLE = 0;
        /**
         * 1 ：已处理
         */
        public static final Integer YET_HANDLE = 1;
    }

    /**
     * 体温单常量类
     */
    public static final class Temperature {
        /**
         * 体温类型
         */
        public static final String TEMPER_TYPE = "0a70689a73874e5496ce29bed064d86c";

        /**
         * 护理事件
         */
        public static final String NURSE_EVENT = "88c511d80fa048588d5ed480a9148bf6";

        /**
         * 护理事件手术
         */
        public static final String NURSE_EVENT_SURGERY = "1dfc9b03e05f4bf9a5aa8fe4e3fd6691";

        /**
         * 护理事件分娩
         */
        public static final String NURSE_EVENT_CHILDBIRTH = "4187d47547ba4f9786092547fbbb06cf";
        /**
         * 护理备注
         */
        public static final String NURSE_MARK = "d4808861ad2a4b259c95a80cab105d71";
    }

    /**
     * 三测单
     */
    public static final class ThreeTets {
        /**
         * 查询三测单天数
         */
        public static final Integer pageNum = 7;

    }

    /**
     * 卫材单据
     *
     * @author zhangbin
     */
    public static final class EisaiReceipts {

        /**
         * 卫材类型(供应商)
         */
        public static final String EISAI_SUPTYPE = "2952c30a0a584eff8c228e99e3321f7b";

        public static class ReceiptConfig {

            public static class ReceiptSort {
                /**
                 * 出库
                 */
                public static final String LIBRARY_ID = "82fde19ea53048e4b2677a8069370efc";

                /**
                 * 盘点
                 */
                public static final String INVENTORY_ID = "7473c04b7fdf452886fc3b4f03687fc0";

                /**
                 * 入库
                 */
                public static final String STORAGE_ID = "a6429a96f4d64141bcbe89d26da2456e";

                /**
                 * 拆分
                 */
                public static final String SPLIT_ID = "50274898d7714a01a188944ca948efb3";
            }

        }

    }

    /**
     * 病历归档操作方式
     */
    public static final class ArchivesOperate {
        /**
         * 归档
         */
        public static final String ARCHIVES = "c1dd6f9a66c64aa7b176d64ed38326cc";
        /**
         * 取消归档
         */
        public static final String CANCEL_ARCHIVES = "7c1f197b29824626af0b23d4c57ace94";

    }

    /**
     * 归档状态 0.归档 1.未归档
     *
     * @author yangxiao
     */
    public static final class ArchivesStatus {
        /**
         * 0 ：未归档
         */
        public static final Integer NOT_ACTIVATION = 0;

        /**
         * 1 ;已归档
         */
        public static final Integer ACTIVATION = 1;
    }

    /**
     * 质控评分状态 0.未评分 1.已评分
     *
     * @author yangxiao
     */
    public static final class QualityControlStatus {
        /**
         * 0 ：未评分
         */
        public static final Integer NOT_SCORE = 0;

        /**
         * 1 ;已评分
         */
        public static final Integer HAS_SCORE = 1;
    }

    /**
     * 质控总分数、 质控等级
     *
     * @author yangxiao
     */
    public static final class QualityTotalScore {
        /**
         * 质控总分 100
         */
        public static final Integer TOTALSCORE = 100;

        /**
         * 甲级
         */
        public static final String CLASS_A = "甲级";

        /**
         * 乙级
         */
        public static final String CLASS_B = "乙级";

        /**
         * 丙级
         */
        public static final String CLASS_C = "丙级";

        /**
         * 甲级
         */
        public static final String CLASS_A_ID = "48e9d6a8341640f59e38300de146ae6f";

        /**
         * 乙级
         */
        public static final String CLASS_B_ID = "f3dd00491d2843a193317165a6162c5c";

        /**
         * 丙级
         */
        public static final String CLASS_C_ID = "ff0634d60d7b4a17aa2e27e0dc7a2cbf";

        /**
         * 模板ID
         */
        public static final String QUALITY_SCORE_TEMPLATE = "5ad5c782f7f50d01c8a20ef8";

        /**
         * 单项否决
         */
        public static final String LINE_ITEM = "单项否决";
    }

    /**
     * 通用字典表
     *
     * @author Guoqing
     */
    public static final class GeneralDictionaryType {

        /**
         * 医疗付款方式代码
         */
        public static final String MEDICAL_PAYMENT_CODE = "e868d634946f54979df7e26095b9671a";

        /**
         * 是否
         */
        public static final String WHETHER_OR_NOT = "083750725ef752dcae4737b7915abc01";

        /**
         * 实施临床路径
         */
        public static final String IMPLEMENT_CLINIC_PATHWAY = "032727b5bf605ffe95faadebaed85d4d";

        /**
         * 变异原因
         */
        public static final String MUTATION_CAUSES = "019b8f4833605970948fa7baaf757e5a";

        /**
         * 性别代码
         */
        public static final String GENDERSEX_CODE = "18ba4efc8faa5ae7b2ad3e0d2f9516bd";

        /**
         * 性别ID
         *
         * @author gongliang 2018-9-26
         */
        public static final class Sex {
            /**
             * 男
             */
            public static final String MAN = "a506b0019b1958d29d81eb543ceeee2b";
            /**
             * 女
             */
            public static final String WOMAN = "0fb894bba0e2566e8f2c962b31058e55";
            /**
             * 未知的性别
             */
            public static final String UNKNOWN = "c16f2b77142c539ba28bc06200ca0064";
            /**
             * 未说明的性别
             */
            public static final String UNSPECIFIED = "b85163692ff7513bbbfe92b82bffe087";
        }

        /**
         * 职业代码
         */
        public static final String PROFESSIONAL_CODE = "c4fc507fe6d65e86af239dd624967f18";

        /**
         * 婚姻状况代码
         */
        public static final String MARITAL_STATUS = "de227fd93652526d9d26fad808926891";

        /**
         * 联系人关系代码
         */
        public static final String CONTACT_RELATION = "f0d517b9787553b181a32c2779a3b4d0";

        /**
         * 入院途径
         */
        public static final String HOSPITAL_WAY = "5dd27a45fc5a5afb95403669e06f9b1e";

        /**
         * 治疗类别
         */
        public static final String TREATMENT_CATEGORIES = "797cc62e4655539c87ca2977b094bb11";

        /**
         * 入院病情代码
         */
        public static final String ADMISSION_CONDITION = "fef8621ec82355e688e786d4f25c91ae";

        /**
         * 入院情况
         */
        public static final String ADMISSION_IS = "99dc102950b957ffb14e6bebc12a0536";

        /**
         * 出院情况
         */
        public static final String OUTHOSPITAL_IS = "d86220a7a0a55082adb9309167f753a6";

        /**
         * 血型编码
         */
        public static final String BLOOD_TYPE_CODE = "a2c2fa5b4fa452ef98fc552c5d29b436";

        /**
         * TNM分期
         */
        public static final String TNM_STAGING = "540ae259f0c651a29c4e0ceb4fb41661";

        /**
         * Rh
         */
        public static final String RH = "9701d17edd1b5bb1b6de41ecc0e29b0f";

        /**
         * 病案质量
         */
        public static final String QUALITY_TNM_CASE = "222812d996d7563784f575213f217100";

        /**
         * 手术级别
         */
        public static final String OPERATION_LEVEL = "96ae683064b05146bbe6cf21a98ca36a";

        /**
         * 切口类别
         */
        public static final String INCISION_CATEGORY = "221f8b941aa854269d12b8732e3c0809";

        /**
         * 切口愈合级别
         */
        public static final String NOTCH_HEALING_GRADE = "4c0a52e5957c562e88a1f2b8e25dd198";

        /**
         * 麻醉方式代码
         */
        public static final String ANESTHESIA = "38a9c367a8335da0837b67c1e17b257e";

        /**
         * 离院方式
         */
        public static final String DEPARTURE_OUTHOSPITAL_WAY = "89d00b269b4e560bab5166dca02b4ba9";

        /**
         * 药物过敏
         */
        public static final String DRUG_ALLERGY = "2f22d7cee9525a67ac83926403e2564f";

        /**
         * 血库作废原因
         */
        public static final String BLOOD_INVALID_REASON = "1baa39b0937a41a49404dd54346ec332";

    }

    /**
     * 国籍民族字典表
     *
     * @author Guoqing
     */
    public static final class NationAndNationalityType {

        /**
         * 国籍
         */
        public static final String NATION = "0329e16974924e35b1d386c6c72d1af1";

        /**
         * 民族
         */
        public static final String NATIONALITY = "a99842ec9cfd4981b333aa1ddab4f8d8";
    }

    /**
     * 血液相关
     *
     * @author DengXiang 2018年5月2日
     */
    public static final class BloodConstant {

        /**
         * 0.血袋样本
         */
        public static Integer BLOOD_SAMPLE_TYPE_BLOOD = 0;

        /**
         * 1.病人样本
         */
        public static Integer BLOOD_SAMPLE_TYPE_PATIEN = 1;

        /**
         * 抗体筛选 检查
         */
        public static Integer USEBLOOD_ANTSCR_CHECK = 1;

        /**
         * 抗体筛选 复检
         */
        public static Integer USEBLOOD_ANTSCR_RECHECK = 2;

        /**
         * 复核表 检查
         */
        public static Integer USEBLOODRECHECK_CHECK = 1;

        /**
         * 复核表 复检
         */
        public static Integer USEBLOODRECHECK_RECHECK = 2;

        /**
         * 血库库存; 1.已备用
         */
        public static Integer BLOODSTOCK_ISRESERVE = 1;

        /**
         * 血库库存; 0.未备用
         */
        public static Integer BLOODSTOCK_INOTRESERVE = 0;

        /**
         * 必须交叉配血;0.否
         */
        public static Integer NOT_CROSS_BLOOD = 0;

        /**
         * 必须交叉配血;1.是
         */
        public static Integer IS_CROSS_BLOOD = 1;

        /**
         * 允许自备血;0.否
         */
        public static Integer NOT_AUTO_BLOOD = 0;

        /**
         * 允许自备血;1.是
         */
        public static Integer IS_AUTO_BLOOD = 1;

        /**
         * 血液登记状态：0.已新建
         */
        public static Integer BLOOD_REGISTER_HAS_NEW = 0;

        /**
         * 血液登记状态：1.已审核
         */
        public static Integer BLOOD_REGISTER_THE_APPROVED = 1;
        /**
         * 血液登记状态： 2.已作废
         */
        public static Integer BLOOD_REGISTER_THE_INVALID = 2;

        /**
         * 血液登记配置出库
         */
        public static String BLOOD_REGISTER_PLACE = "b2fe9a580e63455796397c50280c8dfa";

        /**
         * 血液登记配置入库
         */
        public static String BLOOD_REGISTER_STORE = "8f172230a00340bb98d8d3f715c84113";
        /**
         * 血液状态：1.启用
         */
        public static Integer BLOOD_ENABLED = 1;
        /**
         * 血液状态： 0.未启用
         */
        public static Integer BLOOD_NOT_ENABLED = 0;

        /**
         * 血液库存状态： 0.无
         */
        public static Integer BLOOD_STOCK_NOT_REPERTOR = 0;
        /**
         * 血液库存状态：1.有
         */
        public static Integer BLOOD_STOCK_IS_REPERTORY = 1;

        /**
         * 血库盘点单据配置
         */
        public static String BLOOD_INVENTORY_CONFIGURATION = "83e394390baf45428ab1fcd6881a46fd";

        /**
         * 血库盘点单据配置id
         */
        public static String BLOOD_INVENTORY_CONFIGURATION_ID = "b62b8b65f0c3464daf2288a643024b6c";

        /**
         * 血库作废登记单配置id
         */
        public static String BLOOD_INVALID_CONFIGURATION_ID = "f3213e0cd4b14247b1323cb47f9cd404";

        /**
         * 血库出库登记单配置id
         */
        public static String BLOOD_OUTWARE_CONFIGURATION_ID = "8f1e4cd23cb749a9bec4ce221216fed2";

        /**
         * 自体血入库单据配置Id
         */
        public static String SELF_BLOOD_STORE_CONFIGURATION_ID = "b33e8f3a9602413a81a80e6af49c69da";

        /**
         * 血库
         */
        public static String BLOOD_STORAGE_STOCK = "5bb21a336fe74f44b7e8e4d13b9a225b";

        /**
         * 血库作废单据配置
         */
        public static String BLOOD_INVALID_CONFIGURATION = "2ec880bbc88c414a88bb4e8ebcb7305b";

        /**
         * 患者类型; 0.本院
         */
        public static Integer THIS_HOSPITAL = 0;
        /**
         * 患者类型; 1.外院
         */
        public static Integer OUTER_HOSPITAL = 1;

        /**
         * 输血史： 1.有
         */
        public static Integer HAVE_TRANSFUSE_HISTORY = 1;

        /**
         * 输血史： 0.无
         */
        public static Integer NOT_TRANSFUSE_HISTORY = 0;

        /**
         * 妊娠史： 0.否
         */
        public static Integer IS_GESTATION = 0;
        /**
         * 妊娠史： 1.是
         */
        public static Integer NOT_IS_GESTATION = 1;

        /**
         * 属地：0.本地
         */
        public static Integer THIS_LOCALITY = 0;
        /**
         * 属地：1.外埠
         */
        public static Integer OTHER_CITIES = 1;

        /**
         * 血液检验：0.未检
         */
        public static Integer NOT_DETECTED_BLOOD_TESTS = 0;
        /**
         * 血液检验：1.结果未出
         */
        public static Integer RESULTS_NOT_BLOOD_TESTS = 1;
        /**
         * 血液检验：2.阳性
         */
        public static Integer MASCULINE_GENDER_BLOOD_TESTS = 2;
        /**
         * 血液检验：3.阴性
         */
        public static Integer FEMININE_GENDER_BLOOD_TESTS = 3;

        /**
         * 病人类型
         */
        public static String PATIENT_TYPE = "c38280b7a87140129cccec881d159fb8";

        /**
         * 病人类型：住院
         */
        public static String PATIENT_TYPE_HOSPITAL = "923e782ded144bf1a0e0aff2b067492e";

        /**
         * 用血类型
         */
        public static String USE_TYPE = "00134f43c3d4465d9c3be269887062ad";

        /**
         * 配血方式
         */
        public static String DISTR_WAY = "1be87351f68a4822be85da9a7d46e283";

        /**
         * 用血地点
         */
        public static String USE_PLACE = "4f0baeafe3bc4feeba890b79fbf797b8";

        /**
         * ABO血型父类Id
         */

        public static String ABO_BlOOD_TYPE = "a2c2fa5b4fa452ef98fc552c5d29b436";

        /**
         * RH血型父类Id
         */
        public static String RH_BLOOD_TYPE = "9701d17edd1b5bb1b6de41ecc0e29b0f";

        /**
         * 输血申请单 -已新建
         */
        public static Integer BLOODTRANSFAPPLY_STATUS_CREAT = 0;

        /**
         * 输血申请单 -已审核
         */
        public static Integer BLOODTRANSFAPPLY_STATUS_AUDITED = 1;

        /**
         * 输血申请单 -已接收样本
         */
        public static Integer BLOODTRANSFAPPLY_STATUS_HASBLOODSAMPLE = 2;

        /**
         * 输血申请单 -审核失败
         */
        public static Integer BLOODTRANSFAPPLY_STATUS_INVALID = -1;

        /**
         * 输血申请单 -已作废
         */
        public static Integer BLOODTRANSFAPPLY_STATUS_DELETE = -2;

        /**
         * 输血申请单、复检、配血、发血、采血状态： 1 .是
         */
        public static Integer BLOODTRANSFAPPLY_STATUS_IS = 1;

        /**
         * 输血申请单、复检、配血、发血、采血状态： 0 .否
         */
        public static Integer BLOODTRANSFAPPLY_STATUS_NOT = 0;

        /**
         * 血液样本状态 ;0.过期
         */
        public static Integer BLOOD_SAMPLE_PAST = 0;
        /**
         * 血液样本状态 ;1.正常
         */
        public static Integer BLOOD_SAMPLE_NORMAL = 1;
        /**
         * 血液样本状态 ;-1.销毁
         */
        public static Integer BLOOD_SAMPLE_DESTROY = -1;

        /**
         * 自体血 1
         */
        public static Integer SELF_BLOOD = 1;

        /**
         * 不是自体血 0
         */
        public static Integer SELF_BLOOD_NOT = 0;
        /**
         * 检验方案
         */
        public static String BLOOD_TEST_SCHEME = "648e505b47fe45ac87540b2f015a710b";

        /**
         * 配血方法
         */
        public static String MATCHING_METHOD = "933ebac8558d43de82e68dde7acfb6d4";

        /**
         * 主侧次侧
         */
        public static String BLOOD_TEST_RESULTS = "05eda1081e6242c2a22652d2a94b06aa";

        /**
         * 血袋状态：1.正常
         */
        public static Integer BLOOD_BAG_NORMAL = 1;

        /**
         * 血袋状态：2.过期
         */
        public static Integer BLOOD_BAG_STALE = 2;

        /**
         * 血袋状态：-1.销毁
         */
        public static Integer BLOOD_BAG_DESTROY = -1;

        /**
         * 输血反应所致结果id
         */
        public static String BLOOD_TRANSFREACTION_CAUSE_ID = "600312a11e1944149f8ca7e1e6f1490f";

        /**
         * 配血单的状态 ：创建
         */
        public static Integer BLOOD_APPLY_STOCK_CREAT = 0;

        /**
         * 配血单的状态 ：审核
         */
        public static Integer BLOOD_APPLY_STOCK_AUDIT = 1;

        /**
         * 配血单的状态 ：已发血
         */
        public static Integer BLOOD_APPLY_STOCK_DISTRCT = 2;

        /**
         * 配血单的状态 ：已作废
         */
        public static Integer BLOOD_APPLY_STOCK_INVA = -1;

        /**
         * 备血状态：0.未备血
         */
        public static Integer BLOOD_APPLY_IS_PREPARE_NOT = 0;
        /**
         * 备血状态：1.已备血
         */
        public static Integer BLOOD_APPLY_IS_PREPARE_IS = 1;
        /**
         * 备血状态： 2.完成备血
         */
        public static Integer BLOOD_APPLY_IS_PREPARE_HAS = 2;

    }

    /**
     * 电子病历分类
     *
     * @author yangxiao
     */
    public static final class TemplateClassification {

        /**
         * 新生儿电子病历
         */
        public static final String NEWBORN = "eec8a8ca868a433cb891620ad13e0084";

        /**
         * 新生儿护理电子病历
         */
        public static final String ENRNEWBORN = "57f932399dc54757aefaa06d6365c44e";

        /**
         * 医生电子病历
         */
        public static final String DOCTOR = "261cd75dc94641f28a5c3ca648fc21be";

        /**
         * 护士电子病历
         */
        public static final String NURSE = "92dd3bb5ddff4cdd844dcfb4f020f67b";

        /**
         * 门诊电子病历
         */
        public static final String OMR = "ef9d78b2e3ae45d081e5a812f4f7e664";

        /**
         * 长期医嘱单
         */
        public static final String LONG_ADVICE_SINGLE = "97f9a83636cf4396b95d5427012353a2";

        /**
         * 临时医嘱单
         */
        public static final String TEMP_ADVICE_SINGLE = "e4bbd4204e614b52a1b915355368c08b";

        /**
         * 体温单
         */
        public static final String TEMPERATURE_SINGLE = "f1d1b5f755db4c88bf31d41e34b224bd";

        /**
         * 护理单
         */
        public static final String NURSING_SINGLE = "ce01291a503248029f71d6c018c87839";

        /**
         * 体温单状态
         */
        public static final Integer TEMPERATURE_TERM = 2;

        /**
         * 护理单状态
         */
        public static final Integer NURSING_TERM = 3;

        /**
         * 传染病报卡
         */
        public static final String REPORT_DISEASES_CLASS = "2e584120958c4633adb15defec0fa100";

        /**
         * 电子病历新生儿分类
         */
        public static final String EMR_NEWBORN_CLASS = "d2f8ea1d28b046aca4378d11035b17f7";

        /**
         * 护理病历新生儿分类
         */
        public static final String ENR_NEWBORN_CLASS = "4770f41ea56b4c1fb8fbedbb20fdf3ab";
    }

    /**
     * 病历操作人 0.医生 1.护士
     *
     * @author yangxiao
     */
    public static final class MedicalRecordOperator {
        /**
         * 0. 电子病历
         */
        public static final Integer EMR = 0;

        /**
         * 1. 护理病历
         */
        public static final Integer ENR = 1;

        /**
         * 2. 门诊病历
         */
        public static final Integer OMR = 2;

        /**
         * 医生
         */
        public static final String DOCTOR_NAME = "电子病历";

        /**
         * 护士
         */
        public static final String NURSE_NAME = "护理病历";
    }

    /**
     * 护理病历模板 状态 0.激活 1.未激活
     *
     * @author gongshuai
     */
    public static final class NursingElectronicStatus {
        /**
         * 0 ：激活
         */
        public static final Integer ACTIVATION = 0;

        /**
         * 1 ;未激活
         */
        public static final Integer NOT_ACTIVATION = 1;
    }

    /**
     * 病历分类操作状态 0.可新建 1.无法新建
     *
     * @author yangxiao
     */
    public static final class ClassOperatorStatus {
        /**
         * 0.可新建
         */
        public static final Integer CREAT = 0;

        /**
         * 1.无法新建
         */
        public static final Integer NOT_CREAT = 1;

    }

    /**
     * 护理模板标示 0： 通用模板 1：个性化模板 2：基础模板
     *
     * @author gongshuai
     */
    public static final class NursingGVersion {
        /**
         * 0 ：通用模板
         */
        public static final Integer GENERAL = 0;

        /**
         * 1 ：个性化模板
         */
        public static final Integer NOT_GENERAL = 1;

        /**
         * 2 ：基础模板
         */
        public static final Integer BASICS = 2;

    }

    /**
     * 护理患者类型(在院,出院,入院,转出(科室),转入(科室),死亡(死亡医嘱),一级(护理级别),病危(检查检验),病重(检查检验),昨日手术,今日手术,明日手术,危急值(),特殊交班)
     *
     * @author yanghaiyong
     */
    public static final class NursingPatientType {

        /**
         * 护理交班统计类型(0级)
         */
        public static final String TYPE = "432ce608f9ae47dc880ed94a07aa7719";
        /**
         * 出院
         */
        public static final String HOSPITAL_OUT = "de2bc89feb834bf293421d50e7d2a033";
        /**
         * 入院
         */
        public static final String HOSPITAL_IN = "19c2840c0a07435f9f55fa76633cddc3";
        /**
         * 在院
         */
        public static final String HOSPITAL_ON = "724bac70937548d190a5bb5c5e19e1ae";
        /**
         * 转出
         */
        public static final String ROLL_OUT = "ef96726bed4346d9ab7166d6e7370998";
        /**
         * 转入
         */
        public static final String ROLL_IN = "0be6be6ece1a403da3979104d29bc57a";
        /**
         * 死亡
         */
        public static final String DEATH = "9f175f6c2b5a4e5cbe13c3db7fea7045";
        /**
         * 一级
         */
        public static final String LEVEL_1 = "f1245228e841411da8913e9ada3b7480";
        /**
         * 病危
         */
        public static final String CRITICALLY_ILL = "b84bfe91ae8a4f35b8c8c07d69e5eed0";
        /**
         * 病重
         */
        public static final String WAS_SERIOUSLY_ILL = "138de3a4d29b438ea110453d8823a1d7";
        /**
         * 昨日手术
         */
        public static final String YESTERDAY_SURGERY = "3d3e1a9c269e4ccbbd483d7cc17827b5";
        /**
         * 今日手术
         */
        public static final String TODAY_SURGERY = "e6828aca273344c19a81e864412fed9a";
        /**
         * 明日手术
         */
        public static final String TOMORROW_SURGERY = "4e32af7ac791423a838df493d2d8f20d";
        /**
         * 危急值
         */
        public static final String THE_CRITICAL_VALUE = "fa7bd488407f4e1eaed36a3d89beb1a8";
        /**
         * 特殊交班
         */
        public static final String SPECIAL_SUCCESSION = "f736e6a296f043158195c6d05202684e";

        /**
         * 24内小时入院
         */
        public static final Integer REGISTER_HAS_TWENTY_JOIN = 1;

        /**
         * 不是24内小时入院
         */
        public static final Integer REGISTER_NOT_TWENTY_JOIN = 0;
    }

    /**
     * 患者护理电子病历查询范围
     *
     * @author gongshuai
     */
    public static final class EnrEnquiryRange {
        /**
         * 0;护士个人
         */
        public static final Integer PERSONAL = 0;

        /**
         * 1：病区
         */
        public static final Integer ALL_DEPARTMENTS = 1;
    }

    /**
     * 护理电子病历树结构高级查询排序方式
     * <p>
     * 0;患者姓名排序 1：入院时间排序 2;床号排序
     *
     * @author gongshuai
     */
    public static final class EnrMedicalRecordsSorting {

        /**
         * 0;患者姓名排序
         */
        public static final Integer PATIENT_NAME = 0;

        /**
         * 1：入院时间排序
         */
        public static final Integer ADMISSION_TIME = 1;

        /**
         * 2;床号排序
         */

        public static final Integer BED_NUMBER = 2;
    }

    /**
     * 电子病历返回内容 0：电子病历内容 1：模板内容
     *
     * @author yangxiao
     */
    public static final class EmrContentClass {
        /**
         * 0：电子病历内容
         */
        public static final Integer EMR = 0;

        /**
         * 1：模板内容
         */
        public static final Integer TEMPLATE = 1;

    }

    /**
     * 病案首页状态 0：未提交 1：提交
     *
     * @author yangxiao
     */
    public static final class ErhSubmitStatus {
        /**
         * 0：未提交
         */
        public static final Integer NOT_SUBMIT = 0;

        /**
         * 1：提交
         */
        public static final Integer SUBMIT = 1;

        /**
         * 2：提交并接收
         */
        public static final Integer RECEIVE = 2;

    }

    /**
     * 护理电子病历适用频次
     *
     * @author gongshuai
     */
    public static class EnrFrequencyUsage {

        /**
         * 0.多次使用
         */
        public static final Integer MORE_USE = 0;

        /**
         * 1.单次使用
         */
        public static final Integer SINGLE_USE = 1;

    }

    /**
     * 护理电子病历互斥状态
     *
     * @author gongshuai
     */
    public static class EnrMutexStatus {

        /**
         * 0.否
         */
        public static final Integer NOT_MUTEX = 0;

        /**
         * 1.是
         */
        public static final Integer MUTEX = 1;

    }

    /**
     * 电子病历类型管理 状态 0.激活 1.停用
     *
     * @author yangxiao
     */
    public static final class EmrCategoryStatus {
        /**
         * 0.激活
         */
        public static final Integer ACTIVATION = 0;

        /**
         * 1.停用
         */
        public static final Integer STOPPED = 1;

    }

    /**
     * 护理病历状态
     *
     * @author gongshaui
     */
    public static final class EnrMedicalCondition {
        /**
         * 0 ：有效
         */
        public static final Integer EFFECTIVE = 0;

        /**
         * 1 ;作废
         */
        public static final Integer THE_INVALID = 1;
    }

    public static final class ClinicalPathwayRecordResult {
        /**
         * 0 ：退出
         */
        public static final String SIGN_OUT = "8d5d239a86844ef0bc2feabe9a71307f";
        /**
         * 1 ：完成
         */
        public static final String COMPLETE = "428c000e60ae46c1a23c7fd273a0c406";
        /**
         * 2 ：符合未进入
         */
        public static final String CONFORMING_NON_ENTRY = "4b648dad34094ecc990d0b7cda4e150a";
    }

    /**
     * 电子病历模板类型
     *
     * @author gs
     */
    public static final class TemplateType {
        /**
         * 0 ：术前小结 记录
         */
        public static final String PREOPERATIVE_SUMMARY = "4edb960edc264b26bb6ddb2c044360de";

        /**
         * 1 ：术前讨论 记录
         */
        public static final String PREOPERATIVE_DISCUSSION = "df5fede6b4504c4da468fc4d2ca5adf4";

        /**
         * 2 ：麻醉术前访视 记录
         */
        public static final String PREANESTHESIA = "458fcb3dcce44d8ab7fcb23ed2dd69f9";

        /**
         * 3 ：麻醉术后访视 记录
         */
        public static final String POSTOPERATIVE_ANAESTHESIA = "4b01b7bedd414413a37b70971213b674";

        /**
         * 4 ：麻醉 记录
         */
        public static final String ANAESTHESIA = "31df80fe70ba4c48a4c0868ad4f2fa47";

        /**
         * 5 ：手术 记录
         */
        public static final String OPERATION = "3af92fad1d2843cda0c042783eba25f3";

        /**
         * 6 ：术后首次病程 记录
         */
        public static final String FIRST_COURSE_AFTER_OPERATION = "8e8493f6df26452fb94e49b7aee487e8";

        /**
         * 7 ：麻醉术后访视 记录
         */
        public static final String POST_ANESTHESIA_VISIT = "4b01b7bedd414413a37b70971213b674";

        /**
         * 8 ：输血治疗知情同意书 记录
         */
        public static final String BLOOD_TRANSFUSION = "64895bf5e12f4cb7a190a18ee8463207";

        /**
         * 9 ：出院 记录
         */
        public static final String LEAVE_HOSPITAL = "e82ce4f8f6c24db29772004ad8e00530";

        /**
         * 10 ：病危（重）通知书 记录
         */
        public static final String CRITICALLY_ILL = "61b5ae5637894e8598127788c6a88caf";

        /**
         * 11 ：死亡病例讨论 记录
         */
        public static final String DEATH_DISCUSS = "e063db9bc188459898ee5171897654fe";

        /**
         * 12 ：死亡 记录
         */
        public static final String DEATH = "f97aad0300f541a993e23050babc6ca7";

        /**
         * 13 ：抢救 记录
         */
        public static final String RESCUE = "d7dd04e565974fea83f9c05446c2b6f2";

        /**
         * 14 ：转科（转入）记录
         */
        public static final String ENTER_OUT = "be788d14419746e4980e68a6ed918a84";

        /**
         * 15 ：24小时内入出院记录
         */
        public static final String TWENTY_FOUR_OUT = "904fa9602ffa47a08b3cbf12f320d1b4";

        /**
         * 16 ：24小时内入院死亡记录
         */
        public static final String TWENTY_FOUR_DEATH = "63ac347e4a364fe0b0d9f829e9f3c823";
    }

    /**
     * 医嘱事件
     *
     * @author gs
     */
    public static final class doctorAdviceType {
        /**
         * 0 ：手术
         */
        public static final String OPERATION = "035741e3f8244619b447279e14d38f0d";

        /**
         * 2 ：出院
         */
        public static final String LEAVE_HOSPITAL = "8aad3942c4ab4bcf933fae4b4f47ff4c";

        /**
         * 3 ：输血
         */
        public static final String BLOOD_TRANSFUSION = "e0fc1443c5464b5d818037b91005a9af";

        /**
         * 4 ：病危
         */
        public static final String CRITICALLY_ILL = "fffb852a29a443508989bf73c98e69e0";

        /**
         * 5 ：死亡
         */
        public static final String DEATH = "baca21e7a12d40bc913958fd0bb3cc8c";

        /**
         * 6 ：抢救
         */
        public static final String RESCUE = "ce60425ef5f049a6a6d77a4f65ede40a";

        /**
         * 7 ：转科
         */
        public static final String ENTER_OUT = "770c1429139f40aa933079cab358e2f3";

        /**
         * 8: 常规
         */
        public static final String COMMON = "90c1892838d643aca96da1a5716b7f01";
    }

    /**
     * 病案借阅状态
     *
     * @author gs
     */
    public static final class BORROWSTATE {
        /**
         * 0 ：未借出
         */
        public static final Integer LEND = 0;
        /**
         * 1 ：已借出
         */
        public static final Integer NOT_LEND = 1;
    }

    /**
     * 患者状态（出院、入院）
     *
     * @author gongshuai
     */
    public static final class ENTRANCEANDEXIT {
        /**
         * 0 ：出院
         */
        public static final Integer LEAVE_HOSPITAL = 0;

        /**
         * 1 ;入院
         */
        public static final Integer BE_HOSPITALIZED = 1;
    }

    /**
     * 电子病历欢迎页展示条件查询
     *
     * @author gongshuai
     */
    public static final class WELCOMECONDITION {
        /**
         * 0 ：个人
         */
        public static final Integer PERSONAL = 0;

        /**
         * 1 ;科室
         */
        public static final Integer DEPARTMENT = 1;
    }

    /**
     * 发药单相关
     */
    public static final class SENDPILLS {

        /**
         * 发药单明细
         */
        public static final class SENDPILLS_DETAILS {
            /**
             * 中药类型
             */
            public static final Integer PRETYPE_EAST = 1;

            /**
             * 西药类型
             */
            public static final Integer PRETYPE_WEST = 0;

            /**
             * 用药途径 ：口服
             */
            public static final String DRUGUSEUSAGE_ORALLY = "171642339dad4c13b82b5388841d6aa4";
        }

        /**
         * 紧急
         */
        public static final Integer IS_URGENT = 1;

        /**
         * 非紧急
         */
        public static final Integer URGENT = 0;

    }

    /**
     * 电子病历分类 病程记录
     *
     * @author gongshuai
     */
    public static final class COURSE {
        /**
         * 病程记录分类
         */
        public static final String COURSECLASS = "4b762a977bdd4e4d8eb9d729d4567c2c";

        /**
         * 首次病程记录分类
         */
        public static final String FIRST_COURSECLASS = "4e8637842a42401f8f53e3e5ce215268";

    }

    /**
     * 病案首页模板 状态 0.激活 1.未激活
     *
     * @author gongshuai
     */
    public static final class MedicalRecordStatus {
        /**
         * 0 ：激活
         */
        public static final Integer ACTIVATION = 0;

        /**
         * 1 ;未激活
         */
        public static final Integer NOT_ACTIVATION = 1;
    }

    /**
     * 病案首页模板 分类
     *
     * @author gongshuai
     */
    public static final class MedicalRecordClass {
        /**
         * 病案首页西医
         */
        public static final String WESTERN_MEDICINE = "d16aa5c867b541aab664b2f5cbe3553f";

        /**
         * 病案首页中医
         */
        public static final String CHINESE_MEDICINE = "0634159dccc442e78fe956fe75b49f25";
    }

    /**
     * 不良事件模板 状态 0.激活 1.未激活
     *
     * @author gongshuai
     */
    public static final class AdverseEvent {
        /**
         * 0 ：激活
         */
        public static final Integer ACTIVATION = 0;

        /**
         * 1 ;未激活
         */
        public static final Integer NOT_ACTIVATION = 1;
    }

    /**
     * 不良事件模板 分类
     *
     * @author gongshuai
     */
    public static final class AdverseEventClass {
        /**
         * 不良事件分类顶级ID
         */
        public static final String ADVERSE_EVENT_PARENT = "682dfb66f7384e7cb8890a2397a6fdf1";

        /**
         * 护理不良事件
         */
        public static final String NURSING = "b4bce2abd7104e89885c611cd03db144";

        /**
         * 药品不良事件
         */
        public static final String DRUG = "5a86da185ce64f1195fe0ccfbef5bf36";
    }

    /**
     * 发药单状态类
     *
     * @author zhangyao
     */
    public static final class SENPILDETAILSTATUS {

        /**
         * 西药 0
         */
        public static final Integer WESTERN_MEDICINE = 0;
        /**
         * 中药 1
         */
        public static final Integer TRADITIONAL_CHINESE_MEDICINE = 1;
    }

    /**
     * 入院途径
     *
     * @author LJP
     * @version create time;2018年5月26日 上午10;58;14
     */
    public static final class TheWayInhospital {
        /**
         * 门诊
         */
        public static final String OUTPATIENT = "ac63f51d1a515ce3b664a525c758a47a";

    }

    /**
     * 出院方式
     *
     * @author LJP
     * @version create time;2018年5月26日 下午3;01;48
     */
    public static final class TheWayOutHospital {
        /**
         * 医嘱离院
         */
        public static final String DOCTORADVICELEAVE = "1";
        /**
         * 医嘱转院
         */
        public static final String DOCTORADVICETUEN = "2";
        /**
         * 医嘱转社区卫生服务机构/乡镇卫生院
         */
        public static final String DOCTORADVICETURNCOMM = "3";
        /**
         * 非医嘱离院
         */
        public static final String NOTDOCTORADVICELEAVE = "4";
        /**
         * 死亡
         */
        public static final String DEATH = "5";
        /**
         * 医嘱离院
         */
        public static final String OTHER = "9";
        /**
         * 死亡对应字典表记录ID
         */
        public static final String DEATH_DICTION_ID = "a5e92d3cae745370b509c8c402274669";

    }

    /**
     * 婚姻状况代码
     *
     * @author LJP
     * @version create time;2018年5月26日 上午11;12;16
     */
    public static final class MarriageCondition {
        /**
         * 未婚
         */
        public static final String UNMARRIED = "10";
        /**
         * 已婚
         */
        public static final String MARRIED = "20";
        /**
         * 丧偶
         */
        public static final String WIDOWHOOD = "30";
        /**
         * 离婚
         */
        public static final String DIVORCE = "40";
        /**
         * 其他
         */
        public static final String OTHER = "90";

    }

    /**
     * 中药处方
     */
    public static final class CHM_PRESCRIPTION {

        /**
         * 每日剂量
         */
        public static final String DAY_DOSE = "c331889d78df4363a682915e8d015f75";

        /**
         * 脚注
         */
        public static final String FOOTNOTE = "955d5041414a4c5fac7974ba870c08c7";

        /**
         * 服用嘱托
         */
        public static final String TAKEENTRUST = "54efb42d10354811ac533ae62f6a8124";

        /**
         * 煎煮方法
         */
        public static final String DECOCTING_WAY = "ae5221d5772544d497cc3144f64da492";
    }

    /**
     * 西医病案首页费用项目
     */
    public static final class West_Mrcost {

        /**
         * 一般医疗服务费
         */
        public static final String COMMONLY_HEALTH_COST = "c84e912aacda4682821353cbb63f7687";

        /**
         * 一般医疗操作费
         */
        public static final String COMMONLY_OPERATION_COST = "ba0b16f1a1f248888bc536148ada204c";

        /**
         * 护理费
         */
        public static final String NURSING_COST = "343ff5dae56d4f84a8f20a1c7ae5dd9a";

        /**
         * 其他费用
         */
        public static final String OTHER_EXPENSES = "84d24948bf864aa9932679c663f67da6";

        /**
         * 病理诊断费
         */
        public static final String PATHOLOGICAL_DIAGNOSIS_COST = "f5ff5d3de97c48a89ae6d0e7e5843144";

        /**
         * 实验室诊断费
         */
        public static final String LABORATORY_DIAGNOSIS_COST = "ca35a4c0a553407bb8b7e2bfbe5b8cc7";

        /**
         * 影像学诊断费
         */
        public static final String IMAG_COST = "03438f07adba4b6e98d2666d0abdb519";

        /**
         * 临床诊断项目费
         */
        public static final String CLINICAL_DIAGNOSIS_COST = "04becd798c2b400abc55be6366d55dde";

        /**
         * 非手术治疗项目费
         */
        public static final String NO_SURGICAL_TREATMENT_COST = "d92b164a84a14f41ba5dbbed33253b8c";

        /**
         * 手术治疗费
         */
        public static final String SURGICAL_TREATMENT_COST = "9d286408fb1f430b9d3ebee6ac88e0b4";

        /**
         * 临床物理治疗费
         */
        public static final String CLINICAL_PHYSICAL_THERAPY_COST = "4e809c8687384cc7a4cd933a03e0977b";

        /**
         * 麻醉费
         */
        public static final String ANESTHETIC_COST = "026e1b210a75434a920684b45f1bfca5";

        /**
         * 手术费
         */
        public static final String SURGICAL_EXPENSES_COST = "0d0cd1a89405400c91dbdbff894ff613";

        /**
         * 康复费
         */
        public static final String REHABILITATION_COST = "89da103a687c4e508276c23115e15aed";

        /**
         * 中医治疗费
         */
        public static final String CHINESE_MEDICINE_TREATMENT_COST = "a7640177c67a426a8db79dadc6205ce3";

        /**
         * 西药费
         */
        public static final String WESTERN_MEDICINE_COST = "a33c656585684697a16b475c12af29cc";

        /**
         * 抗菌药物费用
         */
        public static final String ANTISEPTIC_DRUGS_COST = "61a7f3fe4a0f4e938fe106c44ee64b64";

        /**
         * 中成药费
         */
        public static final String CHINESE_PATENT_MEDICINE_COST = "9b0c94e441dc406990c21b021320e08e";

        /**
         * 中草药费
         */
        public static final String CHINESE_HERBAL_MEDICINE_COST = "b1fedeb579f74342998791b4bdd20d3f";

        /**
         * 血费
         */
        public static final String BLOOD_COST = "049f3135e5474e8da114696b809164e8";

        /**
         * 白蛋白类制品费
         */
        public static final String ALBUMIN_COST = "f68fe8dd2f6d4a0c8bda620085736d30";

        /**
         * 球蛋白类制品费
         */
        public static final String GLOBULIN_COST = "1918ff23640b4cd1a7ca90c3df6e3d06";

        /**
         * 凝血因子类制品费
         */
        public static final String COAGULATION_FACTOR_COST = "3fd6759e59b3470e917567263e57cf01";

        /**
         * 细胞因子类制品费
         */
        public static final String CELL_FACTOR_COST = "d8004c3bfa55402796e7cb67639522be";

        /**
         * 检查用一次性医用材料费
         */
        public static final String INSPECT_COST = "cac75086aa004f6a8d0b122aa9256945";

        /**
         * 治疗用一次性医用材料费
         */
        public static final String TREATMENT_COST = "067aabfdca5f4dbd9267591ef053805c";

        /**
         * 手术用一次性医用材料费
         */
        public static final String OPERATION_COST = "cfee73f82f5a4dfab2a3c6573b79a9a7";

        /**
         * 其他费(其他类)
         */
        public static final String OTHER_COST = "0205cf2538154ed4bcba0d35e5d4c137";
    }

    /**
     * 中医病案首页费用项目
     */
    public static final class Chinese_Mrcost {

        /**
         * 一般医疗服务费
         */
        public static final String MR_GSMECost = "71d6dc9d934d47938aef5e4e329d7345";

        /**
         * 中医辩证论治费
         */
        public static final String cmdCost = "fd693da16eaa40978ae97817a43aa093";

        /**
         * 中医辩证论治会诊费
         */
        public static final String cmdgcCost = "c9be9d36e32d4a9c9d6fb196dfe9bf98";

        /**
         * 一般医疗操作费
         */
        public static final String MR_GTCost = "1192fdc93c8b4ce6b99c73547bcb8437";

        /**
         * 护理费
         */
        public static final String MR_NCost = "0754c735898941f1825b5776d46c5d67";

        /**
         * 其他费用
         */
        public static final String MR_OCost = "45f8b9c82cf546dcbfefb7ee813ba058";

        /**
         * 病理诊断费
         */
        public static final String MR_PDCost = "a5776e693d554522b024c9678706c103";

        /**
         * 实验室诊断费
         */
        public static final String MR_LDCost = "3ae7f889aa6b47c0ab296b37973add09";

        /**
         * 影像学诊断费
         */
        public static final String MR_DFFICost = "7a156dd124cf4d9b844254390bb8839d";

        /**
         * 临床诊断项目费
         */
        public static final String MR_CDPCost = "8929e15891274828909ec424a70c1050";

        /**
         * 非手术治疗项目费
         */
        public static final String MR_NOTPCost = "b031931676304ef4afed6609687137d3";

        /**
         * 临床物理治疗费
         */
        public static final String MR_CPTCost = "74a5e26c72644cf1996ad7868195b2e2";

        /**
         * 手术治疗费
         */
        public static final String MR_STCost = "6adea0a6b8fd4266b8993c17ed59a478";

        /**
         * 麻醉费
         */
        public static final String MR_ACost = "267971f898e149418fca95914a24a5d6";

        /**
         * 手术费
         */
        public static final String MR_OOCost = "671afceefb8c4472ba5ba39a2d1ede26";

        /**
         * 康复费
         */
        public static final String MR_RCost = "ada4c99d5dd14d67bec3e8c3c19d9a6b";

        /**
         * 中医诊断
         */
        public static final String cmDiagnosis = "770f43ac1e224248a1e326e7d88db594";

        /**
         * 中医治疗
         */
        public static final String cmTreatment = "17601622fd2e4ee8a7e42b268da061be";

        /**
         * 中医外治
         */
        public static final String cmExternal = "6fd6226e77f4498cb462e57d2e5c366c";

        /**
         * 中医骨治
         */
        public static final String cmOrthopedics = "51d070424b334c27859311a310342651";

        /**
         * 针灸及灸法
         */
        public static final String cmAcupuncture = "eff7b1617bbb4724af1012f228f9cb78";

        /**
         * 中医推拿治疗
         */
        public static final String cmMassage = "96e464866d734b6f8a6c19242f01165d";

        /**
         * 中医肛肠治疗
         */
        public static final String cmAnorectal = "ae1621b377d54f86a525e5c21b831ef5";

        /**
         * 中医特殊治疗
         */
        public static final String cmSpecial = "4d7767cdc45a4857b26ebe11e922095a";

        /**
         * 中医其他
         */
        public static final String cmOther = "646ee5726f5b48cd89404aaf08cc5791";

        /**
         * 中医特殊调配加工
         */
        public static final String cmSpecialMa = "73a8ff870b7149c281628b00555d7752";

        /**
         * 辩证施膳
         */
        public static final String cmFacilities = "630f5372f1d043ad87425729d2698577";

        /**
         * 西药费
         */
        public static final String MR_WMCost = "56273f376ae942f4abcb1e6aec43dff9";

        /**
         * 抗菌药物费用
         */
        public static final String MR_ADCost = "2326af4d10fd4868b441474abcc3beb0";

        /**
         * 中成药费
         */
        public static final String MR_CPMCost = "819dc45b0a7947eabd3a23494b891f02";

        /**
         * 中草药费
         */
        public static final String MR_CHMCost = "5fde724531884814904e5096e54b8379";

        /**
         * 血费
         */
        public static final String MR_BCost = "f0c5778a5b044b64a1edda84f6834e65";

        /**
         * 白蛋白类制品费
         */
        public static final String MR_ALCost = "96f0d622c20f48949b063ce48dde1860";

        /**
         * 球蛋白类制品费
         */
        public static final String MR_GCost = "5be622baaee64e93951f0455f6459b56";

        /**
         * 凝血因子类制品费
         */
        public static final String MR_CFCost = "b628cb2ebc124955b36d0ac8de5dc38f";

        /**
         * 细胞因子类制品费
         */
        public static final String MR_CellsCost = "9b9e50d5039c442ab4d3486289e75cdf";

        /**
         * 检查用一次性医用材料费
         */
        public static final String MR_IDMMCost = "a18dd1b648c74c028b29511d00e9abc6";

        /**
         * 治疗用一次性医用材料费
         */
        public static final String MR_TDMMCost = "1f1512905e97411dbb241333f89ec4b2";

        /**
         * 手术用一次性医用材料费
         */
        public static final String MR_ODMMCost = "9ed86151fa9249e4b69a0dd8954ed6ae";

        /**
         * 其他费
         */
        public static final String MR_OSCost = "546ac81b2b164d149102888247467ad6";

        /**
         * 医疗机构中药制剂费
         */
        public static final String cmCmp = "f2bb9973e39e4f499ef4e51a60897b01";
    }

    /**
     * 护理单模板相关
     */
    public static final class NURDOCTEM {

        /**
         * 是通用模板
         */
        public static final Integer NURDOCTEM_ISGENERAL_YES = 1;

        /**
         * 非通用模板
         */
        public static final Integer NURDOCTEM_ISGENERAL_NO = 0;

        /**
         * 模板详情有修改
         */
        public static final Integer NURDOCTEM_UPDATE = 0;

        /**
         * 模板详情有效
         */
        public static final Integer NURDOCTEM_ENABLED = 1;

        /**
         * 模板详情无效
         */
        public static final Integer NURDOCTEM_UNENABLED = 2;

    }

    /**
     * 检查/检验申请单相关
     *
     * @author Guoqing
     */
    public static final class CHECK_TEST_APPLY_RECEIPT {

        /**
         * 检查项目分类
         */
        public static final String CHECK_ITEM_CLASSIFICATION = "0f3ca2c8f6345591a635624ddb84915b";

        /**
         * 检查申请单类型ID
         */
        public static final String CHECK = "adc38df8b6ed5dfe888606d6d15bc8b0";

        /**
         * 检验申请单类型ID
         */
        public static final String TEST = "3b94faa308445656b9257095264c1df4";

        /**
         * 是否为手工划价产生：1.是
         */
        public static final Integer IS_MANUAL_PRICING = 1;

        /**
         * 是否为手工划价产生： 0.否
         */
        public static final Integer NO_MANUAL_PRICING = 0;
    }

    /**
     * 手术申请单
     *
     * @author yanghaiyong
     */
    public static final class SURGERT_APPLY_RECEIPT_STATUS {

        /**
         * 新建
         */
        public static final Integer NEW = 0;

        /**
         * 提交
         */
        public static final Integer SUBMIT = 1;

    }

    /**
     * 手术申请单类型
     *
     * @author yanghaiyong
     */
    public static final class SURGERT_APPLY_RECEIPT_TYPE {

        /**
         * 择期
         */
        public static final Integer QUIET = 0;

        /**
         * 急诊
         */
        public static final Integer EMERGENCY_DEPARTMENT = 1;

        /**
         * 日间
         */
        public static final Integer DURING_THE_DAY = 2;
    }

    /**
     * 质控结果描述
     *
     * @author yangxiao
     */
    public static final class ControlResultsDescribe {

        /**
         * 未书写
         */
        public static final String NOT_WRITE = "未书写";

        /**
         * 未填写
         */
        public static final String NOT_FILL = "未填写";
    }

    /**
     * 费用类别
     *
     * @author 龚帅
     */
    public static final class PatCostType {

        /**
         * 自费
         */
        public static final String SELF_EXPENSE = "106961d979994b70958e4e8cefd9f2fe";

        /**
         * 居民社保
         */
        public static final String SOCIAL_SECURITY = "4a4222115fa9451baf09c115ae9fef04";

        /**
         * 职工社保
         */
        public static final String SOCIAL_STAFF_SECURITY = "115e1b856c9b4e638434568f3e444a6f";

        /**
         * 农合
         */
        public static final String AGRICULTURAL_COOPERATION = "7c105317d3dc4a3bb8de689b62a8c0d6";
    }

    /**
     * 用药途径和用药
     *
     * @author Guoqing
     */
    public static final class MedicationMethodsAndTypes {

        /**
         * 药品静滴分类 ---> 大液
         */
        public static final String LARGE_LIQUID = "8e4ac0564969414e92ff5dc2ddf6846c";

        /**
         * 药品静滴分类 ---> 针剂
         */
        public static final String INJECTION = "db4eaef80f554065a3c6b88a05d32028";

        /**
         * 静滴
         */
        public static final String STATIC_DROPS = "2947c1518a3c4e2695e060653aab9b28";

        /**
         * 肌注
         */
        public static final String INTRAMUSCULAR_INJECTION = "8417fe7fac2845ae98aead18189afa16";

        /**
         * 皮下
         */
        public static final String SUBCUTANEOUS = "83f624574dbd4338be4af5063c971b9d";

        /**
         * 雾化吸入
         */
        public static final String ATOMIZATION_INHALATION = "190deba8c6bb4953b17293f85695b7a2";

        /**
         * 微量泵入
         */
        public static final String TRACE_PUMPING = "a53fb7907b8b4e18a45d29b5080f0e1b";

        /**
         * 静推(静注)
         */
        public static final String STATIC_PUSH = "f15d407339c54778a5fea49cd7646285";

        /**
         * 皮试
         */
        public static final String SKIN_TEST = "50a02cdcda3e4cac90d567e1b625ac57";
    }

    /**
     * 费用是否固定
     *
     * @author 龚帅
     */
    public static final class Fixed {

        /**
         * 固定
         */
        public static final int FIXED = 1;

        /**
         * 非固定
         */
        public static final int NOT_FIXED = 2;

    }

    /**
     * 医嘱事件（是否停止其他长期医嘱）
     *
     * @author 龚帅
     */
    public static final class StopOtherAdvice {

        /**
         * 不管
         */
        public static final Integer NO_MATTER = 0;

        /**
         * 是
         */
        public static final Integer YES = 1;

        /**
         * 否
         */
        public static final Integer NO = 2;

        /**
         * 强制是
         */
        public static final Integer FORCE_YES = 3;

        /**
         * 强制否
         */
        public static final Integer FORCE_NO = 4;

    }

    /**
     * 医嘱事件（是否紧急）
     *
     * @author 龚帅
     */
    public static final class Exigency {

        /**
         * 不管
         */
        public static final Integer NO_MATTER = 0;

        /**
         * 是
         */
        public static final Integer YES = 1;

        /**
         * 否
         */
        public static final Integer NO = 2;

        /**
         * 强制是
         */
        public static final Integer FORCE_YES = 3;

        /**
         * 强制否
         */
        public static final Integer FORCE_NO = 4;

    }

    /**
     * 医嘱事件（是否备用）
     *
     * @author 龚帅
     */
    public static final class StandbyApplication {

        /**
         * 不管
         */
        public static final Integer NO_MATTER = 0;

        /**
         * 是
         */
        public static final Integer YES = 1;

        /**
         * 否
         */
        public static final Integer NO = 2;

        /**
         * 强制是
         */
        public static final Integer FORCE_YES = 3;

        /**
         * 强制否
         */
        public static final Integer FORCE_NO = 4;

    }

    /**
     * 医嘱事件（是否长期有效）
     *
     * @author 龚帅
     */
    public static final class LongTime {

        /**
         * 不管
         */
        public static final Integer NO_MATTER = 0;

        /**
         * 是
         */
        public static final Integer YES = 1;

        /**
         * 否
         */
        public static final Integer NO = 2;

        /**
         * 强制是
         */
        public static final Integer FORCE_YES = 3;

        /**
         * 强制否
         */
        public static final Integer FORCE_NO = 4;

    }

    /**
     * 质控常量
     *
     * @author yangxiao
     */
    public static final class QuaControlType {

        /**
         * 病案首页
         */
        public static final String MR_HOME_PAGE = "9c8b37e2e82440db98a680ab44832db3";

        /**
         * 病案首页
         */
        public static final String MRHP_TYPE = "0";

        /**
         * 病案首页类型ID
         */
        public static final String MRHP_TYPE_ID = "3f7f28655639426f87e571f5b9dceb47";

        /**
         * 是否单次计分 1：是
         */
        public static final Integer SINGLE_POINTS = 1;

        /**
         * 是否单次计分 0：否
         */
        public static final Integer NO_SINGLE_POINTS = 0;

        /**
         * 质控医嘱事件为第一条医嘱下达时间 事件ID
         */
        public static final String ADVICE_EVENT = "0";

        /**
         * 评分质控开始时间 ： 1 入院时间
         */
        public static final Integer ADMISSION_TIME = 0;

        /**
         * 评分质控开始时间 ： 2 第一条医嘱下达时间
         */
        public static final Integer ONE_ADV_GIVE_TIME = 1;

        /**
         * 评分质控开始时间 ： 4 医嘱下达时间
         */
        public static final Integer ADV_GIVE_TIME = 2;

        /**
         * 评分质控开始时间 ： 3 出院时间
         */
        public static final Integer OUT_HOSP_TIME = 3;

        /**
         * 24小时出入院记录病历类型
         */
        public static final String OUT_HOSP_TYPE_24HOURS = "904fa9602ffa47a08b3cbf12f320d1b4";

        /**
         * 24小时内入院死亡记录病历类型
         */
        public static final String DEATH_TYPE_24HOURS = "63ac347e4a364fe0b0d9f829e9f3c823";

        /**
         * 门诊病历类型
         */
        public static final String OUTPATIENT_TYPE = "4c10b5f1e1d4487396ee36bd8168145a";

        /**
         * 传染病上报类型
         */
        public static final String REPORT_DISEASES = "3f98b13801e64a80adca79518f64c16d";
    }

    /**
     * 药品信息常量类
     */
    public static final class DRUG_CONSTANTS {

        /**
         * 药品剂型单位id
         */
        public static final String DRUG_DOSE_TYPEUNIT_ID = "a7182c9c4d154357b9f586b6cd83f3cc";

        /**
         * 剂量单位id
         */
        public static final String DRUG_DOSEUNIT_ID = "6748aeb70063418e978d4f3a74ec02b5";

        /**
         * 药品有效期单位id
         */
        public static final String DRUG_VALIDITYUNIT_ID = "5bd3532de7764d6d8a0b3348377246e0";

        /**
         * 药品剂型ID
         */
        public static final String DRUG_DOSE_TYPE = "f238d1e43ac444218d76a1c46d860b8d";

        /**
         * 药品品牌ID
         */
        public static final String DRUG_BRAND = "2517ef2bdffe4a03987ac7407f6b1b18";

        /**
         * 敏试药
         */
        public static final Integer DRUG_ISALLERGY = 1;

        /**
         * 非敏试药
         */
        public static final Integer DRUG_NOTALLERGY = 0;
        /**
         * 药品基本包装 1
         */
        public static final Integer DRUGPACK_ISBASICPACK = 1;
        /**
         * 药品非基本包装 0
         */
        public static final Integer DRUGPACK_NOTBASICPACK = 0;
        /**
         * 药品总量取整
         */
        public static final String TOTAL_PICKUP = "9f9c083025964884a68d6deb519a56e6";
        /**
         * 单次取整
         */
        public static final String SINGLE_PICKUP = "3c3400827d9a47d88de1b0ee37c574f1";
        /**
         * 不取整
         */
        public static final String NO_PICKUP = "810e7c7067a54f1a9af98b9d5712a325";
        /**
         * 处方取整
         */
        public static final String PRES_PICKUP = "21d02fa644d04065bc66b3f6060e2f19";
    }

    /**
     * 护理电子病历类型管理 状态 0.激活 1.停用
     *
     * @author gongshuai
     */
    public static final class EnrCategoryStatus {
        /**
         * 0.激活
         */
        public static final Integer ACTIVATION = 0;

        /**
         * 1.停用
         */
        public static final Integer STOPPED = 1;

    }

    /**
     * 病案首页费用项目 对应费用状态码 0.没有 1.有
     *
     * @author gongshuai
     */
    public static final class MrCostState {
        /**
         * 0.没有
         */
        public static final Integer NO = 0;

        /**
         * 1.有
         */
        public static final Integer YES = 1;

    }

    /**
     * 科室归属
     *
     * @author gongshuai
     */
    public static final class WgAscription {
        /**
         * 中医科室
         */
        public static final String CHINESE = "70150717c41b462791c6b204cf7ec1d5";

        /**
         * 西医科室
         */
        public static final String WESTERN = "d3e1672cbd8b400b9e09925cf9cc946b";

    }

    /**
     * 病历违规事项
     *
     * @author LJP
     */
    public static final class IllegalItems {
        /**
         * 字典类型ID
         */
        public static final String EmrIlligalReason = "3ccf2cfa9c494e86bf596c6e43689b10";

        /**
         * 超时违规
         */
        public static final String OVER_TIME_ILLEGAL = "3ef9572c20cd4613b2b0a9399d81c6c0";

        /**
         * 超时违规
         */
        public static final String OVER_TIME_DESCRIBE = "超时违规";
    }

    /**
     * 病案标示 0.通用病案 1.基础病案
     *
     * @author gongshaui
     */
    public static final class MrhpMarking {
        /**
         * 0.通用病案
         */
        public static final Integer ACTIVATION = 0;

        /**
         * 1.基础病案
         */
        public static final Integer BASICS = 1;
    }

    /**
     * 会诊
     *
     * @author DX
     */
    public static final class ConsultationConstant {
        /**
         * 是否已结束 1.是
         */
        public static final Integer IS_END_CONSULT = 1;

        /**
         * 是否已结束 0.否
         */
        public static final Integer NO_END_CONSULT = 0;

        /**
         * 会诊状态 : 0.发起
         */
        public static final Integer CONSULTATION_STATUS_START = 0;
        /**
         * 会诊状态 : 1.接受
         */
        public static final Integer CONSULTATION_STATUS_ACCEPT = 1;
        /**
         * 会诊状态 :-1.拒绝
         */
        public static final Integer CONSULTATION_STATUS_REJECT = -1;
        /**
         * 会诊状态: 2.撤销
         */
        public static final Integer CONSULTATION_STATUS_UNDO = 2;

        /**
         * 会诊 1
         */
        public static final Integer CONSULT = 1;
        /**
         * 不是会诊 0
         */
        public static final Integer NO_CONSULT = 0;

        /**
         * 发起会诊
         */
        public static final Integer LAUNCH = 1;

        /**
         * 接收会诊
         */
        public static final Integer NO_LAUNCH = 0;

        /**
         * 会诊类型
         */
        public static final String CONSULT_TYPE = "4248c3ef4a444cc18f33f57e532a4eb8";

        /**
         * 会诊紧急程度
         */
        public static final String CRITICAL_SITUATION = "a217393d27f04c3a94f4574adc094dd3";

        /**
         * 会诊类型：科室
         */
        public static final String CONSULT_TYPE_WORK_GROUP = "3da6dc520f3e4a1f9696e185ef7ec0a7";
    }

    /**
     * 输液单状态
     */
    public static final class infusionSheetStatus {

        /**
         * 接单 0
         */
        public static final Integer RECEIPT = 0;

        /**
         * 执行中 1
         */
        public static final Integer IN_EXECTION = 1;

        /**
         * 执行完成 2
         */
        public static final Integer FINISH_EXECTION = 2;

        /**
         * 输液单状态已执行 1
         */
        public static final Integer INFUSION_FINISH = 1;
        /**
         * 已安床
         */
        public static final Integer ARRANGED = 1;

        /**
         * 未安床
         */
        public static final Integer UNARRANGED = 0;
    }

    /**
     * 三级医师权限 0.权限出错 2.成立 3.不成立
     *
     * @author gongshaui
     */
    public static final class jurisdictionType {
        /**
         * 0.权限出错
         */
        public static final Integer ERROR = 0;

        /**
         * 1.成立
         */
        public static final Integer ESTABLISH = 1;

        /**
         * 2.不成立
         */
        public static final Integer NOT_ESTABLISH = 2;
    }

    /**
     * 病区
     */
    public static final class DiseaseArea {

        /**
         * 门诊部输液区
         */
        public static final String INFUTION_AREA = "b6d15d4471dc4e009f7c6a0c5fae96b5";

    }

    /**
     * 三级医师操作
     *
     * @author gongshaui
     */
    public static final class threeDocEmrOperation {
        /**
         * 提交
         */
        public static final String SUBMIT = "提交";

        /**
         * 退回
         */
        public static final String RETURN = "退回";
    }

    /**
     * 便利性模板
     *
     * @author DX
     */
    public static final class TemplateMode {

        /**
         * 模板父类(字典表)
         */
        public static final String TEMPLATE_PARENT = "7570f17a15ce4b8984b43558cc712686";

        /**
         * 医嘱模板
         */
        public static final String DOCTOR_ADVICE_TEMPLATE = "7fbcbc40aa8840149459edbac7c6a79d";

        /**
         * 中药处方模板
         */
        public static final String CHM_PRESCRIPTION_TEMPLATE = "776cbcaaaadb4052aab2bfd5a16d4e9d";

        /**
         * 西药处方模板
         */
        public static final String WES_PRESCRIPTION_TEMPLATE = "9bf99d06e32f441d81edb8afb90c3e12";

        /**
         * 病历模板
         */
        public static final String MEDICAL_RECORDS_TEMPLATE = "2a4e892fb9e34f3ea0a982a7c1583884";

        /**
         * 用户
         */
        public static final Integer MODE_USER = 1;

        /**
         * 科室
         */
        public static final Integer MODE_GROUP = 0;

        /**
         * 所有
         */
        public static final Integer MODE_ALL = 2;

        /**
         * 模板状态启用
         */
        public static final Integer MODE_STATUS_ENABLE = 1;

        /**
         * 模板状态未启用
         */
        public static final Integer MODE_STATUS_UNENABLE = 0;
    }

    /**
     * 中药颗粒包装形式常量
     */
    public static final class DrugModality {
        /**
         * 如果为颗粒
         */
        public static final Integer IS_GRAIN = 1;
        /**
         * 不是颗粒
         */
        public static final Integer NOT_GRAIN = 0;
        /**
         * 不管是不是颗粒
         */
        public static final Integer NOCARE_GRAIN = 2;
        /**
         * 散装
         */
        public static final String DRUGMODALITY_BULK = "0c1d6fd957ce4fbdb25724e7868cd4f3";

        /**
         * 包装
         */
        public static final String DRUGMODALITY_PACKING = "ee514d78b7ce4629ad701a83ff124699";
    }

    /**
     * 病历审核操作状态
     *
     * @author yangxiao
     */
    public static final class EmrAuditOperStatus {

        /**
         * 1 审核
         */
        public static final Integer AUDIT = 1;

        /**
         * 0 取消审核
         */
        public static final Integer CANCEL_AUDIT = 0;
    }

    /**
     * 收治入院
     */
    public static final class AdmissionToHospital {

        /**
         * 新建
         */
        public static final Integer HOSPITAL_CREATED = 0;

        /**
         * 作废
         */
        public static final Integer HOSPITAL_CANCEL = 1;

        /**
         * 已收治
         */
        public static final Integer HOSPITAL_ADMITTED = 2;

    }

    /**
     * 医嘱权限
     */
    public static final class DoctorPermiss {
        /**
         * 医师处方审核权
         */
        public static final String PERMISS_AUDIT = "2e517309939b47f8a7833211c93c6711";
        /**
         * 医师医嘱审核权
         */
        public static final String DOCADV_AUDIT = "99834d0ae0244bb98c472aafbb7cb6fd";
    }

    /**
     * 科室属性常量表
     */
    public static final class WorkingGroupAttributeConstant {
        /**
         * 对应业务typeId
         */
        public static final String WAREATTRIBUTE_TYPE_ID = "ab18d3490f834003b6a1bcd41c552cc0";

        /**
         * 门诊西药处方业务类型id
         */
        public static final String OUT_DEPART_WEST_MEDPRES_ID = "198abe5ff878494697947630c0a5d5c3";

        /**
         * 门诊中药处方业务类型id
         */
        public static final String OUT_DEPART_EAST_MEDPRES_ID = "f3e092915009436083a75399212bf87b";

        /**
         * 门诊诊疗处置业务类型id
         */
        public static final String OUT_DEPART_TREATMENT_MEDPRES_ID = "7270d1ba5c3a44b5b2adbe4445058479";

        /**
         * 住院医嘱业务类型id
         */
        public static final String HOSPITAL_DOCTOR_ADVICE_MEDPRES_ID = "315ddb3a5bf24cc29429bc7f62f93d78";

        /**
         * 默认科室
         */
        public static final Integer ATTRIBUTE_DEFAULT = 1;
        /**
         * 非默认科室
         */
        public static final Integer ATTRIBUTE_NOT_DEFAULT = 0;

        /**
         * 检验属性
         */
        public static final String TEST_ATTRIBUTE = "8b7c6ef951644b14926bd5b030785706";

        /**
         * 检查属性
         */
        public static final String CHECK_ATTRIBUTE = "be95c5d9559a47b7bcf6a07bd1dcb5a4";

        /**
         * 中医
         */
        public static final String TCM_TYPE = "6c148b7a0ceb4827a48e506e312c5a5e";

        /**
         * 西医
         */
        public static final String WM_TYPE = "87e9cdea3dd94646aebf369d7f384543";

        /**
         * 急诊
         */
        public static final String EM_TYPE = "962b16fe80f04a68b43ac33ffa338094";

    }

    /**
     * 库存常量
     */
    public static final class StockConstant {
        /**
         * 是否冻结 ：1.是
         */
        public static final Integer IS_FREEZE = 1;
        /**
         * 是否冻结 ： 0.否
         */
        public static final Integer NOT_FREEZE = 0;

        /**
         * 是否有效 ：1.是
         */
        public static final Integer IS_EFFECTIVENESS = 1;
        /**
         * 是否有效 ： 0.否
         */
        public static final Integer NOT_EFFECTIVENESS = 0;

    }

    /**
     * 批次单据
     */
    public static final class BatchPriceReceiptConstant {
        /**
         * 已新建
         */
        public static final Integer CREATED = 0;
        /**
         * 已修改
         */
        public static final Integer UPDATE = 1;
        /**
         * 已校准
         */
        public static final Integer CHECKED = 2;
        /**
         * 已审核
         */
        public static final Integer AUDITED = 3;
        /**
         * 已作废
         */
        public static final Integer INVALID = 4;

        /**
         * 不是已新建的单据
         */
        public static final String NOT_CREATED = "不是已新建的单据";
        /**
         * 单据已审核
         */
        public static final String HAS_AUDITED = "单据已审核";
    }

    public static final class CheckTestApplyTemple {
        /**
         * 医生个人
         */
        public static final Integer TEMPLE_DOCTOR_PERSONAL = 0;

        /**
         * 科室
         */
        public static final Integer TEMPLE_WORK_GROUP = 1;

        /**
         * 所有
         */
        public static final Integer TEMPLE_ALL = 2;
    }

    public static final class WareHouseDefaultPack {
        /**
         * 停用
         */
        public static final Integer STATUS_BLOCK_UP = 0;

        /**
         * 启用
         */
        public static final Integer STATUS_START_USING = 1;
    }

    /**
     * 药品申领单相关
     *
     * @author gongliang 2018-8-14
     */
    public static final class DrugApplyReceiptCorrelation {
        /**
         * 药品申领单状态: 创建 0
         */
        public static final Integer CREATE_STATUS = 0;

        /**
         * 药品申领单状态: 提交 1
         */
        public static final Integer SUBMIT_STATUS = 1;
        /**
         * 药品申领单状态: 确认 2
         */
        public static final Integer CONFIRM_STATUS = 2;
        /**
         * 药品申领单状态: 发药 3
         */
        public static final Integer ISSUE_STATUS = 3;
    }

    /**
     * 入院病况
     *
     * @author LJP
     * @annotation create time:2018年8月28日 上午10:47:24
     */
    public static final class HospitalCondition {
        /**
         * 病况单
         */
        public static final String MAIN = "ce01291a503248029f71d6c018c87840";
        /**
         * 一般
         */
        public static final String COMMON = "cc82870c48c750ef873905adc8c38098";
        /**
         * 护理等级 :一级
         */
        public static final String FIRST_LEVEL = "f1245228e841411da8913e9ada3b7480";
        /**
         * 危
         */
        public static final String DANGER = "f2611eefd92a5997a202071ae2f92828";
        /**
         * 急
         */
        public static final String EMERGENCY = "cc82870c48c750ef873905adc8c38095";
        /**
         * 出院方式：死亡
         */
        public static final String OUT_HOSPITAL_WAY_DEATH = "a5e92d3cae745370b509c8c402274669";
    }

    /**
     * 诊疗项目专用
     *
     * @author yanghaiyong
     */
    public static final class ClassificationType {
        /**
         * 病况单
         */
        public static final String TYPE_1 = "ce01291a503248029f71d6c018c87840";
        /**
         * 护理
         */
        public static final String TYPE_2 = "ce01291a503248029f71d6c018c87841";
    }

    /**
     * 入院病况
     *
     * @author yanghaiyong 2018年10月31日15:09:56
     */
    public static final class HospitalConditionType {
        /**
         * 父级id
         */
        public static final String TYPE = "99dc102950b957ffb14e6bebc12a0536";

        /**
         * 危
         */
        public static final String DANGER = "f2611eefd92a5997a202071ae2f92828";
        /**
         * 急
         */
        public static final String EMERGENCY = "cc82870c48c750ef873905adc8c38095";

        /**
         * 一般
         */
        public static final String COMMON = "cc82870c48c750ef873905adc8c38098";
    }

    /**
     * 护理等级
     */
    public static final class NursingGradeType {
        /**
         * 父级id
         */
        public static final String TYPE = "64c1c4c529f44295b18b87da88169f14";
        /**
         * 特殊护理
         */
        public static final String ZORE = "81aa3682b9d640eeafccf7a4f2d256e6";
        /**
         * 一级护理
         */
        public static final String ONE = "c2e0cb61322c431482aebf4ad24c3816";
        /**
         * 二级护理
         */
        public static final String TWO = "7f12c40a02904ceea4f27da2dff5598b";
        /**
         * 三级护理
         */
        public static final String THREE = "8126833bd9af48578cd4f6f0a28fc541";

    }

    /**
     * 药品退库单
     *
     * @author yf
     */
    public static final class DrugRetiringReceipt {
        /**
         * 药库
         */
        public static final Integer TYPE_STORAGE_USER = 0;
        /**
         * 药房
         */
        public static final Integer TYPE_PHARMACY_USER = 1;
        /**
         * 1.已新建
         */
        public static final Integer STATUS_CREATED = 1;
        /**
         * 2.已提交
         */
        public static final Integer STATUS_COMMIT = 2;
        /**
         * 3.已接收
         */
        public static final Integer STATUS_ACCEPT = 3;
        /**
         * 4.已处理
         */
        public static final Integer STATUS_HANDLED = 4;
    }

    /**
     * 是否已安排床位
     */
    public static final class HasBed {

        /**
         * 0.未安排
         */
        public static final Integer NO_ARRANGE = 0;

        /**
         * 1.已安排
         */
        public static final Integer YES_ARRANGE = 1;

    }

    /**
     * 适用途径
     *
     * @author zhangyao
     */
    public static final class applicableWay {

        /**
         * 门诊
         */
        public static final Integer OUTPATIENT = 0;

        /**
         * 住院
         */
        public static final Integer IN_THE_HOSPITAL = 1;

        /**
         * 不限
         */
        public static final Integer THERE_IS_NO_LIMIT = 2;
    }

    /**
     * 床位状态
     *
     * @author Administrator
     */
    public static final class bed {

        /**
         * 启用
         */
        public static final Integer TO_ENABLE_THE = 0;

        /**
         * 未启用
         */
        public static final Integer IS_NOT_ENABLED = 1;
    }

    /**
     * 移动端 平台ID
     *
     * @author gongshuai
     */
    public static final class med {

        /**
         * 移动护士平台ID
         */
        public static final String PLATFORM_NURSE = "31b648901b0943ca8363b926de44758e";

        /**
         * 移动医生平台ID
         */
        public static final String PLATFORM_DOCTOR = "28e11226288343b882fa2ac28c45a65a";
    }

    /**
     * 移动端 默认配置 mongodb ID
     *
     * @author gongshuai
     */
    public static final class medDefault {

        /**
         * 移动护士默认配置
         */
        public static final String PLATFORM_NURSE_CONFIG = "5b8e254db0c1a11c907dbad3";

        /**
         * 移动医生默认配置
         */
        public static final String PLATFORM_DOCTOR_CONFIG = "5b8e2868b0c1a11c907dbad4";
    }

    public static final class PurchasePlanConstant {
        /**
         * 已新建
         */
        public static final Integer CREATED = 0;
        /**
         * 已修改
         */
        public static final Integer UPDATE = 1;
        /**
         * 已审核
         */
        public static final Integer AUDITED = 3;
        /**
         * 已入库
         */
        public static final Integer HAS_STORAGE = 4;
    }

    /**
     * 过敏状态
     *
     * @author zhangyao
     */
    public static final class AllergicToRecordStatus {
        /**
         * 过敏
         */
        public static final Integer ALLERGY = 0;
        /**
         * 不过敏
         */
        public static final Integer NOT_ALLERGY = 1;

    }

    /**
     * 样本绑定费用
     */
    public static final class sampleCost {

        /**
         * 状态 0, 随样本收
         */
        public static final Integer SAMPLE_BINDING = 0;

        /**
         * 状态 1.仅收一次
         */
        public static final Integer ONLY_ONCE = 1;

        /**
         * 全血
         */
        public static final String WHOLE_BLOOD = "56dbe0b5ac864a3f8fbc1044ef3c2fcf";

        /**
         * 动脉全血
         */
        public static final String ARTERIAL_WHOLE_BLOOD = "b9aa947ec76e4740a31f43e781760166";

        /**
         * 血浆
         */
        public static final String PLASMA = "c9a72f18d2104174be9f23815ffdc51e";

        /**
         * 血液
         */
        public static final String BLOOD = "77894ac9df0740ee93d8b1b7c30c622e";

        /**
         * 血清
         */
        public static final String SERUM = "1df986e6baf94fa5b026cc70e106ad30";

    }

    /**
     * 退药单常量
     *
     * @author yf
     */
    public static final class BackPillConstant {

        /**
         * 已退药
         */
        public static final Integer STATUS_BACKED = 1;

        /**
         * 未退药
         */
        public static final Integer STATUS_UNBACKED = 0;

        /**
         * 门诊
         */
        public static final Integer TYPE_OUT = 1;

        /**
         * 住院
         */
        public static final Integer TYPE_HOSPITAL = 0;
    }

    public static final class DispensingWindowStatus {

        /**
         * 0.停用
         */
        public static final Integer DISPENSING_WINDOW_ENABLED = 0;

        /**
         * 1.启用
         */
        public static final Integer DISPENSING_WINDOW_STOPPED = 1;
    }

    public static final class MEDICAL_RECORD_TYPE {

        /**
         * 西医
         */
        public static final String WESTERN_MEDICINE = "87e9cdea3dd94646aebf369d7f384543";

        /**
         * 中医
         */
        public static final String CHINESE_MEDICINE = "6c148b7a0ceb4827a48e506e312c5a5e";

        /**
         * 急诊
         */
        public static final String EMERGENCY_DEPARTMENT = "962b16fe80f04a68b43ac33ffa338094";

    }

    public static final class AbnormityCaution {
        /**
         * 临期药品上限天数：3个月
         */
        public static final int ADVENT_THREE_MONTHS = 90;
        /**
         * 临期药品上限天数：1个月
         */
        public static final int ADVENT_ONE_MONTHS = 30;
    }

    /**
     * 病案首页标签基础元素对应标示
     *
     * @author yangxiao
     */
    public static final class EleContMark {

        /**
         * 0.文本
         */
        public static final Integer TEXT = 0;

        /**
         * 1.元素
         */
        public static final Integer ELEMENT = 1;
    }

    /**
     * 病历类型
     *
     * @author yangxiao
     */
    public static final class EmrCategoryCons {

        /**
         * 电子病历类型父级ID
         */
        public static final String EMR_PARENT_ID = "d886168ce1454fa4b72bd0127b40a474";

        /**
         * 护理病历类型父级ID
         */
        public static final String ENR_PARENT_ID = "6d6c1f46edf74508a85ebc358d4e6385";

        /**
         * 门诊病历类型父级ID
         */
        public static final String OMR_PARENT_ID = "688a3a08e4ec4e28ac2863ed74a1e1db";

        /**
         * 病案首页类型父级ID
         */
        public static final String MR_PARENT_ID = "c534542e2c4b4f839706d48d449db0f6";
    }

    /**
     * 留观状态
     *
     * @author zhangyao
     */
    public static final class UNDER_OBSERVATION_RECORDS_STATUS {

        /**
         * 0 留观
         */
        public static final Integer UNDER_OBSERVATION = 0;

        /**
         * 1 出观
         */
        public static final Integer THE_CONCEPT_OF = 1;

    }

    /**
     * 门诊护理业务
     *
     * @author zhangyao
     */
    public static final class TYPE_OF_OUTPATIENT_CARE {

        /**
         * 留观
         */
        public static final String UNDER_OBSERVATION = "7b58f4bac8a344368e5e70a6a052853d";

        /**
         * 输液
         */
        public static final String INFUSION = "d1975a2bcfd640d899a1d83266c6a9a9";

        /**
         * 留/输
         */
        public static final String LEAVE_LOSE = "f5fad67ff53e4eb29c87f5ea7b21d267";

    }

    /**
     * 床位类型
     *
     * @author zhangyao
     */
    public static final class BED_TYPE {

        /**
         * 床位
         */
        public static final String BED = "a1c60dcaf13b4f058018acd7f47b3ab3";

        /**
         * 座位
         */
        public static final String SEAT = "1a332383ede74c70b0a59495ff9f2d2f";

        /**
         * 产床
         */
        public static final String OBSTETRIC_TABLE = "ac5da557f77d40099b0779b886de990f";

    }

    /**
     * 新生儿相关
     *
     * @author gongliang
     */
    public static final class NewBaby {

        /**
         * 新生儿缺陷类型父级Id
         */
        public static final String DEFECTS_TYPE = "d680281ce89a4620b9e905cd8cb1fc5f";

        /**
         * 出生结果: 0 为活产，1 为死产，2 为死胎
         */
        public static final class BirthResults {

            /**
             * 0 为活产
             */
            public static final Integer LIVE_BIRTH = 0;
            /**
             * 1 为死产
             */
            public static final Integer DEAD_BIRTH = 1;
            /**
             * 2 为死胎
             */
            public static final Integer DEAD_FETUS = 2;
        }

    }

    /**
     * 费用类别
     */
    public static final class CostCategoriesConstant {

        /**
         * 自费
         */
        public static final String SELF_EXPENSE = "53d845ebaa8349e6b5eaf05c957b9833";
    }

    /**
     * 科室属性相关
     *
     * @author zhanghengrui
     */
    public static final class WorkGroupAttr {

        /**
         * 科室作用域
         *
         * @author zhanghengrui
         */
        public static final class Scope {

            /**
             * 0:门诊
             */
            public static final Integer OUTPATIENT = 0;

            /**
             * 1:住院
             */
            public static final Integer INHOSPITAL = 1;

            /**
             * 2:不限
             */
            public static final Integer NO_LIMIT = 2;
        }
    }

    /**
     * 患者预交资金相关
     *
     * @author gongliang
     */
    public static final class AcceptingTheAmo {

        /**
         * 是否结算产生 0 否 1 是
         *
         * @author gongliang
         */
        public static final class WhetherSettlement {

            /**
             * 0:不是结算产生
             */
            public static final Integer NO_WHETHER = 0;

            /**
             * 1:结算产生
             */
            public static final Integer WHETHER = 1;
        }

        /**
         * 是否退费产生 0 否 1 是
         *
         * @author gongliang
         */
        public static final class Refund {

            /**
             * 0:不是退费产生
             */
            public static final Integer NOT_REFUND = 0;

            /**
             * 1:退费产生
             */
            public static final Integer REFUND = 1;
        }

        /**
         * 结算单状态: 是否出院结算(0 为中途结算, 1 为出院结算)
         *
         * @author gongliang 2018-10-11
         */
        public static final class IsOutSettlement {

            /**
             * 0:中途结算
             */
            public static final Integer NOT_OUT_SETTLEMENT = 0;

            /**
             * 1:出院结算
             */
            public static final Integer OUT_SETTLEMENT = 1;
        }
    }

    /**
     * user表常量
     *
     * @author LJP
     * @annotation create time:2018年10月10日 上午10:58:02
     */
    public static final class UserConstatnt {
        /**
         * 是超级管理员
         */
        public static final Integer IS_Super = 1;
        /**
         * 不是超级管理员
         */
        public static final Integer NOT_Super = 0;

    }

    /**
     * 门诊病历类型
     *
     * @author gongshuai
     */
    public static final class OmrCategory {

        /**
         * 中医病历
         */
        public static final String comr_category = "cfbd983d166a43d3a20e61dc2d99900a";

        /**
         * 西医病历
         */
        public static final String womr_category = "78514a7377b84db0ab1d3f499bc3f937";

        /**
         * 急诊病历
         */
        public static final String eomr_category = "2de77f11a65d4b888734a6745dddd929";

    }

    /**
     * 科室范围
     *
     * @author gongshuai
     */
    public static final class WgScope {

        /**
         * 门诊
         */
        public static final Integer OUTPATIENT = 0;

        /**
         * 住院
         */
        public static final Integer IN_THE_HOSPITAL = 1;

        /**
         * 不限
         */
        public static final Integer THERE_IS_NO_LIMIT = 2;
    }

    /**
     * 病案首页标签基础表
     */
    public static final class MraPageLabelStatus {

        /**
         * 0 中医
         */
        public static final Integer CHINESE_LABEL = 0;

        /**
         * 1 西医
         */
        public static final Integer WESTERN_LABEL = 1;
    }

    /**
     * 转科（转入、转出）
     *
     * @author gongshuai
     */
    public static final class TurnDepartment {
        /**
         * 0 ：转入
         */
        public static final Integer INTO = 0;

        /**
         * 1 ：转出
         */
        public static final Integer OUT = 1;
    }

    /**
     * 条码类型
     */
    public static final class CodeType {

        /**
         * 条形码 barCode
         */
        public static final Integer BAR_CODE = 1;

        /**
         * plu码(散称码) pluCode
         */
        public static final Integer PLU_CODE = 2;

        /**
         * 散卖码
         */
        public static final Integer SCATTER_CODE = 3;
    }

    /**
     * 自费比例
     *
     * @author zhangyao
     */
    public static final class OneselfCostProportion {

        /**
         * 0.启用
         */
        public static final Integer TO_ENABLE_THE = 0;

        /**
         * 1.未启用
         */
        public static final Integer IS_NOT_ENABLED = 1;

    }

    /**
     * 住院医生类型
     *
     * @author 龚亮
     */
    public static final class HospitalDoctorType {

        /**
         * 住院医生类型TypeId
         */
        public static final String DOCTOR_TYPE_ID = "2fb1dd7f0bae4f7caa158435766bd10a";
        /**
         * 责任医生
         */
        public static final String RESPONSIBLE_DOCTOR = "f971aa71475e4321a5f2da996605e5e3";
        /**
         * 会诊医生
         */
        public static final String CONSULT_DOCTOR = "78be1f3f258e4676a9aa0a7fa324e8d5";
        /**
         * 协诊医生
         */
        public static final String ASSIST_CLINICAL_DOCTOR = "bfa9caf950c84791afcbdb8f77898a71";
        /**
         * 手术医生
         */
        public static final String SURGERY_DOCTOR = "45c274cf17664cc3adb85e09c9d4e7dc";

    }

    /**
     * 三级医师配置相关
     *
     * @author 龚亮
     */
    public static final class CheckDoctorOrder {

        /**
         * 主治医师 1
         */
        public static final Integer ATTENDING_PHYSICIAN = 1;
        /**
         * 主任医师 2
         */
        public static final Integer CHIEF_PHYSICIAN = 2;

    }


}
