package ${cfg.packageDao};

import ${package.Mapper}.${table.mapperName};
import org.springframework.stereotype.Repository;
import javax.annotation.Resource;

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

}


