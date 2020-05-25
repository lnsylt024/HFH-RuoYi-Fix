package com.ruoyi.project.common.domain;

import com.ruoyi.framework.web.domain.BaseEntity;

public class Code extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String cd;

	private String cdKey;

	private String cdNM;

	private String delFlag;

	public String getCd() {
		return cd;
	}

	public void setCd(String cd) {
		this.cd = cd;
	}

	public String getCdKey() {
		return cdKey;
	}

	public void setCdKey(String cdKey) {
		this.cdKey = cdKey;
	}

	public String getCdNM() {
		return cdNM;
	}

	public void setCdNM(String cdNM) {
		this.cdNM = cdNM;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Code [cd=" + cd + ", cdKey=" + cdKey + ", cdNM=" + cdNM + ", delFlag=" + delFlag + "]";
	}

}
