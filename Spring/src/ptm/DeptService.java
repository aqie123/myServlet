package ptm;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Repository
public class DeptService implements Service{
    @Resource
    private Dao deptDao;

    @Transactional(
            readOnly=false,      // 读写的事务，当修改数据时候用；如果查询就设置为true
            isolation= Isolation.DEFAULT,  // 事务隔离级别
            timeout=-1,			// 事务执行的超时时间, -1 表示不超时
            // noRollbackFor=ArithmeticException.class,   // 遇到指定的异常不回滚
            propagation= Propagation.REQUIRED      // 事务传播行为
    )
    public void save() {
        deptDao.save();
        int i = 1/0;
        deptDao.save();
    }
}
