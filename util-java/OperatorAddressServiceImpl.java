package com.chngenesis.nebula.operator.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chngenesis.nebula.base.impl.BaseModel;
import com.chngenesis.nebula.base.impl.BaseQuery;
import com.chngenesis.nebula.base.impl.BaseService;
import com.chngenesis.nebula.base.impl.PageQuery;
import com.chngenesis.nebula.entity.operator.OperatorAddress;
import com.chngenesis.nebula.entity.operator.OperatorAddressTree;
import com.chngenesis.nebula.entity.operator.OperatorPermission;
import com.chngenesis.nebula.entity.operator.Permission;
import com.chngenesis.nebula.entity.operator.UserGroupMember;
import com.chngenesis.nebula.entity.session.SessionCache;
import com.chngenesis.nebula.entity.user.User;
import com.chngenesis.nebula.operator.dao.IOperatorAddressDao;
import com.chngenesis.nebula.operator.dao.IOperatorPermissionDao;
import com.chngenesis.nebula.operator.dao.IPermissionDao;
import com.chngenesis.nebula.operator.dao.IUserGroupMemberDao;
import com.chngenesis.nebula.operator.dao.IWorkingGroupDao;
import com.chngenesis.nebula.operator.service.IOperatorAddressService;
import com.chngenesis.nebula.platform.dao.IPlatformDao;
import com.chngenesis.nebula.session.dao.SessionCacheDao;
import com.chngenesis.nebula.user.dao.IUserDao;
import com.chngenesis.nebula.util.UUIDUtil;

/**
 * 菜单服务
 *
 * @author yaofei
 */
@Service("operatorAddressServiceImpl")
@Transactional
public class OperatorAddressServiceImpl extends BaseService implements IOperatorAddressService {

	@Autowired
	private IOperatorAddressDao operatorAddressDao;

	@Autowired
	private IUserGroupMemberDao userGroupMemberDao;

	@Autowired
	private IPermissionDao permissionDao;

	@Autowired
	private IOperatorPermissionDao operatorPermissionDao;

	@Autowired
	private IUserDao userDao;

	@Autowired
	private IPlatformDao platformDao;

	@Autowired
	private IWorkingGroupDao workingGroupDao;

	@Autowired
	private SessionCacheDao sessionCacheDao;

	@Override
	public BaseModel<OperatorAddress> save(OperatorAddress entity) {

		BaseModel<OperatorAddress> baseModel = new BaseModel<OperatorAddress>();
		try {
			String id = entity.getId();
			if (StringUtils.isBlank(id)) {
				entity.setId(UUIDUtil.getUUID());
			}
			if (StringUtils.isBlank(entity.getParentId())) {
				entity.setParentId("0");
			}

			operatorAddressDao.save(entity);
			baseModel.setMessage(SystemConfigMessage.SAVE_SUCCEED);
			baseModel.setError(false);
			return baseModel;

		} catch (Exception e) {

			e.printStackTrace();
			baseModel.setMessage(SystemConfigMessage.SAVE_FAILURE);
			baseModel.setException(e);
			baseModel.setError(true);
			return baseModel;
		}

	}

