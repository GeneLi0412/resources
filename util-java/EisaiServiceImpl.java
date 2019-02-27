package com.chngenesis.nebula.eisai.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.chngenesis.nebula.base.impl.BaseModel;
import com.chngenesis.nebula.base.impl.BaseQuery;
import com.chngenesis.nebula.base.impl.BaseService;
import com.chngenesis.nebula.base.impl.PageQuery;
import com.chngenesis.nebula.businessutils.BusinessUtils;
import com.chngenesis.nebula.eisai.dao.IEisaiAliasDao;
import com.chngenesis.nebula.eisai.dao.IEisaiDao;
import com.chngenesis.nebula.eisai.dao.IEisaiPackDao;
import com.chngenesis.nebula.eisai.dao.IEisaiStandardDao;
import com.chngenesis.nebula.eisai.service.IEisaiService;
import com.chngenesis.nebula.entity.batch.Supplier;
import com.chngenesis.nebula.entity.dictionary.Classification;
import com.chngenesis.nebula.entity.dictionary.DictionaryData;
import com.chngenesis.nebula.entity.eisai.Eisai;
import com.chngenesis.nebula.entity.eisai.EisaiAlias;
import com.chngenesis.nebula.entity.eisai.EisaiPack;
import com.chngenesis.nebula.entity.eisai.EisaiStandard;
import com.chngenesis.nebula.util.SystemConstant;
import com.chngenesis.nebula.util.UUIDUtil;

@Transactional
@Service
public class EisaiServiceImpl extends BaseService implements IEisaiService{
	
	@Autowired
	private IEisaiDao eisaiDao;
	
	@Autowired
	private IEisaiStandardDao eisaiStandardDao;
	
	@Autowired
	private IEisaiPackDao eisaiPackDao;
	
	@Autowired
	private IEisaiAliasDao eisaiAliasDao;

	@Override
	public BaseModel<Eisai> save(Eisai entity) {
		BaseModel<Eisai> baseModel = new BaseModel<Eisai>();
		try {
			String uuid = UUIDUtil.getUUID();
			entity.setId(uuid);
			eisaiDao.save(entity);
			baseModel.setMessage(SystemConfigMessage.SAVE_SUCCEED);
			baseModel.setError(false);
			baseModel.setInsertUuid(uuid);
			return baseModel;
		} catch (Exception e) {
			e.printStackTrace();
			baseModel.setMessage(SystemConfigMessage.SAVE_FAILURE);
			baseModel.setError(true);
			baseModel.setException(e);
			return baseModel;
		}
	}

	@Override
	public BaseModel<Eisai> delete(String id) {
		BaseModel<Eisai> baseModel = new BaseModel<Eisai>();
		try {
			eisaiDao.delete(id);
			baseModel.setMessage(SystemConfigMessage.DELETED_SUCCEED);
			baseModel.setError(false);
			return baseModel;
		} catch (Exception e) {
			e.printStackTrace();
			baseModel.setMessage(SystemConfigMessage.DELETED_FAILURE);
			baseModel.setError(true);
			baseModel.setException(e);
			return baseModel;
		}
	}

	@Override
	public BaseModel<Eisai> update(Eisai entity) {
		BaseModel<Eisai> baseModel = new BaseModel<Eisai>();
		try {
			eisaiDao.update(entity);
			baseModel.setMessage(SystemConfigMessage.UPDATE_SUCCEED);
			baseModel.setError(false);
			return baseModel;
		} catch (Exception e) {
			e.printStackTrace();
			baseModel.setMessage(SystemConfigMessage.UPDATE_FAILURE);
			baseModel.setError(true);
			baseModel.setException(e);
			return baseModel;
		}
	}

	@Override
	public BaseModel<Eisai> queryById(String id) {
		BaseModel<Eisai> baseModel = new BaseModel<Eisai>();
		try {
			Eisai entity = eisaiDao.queryById(id);
			baseModel.setMessage(SystemConfigMessage.OPERATION_SUCCESSFULLY);
			baseModel.setError(false);
			baseModel.setResultDomain(entity);
			return baseModel;
		} catch (Exception e) {
			e.printStackTrace();
			baseModel.setMessage(SystemConfigMessage.OPERATION_FAILURE);
			baseModel.setError(true);
			baseModel.setException(e);
			return baseModel;
		}
	}

