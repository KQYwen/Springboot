package com.qf.service.impl;

import com.qf.dao.ArticleMapper;
import com.qf.dto.ArticleDTO;
import com.qf.dto.DataGridResult;
import com.qf.dto.QueryDTO;
import com.qf.pojo.Article;
import com.qf.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;


    @Override
    public int addArticle(ArticleDTO articleDTO) {
        return 0;
    }

    @Override
    public void delArt(Long id) {

    }

    @Override
    public int updateArticle(ArticleDTO articleDTO) {
        return 0;
    }

    @Override
    public Article findByID(Long id) {
        return null;
    }

    @Override
    public DataGridResult findByPage(QueryDTO queryDTO) {
        return null;
    }
}
