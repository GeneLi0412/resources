package com.chngenesis.startrek.util;

import java.math.BigDecimal;

/**
 * 用于存放所有系统常量
 * 
 * @author Administrator
 *
 */
public class Constants {
	/**
	 * 存储用户常量，用于用户session缓存的存取
	 */
	public static final String ACCOUNT_IN_SESSION = "ACCOUNT_IN_SESSION";

	/**
	 * TOKEN 用于病案首页 、 不良事件放行
	 */
	public static final String HIS_TOKEN = "ZDeNLLYbmibXRB43KE3e8moOnbcv9hzg";

	/**
	 * 存储菜单常量，用于菜单session缓存的存取
	 */
	public static final String MENU_IN_SESSION = "MENU_IN_SESSION";
	/**
	 * 登录成功提示信息
	 */
	public static final String LOGIN_SUCCESS = "登录成功";
	/**
	 * 登录失败提示信息
	 */
	public static final String LOGIN_FAIL = "账号或者密码错误";

	/**
	 * 平台版本号
	 */
	public static final BigDecimal VERSION = new BigDecimal(1.0);

	/**
	 * 操作成功
	 */
	public static final String SUCCESS = "操作成功";

	/**
	 * 操作失败
	 */
	public static final String FAIL = "操作失败";

	/**
	 * 平台ID
	 */
	public static final String PLATFORMID = "70ca0940ad3a47969983531f61e8f5bc";

	/**
	 * 就诊卡类型
	 */
	public static final String PATIENT_CARD_TYPE_ID = "214dffd595594ef7ae41407548b5f5f5";

	/**
	 * 年龄单位类型TypeId
	 */
	public static final String AGE_UNIT_TYPE_ID = "5bd3532de7764d6d8a0b3348377246e9";

	/**
	 * 临床路径类型TypeId
	 */
	public static final String PATHWAY_TYPE_ID = "9b11bd1e91ea4c4583dbf22c09743f63";
	
	/**
	 * 临床路径变异原因TypeId
	 */
	public static final String STAGE_VARITAION_TYPE_ID = "99dc55a60422483c8a0ff36f1a3a3fa0";

	/**
	 * 医嘱类型TypeId
	 */
	public static final String PATHWAY_ADVICE_TYPE_ID = "4912fc49213e41a9ab955bb6ca5e6652";

	/**
	 * 临床路径配置详情类型TypeId
	 */
	public static final String CONFIG_DETAILS_TYPE_ID = "3194c04755024fdbb3b489316ee0ebf9";

	/**
	 * 适用性别TypeId
	 */
	public static final String APPLY_SEX_TYPE_ID = "66bc295cc19e467f9c214e1ad3438856";

	/**
	 * 适用操作人类型TypeId
	 */
	public static final String APPLY_OPERATOR_TYPE_ID = "9a0c1806d7bd4471bdeba28425993ee9";

	/**
	 * 挂号状态 已完成
	 */
	public static final int REGISTRATION_STATUS_END = 1;

	/**
	 * 挂号状态 新建
	 */
	public static final int REGISTRATION_STATUS_BEGIN = 0;

	/**
	 * 挂号状态 作废
	 */
	public static final int REGISTRATION_STATUS_PASS = -1;

	/**
	 * 号池状态 已完成
	 */
	public static final int REGISTRATIONTOOL_STATUS_END = 1;
	/**
	 * 号池状态 新建
	 */
	public static final int REGISTRATIONTOOL_STATUS_BEGIN = 0;
	/**
	 * 号池状态 作废
	 */
	public static final int REGISTRATIONTOOL_STATUS_PASS = -1;

	/**
	 * 挂号费 收费项目ID
	 */
	public static final String REGISTRATION_MONEY = "9a6c8d103f104932b5dc592697ef67c3";

	/**
	 * 诊查费类型ID
	 */
	public static final String CLINIC_TYPE_MONEY = "686ca646e1a0491c8f9d6184f34e0b03";

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
	 * 审核人
	 */
	public static final String USER_AUDIT = "f238d1e43ac444218d76a1c46d860b82";
	/**
	 * 核定人
	 */
	public static final String USER_CHECK = "f238d1e43ac444218d76a1c46d860b83";
	/**
	 * 删除人
	 */
	public static final String USER_LOGIC_DELETE = "f238d1e43ac444218d76a1c46d860b84";
	/**
	 * 打印人
	 */
	public static final String USER_PRINT = "a412cdc935374372b74e8528dd5c4ac8";
	/**
	 * 修改人
	 */
	public static final String USER_UPDATE = "d6b28aac74e1400a87f323c0d982bcb9";

	/**
	 * 处方类型
	 */
	public static final String PRESCRIPTION_TYPE = "592cb6fb4ffa46c7a7a3fcec6aa8b8e5";

	/**
	 * 预约挂号来源 微信
	 */
	public static final String REGISTRATION_SOURCE_WECHAT = "b29e13266012426d8efbba952dc38730";

