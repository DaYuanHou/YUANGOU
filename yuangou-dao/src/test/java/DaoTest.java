
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yuangou.mapper.TbBrandMapper;
import com.yuangou.pojo.TbBrand;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * @类功能说明：
 * @类修改者：
 * @修改日期：
 * @修改说明：
 * @公司名称：北京睿智荟聚科技发展有限公司
 * @作者：PSY
 * @创建时间： 2018-08-15 15:01
 * @版本：V2.0
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext-dao.xml"})
public class DaoTest {
    @Resource
    private TbBrandMapper tBrandMapper;

//    @Test
//    @Transactional
//    public void dss() {
//        TbBrand t = new TbBrand();
//      t.setFirstChar("v");
//        t.setId(10l);
//        t.setName("V");
//
//        tBrandMapper.updateByPrimaryKey(t);
//
//    }

    @Test
    public void ss() {
        PageHelper.startPage(1, 10);
        Page<TbBrand> pages = (Page<TbBrand>) tBrandMapper.selectByExample(null);
        System.out.println(pages.getTotal());
        System.out.println(pages.getResult().get(0).getName());
    }
}
