package com.chngenesis.nebula.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.chngenesis.nebula.entity.certification.Certification;
import com.chngenesis.nebula.entity.doctor.Doctor;

public class CourseDiseaseUtil {
	
	/**
	 * 病程日志添加工具类
	 * 
	 * @param bid     		病历ID
	 * @param doctors  		联合会诊医生list对象
	 * @param courseDisease 病程对象
	 * @param patient 		患者对象
	 * @param icd10s 		疾病list对象
	 * @param phyDoctor		主治医生
	 * @return
	 */
	public static Map<String, Object> courseLog(String bid, List<Doctor> doctors, String courseDisease,
			Map<String, Object> patient, List<Map<String, Object>> icd10s, Doctor phyDoctor, Certification certification) {
		// 总map
		Map<String, Object> totalMap = new HashMap<String, Object>();

		totalMap.put("_id", UUIDUtil.getUUID());
		
		// 设置产生来源业务id，如果有
		totalMap.put("SourceID", bid);
		// 日志状态
		totalMap.put("State", "Ture");
		// 病程id
		totalMap.put("CourseDiseaseID", courseDisease);
		// 设置著作人（主治医生）map
		Map<String, Object> authorMap = new HashMap<String, Object>();
		authorMap.put("ID", phyDoctor.getId());
		authorMap.put("Department", phyDoctor.getProfessionType().getValue());
		authorMap.put("Name", phyDoctor.getUser().getName());
		authorMap.put("Sex", phyDoctor.getUser().getSex());
		SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd"); 
		String birthTimeString =formatter.format(phyDoctor.getUser().getBirthday()); 
		authorMap.put("Age", DateUtil.getAgeFromBirthTime(birthTimeString));
		authorMap.put("Certificates", "身份证");
		authorMap.put("DocumentID", phyDoctor.getUser().getNumber());

		// 医生执业证list
		List<Map<String, Object>> qualiList = new ArrayList<Map<String, Object>>();
		Map<String, Object> qualiMap = new HashMap<String, Object>();
		// 查询医生执照
//		qualiMap.put("name", certification.getCertificationConfigure().getName());
//		qualiMap.put("ID", certification.getCertificationConfigure().getNumber());
//		qualiMap.put("TermOfValidity", certification.getObtainTime());
		qualiList.add(qualiMap);
		authorMap.put("Qualification", qualiList);

		// 著作者加入到总map
		totalMap.put("Author", authorMap);

		// 参与人（参与医生）

		if (doctors != null && doctors.size() > 0) {
			List<Map<String, Object>> coauthorsList = new ArrayList<Map<String, Object>>();
			/// 参与者map
			Map<String, Object> coauthorsMap = new HashMap<String, Object>();
			for (Doctor doctor : doctors) {
				coauthorsMap.put("ID", doctor.getId());
				coauthorsMap.put("Department", doctor.getProfessionType().getValue());
				coauthorsMap.put("Name", doctor.getUser().getName());
				coauthorsMap.put("Sex", doctor.getUser().getSex());
				String birthTimeString1 =formatter.format(doctor.getUser().getBirthday()); 
				coauthorsMap.put("Age", DateUtil.getAgeFromBirthTime(birthTimeString1));
				coauthorsMap.put("Certificates", "身份证");
				coauthorsMap.put("DocumentID", doctor.getUser().getNumber());
				coauthorsList.add(coauthorsMap);
			}
			totalMap.put("Co-authors", coauthorsList);
		}

		// 患者 map
		Map<String, Object> patientMap = new HashMap<String, Object>();
		patientMap.put("ID", patient.get("id"));
		patientMap.put("Name", patient.get("name"));
		patientMap.put("Sex", patient.get("sexName"));
		String birthTimeString2 =formatter.format((Date)patient.get("birthday")); 
		patientMap.put("Age", DateUtil.getAgeFromBirthTime(birthTimeString2));
		patientMap.put("Certificates", "身份证");
		patientMap.put("DocumentID", patient.get("documentNumber"));

		totalMap.put("Patient", patientMap);

		// 疾病 list
		List<Map<String, Object>> icd10List = new ArrayList<Map<String, Object>>();
		for (Map<String, Object> icd10 : icd10s) {
			// 疾病 map
			Map<String, Object> icd10Map = new HashMap<String, Object>();
			icd10Map.put("ProcessID", icd10.get("id"));
			icd10Map.put("ICD-10", icd10.get("code"));
			icd10Map.put("Content", icd10.get("name"));
			icd10Map.put("Suspected", icd10.get("fzm"));
			// 添加到疾病list中
			icd10List.add(icd10Map);
		}
		totalMap.put("Disease", icd10List);

		// 医疗内容
		Map<String, Object> detailedMap = new HashMap<String, Object>();
		detailedMap.put("Type", "确诊");
		detailedMap.put("Time", "2017/12/30 18:53:22");
		// 病程描述list
		List<Map<String, Object>> diagnoseList = new ArrayList<Map<String, Object>>();
		Map<String, Object> diagnoseMap = new HashMap<String, Object>();
		diagnoseMap.put("Diagnose", "中梗阻性分娩");
		diagnoseList.add(diagnoseMap);
		detailedMap.put("Content", diagnoseList);

		totalMap.put("Detailed", detailedMap);

		return totalMap;
	}
	
}
