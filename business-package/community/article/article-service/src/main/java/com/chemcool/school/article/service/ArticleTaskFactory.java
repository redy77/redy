package com.chemcool.school.article.service;

import com.chemcool.school.article.domain.ArticlesTask;
import com.chemcool.school.article.domain.ArticlesTaskExample;
import com.chemcool.school.article.exception.ArticleTaskException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Factory articles
 *
 * @autor Иван Полещук
 */
@Slf4j
@Component
public class ArticleTaskFactory {
    public static ArticlesTask createArticlesTask(ArticlesTaskExample example) {
        if (example.getArticleTitle().isEmpty()) {
            throw new ArticleTaskException("Ошибка! Поле \"Глава\" пустое ");
        }
        if (example.getArticleBody().isEmpty()) {
            throw new ArticleTaskException("Ошибка! Поле \"Раздел\" пустое ");
        }
        log.info("Попытка создать урок.");
        return ArticlesTask.createArticlesTask(example);
    }

}
