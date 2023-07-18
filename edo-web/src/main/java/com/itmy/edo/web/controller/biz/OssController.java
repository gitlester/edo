package com.itmy.edo.web.controller.biz;

import com.amazonaws.services.s3.model.Bucket;
import com.itmy.edo.common.response.Result;
import com.itmy.edo.oss.core.OssTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: limeng
 * @date: 2023/7/18 22:47
 * @version: 1.0.0
 */
@RestController
@RequestMapping("/biz/oss")
public class OssController {

    @Resource
    private OssTemplate ossTemplate;

    @GetMapping("/lists")
    public Result<List<Bucket>> createBucket(){
        List<Bucket> allBuckets = ossTemplate.getAllBuckets();
        return Result.ok(allBuckets);
    }
}
