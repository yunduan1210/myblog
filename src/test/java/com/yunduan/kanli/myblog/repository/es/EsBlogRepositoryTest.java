package com.yunduan.kanli.myblog.repository.es;


/**
 * EsBlog Repository 测试.
 */

import com.yunduan.kanli.myblog.domain.es.EsBlog;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class EsBlogRepositoryTest {

    @Autowired
    private EsBlogRepository esBlogRepository;
    @Before
    public void initRepositoryData(){
        // 清除所有数据
        esBlogRepository.deleteAll();
        esBlogRepository.save(new EsBlog("登鹳雀楼","唐代：王之涣","白日依山尽，黄河入海流。\n" +
                "欲穷千里目，更上一层楼。"));
        esBlogRepository.save(new EsBlog("行宫","唐代：元稹","寥落古行宫，宫花寂寞红。\n" +
                "白头宫女在，闲坐说玄宗。"));
        esBlogRepository.save(new EsBlog("八阵图","唐代：杜甫","功盖三分国，名成八阵图。\n" +
                "江流石不转，遗恨失吞吴。"));
        esBlogRepository.save(new EsBlog("江雪","唐代：柳宗元","千山鸟飞绝，万径人踪灭。\n" +
                "孤舟蓑笠翁，独钓寒江雪。"));
        esBlogRepository.save(new EsBlog("秋夜寄邱员外","唐代：韦应物","怀君属秋夜，散步咏凉天。\n" +
                "空山松子落，幽人应未眠。"));
    }

    @Test
    public void testFindDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining() {
        Pageable pageable = new PageRequest(0,20);
        String title = "宫";
        String summary="元";
        String content = "红";
        Page<EsBlog> page = esBlogRepository.findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining(title,summary,content,pageable);
        assertThat (page.getTotalElements()).isEqualTo(2);

        System.out.println("-------start 1");
        for(EsBlog blog : page.getContent()){
            System.out.println(blog.toString());
        }
        System.out.println("-------end 2");
    }
}

