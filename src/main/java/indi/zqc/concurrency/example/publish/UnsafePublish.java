package indi.zqc.concurrency.example.publish;

import indi.zqc.concurrency.annotation.NotRecommand;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
@NotRecommand
public class UnsafePublish {

    private String[] states = {"a", "b", "c"};

    public String[] getStates() {
        return states;
    }

    public static void main(String[] args) {
        UnsafePublish unsafePublish = new UnsafePublish();
        log.info("{}", Arrays.toString(unsafePublish.getStates()));

        // 不安全的发布，可以通过公共方法修改类状态
        unsafePublish.getStates()[0] = "d";
        log.info("{}", Arrays.toString(unsafePublish.getStates()));
    }
}
