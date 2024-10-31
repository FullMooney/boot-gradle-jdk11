package com.dev.log.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.log.domain.ResponseVO;
import com.dev.log.domain.SampleVO;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequestMapping("/api/aspects")
public class AspectTestController {
    
    @PostMapping("/test-header-aspect")
    public ResponseEntity<ResponseVO> testHeaderAspect(@RequestBody SampleVO vo) {
        
        //exception 발생
        vo.setHeader(null);

        vo.getHeader().setTxTime(System.currentTimeMillis());
        
        if(log.isDebugEnabled()){
            log.debug("{}", vo.getHeader().getTxTime());            
            }

        return ResponseEntity.ok(new ResponseVO());
    }
    

}
