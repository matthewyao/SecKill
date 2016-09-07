package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.Seckill;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by matthewyao on 2016/9/4.
 */
public interface SeckillDao {

    /**
     * 减库存
     * @param seckillId
     * @param killTime
     * @return 如果影响行数 > 1，表示更新的记录行数
     */
    int reduceNumber(@Param("seckillId")long seckillId,@Param("killTime") Date killTime);

    /**
     * 根据秒杀ID查询秒杀对象
     * @param seckillId
     * @return
     */
    Seckill queryById(long seckillId);

    /**
     * 根据偏移量查询秒杀商品列表
     * Java由于会自动命名形参为arg0,arg1...argn，这样在参数绑定时Mybatis会报错
     * 所以需要使用Param注解
     * @param offset
     * @param limit
     * @return
     */
    List<Seckill> queryAll(@Param("offset") int offset, @Param("limit") int limit);
}
