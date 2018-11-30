package com.chngenesis.nebula.util;

import java.math.BigDecimal;
import java.util.Date;

import com.chngenesis.nebula.entity.cost.CostDetails;
import com.chngenesis.nebula.entity.log.CostDetailsOperateLog;
import com.chngenesis.nebula.entity.log.CostOperateLog;
import com.chngenesis.nebula.entity.log.FundsmentDetailsLog;
import com.chngenesis.nebula.entity.patient.MoneyFlow;
import com.chngenesis.nebula.entity.patient.PatientFunds;
import com.chngenesis.nebula.entity.user.User;
import com.chngenesis.nebula.util.SystemConstant.FundOperation;
import com.chngenesis.nebula.util.SystemConstant.OperatingCost;

/**
 * 费用日志操作类
 * @author yangxiao
 *
 */
public class CostOperationLog {
	
	/**
	 * 支付流水操作日志
	 * @param costDetails
	 * @return
	 */
	public static CostDetailsOperateLog costDetailsOperate(CostDetails costDetails, String outTradeNo){
		CostDetailsOperateLog costDetailsOperateLog = new CostDetailsOperateLog();
		// 设置Id
		costDetailsOperateLog.setId(UUIDUtil.getUUID());
		// 设置支付明细
		costDetailsOperateLog.setCostDetails(costDetails);
		// 备注
		costDetailsOperateLog.setMark("支付流水操作");
		// 订单号
		costDetailsOperateLog.setOutTradeNo(outTradeNo);
		return costDetailsOperateLog;
	}
	
	/**O
	 * 费用操作日志
	 * @param userId   操作人Id
	 * @param costId   费用Id
	 * @return
	 */
	public static CostOperateLog costOperateLog(String userId, String costId){
		CostOperateLog costOperateLog = new CostOperateLog();
		// 设置Id
		costOperateLog.setId(UUIDUtil.getUUID());
		// 设置操作员
		costOperateLog.setUserid(userId);
		// 设置费用
		costOperateLog.setCostid(costId);
		// 设置时间
		costOperateLog.setCattime(new Date());
		// 设置备注
		costOperateLog.setMark("费用操作日志");
		return costOperateLog;
	}
	
	/**
	 * 支付详情表
	 * @param fundsDocumentsId	支付单据Id
	 * @param amount			金额
	 * @param payMethodId		支付方式Id
	 * @param conext			详细信息
	 * @param payMethod			描述文本(支付方式)
	 * @return
	 */
	public static FundsmentDetailsLog fundsmentDetailsLog(String fundsDocumentsId, BigDecimal amount, String payMethodId, Object conext, 
			String payMethod, String refundMethodId){
		FundsmentDetailsLog fundsmentDetailsLogs = new FundsmentDetailsLog();
		// 设置Id
		fundsmentDetailsLogs.setId(UUIDUtil.getUUID());
		// 支付单据Id
		fundsmentDetailsLogs.setFundsDocumentsId(fundsDocumentsId);
		// 金额
		fundsmentDetailsLogs.setAmount(amount);
		// 操作时间
		fundsmentDetailsLogs.setOperTime(new Date());
		// 支付方式Id
		fundsmentDetailsLogs.setPayMethod(payMethodId);
		// 退款方式
		fundsmentDetailsLogs.setRefundMethod(refundMethodId);;
		// 描述文本
		fundsmentDetailsLogs.setDescription(payMethod);
		// 详细信息
		fundsmentDetailsLogs.setConext(conext);
		
		return fundsmentDetailsLogs;
	}
	
	/**
	 * 患者资金操作日志
	 * @param patientFunds   患者资金信息
	 * @param balance	操作资金
	 * @param type		 类型 收入  0 支出  1
	 * @param user		操作人
	 * @param balancebeginning	期初资金
	 * @param balanceendPeriod	期末资金
	 * @return
	 */
	public static MoneyFlow moneyFlowLog(PatientFunds patientFunds, String balance, Integer type, User user, 
			String balancebeginning, String balanceendPeriod, String feeType) {
		MoneyFlow moneyFlow = new MoneyFlow();
		// 设置Id
		moneyFlow.setId(UUIDUtil.getUUID());
		// 设置患者资金信息
		moneyFlow.setPatientFunds(patientFunds);
		// 类型 收入  0 支出  1
		moneyFlow.setType(type);
		// 操作时间
		moneyFlow.setOperatetime(new Date());
		// 操作人
		moneyFlow.setUser(user);
		// 余额操作金额
		moneyFlow.setBalance(ThreeDES.encrypt(balance));
		// 余额期初
		moneyFlow.setBalancebeginning(ThreeDES.encrypt(new BigDecimal(balancebeginning).toString()));
		// 余额期末
		moneyFlow.setBalanceendPeriod(ThreeDES.encrypt(new BigDecimal(balanceendPeriod).toString()));
		// 摘要
		String typeValue = FundOperation.INCOME;
		if(OperatingCost.SPENDING == type) {
			 typeValue = FundOperation.SPENDING;
		}
		moneyFlow.setSummary("患者资金操作:"+feeType+";资金操作类型："+typeValue+";操作时间："+moneyFlow.getOperatetime()+
				";操作人:"+moneyFlow.getUser().getName()+
				";操作资金:"+ThreeDES.decrypt(moneyFlow.getBalance())+
				";余额期初:"+ThreeDES.decrypt(moneyFlow.getBalancebeginning())+
				";余额期末:" +ThreeDES.decrypt(moneyFlow.getPatientFunds().getBalanceInfo()));
		return moneyFlow;
	}
}