	@Override
	public BaseModel<OperatorAddress> delete(String id) {

		BaseModel<OperatorAddress> baseModel = new BaseModel<OperatorAddress>();
		try {

			operatorAddressDao.delete(id);
			baseModel.setError(false);
			baseModel.setMessage(SystemConfigMessage.DELETED_SUCCEED);
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
	public BaseModel<OperatorAddress> deleteOwnAndChildrens(String id) {
		BaseModel<OperatorAddress> baseModel = new BaseModel<OperatorAddress>();
		try {
			List<OperatorAddress> menus = operatorAddressDao.queryAll();
			delete(menus, id);
			operatorAddressDao.delete(id);
			baseModel.setError(false);
			baseModel.setMessage(SystemConfigMessage.DELETED_SUCCEED);
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
	public BaseModel<OperatorAddress> update(OperatorAddress entity) {

		BaseModel<OperatorAddress> baseModel = new BaseModel<OperatorAddress>();
		try {
			operatorAddressDao.update(entity);
			baseModel.setError(false);
			baseModel.setMessage(SystemConfigMessage.UPDATE_SUCCEED);
			return baseModel;
		} catch (Exception e) {
			e.printStackTrace();
			baseModel.setError(true);
			baseModel.setMessage(SystemConfigMessage.UPDATE_FAILURE);
			baseModel.setException(e);
			return baseModel;
		}

	}

	@Override
	public BaseModel<OperatorAddress> queryById(String id) {

		BaseModel<OperatorAddress> baseModel = new BaseModel<OperatorAddress>();
		try {
			OperatorAddress resultDomain = operatorAddressDao.queryById(id);
			baseModel.setError(false);
			baseModel.setMessage(SystemConfigMessage.OPERATION_SUCCESSFULLY);
			baseModel.setResultDomain(resultDomain);
			return baseModel;
		} catch (Exception e) {
			e.printStackTrace();
			baseModel.setError(true);
			baseModel.setMessage(SystemConfigMessage.OPERATION_FAILURE);
			baseModel.setException(e);
			return baseModel;
		}

	}

	@Override
	public BaseModel<OperatorAddress> queryByIds(String[] ids) {
		BaseModel<OperatorAddress> baseModel = new BaseModel<OperatorAddress>();
		try {
			List<OperatorAddress> resultDomains = operatorAddressDao.queryByIds(ids);
			baseModel.setMessage(SystemConfigMessage.OPERATION_SUCCESSFULLY);
			baseModel.setError(false);
			baseModel.setResultDomains(resultDomains);
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
	public BaseModel<OperatorAddress> queryAll() {
		BaseModel<OperatorAddress> baseModel = new BaseModel<OperatorAddress>();
		try {
			List<OperatorAddress> resultDomains = operatorAddressDao.queryAll();
			baseModel.setMessage(SystemConfigMessage.OPERATION_SUCCESSFULLY);
			baseModel.setError(false);
			baseModel.setResultDomains(resultDomains);
			return baseModel;
		} catch (Exception e) {
			e.printStackTrace();
			baseModel.setMessage(SystemConfigMessage.OPERATION_FAILURE);
			baseModel.setException(e);
			baseModel.setError(true);
			return baseModel;
		}

	}

	@Override
	public BaseModel<OperatorAddress> pageQuery(BaseQuery<OperatorAddress> baseQuery, OperatorAddress entity) {
		BaseModel<OperatorAddress> baseModel = new BaseModel<OperatorAddress>();
		List<OperatorAddress> resultDomains = operatorAddressDao.findByPage(baseQuery, entity);
		Integer totalNumber = operatorAddressDao.getTotalNumber(baseQuery, entity);
		PageQuery<OperatorAddress> pageQuery = new PageQuery<OperatorAddress>(baseQuery.getCurrentPage(),
				baseQuery.getPageNum(), totalNumber, resultDomains);
		baseModel.setError(false);
		baseModel.setMessage(SystemConfigMessage.OPERATION_SUCCESSFULLY);
		baseModel.setResultDomains(resultDomains);
		baseModel.setBaseQuery(pageQuery);
		return baseModel;
	}

	@Override
	public Integer getTotalNumber(BaseQuery<OperatorAddress> baseQuery) {
		return operatorAddressDao.getTotalNumber(baseQuery);
	}

	@Override
	public boolean checkExist(String queryName, Object value) {
		return operatorAddressDao.checkExist(queryName, value);
	}

	@Override
	public BaseModel<OperatorAddress> queryByUserAndPlatform(String userId, String platformId) {
		BaseModel<OperatorAddress> baseModel = new BaseModel<OperatorAddress>();
		List<UserGroupMember> userGroupMembers = userGroupMemberDao.queryByUserId(userId);
		List<String> workGroupIds = new ArrayList<String>();
		if (userGroupMembers == null) {
			return null;
		}

		for (int i = 0; i < userGroupMembers.size(); i++) {
			workGroupIds.add(userGroupMembers.get(i).getWorkingGroup().getId());
		}

		List<Permission> permissions = new ArrayList<Permission>();
		for (String s : workGroupIds) {
			permissions.addAll(permissionDao.queryByFunctionId(s));
		}

		List<Permission> userPermissions = permissionDao.queryByFunctionId(userId);

		if (userPermissions != null) {
			permissions.addAll(userPermissions);
		}

		Set<OperatorAddress> sets = new HashSet<OperatorAddress>();
		for (Permission permission : permissions) {
			List<OperatorPermission> operatorPermissions = operatorPermissionDao
					.queryByPermissionId(permission.getId());
			for (OperatorPermission operatorPermission : operatorPermissions) {
				if (operatorPermission.getType().compareTo(OperatorPermission.Type.Yes.code) == 0) {
					sets.add(operatorAddressDao.queryById(operatorPermission.getOperationAddress().getId()));
				}
			}
		}

		List<OperatorAddress> operatorAddresses = new ArrayList<OperatorAddress>();
		Iterator<OperatorAddress> itertor = sets.iterator();

		while (itertor.hasNext()) {
			operatorAddresses.add(itertor.next());
		}

		baseModel.setResultDomains(operatorAddresses);
		baseModel.setMessage(SystemConfigMessage.OPERATION_SUCCESSFULLY);
		baseModel.setError(false);
		return baseModel;
	}

	@Override
	public BaseModel<OperatorAddress> queryByUserAndPlatform(String userId, String platformId, Integer type) {

		BaseModel<OperatorAddress> baseModel = new BaseModel<OperatorAddress>();
		List<UserGroupMember> userGroupMembers = userGroupMemberDao.queryByUserId(userId);
		List<String> workGroupIds = new ArrayList<String>();
		if (userGroupMembers == null) {
			return null;
		}

		for (int i = 0; i < userGroupMembers.size(); i++) {
			workGroupIds.add(userGroupMembers.get(i).getWorkingGroup().getId());
		}

		List<Permission> permissions = new ArrayList<Permission>();
		for (String s : workGroupIds) {
			permissions.addAll(permissionDao.queryByFunctionId(s));
		}

		List<Permission> userPermissions = permissionDao.queryByFunctionId(userId);

		if (userPermissions != null) {
			permissions.addAll(userPermissions);
		}

		Set<OperatorAddress> sets = new HashSet<OperatorAddress>();
		for (Permission permission : permissions) {
			List<OperatorPermission> operatorPermissions = operatorPermissionDao
					.queryByPermissionId(permission.getId());
			for (OperatorPermission operatorPermission : operatorPermissions) {
				if (operatorPermission.getType().compareTo(OperatorPermission.Type.Yes.code) == 0) {
					OperatorAddress o = operatorAddressDao.queryById(operatorPermission.getOperationAddress().getId());
					if (o.getType().compareTo(1) == 0) {
						sets.add(o);
					}
				}
			}
		}

		List<OperatorAddress> operatorAddresses = new ArrayList<OperatorAddress>();
		Iterator<OperatorAddress> itertor = sets.iterator();

		while (itertor.hasNext()) {
			operatorAddresses.add(itertor.next());
		}

		baseModel.setResultDomains(operatorAddresses);
		baseModel.setMessage(SystemConfigMessage.OPERATION_SUCCESSFULLY);
		baseModel.setError(false);
		return baseModel;
	}

	@Override
	public BaseModel<OperatorAddress> queryByUser(String userId) {
		BaseModel<OperatorAddress> baseModel = new BaseModel<OperatorAddress>();
		User user = userDao.queryById(userId);
		if (user == null) {
			baseModel.setError(true);
			baseModel.setMessage(SystemConfigMessage.OPERATION_FAILURE);
			return baseModel;
		}

		if (user.getSuper() == 1) {
			List<OperatorAddress> operatorAddresses = operatorAddressDao.queryAll();
			baseModel.setResultDomains(operatorAddresses);
			baseModel.setMessage(SystemConfigMessage.OPERATION_SUCCESSFULLY);
			baseModel.setError(false);
			return baseModel;
		}

		baseModel.setMessage(SystemConfigMessage.NOT_ADMIN);
		baseModel.setError(false);
		return baseModel;
	}

	/***
	 * 递归遍历下级菜单
	 *
	 * @param menuList
	 * @return
	 */
	public List<Object> getMenus(List<OperatorAddressTree> menuList) {
		if (menuList != null && menuList.size() > 0) {
			List<Object> list = new ArrayList<>();
			SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			for (OperatorAddressTree menu : menuList) {
				Map<String, Object> map = new HashMap<>();
				map.put("id", menu.getId());
				map.put("name", menu.getName());
				map.put("text", menu.getName());
				map.put("code", menu.getCode());
				map.put("url", menu.getUrl());
				map.put("icon", menu.getIcon());
				map.put("type", menu.getType());
				map.put("order", menu.getOrder());
				map.put("platformId", platformDao.queryById(menu.getPlatformId()).getName());
				if (menu.getCreateTime() != null) {
					map.put("createTime", sd.format(menu.getCreateTime()));
				}
				map.put("createBy", menu.getCreateBy());
				if (menu.getUpdateTime() != null) {
					map.put("updateTime", menu.getUpdateTime());
				}
				map.put("updateBy", menu.getUpdateBy());
				list.add(map);
				map.put("children", getMenus(menu.getChildrends()));
			}
			return list;
		}
		return null;
	}

	/**
	 * 删除菜单的所有子菜单
	 *
	 * @param list
	 * @param id
	 * @return
	 */
	public void delete(List<OperatorAddress> list, String id) {

		for (OperatorAddress item : list) {
			if (item.getParentId().equals(id)) {
				operatorAddressDao.delete(item.getId());
				delete(list, item.getId());
			}
		}

	}

	@Override
	public BaseModel<OperatorAddressTree> menuToTree() {
		BaseModel<OperatorAddressTree> baseModel = new BaseModel<OperatorAddressTree>();
		try {
			List<OperatorAddress> resultDomains = operatorAddressDao.queryAll();
			List<OperatorAddressTree> list = OperatorAddressTree.menuToTree(resultDomains, "0");
			baseModel.setMessage(SystemConfigMessage.OPERATION_SUCCESSFULLY);
			baseModel.setError(false);
			baseModel.setResultDomains(list);
			return baseModel;
		} catch (Exception e) {
			e.printStackTrace();
			baseModel.setMessage(SystemConfigMessage.OPERATION_FAILURE);
			baseModel.setException(e);
			baseModel.setError(true);
			return baseModel;
		}
	}

	@Override
	public BaseModel<OperatorAddress> queryByTree() {
		BaseModel<OperatorAddress> baseModel = new BaseModel<>();
		try {
			List<OperatorAddress> list = operatorAddressDao.queryAll();
			List<OperatorAddress> resultDomains = new ArrayList<>();
			for (OperatorAddress item : list) {
				if (item.getType().compareTo(1) == 0) {
					resultDomains.add(item);
				}
			}

			baseModel.setResultDomains(resultDomains);
			baseModel.setMessage(SystemConfigMessage.OPERATION_SUCCESSFULLY);
			baseModel.setError(false);
			return baseModel;
		} catch (Exception e) {
			baseModel.setMessage(SystemConfigMessage.OPERATION_FAILURE);
			baseModel.setError(true);
			baseModel.setException(e);
			return baseModel;
		}

	}

	@Override
	public BaseModel<Object> queryByTreeId(String treeId) {
		BaseModel<Object> baseModel = new BaseModel<>();
		try {
			List<OperatorAddress> operatorAddresses = operatorAddressDao.queryAll();
			List<OperatorAddressTree> list = OperatorAddressTree.menuToTreeByTreeId(operatorAddresses, treeId);
			List<Object> result = getMenus(list);
			baseModel.setMessage(SystemConfigMessage.OPERATION_SUCCESSFULLY);
			baseModel.setError(false);
			baseModel.setResultDomains(result);
			return baseModel;
		} catch (Exception e) {
			e.printStackTrace();
			baseModel.setMessage(SystemConfigMessage.OPERATION_FAILURE);
			baseModel.setException(e);
			baseModel.setError(true);
			return baseModel;
		}
	}

	@Override
	public BaseModel<OperatorAddress> queryByTree(String userId, String platfrome) {
		BaseModel<OperatorAddress> baseModel = new BaseModel<>();
		Set<OperatorAddress> operatorSets = new HashSet<>();
		List<String> functionIds = userGroupMemberDao.queryWgIdsByUserId(userId);
		functionIds.add(userId);
		for (String functionId : functionIds) {
			String permissionId = permissionDao.queryIdsByFunctionId(functionId);
			List<String> operatorIds = operatorPermissionDao.queryOperaAdsIdsByPermId(permissionId);
			for (String operatorId : operatorIds) {
				OperatorAddress operator = operatorAddressDao.queryById(operatorId);
				if (operator != null) {
					if (operator.getPlatformId().equals(platfrome) && operator.getType().compareTo(1) == 0) {
						if (StringUtils.isBlank(operator.getIcon())) {
							operator.setIcon("noIcon");
						}
						operatorSets.add(operator);
					}
				}
			}
		}
		List<OperatorAddress> resultDomains = new ArrayList<>(operatorSets);
		baseModel.setResultDomains(resultDomains);
		baseModel.setMessage(SystemConfigMessage.OPERATION_SUCCESSFULLY);
		baseModel.setError(false);
		return baseModel;
	}

	@Override
	public BaseModel<Object> queryByTreeId(String treeId, String userId, String platfrome) {
		BaseModel<Object> baseModel = new BaseModel<>();
		//所有用户操作地址id集合
		List<String> userOperatorIds = new ArrayList<String>();
		//所有用户操作地址实体集合
		List<OperatorAddress> allOperators = new ArrayList<OperatorAddress>();
		List<String> functionIds = userGroupMemberDao.queryWgIdsByUserId(userId);
		functionIds.add(userId);
		for (String functionId : functionIds) {
			String permissionId = permissionDao.queryIdsByFunctionId(functionId);
			// 获取该用户的所有的操作地址
			List<String> operatorIds = operatorPermissionDao.queryOperaAdsIdsByPermId(permissionId);
			userOperatorIds.addAll(operatorIds);
		}
		Set<String> userOperators = new HashSet<>();
		userOperators.addAll(userOperatorIds);
		// 获取所有菜单实体
		for (String operatorId : userOperators) {
			OperatorAddress address = operatorAddressDao.queryById(operatorId);
			if (null != address) {
				allOperators.add(address);
			}
		}
		List<OperatorAddressTree> list = OperatorAddressTree.menuToTreeByTreeId(allOperators, treeId, platfrome);
		List<Object> result = getMenus(list);
		baseModel.setResultDomains(result);
		baseModel.setError(false);
		baseModel.setMessage(SystemConfigMessage.OPERATION_SUCCESSFULLY);
		return baseModel;
	}

	@Override
	public BaseModel<OperatorAddress> queryByPlatform(String platformId) {
		BaseModel<OperatorAddress> baseModel = new BaseModel<>();

		try {
			List<OperatorAddress> operatorAddresses = operatorAddressDao.queryAll();
			List<OperatorAddress> resultDomains = new ArrayList<OperatorAddress>();
			for (OperatorAddress operatorAddress : operatorAddresses) {
				if (operatorAddress.getPlatformId().equals(platformId) && operatorAddress.getType().compareTo(1) == 0) {
					resultDomains.add(operatorAddress);
				}
			}
			baseModel.setResultDomains(resultDomains);
			baseModel.setMessage(SystemConfigMessage.OPERATION_SUCCESSFULLY);
			baseModel.setError(false);
			return baseModel;
		} catch (Exception e) {
			baseModel.setError(true);
			baseModel.setException(e);
			baseModel.setMessage(SystemConfigMessage.OPERATION_FAILURE);
			return baseModel;
		}

	}

	@Override
	public BaseModel<OperatorAddressTree> queryEveAndGroupByPlatform(String platformId) {
		BaseModel<OperatorAddressTree> baseModel = new BaseModel<OperatorAddressTree>();
		try {
			List<OperatorAddress> resultDomains = operatorAddressDao.findByPlatform(platformId);
			List<OperatorAddressTree> list = OperatorAddressTree.menuToTree(resultDomains, "0");
			baseModel.setMessage(SystemConfigMessage.OPERATION_SUCCESSFULLY);
			baseModel.setError(false);
			baseModel.setResultDomains(list);
			return baseModel;
		} catch (Exception e) {
			e.printStackTrace();
			baseModel.setMessage(SystemConfigMessage.OPERATION_FAILURE);
			baseModel.setException(e);
			baseModel.setError(true);
			return baseModel;
		}
	}

	@Override
	public List<OperatorAddress> queryByParentId(String parentId, User user, String platformId) {

		List<OperatorAddress> result = new ArrayList<OperatorAddress>();
		// 根据父级id查询
		List<OperatorAddress> list = operatorAddressDao.queryByParentId(parentId);
		String userId = user.getId();
		// 根据用户id查询所属工作组id
		List<String> workingGroupIds = userGroupMemberDao.queryWgIdsByUserId(userId);
		// 加入用户id
		workingGroupIds.add(userId);
		// 根据工作组id获取permissionid
		Set<String> permissionIds = new HashSet<String>();
		for (String workingGroupId : workingGroupIds) {
			String quIdsByfId = permissionDao.queryIdsByFunctionId(workingGroupId);
			permissionIds.add(quIdsByfId);
		}
		// 根据权限id查询操作地址id
		Set<String> operaAddresss = new HashSet<String>();
		for (String permissionId : permissionIds) {
			List<String> oList = operatorPermissionDao.queryOperaAdsIdsByPermId(permissionId);
			if (oList != null) {
				operaAddresss.addAll(oList);
			}
		}
		// 获取属于该用户的和该用户所属平台的操作地址
		for (String operaAddress : operaAddresss) {
			OperatorAddress address = operatorAddressDao.queryById(operaAddress);
			for (OperatorAddress item : list) {
				if (address.getId().equals(item.getId()) && address.getPlatformId().equals(platformId)) {
					result.add(item);
				}
			}
		}
		return result;
	}

	@Override
	public boolean checkHasPermission(String userId, String platformid){
		// 判断是否存在是超级管理员权限
		boolean aSuper = userDao.queryIsSuper(userId);
		if(aSuper){
			return true;
		}else{
			// 查询用户权限
			List<String> functionIds = userGroupMemberDao.queryWgIdsByUserId(userId);
			functionIds.add(userId);
			// 功能菜单列表,未去重
			List<Map<String, Object>> operatorAddrList = new ArrayList<>();
			for (String functId : functionIds) {
				operatorAddrList.addAll(queryOperatorDetList(functId, platformid));
			}
			if(operatorAddrList.size() > 0){
				return true;
			}else{
				return false;
			}
		}
	};

	@Override
	public Map<String, Object> queryByUserTree(String sessionCacheId, String userId, String platfrome) {
		Map<String, Object> map = new HashMap<>();
		// 判断是否存在是超级管理员权限
		boolean aSuper = userDao.queryIsSuper(userId);
		List<Map<String, Object>> operList = new ArrayList<>();
		if(aSuper){
			// 查询所有的权限(根据平台Id查询)
			List<String> operatorIds = operatorAddressDao.queryInfoByPaltformId(platfrome);
			for (String operatorId : operatorIds) {
				Map<String, Object> operatorMap = operatorAddressDao.queryInfoById(operatorId);
				String parentId = (String) operatorMap.get("parentId");
				Integer type = (Integer) operatorMap.get("type");
				if ("0".equals(parentId) && type.compareTo(1) == 0) {
					if (operatorMap.size() > 0) {
						// 图标
						String icon = (String) operatorMap.get("icon");
						// 平台Id
						String paltformId = (String) operatorMap.get("platformId");
						if (paltformId.equals(platfrome) && type.compareTo(1) == 0) {
							// 伪装为前台需要的格式
							menuToListTree(operatorMap);
							if (StringUtils.isBlank(icon)) {
								operatorMap.put("icon", "noIcon");
							}
							operList.add(operatorMap);
						}
					}
				}
			}
		} else {
			// 查询用户权限
			List<String> functionIds = userGroupMemberDao.queryWgIdsByUserId(userId);
			functionIds.add(userId);
			// 功能菜单列表,未去重
			List<Map<String, Object>> operatorAddrList = new ArrayList<>();
			for (String functId : functionIds) {
				operatorAddrList.addAll(queryOperatorDetList(functId, platfrome));
			}
			// 根据已有的菜单权限向上查询父级并去重
			List<Map<String, Object>> operatorAddrFullList = this.queryFullOperatorAddrDetList(operatorAddrList);
			// 权限ID
			List<String> operatorAddrIds = new ArrayList<String>();
			// 从顶级开始向下遍历
			for (Map<String, Object> operatorAddr : operatorAddrFullList) {
				String operAddrId = String.valueOf(operatorAddr.get("operatorAddressId"));
				operatorAddrIds.add(operAddrId);
				// 判断顶级
				String parentId = String.valueOf(operatorAddr.get("parentId"));
				if("0".equals(parentId)) {
					Map<String, Object> operAddrTreeBranch = this.toOperatorAddressDetTree(operatorAddr, operatorAddrFullList);
					operList.add(operAddrTreeBranch);
				}
			}
			// 缓存菜单操作ID
			if(StringUtils.isNotBlank(sessionCacheId)){
                // 查询账户的session缓存
                SessionCache sessionCache = sessionCacheDao.findById(sessionCacheId);
                sessionCache.setOperatorAddressIds(operatorAddrIds);
                sessionCacheDao.updSessionCache(sessionCache);
            }
		}
		map.put("rows", operList);
		map.put("error", false);
		map.put("message", SystemConfigMessage.OPERATION_SUCCESSFULLY);
		return map;
	}

	/**
	 * 将包含顶级的操作菜单列表包装为树状结构[L]
	 * @param operatorAddr
	 * @param fullList
	 * @return
	 */
	private Map<String, Object> toOperatorAddressDetTree(Map<String, Object> operatorAddr, List<Map<String, Object>> fullList){
		// 获得ID
		String operatorAddressId = String.valueOf(operatorAddr.get("operatorAddressId"));
		// 获得子级
		List<Map<String, Object>> children = new ArrayList<>();
		fullList.stream().forEach(item -> {
			// 获得父级ID
			String parentId = String.valueOf(item.get("parentId"));
			// 获得菜单项类型
			String type = String.valueOf(item.get("type"));
			// 找到子级，同时要求类型为树
			if(operatorAddressId.equals(parentId) && "1".equals(type)) {
				// 迭代封装子级
				Map<String, Object> itemTree = toOperatorAddressDetTree(item, fullList);
				children.add(itemTree);
			}
		});
		if(children.size() > 0) {
			operatorAddr.put("children", children);
		}
		return operatorAddr;
	}

	/**
	 * 向上查询完整的父级菜单项[L]
	 * @param operatorAddrList
	 * @return
	 */
	private List<Map<String, Object>> queryFullOperatorAddrDetList(List<Map<String, Object>> operatorAddrList){
		List<Map<String, Object>> resultList = new ArrayList<>();
		List<Map<String, Object>> operatorAddrs = new ArrayList<>();
		operatorAddrList.stream().forEach(operatorAddr -> {
//			// 根据当前地址向上查询，得到完整的路径列表
//			operatorAddrs.addAll(this.queryFullOperatorAddrDetIterator(operatorAddr));

			// 获得地址ID
			String operatorAddressId = String.valueOf(operatorAddr.get("operatorAddressId"));
			// 采用ORACLE原生递归查询，提升查询效率
			operatorAddrs.addAll(operatorAddressDao.queryFullUpAddress(operatorAddressId));
		});
		// 对得到的结果进行去重
		operatorAddrs.stream().forEach(operAddrMap -> {
			// 获得记录ID
			String operAddrId = String.valueOf(operAddrMap.get("operatorAddressId"));
			// 匹配是否已经存在
			boolean isExist = resultList.stream().anyMatch(operAddrMapIn -> {
				String operAddrIdIn = String.valueOf(operAddrMapIn.get("operatorAddressId"));
				return operAddrId.equals(operAddrIdIn);
			});
			// 如果不存在，则添加
			if(!isExist && operAddrMap!=null && !operAddrMap.isEmpty()) {
				resultList.add(operAddrMap);
			}
		});
		return resultList;
	}

	/**
	 * 向上查询完整的父级菜单项Iterator[L]
	 * @param operatorAddr
	 * @return
	 */
	@SuppressWarnings("unused")
	private List<Map<String, Object>> queryFullOperatorAddrDetIterator(Map<String, Object> operatorAddr){
		List<Map<String, Object>> operatorAddrs = new ArrayList<>();
		operatorAddrs.add(operatorAddr);
		// 判断是否为顶级
		String parentId = String.valueOf(operatorAddr.get("parentId"));
		if(!"0".equals(parentId)) {
			Map<String, Object> operatorMap = operatorAddressDao.queryInfoById(parentId);
			operatorAddrs.addAll(this.queryFullOperatorAddrDetIterator(operatorMap));
		}
		return operatorAddrs;
	}

	/**
	 * 查询操作菜单[L]
	 * @param functionId
	 * @param platfrome
	 * @return
	 */
	private List<Map<String, Object>> queryOperatorDetList(String functionId, String platfrome){
		List<Map<String, Object>> operatorAddresses = new ArrayList<>();
		// Set<String> operatorIds = new HashSet<>();
		// 根据functionid查询对应的权限id
		String permissionId = permissionDao.queryInfoByFunctionId(functionId);
		if(StringUtils.isNotBlank(permissionId)) {
			List<Map<String, Object>> operatorAddrs = operatorAddressDao.queryInfoByCondition(permissionId, platfrome);
			operatorAddresses.addAll(operatorAddrs);
		}
		return operatorAddresses;
	}

	/**
	 * 递归查询
	 *
	 * @param operMap 集合数据
	 * @return
	 */
	public void menuToListTree(Map<String, Object> operMap) {
		String parentId = (String) operMap.get("operatorAddressId");
		Integer type = (Integer) operMap.get("type");
		List<Map<String, Object>> childrenList = operatorAddressDao.queryInfoByParentId(parentId);
		if (!childrenList.isEmpty() && type.compareTo(1) == 0) {
			for (Map<String, Object> childrenMap : childrenList) {
				Integer childType = (Integer) childrenMap.get("type");
				if (childType.compareTo(1) == 0) {
					operMap.put("children", childrenList);
					menuToListTree(childrenMap);
				}
			}
		}
	}

	@Override
	public Map<String, Object> queryAllOperator(String functionId, String platfrome, String status, String onlyself) {
		Map<String, Object> map = new HashMap<>();
		// 查询角色拥有的的操作权限列表
		List<String> operatorAddrIds = new ArrayList<>();
		if(StringUtils.isNotBlank(functionId)) {
			List<String> functionIds = new ArrayList<>();
			functionIds.add(functionId);
			// 查询当前用户拥有的所有权限
			if("0".equals(onlyself)) {
				// 检测是否是用户
				Map<String, Object> user = userDao.queryUserInfoById(functionId);
				if(user.isEmpty()) {
					map.put("error", true);
					map.put("message", "该用户角色不存在");
					return map;
				}
				// 查询该用户所属工作组
				List<String> userGroupMemberIds = userGroupMemberDao.queryWgIdsByUserId(functionId);
				functionIds.addAll(userGroupMemberIds);
			}
			// 遍历功能ID列表，查询功能ID对应的已有权限
			for (String funcId : functionIds) {
				List<String> operatorAddressIds = queryOperatorByFunc(funcId, platfrome);
				operatorAddrIds.addAll(operatorAddressIds);
			}
		}
		// 根据平台Id查询全部的员工权限
		List<Map<String, Object>> operatorAddresses = new ArrayList<>();
		List<String> operatorAddressIds = operatorAddressDao.queryInfoByPaltformId(platfrome);
		operatorAddressIds.stream().forEach(operatorAddressId -> {
			Map<String, Object> operatorMap = operatorAddressDao.queryNameInfoById(operatorAddressId);
			String parentId = (String) operatorMap.get("parentId");
			// 包含该权限
			if(operatorAddrIds.contains(String.valueOf(operatorMap.get("operatorAddressId")))) {
				operatorMap.put(status, true);
			}else {
				operatorMap.put(status, false);
			}
			if ("0".equals(parentId)) {
				// 伪装为前台需要的格式
				menuToListAllTree(operatorMap, operatorAddrIds, status);
				operatorAddresses.add(operatorMap);
			}
		});
		map.put("rowAll", operatorAddresses);
		map.put("error", false);
		map.put("message", SystemConfigMessage.OPERATION_SUCCESSFULLY);
		return map;
	}

	@Override
	public Map<String, Object> queryAllOperatorAndUserHave(String userId, String platfrome) {
		Map<String, Object> map = new HashMap<>();
		// 查询用户的权限工作组和自己的权限
		List<String> functionIds = userGroupMemberDao.queryWgIdsByUserId(userId);
		// 查询用户的树
		functionIds.add(userId);
		List<Map<String, Object>> result = new ArrayList<>();
		functionIds.stream().forEach(functionId -> {
			// 然后查询用户
			Map<String, Object> infoMap = userDao.queryInfoById(functionId);
			if (infoMap.isEmpty()) {
				// 首先查询科室
				infoMap = workingGroupDao.queryWorkGroupNameById(functionId);
				// 科室Id
				infoMap.put("id", infoMap.get("workGroupId"));
				// 科室名称
				infoMap.put("name", infoMap.get("workGroupName"));
			}
			infoMap.put("permissioIds", queryOperatorByFunc(functionId, platfrome));
			result.add(infoMap);
		});
		map.put("error", false);
		map.put("message", SystemConfigMessage.OPERATION_SUCCESSFULLY);
		map.put("rows", result);
		return map;
	}

	private List<String> queryOperatorByFunc(String functionId, String platfrome){
		List<String> operatorAddreIds = new ArrayList<>();
		Set<String> operatorIds = new HashSet<>();
		// 根据functionid查询对应的权限id
		String permissionId = permissionDao.queryInfoByFunctionId(functionId);
		if(StringUtils.isNotBlank(permissionId)) {
			List<OperatorPermission> operatorPermissions = operatorPermissionDao.queryByPermissionId(permissionId);
			for (OperatorPermission operatorPermission : operatorPermissions) {
				operatorIds.add(operatorPermission.getOperationAddress().getId());
			}
			// 判断这些权限是否属于一个平台
			for (String operatorId : operatorIds) {
				Map<String, Object> operatorMap = operatorAddressDao.queryInfoById(operatorId);
				String platformId = (String) operatorMap.get("platformId");
				if(platformId.equals(platfrome)){
					// 则为一个平台的Id
					operatorAddreIds.add(operatorId);
				}
			}
		}
		return operatorAddreIds;
	}

	public void menuToListAllTree(Map<String, Object> operMap, List<String> operatorAddrIds, String status) {
		String parentId = (String) operMap.get("operatorAddressId");
		List<Map<String, Object>> childrenList = operatorAddressDao.queryNameInfoByParentId(parentId);
		if(childrenList!=null && childrenList.size()>0) {
			operMap.put("children", childrenList);
			childrenList.stream().forEach(operatorAddress -> {
				// 包含该权限
				if(operatorAddrIds != null) {
					if(operatorAddrIds.contains(String.valueOf(operatorAddress.get("operatorAddressId")))) {
						operatorAddress.put(status, true);
					}else {
						operatorAddress.put(status, false);
					}
				}
				menuToListAllTree(operatorAddress, operatorAddrIds, status);
			});
		}
	}

	@Override
	public Map<String, Object> modifyOperator(String functionId, String plateformId, String[] operatorIds, Integer[] types) {
		Map<String, Object> map = new HashMap<>();
		// 获取对应的权限
		String permissionId = permissionDao.queryIdsByFunctionId(functionId);
		// 生成对应的关系表
		if(StringUtils.isBlank(permissionId)) {
			permissionId = UUIDUtil.getUUID();
			Permission permission = new Permission();
			permission.setId(permissionId);
			permission.setFunctionId(functionId);
			permissionDao.save(permission);
		}else {
			// 根据权限ID，平台ID查询对应表ID
			List<String> operPermissionIds = operatorPermissionDao.queryByPermissionAndPlateform(permissionId, plateformId);
			if(operPermissionIds!=null) {
				for (String operPermissionId : operPermissionIds) {
					// 删除
					operatorPermissionDao.delete(operPermissionId);
				}
			}
			
		}
		if(operatorIds != null) {
			for (int i = 0; i < operatorIds.length; i++) {
				OperatorPermission operatorPermission = new OperatorPermission();
				operatorPermission.setId(UUIDUtil.getUUID());
				operatorPermission.setOperationAddress(new OperatorAddress(operatorIds[i]));
				operatorPermission.setType(types[i]);
				operatorPermission.setPermissionId(permissionId);
				operatorPermissionDao.save(operatorPermission);
			}
		}
		map.put("error", false);
		map.put("message", SystemConfigMessage.OPERATION_SUCCESSFULLY);
		return map;
	}

	@Override
	public Map<String, Object> queryOperatorTreeByUrl(String sessionCacheId, String operatorAddrId, String userId, String platfromId) {
		Map<String, Object> map = new HashMap<>();
		// 权限树
		List<Map<String, Object>> maList = new ArrayList<>();
		// 根据Id查询对应的操作地址
		List<Map<String, Object>> infoList = operatorAddressDao.queryInfoByParentId(operatorAddrId);
		if(infoList.size()<1){
			// 兼容后台管理系统，详情请看该方法注解
			String menueId = operatorAddressDao.queryTreeIdByCondition(operatorAddrId, platfromId);
			infoList = operatorAddressDao.queryInfoByParentId(menueId);
		}
		// 查询角色是否为超级管理员
		boolean superExist = userDao.queryIsSuper(userId);
		// 超级管理员，无权限限制
		if(superExist){
			infoList.stream().forEach(treeMap -> {
				if (treeMap.size() > 0) {
					// 平台Id
					String paltformId = (String) treeMap.get("platformId");
					// 类型
					Integer type = (Integer) treeMap.get("type");
					if (paltformId.equals(platfromId) && type.compareTo(1) != 0) {
						// 遍历树下面的组件和事件
						this.menuToListTreeForUrl(treeMap);
						maList.add(treeMap);
					}
				}
			});
		}else {
		    // 账户权限下可操作的菜单地址ID
            List<String> operatorAddrIds = new ArrayList<>();
            // 不使用缓存数据
            if(StringUtils.isBlank(sessionCacheId)){
                // 查询用户所属科室得到功能ID列表
                List<String> functionIds = new ArrayList<>();
                // 判断角色是否为用户
                Map<String, Object> userInfo = userDao.queryInfoById(userId);
                if (!userInfo.isEmpty()) {
                    functionIds.addAll(userGroupMemberDao.queryWgIdsByUserId(userId));
                }
                functionIds.add(userId);
                // 查询所有的权限下的操作地址
                List<Map<String, Object>> operatorAddrList = new ArrayList<>();
                for (String functId : functionIds) {
                    operatorAddrList.addAll(queryOperatorList(functId, platfromId));
                }
                // 根据已有的菜单权限向上查询父级并去重
                List<Map<String, Object>> operatorAddrFullList = this.queryFullOperatorAddrList(operatorAddrList);
                // 权限ID
                operatorAddrFullList.stream().forEach(operatorAddress -> {
                    String operAddrId = String.valueOf(operatorAddress.get("operatorAddressId"));
                    operatorAddrIds.add(operAddrId);
                });
            }else {
                SessionCache sessionCache = sessionCacheDao.findById(sessionCacheId);
                operatorAddrIds.addAll(sessionCache.getOperatorAddressIds());
            }
            // 权限匹配
			infoList.stream().forEach(treeMap -> {
				if (treeMap.size() > 0) {
					// 权限ID
					String operaterAddrId = String.valueOf(treeMap.get("operatorAddressId"));
					// 平台Id
					String paltformId = (String) treeMap.get("platformId");
					// 类型
					Integer type = (Integer) treeMap.get("type");
					if (paltformId.equals(platfromId) && type.compareTo(1) != 0 && operatorAddrIds.contains(operaterAddrId)) {
						// 遍历树下面的组件和事件
						this.menuToListTreeDetForUrl(treeMap, operatorAddrIds);
						maList.add(treeMap);
					}
				}
			});
		}
		map.put("resultDomains", maList);
		map.put("message", SystemConfigMessage.OPERATION_SUCCESSFULLY);
		map.put("error", false);
		return map;
	}

	/**
	 * 根据提供的顶级菜单项，向下检索并以树状结构返回数据[L]
	 * @param operMap
	 */
	public void menuToListTreeDetForUrl(Map<String, Object> operMap, List<String> operatorAddrIds) {
		String parentId = (String) operMap.get("operatorAddressId");
		// 符合要求的子级列表
		List<Map<String, Object>> children = new ArrayList<>();
		// 查询该级的所有子级
		List<Map<String, Object>> childrenList = operatorAddressDao.queryInfoByParentId(parentId);
		if (!childrenList.isEmpty()) {
			for (Map<String, Object> childrenMap : childrenList) {
				// 权限ID
				String operaterAddrId = String.valueOf(childrenMap.get("operatorAddressId"));
				// 类型
				Integer childType = (Integer) childrenMap.get("type");
				if (childType.compareTo(1)!=0 && operatorAddrIds.contains(operaterAddrId)) {
					// 递归查询下级
					menuToListTreeDetForUrl(childrenMap, operatorAddrIds);
					children.add(childrenMap);
				}
			}
			operMap.put("children", children);
		}
	}

	public void menuToListTreeForUrl(Map<String, Object> operMap) {
		String parentId = (String) operMap.get("operatorAddressId");
		Integer type = (Integer) operMap.get("type");
		List<Map<String, Object>> childrenList = operatorAddressDao.queryInfoByParentId(parentId);
		if (!childrenList.isEmpty() && type.compareTo(1) != 0) {
			for (Map<String, Object> childrenMap : childrenList) {
				Integer childType = (Integer) childrenMap.get("type");
				if (childType.compareTo(1) != 0) {
					operMap.put("children", childrenList);
					menuToListTreeForUrl(childrenMap);
				}
			}
		}
	}

	@Override
	public Map<String, Object> confirmMenu(String userId, String platfrome, String eventId) {
		Map<String, Object> resultMap = new HashMap<>();
		boolean bl = false;
		List<String> functionIds = userGroupMemberDao.queryWgIdsByUserId(userId);
		functionIds.add(userId);
		out:
		for (String functionId : functionIds) {
			String permissionId = permissionDao.queryIdsByFunctionId(functionId);
			List<String> operatorIds = operatorPermissionDao.queryOperaAdsIdsByPermId(permissionId);
			if (operatorIds.stream().anyMatch(event -> eventId.equals(event))) {
				bl = true;
				break out;
			}
		}
		resultMap.put("confirm", bl);
		return resultMap;
	}

	@Override
	public Map<String, Object> queryWGOperatorAddr(String workGroupId, String platfrome) {
		Map<String, Object> map = new HashMap<>();
		List<String> operList = new ArrayList<>();
		// 获取对应的权限
		String permissionId = permissionDao.queryIdsByFunctionId(workGroupId);
		// 获取对应的操作地址Id
		List<String> operatorIds = operatorPermissionDao.queryOperaAdsIdsByPermId(permissionId);
		operatorIds.stream().forEach(operatorId -> {
			// 查询对应的地址信息
			Map<String, Object> operatorMap = operatorAddressDao.queryInfoById(operatorId);
			String paltformId = (String) operatorMap.get("platformId");
			if (operatorMap.size() > 0 && paltformId.equals(platfrome)) {
				operList.add(operatorId);
			}
		});
		map.put("rows", operList);
		map.put("error", false);
		map.put("message", SystemConfigMessage.OPERATION_SUCCESSFULLY);
		return map;
	}

	@Override
	public Map<String, Object> queryRoleOperatorAddress(String functionId, String plateformId, String haveOrigin) {
		Map<String, Object> base = new HashMap<>();
		// 查询用户所属科室得到功能ID列表
		List<String> functionIds = new ArrayList<>();
		// 判断角色是否为用户
		Map<String, Object> userInfo = userDao.queryInfoById(functionId);
		if(!userInfo.isEmpty()) {
			functionIds.addAll(userGroupMemberDao.queryWgIdsByUserId(functionId));
		}
		functionIds.add(functionId);
		// 查询所有的权限下的操作地址
		List<Map<String, Object>> operatorAddrList = new ArrayList<>();
		for (String functId : functionIds) {
			operatorAddrList.addAll(queryOperatorList(functId, plateformId));
		}
		// 根据已有的菜单权限向上查询父级并去重
		List<Map<String, Object>> operatorAddrFullList = this.queryFullOperatorAddrList(operatorAddrList);
		// 对得到的结果进行层级封装，得到层级树结构
		List<Map<String, Object>> operAddrTree = new ArrayList<>();
		// 从顶级开始向下遍历
		for (Map<String, Object> operatorAddr : operatorAddrFullList) {
			// 判断顶级
			String parentId = String.valueOf(operatorAddr.get("parentId"));
			if("0".equals(parentId)) {
				Map<String, Object> operAddrTreeBranch = this.toOperatorAddressTree(operatorAddr, operatorAddrFullList);
				operAddrTree.add(operAddrTreeBranch);
			}
		}
		// 查询权限来源
		if("1".equals(haveOrigin)) {
			List<Map<String, Object>> privateOperAddrList = new ArrayList<>();
			// 遍历处理科室
			for (String roleId : functionIds) {
				// 用户自己的权限
				Map<String, Object> role = userDao.queryInfoById(roleId);
				if(role.isEmpty()) {
					role.putAll(workingGroupDao.queryWorkGroupNameById(roleId));
				}
				// 查询地址列表
				List<Map<String, Object>> roleOperAddrs = this.queryOperatorList(roleId, plateformId);
				// 根据已有的菜单权限向上查询父级并去重
				List<Map<String, Object>> roleOperAddrFullList = this.queryFullOperatorAddrList(roleOperAddrs);
				// 对得到的结果进行层级封装，得到层级树结构
				List<Map<String, Object>> roleOperAddrTree = new ArrayList<>();
				// 从顶级开始向下遍历
				for (Map<String, Object> operatorAddr : roleOperAddrFullList) {
					// 判断顶级
					String parentId = String.valueOf(operatorAddr.get("parentId"));
					if("0".equals(parentId)) {
						Map<String, Object> operAddrTreeBranch = this.toOperatorAddressTree(operatorAddr, roleOperAddrFullList);
						roleOperAddrTree.add(operAddrTreeBranch);
					}
				}
				// 添加到用户的信息中
				if(roleOperAddrTree.size()>0) {
					role.put("operatorAddress", roleOperAddrTree);
					privateOperAddrList.add(role);
				}
			}
			base.put("rows", privateOperAddrList);
		}
		base.put("data", operAddrTree);
		base.put("error", false);
		base.put("message", SystemConfigMessage.OPERATION_SUCCESSFULLY);
		return base;
	}

	/**
	 * 将包含顶级的操作菜单列表包装为树状结构[L]
	 * @param operatorAddr
	 * @param fullList
	 * @return
	 */
	private Map<String, Object> toOperatorAddressTree(Map<String, Object> operatorAddr, List<Map<String, Object>> fullList){
		// 获得ID
		String operatorAddressId = String.valueOf(operatorAddr.get("operatorAddressId"));
		// 获得子级
		List<Map<String, Object>> children = new ArrayList<>();
		fullList.stream().forEach(item -> {
			// 获得父级ID
			String parentId = String.valueOf(item.get("parentId"));
			if(operatorAddressId.equals(parentId)) {
				// 迭代封装子级
				Map<String, Object> itemTree = toOperatorAddressTree(item, fullList);
				children.add(itemTree);
			}
		});
		if(children.size()>0) {
			operatorAddr.put("children", children);
		}
		return operatorAddr;
	}
	
	/**
	 * 向上查询完整的父级菜单项[L]
	 * @param operatorAddrList
	 * @return
	 */
	private List<Map<String, Object>> queryFullOperatorAddrList(List<Map<String, Object>> operatorAddrList){
		List<Map<String, Object>> resultList = new ArrayList<>();
		List<Map<String, Object>> operatorAddrs = new ArrayList<>();
		operatorAddrList.stream().forEach(operatorAddr -> {
			// 根据当前地址向上查询，得到完整的路径列表
			operatorAddrs.addAll(this.queryFullOperatorAddrIterator(operatorAddr));
		});
		// 对得到的结果进行去重
		operatorAddrs.stream().forEach(operAddrMap -> {
			// 获得记录ID
			String operAddrId = String.valueOf(operAddrMap.get("operatorAddressId"));
			// 匹配是否已经存在
			boolean isExist = resultList.stream().anyMatch(operAddrMapIn -> {
				String operAddrIdIn = String.valueOf(operAddrMapIn.get("operatorAddressId"));
				return operAddrId.equals(operAddrIdIn);
			});
			// 如果不存在，则添加
			if(!isExist) {
				resultList.add(operAddrMap);
			}
		});
		return resultList;
	}

	/**
	 * 向上查询完整的父级菜单项Iterator[L]
	 * @param operatorAddr
	 * @return
	 */
	private List<Map<String, Object>> queryFullOperatorAddrIterator(Map<String, Object> operatorAddr){
		List<Map<String, Object>> operatorAddrs = new ArrayList<>();
		operatorAddrs.add(operatorAddr);
		// 判断是否为顶级
		String parentId = String.valueOf(operatorAddr.get("parentId"));
		if(!"0".equals(parentId)) {
			Map<String, Object> operatorMap = operatorAddressDao.querySimpInfoById(parentId);
			operatorAddrs.addAll(this.queryFullOperatorAddrIterator(operatorMap));
		}
		return operatorAddrs;
	}
	
	/**
	 * 查询操作菜单[L]
	 * @param functionId
	 * @param platfrome
	 * @return
	 */
	private List<Map<String, Object>> queryOperatorList(String functionId, String platfrome){
		List<Map<String, Object>> operatorAddresses = new ArrayList<>();
		Set<String> operatorIds = new HashSet<>();
		// 根据functionid查询对应的权限id
		String permissionId = permissionDao.queryInfoByFunctionId(functionId);
		if(StringUtils.isNotBlank(permissionId)) {
			List<OperatorPermission> operatorPermissions = operatorPermissionDao.queryByPermissionId(permissionId);
			for (OperatorPermission operatorPermission : operatorPermissions) {
				operatorIds.add(operatorPermission.getOperationAddress().getId());
			}
			// 判断这些权限是否属于一个平台
			for (String operatorId : operatorIds) {
				Map<String, Object> operatorMap = operatorAddressDao.querySimpInfoById(operatorId);
				String platformId = (String) operatorMap.get("platformId");
				if(platformId.equals(platfrome)){
					operatorAddresses.add(operatorMap);
				}
			}
		}
		return operatorAddresses;
	}
}