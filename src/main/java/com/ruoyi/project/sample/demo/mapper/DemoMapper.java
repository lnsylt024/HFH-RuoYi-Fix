package com.ruoyi.project.sample.demo.mapper;

import java.util.List;

import com.ruoyi.project.sample.demo.domain.Demo;

/**
 * サンプルのデータ集
 * 
 * @author lnsylt
 *
 */
public interface DemoMapper {

	/**
	 * SQLより、一覧データ
	 * 
	 * @param demo
	 * @return
	 */
	public List<Demo> selectDemoList(Demo demo);
	
	/**
	 * IDより、サンプルデータ
	 * 
	 * @param demoId
	 * @return
	 */
	public Demo selectDemoById(Long demoId);
	
	/**
	 * 追加データ
	 * 
	 * @param demo
	 * @return
	 */
	public int insertDemo(Demo demo);
	
	/**
	 * 更新データ
	 * 
	 * @param demo
	 * @return
	 */
	public int updateDemo(Demo demo);
	
	/**
	 * IDより、削除データ（物理）
	 * 
	 * @param demoId
	 * @return
	 */
	public int deleteDemoById(Long demoId);
	
	/**
	 * ID集より、削除データ（ロジック）
	 * 
	 * @param demoIds
	 * @return
	 */
	public int deleteDemoByIds(Long[] demoIds);
}