	/**
	 * 预约挂号来源 门诊窗口
	 */
	public static final String REGISTRATION_SOURCE_WINDOW = "25153ba39d5e4a238bf11c7e5e4f84cb";

	/**
	 * 电子病历父分类ID
	 */
	public static final String EMRTEMPLETE_TYPE_PARENTID = "261cd75dc94641f28a5c3ca648fc21be";

	/**
	 * 住院目的
	 */
	public static final String HOSPITAL_PURPOSES_TYPEID = "1f859d30c70941509871e1460aa9b491";

	/**
	 * 疾病诊断类型
	 */
	public static final String DISEASE_DIAGNOSIS_TYPEID = "857cae4a55244abd90d50ae8d40a1d7c";

	/**
	 * 电子病历模板类型
	 */
	public static final String EMR_TYPE_ID = "f215547698624cefb11fbca1c7bc993f";

	/**
	 * 电子病历模板分类父ID
	 */
	public static final String EMR_CLASS_ID = "261cd75dc94641f28a5c3ca648fc21be";

	/**
	 * 电子病历模板状态 1 未激活
	 */
	public static final Integer EMRTP_STATUS_USE = 1;

	/**
	 * 电子病历模板状态 0 激活
	 */
	public static final Integer EMRTP_STATUS_UNUSE = 0;

	/**
	 * 嘱托医嘱类别
	 */
	public static final String DOCTORADVICE_CATEGORY = "e8682e560444269960e62265";

	/**
	 * 检查医嘱类别
	 */
	public static final String DOCTORADVICE_CHECK = "4e95e17740238321098428e";

	/**
	 * 检验医嘱类别
	 */
	public static final String DOCTORADVICE_TEST = "70e84519e4e5644773951";

	/**
	 * 手术医嘱类别
	 */
	public static final String DOCTORADVICE_SURGERY = "cf91a0ee42e847398b77e226d812cada";

	/**
	 * 病案类型
	 */
	public static final String MEDICAL_RECORD = "3ee1003f7a9545c680e11120c3d78747";
	/**
	 * 不良事件
	 */
	public static final String EVENTS_CLA_ID = "682dfb66f7384e7cb8890a2397a6fdf1";
	/**
	 * 药品不良事件类别ID
	 */
	public static final String DRUG_EVENTS_CLA_ID = "5a86da185ce64f1195fe0ccfbef5bf36";
	/**
	 * 护理不良事件类别ID
	 */
	public static final String NURSE_EVENTS_CLA_ID = "b4bce2abd7104e89885c611cd03db144";

	/**
	 * 通用字典表
	 * 
	 * @author gongliang
	 *
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

	}

	/**
	 * 国籍民族字典表
	 * 
	 * @author gongliang
	 *
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
	 * 临床路径相关
	 * 
	 * @author gongliang 2018-5-12
	 *
	 */
	public static final class ClinicalPathwayType {
		/**
		 * 患者临床路径操作类型
		 * 
		 * 入径
		 */
		public static final String OPERTION_TYPE = "9fa9f9cf3bec43bda9ff4a8398a1c0c8";
		
		public static final String ENTER = "cd2d816ff8544e4ca05ac5f1ebaa54b";
		/**
		 * 符合未进入
		 */
		public static final String UNENTER = "c3817d0a710847a19ef3d192b4ec8dd";
		/**
		 * 退出
		 */
		public static final String EXIT = "feaf935899df45e587f458b6a8cab72";
		/**
		 * 完成
		 */
		public static final String ACHIEVE = "08a6248a64614cc5b0b9cf5d7e33275";
		/**
		 * 退出路径原因
		 */
		public static final String EXIT_REASON_TYPE_ID = "741e2082748a4f66931eefadc228494f";
		
		/**
		 * 患者不同意
		 */
		public static final String PATIENTS_DISAGREE = "90a8a7b3dafa4ca98a6a5270d8379a43";
		/**
		 * 医生确认不进入
		 */
		public static final String NOT_TO_ENTER = "0264069a32e143d6be1c5b91a233868f";
		/**
		 * 变异退出
		 */
		public static final String VARIATION_OF_EXIT = "043fdffcf24e4dd68ef6804cc82e90ae";
	}

	/**
	 * 护理病历模板 状态 0.激活 1.未激活
	 * 
	 * @author gongshuai
	 *
	 */
	public static final class NursingElectronicStatus {
		/**
		 * 0 ：激活
		 */
		public static final Integer ACTIVATION = 0;

		/**
		 * 1 :未激活
		 */
		public static final Integer NOT_ACTIVATION = 1;
	}
	
	/**
	 * 平台session缓存标识
	 * @author zhanghengrui
	 *
	 */
	public static final class SessionCaChePlatform{
		/**
		 * HIS
		 */
		public static final String HIS = "5183250ec8b2413183008a418eaf1cbe";

		/**
		 * 后台管理系统
		 */
		public static final String BACKMGR = "e13b7a0c18984cb59420f196a349af42";
	}
}
