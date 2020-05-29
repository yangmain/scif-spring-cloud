package ${cfg.packageDao};

import ${package.Mapper}.${table.mapperName};
import ${package.Entity}.${entity};
import org.springframework.stereotype.Repository;
import javax.annotation.Resource;
import java.io.Serializable;

/**
 * <p>
 * ${table.comment!} Dao
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
@Repository
public class ${entity}Dao {

    @Resource
    private ${table.mapperName} ${table.entityPath}Mapper;

    /**
     * 根据主键查找方法
     *
     * @param id 主键
     * @return 结果记录
     */
    public ${entity} selectById(Serializable id) {
        return ${table.entityPath}Mapper.selectById(id);
    }

    /**
     * 根据主键更新方法
     *
     * @param entity 实体
     * @return 影响记录条数
     */
    public int updateById(${entity} entity) {
        return ${table.entityPath}Mapper.updateById(entity);
    }

    /**
     * 新增插入方法
     *
     * @param entity 实体
     * @return 影响记录条数
     */
    public int insert(${entity} entity) {
        return ${table.entityPath}Mapper.insert(entity);
    }


}