	@Override
	public BaseModel<Eisai> queryByIds(String[] ids) {
		BaseModel<Eisai> baseModel = new BaseModel<Eisai>();
		try {
			List<Eisai> entitys = eisaiDao.queryByIds(ids);
			baseModel.setMessage(SystemConfigMessage.OPERATION_SUCCESSFULLY);
			baseModel.setError(false);
			baseModel.setResultDomains(entitys);
			return baseModel;
		} catch (Exception e) {
			e.printStackTrace();
			baseModel.setMessage(SystemConfigMessage.OPERATION_FAILURE);
			baseModel.setError(true);
			baseModel.setException(e);
			return baseModel;
		}
	}

	@Override
	public BaseModel<Eisai> queryAll() {
		BaseModel<Eisai> baseModel = new BaseModel<Eisai>();
		try {
			List<Eisai> entitys = eisaiDao.queryAll();
			baseModel.setMessage(SystemConfigMessage.OPERATION_SUCCESSFULLY);
			baseModel.setError(false);
			baseModel.setResultDomains(entitys);
			return baseModel;
		} catch (Exception e) {
			e.printStackTrace();
			baseModel.setMessage(SystemConfigMessage.OPERATION_FAILURE);
			baseModel.setError(true);
			baseModel.setException(e);
			return baseModel;
		}
	}

	@Override
	public BaseModel<Eisai> pageQuery(BaseQuery<Eisai> baseQuery, Eisai entity) {
		BaseModel<Eisai> baseModel = new BaseModel<Eisai>();
		List<Eisai> menuList = eisaiDao.findByPage(baseQuery, entity);
		Integer totalNumber = eisaiDao.getTotalNumber(baseQuery, entity);
		PageQuery<Eisai> pageQuery = new PageQuery<Eisai>(baseQuery.getCurrentPage(), baseQuery.getPageNum(), totalNumber,
				menuList);
		baseModel.setMessage(SystemConfigMessage.OPERATION_SUCCESSFULLY);
		baseModel.setBaseQuery(pageQuery);
		baseModel.setResultDomains(menuList);
		baseModel.setError(false);
		return baseModel;
	}

	@Override
	public Integer getTotalNumber(BaseQuery<Eisai> baseQuery) {

		return eisaiDao.getTotalNumber(baseQuery);
	}

	@Override
	public boolean checkExist(String queryName, Object value) {
		return eisaiDao.checkExist(queryName, value);
	}

	@Override
	public BaseModel<Eisai> logicDelete(String id) {
		BaseModel<Eisai> baseModel = new BaseModel<Eisai>();
		try {
			eisaiDao.logicDelete(id);
			baseModel.setMessage(SystemConfigMessage.DELETED_SUCCEED);
			baseModel.setError(false);
			return baseModel;
		} catch (Exception e) {
			e.printStackTrace();
			baseModel.setMessage(SystemConfigMessage.DELETED_FAILURE);
			baseModel.setError(true);
			baseModel.setException(e);
			return baseModel;
		}
	}

	@Override
	public BaseModel<Eisai> logicDeleteByIds(String[] ids) {
		BaseModel<Eisai> baseModel = new BaseModel<Eisai>();
		try {
			eisaiDao.logicDeleteByIds(ids);
			baseModel.setMessage(SystemConfigMessage.DELETED_SUCCEED);
			baseModel.setError(false);
			return baseModel;
		} catch (Exception e) {
			e.printStackTrace();
			baseModel.setMessage(SystemConfigMessage.DELETED_FAILURE);
			baseModel.setError(true);
			baseModel.setException(e);
			return baseModel;
		}
	}

	@Override
	public BaseModel<Map<String, Object>> queryByNameToMap(String name) {
		BaseModel<Map<String, Object>> baseModel = new BaseModel<Map<String, Object>>();
		baseModel.setMessage(SystemConfigMessage.OPERATION_SUCCESSFULLY);
		baseModel.setError(true);
		try {
			List<Map<String, Object>> items= eisaiAliasDao.queryByName(name);
		    baseModel.setResultDomains(items);
			return baseModel;
		} catch (Exception e) {
			e.printStackTrace();
			baseModel.setMessage(SystemConfigMessage.OPERATION_FAILURE);
			baseModel.setError(true);
			baseModel.setException(e);
			return baseModel;
		}
		
	}

	@Override
	public List<Map<String, Object>> queryByEisaiId(String eisaiId) {
		List<Map<String,Object>> list = eisaiStandardDao.queryByEisaiId(eisaiId);
		return list;
	}
	
	@Override
	public List<Map<String, Object>> queryByEisaiStandardId(String standardId) {
		List<Map<String, Object>> list = eisaiPackDao.queryByEisaiStandardId(standardId);
		return list;
	}

