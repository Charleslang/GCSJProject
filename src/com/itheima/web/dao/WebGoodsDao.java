package com.itheima.web.dao;

import com.itheima.web.entity.WebTbGoods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品管理dao层
 *
 * @author Lv Bo
 * @create 2020-06-05
 * @version 1.0
 **/
public interface WebGoodsDao {
    /**
     *该方法查询数据库中的所有商品信息
     * @return List<WebTbGoods> ，若查询失败则返回null
     */
    List<WebTbGoods> getAllGoods();

    /**
     *该方法添加一个商品信息
     * @param o 商品实体
     * @return int 添加成功返回1，有同名的商品添加失败返回0
     */
    int addGoods(Object o);

    /**
     *该方法根据商品id得到该商品信息
     * @param gId 商品id
     * @return WebTbGoods，若查询失败则返回null
     */
    WebTbGoods getGoods(String gId);
    /**
     *修改商品信息
     * @param o 商品实体类
     * @return int，更新成功返回1，有同名的商品更新失败返回1
     */
    int updateGoods(Object o);
    /**
     *根据商品id删除商品心胸
     * @param gId 商品id
     * @return int，删除成功返回1，失败返回0
     */
    int deleteGoods(Integer gId);
    /**
     *根据商品类型得到该类型的所有商品
     * @param g_type 商品类型
     * @return List<WebTbGoods>，查询成功返回该类型的所有商品信息，若查询失败则返回null
     */
    List<WebTbGoods> getTypeGoods(Integer g_type);
    /**
     *根据商品名字模糊查询所有的商品信息
     * @param g_name 商品名字
     * @return List<WebTbGoods>，查询成功返回该类型的所有商品信息，若查询失败则返回null
     */
    List<WebTbGoods> getNameGoods(String g_name);
    /**
     *根据添加的开始时间和结束时间得到该时间范围内的所有商品
     * @param start 开始时间
     * @param end 结束时间
     * @return List<WebTbGoods>，查询成功返回该类型的所有商品信息，若查询失败则返回null
     */
    List<WebTbGoods> getDateGoods(@Param("start")String start, @Param("end")String end);
    /**
     *根据添加的开始时间和结束时间和商品类型得到该时间范围内该类型的所有商品
     * @param start 开始时间
     * @param end 结束时间
     * @param g_type 商品类型
     * @return List<WebTbGoods>，查询成功返回该类型的所有商品信息，若查询失败则返回null
     */
    List<WebTbGoods> getDateTypeGoods(@Param("start")String start,@Param("end")String end,@Param("g_type")Integer g_type);
}
