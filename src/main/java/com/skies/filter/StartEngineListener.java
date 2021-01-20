package com.skies.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * 启动时执行
 */
@Component
@Slf4j
public class StartEngineListener implements CommandLineRunner {


    @Override
    public void run(String... strings) throws Exception {
        loadRticData();
    }

    /**
     * 初始化路段信息到内存
     */
    private void loadRticData() {
        log.info("数据初始化~ ");
        try {
        }catch (Exception e){
            log.error("初始化map异常！");
            e.printStackTrace();
        }
    }
}