	@Override
	public Map<String, Object> queryAllEisaiForPage(String queryText, Integer page, Integer rows) {
		Map<String, Object> base = new HashMap<>();
		// 查询总记录数
		Integer recodCount = eisaiPackDao.queryTotalRecods(queryText);
		// 存在记录
		List<Map<String, Object>> recodDetails = new ArrayList<>();
		if(recodCount > 0) {
			recodDetails = eisaiPackDao.queryAllEisaiForPage(queryText, page, rows);
		}
		base.put("total", recodCount);
		base.put("rows", recodDetails);
		base.put("error", false);
		base.put("message", SystemConfigMessage.OPERATION_SUCCESSFULLY);
		return base;
	}

	@Override
	public Map<String, Object> queryEisaiDetails(String eisaId) {
		Map<String, Object> base = new HashMap<>();
		// 查询卫材基本信息
		Map<String, Object> eisai = eisaiDao.queryByHId(eisaId);
		// 查询卫材通用名
		List<Map<String, Object>> publicNames = eisaiAliasDao.queryAllByEisai(eisaId);
		eisai.put("eisaiAlias", publicNames);
		// 查询药品规格
		List<Map<String, Object>> eisaiStandards = eisaiStandardDao.queryFullByEisai(eisaId);
		// 查询规格下的包装信息
		eisaiStandards.stream().forEach(standard->{
			// 获取标准ID
			String standardId = String.valueOf(standard.get("id"));
			// 查询包装
			List<Map<String, Object>> packs = eisaiPackDao.queryFullByEisaiStandard(standardId);
			packs.stream().forEach(pack->{
				// 包装ID
				String packId = String.valueOf(pack.get("id"));
				// 获得包装计量
				Map<String, Object> eisaiPackDose = BusinessUtils.getEisaiPackDose(packId, eisaiPackDao);
				pack.put("packMetering", eisaiPackDose.get("packDose"));
			});
			// 根据
			standard.put("packs", packs);
		});
		eisai.put("eisaiStandards", eisaiStandards);
		base.put("result", eisai);
		base.put("error", false);
		base.put("message", SystemConfigMessage.OPERATION_SUCCESSFULLY);
		return base;
	}

