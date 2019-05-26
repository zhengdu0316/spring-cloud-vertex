package org.vertex.es.entity;


import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * base_户主表 base_householder_info
 * 
 * @author ruoyi
 * @date 2019-01-10
 */
@Data
public class HouseholderInfo
{
	private static final long serialVersionUID = 1L;
	
	/** ID */
	private String id;
	/** 姓名 */

	private String name;
	/** 身份证 */

	private String idCard;
	/** 电话 */

	private String phone;
	/** 家庭人数 */

	private Integer familySize;
	/** 经济条件 */

	private String economicCondition;
	/** 所属行政区 */

	private String areaCode;
	/** 数据状态 1：正常  2：禁用   3：删除 */
	private String detailAddr;
	private String hzid;
	private Integer dataStatus;
	/** 创建人ID */
	private String creator;
	/** 创建人姓名 */
	private String creatorName;
	/** 创建时间 */
	private Date created;
	/** 最后修改人ID */
	private String modifier;
	/** 最后修改人姓名 */
	private String modifierName;
	/** 最后修改时间 */
	private Date modified;
	/** 备注 */
	private String remark;
	/** 备用字段1 */
	private String ccol1;
	/** 备用字段2 */
	private String ccol2;
	/** 备用字段3 */
	private String ccol3;
	/** 备用字段4 */
	private BigDecimal dcol1;
	/** 备用字段5 */
	private BigDecimal dcol2;
	/** 备用字段6 */
	private Date datecol1;
	/** 数据类型 */
	private Integer typeData;

	/** 附加参数 房屋ID*/
	private String houseId;
}
