package com.yunduan.kanli.myblog.repository.es;

import com.yunduan.kanli.myblog.domain.es.EsBlog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

/**
 * EsBlog Repository 接口.
 */
public interface EsBlogRepository extends ElasticsearchCrudRepository<EsBlog,String> {
    /**
     * 分页查询博客(去重)
     * @param title
     * @param summary
     * @param content
     * @param pageable
     * @return
     */
    Page<EsBlog> findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining(String title, String summary, String content, Pageable pageable);
}