	@Override
	public Map<String, Object> saveOrUpdateEisaiInfo(String content) {
		Map<String, Object> base = new HashMap<>();
		// 获取JSON对象
		JSONObject contentObject = JSON.parseObject(content);
		/*** 卫材基本信息  ***/
		JSONObject eisaiJson = contentObject.getJSONObject("eisai");
		// 获取卫材对象
		Eisai eisai = contentObject.getObject("eisai", Eisai.class);
		// 卫材分类  注：JSON转对象，只适用于基础数据类型
		String classificationId = eisaiJson.getString("classification.id");
		if(StringUtils.isNotBlank(classificationId)) {
			eisai.setClassification(new Classification(classificationId));
		}
		// 卫材类型
		String typeId = eisaiJson.getString("type.id");
		if(StringUtils.isNotBlank(typeId)) {
			eisai.setType(new DictionaryData(typeId));
		}
		// 卫材有效期单位
		String validityUnitId = eisaiJson.getString("validityUnit.id");
		if(StringUtils.isNotBlank(validityUnitId)) {
			eisai.setValidityUnit(new DictionaryData(validityUnitId));
		}
		// 卫材编码，唯一不重复
		Integer eisaiNumber;
		if(StringUtils.isBlank(eisai.getNumber())) {
			eisaiNumber = 10000 + eisaiDao.queryRecodCount();
		}else {
			eisaiNumber = Integer.parseInt(eisai.getNumber());
		}
		while(eisaiDao.isExistNumber(String.valueOf(eisaiNumber), eisai.getId())) {
			eisaiNumber++;
		}
		eisai.setNumber(String.valueOf(eisaiNumber));
		// 持久化
		if(StringUtils.isBlank(eisai.getId())) {
			eisai.setId(UUIDUtil.getUUID());
			eisaiDao.save(eisai);
		}else {
			eisaiDao.update(eisai);
			// 清空所有的别名
			List<String> eisaiAliasIds = eisaiAliasDao.queryIdsByEisai(eisai.getId());
			if(eisaiAliasIds!=null && eisaiAliasIds.size()>0) {
				for (String eisaiAliasId : eisaiAliasIds) {
					eisaiAliasDao.delete(eisaiAliasId);
				}
			}
		}
		/*** 卫材别名 ***/
		JSONArray eisaiAliases = contentObject.getJSONArray("eisaiAlias");
		// 获取别名对象
		List<EisaiAlias> eisaiAliasList = eisaiAliases.toJavaList(EisaiAlias.class);
		for (EisaiAlias eisaiAlias : eisaiAliasList) {
			eisaiAlias.setId(UUIDUtil.getUUID());
			// 关联卫材ID
			eisaiAlias.setEisai(eisai);
			eisaiAliasDao.save(eisaiAlias);
		}
		/*** 规格 ***/
		boolean haveBasicPack = false;
		JSONArray eisaiStandardObjs = contentObject.getJSONArray("eisaiStandards");
		// 获得规格对象列表
		List<EisaiStandard> eisaiStandardList = eisaiStandardObjs.toJavaList(EisaiStandard.class);
		for(int i=0;i<eisaiStandardList.size();i++) {
			EisaiStandard eisaiStandard = eisaiStandardList.get(i);
			// 获得对应的JSON对象
			JSONObject eisaiStandardObj = eisaiStandardObjs.getJSONObject(i);
			// 绑定卫材
			eisaiStandard.setEisai(eisai);
			// 规格最小单位
			String minunitId = eisaiStandardObj.getString("minUnit.id");
			if(StringUtils.isNotBlank(minunitId)) {
				eisaiStandard.setMinUnit(new DictionaryData(minunitId));
			}
			// 规格供应商
			String supplierId = eisaiStandardObj.getString("supplier.id");
			if(StringUtils.isNotBlank(supplierId)) {
				eisaiStandard.setSupplier(new Supplier(supplierId));
			}
			// 规格品牌
			String brandId = eisaiStandardObj.getString("brand.id");
			if(StringUtils.isNotBlank(brandId)) {
				eisaiStandard.setBrand(new DictionaryData(brandId));
			}
			// 规格编码  注：编码由后台生成，前端仅做展示
			if(StringUtils.isBlank(eisaiStandard.getNumber())) {
				Integer standardNumber = 10000 + eisaiStandardDao.queryRecodCount();
				while(eisaiStandardDao.isExistNumber(String.valueOf(standardNumber), eisaiStandard.getId())) {
					standardNumber++;
				}
				eisaiStandard.setNumber(String.valueOf(standardNumber));
			}
			// 持久化
			if(StringUtils.isBlank(eisaiStandard.getId())) {
				eisaiStandard.setId(UUIDUtil.getUUID());
				eisaiStandardDao.save(eisaiStandard);
			}else {
				eisaiStandardDao.update(eisaiStandard);
			}
			/*** 包装 ***/
			JSONArray eisaiPackObjs = eisaiStandardObj.getJSONArray("packs");
			// 获得包装对象
			List<EisaiPack> eisaiPackList = eisaiPackObjs.toJavaList(EisaiPack.class);
			for(int j=0;j<eisaiPackList.size();j++) {
				EisaiPack eisaiPack = eisaiPackList.get(j);
				// 获得JSON对象
				JSONObject eisaiPackObj = eisaiPackObjs.getJSONObject(j);
				// 绑定卫材规格
				eisaiPack.setEisaiStandard(eisaiStandard);
				// 基本包装限定
				if(eisaiPack.getBasicUnit() == SystemConstant.EisaiPackAbout.IS_BASIC_PACK) {
					haveBasicPack = true;
				}
				// 包装计量
				String packMetering = eisaiPackObj.getString("packMetering");
				// 规格计量
				String standardMetering = eisaiStandardObj.getString("dose");
				// 获得转换比
				String convertRelation = (StringUtils.isNotBlank(packMetering)?packMetering:"1")
						+ "/" + (StringUtils.isNotBlank(standardMetering)?standardMetering:"1");
				eisaiPack.setConvertRelation(convertRelation);
				// 持久化
				if(StringUtils.isBlank(eisaiPack.getId())) {
					eisaiPack.setId(UUIDUtil.getUUID());
					eisaiPackDao.save(eisaiPack);
				}else {
					eisaiPackDao.update(eisaiPack);
				}
			}
		}
		// 基本包装判定
		if(!haveBasicPack) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			base.put("error", true);
			base.put("message", "请为卫材添加至少一个基本包装！");
			return base;
		}
		base.put("error", false);
		base.put("message", SystemConfigMessage.OPERATION_SUCCESSFULLY);
		return base;
	}
}
