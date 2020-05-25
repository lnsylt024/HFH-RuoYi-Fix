package com.ruoyi.framework.web.page;

import com.ruoyi.common.utils.StringUtils;

/**
 * 分页数据
 * 
 * @author ruoyi
 */
public class PageDomain
{
    /** 当前记录起始索引 */
    private Integer pageNum;
    /** 每页显示记录数 */
    private Integer pageSize;
    /** 排序列 */
    private String orderByColumn;
    /** 排序的方向 "desc" 或者 "asc". */
    private String isAsc;

    public String getOrderBy()
    {
        if (StringUtils.isEmpty(orderByColumn))
        {
            return "";
        }
        
        String[] orderByCols= orderByColumn.split(",");
        String[] isAscs= isAsc.split(",");
        
        String resultOrderBy ="";
        
        if(orderByCols.length == isAscs.length) {
        	if(orderByCols.length != 1) {        		
        		for(int i=0;i<orderByCols.length;i++) {
        			resultOrderBy = resultOrderBy+StringUtils.toUnderScoreCase(orderByCols[i]) + " " + isAscs[i]+",";
        		}
        		resultOrderBy = resultOrderBy.substring(0, resultOrderBy.length()-1);
        	}else {
        		resultOrderBy=StringUtils.toUnderScoreCase(orderByColumn) + " " + isAsc;
        	}
        }else {
        	if(orderByCols.length > isAscs.length) {
        		for(int i=0;i<orderByCols.length;i++) {
        			resultOrderBy = resultOrderBy+StringUtils.toUnderScoreCase(orderByCols[i]) + " " + isAscs[0]+",";
        		}
        		resultOrderBy = resultOrderBy.substring(0, resultOrderBy.length()-1);
        	}
        }
        
        return resultOrderBy;
    }

    public Integer getPageNum()
    {
        return pageNum;
    }

    public void setPageNum(Integer pageNum)
    {
        this.pageNum = pageNum;
    }

    public Integer getPageSize()
    {
        return pageSize;
    }

    public void setPageSize(Integer pageSize)
    {
        this.pageSize = pageSize;
    }

    public String getOrderByColumn()
    {
        return orderByColumn;
    }

    public void setOrderByColumn(String orderByColumn)
    {
        this.orderByColumn = orderByColumn;
    }

    public String getIsAsc()
    {
        return isAsc;
    }

    public void setIsAsc(String isAsc)
    {
        this.isAsc = isAsc;
    }
}
