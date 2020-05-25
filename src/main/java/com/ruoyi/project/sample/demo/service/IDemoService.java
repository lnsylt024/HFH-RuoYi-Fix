package com.ruoyi.project.sample.demo.service;

import java.util.List;

import com.ruoyi.project.common.service.IBaseService;
import com.ruoyi.project.sample.demo.domain.Demo;

/**
 * サンプルのインターフェーズ
 * 
 * @author lnsylt
 *
 */
public interface IDemoService extends IBaseService {

	/**
	 * サンプルデータ（ページ分）
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
	 * 新規データ
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
	 * 削除データ
	 * 
	 * @param ids
	 * @return
	 */
	public int deleteDemoById(String ids) throws Exception;
	
	/**
	 * 権限チェック
	 * 
	 * @param demo
	 */
    public void checkDemoAllowed(Demo demo);
}
