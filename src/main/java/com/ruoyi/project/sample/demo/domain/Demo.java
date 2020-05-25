package com.ruoyi.project.sample.demo.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.aspectj.lang.annotation.Excel.ColumnType;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * サンプルのEntity
 * 
 * @author lnsylt
 *
 */
public class Demo extends BaseEntity {

	private static final long serialVersionUID = 1L;

	public Demo() {
		// Empty
	}

	public Demo(Long demoId) {
		this.demoId = demoId;
	}

	/**
	 * ID
	 */
	@Excel(name = "ID", cellType = ColumnType.NUMERIC)
	private Long demoId;

	/**
	 * 名前
	 */
	@Excel(name = "名前")
	@NotBlank(message="名前が必須です")
	@Size(min=1,max=30,message="30バイト")
	private String demoName;

	/**
	 * 年齢
	 */
	@Excel(name = "年齢")
	@NotBlank(message="年齢が必須です")
	@Size(min=0,max=2,message="2バイト")
	private String demoAge;

	/**
	 * 学歴コード
	 */
	@NotBlank(message="20バイト")	
	private String demoEdu;

	/**
	 * 学歴名前
	 */
	@Excel(name = "学歴")
	private String demoEduNM;
	
	/**
	 * 順番
	 */
	@Excel(name = "順番")
	@NotBlank(message="順番は必須です。")
	private String demoSort;

	/**
	 * ステータス
	 */
	@Excel(name = "ステータス", readConverterExp = "0=利用中,1=停止")
	private String status;

	/**
	 * 削除フラグ（0：利用中、2：削除済）
	 */
	@Excel(name = "削除フラグ")
	private String delFlag;

	public Long getDemoId() {
		return demoId;
	}

	public void setDemoId(Long demoId) {
		this.demoId = demoId;
	}

	public String getDemoName() {
		return demoName;
	}

	public void setDemoName(String demoName) {
		this.demoName = demoName;
	}

	public String getDemoAge() {
		return demoAge;
	}

	public void setDemoAge(String demoAge) {
		this.demoAge = demoAge;
	}

	public String getDemoEdu() {
		return demoEdu;
	}

	public void setDemoEdu(String demoEdu) {
		this.demoEdu = demoEdu;
	}
	
	public String getDemoEduNM() {
		return demoEduNM;
	}

	public void setDemoEduNM(String demoEduNM) {
		this.demoEduNM = demoEduNM;
	}

	public String getDemoSort() {
		return demoSort;
	}

	public void setDemoSort(String demoSort) {
		this.demoSort = demoSort;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	
    public boolean isAdmin()
    {
        return isAdmin(this.demoId);
    }

    public static boolean isAdmin(Long demoId)
    {
        return demoId != null && 1L == demoId;
    }
	
	@Override
	public String toString() {
//		return "Demo [demoId=" + demoId + ", demoName=" + demoName + ", demoAge=" + demoAge + ", demoEdu=" + demoEdu
//				+ ", demoSort=" + demoSort + ", status=" + status + ", delFlag=" + delFlag + "]";

		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				// LocalEntity
				.append("demoId", getDemoId()).append("demoName", getDemoName()).append("demoAge", getDemoAge())
				.append("demoEdu", getDemoEdu()).append("demoSort", getDemoSort()).append("status", getStatus())
				.append("delFlag", getDelFlag())
				// BaseEntity
				.append("createBy", getCreateBy()).append("createTime", getCreateTime())
				.append("updateBy", getUpdateBy()).append("updateTime", getUpdateTime()).append("remark", getRemark())
				.toString();

	}

}
